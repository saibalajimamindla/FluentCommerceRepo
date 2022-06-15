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
public final class RoleKey {
  private final @Nonnull String name;

  RoleKey(@Nonnull String name) {
    this.name = name;
  }

  /**
   *  Name of the role which is unique and acts as a key to identify the role itself
   */
  public @Nonnull String name() {
    return this.name;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("name", name);
      }
    };
  }

  public static final class Builder {
    private @Nonnull String name;

    Builder() {
    }

    /**
     *  Name of the role which is unique and acts as a key to identify the role itself
     */
    public Builder name(@Nonnull String name) {
      this.name = name;
      return this;
    }

    public RoleKey build() {
      Utils.checkNotNull(name, "name == null");
      return new RoleKey(name);
    }
  }
}
