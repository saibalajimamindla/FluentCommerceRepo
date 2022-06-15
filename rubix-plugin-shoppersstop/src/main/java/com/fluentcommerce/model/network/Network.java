package com.fluentcommerce.model.network;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.model.common.BaseEntity;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.retailer.Retailer;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Network.Builder.class)
public class Network extends BaseEntity {

    private String id;
    private String ref;
    private String createdOn;
    private String updatedOn;
    private String type;
    private String status;
    private Map<String, Object> attributes;
    private List<Location> location;
    private List<Retailer> retailer;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Network from(GetLocationByRefQuery.NetworkNode node) {
        return Network.builder()
            .id(node.id())
            .ref(node.ref())
            .status(node.status())
            .build();
    }
}
