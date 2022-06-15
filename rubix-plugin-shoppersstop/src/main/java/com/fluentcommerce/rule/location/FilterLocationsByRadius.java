package com.fluentcommerce.rule.location;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.attribute.Attribute;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventAttribute;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fluentcommerce.util.CommonUtils.convertObjectToDto;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_ATTRIBUTES;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LOCATIONS;
import static com.fluentcommerce.util.Constants.METER_TO_KILOMETER_FACTOR;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.Constants.RADIUS;

@RuleInfo(
    name = "FilterLocationsByRadius",
    description = "Filters locations which are outside of the radius provided in the event attribute. "
        + "Sends event {" + PROP_EVENT_NAME + "}.",
    accepts = {
        @EventInfo(entityType = ENTITY_TYPE_ORDER),
        @EventInfo(entityType = ENTITY_TYPE_FULFILMENT_OPTIONS)
    }
)
@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule")
@EventAttribute(name = EVENT_FIELD_LOCATIONS)
@EventAttribute(name = EVENT_FIELD_ATTRIBUTES)
@Slf4j
public class FilterLocationsByRadius extends BaseRule {

    private static final String CLASS_NAME = FilterLocationsByRadius.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);
        Map<String, Object> locationsMap = context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class);

        List<Attribute> fulfilmentOptionAttributes = convertObjectToDto(
            context.getEvent().getAttribute(EVENT_FIELD_ATTRIBUTES, List.class),
            new TypeReference<List<Attribute>>() {}
        );

        Double radius = null;
        if (fulfilmentOptionAttributes != null) {
            for (Attribute fulfilmentOptionAttribute : fulfilmentOptionAttributes) {
                if (StringUtils.equals(fulfilmentOptionAttribute.getName(), RADIUS)) {
                    radius = (Double) fulfilmentOptionAttribute.getValue() * METER_TO_KILOMETER_FACTOR;
                }
            }
        }
        if (radius != null) {
            Map<String, Location> updatedLocations = new HashMap<>();
            for (Map.Entry<String, Object> locationEntry : locationsMap.entrySet()) {
                Location location = convertObjectToDto(locationEntry.getValue(), Location.class);
                if (Double.compare(location.getDistance(), radius) <= 0) {
                    updatedLocations.put(location.getRef(), location);
                }
            }
            Map<String, Object> attributes = context.getEvent().getAttributes();
            attributes.put(EVENT_FIELD_LOCATIONS, updatedLocations);
            //hard-coded to an inline event until the Rubix bug is fixed
            EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
        } else {
            EventUtils.forwardInlineEvent(context, eventName);
        }
    }
}
