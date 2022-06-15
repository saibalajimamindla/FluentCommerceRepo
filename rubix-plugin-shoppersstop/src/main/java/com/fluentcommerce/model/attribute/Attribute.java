package com.fluentcommerce.model.attribute;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.fulfilmentOption.GetFulfilmentOptionByIdQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentretail.api.model.location.Address;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Attribute.Builder.class)
public class Attribute {

    private String name;
    private String type;
    private Object value;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Attribute from(GetLocationByRefQuery.Attribute attribute) {
        return Attribute.builder()
            .name(attribute.name())
            .type(attribute.type())
            .value(attribute.value())
            .build();
    }

    public static Attribute from(GetFulfilmentOptionByIdQuery.Attribute attribute) {
        Attribute.Builder attributeBuilder = Attribute.builder()
            .name(attribute.name())
            .type(attribute.type());
        if (StringUtils.equals(attribute.type(), "DOUBLE")) {
            attributeBuilder.value(Double.parseDouble(attribute.value().toString()));
        } else {
            attributeBuilder.value(attribute.value());
        }
        return attributeBuilder.build();
    }

    public static Attribute from(Map<String,Object> attribute) {
        Attribute.Builder builder = Attribute.builder()
            .name((String) attribute.get("name"));
        Object value = attribute.get("value");

        String type = "OBJECT";
        if (value instanceof String) {
            if (((String) value).length() > com.fluentretail.api.model.attribute.Attribute.MAX_STRING_LENGTH) {
                type = "TEXT";
            } else {
                type = "STRING";
            }
        } else if (value instanceof Integer) {
            type = "INTEGER";
        } else if (value instanceof Boolean) {
            type = "BOOLEAN";
        } else if (value instanceof Address) {
            type = "ADDRESS";
        }
        builder.value(value);
        builder.type(type);
            return builder.build();
    }


}
