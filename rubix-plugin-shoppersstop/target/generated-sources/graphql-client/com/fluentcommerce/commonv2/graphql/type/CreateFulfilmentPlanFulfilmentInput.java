package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateFulfilmentPlanFulfilmentInput {
  private final Input<String> fulfilmentType;

  private final Input<String> locationRef;

  private final Input<String> eta;

  private final Input<List<CreateFulfilmentPlanFulfilmentItemInput>> items;

  CreateFulfilmentPlanFulfilmentInput(Input<String> fulfilmentType, Input<String> locationRef,
      Input<String> eta, Input<List<CreateFulfilmentPlanFulfilmentItemInput>> items) {
    this.fulfilmentType = fulfilmentType;
    this.locationRef = locationRef;
    this.eta = eta;
    this.items = items;
  }

  /**
   *  Type of fulfilment.
   */
  public @Nullable String fulfilmentType() {
    return this.fulfilmentType.value;
  }

  /**
   *  Reference to identify the fulfilment location for this fulfilment.
   */
  public @Nullable String locationRef() {
    return this.locationRef.value;
  }

  /**
   *  ETA of the `FulfilmentPlan` as configured in the workflow
   */
  public @Nullable String eta() {
    return this.eta.value;
  }

  /**
   *  List of products with their requested and available quantities
   */
  public @Nullable List<CreateFulfilmentPlanFulfilmentItemInput> items() {
    return this.items.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        if (fulfilmentType.defined) {
          writer.writeString("fulfilmentType", fulfilmentType.value);
        }
        if (locationRef.defined) {
          writer.writeString("locationRef", locationRef.value);
        }
        if (eta.defined) {
          writer.writeString("eta", eta.value);
        }
        if (items.defined) {
          writer.writeList("items", items.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (CreateFulfilmentPlanFulfilmentItemInput $item : items.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
      }
    };
  }

  public static final class Builder {
    private Input<String> fulfilmentType = Input.absent();

    private Input<String> locationRef = Input.absent();

    private Input<String> eta = Input.absent();

    private Input<List<CreateFulfilmentPlanFulfilmentItemInput>> items = Input.absent();

    Builder() {
    }

    /**
     *  Type of fulfilment.
     */
    public Builder fulfilmentType(@Nullable String fulfilmentType) {
      this.fulfilmentType = Input.fromNullable(fulfilmentType);
      return this;
    }

    /**
     *  Reference to identify the fulfilment location for this fulfilment.
     */
    public Builder locationRef(@Nullable String locationRef) {
      this.locationRef = Input.fromNullable(locationRef);
      return this;
    }

    /**
     *  ETA of the `FulfilmentPlan` as configured in the workflow
     */
    public Builder eta(@Nullable String eta) {
      this.eta = Input.fromNullable(eta);
      return this;
    }

    /**
     *  List of products with their requested and available quantities
     */
    public Builder items(@Nullable List<CreateFulfilmentPlanFulfilmentItemInput> items) {
      this.items = Input.fromNullable(items);
      return this;
    }

    public CreateFulfilmentPlanFulfilmentInput build() {
      return new CreateFulfilmentPlanFulfilmentInput(fulfilmentType, locationRef, eta, items);
    }
  }
}
