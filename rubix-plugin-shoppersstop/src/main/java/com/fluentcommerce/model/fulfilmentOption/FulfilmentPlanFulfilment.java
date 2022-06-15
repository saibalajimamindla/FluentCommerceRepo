package com.fluentcommerce.model.fulfilmentOption;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = FulfilmentPlanFulfilment.Builder.class)
public class FulfilmentPlanFulfilment {
    private String type;
    private String locationRef;
    private Double rating;
    private Integer eta;
    private String fulfilmentType;
    private Double distance;
    private List<FulfilmentPlanFulfilmentItem> items;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}
}
