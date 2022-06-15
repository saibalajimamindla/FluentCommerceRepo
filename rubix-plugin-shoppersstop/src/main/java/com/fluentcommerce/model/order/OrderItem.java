package com.fluentcommerce.model.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.fulfilment.GetFulfilmentByIdQuery;
import com.fluentcommerce.commonv2.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.common.BaseEntity;
import com.fluentcommerce.model.product.VariantProduct;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = OrderItem.Builder.class)
public class OrderItem extends BaseEntity {

    private String id;
    private String ref;

    @Nullable
    private Integer quantity;

    @Nullable
    private String productRef;

    @Nullable
    private Map<String, Object> attributes;

    private VariantProduct product;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public int getQuantity() {
        return quantity == null ? 0 : quantity;
    }

    public static OrderItem from(GetOrderByIdQuery.OrderItemNode orderItemNode) {
        OrderItem.Builder builder = OrderItem.builder()
            .id(orderItemNode.id())
            .ref(orderItemNode.ref())
            .quantity(orderItemNode.quantity());
        if (orderItemNode.orderItemProduct().asVariantProduct() != null) {
            builder.productRef(orderItemNode.orderItemProduct().asVariantProduct().ref());
            builder.product(VariantProduct.from(orderItemNode.orderItemProduct().asVariantProduct()));
        } else if (orderItemNode.orderItemProduct().asStandardProduct() != null) {
            builder.productRef(orderItemNode.orderItemProduct().asStandardProduct().ref());
            //todo to support Standard Products
        }
        return builder.build();
    }

    public static OrderItem from(GetFulfilmentByIdQuery.OrderItem orderItem) {
        return OrderItem.builder()
            .id(orderItem.id())
            .ref(orderItem.ref())
            .quantity(orderItem.quantity())
            .attributes(getAttributes(orderItem))
            .build();
    }

    private static Map<String, Object> getAttributes(GetFulfilmentByIdQuery.OrderItem orderItem) {
        if (orderItem == null || CollectionUtils.isEmpty(orderItem.orderItemAttributes())) return new HashMap<>();
        return orderItem.orderItemAttributes().stream()
            .collect(Collectors.toMap(GetFulfilmentByIdQuery.OrderItemAttribute::name, GetFulfilmentByIdQuery.OrderItemAttribute::value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderItem that = (OrderItem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
