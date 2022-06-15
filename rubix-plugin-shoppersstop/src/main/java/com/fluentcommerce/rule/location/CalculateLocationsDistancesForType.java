package com.fluentcommerce.rule.location;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.api.model.location.Coordinates;
import com.fluentretail.rubix.rule.meta.EventAttribute;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.fluentcommerce.util.CommonUtils.convertObjectToDto;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.LocationUtils.findDistance;

@RuleInfo(
    name = "CalculateLocationsDistancesForType",
    description = "Calculates the distances of each location compared to the longitude/latitude in the request. "
        + "Sends event {" + PROP_EVENT_NAME + "}.",
    accepts = {
        @EventInfo(entityType = ENTITY_TYPE_ORDER),
        @EventInfo(entityType = ENTITY_TYPE_FULFILMENT_OPTIONS)
    }
)
@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule")
@EventAttribute(name = EVENT_FIELD_LOCATIONS)
@EventAttribute(name = SD_EVENT_FIELD_LOCATIONS)
@EventAttribute(name = EVENT_FIELD_LONGITUDE)
@EventAttribute(name = EVENT_FIELD_LATITUDE)
@Slf4j
public class CalculateLocationsDistancesForType extends BaseRule {

    private static final String CLASS_NAME = CalculateLocationsDistancesForType.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);
        Map<String, Object> locationsMap = context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class);
        Map<String, Object> sdLocationsMap = context.getEvent().getAttribute(SD_EVENT_FIELD_LOCATIONS, Map.class);
        Double longitude = context.getEvent().getAttribute(EVENT_FIELD_LONGITUDE, Double.class);
        Double latitude = context.getEvent().getAttribute(EVENT_FIELD_LATITUDE, Double.class);

        Coordinates requestCoordinates = Coordinates.builder()
            .longitude(longitude)
            .latitude(latitude)
            .build();

        Map<String, Location> updatedLocations = new HashMap<>();
        Map<String, Location> sdUpdatedLocations = new HashMap<>();
        for (Map.Entry<String, Object> locationEntry : locationsMap.entrySet()) {
            Location location = convertObjectToDto(locationEntry.getValue(), Location.class);
            if (location.getLongitude() == null || location.getLatitude() == null) {
                log.info("{} - coordinates for location:{} is null - ignoring", logPrefix, location);
                continue;
            }
            Double distance = findDistance(
                requestCoordinates,
                Coordinates.builder().longitude(location.getLongitude()).latitude(location.getLatitude())
                    .build()
            );
            updatedLocations.put(location.getRef(), location.toBuilder().distance(distance).build() );
        }

        for (Map.Entry<String, Object> locationEntry : sdLocationsMap.entrySet()) {
            Location location = convertObjectToDto(locationEntry.getValue(), Location.class);
            if (location.getLongitude() == null || location.getLatitude() == null) {
                log.info("{} - coordinates for location:{} is null - ignoring", logPrefix, location);
                continue;
            }
            Double distance = findDistance(
                    requestCoordinates,
                    Coordinates.builder().longitude(location.getLongitude()).latitude(location.getLatitude())
                            .build()
            );
            sdUpdatedLocations.put(location.getRef(), location.toBuilder().distance(distance).build() );
        }

        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_LOCATIONS, updatedLocations);
        attributes.put(SD_EVENT_FIELD_LOCATIONS, sdUpdatedLocations);
        //hard-coded to an inline event until the Rubix bug is fixed
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }
}
