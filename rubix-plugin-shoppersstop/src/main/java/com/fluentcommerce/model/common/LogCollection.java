package com.fluentcommerce.model.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fluentcommerce.common.LogJsonSerializer;

import java.util.ArrayList;

public class LogCollection extends ArrayList<Log> {
    private LogJsonSerializer serializer;

    public LogCollection() {
        super();
        this.serializer = new LogJsonSerializer();
    }

    @Override
    public String toString() throws RuntimeException {
        try {
            return serializer.Serialize(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
