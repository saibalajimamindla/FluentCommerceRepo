package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import java.io.IOException;
import java.lang.Override;
import javax.annotation.Generated;

@Generated("Apollo GraphQL")
public final class GeoCoordinateInput {
  private final double latitude;

  private final double longitude;

  GeoCoordinateInput(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   *  Geographical coordinate that specifies the north–south position of a point on the Earth's surface
   */
  public double latitude() {
    return this.latitude;
  }

  /**
   *  Geographical coordinate that specifies the east–west position of a point on the Earth's surface
   */
  public double longitude() {
    return this.longitude;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeDouble("latitude", latitude);
        writer.writeDouble("longitude", longitude);
      }
    };
  }

  public static final class Builder {
    private double latitude;

    private double longitude;

    Builder() {
    }

    /**
     *  Geographical coordinate that specifies the north–south position of a point on the Earth's surface
     */
    public Builder latitude(double latitude) {
      this.latitude = latitude;
      return this;
    }

    /**
     *  Geographical coordinate that specifies the east–west position of a point on the Earth's surface
     */
    public Builder longitude(double longitude) {
      this.longitude = longitude;
      return this;
    }

    public GeoCoordinateInput build() {
      return new GeoCoordinateInput(latitude, longitude);
    }
  }
}
