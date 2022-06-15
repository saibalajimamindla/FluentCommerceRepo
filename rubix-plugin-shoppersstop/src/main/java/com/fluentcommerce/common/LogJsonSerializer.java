package com.fluentcommerce.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluentcommerce.model.common.Log;

import java.util.List;

public class LogJsonSerializer {
    public String Serialize(List<Log> input) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(input);
    }
}
