package com.fluentcommerce.model.fulfilment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.fulfilment.GetFulfilmentByIdQuery;
import com.fluentcommerce.commonv2.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.common.BaseEntity;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Fulfilment.Builder.class)
public class Fulfilment extends BaseEntity {

    private String id;
    private String ref;
    private String type;
    private List<FulfilmentItem> items;

    @Nullable
    private String fromAddressId;

    @Nullable
    private String fromAddressRef;

    @Nullable
    private String toAddressId;

    @Nullable
    private String toAddressRef;

    @Nullable
    private String status;

    @Nullable
    private String fromLocationRef;

    @Nullable
    private Map<String, Object> attributes;

    @Nullable
    private String orderId;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Fulfilment from(GetFulfilmentByIdQuery.FulfilmentById fulfilmentById) {
        return Fulfilment.builder()
            .id(fulfilmentById.id())
            .ref(fulfilmentById.ref())
            .status(fulfilmentById.status())
            .type(fulfilmentById.type())
            .items(getItems(fulfilmentById.items()))
            .attributes(getAttributes(fulfilmentById))
            .fromLocationRef(fulfilmentById.fromLocation() != null ? fulfilmentById.fromLocation().ref() : null)
            .fromAddressId(fulfilmentById.fromAddress() != null ? fulfilmentById.fromAddress().id() : null)
            .fromAddressRef(fulfilmentById.fromAddress() != null ? fulfilmentById.fromAddress().ref() : null)
            .toAddressId(fulfilmentById.toAddress() != null ? fulfilmentById.toAddress().id() : null)
            .toAddressRef(fulfilmentById.toAddress() != null ? fulfilmentById.toAddress().ref() : null)
            .orderId(fulfilmentById.order() != null ? fulfilmentById.order().id() : null)
            .build();
    }

    public static Fulfilment from(String orderId, GetOrderByIdQuery.FulfilmentNode fulfilmentNode) {
        return Fulfilment.builder()
            .id(fulfilmentNode.id())
            .ref(fulfilmentNode.ref())
            .status(fulfilmentNode.status())
            .type(fulfilmentNode.type())
            .items(getItems(fulfilmentNode.fulfilmentItems()))
            .attributes(getAttributes(fulfilmentNode))
            .fromLocationRef(fulfilmentNode.fromLocation() != null ? fulfilmentNode.fromLocation().ref() : null)
            .fromAddressId(fulfilmentNode.fromAddress() != null ? fulfilmentNode.fromAddress().id() : null)
            .fromAddressRef(fulfilmentNode.fromAddress() != null ? fulfilmentNode.fromAddress().ref() : null)
            .toAddressId(fulfilmentNode.toAddress() != null ? fulfilmentNode.toAddress().id() : null)
            .toAddressRef(fulfilmentNode.toAddress() != null ? fulfilmentNode.toAddress().ref() : null)
            .orderId(orderId)
            .build();
    }

    private static Map<String, Object> getAttributes(GetFulfilmentByIdQuery.FulfilmentById fulfilment) {
        if (fulfilment == null || CollectionUtils.isEmpty(fulfilment.attributes())) return new HashMap<>();
        return fulfilment.attributes().stream()
                .collect(Collectors.toMap(GetFulfilmentByIdQuery.Attribute::name, GetFulfilmentByIdQuery.Attribute::value));
    }

    private static List<FulfilmentItem> getItems(GetFulfilmentByIdQuery.Items items) {
        if (items == null) return new ArrayList<>();
        if (CollectionUtils.isEmpty(items.itemEdge())) return new ArrayList<>();

        return items.itemEdge()
                .stream()
                .map(GetFulfilmentByIdQuery.ItemEdge::itemNode)
                .filter(Objects::nonNull)
                .map(FulfilmentItem::from)
                .collect(Collectors.toList());
    }

    private static Map<String, Object> getAttributes(GetOrderByIdQuery.FulfilmentNode fulfilment) {
        if (fulfilment == null || CollectionUtils.isEmpty(fulfilment.fulfilmentAttributes())) return new HashMap<>();
        return fulfilment.fulfilmentAttributes().stream()
            .collect(Collectors.toMap(GetOrderByIdQuery.FulfilmentAttribute::name, GetOrderByIdQuery.FulfilmentAttribute::value));
    }

    private static List<FulfilmentItem> getItems(GetOrderByIdQuery.FulfilmentItems fulfilmentItems) {
        if (fulfilmentItems == null) return new ArrayList<>();
        if (CollectionUtils.isEmpty(fulfilmentItems.fulfilmentItemEdges())) return new ArrayList<>();

        return fulfilmentItems.fulfilmentItemEdges()
            .stream()
            .map(GetOrderByIdQuery.FulfilmentItemEdge::fulfilmentItemNode)
            .filter(Objects::nonNull)
            .map(FulfilmentItem::from)
            .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fulfilment that = (Fulfilment) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
