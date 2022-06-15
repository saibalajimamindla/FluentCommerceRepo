package com.fluentcommerce.model.fulfilmentOption;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Product.Builder.class)
public class Product {

    private String productRef;
    private String catalogueRef;
    private int requestedQuantity;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

}
