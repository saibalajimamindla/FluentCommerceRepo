package com.fluentcommerce.commonv2.graphql.mutation.fulfilment;

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
import com.fluentcommerce.commonv2.graphql.type.CreateFulfilmentInput;
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
public final class CreateFulfilmentMutation implements Mutation<CreateFulfilmentMutation.Data, CreateFulfilmentMutation.Data, CreateFulfilmentMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation CreateFulfilment($input: CreateFulfilmentInput!) {\n"
      + "  createFulfilment(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "CreateFulfilment";
    }
  };

  private final CreateFulfilmentMutation.Variables variables;

  public CreateFulfilmentMutation(@Nonnull CreateFulfilmentInput input) {
    Utils.checkNotNull(input, "input == null");
    variables = new CreateFulfilmentMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "e42cbfce0c19b956bf66d1c0cb1bec578d7e4b16425b762dbc9bdb88e13d2b4b";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateFulfilmentMutation.Data wrapData(CreateFulfilmentMutation.Data data) {
    return data;
  }

  @Override
  public CreateFulfilmentMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateFulfilmentMutation.Data> responseFieldMapper() {
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
    private @Nonnull CreateFulfilmentInput input;

    Builder() {
    }

    public Builder input(@Nonnull CreateFulfilmentInput input) {
      this.input = input;
      return this;
    }

    public CreateFulfilmentMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new CreateFulfilmentMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull CreateFulfilmentInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull CreateFulfilmentInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nonnull CreateFulfilmentInput input() {
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
          writer.writeObject("input", input.marshaller());
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("createFulfilment", "createFulfilment", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateFulfilment createFulfilment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateFulfilment createFulfilment) {
      this.createFulfilment = createFulfilment;
    }

    /**
     *  This mutation creates a `Fulfilment`, an orchestratable entity inside the Fluent ecosystem. If the `Fulfilment` is successfully created, a CREATE event will be generate associated with the mutation.<br/>A sample of the event generated:<br/>{<br/>&nbsp;&nbsp;&nbsp;&nbsp;"name": "CREATE",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"type": "NORMAL",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"entityRef": "FULFILMENT-001",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"entityType": "FULFILMENT",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"retailerId": "1",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"accountId": "ACCOUNT_ID"<br/>}<br/>
     */
    public @Nullable CreateFulfilment createFulfilment() {
      return this.createFulfilment;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createFulfilment != null ? createFulfilment.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createFulfilment=" + createFulfilment
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
        return ((this.createFulfilment == null) ? (that.createFulfilment == null) : this.createFulfilment.equals(that.createFulfilment));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createFulfilment == null) ? 0 : createFulfilment.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createFulfilment = createFulfilment;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateFulfilment.Mapper createFulfilmentFieldMapper = new CreateFulfilment.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateFulfilment createFulfilment = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateFulfilment>() {
          @Override
          public CreateFulfilment read(ResponseReader reader) {
            return createFulfilmentFieldMapper.map(reader);
          }
        });
        return new Data(createFulfilment);
      }
    }

    public static final class Builder {
      private @Nullable CreateFulfilment createFulfilment;

      Builder() {
      }

      public Builder createFulfilment(@Nullable CreateFulfilment createFulfilment) {
        this.createFulfilment = createFulfilment;
        return this;
      }

      public Builder createFulfilment(@Nonnull Mutator<CreateFulfilment.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateFulfilment.Builder builder = this.createFulfilment != null ? this.createFulfilment.toBuilder() : CreateFulfilment.builder();
        mutator.accept(builder);
        this.createFulfilment = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createFulfilment);
      }
    }
  }

  public static class CreateFulfilment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CreateFulfilment(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "CreateFulfilment{"
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
      if (o instanceof CreateFulfilment) {
        CreateFulfilment that = (CreateFulfilment) o;
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

    public static final class Mapper implements ResponseFieldMapper<CreateFulfilment> {
      @Override
      public CreateFulfilment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new CreateFulfilment(__typename, id);
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

      public CreateFulfilment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new CreateFulfilment(__typename, id);
      }
    }
  }
}
