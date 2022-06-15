package com.fluentcommerce.util;

import com.fluentretail.api.model.setting.RetailerSetting;
import com.fluentretail.rubix.context.Context;
import com.fluentretail.rubix.exceptions.RubixException;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static com.fluentcommerce.util.Constants.ErrorCode.ERROR_CODE_400;
import static com.fluentcommerce.util.Constants.Setting.SETTING_CONTEXT_ACCOUNT;
import static com.fluentcommerce.util.Constants.Setting.SETTING_CONTEXT_RETAILER;

@Slf4j
@Deprecated
public class SettingUtilsV1 {

    private static final String CLASS_NAME = SettingUtilsV1.class.getSimpleName();

    /**
     * Look for setting at retailer context and then at account context.
     * @param context
     * @param settingName
     * @return
     */
    @Deprecated
    public static String getSetting(Context context, String settingName) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        String value = getSetting(context, SETTING_CONTEXT_RETAILER, context.getEvent().getRetailerId(), settingName);
        if (value == null) {
            value = getSetting(context, SETTING_CONTEXT_ACCOUNT, context.getEvent().getAccountId(), settingName);
            log.info("{} - Setting Key=[{}] loaded from ACCOUNT context value=[{}]", logPrefix, settingName, value);
        } else {
            log.info("{} - Setting Key=[{}] loaded from RETAILER context value=[{}]", logPrefix, settingName, value);
        }
        return value;
    }

    @Deprecated
    public static String getSetting(Context context, String settingContext, String contextKey, String settingName) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        RetailerSetting.List settings = context.api().getSettings(settingContext, contextKey, ImmutableList.of(settingName));
        if (settings != null && CollectionUtils.isNotEmpty(settings.getSettings())) {
            RetailerSetting retailerSetting = settings.getSettings().stream()
                    .filter(setting -> setting.getKey().equalsIgnoreCase(settingName))
                    .findAny()
                    .orElse(null);
            if (retailerSetting != null) {
                return (String) retailerSetting.getValue();
            }
        } else {
            log.warn("{} - Cannot find Setting Key=[{}] in context=[{}], contextKey=[{}]",
                logPrefix, settingName, settingContext, contextKey);
        }
        return null;
    }

    @Deprecated
    public static Map<String, Object> getJsonSetting(Context context, String settingName) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        log.info("{} - getting setting for retailer with name:{}", logPrefix, settingName);
        String retailerId = context.getEvent().getRetailerId();
        RetailerSetting.List retailerSetting = context.api().getSettings(SETTING_CONTEXT_RETAILER, retailerId,
            Collections.singletonList(settingName));
        Optional<RetailerSetting> option = retailerSetting.getSettings().stream().findFirst();
        if (option.isPresent()) {
            Map<String, Object> retailerSettingMap = (Map<String, Object>) option.get().getValue();
            log.info("{} - json setting name: {}, mapValue: {}", logPrefix, settingName, retailerSettingMap);
            return retailerSettingMap;
        } else {
            log.error("{} - retailer setting '{}' not found in for retailerId {}.", logPrefix, settingName, retailerId);
            throw new RubixException(ERROR_CODE_400,
                String.format("[%s] retailer setting '%s' not found  for retailerId %s.", logPrefix, settingName, retailerId));
        }
    }

    @Deprecated
    public static String getSetting(Context context, String retailerId, String key) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        final RetailerSetting.List retailerSettings = context.api()
            .getRetailerSettings(retailerId, Collections.singletonList(key));

        if (null != retailerSettings && CollectionUtils.isNotEmpty(retailerSettings.getSettings())) {

            final RetailerSetting retailerSetting = retailerSettings.getSettings().stream()
                .filter(setting -> setting.getKey()
                    .equalsIgnoreCase(key)).findAny().orElse(null);

            if (retailerSetting != null) {
                return (String) retailerSetting.getValue();
            }
        } else {
            log.info("{} - Could not find any RetailerSetting with key=[{}]", logPrefix, key);
        }
        return null;
    }
}
