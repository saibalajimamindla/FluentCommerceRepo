package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlan;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlanFulfilment;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlanFulfilmentItem;
import com.fluentcommerce.model.fulfilmentOption.Product;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;

/**
 * @author Holger
 */
@RuleInfo(
    name = "SelectProductAvailabilityFulfilmentPlanFO",
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
@EventAttribute(name = EVENT_FIELD_VIRTUAL_POSITIONS)
@EventAttribute(name = EVENT_FIELD_PRODUCTS)
@Slf4j
public class SelectProductAvailabilityFulfilmentPlanFO extends BaseRule {

    private static final String CLASS_NAME = SelectProductAvailabilityFulfilmentPlanFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);
        List<VirtualPosition> virtualPositions =
            context.getEvent().getAttributeList(EVENT_FIELD_VIRTUAL_POSITIONS, VirtualPosition.class);
        List<Product> products =
            context.getEvent().getAttributeList(EVENT_FIELD_PRODUCTS, Product.class);

        Map<String, FulfilmentPlanFulfilment> fulfilmentPlanFulfilmentMap = new HashMap<>();
        for (VirtualPosition virtualPosition : virtualPositions) {
            String groupRef = virtualPosition.getGroupRef();
            FulfilmentPlanFulfilment fulfilmentPlan;
            if (fulfilmentPlanFulfilmentMap.get(groupRef) == null) {
                fulfilmentPlan = FulfilmentPlanFulfilment.builder().locationRef(groupRef).build();
            } else {
                fulfilmentPlan = fulfilmentPlanFulfilmentMap.get(groupRef);
            }

            List<FulfilmentPlanFulfilmentItem> planFulfilmentPlanFulfilmentItems;
            if (fulfilmentPlan.getItems() == null) {
                planFulfilmentPlanFulfilmentItems = new ArrayList<>();
            } else {
                planFulfilmentPlanFulfilmentItems = fulfilmentPlan.getItems();
            }
            for (Product product : products) {
                if (StringUtils.equals(product.getProductRef(), virtualPosition.getProductRef())) {
                    FulfilmentPlanFulfilmentItem item = FulfilmentPlanFulfilmentItem.builder()
                        .availableQuantity(virtualPosition.getQuantity())
                        .requestedQuantity(product.getRequestedQuantity())
                        .productRef(product.getProductRef())
                        .build();
                    planFulfilmentPlanFulfilmentItems.add(item);
                    log.info("{} - adding fulfilment item:{} for locationRef:{}", logPrefix, item, groupRef);
                }
            }
            fulfilmentPlan = fulfilmentPlan.toBuilder().items(planFulfilmentPlanFulfilmentItems).build();
            fulfilmentPlanFulfilmentMap.put(groupRef, fulfilmentPlan);
        }
        FulfilmentPlan fulfilmentPlan = FulfilmentPlan.builder()
            .fulfilments(fulfilmentPlanFulfilmentMap.values().stream().collect(Collectors.toList())).build();

        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_FULFILMENT_PLANS, Arrays.asList(fulfilmentPlan));
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }
}
