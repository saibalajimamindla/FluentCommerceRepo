package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("Apollo GraphQL")
public final class AddressId {
  private final @Nonnull String id;

  AddressId(@Nonnull String id) {
    this.id = id;
  }

  /**
   *  ID of the object
   */
  public @Nonnull String id() {
    return this.id;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeCustom("id", com.fluentretail.graphql.type.CustomType.ID, id);
      }
    };
  }

  public static final class Builder {
    private @Nonnull String id;

    Builder() {
    }

    /**
     *  ID of the object
     */
    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public AddressId build() {
      Utils.checkNotNull(id, "id == null");
      return new AddressId(id);
    }
  }
}
