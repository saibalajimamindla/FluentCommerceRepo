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
public final class CreateFulfilmentPlanFulfilmentItemInput {
  private final @Nonnull String productRef;

  private final Input<String> catalogueRef;

  private final int availableQuantity;

  private final int requestedQuantity;

  CreateFulfilmentPlanFulfilmentItemInput(@Nonnull String productRef, Input<String> catalogueRef,
      int availableQuantity, int requestedQuantity) {
    this.productRef = productRef;
    this.catalogueRef = catalogueRef;
    this.availableQuantity = availableQuantity;
    this.requestedQuantity = requestedQuantity;
  }

  /**
   *  External reference of the product.
   */
  public @Nonnull String productRef() {
    return this.productRef;
  }

  /**
   *  A reference to identify the Catalogue
   */
  public @Nullable String catalogueRef() {
    return this.catalogueRef.value;
  }

  /**
   *  Quantity of the product available as per the plan
   */
  public int availableQuantity() {
    return this.availableQuantity;
  }

  /**
   *  Requested quantity of the product.
   */
  public int requestedQuantity() {
    return this.requestedQuantity;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("productRef", productRef);
        if (catalogueRef.defined) {
          writer.writeString("catalogueRef", catalogueRef.value);
        }
        writer.writeInt("availableQuantity", availableQuantity);
        writer.writeInt("requestedQuantity", requestedQuantity);
      }
    };
  }

  public static final class Builder {
    private @Nonnull String productRef;

    private Input<String> catalogueRef = Input.absent();

    private int availableQuantity;

    private int requestedQuantity;

    Builder() {
    }

    /**
     *  External reference of the product.
     */
    public Builder productRef(@Nonnull String productRef) {
      this.productRef = productRef;
      return this;
    }

    /**
     *  A reference to identify the Catalogue
     */
    public Builder catalogueRef(@Nullable String catalogueRef) {
      this.catalogueRef = Input.fromNullable(catalogueRef);
      return this;
    }

    /**
     *  Quantity of the product available as per the plan
     */
    public Builder availableQuantity(int availableQuantity) {
      this.availableQuantity = availableQuantity;
      return this;
    }

    /**
     *  Requested quantity of the product.
     */
    public Builder requestedQuantity(int requestedQuantity) {
      this.requestedQuantity = requestedQuantity;
      return this;
    }

    public CreateFulfilmentPlanFulfilmentItemInput build() {
      Utils.checkNotNull(productRef, "productRef == null");
      return new CreateFulfilmentPlanFulfilmentItemInput(productRef, catalogueRef, availableQuantity, requestedQuantity);
    }
  }
}
