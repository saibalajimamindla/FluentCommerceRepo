package com.fluentcommerce.model.address;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationsForNetworkRefQuery;
import com.fluentcommerce.model.common.BaseEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Address.Builder.class)
public class Address extends BaseEntity {

    private String id;
    private String ref;
    private String type;
    private String createdOn;
    private String updatedOn;
    private String companyName;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postcode;
    private String region;
    private String country;
    private Double latitude;
    private Double longitude;
    private String timeZone;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Address from(GetLocationsForNetworkRefQuery.PrimaryAddress primaryAddress) {
        return Address.builder()
            .latitude(primaryAddress.latitude())
            .longitude(primaryAddress.longitude())
            .build();
    }

    public static Address from(GetLocationByRefQuery.PrimaryAddress primaryAddress) {
        return Address.builder()
            .id(primaryAddress.id())
            .type(primaryAddress.type())
            .companyName(primaryAddress.companyName())
            .name(primaryAddress.name())
            .street(primaryAddress.street())
            .city(primaryAddress.city())
            .state(primaryAddress.state())
            .postcode(primaryAddress.postcode())
            .region(primaryAddress.region())
            .country(primaryAddress.country())
            .latitude(primaryAddress.latitude())
            .longitude(primaryAddress.longitude())
            .ref(primaryAddress.ref())
            .timeZone(primaryAddress.timeZone())
            .build();
    }

}
