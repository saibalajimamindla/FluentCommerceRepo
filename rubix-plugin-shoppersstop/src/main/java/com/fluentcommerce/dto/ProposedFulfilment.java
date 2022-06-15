package com.fluentcommerce.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.virtual.VirtualPosition;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = ProposedFulfilment.Builder.class)
public class ProposedFulfilment {
    private String locationRef;
    private Double distance;
    private String locationType;
    private List<VirtualPosition> virtualPositions;
    private String eta;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static ProposedFulfilment from(Location location, List<VirtualPosition> virtualPositions) {
        return ProposedFulfilment.builder()
            .locationRef(location.getRef())
            .locationType(location.getType())
            .distance(location.getDistance())
            .virtualPositions(virtualPositions)
            .build();
    }
}
