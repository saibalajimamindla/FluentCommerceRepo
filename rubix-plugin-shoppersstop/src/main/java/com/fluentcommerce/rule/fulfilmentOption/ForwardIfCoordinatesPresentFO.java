package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LATITUDE;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LONGITUDE;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;

/**
 * @author holger
 * This rule forwards the event with the corresponding name if longitude and latitude are present.
 */
@RuleInfo(
    name = "ForwardIfCoordinatesPresentFO",
    description = "Forwards the event with name {" + PROP_EVENT_NAME + "} if the longitude and latitude are present.",
    accepts = {
            @EventInfo(
                    entityType = ENTITY_TYPE_FULFILMENT_OPTIONS
            )
    },
    produces = {
        @EventInfo(
            eventName = "{" + PROP_EVENT_NAME + "}",
            entityType = EventInfoVariables.EVENT_TYPE,
            entitySubtype = EventInfoVariables.EVENT_SUBTYPE,
            status = EventInfoVariables.EVENT_STATUS)
    }
)
@ParamString(name = PROP_EVENT_NAME, description = "The name of event to be triggered")
@EventAttribute(name = EVENT_FIELD_LONGITUDE)
@EventAttribute(name = EVENT_FIELD_LATITUDE)
@Slf4j
public class ForwardIfCoordinatesPresentFO extends BaseRule {

    private static final String CLASS_NAME = ForwardIfCoordinatesPresentFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);

        Double longitude = context.getEvent().getAttribute(EVENT_FIELD_LONGITUDE, Double.class);
        Double latitude = context.getEvent().getAttribute(EVENT_FIELD_LATITUDE, Double.class);
        if (latitude != null && longitude != null) {
            EventUtils.forwardInlineEvent(context, eventName);
        }
    }
}


