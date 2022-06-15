package com.fluentcommerce.service;

import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.commonv2.graphql.mutation.fulfilmentOption.CreateFulfilmentPlanMutation;
import com.fluentcommerce.commonv2.graphql.mutation.fulfilmentOption.UpdateFulfilmentPlanMutation;
import com.fluentcommerce.commonv2.graphql.query.fulfilmentOption.GetFulfilmentOptionByIdQuery;
import com.fluentcommerce.commonv2.graphql.query.fulfilmentOption.GetFulfilmentPlanIdByRefQuery;
import com.fluentcommerce.commonv2.graphql.type.*;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlan;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlanFulfilment;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlanFulfilmentItem;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.exceptions.RubixException;
import com.fluentretail.rubix.exceptions.RuleExecutionException;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static com.fluentcommerce.util.Constants.AttributeType.DOUBLE_TYPE;
import static com.fluentcommerce.util.Constants.AttributeType.STRING_TYPE;
import static com.fluentcommerce.util.Constants.DISTANCE;
import static com.fluentcommerce.util.Constants.ErrorCode.ERROR_CODE_404;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_PICKUP_LOCATION_REF;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_TYPE;
import static com.fluentcommerce.util.Constants.PICKUP_LOCATION_REF;

@Slf4j
public class FulfilmentOptionService {

    private static final String CLASS_NAME = FulfilmentOptionService.class.getSimpleName();

    private Context context;

    public FulfilmentOptionService(Context context) {
        this.context = context;
    }

    public GetFulfilmentOptionByIdQuery.FulfilmentOptionById getFulfilmentOptionByIdOrFail(String fulfilmentOptionId) {
        if (StringUtils.isBlank(fulfilmentOptionId))
            throw new RuleExecutionException("fulfilment option id blank", context.getEvent());

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        final GetFulfilmentOptionByIdQuery queryFulfilmentOptionsById = GetFulfilmentOptionByIdQuery.builder()
            .id(fulfilmentOptionId)
            .includeAttributes(true)
            .includeAddress(true)
            .includeProducts(true)
            .includePlans(false)
            .build();
        final GetFulfilmentOptionByIdQuery.FulfilmentOptionById fulfilmentOptionById;
        try {
            log.info(logPrefix + " - retrieving fulfilment option with id: {}", fulfilmentOptionId);
            final GetFulfilmentOptionByIdQuery.Data queryFulfilmentOptionsByData = (GetFulfilmentOptionByIdQuery.Data) context
                .api().query(queryFulfilmentOptionsById);
            if (queryFulfilmentOptionsByData != null && queryFulfilmentOptionsByData.fulfilmentOptionById() != null) {
                fulfilmentOptionById = queryFulfilmentOptionsByData.fulfilmentOptionById();
            } else {
                log.error(logPrefix + " - FULFILMENT_OPTIONS data is null");
                throw new RubixException(ERROR_CODE_404, logPrefix + " FULFILMENT_OPTIONS data for is null");
            }
        } catch (Exception e) {
            log.error(logPrefix + " - Error retrieving fulfilment option with id: {}", fulfilmentOptionId);
            throw new RubixException(ERROR_CODE_404,
                logPrefix + " - Error retrieving fulfilment option with id:" + fulfilmentOptionId);
        }
        return fulfilmentOptionById;
    }

