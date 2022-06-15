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
public final class CreateWaveInput {
  private final @Nonnull String ref;

  private final Input<String> name;

  private final @Nonnull String type;

  private final Input<List<AttributeInput>> attributes;

  private final @Nonnull RetailerId retailer;

  private final @Nonnull LocationId location;

  private final @Nonnull List<FulfilmentId> fulfilments;

  private final Input<UserId> allocatedTo;

  CreateWaveInput(@Nonnull String ref, Input<String> name, @Nonnull String type,
      Input<List<AttributeInput>> attributes, @Nonnull RetailerId retailer,
      @Nonnull LocationId location, @Nonnull List<FulfilmentId> fulfilments,
      Input<UserId> allocatedTo) {
    this.ref = ref;
    this.name = name;
    this.type = type;
    this.attributes = attributes;
    this.retailer = retailer;
    this.location = location;
    this.fulfilments = fulfilments;
    this.allocatedTo = allocatedTo;
  }

  /**
   *  External reference of the object. Must be unique.
   */
  public @Nonnull String ref() {
    return this.ref;
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
  public @Nonnull String type() {
    return this.type;
  }

  /**
   *  A list of attributes associated with this wave. Attributes can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
   */
  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  /**
   *  `Retailer` of the wave
   */
  public @Nonnull RetailerId retailer() {
    return this.retailer;
  }

  /**
   *  `Location` of the wave operation
   */
  public @Nonnull LocationId location() {
    return this.location;
  }

  /**
   *  `Fulfilment`s associated with this wave
   */
  public @Nonnull List<FulfilmentId> fulfilments() {
    return this.fulfilments;
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
        writer.writeString("ref", ref);
        if (name.defined) {
          writer.writeString("name", name.value);
        }
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
        writer.writeObject("retailer", retailer.marshaller());
        writer.writeObject("location", location.marshaller());
        writer.writeList("fulfilments", new InputFieldWriter.ListWriter() {
          @Override
          public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
            for (FulfilmentId $item : fulfilments) {
              listItemWriter.writeObject($item.marshaller());
            }
          }
        });
        if (allocatedTo.defined) {
          writer.writeObject("allocatedTo", allocatedTo.value != null ? allocatedTo.value.marshaller() : null);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private Input<String> name = Input.absent();

    private @Nonnull String type;

    private Input<List<AttributeInput>> attributes = Input.absent();

    private @Nonnull RetailerId retailer;

    private @Nonnull LocationId location;

    private @Nonnull List<FulfilmentId> fulfilments;

    private Input<UserId> allocatedTo = Input.absent();

    Builder() {
    }

    /**
     *  External reference of the object. Must be unique.
     */
    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
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
    public Builder type(@Nonnull String type) {
      this.type = type;
      return this;
    }

    /**
     *  A list of attributes associated with this wave. Attributes can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    /**
     *  `Retailer` of the wave
     */
    public Builder retailer(@Nonnull RetailerId retailer) {
      this.retailer = retailer;
      return this;
    }

    /**
     *  `Location` of the wave operation
     */
    public Builder location(@Nonnull LocationId location) {
      this.location = location;
      return this;
    }

    /**
     *  `Fulfilment`s associated with this wave
     */
    public Builder fulfilments(@Nonnull List<FulfilmentId> fulfilments) {
      this.fulfilments = fulfilments;
      return this;
    }

    /**
     *  `User` who this wave is assigned to
     */
    public Builder allocatedTo(@Nullable UserId allocatedTo) {
      this.allocatedTo = Input.fromNullable(allocatedTo);
      return this;
    }

    public CreateWaveInput build() {
      Utils.checkNotNull(ref, "ref == null");
      Utils.checkNotNull(type, "type == null");
      Utils.checkNotNull(retailer, "retailer == null");
      Utils.checkNotNull(location, "location == null");
      Utils.checkNotNull(fulfilments, "fulfilments == null");
      return new CreateWaveInput(ref, name, type, attributes, retailer, location, fulfilments, allocatedTo);
    }
  }
}
