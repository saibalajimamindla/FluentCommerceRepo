package com.fluentcommerce.model.virtual;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.virtual.GetVirtualPositionsQuery;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = VirtualPosition.Builder.class)
public class VirtualPosition {
    private String ref;
    private String productRef;
    private int quantity;
    private String groupRef;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static VirtualPosition from(GetVirtualPositionsQuery.VirtualPosition virtualPosition) {
        return VirtualPosition.builder()
            .ref(virtualPosition.ref())
            .quantity(virtualPosition.quantity())
            .productRef(virtualPosition.productRef())
            .groupRef(virtualPosition.groupRef())
            .build();
    }
}

