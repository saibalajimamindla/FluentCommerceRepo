package com.fluentcommerce.commonv2.graphql.mutation.wave;

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
import com.fluentcommerce.commonv2.graphql.type.UpdateWaveInput;
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
public final class UpdateWaveMutation implements Mutation<UpdateWaveMutation.Data, UpdateWaveMutation.Data, UpdateWaveMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdateWave($input: UpdateWaveInput) {\n"
      + "  updateWave(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "UpdateWave";
    }
  };

  private final UpdateWaveMutation.Variables variables;

  public UpdateWaveMutation(@Nullable UpdateWaveInput input) {
    variables = new UpdateWaveMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "49b5903df30bfdcf5ee8cb0c4343243da90087c6fdb97914a28c4bf7109eef8a";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public UpdateWaveMutation.Data wrapData(UpdateWaveMutation.Data data) {
    return data;
  }

  @Override
  public UpdateWaveMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<UpdateWaveMutation.Data> responseFieldMapper() {
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
    private @Nullable UpdateWaveInput input;

    Builder() {
    }

    public Builder input(@Nullable UpdateWaveInput input) {
      this.input = input;
      return this;
    }

    public UpdateWaveMutation build() {
      return new UpdateWaveMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable UpdateWaveInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable UpdateWaveInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable UpdateWaveInput input() {
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
      ResponseField.forObject("updateWave", "updateWave", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdateWave updateWave;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdateWave updateWave) {
      this.updateWave = updateWave;
    }

    public @Nullable UpdateWave updateWave() {
      return this.updateWave;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updateWave != null ? updateWave.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateWave=" + updateWave
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
        return ((this.updateWave == null) ? (that.updateWave == null) : this.updateWave.equals(that.updateWave));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updateWave == null) ? 0 : updateWave.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.updateWave = updateWave;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdateWave.Mapper updateWaveFieldMapper = new UpdateWave.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdateWave updateWave = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdateWave>() {
          @Override
          public UpdateWave read(ResponseReader reader) {
            return updateWaveFieldMapper.map(reader);
          }
        });
        return new Data(updateWave);
      }
    }

    public static final class Builder {
      private @Nullable UpdateWave updateWave;

      Builder() {
      }

      public Builder updateWave(@Nullable UpdateWave updateWave) {
        this.updateWave = updateWave;
        return this;
      }

      public Builder updateWave(@Nonnull Mutator<UpdateWave.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        UpdateWave.Builder builder = this.updateWave != null ? this.updateWave.toBuilder() : UpdateWave.builder();
        mutator.accept(builder);
        this.updateWave = builder.build();
        return this;
      }

      public Data build() {
        return new Data(updateWave);
      }
    }
  }

  public static class UpdateWave {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public UpdateWave(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "UpdateWave{"
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
      if (o instanceof UpdateWave) {
        UpdateWave that = (UpdateWave) o;
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

    public static final class Mapper implements ResponseFieldMapper<UpdateWave> {
      @Override
      public UpdateWave map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new UpdateWave(__typename, id);
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

      public UpdateWave build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new UpdateWave(__typename, id);
      }
    }
  }
}
