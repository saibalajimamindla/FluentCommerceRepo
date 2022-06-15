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
public final class ProductQuantityInput {
  private final @Nonnull String productRef;

  private final int quantity;

  ProductQuantityInput(@Nonnull String productRef, int quantity) {
    this.productRef = productRef;
    this.quantity = quantity;
  }

  /**
   *  Reference identifier for the `Product`
   */
  public @Nonnull String productRef() {
    return this.productRef;
  }

  /**
   *  Requested quantity of the associated `Product`
   */
  public int quantity() {
    return this.quantity;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("productRef", productRef);
        writer.writeInt("quantity", quantity);
      }
    };
  }

  public static final class Builder {
    private @Nonnull String productRef;

    private int quantity;

    Builder() {
    }

    /**
     *  Reference identifier for the `Product`
     */
    public Builder productRef(@Nonnull String productRef) {
      this.productRef = productRef;
      return this;
    }

    /**
     *  Requested quantity of the associated `Product`
     */
    public Builder quantity(int quantity) {
      this.quantity = quantity;
      return this;
    }

    public ProductQuantityInput build() {
      Utils.checkNotNull(productRef, "productRef == null");
      return new ProductQuantityInput(productRef, quantity);
    }
  }
}
