package com.fluentcommerce.util;

import com.fluentretail.rubix.event.Event;
import com.fluentretail.rubix.event.EventType;
import com.fluentretail.rubix.exceptions.PropertyNotFoundException;
import com.fluentretail.rubix.v2.context.Context;

import java.util.HashMap;
import java.util.Map;

import static com.fluentcommerce.util.Constants.ErrorCode.EXCEPTION_MESSAGE;
import static com.fluentcommerce.util.Constants.ErrorCode.EXCEPTION_TYPE;

/**
 * 
 * Helper class for rules development - for now has only validation methods.
 *
 */
public class RuleUtils {

    private RuleUtils() {}

    /**
     * Generates a standard log prefix with the account, class/rule, entityType, entityId and entityRef information
     * @param className the classname or rulename
     * @param event the event from which the information is extracted
     * @return the log prefix string
     */
    public static String buildLogPrefix(String className, final Event event) {
        final String entityId = event.getEntityId();
        final String entityRef = event.getEntityRef();
        final String entityType = event.getEntityType();
        final String accountId = event.getAccountId();
        return "[" + accountId + "] [" + className + "][" + entityType + " id=" + entityId + ", ref="
                + entityRef + "]";
    }

    public static boolean validateRulePropsIsNotEmpty(Context context, String... ruleProps) {
        if (ruleProps != null) {
            for (String ruleProp : ruleProps) {
                if (null == context.getProp(ruleProp) || context.getProp(ruleProp).isEmpty()) {
                    throw new PropertyNotFoundException(400, ruleProp);
                }
            }
        }
        return true;
    }

    public static Event createExceptionEvent(Context context, Exception e){
        Map<String,Object> exceptionEventAttributesMap= new HashMap<String,Object>();
        exceptionEventAttributesMap.put(EXCEPTION_TYPE, e.getMessage());
        exceptionEventAttributesMap.put(EXCEPTION_MESSAGE, e.getStackTrace());
        return context.getEvent().toBuilder().type(EventType.EXCEPTION).attributes(exceptionEventAttributesMap).build();
    }

}
