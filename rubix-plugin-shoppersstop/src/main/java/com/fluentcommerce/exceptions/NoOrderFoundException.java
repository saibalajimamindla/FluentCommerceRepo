package com.fluentcommerce.exceptions;

import com.fluentretail.rubix.event.Event;
import com.fluentretail.rubix.exceptions.RuleExecutionException;


public class NoOrderFoundException extends RuleExecutionException {
    public NoOrderFoundException(String message, Event event) {
        super(message, event);
    }

    public static NoOrderFoundException id(String orderId, Event event) {
        return new NoOrderFoundException("No order found with id: " + orderId, event);
    }

    public static NoOrderFoundException ref(String orderRef, Event event) {
        return new NoOrderFoundException("No order found with ref: " + orderRef, event);
    }
}
