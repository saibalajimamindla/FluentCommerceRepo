package com.fluentcommerce.model.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.common.BaseEntity;
import com.fluentcommerce.model.customer.Customer;
import com.fluentcommerce.model.fulfilment.Fulfilment;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Order.Builder.class)
public class Order extends BaseEntity {

    private String id;
    private String ref;
    private String type;
    private String status;
    private Date createdOn;

    private List<OrderItem> items;

    @Nullable
    private String pickupLocationRef;

    @Nullable
    private String deliveryType;

    @Nullable
    private String deliveryAddressId;

    @Nullable
    private String deliveryAddressRef;

    @Nullable
    private String deliveryAddressType;

    @Nullable
    private String deliveryAddressName;

    @Nullable
    private String deliveryAddressCompanyName;

    @Nullable
    private String deliveryAddressStreet;

    @Nullable
    private String deliveryAddressCity;

    @Nullable
    private String deliveryAddressState;

    @Nullable
    private String deliveryAddressPostcode;

    @Nullable
    private String deliveryAddressRegion;

    @Nullable
    private String deliveryAddressCountry;

    @Nullable
    private Double deliveryAddressLongitude;

    @Nullable
    private Double deliveryAddressLatitude;

    @Nullable
    private Map<String, Object> attributes;

    @Nullable
    private List<Fulfilment> fulfilments;

    @Nullable
    private Customer customer;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Order from(GetOrderByIdQuery.OrderById orderById) {
        Order.Builder builder = Order.builder()
            .id(orderById.id())
            .ref(orderById.ref())
            .status(orderById.status())
            .type(orderById.type())
            .createdOn((Date)orderById.createdOn())
            .attributes(mapAttributes(orderById))
            .items(mapItems(orderById.orderItems()))
            .customer(mapCustomer(orderById));
        if (orderById.fulfilmentChoice() != null) {
            mapFulfilmentChoice(builder, orderById.fulfilmentChoice());
        }
        mapFulfilments(builder, orderById.fulfilments());
        return builder.build();
    }

    private static Customer mapCustomer(GetOrderByIdQuery.OrderById orderById) {
        if (orderById == null || orderById.customer() == null) return null;
        return Customer.from(orderById.customer());
    }

    private static List<OrderItem> mapItems(GetOrderByIdQuery.OrderItems items) {
        if (items == null) return new ArrayList<>();
        if (CollectionUtils.isEmpty(items.orderItemEdge())) return new ArrayList<>();
        return items.orderItemEdge()
            .stream()
            .map(GetOrderByIdQuery.OrderItemEdge::orderItemNode)
            .filter(Objects::nonNull)
            .map(OrderItem::from)
            .collect(Collectors.toList());
    }

    private static void mapFulfilments(Order.Builder order, GetOrderByIdQuery.Fulfilments fulfilments) {
        List<Fulfilment> fulfilmentEntities = new ArrayList<>();
        if (fulfilments != null
            && CollectionUtils.isNotEmpty(fulfilments.fulfilmentEdges())
        ) {
            for (GetOrderByIdQuery.FulfilmentEdge fulfilmentEdge : fulfilments.fulfilmentEdges()) {
                fulfilmentEntities.add(Fulfilment.from(order.id, fulfilmentEdge.fulfilmentNode()));
            }
        }
        order.fulfilments = fulfilmentEntities;
    }

    private static void mapFulfilmentChoice(Order.Builder order, GetOrderByIdQuery.FulfilmentChoice fulfilmentChoice) {
        order.deliveryType(fulfilmentChoice.deliveryType() != null ? fulfilmentChoice.deliveryType() : null);
        order.pickupLocationRef(fulfilmentChoice.pickupLocationRef() != null ? fulfilmentChoice.pickupLocationRef() : null);
        if (fulfilmentChoice.deliveryAddress() != null) {
            mapDeliveryAddress(order, fulfilmentChoice.deliveryAddress());
        }
    }

    private static void mapDeliveryAddress(Order.Builder order, GetOrderByIdQuery.DeliveryAddress deliveryAddress) {
        order.deliveryAddressId(deliveryAddress.id() != null ? deliveryAddress.id() : null);
        order.deliveryAddressRef(deliveryAddress.ref() != null ? deliveryAddress.ref() : null);
        order.deliveryAddressType(deliveryAddress.type() != null ? deliveryAddress.type() : null);
        order.deliveryAddressName(deliveryAddress.name() != null ? deliveryAddress.name() : null);
        order.deliveryAddressCompanyName(deliveryAddress.companyName() != null ? deliveryAddress.companyName() : null);
        order.deliveryAddressStreet(deliveryAddress.street() != null ? deliveryAddress.street() : null);
        order.deliveryAddressCity(deliveryAddress.city() != null ? deliveryAddress.city() : null);
        order.deliveryAddressState(deliveryAddress.state() != null ? deliveryAddress.state() : null);
        order.deliveryAddressPostcode(deliveryAddress.postcode() != null ? deliveryAddress.postcode() : null);
        order.deliveryAddressRegion(deliveryAddress.region() != null ? deliveryAddress.region() : null);
        order.deliveryAddressCountry(deliveryAddress.country() != null ? deliveryAddress.country() : null);
        order.deliveryAddressLongitude(deliveryAddress.longitude() != null ? deliveryAddress.longitude() : null);
        order.deliveryAddressLatitude(deliveryAddress.latitude() != null ? deliveryAddress.latitude() : null);
    }


    private static Map<String, Object> mapAttributes(GetOrderByIdQuery.OrderById orderById) {
        if (orderById == null || CollectionUtils.isEmpty(orderById.orderAttributes())) return new HashMap<>();
        return orderById.orderAttributes().stream()
                .collect(Collectors.toMap(GetOrderByIdQuery.OrderAttribute::name, GetOrderByIdQuery.OrderAttribute::value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order that = (Order) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
