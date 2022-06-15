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
import com.fluentcommerce.commonv2.graphql.type.CreateUserInput;
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
public final class CreateLocationUserMutation implements Mutation<CreateLocationUserMutation.Data, CreateLocationUserMutation.Data, CreateLocationUserMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation createLocationUser($input: CreateUserInput!) {\n"
      + "  createUser(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "createLocationUser";
    }
  };

  private final CreateLocationUserMutation.Variables variables;

  public CreateLocationUserMutation(@Nonnull CreateUserInput input) {
    Utils.checkNotNull(input, "input == null");
    variables = new CreateLocationUserMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "4bc0a5cef14f1805f216ac88a7fff3ae9da5e124c362adf7f06398be58144c14";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateLocationUserMutation.Data wrapData(CreateLocationUserMutation.Data data) {
    return data;
  }

  @Override
  public CreateLocationUserMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateLocationUserMutation.Data> responseFieldMapper() {
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
    private @Nonnull CreateUserInput input;

    Builder() {
    }

    public Builder input(@Nonnull CreateUserInput input) {
      this.input = input;
      return this;
    }

    public CreateLocationUserMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new CreateLocationUserMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull CreateUserInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull CreateUserInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nonnull CreateUserInput input() {
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
      ResponseField.forObject("createUser", "createUser", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateUser createUser;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateUser createUser) {
      this.createUser = createUser;
    }

    /**
     *  Creates a `User`
     */
    public @Nullable CreateUser createUser() {
      return this.createUser;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createUser != null ? createUser.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createUser=" + createUser
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
        return ((this.createUser == null) ? (that.createUser == null) : this.createUser.equals(that.createUser));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createUser == null) ? 0 : createUser.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createUser = createUser;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateUser.Mapper createUserFieldMapper = new CreateUser.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateUser createUser = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateUser>() {
          @Override
          public CreateUser read(ResponseReader reader) {
            return createUserFieldMapper.map(reader);
          }
        });
        return new Data(createUser);
      }
    }

    public static final class Builder {
      private @Nullable CreateUser createUser;

      Builder() {
      }

      public Builder createUser(@Nullable CreateUser createUser) {
        this.createUser = createUser;
        return this;
      }

      public Builder createUser(@Nonnull Mutator<CreateUser.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateUser.Builder builder = this.createUser != null ? this.createUser.toBuilder() : CreateUser.builder();
        mutator.accept(builder);
        this.createUser = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createUser);
      }
    }
  }

  public static class CreateUser {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CreateUser(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "CreateUser{"
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
      if (o instanceof CreateUser) {
        CreateUser that = (CreateUser) o;
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

    public static final class Mapper implements ResponseFieldMapper<CreateUser> {
      @Override
      public CreateUser map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new CreateUser(__typename, id);
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

      public CreateUser build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new CreateUser(__typename, id);
      }
    }
  }
}
