package com.fluentcommerce.rule.order;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.order.Order;
import com.fluentcommerce.service.OrderService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.EventInfo;
import com.fluentretail.rubix.rule.meta.ParamString;
import com.fluentretail.rubix.rule.meta.RuleInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_ORDER;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LATITUDE;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_LONGITUDE;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;

@RuleInfo(
	name = "ForwardEventWithDeliveryAddressCoordinates",
	description =  "Forwards the event with name {" + PROP_EVENT_NAME + "} containing the longitude & latitude of the "
		+ "delivery address.",
	accepts = {
		@EventInfo(
			entityType = ENTITY_TYPE_ORDER
		)
	}
)
@ParamString(name = PROP_EVENT_NAME, description = "The name of event to be triggered")
@Slf4j
public class ForwardEventWithDeliveryAddressCoordinates extends BaseRule {

	private static final String CLASS_NAME = ForwardEventWithDeliveryAddressCoordinates.class.getSimpleName();

	@Override
	public void execute(ContextWrapper context) {
		final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
		log.info("{} - Incoming event :{}", logPrefix, context.getEvent());

		final String eventName = context.getProp(PROP_EVENT_NAME);

		OrderService orderService = new OrderService(context);
		Order order = orderService.getOrderByIdOrFail(context.getEvent().getEntityId());

		Map<String, Object> attributes = context.getEvent().getAttributes();
		attributes.put(EVENT_FIELD_LONGITUDE, order.getDeliveryAddressLongitude());
		attributes.put(EVENT_FIELD_LATITUDE, order.getDeliveryAddressLatitude());
		EventUtils.forwardEventWithAttributes(context, eventName, attributes);
	}
}
