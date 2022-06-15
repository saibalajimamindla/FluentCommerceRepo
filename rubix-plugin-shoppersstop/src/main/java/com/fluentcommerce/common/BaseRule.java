package com.fluentcommerce.common;

import com.fluentcommerce.util.CommonUtils;
import com.fluentretail.rubix.exceptions.RubixException;
import com.fluentretail.rubix.v2.context.Context;
import com.fluentretail.rubix.v2.rule.Rule;

public abstract class BaseRule implements Rule {

    public abstract void execute(ContextWrapper context);

    protected <E extends Exception> void onException(E exception, ContextWrapper context) {
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        throw new RuntimeException(exception);
    }

    protected boolean shouldLog() {
        return true;
    }

    protected void persistLogs(ContextWrapper contextWrapper) {
        if (shouldLog()) {
            CommonUtils.newLog(contextWrapper);
        }
    }

    @Override
    public <C extends Context> void run(C context) {
        ContextWrapper contextWrapper = ContextWrapper.from(context);
        try {
            execute(contextWrapper);
        } catch (RubixException e) {
            onException(e, contextWrapper);
        } catch (Exception e) {
            onException(e, contextWrapper);
        } finally {
            persistLogs(contextWrapper);
        }
    }
}
