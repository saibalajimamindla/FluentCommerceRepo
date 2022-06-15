package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class UpdateArticleInput {
  private final @Nonnull String id;

  private final Input<String> type;

  private final Input<String> status;

  private final Input<List<AttributeInput>> attributes;

  private final Input<String> articleNumber;

  private final Input<String> barcodeArticleNumber;

  private final Input<String> description;

  private final Input<Double> height;

  private final Input<Double> length;

  private final Input<String> name;

  private final Input<String> purchaseValue;

  private final Input<Double> weight;

  private final Input<Double> width;

  private final Input<Object> expiryDate;

  private final Input<Integer> quantity;

  UpdateArticleInput(@Nonnull String id, Input<String> type, Input<String> status,
      Input<List<AttributeInput>> attributes, Input<String> articleNumber,
      Input<String> barcodeArticleNumber, Input<String> description, Input<Double> height,
      Input<Double> length, Input<String> name, Input<String> purchaseValue, Input<Double> weight,
      Input<Double> width, Input<Object> expiryDate, Input<Integer> quantity) {
    this.id = id;
    this.type = type;
    this.status = status;
    this.attributes = attributes;
    this.articleNumber = articleNumber;
    this.barcodeArticleNumber = barcodeArticleNumber;
    this.description = description;
    this.height = height;
    this.length = length;
    this.name = name;
    this.purchaseValue = purchaseValue;
    this.weight = weight;
    this.width = width;
    this.expiryDate = expiryDate;
    this.quantity = quantity;
  }

  /**
   *  ID of the object
   */
  public @Nonnull String id() {
    return this.id;
  }

  /**
   *  Type of the `Article`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
   *  Max character limit: 50.
   */
  public @Nullable String type() {
    return this.type.value;
  }

  /**
   *  The current status of the `Article`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
   *  Max character limit: 30.
   */
  public @Nullable String status() {
    return this.status.value;
  }

  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  /**
   *  Max character limit: 30.
   */
  public @Nullable String articleNumber() {
    return this.articleNumber.value;
  }

  /**
   *  Max character limit: 50.
   */
  public @Nullable String barcodeArticleNumber() {
    return this.barcodeArticleNumber.value;
  }

  /**
   *  Max character limit: 256.
   */
  public @Nullable String description() {
    return this.description.value;
  }

  public @Nullable Double height() {
    return this.height.value;
  }

  public @Nullable Double length() {
    return this.length.value;
  }

  /**
   *  Max character limit: 256.
   */
  public @Nullable String name() {
    return this.name.value;
  }

  /**
   *  Max character limit: 100.
   */
  public @Nullable String purchaseValue() {
    return this.purchaseValue.value;
  }

  public @Nullable Double weight() {
    return this.weight.value;
  }

  public @Nullable Double width() {
    return this.width.value;
  }

  public @Nullable Object expiryDate() {
    return this.expiryDate.value;
  }

  public @Nullable Integer quantity() {
    return this.quantity.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeCustom("id", com.fluentretail.graphql.type.CustomType.ID, id);
        if (type.defined) {
          writer.writeString("type", type.value);
        }
        if (status.defined) {
          writer.writeString("status", status.value);
        }
        if (attributes.defined) {
          writer.writeList("attributes", attributes.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (AttributeInput $item : attributes.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
        if (articleNumber.defined) {
          writer.writeString("articleNumber", articleNumber.value);
        }
        if (barcodeArticleNumber.defined) {
          writer.writeString("barcodeArticleNumber", barcodeArticleNumber.value);
        }
        if (description.defined) {
          writer.writeString("description", description.value);
        }
        if (height.defined) {
          writer.writeDouble("height", height.value);
        }
        if (length.defined) {
          writer.writeDouble("length", length.value);
        }
        if (name.defined) {
          writer.writeString("name", name.value);
        }
        if (purchaseValue.defined) {
          writer.writeString("purchaseValue", purchaseValue.value);
        }
        if (weight.defined) {
          writer.writeDouble("weight", weight.value);
        }
        if (width.defined) {
          writer.writeDouble("width", width.value);
        }
        if (expiryDate.defined) {
          writer.writeCustom("expiryDate", com.fluentretail.graphql.type.CustomType.DATETIME, expiryDate.value != null ? expiryDate.value : null);
        }
        if (quantity.defined) {
          writer.writeInt("quantity", quantity.value);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String id;

    private Input<String> type = Input.absent();

    private Input<String> status = Input.absent();

    private Input<List<AttributeInput>> attributes = Input.absent();

    private Input<String> articleNumber = Input.absent();

    private Input<String> barcodeArticleNumber = Input.absent();

    private Input<String> description = Input.absent();

    private Input<Double> height = Input.absent();

    private Input<Double> length = Input.absent();

    private Input<String> name = Input.absent();

    private Input<String> purchaseValue = Input.absent();

    private Input<Double> weight = Input.absent();

    private Input<Double> width = Input.absent();

    private Input<Object> expiryDate = Input.absent();

    private Input<Integer> quantity = Input.absent();

    Builder() {
    }

    /**
     *  ID of the object
     */
    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    /**
     *  Type of the `Article`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     *  Max character limit: 50.
     */
    public Builder type(@Nullable String type) {
      this.type = Input.fromNullable(type);
      return this;
    }

    /**
     *  The current status of the `Article`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     *  Max character limit: 30.
     */
    public Builder status(@Nullable String status) {
      this.status = Input.fromNullable(status);
      return this;
    }

    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    /**
     *  Max character limit: 30.
     */
    public Builder articleNumber(@Nullable String articleNumber) {
      this.articleNumber = Input.fromNullable(articleNumber);
      return this;
    }

    /**
     *  Max character limit: 50.
     */
    public Builder barcodeArticleNumber(@Nullable String barcodeArticleNumber) {
      this.barcodeArticleNumber = Input.fromNullable(barcodeArticleNumber);
      return this;
    }

    /**
     *  Max character limit: 256.
     */
    public Builder description(@Nullable String description) {
      this.description = Input.fromNullable(description);
      return this;
    }

    public Builder height(@Nullable Double height) {
      this.height = Input.fromNullable(height);
      return this;
    }

    public Builder length(@Nullable Double length) {
      this.length = Input.fromNullable(length);
      return this;
    }

    /**
     *  Max character limit: 256.
     */
    public Builder name(@Nullable String name) {
      this.name = Input.fromNullable(name);
      return this;
    }

    /**
     *  Max character limit: 100.
     */
    public Builder purchaseValue(@Nullable String purchaseValue) {
      this.purchaseValue = Input.fromNullable(purchaseValue);
      return this;
    }

    public Builder weight(@Nullable Double weight) {
      this.weight = Input.fromNullable(weight);
      return this;
    }

    public Builder width(@Nullable Double width) {
      this.width = Input.fromNullable(width);
      return this;
    }

    public Builder expiryDate(@Nullable Object expiryDate) {
      this.expiryDate = Input.fromNullable(expiryDate);
      return this;
    }

    public Builder quantity(@Nullable Integer quantity) {
      this.quantity = Input.fromNullable(quantity);
      return this;
    }

    public UpdateArticleInput build() {
      Utils.checkNotNull(id, "id == null");
      return new UpdateArticleInput(id, type, status, attributes, articleNumber, barcodeArticleNumber, description, height, length, name, purchaseValue, weight, width, expiryDate, quantity);
    }
  }
}
