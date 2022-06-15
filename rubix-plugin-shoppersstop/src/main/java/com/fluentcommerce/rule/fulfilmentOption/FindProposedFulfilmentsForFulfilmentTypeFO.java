package com.fluentcommerce.rule.fulfilmentOption;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.dto.ProposedFulfilment;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static com.fluentcommerce.util.CommonUtils.convertObjectToDto;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.FulfilmentUtils.createProposedFulfilments;
import static com.fluentcommerce.util.FulfilmentUtils.getLocationRefVirtualPositionMap;

/**
 * @author Holger
 */
@RuleInfo(
    name = "FindProposedFulfilmentsForFulfilmentTypeFO",
    description = "Select proposed fulfilments based on the inventory found in the incoming event. "
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
@EventAttribute(name = SD_EVENT_FIELD_VIRTUAL_POSITIONS)
@EventAttribute(name = EVENT_FIELD_LOCATIONS)
@EventAttribute(name = SD_EVENT_FIELD_LOCATIONS)
@Slf4j
public class FindProposedFulfilmentsForFulfilmentTypeFO extends BaseRule {

    private static final String CLASS_NAME = FindProposedFulfilmentsForFulfilmentTypeFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);
        List<VirtualPosition> virtualPositions =
            context.getEvent().getAttributeList(EVENT_FIELD_VIRTUAL_POSITIONS, VirtualPosition.class);

        List<VirtualPosition> SdVirtualPositions =
                context.getEvent().getAttributeList(SD_EVENT_FIELD_VIRTUAL_POSITIONS, VirtualPosition.class);

        Map<String, Location> locationsMap = convertObjectToDto(
            context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class),
            new TypeReference<Map<String, Location>>(){}
        );

        Map<String, Location> SdLocationsMap = convertObjectToDto(
                context.getEvent().getAttribute(SD_EVENT_FIELD_LOCATIONS, Map.class),
                new TypeReference<Map<String, Location>>(){}
        );


        final Map<String, Map<String, VirtualPosition>> locationRefProductRefVirtualPositionMap =
            getLocationRefVirtualPositionMap(virtualPositions, locationsMap);

        final Map<String, Map<String, VirtualPosition>> SdLocationRefProductRefVirtualPositionMap =
                getLocationRefVirtualPositionMap(SdVirtualPositions, SdLocationsMap);

        final Map<String, ProposedFulfilment> proposedFulfilments = createProposedFulfilments(
            context,
            locationRefProductRefVirtualPositionMap,
            locationsMap
        );

        final Map<String, ProposedFulfilment> SdProposedFulfilments = createProposedFulfilments(
                context,
                SdLocationRefProductRefVirtualPositionMap,
                SdLocationsMap
        );

        log.info("{} - identified:{} proposed fulfilments", logPrefix, proposedFulfilments.size());
        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_PROPOSED_FULFILMENTS, proposedFulfilments);
        attributes.put(SD_EVENT_FIELD_PROPOSED_FULFILMENTS, SdProposedFulfilments);
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }
}
