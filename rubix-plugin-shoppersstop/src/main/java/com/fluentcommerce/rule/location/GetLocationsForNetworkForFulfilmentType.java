package com.fluentcommerce.rule.location;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.commonv2.graphql.query.location.GetNetworksByLocationIdQuery;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.service.LocationService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LOCATIONS;
import static com.fluentcommerce.util.Constants.EventField.SD_EVENT_FIELD_LOCATIONS;
import static com.fluentcommerce.util.Constants.PropertyField.*;

/**
 * @author Holger
 */
@RuleInfo(
    name = "GetLocationsForNetworkForFulfilmentType",
    description = "Retrieves the locations in ED network {" + PROP_NETWORK_REF + "} which are in status {"
        + PROP_LOCATION_STATUSES + "}. Sends event {" + PROP_EVENT_NAME + "}.",
    accepts = {
        @EventInfo(entityType = ENTITY_TYPE_FULFILMENT_OPTIONS),
        @EventInfo(entityType = ENTITY_TYPE_ORDER)
    }
)

@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule")
@ParamString(name = PROP_LOCATION_STATUSES, description = "The location statuses which will be considered")
@ParamString(name = PROP_NETWORK_REF, description = "The ED network ref for which the locations will be retrieved.")
@Slf4j
public class GetLocationsForNetworkForFulfilmentType extends BaseRule {

    private static final String CLASS_NAME = GetLocationsForNetworkForFulfilmentType.class.getSimpleName();
    private static Boolean ED_flag = false;
    private static Boolean SD_flag = false;

    @Override
    public void execute(ContextWrapper context) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);
        final String networkRef = context.getProp(PROP_NETWORK_REF);
        List<String> locationStatuses = context.getPropList(PROP_LOCATION_STATUSES, String.class);

        Map<String, Location> networkLocations = new HashMap<>();

        Map<String, Location> sdLocations = new HashMap<>();
        Map<String, Location> edLocations = new HashMap<>();

        LocationService locationService = new LocationService(context);
        List<Location> locations = locationService.loadLocationsForNetwork(networkRef, locationStatuses);
        for (Location location : locations) {
            networkLocations.put(location.getRef(), location);
        }
        log.info(logPrefix + " - found:{} locations for network: {} in status:{}", networkLocations, networkRef, locationStatuses);

        //splitting locations
        for (Map.Entry<String, Location> entry : networkLocations.entrySet()) {
            Location location = entry.getValue();
            GetNetworksByLocationIdQuery query = GetNetworksByLocationIdQuery.builder().id(location.getId()).build();
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
                    edLocations.put(entry.getKey(),entry.getValue());
                    sdLocations.put(entry.getKey(),entry.getValue());
                }else if(ED_flag)
                {
                    edLocations.put(entry.getKey(),entry.getValue());
                }else {
                    sdLocations.put(entry.getKey(),entry.getValue());
                }
                ED_flag = false;
                SD_flag = false;
            }

        }


        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_LOCATIONS, edLocations);
        attributes.put(SD_EVENT_FIELD_LOCATIONS, sdLocations);
        //hard-coded to an inline event until the Rubix bug is fixed
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }
}
