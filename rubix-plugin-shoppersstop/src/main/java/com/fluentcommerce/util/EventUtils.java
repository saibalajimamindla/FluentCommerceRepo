package com.fluentcommerce.util;

import com.fluentretail.api.model.EntityType;
import com.fluentretail.api.v2.model.Entity;
import com.fluentretail.rubix.event.Event;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

import static com.fluentcommerce.util.Constants.EntityType.*;


@Slf4j
public class EventUtils {

    private static String CLASS_NAME = com.fluentcommerce.util.EventUtils.class.getSimpleName();

    public static void forwardInlineEvent(Context context, String eventName) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        Event newEvent = context.getEvent().toBuilder()
            .name(eventName)
            .scheduledOn(null)
            .build();
        log.info(logPrefix + " - Forwarding inline event: {}",  newEvent);
        context.action().sendEvent(newEvent);
    }

    public static void forwardInlineEventWithAttributes(Context context, String eventName, Map<String, Object> attributes) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        Event newEvent = context.getEvent().toBuilder()
            .name(eventName)
            .scheduledOn(null)
            .attributes(attributes)
            .build();
        log.info(logPrefix + " - Forwarding inline event: {}",  newEvent);
        context.action().sendEvent(newEvent);
    }

    public static void forwardEvent(Context context, String eventName) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        Event event = createEvent(context, eventName, null);
        log.info(logPrefix + " - Forwarding event: {}",  event);
        context.action().sendEvent(event);
    }

    public static void forwardEventWithAttributes(Context context, String eventName, Map<String, Object> attributes) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        Event event = createEvent(context, eventName, attributes);
        log.info(logPrefix + " - Forwarding event: {}",  event);
        context.action().sendEvent(event);
    }

    // ensure inline event is not scheduled, fetch entity to ensure latest entity status, and entitysubtype is set
    // if incoming state different to current state, schedule (WORKAROUND Rubix Bug)
    private static Event createEvent(Context context, String eventName, Map<String, Object> attributes) {
        final String logPrefix = com.fluentcommerce.util.RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        Entity entity = context.getEntity();
        String entityStatus = entity == null ? context.getEvent().getEntityStatus() : entity.getStatus();
        String entitySubtype = entity == null ? context.getEvent().getEntitySubtype() : entity.getType();

        entityStatus = checkAndRetrieveV1EntityStatus(context, entityStatus);

        Event.Builder eventBuilder = context.getEvent().toBuilder()
            .scheduledOn(entityStatus != context.getEvent().getEntityStatus() ? new Date() : null)
            .entityStatus(entityStatus)
            .entitySubtype(entitySubtype)
            .name(eventName);
        if (attributes != null){
            eventBuilder.attributes(attributes);
        }
        Event event = eventBuilder.build();
        log.info("{} - Sending new event: {}. context.getEntity null?:{}. entityStatus:{} != context.getEvent().getEntityStatus():{}"
            , logPrefix, event, entity, entityStatus, context.getEvent().getEntityStatus());
        return event;
    }

    private static String checkAndRetrieveV1EntityStatus(Context context, String entityStatus) {

        com.fluentretail.api.model.Entity v1Entity;
        switch (context.getEvent().getEntityType()) {
            case ENTITY_TYPE_ORDER:
            case ENTITY_TYPE_FULFILMENT:
            case ENTITY_TYPE_CONSIGNMENT:
            case ENTITY_TYPE_ARTICLE:
            case ENTITY_TYPE_FULFILMENT_OPTIONS:
            case ENTITY_TYPE_FULFILMENT_PLAN:
            case ENTITY_TYPE_LOCATION:
            case ENTITY_TYPE_WAVE:
                v1Entity = context.api().getLegacyClient().getEntity(EntityType.of(context.getEvent().getEntityType()), context.getEvent().getEntityId());
                log.info("[{}] [COMMON-V2] [{}]- Got Legacy Entity {}, Legacy Entity Status: {}, Event Entity Status: {}", context.getEvent().getAccountId(), EventUtils.class.getSimpleName(), v1Entity, v1Entity.getStatus(), entityStatus);
                entityStatus = entityStatus.equalsIgnoreCase(v1Entity.getStatus()) ? entityStatus : v1Entity.getStatus();
                break;
            default:
                break;
        }
        return entityStatus;
    }
}
