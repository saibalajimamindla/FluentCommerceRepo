package com.fluentcommerce.model.fulfilment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.fulfilment.GetFulfilmentByIdQuery;
import com.fluentcommerce.commonv2.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.common.BaseEntity;
import com.fluentcommerce.model.order.OrderItem;
import lombok.Builder;
import lombok.Value;

import javax.annotation.Nullable;
import java.util.Objects;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = FulfilmentItem.Builder.class)
public class FulfilmentItem extends BaseEntity {

    private String id;
    private String ref;
    private String productRef;
    private Integer requestedQuantity;
    private Integer filledQuantity;
    private Integer rejectedQuantity;
    private String orderItemRef;

    @Nullable
    private OrderItem orderItem;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public int getRequestedQuantity() {
        return requestedQuantity == null ? 0 : requestedQuantity;
    }

    public int getFilledQuantity() {
        return filledQuantity == null ? 0 : filledQuantity;
    }

    public int getRejectedQuantity() {
        return rejectedQuantity == null ? 0 : rejectedQuantity;
    }

    public static FulfilmentItem from(GetFulfilmentByIdQuery.ItemNode itemNode) {
        return FulfilmentItem.builder()
            .id(itemNode.id())
            .ref(itemNode.ref())
            .requestedQuantity(itemNode.requestedQuantity())
            .filledQuantity(itemNode.filledQuantity())
            .rejectedQuantity(itemNode.rejectedQuantity())
            .orderItem(OrderItem.from(itemNode.orderItem()))
            .build();
    }

    public static FulfilmentItem from(GetOrderByIdQuery.FulfilmentItemNode itemNode) {
        return FulfilmentItem.builder()
            .id(itemNode.id())
            .ref(itemNode.ref())
            .requestedQuantity(itemNode.requestedQuantity())
            .filledQuantity(itemNode.filledQuantity())
            .rejectedQuantity(itemNode.rejectedQuantity())
            .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FulfilmentItem that = (FulfilmentItem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

}
