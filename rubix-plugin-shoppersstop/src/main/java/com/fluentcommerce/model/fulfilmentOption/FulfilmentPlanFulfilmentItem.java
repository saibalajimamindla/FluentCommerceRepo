package com.fluentcommerce.model.fulfilmentOption;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = FulfilmentPlanFulfilmentItem.Builder.class)
public class FulfilmentPlanFulfilmentItem {
    private String productRef;
    private int availableQuantity;
    private int requestedQuantity;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}
}
