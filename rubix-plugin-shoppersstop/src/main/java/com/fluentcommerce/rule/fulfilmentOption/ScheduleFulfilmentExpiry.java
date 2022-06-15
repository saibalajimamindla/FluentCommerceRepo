package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.commonv2.graphql.mutation.fulfilment.UpdateFulfilmentMutation;
import com.fluentcommerce.commonv2.graphql.query.fulfilment.GetFulfilmentByIdQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationDetailsByRefQuery;
import com.fluentcommerce.commonv2.graphql.type.UpdateFulfilmentInput;
import com.fluentretail.rubix.common.Constants;
import com.fluentretail.rubix.common.utils.DateUtils;
import com.fluentretail.rubix.common.utils.LocationUtils;
import com.fluentretail.rubix.common.utils.SettingsHelper;
import com.fluentretail.rubix.event.Event;
import com.fluentretail.rubix.exceptions.RubixException;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.EventInfoVariables;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import com.fluentretail.rubix.v2.context.Context;
import com.fluentretail.rubix.v2.rule.Rule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.TimeZone;

import static com.fluentretail.rubix.common.Constants.CONVERT_SECOND;
import static com.fluentretail.rubix.common.Constants.ERROR_CODE_400;

/**
 * This rule will set a fulfilment expiry against the given fulfilment based on the Pick&PackTimeLimit set at the location 
 * and schedule a \"FulfilmentExpiry\" event
 * Status of the fulfilment is not considered while setting the expiry
 * This rule applies to both PFS and PFDC sub types. If no Pick&PackTimeLimit is set for DC, the fulfilment will not be expired.
 * 
 * @author Mamata
 *
 */
@RuleInfo(name = "ScheduleFulfilmentExpiry",
description = "Sets a fulfilment expiry against the fulfilment and schedule a \"FulfilmentExpiry\" event",
produces = {
        @EventInfo(
                eventName = "{eventName}",
                entityType = EventInfoVariables.EVENT_TYPE,
                entitySubtype = EventInfoVariables.EVENT_SUBTYPE,
                status = EventInfoVariables.EVENT_STATUS)
},
accepts = {
        @EventInfo(
                entityType = Constants.ENTITY_TYPE_FULFILMENT
        )
}
)

@Slf4j
public class ScheduleFulfilmentExpiry implements Rule {
    public static final String FULFILMENT_EXPIRY_EVENT = "FulfilmentExpiry";
    public static final String SETTING_CONTEXT_AGENT = "AGENT";
    public static final String SETTING_NAME_PICKPACK_TIMELIMIT = "PICK_N_PACK_TIME_LIMIT";

    @Override
    public void run(Context context) {
        final Event incomingEvent = context.getEvent();
        log.info("ScheduleFulfilmentExpiry-V2 Rule has been triggered");
        String fulfilmentId = incomingEvent.getEntityId();

		GetFulfilmentByIdQuery getFulfilmentDetails = GetFulfilmentByIdQuery.builder().id(fulfilmentId)
            .includeAttributes(false)
            .includeItems(false)
            .includeArticles(false)
            .includeFromAddress(true)
            .includeOrder(false)
            .includeToAddress(false)
            .build();
		GetFulfilmentByIdQuery.Data fulfilmentData = (GetFulfilmentByIdQuery.Data) context.api().query(getFulfilmentDetails);
        Date expiryTime = null;
        String timeZone = null;
        int expiryHrs;
        int delayedSeconds;
        try {
            if (fulfilmentData.fulfilmentById().fromAddress() != null) {
            	String locationRef = fulfilmentData.fulfilmentById().fromAddress().ref();
            	log.info("LocationRef from PrimaryAddress of fulfilment : " + locationRef);
            	String locationId = LocationUtils.getLocationId(context, locationRef);
            	
            	log.info("Location ID for the location : " + locationId);
                //timeZone = fulfilmentData.fulfilmentById().fromAddress().timeZone();
            	timeZone = LocationUtils.getLocationTimeZone(context, locationRef);
                log.info("Timezone for the location : " + timeZone);
                if (StringUtils.isEmpty(timeZone)) {
                    timeZone = String.valueOf(TimeZone.getTimeZone("UTC"));
                }
                
                //Use PICK_N_PACK_TIME_LIMIT in settings table for the location to calculate expiry time
                String pickPackLimitValue = SettingsHelper
                    .getSettingValue(context, SETTING_CONTEXT_AGENT, locationId, SETTING_NAME_PICKPACK_TIMELIMIT);
                log.info("pickPackLimitValue for this location : " + pickPackLimitValue);
                //DC locations might not have a Pik&Pack Time Limit set, in that case no event will be scheduled
                if(pickPackLimitValue != null && !pickPackLimitValue.isEmpty()) {
                	expiryHrs = Integer.parseInt(pickPackLimitValue);
                	log.info("Expiry hours from API location.getPickAndPackTimeLimit():-->" + expiryHrs);
                
                	delayedSeconds = expiryHrs * CONVERT_SECOND;
                	GetLocationDetailsByRefQuery.OpeningSchedule openingSchedule = LocationUtils.getOpeningSchedule(context, locationRef);
                	expiryTime = DateUtils.getExpiryDate((Date)fulfilmentData.fulfilmentById().createdOn(), delayedSeconds, openingSchedule,
                        TimeZone.getTimeZone(timeZone));
                
                	log.info("ExpiryTime for fullfillment Id:" + fulfilmentId + " is" + expiryTime);
                
                	UpdateFulfilmentInput updateFulfilmentInput = UpdateFulfilmentInput.builder().id(incomingEvent.getEntityId()).expiryTime(expiryTime).build();
                	UpdateFulfilmentMutation updateFulfilment = UpdateFulfilmentMutation.builder().input(updateFulfilmentInput).build();
                	context.action().mutation(updateFulfilment);

                	Event scheduledEvent = createEvent(incomingEvent, expiryTime);
                	log.info("Send {} event: {}", FULFILMENT_EXPIRY_EVENT, scheduledEvent);
                	context.action().sendEvent(scheduledEvent);
                }
            }
        } catch (RubixException re) {
            throw new RubixException(ERROR_CODE_400, "Exception while setting the expiry time or while sending the fulfillment expiry event");
        }

    }

    private Event createEvent(Event incomingEvent, Date expiryTime) {
        return Event.builder()
                .name(FULFILMENT_EXPIRY_EVENT)
                .accountId(incomingEvent.getAccountId())
                .retailerId(incomingEvent.getRetailerId())
                .entityId(incomingEvent.getEntityId())
                .entityRef(incomingEvent.getEntityRef())
                .entityType(incomingEvent.getEntityType())
                .rootEntityId(incomingEvent.getRootEntityId())
                .rootEntityRef(incomingEvent.getRootEntityRef())
                .rootEntityType(incomingEvent.getRootEntityType())
                .scheduledOn(expiryTime)
                .build();
    }
}
