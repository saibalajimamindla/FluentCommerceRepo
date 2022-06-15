package com.fluentcommerce.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = FulfilmentRating.Builder.class)
public class FulfilmentRating implements Comparable<FulfilmentRating> {

    private Double rating;
	private String locRef;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    /**
     * Sorting in descending order
     */
    @Override
    public int compareTo(FulfilmentRating other) {
        return other.getRating().compareTo(this.getRating());
    }
}
