package com.fluentcommerce.util.email;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluentcommerce.dto.email.EmailSetting;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.context.Context;
import com.fluentretail.rubix.exceptions.RubixException;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static com.fluentcommerce.util.Constants.ErrorCode.ERROR_CODE_400;
import static com.fluentcommerce.util.Constants.Setting.SETTING_EMAIL_SERVICE_CONFIG;
import static com.fluentcommerce.util.Constants.Setting.SETTING_EMAIL_SERVICE_CONFIG_MANDILL_KEY;
import static com.fluentcommerce.util.SettingUtilsV1.getJsonSetting;

@Slf4j
public class EmailUtils {

    private static final String CLASS_NAME = EmailUtils.class.getSimpleName();

    public static Map<String, Object> getEmailServiceConfig(Context context) {
        return getJsonSetting(context, SETTING_EMAIL_SERVICE_CONFIG);
    }

    public static EmailSetting getEmailConfigSetting(Context context, String configSettingName) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        Map<String, Object> emailConfigMap = getEmailServiceConfig(context);
        if (emailConfigMap.containsKey(configSettingName)) {
            Object obj = emailConfigMap.get(configSettingName);
            log.info("{} - EmailSettingName: {}, Value: {}",logPrefix, configSettingName, obj);
            Map<String, String> settingMap = new ObjectMapper().convertValue(obj, Map.class);
            log.info("{} - EmailSettingMap: {}", logPrefix, settingMap);
            return new EmailSetting(settingMap);
        } else {
            log.error("{} - Email Configuration Setting [{}] not found in Email Service Configuration of retailer [{}]",
                logPrefix, configSettingName, context.getEvent().getRetailerId());
            throw new RubixException(ERROR_CODE_400,
                String.format("Email configuration Setting [%s] not found in Email Service Configuration of retailer [%s]",
                    configSettingName, context.getEvent().getRetailerId()));
        }
    }

    public static String getMandrillKey(Context context) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        Map<String, Object> emailConfigMap = getEmailServiceConfig(context);
        if (emailConfigMap.containsKey(SETTING_EMAIL_SERVICE_CONFIG_MANDILL_KEY)) {
            log.info("{} - Key: {}, Value: {}", logPrefix, SETTING_EMAIL_SERVICE_CONFIG_MANDILL_KEY,
                emailConfigMap.get(SETTING_EMAIL_SERVICE_CONFIG_MANDILL_KEY));
            return (String) emailConfigMap.get(SETTING_EMAIL_SERVICE_CONFIG_MANDILL_KEY);
        } else {
            log.error("{} - Mandrill Key '{}' is not set in retailer settings for retailerId {}.",
                context.getEvent().getAccountId(), SETTING_EMAIL_SERVICE_CONFIG_MANDILL_KEY, logPrefix);
            throw new RubixException(ERROR_CODE_400,
                String.format("Mandrill Key '%s' is not set in retailer settings for retailerId %s.",
                    SETTING_EMAIL_SERVICE_CONFIG_MANDILL_KEY, context.getEvent().getRetailerId()));
        }
    }
}
