package com.fluentcommerce.rule.fulfilmentOption;

import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.service.SettingService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.GeoUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.api.model.location.Coordinates;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.PROP_EVENT_NAME;
import static com.fluentcommerce.util.Constants.Setting.SETTING_GEOCODER_API_KEY_SETTING;
import static com.fluentcommerce.util.GeoUtils.buildAddressString;

@RuleInfo(name = "CalculateCoordinatesForDeliveryAddressFO", description = "This rule calculates and sets the "
	+ "longitude and latitude based on the delivery address provided. Sends event {" + PROP_EVENT_NAME + "}.",
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

@ParamString(name = PROP_EVENT_NAME, description = "Event to be triggered.")
@EventAttribute(name = EVENT_FIELD_ADDRESS_LINE1)
@EventAttribute(name = EVENT_FIELD_ADDRESS_LINE2)
@EventAttribute(name = EVENT_FIELD_CITY)
@EventAttribute(name = EVENT_FIELD_STATE)
@EventAttribute(name = EVENT_FIELD_POSTCODE)
@EventAttribute(name = EVENT_FIELD_COUNTRY)

@Slf4j
public class CalculateCoordinatesForDeliveryAddressFO extends BaseRule {

	private static final String CLASS_NAME = CalculateCoordinatesForDeliveryAddressFO.class.getSimpleName();

	@Override
	public void execute(ContextWrapper context) {
		final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
		log.info(logPrefix + " - Incoming event :{}", context.getEvent());

		String eventName = context.getProp(PROP_EVENT_NAME);

		String addressLine1 = context.getEvent().getAttribute(EVENT_FIELD_ADDRESS_LINE1);
		String addressLine2 = context.getEvent().getAttribute(EVENT_FIELD_ADDRESS_LINE2);
		String street = StringUtils.EMPTY;
		if(StringUtils.isNotBlank(addressLine1)) {
			street = street + addressLine1;
		}
		if(StringUtils.isNotBlank(addressLine2)) {
			street = street + addressLine2;
		}
		String city = context.getEvent().getAttribute(EVENT_FIELD_CITY);
		String state = context.getEvent().getAttribute(EVENT_FIELD_STATE);
		String postcode = context.getEvent().getAttribute(EVENT_FIELD_POSTCODE);
		String country = context.getEvent().getAttribute(EVENT_FIELD_COUNTRY);

		SettingService settingService = new SettingService(context);
		String apiKey = settingService.getSettingValue(SETTING_GEOCODER_API_KEY_SETTING, "N/A");
		Coordinates coordinates = GeoUtils.getCoordinatesByAddress(buildAddressString(street, city, state, postcode, country), apiKey);

		Map<String, Object> attributes = context.getEvent().getAttributes();
		attributes.put(EVENT_FIELD_LONGITUDE, coordinates.getLongitude());
		attributes.put(EVENT_FIELD_LATITUDE, coordinates.getLatitude());
		EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
	}
}
