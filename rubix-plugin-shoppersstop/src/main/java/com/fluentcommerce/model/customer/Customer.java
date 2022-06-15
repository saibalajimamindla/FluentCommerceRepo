package com.fluentcommerce.model.customer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.address.Address;
import com.fluentcommerce.model.common.BaseEntity;
import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.util.Objects;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Customer.Builder.class)
public class Customer extends BaseEntity {

    private String id;
    private String ref;

    @Nullable
    private String title;

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    private String username;

    @Nullable
    private String primaryEmail;

    @Nullable
    private String primaryPhone;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Customer from(GetOrderByIdQuery.Customer customer) {
        return Customer.builder()
            .id(customer.id())
            .ref(customer.ref())
            .title(customer.title())
            .firstName(customer.firstName())
            .lastName(customer.lastName())
            .username(customer.username())
            .primaryEmail(customer.primaryEmail())
            .primaryPhone(customer.primaryPhone())
            .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer that = (Customer) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
