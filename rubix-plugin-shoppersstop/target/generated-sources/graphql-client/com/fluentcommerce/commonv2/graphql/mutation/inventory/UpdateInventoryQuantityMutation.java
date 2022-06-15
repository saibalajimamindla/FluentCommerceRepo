package com.fluentcommerce.commonv2.graphql.mutation.inventory;

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
import com.fluentcommerce.commonv2.graphql.type.UpdateInventoryQuantityInput;
import java.io.IOException;
import java.lang.Integer;
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
public final class UpdateInventoryQuantityMutation implements Mutation<UpdateInventoryQuantityMutation.Data, UpdateInventoryQuantityMutation.Data, UpdateInventoryQuantityMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdateInventoryQuantity($input: UpdateInventoryQuantityInput) {\n"
      + "  updateInventoryQuantity(input: $input) {\n"
      + "    __typename\n"
      + "    ref\n"
      + "    status\n"
      + "    quantity\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "UpdateInventoryQuantity";
    }
  };

  private final UpdateInventoryQuantityMutation.Variables variables;

  public UpdateInventoryQuantityMutation(@Nullable UpdateInventoryQuantityInput input) {
    variables = new UpdateInventoryQuantityMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "5a6a46df5b27c0139e0a213c4ecec4b83a5276649094bf10fc6f3fbb57ef8efd";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public UpdateInventoryQuantityMutation.Data wrapData(UpdateInventoryQuantityMutation.Data data) {
    return data;
  }

  @Override
  public UpdateInventoryQuantityMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<UpdateInventoryQuantityMutation.Data> responseFieldMapper() {
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
    private @Nullable UpdateInventoryQuantityInput input;

    Builder() {
    }

    public Builder input(@Nullable UpdateInventoryQuantityInput input) {
      this.input = input;
      return this;
    }

    public UpdateInventoryQuantityMutation build() {
      return new UpdateInventoryQuantityMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable UpdateInventoryQuantityInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable UpdateInventoryQuantityInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable UpdateInventoryQuantityInput input() {
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
      ResponseField.forObject("updateInventoryQuantity", "updateInventoryQuantity", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdateInventoryQuantity updateInventoryQuantity;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdateInventoryQuantity updateInventoryQuantity) {
      this.updateInventoryQuantity = updateInventoryQuantity;
    }

    public @Nullable UpdateInventoryQuantity updateInventoryQuantity() {
      return this.updateInventoryQuantity;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updateInventoryQuantity != null ? updateInventoryQuantity.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateInventoryQuantity=" + updateInventoryQuantity
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
        return ((this.updateInventoryQuantity == null) ? (that.updateInventoryQuantity == null) : this.updateInventoryQuantity.equals(that.updateInventoryQuantity));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updateInventoryQuantity == null) ? 0 : updateInventoryQuantity.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.updateInventoryQuantity = updateInventoryQuantity;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdateInventoryQuantity.Mapper updateInventoryQuantityFieldMapper = new UpdateInventoryQuantity.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdateInventoryQuantity updateInventoryQuantity = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdateInventoryQuantity>() {
          @Override
          public UpdateInventoryQuantity read(ResponseReader reader) {
            return updateInventoryQuantityFieldMapper.map(reader);
          }
        });
        return new Data(updateInventoryQuantity);
      }
    }

    public static final class Builder {
      private @Nullable UpdateInventoryQuantity updateInventoryQuantity;

      Builder() {
      }

      public Builder updateInventoryQuantity(@Nullable UpdateInventoryQuantity updateInventoryQuantity) {
        this.updateInventoryQuantity = updateInventoryQuantity;
        return this;
      }

      public Builder updateInventoryQuantity(@Nonnull Mutator<UpdateInventoryQuantity.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        UpdateInventoryQuantity.Builder builder = this.updateInventoryQuantity != null ? this.updateInventoryQuantity.toBuilder() : UpdateInventoryQuantity.builder();
        mutator.accept(builder);
        this.updateInventoryQuantity = builder.build();
        return this;
      }

      public Data build() {
        return new Data(updateInventoryQuantity);
      }
    }
  }

  public static class UpdateInventoryQuantity {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String ref;

    final @Nullable String status;

    final @Nullable Integer quantity;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public UpdateInventoryQuantity(@Nonnull String __typename, @Nonnull String ref,
        @Nullable String status, @Nullable Integer quantity) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.status = status;
      this.quantity = quantity;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The unique reference identifier for the Inventory Quantity
     */
    public @Nonnull String ref() {
      return this.ref;
    }

    /**
     *  The current status of the `InventoryQuantity`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  The actual amount of this specific Quantity record
     */
    public @Nullable Integer quantity() {
      return this.quantity;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
          writer.writeString($responseFields[2], status);
          writer.writeInt($responseFields[3], quantity);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UpdateInventoryQuantity{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "quantity=" + quantity
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateInventoryQuantity) {
        UpdateInventoryQuantity that = (UpdateInventoryQuantity) o;
        return this.__typename.equals(that.__typename)
         && this.ref.equals(that.ref)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.quantity == null) ? (that.quantity == null) : this.quantity.equals(that.quantity));
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
        h ^= ref.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (quantity == null) ? 0 : quantity.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.ref = ref;
      builder.status = status;
      builder.quantity = quantity;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<UpdateInventoryQuantity> {
      @Override
      public UpdateInventoryQuantity map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        final String status = reader.readString($responseFields[2]);
        final Integer quantity = reader.readInt($responseFields[3]);
        return new UpdateInventoryQuantity(__typename, ref, status, quantity);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String ref;

      private @Nullable String status;

      private @Nullable Integer quantity;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder ref(@Nonnull String ref) {
        this.ref = ref;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder quantity(@Nullable Integer quantity) {
        this.quantity = quantity;
        return this;
      }

      public UpdateInventoryQuantity build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(ref, "ref == null");
        return new UpdateInventoryQuantity(__typename, ref, status, quantity);
      }
    }
  }
}
