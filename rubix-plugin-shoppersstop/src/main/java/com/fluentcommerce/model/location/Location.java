package com.fluentcommerce.model.location;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationsForNetworkRefQuery;
import com.fluentcommerce.model.common.BaseEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Location.Builder.class)
public class Location extends BaseEntity {
    private String id;
    private String ref;
    private String type;
    private Double longitude;
    private Double latitude;
    private Double distance;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Location from(GetLocationsForNetworkRefQuery.Location location) {
        return Location.builder()
            .id(location.id())
            .ref(location.ref())
            .type(location.type())
            .longitude(location.primaryAddress().longitude())
            .latitude(location.primaryAddress().latitude())
            .build();
    }
}