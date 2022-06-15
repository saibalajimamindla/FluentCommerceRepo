package com.fluentcommerce.commonv2.graphql.mutation.fulfilmentOption;

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
import com.fluentcommerce.commonv2.graphql.type.CreateFulfilmentPlanInput;
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
public final class CreateFulfilmentPlanMutation implements Mutation<CreateFulfilmentPlanMutation.Data, CreateFulfilmentPlanMutation.Data, CreateFulfilmentPlanMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation createFulfilmentPlan($input: CreateFulfilmentPlanInput!) {\n"
      + "  createFulfilmentPlan(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "createFulfilmentPlan";
    }
  };

  private final CreateFulfilmentPlanMutation.Variables variables;

  public CreateFulfilmentPlanMutation(@Nonnull CreateFulfilmentPlanInput input) {
    Utils.checkNotNull(input, "input == null");
    variables = new CreateFulfilmentPlanMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "b3fa3b7b6e0a84fee52231e453cabb74e415b0976291fa5d2965e138f01bf7a5";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateFulfilmentPlanMutation.Data wrapData(CreateFulfilmentPlanMutation.Data data) {
    return data;
  }

  @Override
  public CreateFulfilmentPlanMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateFulfilmentPlanMutation.Data> responseFieldMapper() {
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
    private @Nonnull CreateFulfilmentPlanInput input;

    Builder() {
    }

    public Builder input(@Nonnull CreateFulfilmentPlanInput input) {
      this.input = input;
      return this;
    }

    public CreateFulfilmentPlanMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new CreateFulfilmentPlanMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull CreateFulfilmentPlanInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull CreateFulfilmentPlanInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nonnull CreateFulfilmentPlanInput input() {
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
      ResponseField.forObject("createFulfilmentPlan", "createFulfilmentPlan", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateFulfilmentPlan createFulfilmentPlan;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateFulfilmentPlan createFulfilmentPlan) {
      this.createFulfilmentPlan = createFulfilmentPlan;
    }

    /**
     *  This mutation creates a `FulfilmentPlan`, an orchestratable entity inside the Fluent ecosystem. If the `FulfilmentPlan` is successfully created, a CREATE event will be generate associated with the mutation.<br/>A sample of the event generated:<br/>{<br/>&nbsp;&nbsp;&nbsp;&nbsp;"name": "CREATE",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"type": "NORMAL",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"entityRef": "FULFILMENTPLAN-001",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"entityType": "FULFILMENTPLAN",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"retailerId": "1",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"accountId": "ACCOUNT_ID"<br/>}<br/>
     */
    public @Nullable CreateFulfilmentPlan createFulfilmentPlan() {
      return this.createFulfilmentPlan;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createFulfilmentPlan != null ? createFulfilmentPlan.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createFulfilmentPlan=" + createFulfilmentPlan
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
        return ((this.createFulfilmentPlan == null) ? (that.createFulfilmentPlan == null) : this.createFulfilmentPlan.equals(that.createFulfilmentPlan));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createFulfilmentPlan == null) ? 0 : createFulfilmentPlan.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createFulfilmentPlan = createFulfilmentPlan;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateFulfilmentPlan.Mapper createFulfilmentPlanFieldMapper = new CreateFulfilmentPlan.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateFulfilmentPlan createFulfilmentPlan = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateFulfilmentPlan>() {
          @Override
          public CreateFulfilmentPlan read(ResponseReader reader) {
            return createFulfilmentPlanFieldMapper.map(reader);
          }
        });
        return new Data(createFulfilmentPlan);
      }
    }

    public static final class Builder {
      private @Nullable CreateFulfilmentPlan createFulfilmentPlan;

      Builder() {
      }

      public Builder createFulfilmentPlan(@Nullable CreateFulfilmentPlan createFulfilmentPlan) {
        this.createFulfilmentPlan = createFulfilmentPlan;
        return this;
      }

      public Builder createFulfilmentPlan(@Nonnull Mutator<CreateFulfilmentPlan.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateFulfilmentPlan.Builder builder = this.createFulfilmentPlan != null ? this.createFulfilmentPlan.toBuilder() : CreateFulfilmentPlan.builder();
        mutator.accept(builder);
        this.createFulfilmentPlan = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createFulfilmentPlan);
      }
    }
  }

  public static class CreateFulfilmentPlan {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CreateFulfilmentPlan(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "CreateFulfilmentPlan{"
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
      if (o instanceof CreateFulfilmentPlan) {
        CreateFulfilmentPlan that = (CreateFulfilmentPlan) o;
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

    public static final class Mapper implements ResponseFieldMapper<CreateFulfilmentPlan> {
      @Override
      public CreateFulfilmentPlan map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new CreateFulfilmentPlan(__typename, id);
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

      public CreateFulfilmentPlan build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new CreateFulfilmentPlan(__typename, id);
      }
    }
  }
}
