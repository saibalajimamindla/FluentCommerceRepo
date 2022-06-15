package com.fluentcommerce.rule.common;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.event.Event;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.EventInfoVariables;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.UUID;

import static com.fluentcommerce.util.Constants.EntityType.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_WEBHOOK_ENDPOINT;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_WEBHOOK_NAME;

/**
 * Rule which will send a webhook for the order to the defined endpoint.
 *
 * @author Holger Lierse
 */
@RuleInfo(name = "SendWebhook",
    description =
        "Send a webhook with name {" + PROP_WEBHOOK_NAME + "} to the endpoint {" + PROP_WEBHOOK_ENDPOINT + "} "
            + "for the entity.",
    produces = {
        @EventInfo(
            eventName = "{" + PROP_WEBHOOK_NAME + "}",
            entityType = EventInfoVariables.EVENT_TYPE,
            entitySubtype = EventInfoVariables.EVENT_SUBTYPE,
            status = EventInfoVariables.EVENT_STATUS
        )
    },
    accepts = {
        @EventInfo(
            entityType = ENTITY_TYPE_ORDER
        ),
        @EventInfo(
            entityType = ENTITY_TYPE_FULFILMENT
        ),
        @EventInfo(
            entityType = ENTITY_TYPE_ARTICLE
        ),
        @EventInfo(
            entityType = ENTITY_TYPE_CONSIGNMENT
        ),
        @EventInfo(
            entityType = ENTITY_TYPE_LOCATION
        ),
        @EventInfo(
            entityType = ENTITY_TYPE_WAVE
        ),
        @EventInfo(
            entityType = ENTITY_TYPE_FULFILMENT_OPTIONS
        ),
        @EventInfo(
            entityType = ENTITY_TYPE_FULFILMENT_PLAN
        )
    }
)
@ParamString(name = PROP_WEBHOOK_NAME, description = "The name of the webhook message")
@ParamString(name = PROP_WEBHOOK_ENDPOINT, description = "The url of the webhook endpoint")
@Slf4j
public class SendWebhook extends BaseRule {

    private static final String CLASS_NAME = SendWebhook.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        log.info("{} - incoming event {} ", logPrefix, context.getEvent());
        final String webhookEndpoint = context.getProp(PROP_WEBHOOK_ENDPOINT);
        final String webhookName = context.getProp(PROP_WEBHOOK_NAME);

        RuleUtils.validateRulePropsIsNotEmpty(context, PROP_WEBHOOK_ENDPOINT, PROP_WEBHOOK_NAME);

        final Event event = buildWebhookEvent(context.getEvent(), webhookName);
        context.action().postWebhook(webhookEndpoint, event);
    }

    private Event buildWebhookEvent(Event event, String webhookName) {
        return event.toBuilder()
            .id(UUID.randomUUID())
            .name(webhookName)
            .attributes(new HashMap<>())
            .build();
    }
}
