package com.fluentcommerce.model.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.common.BaseEntity;
import com.fluentretail.api.model.attribute.Attribute;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Objects;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = VariantProduct.Builder.class)
public class VariantProduct extends BaseEntity {

    private String id;
    private String ref;
    private String type;
    private String status;
    private String gtin;
    private String name;
    private String summary;
    private List<String> categoryRefs;
    private String standardProductRef;
    private List<Attribute> attributes;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static VariantProduct from(GetOrderByIdQuery.AsVariantProduct variantProduct) {
        return VariantProduct.builder()
            .id(variantProduct.id())
            .ref(variantProduct.ref())
            .type(variantProduct.type())
            .status(variantProduct.status())
        .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VariantProduct that = (VariantProduct) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
