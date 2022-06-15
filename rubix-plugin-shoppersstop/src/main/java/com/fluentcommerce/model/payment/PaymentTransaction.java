package com.fluentcommerce.model.payment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentretail.api.model.attribute.Attribute;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = PaymentTransaction.Builder.class)
public class PaymentTransaction {
    private String ref;
    private String type;
    private String status;
    private Double amount;
    private String currencyCode;
    private String paymentRef;
    private String paymentServiceProviderRef;
    private String authorizationKey;
    private String cardType;
    private String paymentMethod;

    private List<Attribute> attributes;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
    }
}