    public Map<String, FulfilmentPlan> createFulfilmentPlans(ContextWrapper context, List<FulfilmentPlan> fulfilmentPlanList) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        Map<String, FulfilmentPlan> createdFulfilmentPlansMap = new HashMap<>();
        List<CreateFulfilmentPlanInput> fulfilmentPlanInputList = new ArrayList<>();
        Double distance = null;
        for (FulfilmentPlan fulfilmentPlan : fulfilmentPlanList) {

            List<FulfilmentPlanFulfilment> fulfilmentPlanFulfilmentList = fulfilmentPlan.getFulfilments();
            if (CollectionUtils.isEmpty(fulfilmentPlanFulfilmentList)) {
                continue;
            }
            String pickupLocationRef = context.getEvent().getAttribute(EVENT_FIELD_PICKUP_LOCATION_REF);

            List<CreateFulfilmentPlanFulfilmentInput> fulfilmentPlanFulfilmentInputList = new ArrayList<>();
            for (FulfilmentPlanFulfilment fulfilmentPlanFulfilment : fulfilmentPlanFulfilmentList) {
                distance = fulfilmentPlanFulfilment.getDistance();
                List<CreateFulfilmentPlanFulfilmentItemInput> fulfilmentItemInputs = new ArrayList<>();
                if (fulfilmentPlanFulfilment.getItems() != null
                    && fulfilmentPlanFulfilment.getItems().size() > 0
                ) {
                    for (FulfilmentPlanFulfilmentItem fulfilmentPlanFulfilmentItem : fulfilmentPlanFulfilment
                        .getItems()) {
                        CreateFulfilmentPlanFulfilmentItemInput fulfilmentItemInput = CreateFulfilmentPlanFulfilmentItemInput
                            .builder()
                            .availableQuantity(fulfilmentPlanFulfilmentItem.getAvailableQuantity())
                            .requestedQuantity(fulfilmentPlanFulfilmentItem.getRequestedQuantity())
                            .productRef(fulfilmentPlanFulfilmentItem.getProductRef()).build();
                        fulfilmentItemInputs.add(fulfilmentItemInput);
                    }
                }
                CreateFulfilmentPlanFulfilmentInput.Builder fulfilmentPlanFulfilmentsInputBuilder = CreateFulfilmentPlanFulfilmentInput
                    .builder()
                    .fulfilmentType(fulfilmentPlanFulfilment.getFulfilmentType())
                    .eta(fulfilmentPlanFulfilment.getEta() != null ? fulfilmentPlanFulfilment.getEta().toString() : null)
                    .locationRef(fulfilmentPlanFulfilment.getLocationRef())
                    .items(fulfilmentItemInputs);
                fulfilmentPlanFulfilmentInputList.add(fulfilmentPlanFulfilmentsInputBuilder.build());
            }

            String uuid = UUID.randomUUID().toString();
            createdFulfilmentPlansMap.put(uuid, fulfilmentPlan);

            CreateFulfilmentPlanInput.Builder createFulfilmentPlanInput = CreateFulfilmentPlanInput.builder()
                .fulfilmentOptionId(FulfilmentOptionId.builder().id(
                    context.getEvent().getEntityId()
                ).build())
                .ref(uuid)
                .retailerId(
                    Integer.parseInt(context.getEvent().getRetailerId())
                )
                .type(context.getEvent().getAttribute(EVENT_FIELD_TYPE))
                .splits(fulfilmentPlanFulfilmentInputList.size() - 1)
                .eta(fulfilmentPlan.getEta())
                .fulfilments(fulfilmentPlanFulfilmentInputList);

            List<AttributeInput> attributesInput = new ArrayList<>();
            if (distance != null){
                AttributeInput distanceAttribute = AttributeInput.builder()
                    .name(DISTANCE)
                    .type(DOUBLE_TYPE)
                    .value(distance / 1000)
                    .build();
                attributesInput.add(distanceAttribute);
            }
            if (StringUtils.isNotBlank(pickupLocationRef)) {
                AttributeInput pickupLocationRefAttribute = AttributeInput.builder()
                    .name(PICKUP_LOCATION_REF)
                    .type(STRING_TYPE)
                    .value(pickupLocationRef)
                    .build();
                attributesInput.add(pickupLocationRefAttribute);
            }

            createFulfilmentPlanInput.attributes(attributesInput);
            fulfilmentPlanInputList.add(createFulfilmentPlanInput.build());
        }

        log.info("{} - Creating fulfilmentPlans for for fulfilmentOption:{}",
            logPrefix, context.getEvent().getEntityId());
        for (CreateFulfilmentPlanInput createFulfilmentPlanInput : fulfilmentPlanInputList) {
            context.action().mutation(CreateFulfilmentPlanMutation.builder()
                .input(createFulfilmentPlanInput)
                .build());
        }

        return createdFulfilmentPlansMap;
    }

    public void updateFulfilmentPlanStatus(Map.Entry<String, FulfilmentPlan> entry) {
        GetFulfilmentPlanIdByRefQuery query = GetFulfilmentPlanIdByRefQuery.builder().ref(Arrays.asList(entry.getKey())).build();
        GetFulfilmentPlanIdByRefQuery.Data data =  (GetFulfilmentPlanIdByRefQuery.Data) context.api().query(query);
        String fulfilmentPlanId = data.fulfilmentPlans().fulfilmentPlanEdge().stream().findFirst().get().fulfilmentPlanNode().id();

        UpdateFulfilmentPlanInput input =  UpdateFulfilmentPlanInput.builder()
            .id(fulfilmentPlanId)
            .status(entry.getValue().getStatus())
            .build();
        context.action().mutation(UpdateFulfilmentPlanMutation.builder().input(input).build());
    }
}
