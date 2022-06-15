package com.fluentcommerce.model.common;

import com.fluentretail.api.model.attribute.Attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Log {
    public String Title;
    public String Message;
    public List<Attribute> Attributes;

    public Log() {
        Attributes = new ArrayList<Attribute>();
    }

    public Log addAttribute(Attribute attribute) {
        Objects.requireNonNull(attribute);

        Attributes.add(attribute);
        return this;
    }

    public Log addAttribute(String name, Attribute.Type type, Object value){
        Attribute attribute = Attribute.builder().name(name).attributeType(type).value(value).build();

        return addAttribute(attribute);
    }

    public static Log create(String title, String message, List<Attribute> attributes) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(message);

        Log result = new Log();

        result.Title = title;
        result.Message = message;

        if (attributes != null)
            result.Attributes = attributes;

        return result;
    }

    public static Log create(String title, String message) {
        return create(title, message, null);
    }
}
