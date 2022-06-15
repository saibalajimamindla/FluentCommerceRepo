package com.fluentcommerce.model.retailer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.model.common.BaseEntity;
import com.fluentcommerce.model.network.Network;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Retailer.Builder.class)
public class Retailer extends BaseEntity {
    private String id;
    private String ref;
    private String createdOn;
    private String updatedOn;
    private String status;
    private String summary;
    private String websiteUrl;
    private String websiteUrlName;
    private String primaryEmail;
    private String supportContactName;
    private String supportEmail;
    private String supportPhone;
    private String tradingName;
    private List<Network> networkList;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Retailer from(GetLocationByRefQuery.Retailer retailer) {
        return Retailer.builder()
            .id(retailer.id())
            .ref(retailer.ref())
            .build();
    }

    public  static Retailer from(String retailerId){
        return Retailer.builder()
            .id(retailerId)
            .build();
    }
}
