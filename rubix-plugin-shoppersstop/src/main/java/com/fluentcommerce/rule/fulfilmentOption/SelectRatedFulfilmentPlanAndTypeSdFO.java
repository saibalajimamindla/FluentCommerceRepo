package com.fluentcommerce.rule.fulfilmentOption;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetNetworksByLocationIdQuery;
import com.fluentcommerce.dto.FulfilmentRating;
import com.fluentcommerce.dto.ProposedFulfilment;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlan;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlanFulfilment;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlanFulfilmentItem;
import com.fluentcommerce.model.fulfilmentOption.Product;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.service.LocationService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.MapUtils;

import java.util.*;

import static com.fluentcommerce.util.CommonUtils.convertObjectToDto;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.Constants.Status.*;
import static com.fluentcommerce.util.FulfilmentUtils.getRatedProposedFulfilments;
import static com.fluentcommerce.util.LocationUtils.getNearestLocationDistance;

/**
 * @author Holger
 */
@RuleInfo(
        name = "SelectRatedFulfilmentPlanAndTypeSdFO",
        description = "Select a fulfilment plan based on the inventory found in the incoming event. "
                + "Sends event {" + PROP_EVENT_NAME + "}.",
        accepts = {
                @EventInfo(entityType = ENTITY_TYPE_FULFILMENT_OPTIONS)
        },
        produces = {
                @EventInfo(
                        eventName = "{" + PROP_EVENT_NAME + "}",
                        entityType = EventInfoVariables.EVENT_TYPE,
                        entitySubtype = EventInfoVariables.EVENT_SUBTYPE,
                        status = EventInfoVariables.EVENT_STATUS)
        }
)

@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule")
@EventAttribute(name = SD_EVENT_FIELD_PROPOSED_FULFILMENTS)
@EventAttribute(name = SD_EVENT_FIELD_LOCATIONS)
@EventAttribute(name = EVENT_FIELD_PRODUCTS)
@Slf4j
public class SelectRatedFulfilmentPlanAndTypeSdFO extends BaseRule {

    private static final String CLASS_NAME = SelectRatedFulfilmentPlanAndTypeSdFO.class.getSimpleName();
    private static Boolean ED_flag = false;
    private static Boolean SD_flag = false;

    private  String fulfilmentType = null;

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);

        Map<String, ProposedFulfilment> proposedFulfilments = convertObjectToDto(
                context.getEvent().getAttribute(SD_EVENT_FIELD_PROPOSED_FULFILMENTS, Map.class),
                new TypeReference<Map<String, ProposedFulfilment>>() {}
        );
        Map<String, Location> locationsMap = convertObjectToDto(
                context.getEvent().getAttribute(SD_EVENT_FIELD_LOCATIONS, Map.class),
                new TypeReference<Map<String, Location>>() {
                }
        );

        List<Product> products =
                context.getEvent().getAttributeList(EVENT_FIELD_PRODUCTS, Product.class);

