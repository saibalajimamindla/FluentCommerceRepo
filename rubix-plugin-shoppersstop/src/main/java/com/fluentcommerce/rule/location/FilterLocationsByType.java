package com.fluentcommerce.rule.location;

import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.rule.order.SendEventOnIdentifyingDeliveryType;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventAttribute;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import com.fluentretail.rubix.v2.context.Context;
import com.fluentretail.rubix.v2.rule.Rule;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LOCATIONS;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_VIRTUAL_POSITIONS;
import static com.fluentcommerce.util.Constants.PropertyField.*;
import static com.fluentcommerce.util.Constants.PropertyField.Express_DELIVERY_TYPE;

@RuleInfo(
        name = "FilterLocationsByType",
        description =  "Forwards the event to  {" + PROP_EVENT_NAME + "}"+" after filtering the the"
        +" locations by the type specified {"+LOCATION_TYPE+"}",
        accepts = {
                @EventInfo(
                        entityType = ENTITY_TYPE_ORDER
                )
        }
)
@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule")
@ParamString(name = LOCATION_TYPE, description = "Location Type to be filtered")

@Slf4j
public class FilterLocationsByType implements Rule {

    private static final String CLASS_NAME = FilterLocationsByType.class.getSimpleName();

    @Override
    public <C extends Context> void run(C context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - incoming event :{}", context.getEvent());

        String eventName = context.getProp(PROP_EVENT_NAME);
        String ProposedLocationType = context.getProp(LOCATION_TYPE);

        Map<String, Location> locations = context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class);
        Map<String, Location> updatedLocations = new HashMap<>();
        // filtering locations for type
        for (Map.Entry<String, Location> entry : locations.entrySet()) {
            String LocationType = entry.getValue().getType();
            if(LocationType.equals(ProposedLocationType)){
                updatedLocations.put(entry.getKey(),entry.getValue());
            }
        }


        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_LOCATIONS, updatedLocations);
        EventUtils.forwardEventWithAttributes(context, eventName, attributes);
    }
}
