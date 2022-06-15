package com.fluentcommerce.model.setting;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.setting.GetSettingQuery;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Setting.Builder.class)
public class Setting {
    private Integer id;
    private String name;
    private String value;
    private String valueType;
    private Object lobValue;
    private String context;
    private int contextId;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Setting from(GetSettingQuery.SettingNode setting) {
        return Setting.builder()
            .id(Integer.parseInt(setting.id()))
            .name(setting.name())
            .value(setting.value())
            .valueType(setting.valueType())
            .lobValue(setting.lobValue())
            .context(setting.context())
            .contextId(setting.contextId())
            .build();
    }
}

