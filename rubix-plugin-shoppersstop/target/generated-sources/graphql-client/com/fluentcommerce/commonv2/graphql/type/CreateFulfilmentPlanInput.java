package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateFulfilmentPlanInput {
  private final @Nonnull String ref;

  private final @Nonnull String type;

  private final Input<Integer> splits;

  private final Input<String> eta;

  private final int retailerId;

  private final Input<List<AttributeInput>> attributes;

  private final @Nonnull FulfilmentOptionId fulfilmentOptionId;

  private final Input<List<CreateFulfilmentPlanFulfilmentInput>> fulfilments;

  private final Input<List<CreateFulfilmentPlanExceptionInput>> exceptions;

  CreateFulfilmentPlanInput(@Nonnull String ref, @Nonnull String type, Input<Integer> splits,
      Input<String> eta, int retailerId, Input<List<AttributeInput>> attributes,
      @Nonnull FulfilmentOptionId fulfilmentOptionId,
      Input<List<CreateFulfilmentPlanFulfilmentInput>> fulfilments,
      Input<List<CreateFulfilmentPlanExceptionInput>> exceptions) {
    this.ref = ref;
    this.type = type;
    this.splits = splits;
    this.eta = eta;
    this.retailerId = retailerId;
    this.attributes = attributes;
    this.fulfilmentOptionId = fulfilmentOptionId;
    this.fulfilments = fulfilments;
    this.exceptions = exceptions;
  }

  /**
   *  External reference. Recommended to be unique.
   */
  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  Type of the `FulfilmentPlan`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
   */
  public @Nonnull String type() {
    return this.type;
  }

  /**
   *  Order split limits
   */
  public @Nullable Integer splits() {
    return this.splits.value;
  }

  /**
   *  ETA of the `FulfilmentPlan`. Although this can be set explicitly, we recommend that this be determined and set in the workflow.
   */
  public @Nullable String eta() {
    return this.eta.value;
  }

  /**
   *  ID of the retailer
   */
  public int retailerId() {
    return this.retailerId;
  }

  /**
   *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
   */
  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  /**
   *  associated `FulfilmentOption` object
   */
  public @Nonnull FulfilmentOptionId fulfilmentOptionId() {
    return this.fulfilmentOptionId;
  }

  /**
   *  Represents fulfilments under this Fulfilment Plan
   */
  public @Nullable List<CreateFulfilmentPlanFulfilmentInput> fulfilments() {
    return this.fulfilments.value;
  }

  /**
   *  A list of exceptions.
   */
  public @Nullable List<CreateFulfilmentPlanExceptionInput> exceptions() {
    return this.exceptions.value;
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
        if (splits.defined) {
          writer.writeInt("splits", splits.value);
        }
        if (eta.defined) {
          writer.writeString("eta", eta.value);
        }
        writer.writeInt("retailerId", retailerId);
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
        writer.writeObject("fulfilmentOptionId", fulfilmentOptionId.marshaller());
        if (fulfilments.defined) {
          writer.writeList("fulfilments", fulfilments.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (CreateFulfilmentPlanFulfilmentInput $item : fulfilments.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
        if (exceptions.defined) {
          writer.writeList("exceptions", exceptions.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (CreateFulfilmentPlanExceptionInput $item : exceptions.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private @Nonnull String type;

    private Input<Integer> splits = Input.absent();

    private Input<String> eta = Input.absent();

    private int retailerId;

    private Input<List<AttributeInput>> attributes = Input.absent();

    private @Nonnull FulfilmentOptionId fulfilmentOptionId;

    private Input<List<CreateFulfilmentPlanFulfilmentInput>> fulfilments = Input.absent();

    private Input<List<CreateFulfilmentPlanExceptionInput>> exceptions = Input.absent();

    Builder() {
    }

    /**
     *  External reference. Recommended to be unique.
     */
    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  Type of the `FulfilmentPlan`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     */
    public Builder type(@Nonnull String type) {
      this.type = type;
      return this;
    }

    /**
     *  Order split limits
     */
    public Builder splits(@Nullable Integer splits) {
      this.splits = Input.fromNullable(splits);
      return this;
    }

    /**
     *  ETA of the `FulfilmentPlan`. Although this can be set explicitly, we recommend that this be determined and set in the workflow.
     */
    public Builder eta(@Nullable String eta) {
      this.eta = Input.fromNullable(eta);
      return this;
    }

    /**
     *  ID of the retailer
     */
    public Builder retailerId(int retailerId) {
      this.retailerId = retailerId;
      return this;
    }

    /**
     *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    /**
     *  associated `FulfilmentOption` object
     */
    public Builder fulfilmentOptionId(@Nonnull FulfilmentOptionId fulfilmentOptionId) {
      this.fulfilmentOptionId = fulfilmentOptionId;
      return this;
    }

    /**
     *  Represents fulfilments under this Fulfilment Plan
     */
    public Builder fulfilments(@Nullable List<CreateFulfilmentPlanFulfilmentInput> fulfilments) {
      this.fulfilments = Input.fromNullable(fulfilments);
      return this;
    }

    /**
     *  A list of exceptions.
     */
    public Builder exceptions(@Nullable List<CreateFulfilmentPlanExceptionInput> exceptions) {
      this.exceptions = Input.fromNullable(exceptions);
      return this;
    }

    public CreateFulfilmentPlanInput build() {
      Utils.checkNotNull(ref, "ref == null");
      Utils.checkNotNull(type, "type == null");
      Utils.checkNotNull(fulfilmentOptionId, "fulfilmentOptionId == null");
      return new CreateFulfilmentPlanInput(ref, type, splits, eta, retailerId, attributes, fulfilmentOptionId, fulfilments, exceptions);
    }
  }
}
