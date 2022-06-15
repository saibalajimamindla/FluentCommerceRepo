package com.fluentcommerce.util.email;

import com.fluentcommerce.model.fulfilment.Fulfilment;
import com.fluentcommerce.service.FulfilmentService;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.event.Event;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TemplateVariablesUtil {

    private static final String CLASS_NAME = "TemplateVariablesUtil";

    public static Map<String, Object> populateTemplateVariables(Context context) {
        final Event incomingEvent = context.getEvent();
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, incomingEvent);
        Map<String, Object> templateVariables = new HashMap<>();

        final String fulfilmentId = incomingEvent.getEntityId();
        log.info("{} - Building Template Variables for Fulfilment with [Id: {}]", logPrefix,
                context.getEvent().getEntityId());
        populateFromFulfilment(fulfilmentId, context, templateVariables);

        FulfilmentService fulfilmentService = new FulfilmentService(context);
        Fulfilment fulfilment = fulfilmentService.getFulfilmentByIdOrFail(fulfilmentId);
        populateFromOrder(fulfilment.getOrderId(), context, templateVariables);

        return templateVariables;
    }

    private static void populateFromOrder(String orderId, Context context, Map<String, Object> templateVariables) {
        CompileTemplateFunction.INIT_ORDER.apply(orderId, context, templateVariables);
    }

    private static void populateFromFulfilment(String fulfilmentId, Context context,
            Map<String, Object> templateVariables) {
        CompileTemplateFunction.INIT_LOCATION.apply(fulfilmentId, context, templateVariables);
    }
}
