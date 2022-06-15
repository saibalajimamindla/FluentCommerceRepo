package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateArticleItemWithArticleInput {
  private final int quantity;

  private final Input<String> barcode;

  CreateArticleItemWithArticleInput(int quantity, Input<String> barcode) {
    this.quantity = quantity;
    this.barcode = barcode;
  }

  public int quantity() {
    return this.quantity;
  }

  public @Nullable String barcode() {
    return this.barcode.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeInt("quantity", quantity);
        if (barcode.defined) {
          writer.writeString("barcode", barcode.value);
        }
      }
    };
  }

  public static final class Builder {
    private int quantity;

    private Input<String> barcode = Input.absent();

    Builder() {
    }

    public Builder quantity(int quantity) {
      this.quantity = quantity;
      return this;
    }

    public Builder barcode(@Nullable String barcode) {
      this.barcode = Input.fromNullable(barcode);
      return this;
    }

    public CreateArticleItemWithArticleInput build() {
      return new CreateArticleItemWithArticleInput(quantity, barcode);
    }
  }
}
