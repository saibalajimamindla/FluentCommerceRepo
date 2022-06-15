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
public final class UpdateInventoryQuantityInput {
  private final @Nonnull String ref;

  private final @Nonnull InventoryCatalogueKey catalogue;

  private final Input<String> status;

  private final Input<String> type;

  private final Input<List<AttributeInput>> attributes;

  private final Input<Integer> quantity;

  private final Input<String> condition;

  private final Input<Object> expectedOn;

  private final Input<String> storageAreaRef;

  UpdateInventoryQuantityInput(@Nonnull String ref, @Nonnull InventoryCatalogueKey catalogue,
      Input<String> status, Input<String> type, Input<List<AttributeInput>> attributes,
      Input<Integer> quantity, Input<String> condition, Input<Object> expectedOn,
      Input<String> storageAreaRef) {
    this.ref = ref;
    this.catalogue = catalogue;
    this.status = status;
    this.type = type;
    this.attributes = attributes;
    this.quantity = quantity;
    this.condition = condition;
    this.expectedOn = expectedOn;
    this.storageAreaRef = storageAreaRef;
  }

  /**
   *  The unique reference identifier for the Inventory Quantity. <br/>
   *  Max character limit: 100.
   */
  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  The Inventory Catalogue in which this Position is managed
   */
  public @Nonnull InventoryCatalogueKey catalogue() {
    return this.catalogue;
  }

  /**
   *  The current status of the `InventoryQuantity`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
   *  Max character limit: 50.
   */
  public @Nullable String status() {
    return this.status.value;
  }

  /**
   *  Type of the `InventoryQuantity`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
   *  Max character limit: 50.
   */
  public @Nullable String type() {
    return this.type.value;
  }

  /**
   *  A list of attributes associated with this Inventory Quantity. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
   */
  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  /**
   *  The actual amount of this specific Quantity record
   */
  public @Nullable Integer quantity() {
    return this.quantity.value;
  }

  /**
   *  The condition of the Inventory Quantity value. The platform does not enforce any values here. Examples could include `NEW`, `USED`, or `DAMAGED`
   */
  public @Nullable String condition() {
    return this.condition.value;
  }

  /**
   *  The date and time the quantity is expected to arrive
   */
  public @Nullable Object expectedOn() {
    return this.expectedOn.value;
  }

  /**
   *  A reference to the Storage Area where this inventory is kept. <br/>
   *  Max character limit: 100.
   */
  public @Nullable String storageAreaRef() {
    return this.storageAreaRef.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("ref", ref);
        writer.writeObject("catalogue", catalogue.marshaller());
        if (status.defined) {
          writer.writeString("status", status.value);
        }
        if (type.defined) {
          writer.writeString("type", type.value);
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
        if (quantity.defined) {
          writer.writeInt("quantity", quantity.value);
        }
        if (condition.defined) {
          writer.writeString("condition", condition.value);
        }
        if (expectedOn.defined) {
          writer.writeCustom("expectedOn", com.fluentretail.graphql.type.CustomType.DATETIME, expectedOn.value != null ? expectedOn.value : null);
        }
        if (storageAreaRef.defined) {
          writer.writeString("storageAreaRef", storageAreaRef.value);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private @Nonnull InventoryCatalogueKey catalogue;

    private Input<String> status = Input.absent();

    private Input<String> type = Input.absent();

    private Input<List<AttributeInput>> attributes = Input.absent();

    private Input<Integer> quantity = Input.absent();

    private Input<String> condition = Input.absent();

    private Input<Object> expectedOn = Input.absent();

    private Input<String> storageAreaRef = Input.absent();

    Builder() {
    }

    /**
     *  The unique reference identifier for the Inventory Quantity. <br/>
     *  Max character limit: 100.
     */
    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  The Inventory Catalogue in which this Position is managed
     */
    public Builder catalogue(@Nonnull InventoryCatalogueKey catalogue) {
      this.catalogue = catalogue;
      return this;
    }

    /**
     *  The current status of the `InventoryQuantity`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     *  Max character limit: 50.
     */
    public Builder status(@Nullable String status) {
      this.status = Input.fromNullable(status);
      return this;
    }

    /**
     *  Type of the `InventoryQuantity`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     *  Max character limit: 50.
     */
    public Builder type(@Nullable String type) {
      this.type = Input.fromNullable(type);
      return this;
    }

    /**
     *  A list of attributes associated with this Inventory Quantity. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    /**
     *  The actual amount of this specific Quantity record
     */
    public Builder quantity(@Nullable Integer quantity) {
      this.quantity = Input.fromNullable(quantity);
      return this;
    }

    /**
     *  The condition of the Inventory Quantity value. The platform does not enforce any values here. Examples could include `NEW`, `USED`, or `DAMAGED`
     */
    public Builder condition(@Nullable String condition) {
      this.condition = Input.fromNullable(condition);
      return this;
    }

    /**
     *  The date and time the quantity is expected to arrive
     */
    public Builder expectedOn(@Nullable Object expectedOn) {
      this.expectedOn = Input.fromNullable(expectedOn);
      return this;
    }

    /**
     *  A reference to the Storage Area where this inventory is kept. <br/>
     *  Max character limit: 100.
     */
    public Builder storageAreaRef(@Nullable String storageAreaRef) {
      this.storageAreaRef = Input.fromNullable(storageAreaRef);
      return this;
    }

    public UpdateInventoryQuantityInput build() {
      Utils.checkNotNull(ref, "ref == null");
      Utils.checkNotNull(catalogue, "catalogue == null");
      return new UpdateInventoryQuantityInput(ref, catalogue, status, type, attributes, quantity, condition, expectedOn, storageAreaRef);
    }
  }
}
