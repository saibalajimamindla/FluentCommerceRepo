package com.fluentcommerce.model.fulfilmentOption;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.model.attribute.Attribute;
import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = FulfilmentOption.Builder.class)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class FulfilmentOption {
    private String id;
    private String ref;
    private String type;
    private Date createdOn;
    private int retailerId;
    private Date updatedOn;
    private String orderType;
    private String pickupLocationRef;
    private String addressName;
    private String companyName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private Double longitude;
    private Double latitude;
    private List<Product> products;
    private List<Attribute> attributes;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}
}
