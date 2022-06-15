package com.fluentcommerce.commonv2.graphql.mutation.consignment;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.Mutator;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import com.fluentcommerce.commonv2.graphql.type.CreateConsignmentInput;
import com.fluentretail.graphql.type.CustomType;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateConsignmentMutation implements Mutation<CreateConsignmentMutation.Data, CreateConsignmentMutation.Data, CreateConsignmentMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation CreateConsignment($input: CreateConsignmentInput) {\n"
      + "  createConsignment(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    status\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "CreateConsignment";
    }
  };

  private final CreateConsignmentMutation.Variables variables;

  public CreateConsignmentMutation(@Nullable CreateConsignmentInput input) {
    variables = new CreateConsignmentMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "e7ec8ef5b7f28869148626d30a978415be9433bb9ff2623ae0ac697bf2d2f3b9";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateConsignmentMutation.Data wrapData(CreateConsignmentMutation.Data data) {
    return data;
  }

  @Override
  public CreateConsignmentMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateConsignmentMutation.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    private @Nullable CreateConsignmentInput input;

    Builder() {
    }

    public Builder input(@Nullable CreateConsignmentInput input) {
      this.input = input;
      return this;
    }

    public CreateConsignmentMutation build() {
      return new CreateConsignmentMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable CreateConsignmentInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable CreateConsignmentInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable CreateConsignmentInput input() {
      return input;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeObject("input", input != null ? input.marshaller() : null);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("createConsignment", "createConsignment", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateConsignment createConsignment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateConsignment createConsignment) {
      this.createConsignment = createConsignment;
    }

    public @Nullable CreateConsignment createConsignment() {
      return this.createConsignment;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createConsignment != null ? createConsignment.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createConsignment=" + createConsignment
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.createConsignment == null) ? (that.createConsignment == null) : this.createConsignment.equals(that.createConsignment));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createConsignment == null) ? 0 : createConsignment.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createConsignment = createConsignment;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateConsignment.Mapper createConsignmentFieldMapper = new CreateConsignment.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateConsignment createConsignment = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateConsignment>() {
          @Override
          public CreateConsignment read(ResponseReader reader) {
            return createConsignmentFieldMapper.map(reader);
          }
        });
        return new Data(createConsignment);
      }
    }

    public static final class Builder {
      private @Nullable CreateConsignment createConsignment;

      Builder() {
      }

      public Builder createConsignment(@Nullable CreateConsignment createConsignment) {
        this.createConsignment = createConsignment;
        return this;
      }

      public Builder createConsignment(@Nonnull Mutator<CreateConsignment.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateConsignment.Builder builder = this.createConsignment != null ? this.createConsignment.toBuilder() : CreateConsignment.builder();
        mutator.accept(builder);
        this.createConsignment = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createConsignment);
      }
    }
  }

  public static class CreateConsignment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String status;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CreateConsignment(@Nonnull String __typename, @Nonnull String id,
        @Nullable String status) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.status = status;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  ID of the object
     */
    public @Nonnull String id() {
      return this.id;
    }

    /**
     *  The status of the consignment
     */
    public @Nullable String status() {
      return this.status;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], status);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CreateConsignment{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "status=" + status
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof CreateConsignment) {
        CreateConsignment that = (CreateConsignment) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= id.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      builder.status = status;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<CreateConsignment> {
      @Override
      public CreateConsignment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String status = reader.readString($responseFields[2]);
        return new CreateConsignment(__typename, id, status);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String status;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder id(@Nonnull String id) {
        this.id = id;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public CreateConsignment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new CreateConsignment(__typename, id, status);
      }
    }
  }
}
