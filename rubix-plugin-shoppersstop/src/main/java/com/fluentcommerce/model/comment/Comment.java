package com.fluentcommerce.model.comment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.comment.GetCommentsQuery;
import com.fluentcommerce.model.common.BaseEntity;
import com.fluentcommerce.model.customer.Customer;
import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Comment.Builder.class)
public class Comment extends BaseEntity {
    private String id;
    private String entityType;
    private String entityId;
    private String text;
    private String createdOn;
    private String updatedOn;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static Comment from(GetCommentsQuery.Node comment) {
        return Comment.builder()
            .id(comment.id())
            .entityType(comment.entityType())
            .entityId(comment.entityId())
            .text(comment.text())
            .createdOn((String) comment.createdOn())
            .updatedOn((String) comment.updatedOn())
            .build();
    }
}
