package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateStoreAddressInput {
  private final @Nonnull String ref;

  private final Input<String> companyName;

  private final Input<String> name;

  private final Input<String> street;

  private final Input<String> city;

  private final Input<String> state;

  private final Input<String> postcode;

  private final Input<String> region;

  private final Input<String> country;

  private final double latitude;

  private final double longitude;

  private final Input<String> timeZone;

  CreateStoreAddressInput(@Nonnull String ref, Input<String> companyName, Input<String> name,
      Input<String> street, Input<String> city, Input<String> state, Input<String> postcode,
      Input<String> region, Input<String> country, double latitude, double longitude,
      Input<String> timeZone) {
    this.ref = ref;
    this.companyName = companyName;
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
    this.postcode = postcode;
    this.region = region;
    this.country = country;
    this.latitude = latitude;
    this.longitude = longitude;
    this.timeZone = timeZone;
  }

  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  Max character limit: 45.
   */
  public @Nullable String companyName() {
    return this.companyName.value;
  }

  public @Nullable String name() {
    return this.name.value;
  }

  /**
   *  Max character limit: 100.
   */
  public @Nullable String street() {
    return this.street.value;
  }

  /**
   *  Max character limit: 45.
   */
  public @Nullable String city() {
    return this.city.value;
  }

  /**
   *  Max character limit: 200.
   */
  public @Nullable String state() {
    return this.state.value;
  }

  /**
   *  Max character limit: 100.
   */
  public @Nullable String postcode() {
    return this.postcode.value;
  }

  /**
   *  Max character limit: 250.
   */
  public @Nullable String region() {
    return this.region.value;
  }

  /**
   *  Max character limit: 100.
   */
  public @Nullable String country() {
    return this.country.value;
  }

  public double latitude() {
    return this.latitude;
  }

  public double longitude() {
    return this.longitude;
  }

  /**
   *  Max character limit: 32.
   */
  public @Nullable String timeZone() {
    return this.timeZone.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("ref", ref);
        if (companyName.defined) {
          writer.writeString("companyName", companyName.value);
        }
        if (name.defined) {
          writer.writeString("name", name.value);
        }
        if (street.defined) {
          writer.writeString("street", street.value);
        }
        if (city.defined) {
          writer.writeString("city", city.value);
        }
        if (state.defined) {
          writer.writeString("state", state.value);
        }
        if (postcode.defined) {
          writer.writeString("postcode", postcode.value);
        }
        if (region.defined) {
          writer.writeString("region", region.value);
        }
        if (country.defined) {
          writer.writeString("country", country.value);
        }
        writer.writeDouble("latitude", latitude);
        writer.writeDouble("longitude", longitude);
        if (timeZone.defined) {
          writer.writeString("timeZone", timeZone.value);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private Input<String> companyName = Input.absent();

    private Input<String> name = Input.absent();

    private Input<String> street = Input.absent();

    private Input<String> city = Input.absent();

    private Input<String> state = Input.absent();

    private Input<String> postcode = Input.absent();

    private Input<String> region = Input.absent();

    private Input<String> country = Input.absent();

    private double latitude;

    private double longitude;

    private Input<String> timeZone = Input.absent();

    Builder() {
    }

    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  Max character limit: 45.
     */
    public Builder companyName(@Nullable String companyName) {
      this.companyName = Input.fromNullable(companyName);
      return this;
    }

    public Builder name(@Nullable String name) {
      this.name = Input.fromNullable(name);
      return this;
    }

    /**
     *  Max character limit: 100.
     */
    public Builder street(@Nullable String street) {
      this.street = Input.fromNullable(street);
      return this;
    }

    /**
     *  Max character limit: 45.
     */
    public Builder city(@Nullable String city) {
      this.city = Input.fromNullable(city);
      return this;
    }

    /**
     *  Max character limit: 200.
     */
    public Builder state(@Nullable String state) {
      this.state = Input.fromNullable(state);
      return this;
    }

    /**
     *  Max character limit: 100.
     */
    public Builder postcode(@Nullable String postcode) {
      this.postcode = Input.fromNullable(postcode);
      return this;
    }

    /**
     *  Max character limit: 250.
     */
    public Builder region(@Nullable String region) {
      this.region = Input.fromNullable(region);
      return this;
    }

    /**
     *  Max character limit: 100.
     */
    public Builder country(@Nullable String country) {
      this.country = Input.fromNullable(country);
      return this;
    }

    public Builder latitude(double latitude) {
      this.latitude = latitude;
      return this;
    }

    public Builder longitude(double longitude) {
      this.longitude = longitude;
      return this;
    }

    /**
     *  Max character limit: 32.
     */
    public Builder timeZone(@Nullable String timeZone) {
      this.timeZone = Input.fromNullable(timeZone);
      return this;
    }

    public CreateStoreAddressInput build() {
      Utils.checkNotNull(ref, "ref == null");
      return new CreateStoreAddressInput(ref, companyName, name, street, city, state, postcode, region, country, latitude, longitude, timeZone);
    }
  }
}
