package com.fluentcommerce.service;

import com.fluentcommerce.commonv2.graphql.query.setting.GetSettingQuery;
import com.fluentcommerce.model.setting.Setting;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.v2.context.Context;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.fluentcommerce.util.Constants.Setting.*;
import static java.lang.Integer.valueOf;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Slf4j
public class SettingService {

	private static final String CLASS_NAME = SettingService.class.getSimpleName();

	private Context context;

	public SettingService(Context context) {
		this.context = context;
	}

	public String getSettingValue(String settingName, String defaultValue) {
		final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
		if (isBlank(settingName)) {
			return defaultValue;
		}
		try {
			Setting setting = getSetting(settingName);
			if (setting != null) {
				return setting.getValue();
			}
		} catch (Exception e) {
			log.error(logPrefix + " - exception occurred while executing, use default value.", e);
		}
		return defaultValue;
	}

	public Integer getSettingValue(String settingName, Integer defaultValue) {
		final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
		if (isBlank(settingName)) {
			return defaultValue;
		}
		try {
			Setting setting = getSetting(settingName);
			if (setting != null) {
				return valueOf(setting.getValue());
			}
		} catch (Exception e) {
			log.error(logPrefix + " - exception occurred while executing, use default value.", e);
		}
		return defaultValue;
	}

	public List<Setting> getSettings(String settingName, String settingContext, List<Integer> contextIds) {
		GetSettingQuery.Settings settingData = getSettingData(context, settingName, settingContext, contextIds).settings();

		if (settingData == null
			|| settingData.settingEdge() == null
			|| settingData.settingEdge().size() <= 0
		) {
			return null;
		}

		List<Setting> settings = new ArrayList<>();
		for (GetSettingQuery.SettingEdge settingEdge : settingData.settingEdge()) {
			settings.add(Setting.from(settingEdge.settingNode()));
		}
		return settings;
	}
	
	public Setting getSetting(String settingName) {
		List<GetSettingQuery.SettingEdge> edges = getSettingData(context, settingName, SETTING_CONTEXT_RETAILER, context.getEvent().getRetailerId()).settings().settingEdge();
		if (edges.size() == 0) {
			edges = getSettingData(context, settingName, SETTING_CONTEXT_ACCOUNT, SETTING_CONTEXT_ACCOUNT_ID).settings().settingEdge();
			if (edges.size() == 0) {
				edges = getSettingData(context, settingName, SETTING_CONTEXT_GLOBAL, SETTING_CONTEXT_GLOBAL_ID).settings().settingEdge();
			}
		}
		if (edges.stream().findFirst().isPresent())
			return Setting.from(edges.stream().findFirst().get().settingNode());
		return null;
	}

	private static GetSettingQuery.Data getSettingData(Context context, String settingName, String settingContext, String contextId) {
		GetSettingQuery querySettings = GetSettingQuery.builder().name(ImmutableList.of(settingName)).context(ImmutableList.of(settingContext))
				.contextId(ImmutableList.of(Integer.parseInt(contextId))).build();
		GetSettingQuery.Data settingsData = (GetSettingQuery.Data) context.api().query(querySettings);
        return settingsData;
	}

	private static GetSettingQuery.Data getSettingData(Context context, String settingName, String settingContext, List<Integer> contextIds) {
		GetSettingQuery querySettings = GetSettingQuery.builder()
			.name(ImmutableList.of(settingName))
			.context(ImmutableList.of(settingContext))
			.contextId(contextIds)
			.build();
		GetSettingQuery.Data settingsData = (GetSettingQuery.Data) context.api().query(querySettings);
		return settingsData;
	}

}
