package com.fluentcommerce.model.openingSchedule;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.model.common.BaseEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = OpeningSchedule.Builder.class)
public class OpeningSchedule extends BaseEntity {

    private String id;
    private String createdOn;
    private String updatedOn;
    private Boolean allHours;
    private Integer monEnd;
    private Integer monStart;
    private Integer tueEnd;
    private Integer tueStart;
    private Integer wedEnd;
    private Integer wedStart;
    private Integer thuEnd;
    private Integer thuStart;
    private Integer friEnd;
    private Integer friStart;
    private Integer satEnd;
    private Integer satStart;
    private Integer sunEnd;
    private Integer sunStart;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static OpeningSchedule from(GetLocationByRefQuery.OpeningSchedule openingSchedule) {
        return OpeningSchedule.builder()
            .id(openingSchedule.id())
            .createdOn((String) openingSchedule.createdOn())
            .updatedOn((String) openingSchedule.updatedOn())
            .allHours(openingSchedule.allHours())
            .monEnd(openingSchedule.monEnd())
            .monStart(openingSchedule.monStart())
            .tueEnd(openingSchedule.tueEnd())
            .tueStart(openingSchedule.tueStart())
            .wedEnd(openingSchedule.wedEnd())
            .wedStart(openingSchedule.wedStart())
            .thuEnd(openingSchedule.thuEnd())
            .thuStart(openingSchedule.thuStart())
            .friEnd(openingSchedule.friEnd())
            .friStart(openingSchedule.friStart())
            .satEnd(openingSchedule.satEnd())
            .satStart(openingSchedule.satStart())
            .sunEnd(openingSchedule.sunEnd())
            .sunStart(openingSchedule.sunStart())
            .build();
    }

}
