package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentOption;
import com.fluentcommerce.model.fulfilmentOption.Product;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.service.VirtualService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.EventInfoVariables;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.fluentcommerce.util.CommonUtils.convertMapToDto;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_VIRTUAL_POSITIONS;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_VIRTUAL_CATALOGUE_REF;

/**
 * @author Holger
 */
@RuleInfo(
    name = "SearchInventoryForProductAvailabilityFO",
    description = "Searches inventory using virtual catalogue {" + PROP_VIRTUAL_CATALOGUE_REF + "} based on the incoming"
        + " event. Sends event {" + PROP_EVENT_NAME + "}.",
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
@Slf4j
public class SearchInventoryForProductAvailabilityFO extends BaseRule {

    private static final String CLASS_NAME = SearchInventoryForProductAvailabilityFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);
        final String virtualCatalogueRef = context.getProp(PROP_VIRTUAL_CATALOGUE_REF);
        FulfilmentOption fulfilmentOption = convertMapToDto(context.getEvent().getAttributes(), FulfilmentOption.class);
        List<String> productRefs = new ArrayList<>();
        for (Product product : fulfilmentOption.getProducts()) {
            productRefs.add(product.getProductRef());
        }

        VirtualService virtualService = new VirtualService(context);
        List<VirtualPosition> virtualPositions = virtualService.searchVirtualPositions(virtualCatalogueRef,
            Arrays.asList(virtualCatalogueRef),
            productRefs
        );

        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_VIRTUAL_POSITIONS, virtualPositions);
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }
}
