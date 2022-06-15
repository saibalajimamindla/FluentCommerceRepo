package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class UpdateFulfilmentPlanInput {
  private final @Nonnull String id;

  private final Input<String> ref;

  private final Input<String> status;

  private final Input<String> eta;

  private final Input<List<AttributeInput>> attributes;

  private final Input<List<CreateFulfilmentPlanExceptionInput>> exceptions;

  UpdateFulfilmentPlanInput(@Nonnull String id, Input<String> ref, Input<String> status,
      Input<String> eta, Input<List<AttributeInput>> attributes,
      Input<List<CreateFulfilmentPlanExceptionInput>> exceptions) {
    this.id = id;
    this.ref = ref;
    this.status = status;
    this.eta = eta;
    this.attributes = attributes;
    this.exceptions = exceptions;
  }

  /**
   *  ID of the object
   */
  public @Nonnull String id() {
    return this.id;
  }

  /**
   *  External reference. Recommended to be unique.
   */
  public @Nullable String ref() {
    return this.ref.value;
  }

  /**
   *  The current status of the `FulfilmentPlan`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
   */
  public @Nullable String status() {
    return this.status.value;
  }

  /**
   *  ETA of the `FulfilmentPlan`. Although this can be set explicitly, we recommend that this be determined and set in the workflow.
   */
  public @Nullable String eta() {
    return this.eta.value;
  }

  /**
   *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
   */
  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  /**
   *  A list of exceptions.
   *  **Note** <br /><br />
   *  This will always be an append operation. Existing exceptions can not be modified but new ones can be added.
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
        writer.writeCustom("id", com.fluentretail.graphql.type.CustomType.ID, id);
        if (ref.defined) {
          writer.writeString("ref", ref.value);
        }
        if (status.defined) {
          writer.writeString("status", status.value);
        }
        if (eta.defined) {
          writer.writeString("eta", eta.value);
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
    private @Nonnull String id;

    private Input<String> ref = Input.absent();

    private Input<String> status = Input.absent();

    private Input<String> eta = Input.absent();

    private Input<List<AttributeInput>> attributes = Input.absent();

    private Input<List<CreateFulfilmentPlanExceptionInput>> exceptions = Input.absent();

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
     *  External reference. Recommended to be unique.
     */
    public Builder ref(@Nullable String ref) {
      this.ref = Input.fromNullable(ref);
      return this;
    }

    /**
     *  The current status of the `FulfilmentPlan`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public Builder status(@Nullable String status) {
      this.status = Input.fromNullable(status);
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
     *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    /**
     *  A list of exceptions.
     *  **Note** <br /><br />
     *  This will always be an append operation. Existing exceptions can not be modified but new ones can be added.
     */
    public Builder exceptions(@Nullable List<CreateFulfilmentPlanExceptionInput> exceptions) {
      this.exceptions = Input.fromNullable(exceptions);
      return this;
    }

    public UpdateFulfilmentPlanInput build() {
      Utils.checkNotNull(id, "id == null");
      return new UpdateFulfilmentPlanInput(id, ref, status, eta, attributes, exceptions);
    }
  }
}
