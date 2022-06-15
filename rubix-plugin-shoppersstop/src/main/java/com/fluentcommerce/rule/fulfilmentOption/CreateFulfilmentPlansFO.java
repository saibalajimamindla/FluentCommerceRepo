package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlan;
import com.fluentcommerce.service.FulfilmentOptionService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;

/**
 * @author Holger
 */
@RuleInfo(
    name = "CreateFulfilmentPlansFO",
    description = "Created the fulfilment plans. Sends event {" + PROP_EVENT_NAME + "}.",
    accepts = {
        @EventInfo(entityType = ENTITY_TYPE_FULFILMENT_OPTIONS)
    },
    produces = {
        @EventInfo(
            eventName = "{" + PROP_EVENT_NAME + "}",
            entityType = EventInfoVariables.EVENT_TYPE,
            entitySubtype = EventInfoVariables.EVENT_SUBTYPE,
            status = EventInfoVariables.EVENT_STATUS)
    }
)
@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule")
@EventAttribute(name = EVENT_FIELD_FULFILMENT_PLANS)
@EventAttribute(name = EVENT_FIELD_LOCATIONS)

@Slf4j
public class CreateFulfilmentPlansFO extends BaseRule {

    private static final String CLASS_NAME = CreateFulfilmentPlansFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info("{} - Incoming event :{}", logPrefix, context.getEvent());
        final String eventName = context.getProp(PROP_EVENT_NAME);

        List<FulfilmentPlan> fulfilmentPlans =
            context.getEvent().getAttribute(EVENT_FIELD_FULFILMENT_PLANS, List.class);

        FulfilmentOptionService fulfilmentOptionService = new FulfilmentOptionService(context);
        Map<String, FulfilmentPlan> createdFulfilmentPlansMap =
            fulfilmentOptionService.createFulfilmentPlans(context, fulfilmentPlans);

        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_CREATED_FULFILMENT_PLANS, createdFulfilmentPlansMap);
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);

    }
}


