package com.fluentcommerce.service;

import com.fluentcommerce.commonv2.graphql.mutation.customer.UpdateCustomerAddressMutation;
import com.fluentcommerce.commonv2.graphql.mutation.order.UpdateOrderMutation;
import com.fluentcommerce.commonv2.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.commonv2.graphql.type.*;
import com.fluentcommerce.exceptions.NoFulfilmentFoundException;
import com.fluentcommerce.exceptions.NoOrderFoundException;
import com.fluentcommerce.model.fulfilment.Fulfilment;
import com.fluentcommerce.model.fulfilment.FulfilmentItem;
import com.fluentcommerce.model.order.Order;
import com.fluentcommerce.model.order.OrderItem;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.util.Constants;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.exceptions.RubixException;
import com.fluentretail.rubix.exceptions.RuleExecutionException;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.fluentcommerce.util.Constants.DEFAULT_HALF_PAGE_SIZE;
import static com.fluentcommerce.util.Constants.DEFAULT_PAGE_SIZE;
import static java.lang.String.format;

@Slf4j
public class OrderService {

    private static final String CLASS_NAME = OrderService.class.getSimpleName();

    private Context context;

    public OrderService(Context context) {
        this.context =  context;
    }

    public Order getOrderByIdOrFail(String orderId) {
        if (StringUtils.isBlank(orderId))
            throw new RuleExecutionException("order id blank", context.getEvent());

        GetOrderByIdQuery query = GetOrderByIdQuery.builder()
            .id(orderId)
            .includeOrderItems(true)
            .includeFulfilmentChoice(true)
            .includeCustomer(true)
            .includeOrderAttributes(false)
            .includeOrderProductAttributes(false)
            .includeFulfilments(false)
            .includeFulfilmentAttributes(false)
            .includeFulfilmentItems(false)
            .includeFulfilmentOrderItems(false)
            .orderItemCount(DEFAULT_PAGE_SIZE)
            .build();
        GetOrderByIdQuery.Data data = (GetOrderByIdQuery.Data) context.api().query(query);

        if (data == null) throw NoOrderFoundException.id(orderId, context.getEvent());
        if (data.orderById() == null) throw NoOrderFoundException.id(orderId, context.getEvent());
        return Order.from(data.orderById());
    }

    public List<GetOrderByIdQuery.OrderAttribute> getOrderAttributes(String orderId) {
        if (StringUtils.isBlank(orderId))
            throw new RuleExecutionException("order id blank", context.getEvent());

        GetOrderByIdQuery query = GetOrderByIdQuery.builder()
                .id(orderId)
                .includeOrderItems(false)
                .includeFulfilmentChoice(false)
                .includeCustomer(false)
                .includeOrderAttributes(true)
                .includeOrderProductAttributes(false)
                .includeFulfilments(false)
                .includeFulfilmentAttributes(false)
                .includeFulfilmentItems(false)
                .includeFulfilmentOrderItems(false)
                .build();
        GetOrderByIdQuery.Data data = (GetOrderByIdQuery.Data) context.api().query(query);

        if (data == null) throw NoOrderFoundException.id(orderId, context.getEvent());
        if (data.orderById() == null) throw NoOrderFoundException.id(orderId, context.getEvent());

        return data.orderById().orderAttributes() == null ? new ArrayList<GetOrderByIdQuery.OrderAttribute>() :
                data.orderById().orderAttributes();
    }

    public void updateOrderAttributes(List<AttributeInput> attributeInputList){
        UpdateOrderInput orderInput = UpdateOrderInput.builder()
                .id(context.getEvent().getEntityId())
                .attributes(attributeInputList)
                .build();
        UpdateOrderMutation orderMutation = UpdateOrderMutation.builder().input(orderInput).build();
        context.action().mutation(orderMutation);
    }

    public Order getOrderByIdWithItemsAndFulfilments(String orderId) {
        if (StringUtils.isBlank(orderId))
            throw new RuleExecutionException("order id blank", context.getEvent());

        GetOrderByIdQuery query = GetOrderByIdQuery.builder()
            .id(orderId)
            .includeOrderItems(true)
            .includeFulfilmentChoice(true)
            .includeCustomer(false)
            .includeOrderAttributes(false)
            .includeOrderProductAttributes(false)
            .includeFulfilments(true)
            .includeFulfilmentAttributes(false)
            .includeFulfilmentItems(true)
            .includeFulfilmentOrderItems(true)
            .orderItemCount(DEFAULT_PAGE_SIZE)
            .fulfilmentCount(DEFAULT_HALF_PAGE_SIZE)
            .fulfilmentItemCount(DEFAULT_PAGE_SIZE)
            .build();
        GetOrderByIdQuery.Data data = (GetOrderByIdQuery.Data) context.api().query(query);

        if (data == null) throw NoFulfilmentFoundException.id(orderId, context.getEvent());
        if (data.orderById() == null) throw NoFulfilmentFoundException.id(orderId, context.getEvent());
        return Order.from(data.orderById());
    }

