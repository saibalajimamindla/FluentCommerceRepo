package com.fluentcommerce.rule.fulfilmentOption;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fluentcommerce.common.BaseRule;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlan;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentPlanFulfilment;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.setting.Setting;
import com.fluentcommerce.service.SettingService;
import com.fluentcommerce.util.EventUtils;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.rule.meta.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.fluentcommerce.util.CommonUtils.convertObjectToDto;
import static com.fluentcommerce.util.Constants.EntitySubType.ENTITY_SUBTYPE_ORDER_CC;
import static com.fluentcommerce.util.Constants.EntitySubType.ENTITY_SUBTYPE_ORDER_HD;
import static com.fluentcommerce.util.Constants.EntityType.ENTITY_TYPE_FULFILMENT_OPTIONS;
import static com.fluentcommerce.util.Constants.EventField.*;
import static com.fluentcommerce.util.Constants.PropertyField.*;
import static com.fluentcommerce.util.Constants.Setting.SETTING_CONTEXT_AGENT;

/**
 * @author Holger
 */
@RuleInfo(
    name = "CalculateEtaFO",
    description = "Calculates the eta of each fulfilment plan and fulfilment"
        + " based on the locations {" + PROP_PICK_N_PACK_TIME_LIMIT_SETTING + "} setting "
        + "or default eta (inter-store transfer) {" + PROP_DEFAULT_ETA + "}."
        + "Sends event {" + PROP_EVENT_NAME + "}.",
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
@ParamString(name = PROP_PICK_N_PACK_TIME_LIMIT_SETTING, description = "The pick and pack time limit setting")
@ParamInteger(name = PROP_DEFAULT_ETA, description = "The default eta")
@EventAttribute(name = EVENT_FIELD_FULFILMENT_PLANS)
@EventAttribute(name = EVENT_FIELD_LOCATIONS)
@EventAttribute(name = EVENT_FIELD_PICKUP_LOCATION_REF)
@EventAttribute(name = EVENT_FIELD_ORDER_TYPE)
@Slf4j
public class CalculateEtaFO extends BaseRule {

    private static final String CLASS_NAME = CalculateEtaFO.class.getSimpleName();

    @Override
    public void execute(ContextWrapper context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info("{} - Incoming event :{}", logPrefix, context.getEvent());

        String eventName = context.getProp(PROP_EVENT_NAME);
        Integer defaultEta = context.getProp(PROP_DEFAULT_ETA, Integer.class);
        String pickAndPackTimeLimitSettingName = context.getProp(PROP_PICK_N_PACK_TIME_LIMIT_SETTING);

        List<FulfilmentPlan> fulfilmentPlans =
            context.getEvent().getAttribute(EVENT_FIELD_FULFILMENT_PLANS, List.class);
        Map<String, Location> locationsMap = convertObjectToDto(
            context.getEvent().getAttribute(EVENT_FIELD_LOCATIONS, Map.class),
            new TypeReference<Map<String, Location>>() {
            }
        );
        String pickupLocationRef = context.getEvent().getAttribute(EVENT_FIELD_PICKUP_LOCATION_REF);
        String orderType = context.getEvent().getAttribute(EVENT_FIELD_ORDER_TYPE);

        SettingService settingService = new SettingService(context);
        List<Integer> locationIds = locationsMap.values().stream()
            .map(location -> Integer.parseInt(location.getId())).collect(Collectors.toList());

        List<Setting> pickNPackTimeLimitSettings = settingService.getSettings(
            pickAndPackTimeLimitSettingName, SETTING_CONTEXT_AGENT, locationIds);

        Map<Integer, String> pickNPackTimeLimitSettingsMap = pickNPackTimeLimitSettings.stream()
            .collect(Collectors.toMap(Setting::getContextId, Setting::getValue));
        List<FulfilmentPlan> updatedFulfilmentPlanList = new ArrayList<>();

        for (FulfilmentPlan fulfilmentPlan : fulfilmentPlans) {
            List<FulfilmentPlanFulfilment> updatedFulfilmentPlanFulfilmentList = new ArrayList<>();
            Integer maxEta = -1;
            for (FulfilmentPlanFulfilment fulfilmentPlanFulfilment : fulfilmentPlan.getFulfilments()) {
                if (StringUtils.equals(orderType, ENTITY_SUBTYPE_ORDER_HD)
                    || (StringUtils.equals(orderType, ENTITY_SUBTYPE_ORDER_CC)
                        && StringUtils.equals(pickupLocationRef, fulfilmentPlanFulfilment.getLocationRef())
                )) {
                    Integer locationId = Integer
                        .parseInt(locationsMap.get(fulfilmentPlanFulfilment.getLocationRef()).getId());
                    log.info("{} - Retrieving pick and pack time limit for location with id:{}, map:{}",
                        logPrefix, locationId, pickNPackTimeLimitSettingsMap);
                    String pickNPackTimeLimitSetting = pickNPackTimeLimitSettingsMap.get(locationId);
                    Integer eta;
                    if (StringUtils.isBlank(pickNPackTimeLimitSetting)) {
                        eta = defaultEta;
                    } else {
                        eta = Integer.parseInt(pickNPackTimeLimitSetting);
                    }
                    maxEta = eta > maxEta ? eta : maxEta;
                    updatedFulfilmentPlanFulfilmentList.add(fulfilmentPlanFulfilment.toBuilder().eta(eta).build());
                } else {
                    maxEta = defaultEta > maxEta ? defaultEta : maxEta;
                    updatedFulfilmentPlanFulfilmentList.add(
                        fulfilmentPlanFulfilment.toBuilder().eta(defaultEta).build()
                    );
                }
            }
            updatedFulfilmentPlanList.add(fulfilmentPlan.toBuilder()
                .fulfilments(updatedFulfilmentPlanFulfilmentList)
                .eta(maxEta.toString())
                .build());
        }

        Map<String, Object> attributes = context.getEvent().getAttributes();
        attributes.put(EVENT_FIELD_FULFILMENT_PLANS, updatedFulfilmentPlanList);
        EventUtils.forwardInlineEventWithAttributes(context, eventName, attributes);
    }

}
