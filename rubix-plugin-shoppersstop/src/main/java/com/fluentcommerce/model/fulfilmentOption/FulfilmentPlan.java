package com.fluentcommerce.model.fulfilmentOption;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = FulfilmentPlan.Builder.class)
public class FulfilmentPlan {
    private List<FulfilmentPlanFulfilment> fulfilments;
    private String status;
    private String eta;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}
}
