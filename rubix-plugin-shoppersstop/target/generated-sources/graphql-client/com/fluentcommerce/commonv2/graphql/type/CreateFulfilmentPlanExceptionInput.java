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
public final class CreateFulfilmentPlanExceptionInput {
  private final Input<String> code;

  private final Input<String> message;

  private final Input<List<AttributeInput>> attributes;

  CreateFulfilmentPlanExceptionInput(Input<String> code, Input<String> message,
      Input<List<AttributeInput>> attributes) {
    this.code = code;
    this.message = message;
    this.attributes = attributes;
  }

  /**
   *  The exception code
   */
  public @Nullable String code() {
    return this.code.value;
  }

  /**
   *  The english like description of the exception
   */
  public @Nullable String message() {
    return this.message.value;
  }

  /**
   *  Attributes may contain useful information about the exception
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
        if (code.defined) {
          writer.writeString("code", code.value);
        }
        if (message.defined) {
          writer.writeString("message", message.value);
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
    private Input<String> code = Input.absent();

    private Input<String> message = Input.absent();

    private Input<List<AttributeInput>> attributes = Input.absent();

    Builder() {
    }

    /**
     *  The exception code
     */
    public Builder code(@Nullable String code) {
      this.code = Input.fromNullable(code);
      return this;
    }

    /**
     *  The english like description of the exception
     */
    public Builder message(@Nullable String message) {
      this.message = Input.fromNullable(message);
      return this;
    }

    /**
     *  Attributes may contain useful information about the exception
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    public CreateFulfilmentPlanExceptionInput build() {
      return new CreateFulfilmentPlanExceptionInput(code, message, attributes);
    }
  }
}
