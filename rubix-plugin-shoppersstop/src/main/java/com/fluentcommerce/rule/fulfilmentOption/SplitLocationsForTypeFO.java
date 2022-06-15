package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetNetworksByLocationIdQuery;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.service.LocationService;
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
import java.util.Map;

import static com.fluentcommerce.util.CommonUtils.convertObjectToDto;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LOCATIONS;
import static com.fluentcommerce.util.Constants.EventField.SD_EVENT_FIELD_LOCATIONS;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;

@RuleInfo(
        name = "SplitLocationsForTypeFO",
        description = "Filters locations and splits them into SD and ED locations "
                + "Sends event {" + PROP_EVENT_NAME + "}.",
        accepts = {
                @EventInfo(entityType = ENTITY_TYPE_ORDER),
                @EventInfo(entityType = ENTITY_TYPE_FULFILMENT_OPTIONS)
        }
)
@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule")
@EventAttribute(name = EVENT_FIELD_LOCATIONS)

@Slf4j
public class SplitLocationsForTypeFO extends BaseRule {

    private static final String CLASS_NAME = SelectRatedFulfilmentPlanAndTypeFO.class.getSimpleName();

    private static Boolean ED_flag = false;
    private static Boolean SD_flag = false;

    @Override
    public void execute(ContextWrapper context){

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);
        Map<String, Object> locationsMap = context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class);

        Map<String, Location> updatedLocations = new HashMap<>();

        Map<String, Location> sdLocations = new HashMap<>();
        Map<String, Location> edLocations = new HashMap<>();

        for (Map.Entry<String, Object> locationEntry : locationsMap.entrySet()) {
            Location location = convertObjectToDto(locationEntry.getValue(), Location.class);
                updatedLocations.put(location.getRef(), location);
        }

        //splitting locations
        for (Map.Entry<String, Location> entry : updatedLocations.entrySet()) {
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
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);

    }
}
