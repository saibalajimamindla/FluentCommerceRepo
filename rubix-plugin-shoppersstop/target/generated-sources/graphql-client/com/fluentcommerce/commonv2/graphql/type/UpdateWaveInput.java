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
public final class UpdateWaveInput {
  private final @Nonnull String id;

  private final Input<String> name;

  private final Input<String> type;

  private final Input<String> status;

  private final Input<List<AttributeInput>> attributes;

  private final Input<List<FulfilmentId>> fulfilments;

  private final Input<UserId> allocatedTo;

  UpdateWaveInput(@Nonnull String id, Input<String> name, Input<String> type, Input<String> status,
      Input<List<AttributeInput>> attributes, Input<List<FulfilmentId>> fulfilments,
      Input<UserId> allocatedTo) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.status = status;
    this.attributes = attributes;
    this.fulfilments = fulfilments;
    this.allocatedTo = allocatedTo;
  }

  /**
   *  ID of the `Wave` to be updated
   */
  public @Nonnull String id() {
    return this.id;
  }

  /**
   *  Name of the wave
   */
  public @Nullable String name() {
    return this.name.value;
  }

  /**
   *  Type of the `Wave`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
   */
  public @Nullable String type() {
    return this.type.value;
  }

  /**
   *  The current status of the `Wave`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
   */
  public @Nullable String status() {
    return this.status.value;
  }

  /**
   *  A list of attributes associated with this wave. `Attribute`s can be used to extend the existing data structure with additional data for use in orchestration rules, UI etc.
   */
  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  /**
   *  Fulfilments associated with this wave. This field can be used to add new fulfilments to the wave. Existing fulfilments can't be deleted.
   */
  public @Nullable List<FulfilmentId> fulfilments() {
    return this.fulfilments.value;
  }

  /**
   *  `User` who this wave is assigned to
   */
  public @Nullable UserId allocatedTo() {
    return this.allocatedTo.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeCustom("id", com.fluentretail.graphql.type.CustomType.ID, id);
        if (name.defined) {
          writer.writeString("name", name.value);
        }
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
        if (fulfilments.defined) {
          writer.writeList("fulfilments", fulfilments.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (FulfilmentId $item : fulfilments.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
        if (allocatedTo.defined) {
          writer.writeObject("allocatedTo", allocatedTo.value != null ? allocatedTo.value.marshaller() : null);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String id;

    private Input<String> name = Input.absent();

    private Input<String> type = Input.absent();

    private Input<String> status = Input.absent();

    private Input<List<AttributeInput>> attributes = Input.absent();

    private Input<List<FulfilmentId>> fulfilments = Input.absent();

    private Input<UserId> allocatedTo = Input.absent();

    Builder() {
    }

    /**
     *  ID of the `Wave` to be updated
     */
    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    /**
     *  Name of the wave
     */
    public Builder name(@Nullable String name) {
      this.name = Input.fromNullable(name);
      return this;
    }

    /**
     *  Type of the `Wave`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     */
    public Builder type(@Nullable String type) {
      this.type = Input.fromNullable(type);
      return this;
    }

    /**
     *  The current status of the `Wave`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public Builder status(@Nullable String status) {
      this.status = Input.fromNullable(status);
      return this;
    }

    /**
     *  A list of attributes associated with this wave. `Attribute`s can be used to extend the existing data structure with additional data for use in orchestration rules, UI etc.
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    /**
     *  Fulfilments associated with this wave. This field can be used to add new fulfilments to the wave. Existing fulfilments can't be deleted.
     */
    public Builder fulfilments(@Nullable List<FulfilmentId> fulfilments) {
      this.fulfilments = Input.fromNullable(fulfilments);
      return this;
    }

    /**
     *  `User` who this wave is assigned to
     */
    public Builder allocatedTo(@Nullable UserId allocatedTo) {
      this.allocatedTo = Input.fromNullable(allocatedTo);
      return this;
    }

    public UpdateWaveInput build() {
      Utils.checkNotNull(id, "id == null");
      return new UpdateWaveInput(id, name, type, status, attributes, fulfilments, allocatedTo);
    }
  }
}
