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
import com.fluentretail.graphql.type.CustomType;
import com.fluentcommerce.commonv2.graphql.type.UpdateConsignmentInput;
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
public final class UpdateConsignmentMutation implements Mutation<UpdateConsignmentMutation.Data, UpdateConsignmentMutation.Data, UpdateConsignmentMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdateConsignment($input: UpdateConsignmentInput) {\n"
      + "  updateConsignment(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    status\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "UpdateConsignment";
    }
  };

  private final UpdateConsignmentMutation.Variables variables;

  public UpdateConsignmentMutation(@Nullable UpdateConsignmentInput input) {
    variables = new UpdateConsignmentMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "6f00eb117f00eea1de47ae282ce74eceeccf0fe813c5ad2cdee4b1a9a2937d84";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public UpdateConsignmentMutation.Data wrapData(UpdateConsignmentMutation.Data data) {
    return data;
  }

  @Override
  public UpdateConsignmentMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<UpdateConsignmentMutation.Data> responseFieldMapper() {
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
    private @Nullable UpdateConsignmentInput input;

    Builder() {
    }

    public Builder input(@Nullable UpdateConsignmentInput input) {
      this.input = input;
      return this;
    }

    public UpdateConsignmentMutation build() {
      return new UpdateConsignmentMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable UpdateConsignmentInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable UpdateConsignmentInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable UpdateConsignmentInput input() {
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
      ResponseField.forObject("updateConsignment", "updateConsignment", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdateConsignment updateConsignment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdateConsignment updateConsignment) {
      this.updateConsignment = updateConsignment;
    }

    public @Nullable UpdateConsignment updateConsignment() {
      return this.updateConsignment;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updateConsignment != null ? updateConsignment.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateConsignment=" + updateConsignment
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
        return ((this.updateConsignment == null) ? (that.updateConsignment == null) : this.updateConsignment.equals(that.updateConsignment));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updateConsignment == null) ? 0 : updateConsignment.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.updateConsignment = updateConsignment;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdateConsignment.Mapper updateConsignmentFieldMapper = new UpdateConsignment.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdateConsignment updateConsignment = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdateConsignment>() {
          @Override
          public UpdateConsignment read(ResponseReader reader) {
            return updateConsignmentFieldMapper.map(reader);
          }
        });
        return new Data(updateConsignment);
      }
    }

    public static final class Builder {
      private @Nullable UpdateConsignment updateConsignment;

      Builder() {
      }

      public Builder updateConsignment(@Nullable UpdateConsignment updateConsignment) {
        this.updateConsignment = updateConsignment;
        return this;
      }

      public Builder updateConsignment(@Nonnull Mutator<UpdateConsignment.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        UpdateConsignment.Builder builder = this.updateConsignment != null ? this.updateConsignment.toBuilder() : UpdateConsignment.builder();
        mutator.accept(builder);
        this.updateConsignment = builder.build();
        return this;
      }

      public Data build() {
        return new Data(updateConsignment);
      }
    }
  }

  public static class UpdateConsignment {
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

    public UpdateConsignment(@Nonnull String __typename, @Nonnull String id,
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
        $toString = "UpdateConsignment{"
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
      if (o instanceof UpdateConsignment) {
        UpdateConsignment that = (UpdateConsignment) o;
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

    public static final class Mapper implements ResponseFieldMapper<UpdateConsignment> {
      @Override
      public UpdateConsignment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String status = reader.readString($responseFields[2]);
        return new UpdateConsignment(__typename, id, status);
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

      public UpdateConsignment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new UpdateConsignment(__typename, id, status);
      }
    }
  }
}
