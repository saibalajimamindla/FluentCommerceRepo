package com.fluentcommerce.rule.order;

import com.fluentcommerce.model.order.Order;
import com.fluentcommerce.service.OrderService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import com.fluentretail.rubix.v2.context.Context;
import com.fluentretail.rubix.v2.rule.Rule;
import lombok.extern.slf4j.Slf4j;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.PropertyField.*;


@RuleInfo(
        name = "SendEventOnIdentifyingDeliveryType",
        description =  "Forwards the event to SD Network event {" + SD_EVENT_NAME + "}"+ " or to SD Network event {"+ ED_EVENT_NAME +"}"
        +"based on the order delivery type by Standard Delivery type value {"+STANDARD_DELIVERY_TYPE+"} Express Delivery type value {"+Express_DELIVERY_TYPE+"}",
        accepts = {
                @EventInfo(
                        entityType = ENTITY_TYPE_ORDER
                )
        }
)
@ParamString(name = SD_EVENT_NAME, description = "The name of event to be triggered for standard delivery")
@ParamString(name = ED_EVENT_NAME, description = "The name of event to be triggered for express delivery")
@ParamString(name = STANDARD_DELIVERY_TYPE, description = "The value of standard delivery type")
@ParamString(name = Express_DELIVERY_TYPE, description = "The value of express delivery type")
@Slf4j
public class SendEventOnIdentifyingDeliveryType implements Rule {

    private static final String CLASS_NAME = SendEventOnIdentifyingDeliveryType.class.getSimpleName();

    @Override
    public <C extends Context> void run(C context) {

        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info("{} - Incoming event :{}", logPrefix, context.getEvent());
        String SdEventName = context.getProp(SD_EVENT_NAME);
        String EdEventName = context.getProp(ED_EVENT_NAME);

        String standardDeliveryTypeValue = context.getProp(STANDARD_DELIVERY_TYPE);
        String expressDeliveryTypeValue = context.getProp(Express_DELIVERY_TYPE);

        OrderService orderService = new OrderService(context);
        Order order = orderService.getOrderByIdOrFail(context.getEvent().getEntityId());
        if(order.getDeliveryType().equalsIgnoreCase(standardDeliveryTypeValue))
        {
            EventUtils.forwardInlineEvent(context, SdEventName);
        }else {
            EventUtils.forwardInlineEvent(context, EdEventName);
        }
    }
}
