package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.commonv2.graphql.query.fulfilmentOption.GetFulfilmentOptionByIdQuery;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentOption;
import com.fluentcommerce.model.fulfilmentOption.Product;
import com.fluentcommerce.service.FulfilmentOptionService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.EventInfoVariables;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static com.fluentcommerce.util.CommonUtils.convertDtoToMap;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_PRODUCTS;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.FulfilmentOptionUtils.mapFulfilmentOptionProductsToDto;
import static com.fluentcommerce.util.FulfilmentOptionUtils.mapFulfilmentOptionToDto;

/**
 * @author Holger
 */
@RuleInfo(
    name = "LoadFulfilmentOptionFO",
    description = "Loads the fulfilment option into memory and sends event {" + PROP_EVENT_NAME + "}.",
    accepts = {
        @EventInfo(entityType = ENTITY_TYPE_FULFILMENT_OPTIONS)
    },
    produces = {
        @EventInfo(
            eventName = "{" + PROP_EVENT_NAME + "}",
            entityType = EventInfoVariables.EVENT_TYPE,
            entitySubtype = EventInfoVariables.EVENT_SUBTYPE,
            status = EventInfoVariables.EVENT_STATUS)
    }
)

@ParamString(name = PROP_EVENT_NAME, description = "The event name triggered by this rule")
@Slf4j
public class LoadFulfilmentOptionFO extends BaseRule {

    private static final String CLASS_NAME = LoadFulfilmentOptionFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info(logPrefix + " - Incoming event :{}", context.getEvent());

        final String eventName = context.getProp(PROP_EVENT_NAME);

        final String fulfilmentOptionId = context.getEvent().getEntityId();

        FulfilmentOptionService fulfilmentOptionService = new FulfilmentOptionService(context);
        GetFulfilmentOptionByIdQuery.FulfilmentOptionById fulfilmentOptionById =
            fulfilmentOptionService.getFulfilmentOptionByIdOrFail(fulfilmentOptionId);

        FulfilmentOption fulfilmentOption = mapFulfilmentOptionToDto(context, fulfilmentOptionById);

        Map<String, Object> attributes = convertDtoToMap(fulfilmentOption);
        List<Product> products = mapFulfilmentOptionProductsToDto(context, fulfilmentOptionById);
        attributes.put(EVENT_FIELD_PRODUCTS, products);
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }
}
