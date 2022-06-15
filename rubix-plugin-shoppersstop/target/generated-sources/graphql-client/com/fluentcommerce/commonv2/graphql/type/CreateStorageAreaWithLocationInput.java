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
public final class CreateStorageAreaWithLocationInput {
  private final @Nonnull String ref;

  private final Input<String> type;

  private final Input<List<AttributeInput>> attributes;

  CreateStorageAreaWithLocationInput(@Nonnull String ref, Input<String> type,
      Input<List<AttributeInput>> attributes) {
    this.ref = ref;
    this.type = type;
    this.attributes = attributes;
  }

  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  Max character limit: 50.
   */
  public @Nullable String type() {
    return this.type.value;
  }

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
        writer.writeString("ref", ref);
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
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private Input<String> type = Input.absent();

    private Input<List<AttributeInput>> attributes = Input.absent();

    Builder() {
    }

    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  Max character limit: 50.
     */
    public Builder type(@Nullable String type) {
      this.type = Input.fromNullable(type);
      return this;
    }

    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    public CreateStorageAreaWithLocationInput build() {
      Utils.checkNotNull(ref, "ref == null");
      return new CreateStorageAreaWithLocationInput(ref, type, attributes);
    }
  }
}
