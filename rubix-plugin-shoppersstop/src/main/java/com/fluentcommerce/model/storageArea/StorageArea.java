package com.fluentcommerce.model.storageArea;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.model.common.BaseEntity;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = StorageArea.Builder.class)
public class StorageArea extends BaseEntity {
    private String id;
    private String createdOn;
    private String updatedOn;
    private String name;
    private String status;
    private String location;
    private String type;
    private Map<String,Object> attributes;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static StorageArea from(GetLocationByRefQuery.StorageNode node) {
        return StorageArea.builder()
            .id(node.id())
            .status(node.status())
            .type(node.type())
            .build();
    }
}