    public void updateOrderCoordinates(String deliveryAddressId, Double longitude, Double latitude) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        UpdateCustomerAddressInput updateCustomerAddress = UpdateCustomerAddressInput.builder()
            .id(deliveryAddressId)
            .latitude(latitude)
            .longitude(longitude)
            .build();
        log.info("{} - Updating order with id:{} latitude:{} longitude:{}",
            logPrefix, context.getEvent().getEntityId(), latitude, longitude);
        context.action().mutation(UpdateCustomerAddressMutation.builder().input(updateCustomerAddress).build());

    }

    public Map<String, Integer> getUnfulfilledItems(
        @Nonnull Order order,
        @Nonnull List<String> excludedFulfilmentStatuses) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        if (order == null || CollectionUtils.isEmpty(order.getItems())) {
            log.error("{} - required order data with id:{} is null. order, orderById, orderItems or orderItemsEdges is null:{}",
                logPrefix, context.getEvent().getRootEntityId(), order);
            throw new RubixException(404,
                format("%s - required order data with id:%s is null. order, orderById, orderItems or orderItemsEdges is null: %s",
                    logPrefix, context.getEvent().getRootEntityId(), order));
        }

        final Map<String, Integer> remainingProductsToFulfil = new ConcurrentHashMap<>();
        for (OrderItem orderItem : order.getItems()) {
            getOrderItems(remainingProductsToFulfil, orderItem);
        }
        log.info("{} - order item products & quantities in the order with id:{} are:{}", logPrefix, order.getId(), remainingProductsToFulfil);
        if (CollectionUtils.isEmpty(order.getFulfilments())) {
            log.info("{} - no fulfilments present for order id:{}", logPrefix, order.getId());
        } else {
            log.info("{} - found {} fulfilments for order id:{}", logPrefix, order.getFulfilments().size(), order.getId());
            for (Fulfilment fulfilment : order.getFulfilments()) {
                log.info("{} - checking fulfilment with id:{} with status:{} for exclusion for order id:{}. "
                        + "remainingProductsToFulfil:{}, excludedFulfilmentStatuses:{}",
                    logPrefix, fulfilment.getId(), fulfilment.getStatus(), order.getId(), remainingProductsToFulfil,
                    excludedFulfilmentStatuses);
                filterByExcludedFulfilmentStatuses(
                    order,
                    fulfilment,
                    remainingProductsToFulfil,
                    excludedFulfilmentStatuses
                );
                log.info("{} - checked fulfilment with id:{} with status:{} for exclusion for order id:{}. "
                        + "remainingProductsToFulfil:{}, excludedFulfilmentStatuses:{}",
                    logPrefix, fulfilment.getId(), fulfilment.getStatus(), order.getId(), remainingProductsToFulfil,
                    excludedFulfilmentStatuses);
            }
        }
        log.info("{} - remaining unfulfilled items are:{}", logPrefix, remainingProductsToFulfil);
        return remainingProductsToFulfil;
    }

    public List<CreateFulfilmentItemWithFulfilmentInput> getFulfilledItems(
        Order order,
        Map<String, Integer> unfulfilledItems,
        List<VirtualPosition> virtualPositions) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        final List<CreateFulfilmentItemWithFulfilmentInput> items = new ArrayList<>();
        if (order == null || CollectionUtils.isEmpty(order.getItems())) {
            log.error("{} - order is null or no order items found for order id:{}",
                logPrefix, context.getEvent().getRootEntityId());

            return null;
        }
        if (virtualPositions == null || CollectionUtils.isEmpty(virtualPositions)) {
            log.info("{} - virtual positions are null or empty for order id:{}", logPrefix, order.getId());
            return null;
        }

        for (OrderItem orderItem : order.getItems()) {
            if (!unfulfilledItems.containsKey(orderItem.getProductRef())) {
                log.info("{} - order item with productRef:{} is already fulfilled in order id:{}.",
                    logPrefix, orderItem.getProductRef(), order.getId());

                continue;
            }

            for (VirtualPosition virtualPosition : virtualPositions) {
                if(StringUtils.equals(virtualPosition.getProductRef(), orderItem.getProductRef())) {
                    log.info("{} - matched productRef:{}  with virtualPositions:{} for order id:{} with unfulfilledItems:{}",
                        logPrefix, orderItem.getProductRef(), virtualPosition, order.getId(), unfulfilledItems);
                    Integer requestedQuantity = unfulfilledItems.get(orderItem.getProductRef());
                    //fulfil whatever is possible
                    if (virtualPosition.getQuantity() < requestedQuantity) {
                        requestedQuantity = virtualPosition.getQuantity();
                    }
                    log.info("{} - fulfilled items ref:{} requestedQty:{}",
                        logPrefix, virtualPosition.getProductRef(), requestedQuantity);
                    items.add(CreateFulfilmentItemWithFulfilmentInput.builder()
                        .ref(virtualPosition.getProductRef())
                        .orderItem(
                            OrderItemId.builder().id(orderItem.getId()).build())
                        .requestedQuantity(requestedQuantity).build());
                }
            }
        }
        return items;
    }

    private static void getOrderItems(final Map<String, Integer> remainingVariantProductsToFulfil, OrderItem orderItem) {
        final Integer qty = remainingVariantProductsToFulfil.get(orderItem.getProductRef());
        if (qty != null) {
            remainingVariantProductsToFulfil.put(orderItem.getProductRef(), qty + orderItem.getQuantity());
        } else {
            remainingVariantProductsToFulfil.put(orderItem.getProductRef(), orderItem.getQuantity());
        }
    }

    private void filterByExcludedFulfilmentStatuses(
        @Nonnull Order order,
        @Nonnull final Fulfilment fulfilment,
        @Nonnull final Map<String, Integer> remainingVariantProductsToFulfil,
        @Nonnull final List<String> excludedFulfilmentStatuses
    ) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        if (fulfilment == null || CollectionUtils.isEmpty(fulfilment.getItems())) {
            log.error("{} - fulfilment or fulfilmentItems are null:{} for order:{}", logPrefix, fulfilment, order.getId());
            throw new RubixException(404,
                format("%s - fulfilment or fulfilmentItems are null:%s for order:%s",
                    logPrefix, context.getEvent().getRootEntityId(), order));
        }
        final String fulfilmentStatus = fulfilment.getStatus();
        for (FulfilmentItem fulfilmentItem : fulfilment.getItems()) {
            final Integer qty = remainingVariantProductsToFulfil.get(fulfilmentItem.getRef());
            if (qty != null) {
                if (CollectionUtils.isNotEmpty(excludedFulfilmentStatuses)
                    && excludedFulfilmentStatuses.contains(fulfilmentStatus)) {
                    log.info("{} - fulfilment item ref:{} for fulfilment id:{} and status:{} is part of excluded statuses:{}.",
                        logPrefix, fulfilmentItem.getRef(), fulfilment.getId(), fulfilmentStatus, excludedFulfilmentStatuses
                    );
                    remainingVariantProductsToFulfil.put(
                        fulfilmentItem.getRef(),
                        qty - fulfilmentItem.getRequestedQuantity()
                    );
                } else {
                    log.info("{} - fulfilment item ref:{} for fulfilment id:{} and status:{} is not part of excluded statuses:{}.",
                        logPrefix, fulfilmentItem.getRef(), fulfilment.getId(), fulfilmentStatus, excludedFulfilmentStatuses
                    );
                    remainingVariantProductsToFulfil.put(
                        fulfilmentItem.getRef(),
                        qty - (fulfilmentItem.getRequestedQuantity() - fulfilmentItem.getRejectedQuantity()));
                }
                if (Constants.ZERO.equals(remainingVariantProductsToFulfil.get(fulfilmentItem.getRef()))) {
                    remainingVariantProductsToFulfil.remove(fulfilmentItem.getRef());
                }
            }
        }
    }

    public boolean isMaxSplitLimitReached(@Nonnull final List<Fulfilment> fulfilments,
        final int maxSplitLimit,
        @Nullable final List<String> excludedFulfilmentStatuses) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        int validFulfilmentCount;
        if (CollectionUtils.isEmpty(excludedFulfilmentStatuses)) {
            validFulfilmentCount = (int) fulfilments.stream().count();
        } else {
            validFulfilmentCount = (int) fulfilments.stream().filter(
                fulfilment -> !excludedFulfilmentStatuses.contains(fulfilment.getStatus())
            ).count();
        }
        log.info("{} - Fulfilment count: {} and MaxSplitLimit: {} ",logPrefix, validFulfilmentCount, maxSplitLimit);
        return validFulfilmentCount > maxSplitLimit;
    }

}
