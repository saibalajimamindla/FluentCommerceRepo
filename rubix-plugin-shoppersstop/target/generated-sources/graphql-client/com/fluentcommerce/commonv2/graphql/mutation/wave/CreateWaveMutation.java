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
import com.fluentcommerce.commonv2.graphql.type.CreateWaveInput;
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
public final class CreateWaveMutation implements Mutation<CreateWaveMutation.Data, CreateWaveMutation.Data, CreateWaveMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation createWave($input: CreateWaveInput) {\n"
      + "  createWave(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "createWave";
    }
  };

  private final CreateWaveMutation.Variables variables;

  public CreateWaveMutation(@Nullable CreateWaveInput input) {
    variables = new CreateWaveMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "e9865cef3efb497b3a8ec2165a84680d70ac5de78a9f94ad780ce17f4de548a5";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateWaveMutation.Data wrapData(CreateWaveMutation.Data data) {
    return data;
  }

  @Override
  public CreateWaveMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateWaveMutation.Data> responseFieldMapper() {
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
    private @Nullable CreateWaveInput input;

    Builder() {
    }

    public Builder input(@Nullable CreateWaveInput input) {
      this.input = input;
      return this;
    }

    public CreateWaveMutation build() {
      return new CreateWaveMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable CreateWaveInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable CreateWaveInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable CreateWaveInput input() {
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
      ResponseField.forObject("createWave", "createWave", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateWave createWave;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateWave createWave) {
      this.createWave = createWave;
    }

    /**
     *  This mutation creates a `Wave`, an orchestratable entity inside the Fluent ecosystem. If the `Wave` is successfully created, a CREATE event will be generate associated with the mutation.<br/>A sample of the event generated:<br/>{<br/>&nbsp;&nbsp;&nbsp;&nbsp;"name": "CREATE",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"type": "NORMAL",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"entityRef": "WAVE-001",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"entityType": "WAVE",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"retailerId": "1",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"accountId": "ACCOUNT_ID"<br/>}<br/>
     */
    public @Nullable CreateWave createWave() {
      return this.createWave;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createWave != null ? createWave.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createWave=" + createWave
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
        return ((this.createWave == null) ? (that.createWave == null) : this.createWave.equals(that.createWave));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createWave == null) ? 0 : createWave.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createWave = createWave;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateWave.Mapper createWaveFieldMapper = new CreateWave.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateWave createWave = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateWave>() {
          @Override
          public CreateWave read(ResponseReader reader) {
            return createWaveFieldMapper.map(reader);
          }
        });
        return new Data(createWave);
      }
    }

    public static final class Builder {
      private @Nullable CreateWave createWave;

      Builder() {
      }

      public Builder createWave(@Nullable CreateWave createWave) {
        this.createWave = createWave;
        return this;
      }

      public Builder createWave(@Nonnull Mutator<CreateWave.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateWave.Builder builder = this.createWave != null ? this.createWave.toBuilder() : CreateWave.builder();
        mutator.accept(builder);
        this.createWave = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createWave);
      }
    }
  }

  public static class CreateWave {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String ref;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CreateWave(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
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
     *  External reference of the object. Must be unique.
     */
    public @Nonnull String ref() {
      return this.ref;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CreateWave{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof CreateWave) {
        CreateWave that = (CreateWave) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.ref.equals(that.ref);
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
        h ^= ref.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      builder.ref = ref;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<CreateWave> {
      @Override
      public CreateWave map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        return new CreateWave(__typename, id, ref);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String ref;

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

      public Builder ref(@Nonnull String ref) {
        this.ref = ref;
        return this;
      }

      public CreateWave build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        return new CreateWave(__typename, id, ref);
      }
    }
  }
}
