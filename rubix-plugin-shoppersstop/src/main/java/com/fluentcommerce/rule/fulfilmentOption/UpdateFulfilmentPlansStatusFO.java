package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlan;
import com.fluentcommerce.service.FulfilmentOptionService;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventAttribute;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_CREATED_FULFILMENT_PLANS;

/**
 * @author holger
 * This rule forwards the event if the fulfilment plan status of the event is matching"
 */
@RuleInfo(
        name = "UpdateFulfilmentPlansStatusFO",
        description = "Workaround rule - Updates each fulfilment plan status.",
        accepts = {
                @EventInfo(
                        entityType = ENTITY_TYPE_FULFILMENT_OPTIONS
                )
        }
)
@EventAttribute(name = EVENT_FIELD_CREATED_FULFILMENT_PLANS)
@Slf4j
public class UpdateFulfilmentPlansStatusFO extends BaseRule {

    private static final String CLASS_NAME = UpdateFulfilmentPlansStatusFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        Map<String, FulfilmentPlan> fulfilmentPlans =
            context.getEvent().getAttribute(EVENT_FIELD_CREATED_FULFILMENT_PLANS, Map.class);

        FulfilmentOptionService fulfilmentOptionService = new FulfilmentOptionService(context);
        for (Map.Entry<String, FulfilmentPlan> entry : fulfilmentPlans.entrySet()) {
            fulfilmentOptionService.updateFulfilmentPlanStatus(entry);
        }
    }
}


