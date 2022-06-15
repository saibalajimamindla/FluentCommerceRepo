package com.fluentcommerce.service;

import com.fluentcommerce.commonv2.graphql.mutation.fulfilment.CreateFulfilmentMutation;
import com.fluentcommerce.commonv2.graphql.query.fulfilment.GetFulfilmentByIdQuery;
import com.fluentcommerce.commonv2.graphql.type.AddressId;
import com.fluentcommerce.commonv2.graphql.type.CreateFulfilmentInput;
import com.fluentcommerce.commonv2.graphql.type.CreateFulfilmentItemWithFulfilmentInput;
import com.fluentcommerce.commonv2.graphql.type.OrderId;
import com.fluentcommerce.dto.ProposedFulfilment;
import com.fluentcommerce.exceptions.NoFulfilmentFoundException;
import com.fluentcommerce.model.fulfilment.Fulfilment;
import com.fluentcommerce.model.order.Order;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.exceptions.RuleExecutionException;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.UUID;

import static com.fluentcommerce.util.Constants.DEFAULT_PAGE_SIZE;
import static com.fluentcommerce.util.Constants.EntitySubType.ENTITY_SUBTYPE_ORDER_HD;
import static com.fluentcommerce.util.FulfilmentUtils.getFulfilmentType;

@Slf4j
public class FulfilmentService {

    private static final String CLASS_NAME = FulfilmentService.class.getSimpleName();

    private Context context;

    public FulfilmentService(Context context) {
        this.context = context;
    }

    public Fulfilment getFulfilmentByIdOrFail(String fulfilmentId) {
        if (StringUtils.isBlank(fulfilmentId))
            throw new RuleExecutionException("fulfilment id blank", context.getEvent());

        GetFulfilmentByIdQuery query = GetFulfilmentByIdQuery.builder()
            .id(fulfilmentId)
            .includeOrder(true)
            .includeAttributes(true)
            .includeToAddress(true)
            .includeFromAddress(true)
            .includeItems(true)
            .fulfilmentItemsCount(DEFAULT_PAGE_SIZE)
            .build();
        GetFulfilmentByIdQuery.Data data = (GetFulfilmentByIdQuery.Data) context.api().query(query);

        if (data == null) throw NoFulfilmentFoundException.id(fulfilmentId, context.getEvent());
        if (data.fulfilmentById() == null) throw NoFulfilmentFoundException.id(fulfilmentId, context.getEvent());
        return Fulfilment.from(data.fulfilmentById());
    }

    public void createFulfilment(
        Order order,
        ProposedFulfilment proposedFulfilment,
        List<CreateFulfilmentItemWithFulfilmentInput> items) {

        String toAddressId;
        if (StringUtils.equals(order.getType(), ENTITY_SUBTYPE_ORDER_HD)) {
            toAddressId = order.getDeliveryAddressId();
        } else {
            LocationService locationService = new LocationService(context);
            toAddressId = locationService.getStoreAddressByLocationRef(order.getPickupLocationRef()).id();
        }

        String fulfilmentType = getFulfilmentType(order, proposedFulfilment.getLocationType());
        LocationService locationService = new LocationService(context);
        String fromAddressId = locationService.getStoreAddressByLocationRef(proposedFulfilment.getLocationRef()).id();

        final String orderId = order.getId();
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        log.info("{} - Create fulfilment for orderId:{} with fromAddressId:{}, toAddressId:{}, fulfilmentType:{} "
                + "deliveryType:{}, items:{}",
            logPrefix, orderId, fromAddressId, toAddressId, fulfilmentType, order.getDeliveryType(), items);
        CreateFulfilmentInput
            createFulfilmentInput = CreateFulfilmentInput.builder()
            .fromAddress(AddressId.builder().id(fromAddressId).build()).toAddress(AddressId.builder().id(toAddressId).build())
            .type(fulfilmentType)
            .items(items)
            .order(OrderId.builder().id(orderId).build())
            .ref(UUID.randomUUID().toString())
            .deliveryType(order.getDeliveryType())
            .build();
        CreateFulfilmentMutation createFulfilment = CreateFulfilmentMutation.builder().input(createFulfilmentInput).build();
        context.action().mutation(createFulfilment);
    }
}
