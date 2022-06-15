package com.fluentcommerce.util.email;

import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.model.fulfilment.Fulfilment;
import com.fluentcommerce.model.order.Order;
import com.fluentcommerce.service.FulfilmentService;
import com.fluentcommerce.service.LocationService;
import com.fluentcommerce.service.OrderService;
import com.fluentcommerce.util.DateUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.v2.context.Context;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.Map;

import static com.fluentcommerce.util.email.TemplateVariables.*;

@FunctionalInterface
public interface CompileTemplateFunction {

    String INTERFACE_NAME = "CompileTemplateFunction";

    Logger log = LoggerFactory.getLogger(CompileTemplateFunction.class.getName());

    void apply(String entityId, Context context, Map<String, Object> templateVariables);

    CompileTemplateFunction INIT_ORDER =
        (orderId, context, templateVariables) -> {
            final String logPrefix = RuleUtils.buildLogPrefix(INTERFACE_NAME, context.getEvent());
            OrderService orderService = new OrderService(context);
            Order order = orderService.getOrderByIdOrFail(orderId);

            templateVariables.put(ORDER_NUMBER, order.getRef());
            templateVariables.put(ORDER_CREATED_ON, DateUtils.formatDateTime(order.getCreatedOn(), ZoneId.of("Australia/Victoria")));
            templateVariables.put(CUSTOMER_FIRST_NAME, order.getCustomer().getFirstName());
            templateVariables.put(CUSTOMER_LAST_NAME, order.getCustomer().getLastName());
            templateVariables.put(CUSTOMER_FULL_NAME, order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
            templateVariables.put(CUSTOMER_CONTACT_NUMBER, order.getCustomer().getPrimaryPhone());
            templateVariables.put(CUSTOMER_EMAIL, order.getCustomer().getPrimaryEmail());
        };

    CompileTemplateFunction INIT_LOCATION =
        (fulfilmentId, context, templateVariables) -> {
            final String logPrefix = RuleUtils.buildLogPrefix(INTERFACE_NAME, context.getEvent());

            LocationService locationService = new LocationService(context);
            FulfilmentService fulfilmentService = new FulfilmentService(context);
            Fulfilment fulfilment = fulfilmentService.getFulfilmentByIdOrFail(fulfilmentId);

            if (StringUtils.isNotEmpty(fulfilment.getFromAddressRef())) {
                final GetLocationByRefQuery.Location locationByRef = locationService
                    .getLocationByRefOrFail(fulfilment.getFromAddressRef());

                if (locationByRef != null) {
                    templateVariables.put(LOCATION_NAME, locationByRef.name());
                    templateVariables.put(LOCATION_PHONE, locationByRef.supportPhoneNumber());

                    final GetLocationByRefQuery.PrimaryAddress address = locationByRef.primaryAddress();
                    if (address != null) {
                        templateVariables.put(LOCATION_PRIMARYLOCATION_STREET, address.street());
                        templateVariables.put(LOCATION_PRIMARYLOCATION_CITY, address.city());
                        templateVariables.put(LOCATION_PRIMARYLOCATION_STATE, address.state());
                        templateVariables.put(LOCATION_PRIMARYLOCATION_POSTCODE, address.postcode());
                        templateVariables.put(LOCATION_PRIMARYLOCATION_COUNTRY, address.country());
                    }

                    final GetLocationByRefQuery.OpeningSchedule openingHours = locationByRef.openingSchedule();
                    if (openingHours != null) {
                        templateVariables.put(DayOfWeek.MONDAY.name().toLowerCase(), DateUtils.formatOpeningHours(
                            String.valueOf(openingHours.monStart()), String.valueOf(openingHours.monEnd())));
                        templateVariables.put(DayOfWeek.TUESDAY.name().toLowerCase(), DateUtils.formatOpeningHours(
                            String.valueOf(openingHours.tueStart()), String.valueOf(openingHours.tueEnd())));
                        templateVariables
                            .put(DayOfWeek.WEDNESDAY.name().toLowerCase(), DateUtils.formatOpeningHours(
                                String.valueOf(openingHours.wedStart()),
                                String.valueOf(openingHours.wedEnd())));
                        templateVariables.put(DayOfWeek.THURSDAY.name().toLowerCase(), DateUtils.formatOpeningHours(
                            String.valueOf(openingHours.thuStart()), String.valueOf(openingHours.thuEnd())));
                        templateVariables.put(DayOfWeek.FRIDAY.name().toLowerCase(), DateUtils.formatOpeningHours(
                            String.valueOf(openingHours.friStart()), String.valueOf(openingHours.friEnd())));
                        templateVariables.put(DayOfWeek.SATURDAY.name().toLowerCase(), DateUtils.formatOpeningHours(
                            String.valueOf(openingHours.satStart()), String.valueOf(openingHours.satEnd())));
                        templateVariables.put(DayOfWeek.SUNDAY.name().toLowerCase(), DateUtils.formatOpeningHours(
                            String.valueOf(openingHours.sunStart()), String.valueOf(openingHours.sunEnd())));
                    }
                }
            }
        };
}