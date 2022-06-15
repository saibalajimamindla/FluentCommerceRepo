package com.fluentcommerce.exceptions;

import com.fluentretail.rubix.event.Event;
import com.fluentretail.rubix.exceptions.RuleExecutionException;


public class NoFulfilmentFoundException extends RuleExecutionException {
    public NoFulfilmentFoundException(String message, Event event) {
        super(message, event);
    }

    public static NoFulfilmentFoundException id(String fulfilmentId, Event event) {
        return new NoFulfilmentFoundException("No fulfilment found with id: " + fulfilmentId, event);
    }

    public static NoFulfilmentFoundException ref(String fulfilmentRef, Event event) {
        return new NoFulfilmentFoundException("No fulfilment found with ref: " + fulfilmentRef, event);
    }
}
