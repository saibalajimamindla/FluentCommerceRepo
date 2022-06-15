package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentOption;
import com.fluentcommerce.model.fulfilmentOption.Product;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.service.VirtualService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.fluentcommerce.util.CommonUtils.convertMapToDto;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_VIRTUAL_CATALOGUE_REF;

/**
 * @author Holger
 */
@RuleInfo(
    name = "SearchInventoryAtLocationsForFulfilmentTypeFO",
    description = "Searches inventory based on the incoming event information using virtual catalogue with ref {" +
        PROP_VIRTUAL_CATALOGUE_REF + "} for delivery types locations Sends event {" + PROP_EVENT_NAME + "}.",
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
@ParamString(name = PROP_VIRTUAL_CATALOGUE_REF, description = "The virtual catalogue which will be searched")
@EventAttribute(name = EVENT_FIELD_LOCATIONS)
@EventAttribute(name = SD_EVENT_FIELD_LOCATIONS)
@Slf4j
public class SearchInventoryAtLocationsForFulfilmentTypeFO extends BaseRule {

    private static final String CLASS_NAME = SearchInventoryAtLocationsForFulfilmentTypeFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);
        final String virtualCatalogueRef = context.getProp(PROP_VIRTUAL_CATALOGUE_REF);
        Map<String, Location> EDLocations = context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class);
        Map<String, Location> SDLocations = context.getEvent().getAttribute(SD_EVENT_FIELD_LOCATIONS, Map.class);

        Map<String, Location> SDLocationsFilterd =new HashMap<>();

        for (Map.Entry<String, Location> locationEntry : SDLocations.entrySet()) {
            if(locationEntry.getValue().getType().equalsIgnoreCase("WAREHOUSE"))
            {
                SDLocationsFilterd.put(locationEntry.getKey(),locationEntry.getValue());
            }

        }


        FulfilmentOption fulfilmentOption = convertMapToDto(context.getEvent().getAttributes(), FulfilmentOption.class);
        List<String> productRefs = new ArrayList<>();
        for (Product product : fulfilmentOption.getProducts()) {
            productRefs.add(product.getProductRef());
        }

        VirtualService virtualService = new VirtualService(context);
        List<VirtualPosition> EDVirtualPositions = virtualService.searchVirtualPositions(virtualCatalogueRef,
                EDLocations.keySet().stream().collect(Collectors.toList()),
            productRefs
        );
        List<VirtualPosition> SDVirtualPositions = virtualService.searchVirtualPositions(virtualCatalogueRef,
                SDLocations.keySet().stream().collect(Collectors.toList()),
                productRefs
        );
        List<VirtualPosition> SDVirtualPositionsFiltered = virtualService.searchVirtualPositions(virtualCatalogueRef,
                SDLocationsFilterd.keySet().stream().collect(Collectors.toList()),
                productRefs
        );

        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_VIRTUAL_POSITIONS, EDVirtualPositions);
        if (!SDVirtualPositions.isEmpty())
        {
            attributes.put(SD_EVENT_FIELD_VIRTUAL_POSITIONS, SDVirtualPositions);
        }else {
            attributes.put(SD_EVENT_FIELD_VIRTUAL_POSITIONS, SDVirtualPositionsFiltered);
        }


        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }
}
