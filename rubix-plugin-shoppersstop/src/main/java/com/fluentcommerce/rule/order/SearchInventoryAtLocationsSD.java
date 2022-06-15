package com.fluentcommerce.rule.order;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.order.Order;
import com.fluentcommerce.model.order.OrderItem;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.service.OrderService;
import com.fluentcommerce.service.VirtualService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LOCATIONS;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_VIRTUAL_POSITIONS;
import static com.fluentcommerce.util.Constants.PropertyField.*;

@RuleInfo(
    name = "SearchInventoryAtLocationsSD",
    description = "Searches inventory based on the incoming event information using SD virtual catalogue with ref {" +
        PROP_VIRTUAL_CATALOGUE_REF + "}. Sends event to {" + PROP_EVENT_NAME_IF_VIRTUAL_POSITIONS_EXISTS + "} in case of virtualPositions found or else sends event to {"
        +PROP_EVENT_NAME_IF_VIRTUAL_POSITIONS_NOT_EXISTS+"}",
    accepts = {
        @EventInfo(entityType = ENTITY_TYPE_ORDER)
    }
)

@ParamString(name = PROP_EVENT_NAME_IF_VIRTUAL_POSITIONS_EXISTS, description = "The event name triggered by this rule if VirtualPositions found")
@ParamString(name = PROP_EVENT_NAME_IF_VIRTUAL_POSITIONS_NOT_EXISTS, description = "The event name triggered by this rule if VirtualPositions not found")
@ParamString(name = PROP_VIRTUAL_CATALOGUE_REF, description = "The virtual catalogue which will be searched")
@Slf4j
public class SearchInventoryAtLocationsSD extends BaseRule {

    private static final String CLASS_NAME = SearchInventoryAtLocationsSD.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String virtualPositionsExistsEventName = context.getProp(PROP_EVENT_NAME_IF_VIRTUAL_POSITIONS_EXISTS);
        final String virtualPositionsNotExistsEventName = context.getProp(PROP_EVENT_NAME_IF_VIRTUAL_POSITIONS_NOT_EXISTS);
        final String virtualCatalogueRef = context.getProp(PROP_VIRTUAL_CATALOGUE_REF);
        Map<String, Location> locations = context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class);

        OrderService orderService = new OrderService(context);
        Order order = orderService.getOrderByIdOrFail(context.getEvent().getEntityId());

        List<OrderItem> orderItems = order.getItems();
        List<String> productRefs = orderItems.stream()
                .map(OrderItem::getProductRef)
                .collect(Collectors.toList());

        VirtualService virtualService = new VirtualService(context);
        log.info(logPrefix + " - searching for inventory virtualCatalogueRef:{}, locationRefs:{}, productRefs:{}",
                virtualCatalogueRef, locations.keySet(), productRefs);

        List<VirtualPosition> virtualPositions;
        if(locations.size() == 0){
            virtualPositions = new ArrayList<>();
        } else {
            virtualPositions = virtualService.searchVirtualPositions(virtualCatalogueRef, new ArrayList<>(locations.keySet()), productRefs);
        }

        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_VIRTUAL_POSITIONS, virtualPositions);

        if (virtualPositions.size() == 0)
        {
            EventUtils.forwardEventWithAttributes(context, virtualPositionsNotExistsEventName, attributes);
        }else {
            EventUtils.forwardEventWithAttributes(context, virtualPositionsExistsEventName, attributes);
        }
    }
}