//        Map<String, Product> productsEventMap = convertObjectToDto(
//                context.getEvent().getAttribute(EVENT_FIELD_PRODUCTS, Map.class),
//                new TypeReference<Map<String, Product>>() {
//                }
//        );

        //START: Should be moved into rule: RateProposedFulfilments
        Map<String, Integer> productsMap = new HashMap<>();
        for (Product product : products) {
            productsMap.put(product.getProductRef(), product.getRequestedQuantity());
        }
        final Double nearestLocationDistance = getNearestLocationDistance(locationsMap.values());
        final Map<FulfilmentRating, ProposedFulfilment> ratedProposedFulfilmentsMap = getRatedProposedFulfilments(
                context,
                proposedFulfilments,
                productsMap,
                locationsMap,
                nearestLocationDistance
        );
        //END

        Map<String, Product> remainingProducts = new HashMap<>();
        for(Product product : products){
            remainingProducts.put(product.getProductRef(), product);
        }

        List<FulfilmentPlanFulfilment> fulfilmentPlanFulfilmentList = new ArrayList<>();

        for (ProposedFulfilment ratedProposedFulfilment : ratedProposedFulfilmentsMap.values()) {
            List<FulfilmentPlanFulfilmentItem> fulfilmentPlanFulfilmentItemList = new ArrayList<>();
            List<VirtualPosition> virtualPositions = ratedProposedFulfilment.getVirtualPositions();
            for (VirtualPosition virtualPosition : virtualPositions) {
                String productRef = virtualPosition.getProductRef();
                int availableQty = virtualPosition.getQuantity();
                Product product = remainingProducts.get(productRef);
                if (product == null || availableQty == 0) {
                    continue;
                }
                FulfilmentPlanFulfilmentItem.Builder fulfilmentPlanFulfilmentItem = FulfilmentPlanFulfilmentItem.builder()
                        .availableQuantity(availableQty)
                        .requestedQuantity(productsMap.get(product.getProductRef()))
                        .productRef(product.getProductRef());
                if (availableQty >= product.getRequestedQuantity()) {
                    remainingProducts.remove(productRef);
                    fulfilmentPlanFulfilmentItemList.add(fulfilmentPlanFulfilmentItem.build());
                } else if (availableQty > 0 && availableQty < product.getRequestedQuantity()) {
                    Product currentProduct = remainingProducts.get(productRef);
                    int newRequestedQuantity = currentProduct.getRequestedQuantity() - virtualPosition.getQuantity();
                    remainingProducts.put(
                            productRef,
                            currentProduct.toBuilder().requestedQuantity(newRequestedQuantity).build()
                    );
                    fulfilmentPlanFulfilmentItemList.add(fulfilmentPlanFulfilmentItem.build());
                }
            }
            String locationref = ratedProposedFulfilment.getLocationRef();
            LocationService locationService = new LocationService(context);
            GetLocationByRefQuery.Location location = locationService.getLocationByRefOrFail(locationref);
            GetNetworksByLocationIdQuery query = GetNetworksByLocationIdQuery.builder().id(location.id()).build();
            GetNetworksByLocationIdQuery.Data Result = (GetNetworksByLocationIdQuery.Data) context.api().query(query);
            if (Result.locationById().networks()!= null && Result.locationById().networks().edges()!=null )
            {
                for (GetNetworksByLocationIdQuery.Edge edge :Result.locationById().networks().edges()) {
                    if(edge.node().ref()!=null) {
                        if (edge.node().ref().contains("_ED"))
                        {
                            ED_flag = true;
                        }else if (edge.node().ref().contains("_SD")) {
                            SD_flag=true;
                        }
                    }

                }

                if (ED_flag && SD_flag)
                {
                    fulfilmentType="BOTH";
                }else if(ED_flag)
                {
                    fulfilmentType="ED";
                }else {
                    fulfilmentType="SD";
                }
                ED_flag = false;
                SD_flag = false;

            }

            if (fulfilmentPlanFulfilmentItemList.size() > 0) {
                FulfilmentPlanFulfilment fulfilmentPlanFulfilment = FulfilmentPlanFulfilment.builder()
                        .locationRef(ratedProposedFulfilment.getLocationRef())
                        .items(fulfilmentPlanFulfilmentItemList)
                        .distance(ratedProposedFulfilment.getDistance())
                        .fulfilmentType(fulfilmentType)
                        .build();
                fulfilmentPlanFulfilmentList.add(fulfilmentPlanFulfilment);
            }
            if (MapUtils.isEmpty(remainingProducts)){
                break;
            }
        }

        //consider to move into a separate rule
        FulfilmentPlan.Builder fulfilmentPlanBuilder = FulfilmentPlan.builder()
                .fulfilments(fulfilmentPlanFulfilmentList);
        if (MapUtils.isEmpty(remainingProducts)) {
            fulfilmentPlanBuilder.status(STATUS_FULFILLED);
        } else if (fulfilmentPlanFulfilmentList.size() > 0) {
            fulfilmentPlanBuilder.status(STATUS_PARTIALLY_FULFILLED);
        } else {
            fulfilmentPlanBuilder.status(STATUS_REJECTED);
        }
        List<FulfilmentPlan> fulfilmentPlanList = Arrays.asList(fulfilmentPlanBuilder.build());

        Map<String, Object> attributes = context.getEvent().getAttributes();
        List<FulfilmentPlan> existingFulfilmentPlans = context.getEvent().getAttribute(EVENT_FIELD_FULFILMENT_PLANS, List.class);
        if(existingFulfilmentPlans != null && existingFulfilmentPlans.size() > 0) {
            fulfilmentPlanList = ListUtils.union(existingFulfilmentPlans, fulfilmentPlanList);
        }
        attributes.put(SD_EVENT_FIELD_FULFILMENT_PLANS, fulfilmentPlanList);
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }
}
