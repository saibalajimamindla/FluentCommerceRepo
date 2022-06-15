package com.fluentcommerce.commonv2.graphql.mutation.customer;

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
import com.fluentcommerce.commonv2.graphql.type.UpdateCustomerAddressInput;
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
public final class UpdateCustomerAddressMutation implements Mutation<UpdateCustomerAddressMutation.Data, UpdateCustomerAddressMutation.Data, UpdateCustomerAddressMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdateCustomerAddress($input: UpdateCustomerAddressInput!) {\n"
      + "  updateCustomerAddress(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "UpdateCustomerAddress";
    }
  };

  private final UpdateCustomerAddressMutation.Variables variables;

  public UpdateCustomerAddressMutation(@Nonnull UpdateCustomerAddressInput input) {
    Utils.checkNotNull(input, "input == null");
    variables = new UpdateCustomerAddressMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "50c8852db8a706c7de8e0eee513a6d55e74fc4d4a16e68e7af9eee4519d4b783";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public UpdateCustomerAddressMutation.Data wrapData(UpdateCustomerAddressMutation.Data data) {
    return data;
  }

  @Override
  public UpdateCustomerAddressMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<UpdateCustomerAddressMutation.Data> responseFieldMapper() {
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
    private @Nonnull UpdateCustomerAddressInput input;

    Builder() {
    }

    public Builder input(@Nonnull UpdateCustomerAddressInput input) {
      this.input = input;
      return this;
    }

    public UpdateCustomerAddressMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new UpdateCustomerAddressMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull UpdateCustomerAddressInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull UpdateCustomerAddressInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nonnull UpdateCustomerAddressInput input() {
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
      ResponseField.forObject("updateCustomerAddress", "updateCustomerAddress", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdateCustomerAddress updateCustomerAddress;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdateCustomerAddress updateCustomerAddress) {
      this.updateCustomerAddress = updateCustomerAddress;
    }

    public @Nullable UpdateCustomerAddress updateCustomerAddress() {
      return this.updateCustomerAddress;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updateCustomerAddress != null ? updateCustomerAddress.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateCustomerAddress=" + updateCustomerAddress
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
        return ((this.updateCustomerAddress == null) ? (that.updateCustomerAddress == null) : this.updateCustomerAddress.equals(that.updateCustomerAddress));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updateCustomerAddress == null) ? 0 : updateCustomerAddress.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.updateCustomerAddress = updateCustomerAddress;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdateCustomerAddress.Mapper updateCustomerAddressFieldMapper = new UpdateCustomerAddress.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdateCustomerAddress updateCustomerAddress = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdateCustomerAddress>() {
          @Override
          public UpdateCustomerAddress read(ResponseReader reader) {
            return updateCustomerAddressFieldMapper.map(reader);
          }
        });
        return new Data(updateCustomerAddress);
      }
    }

    public static final class Builder {
      private @Nullable UpdateCustomerAddress updateCustomerAddress;

      Builder() {
      }

      public Builder updateCustomerAddress(@Nullable UpdateCustomerAddress updateCustomerAddress) {
        this.updateCustomerAddress = updateCustomerAddress;
        return this;
      }

      public Builder updateCustomerAddress(@Nonnull Mutator<UpdateCustomerAddress.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        UpdateCustomerAddress.Builder builder = this.updateCustomerAddress != null ? this.updateCustomerAddress.toBuilder() : UpdateCustomerAddress.builder();
        mutator.accept(builder);
        this.updateCustomerAddress = builder.build();
        return this;
      }

      public Data build() {
        return new Data(updateCustomerAddress);
      }
    }
  }

  public static class UpdateCustomerAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public UpdateCustomerAddress(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "UpdateCustomerAddress{"
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
      if (o instanceof UpdateCustomerAddress) {
        UpdateCustomerAddress that = (UpdateCustomerAddress) o;
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

    public static final class Mapper implements ResponseFieldMapper<UpdateCustomerAddress> {
      @Override
      public UpdateCustomerAddress map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new UpdateCustomerAddress(__typename, id);
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

      public UpdateCustomerAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new UpdateCustomerAddress(__typename, id);
      }
    }
  }
}
