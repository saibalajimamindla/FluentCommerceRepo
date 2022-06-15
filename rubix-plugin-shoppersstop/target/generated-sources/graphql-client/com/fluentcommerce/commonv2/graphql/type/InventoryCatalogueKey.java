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
public final class InventoryCatalogueKey {
  private final @Nonnull String ref;

  InventoryCatalogueKey(@Nonnull String ref) {
    this.ref = ref;
  }

  /**
   *  Inventory Catalogue reference identifier. <br/>
   *  Max character limit: 100.
   */
  public @Nonnull String ref() {
    return this.ref;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("ref", ref);
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    Builder() {
    }

    /**
     *  Inventory Catalogue reference identifier. <br/>
     *  Max character limit: 100.
     */
    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    public InventoryCatalogueKey build() {
      Utils.checkNotNull(ref, "ref == null");
      return new InventoryCatalogueKey(ref);
    }
  }
}
