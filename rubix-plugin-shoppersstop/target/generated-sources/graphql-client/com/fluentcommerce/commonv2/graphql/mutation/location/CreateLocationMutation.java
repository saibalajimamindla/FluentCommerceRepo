package com.fluentcommerce.commonv2.graphql.mutation.location;

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
import com.fluentcommerce.commonv2.graphql.type.CreateLocationInput;
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
public final class CreateLocationMutation implements Mutation<CreateLocationMutation.Data, CreateLocationMutation.Data, CreateLocationMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation createLocation($input: CreateLocationInput!) {\n"
      + "  createLocation(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "createLocation";
    }
  };

  private final CreateLocationMutation.Variables variables;

  public CreateLocationMutation(@Nonnull CreateLocationInput input) {
    Utils.checkNotNull(input, "input == null");
    variables = new CreateLocationMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "8bfa87f45c15906c7d4f70f9acb018e6f27c197e3d092defb5c6a9b48770e345";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateLocationMutation.Data wrapData(CreateLocationMutation.Data data) {
    return data;
  }

  @Override
  public CreateLocationMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateLocationMutation.Data> responseFieldMapper() {
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
    private @Nonnull CreateLocationInput input;

    Builder() {
    }

    public Builder input(@Nonnull CreateLocationInput input) {
      this.input = input;
      return this;
    }

    public CreateLocationMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new CreateLocationMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull CreateLocationInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull CreateLocationInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nonnull CreateLocationInput input() {
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
      ResponseField.forObject("createLocation", "createLocation", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateLocation createLocation;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateLocation createLocation) {
      this.createLocation = createLocation;
    }

    public @Nullable CreateLocation createLocation() {
      return this.createLocation;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createLocation != null ? createLocation.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createLocation=" + createLocation
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
        return ((this.createLocation == null) ? (that.createLocation == null) : this.createLocation.equals(that.createLocation));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createLocation == null) ? 0 : createLocation.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createLocation = createLocation;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateLocation.Mapper createLocationFieldMapper = new CreateLocation.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateLocation createLocation = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateLocation>() {
          @Override
          public CreateLocation read(ResponseReader reader) {
            return createLocationFieldMapper.map(reader);
          }
        });
        return new Data(createLocation);
      }
    }

    public static final class Builder {
      private @Nullable CreateLocation createLocation;

      Builder() {
      }

      public Builder createLocation(@Nullable CreateLocation createLocation) {
        this.createLocation = createLocation;
        return this;
      }

      public Builder createLocation(@Nonnull Mutator<CreateLocation.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateLocation.Builder builder = this.createLocation != null ? this.createLocation.toBuilder() : CreateLocation.builder();
        mutator.accept(builder);
        this.createLocation = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createLocation);
      }
    }
  }

  public static class CreateLocation {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CreateLocation(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "CreateLocation{"
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
      if (o instanceof CreateLocation) {
        CreateLocation that = (CreateLocation) o;
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

    public static final class Mapper implements ResponseFieldMapper<CreateLocation> {
      @Override
      public CreateLocation map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new CreateLocation(__typename, id);
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

      public CreateLocation build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new CreateLocation(__typename, id);
      }
    }
  }
}
