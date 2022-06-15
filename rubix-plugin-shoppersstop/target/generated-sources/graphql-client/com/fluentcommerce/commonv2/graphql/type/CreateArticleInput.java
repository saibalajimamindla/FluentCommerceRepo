package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateArticleInput {
  private final @Nonnull String ref;

  private final @Nonnull String type;

  private final Input<List<AttributeInput>> attributes;

  private final Input<String> articleNumber;

  private final Input<String> barcodeArticleNumber;

  private final Input<String> description;

  private final double height;

  private final double length;

  private final Input<String> name;

  private final Input<String> purchaseValue;

  private final double weight;

  private final double width;

  private final Input<Object> expiryDate;

  private final Input<Integer> quantity;

  private final Input<List<CreateArticleItemWithArticleInput>> items;

  private final @Nonnull List<FulfilmentId> fulfilments;

  private final Input<StorageAreaId> storageArea;

  CreateArticleInput(@Nonnull String ref, @Nonnull String type,
      Input<List<AttributeInput>> attributes, Input<String> articleNumber,
      Input<String> barcodeArticleNumber, Input<String> description, double height, double length,
      Input<String> name, Input<String> purchaseValue, double weight, double width,
      Input<Object> expiryDate, Input<Integer> quantity,
      Input<List<CreateArticleItemWithArticleInput>> items, @Nonnull List<FulfilmentId> fulfilments,
      Input<StorageAreaId> storageArea) {
    this.ref = ref;
    this.type = type;
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
    this.items = items;
    this.fulfilments = fulfilments;
    this.storageArea = storageArea;
  }

  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  Type of the `Article`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
   *  Max character limit: 50.
   */
  public @Nonnull String type() {
    return this.type;
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

  public double height() {
    return this.height;
  }

  public double length() {
    return this.length;
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

  public double weight() {
    return this.weight;
  }

  public double width() {
    return this.width;
  }

  public @Nullable Object expiryDate() {
    return this.expiryDate.value;
  }

  public @Nullable Integer quantity() {
    return this.quantity.value;
  }

  public @Nullable List<CreateArticleItemWithArticleInput> items() {
    return this.items.value;
  }

  public @Nonnull List<FulfilmentId> fulfilments() {
    return this.fulfilments;
  }

  public @Nullable StorageAreaId storageArea() {
    return this.storageArea.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("ref", ref);
        writer.writeString("type", type);
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
        writer.writeDouble("height", height);
        writer.writeDouble("length", length);
        if (name.defined) {
          writer.writeString("name", name.value);
        }
        if (purchaseValue.defined) {
          writer.writeString("purchaseValue", purchaseValue.value);
        }
        writer.writeDouble("weight", weight);
        writer.writeDouble("width", width);
        if (expiryDate.defined) {
          writer.writeCustom("expiryDate", com.fluentretail.graphql.type.CustomType.DATETIME, expiryDate.value != null ? expiryDate.value : null);
        }
        if (quantity.defined) {
          writer.writeInt("quantity", quantity.value);
        }
        if (items.defined) {
          writer.writeList("items", items.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (CreateArticleItemWithArticleInput $item : items.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
        writer.writeList("fulfilments", new InputFieldWriter.ListWriter() {
          @Override
          public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
            for (FulfilmentId $item : fulfilments) {
              listItemWriter.writeObject($item.marshaller());
            }
          }
        });
        if (storageArea.defined) {
          writer.writeObject("storageArea", storageArea.value != null ? storageArea.value.marshaller() : null);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private @Nonnull String type;

    private Input<List<AttributeInput>> attributes = Input.absent();

    private Input<String> articleNumber = Input.absent();

    private Input<String> barcodeArticleNumber = Input.absent();

    private Input<String> description = Input.absent();

    private double height;

    private double length;

    private Input<String> name = Input.absent();

    private Input<String> purchaseValue = Input.absent();

    private double weight;

    private double width;

    private Input<Object> expiryDate = Input.absent();

    private Input<Integer> quantity = Input.absent();

    private Input<List<CreateArticleItemWithArticleInput>> items = Input.absent();

    private @Nonnull List<FulfilmentId> fulfilments;

    private Input<StorageAreaId> storageArea = Input.absent();

    Builder() {
    }

    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  Type of the `Article`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     *  Max character limit: 50.
     */
    public Builder type(@Nonnull String type) {
      this.type = type;
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

    public Builder height(double height) {
      this.height = height;
      return this;
    }

    public Builder length(double length) {
      this.length = length;
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

    public Builder weight(double weight) {
      this.weight = weight;
      return this;
    }

    public Builder width(double width) {
      this.width = width;
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

    public Builder items(@Nullable List<CreateArticleItemWithArticleInput> items) {
      this.items = Input.fromNullable(items);
      return this;
    }

    public Builder fulfilments(@Nonnull List<FulfilmentId> fulfilments) {
      this.fulfilments = fulfilments;
      return this;
    }

    public Builder storageArea(@Nullable StorageAreaId storageArea) {
      this.storageArea = Input.fromNullable(storageArea);
      return this;
    }

    public CreateArticleInput build() {
      Utils.checkNotNull(ref, "ref == null");
      Utils.checkNotNull(type, "type == null");
      Utils.checkNotNull(fulfilments, "fulfilments == null");
      return new CreateArticleInput(ref, type, attributes, articleNumber, barcodeArticleNumber, description, height, length, name, purchaseValue, weight, width, expiryDate, quantity, items, fulfilments, storageArea);
    }
  }
}
