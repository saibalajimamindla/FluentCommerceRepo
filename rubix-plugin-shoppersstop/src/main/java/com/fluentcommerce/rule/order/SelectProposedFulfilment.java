package com.fluentcommerce.rule.order;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.dto.FulfilmentRating;
import com.fluentcommerce.dto.ProposedFulfilment;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.order.Order;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.service.OrderService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

import static com.fluentcommerce.util.CommonUtils.convertObjectToDto;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EXCLUDED_FULFILMENT_STATUSES;
import static com.fluentcommerce.util.FulfilmentUtils.*;
import static com.fluentcommerce.util.LocationUtils.getNearestLocationDistance;
import static java.util.stream.Collectors.toList;

@RuleInfo(
    name = "SelectProposedFulfilment",
    description = "Select a proposed fulfilments based on the inventory found in the incoming event excluding "
        + "fulfilments in statuses {" + PROP_EXCLUDED_FULFILMENT_STATUSES + "}. "
        + "Sends event {" + PROP_EVENT_NAME + "}.",
    accepts = {
        @EventInfo(entityType = ENTITY_TYPE_ORDER)
    }
)

@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule.")
@ParamString(name = PROP_EXCLUDED_FULFILMENT_STATUSES, description = "The list of excluded fulfilment statuses.")

@Slf4j
public class SelectProposedFulfilment extends BaseRule {

    private static final String CLASS_NAME = SelectProposedFulfilment.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);

        List<VirtualPosition> virtualPositions =
            context.getEvent().getAttributeList(EVENT_FIELD_VIRTUAL_POSITIONS, VirtualPosition.class);
        Map<String, Object> locationsMap = context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class);
        final List<String> excludedFulfilmentStatuses =
            context.getPropList(PROP_EXCLUDED_FULFILMENT_STATUSES, String.class) != null ?
                context.getPropList(PROP_EXCLUDED_FULFILMENT_STATUSES, String.class).stream()
                    .filter(StringUtils::isNotBlank).collect(toList()) : null;

        if (MapUtils.isEmpty(locationsMap) || CollectionUtils.isEmpty(virtualPositions)) {
            log.info("{} - no locations or virtual positions found for order id:{}", logPrefix, context.getEvent().getEntityId());
        } else {
            log.info("{} - locations map is:{}", logPrefix, locationsMap);
        }

        OrderService orderService = new OrderService(context);
        Order order = orderService.getOrderByIdWithItemsAndFulfilments(context.getEvent().getEntityId());

        //todo replace with object mapper
        List<Location> locations = new ArrayList<>();
        for (Map.Entry<String, Object> locationEntry : locationsMap.entrySet()) {
            Location location = convertObjectToDto(locationEntry.getValue(), Location.class);
            locations.add(location);
        }

        List<String> excludedLocationRefs = getExcludedLocationRefs(context, order);
        final Map<String, Location> includedLocationsByLocationRef =
            getIncludedLocationsGroupedByLocationRef(context, locations, excludedLocationRefs);
        final Map<String, Map<String, VirtualPosition>> locationRefProductRefVirtualPositionMap =
            getLocationRefVirtualPositionMap(virtualPositions, includedLocationsByLocationRef);

        final Double nearestLocationDistance = getNearestLocationDistance(locations);
        final Map<String, Integer> unfulfilledItems =
            orderService.getUnfulfilledItems(order, excludedFulfilmentStatuses);
        if (MapUtils.isEmpty(unfulfilledItems)) {
            log.info("{} - No unfulfilled items found", logPrefix);
            return;
        }

        final Map<String, ProposedFulfilment> proposedFulfilments = createProposedFulfilments(
            context,
            locationRefProductRefVirtualPositionMap,
            includedLocationsByLocationRef
        );
        final NavigableMap<FulfilmentRating, ProposedFulfilment> ratedFulfilments = getRatedProposedFulfilments(
            context,
            proposedFulfilments,
            unfulfilledItems,
            includedLocationsByLocationRef,
            nearestLocationDistance
        );
        log.info("{} - identified:{} proposed fulfilments", logPrefix, proposedFulfilments.size());

        Map<String, Object> attributes = context.getEvent().getAttributes();
        if (MapUtils.isNotEmpty(ratedFulfilments)) {
            attributes.put(EVENT_FIELD_PROPOSED_FULFILMENT, ratedFulfilments.firstEntry().getValue());
        }
        EventUtils.forwardEventWithAttributes(context, eventName, attributes);
    }
}
