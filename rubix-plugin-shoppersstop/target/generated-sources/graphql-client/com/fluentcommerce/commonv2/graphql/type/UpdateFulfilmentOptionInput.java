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
public final class UpdateFulfilmentOptionInput {
  private final @Nonnull String id;

  private final Input<String> ref;

  private final Input<String> status;

  private final Input<String> trackingCode;

  private final Input<List<AttributeInput>> attributes;

  UpdateFulfilmentOptionInput(@Nonnull String id, Input<String> ref, Input<String> status,
      Input<String> trackingCode, Input<List<AttributeInput>> attributes) {
    this.id = id;
    this.ref = ref;
    this.status = status;
    this.trackingCode = trackingCode;
    this.attributes = attributes;
  }

  /**
   *  ID of the object. If provided, will be used to identify the object.
   */
  public @Nonnull String id() {
    return this.id;
  }

  /**
   *  External reference. If provided, will be used to identify the object.
   */
  public @Nullable String ref() {
    return this.ref.value;
  }

  /**
   *  The current status of the `FulfilmentOption`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
   */
  public @Nullable String status() {
    return this.status.value;
  }

  /**
   *  A unique identifier for the clients to group related Fulfilment Plans.
   */
  public @Nullable String trackingCode() {
    return this.trackingCode.value;
  }

  /**
   *  A list of attributes associated with this object. This can be used to extend an existing object with additional data for use in orchestration rules, etc.
   */
  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
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
        if (trackingCode.defined) {
          writer.writeString("trackingCode", trackingCode.value);
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
      }
    };
  }

  public static final class Builder {
    private @Nonnull String id;

    private Input<String> ref = Input.absent();

    private Input<String> status = Input.absent();

    private Input<String> trackingCode = Input.absent();

    private Input<List<AttributeInput>> attributes = Input.absent();

    Builder() {
    }

    /**
     *  ID of the object. If provided, will be used to identify the object.
     */
    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    /**
     *  External reference. If provided, will be used to identify the object.
     */
    public Builder ref(@Nullable String ref) {
      this.ref = Input.fromNullable(ref);
      return this;
    }

    /**
     *  The current status of the `FulfilmentOption`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public Builder status(@Nullable String status) {
      this.status = Input.fromNullable(status);
      return this;
    }

    /**
     *  A unique identifier for the clients to group related Fulfilment Plans.
     */
    public Builder trackingCode(@Nullable String trackingCode) {
      this.trackingCode = Input.fromNullable(trackingCode);
      return this;
    }

    /**
     *  A list of attributes associated with this object. This can be used to extend an existing object with additional data for use in orchestration rules, etc.
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    public UpdateFulfilmentOptionInput build() {
      Utils.checkNotNull(id, "id == null");
      return new UpdateFulfilmentOptionInput(id, ref, status, trackingCode, attributes);
    }
  }
}
