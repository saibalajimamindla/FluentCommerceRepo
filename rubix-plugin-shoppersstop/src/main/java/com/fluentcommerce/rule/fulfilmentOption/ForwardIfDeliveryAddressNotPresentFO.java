package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;

/**
 * @author holger
 * This rule forwards the event with the corresponding name if the delivery address is not present.
 */
@RuleInfo(
    name = "ForwardIfDeliveryAddressNotPresentFO",
    description = "Forwards the event with name {" + PROP_EVENT_NAME + "} if the delivery address is not present.",
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
@EventAttribute(name = EVENT_FIELD_CITY)
@EventAttribute(name = EVENT_FIELD_STATE)
@EventAttribute(name = EVENT_FIELD_POSTCODE)
@EventAttribute(name = EVENT_FIELD_COUNTRY)
@Slf4j
public class ForwardIfDeliveryAddressNotPresentFO extends BaseRule {

    private static final String CLASS_NAME = ForwardIfDeliveryAddressNotPresentFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);

        final String city = context.getEvent().getAttribute(EVENT_FIELD_CITY);
        final String state = context.getEvent().getAttribute(EVENT_FIELD_STATE);
        final String postcode = context.getEvent().getAttribute(EVENT_FIELD_POSTCODE);
        final String country = context.getEvent().getAttribute(EVENT_FIELD_COUNTRY);

        if (StringUtils.isBlank(city)
            || StringUtils.isBlank(state)
            || StringUtils.isBlank(postcode)
            || StringUtils.isBlank(country)
        ) {
            EventUtils.forwardInlineEvent(context, eventName);
        }
    }
}


