package com.fluentcommerce.commonv2.graphql.mutation.carrier;

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
import com.fluentcommerce.commonv2.graphql.type.CreateCarrierConsignmentInput;
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
public final class CreateCarrierConsignmentMutation implements Mutation<CreateCarrierConsignmentMutation.Data, CreateCarrierConsignmentMutation.Data, CreateCarrierConsignmentMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation CreateCarrierConsignment($input: CreateCarrierConsignmentInput) {\n"
      + "  createCarrierConsignment(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "CreateCarrierConsignment";
    }
  };

  private final CreateCarrierConsignmentMutation.Variables variables;

  public CreateCarrierConsignmentMutation(@Nullable CreateCarrierConsignmentInput input) {
    variables = new CreateCarrierConsignmentMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "0c6229140a183aa4ad3897e9e2fbdf27126610a5783b30e0cff7b2a3529748be";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateCarrierConsignmentMutation.Data wrapData(CreateCarrierConsignmentMutation.Data data) {
    return data;
  }

  @Override
  public CreateCarrierConsignmentMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateCarrierConsignmentMutation.Data> responseFieldMapper() {
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
    private @Nullable CreateCarrierConsignmentInput input;

    Builder() {
    }

    public Builder input(@Nullable CreateCarrierConsignmentInput input) {
      this.input = input;
      return this;
    }

    public CreateCarrierConsignmentMutation build() {
      return new CreateCarrierConsignmentMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable CreateCarrierConsignmentInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable CreateCarrierConsignmentInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable CreateCarrierConsignmentInput input() {
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
      ResponseField.forObject("createCarrierConsignment", "createCarrierConsignment", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateCarrierConsignment createCarrierConsignment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateCarrierConsignment createCarrierConsignment) {
      this.createCarrierConsignment = createCarrierConsignment;
    }

    /**
     *  Creates a `CarrierConsignment`
     */
    public @Nullable CreateCarrierConsignment createCarrierConsignment() {
      return this.createCarrierConsignment;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createCarrierConsignment != null ? createCarrierConsignment.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createCarrierConsignment=" + createCarrierConsignment
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
        return ((this.createCarrierConsignment == null) ? (that.createCarrierConsignment == null) : this.createCarrierConsignment.equals(that.createCarrierConsignment));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createCarrierConsignment == null) ? 0 : createCarrierConsignment.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createCarrierConsignment = createCarrierConsignment;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateCarrierConsignment.Mapper createCarrierConsignmentFieldMapper = new CreateCarrierConsignment.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateCarrierConsignment createCarrierConsignment = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateCarrierConsignment>() {
          @Override
          public CreateCarrierConsignment read(ResponseReader reader) {
            return createCarrierConsignmentFieldMapper.map(reader);
          }
        });
        return new Data(createCarrierConsignment);
      }
    }

    public static final class Builder {
      private @Nullable CreateCarrierConsignment createCarrierConsignment;

      Builder() {
      }

      public Builder createCarrierConsignment(@Nullable CreateCarrierConsignment createCarrierConsignment) {
        this.createCarrierConsignment = createCarrierConsignment;
        return this;
      }

      public Builder createCarrierConsignment(@Nonnull Mutator<CreateCarrierConsignment.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateCarrierConsignment.Builder builder = this.createCarrierConsignment != null ? this.createCarrierConsignment.toBuilder() : CreateCarrierConsignment.builder();
        mutator.accept(builder);
        this.createCarrierConsignment = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createCarrierConsignment);
      }
    }
  }

  public static class CreateCarrierConsignment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CreateCarrierConsignment(@Nonnull String __typename, @Nonnull String id) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CreateCarrierConsignment{"
          + "__typename=" + __typename + ", "
          + "id=" + id
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof CreateCarrierConsignment) {
        CreateCarrierConsignment that = (CreateCarrierConsignment) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id);
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
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<CreateCarrierConsignment> {
      @Override
      public CreateCarrierConsignment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new CreateCarrierConsignment(__typename, id);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

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

      public CreateCarrierConsignment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new CreateCarrierConsignment(__typename, id);
      }
    }
  }
}
