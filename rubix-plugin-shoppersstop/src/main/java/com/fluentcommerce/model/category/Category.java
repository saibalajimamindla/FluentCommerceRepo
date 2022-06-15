package com.fluentcommerce.model.category;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.model.comment.Comment;
import com.fluentretail.api.model.attribute.Attribute;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = Category.Builder.class)
public class Category {

    @NonNull
    private String ref;
    private String type;
    private String status;
    private List<Attribute> attributes;
    private String name;
    private String summary;
    private String parentCategory;
    private List<String> childCategories;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}
}