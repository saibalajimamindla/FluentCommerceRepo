package com.fluentcommerce.commonv2.graphql.mutation.common;

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
import com.fluentcommerce.commonv2.graphql.type.CreateCommentInput;
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
public final class CreateCommentForEntityMutation implements Mutation<CreateCommentForEntityMutation.Data, CreateCommentForEntityMutation.Data, CreateCommentForEntityMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation CreateCommentForEntity($input: CreateCommentInput) {\n"
      + "  createComment(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "CreateCommentForEntity";
    }
  };

  private final CreateCommentForEntityMutation.Variables variables;

  public CreateCommentForEntityMutation(@Nullable CreateCommentInput input) {
    variables = new CreateCommentForEntityMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "42742a822ae6f2626677fbe89adf7ffe5d1582a76ab6d5c95a3851c61c92182f";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateCommentForEntityMutation.Data wrapData(CreateCommentForEntityMutation.Data data) {
    return data;
  }

  @Override
  public CreateCommentForEntityMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateCommentForEntityMutation.Data> responseFieldMapper() {
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
    private @Nullable CreateCommentInput input;

    Builder() {
    }

    public Builder input(@Nullable CreateCommentInput input) {
      this.input = input;
      return this;
    }

    public CreateCommentForEntityMutation build() {
      return new CreateCommentForEntityMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable CreateCommentInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable CreateCommentInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable CreateCommentInput input() {
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
      ResponseField.forObject("createComment", "createComment", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateComment createComment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateComment createComment) {
      this.createComment = createComment;
    }

    /**
     *  Creates a `Comment` against a known entity
     */
    public @Nullable CreateComment createComment() {
      return this.createComment;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createComment != null ? createComment.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createComment=" + createComment
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
        return ((this.createComment == null) ? (that.createComment == null) : this.createComment.equals(that.createComment));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createComment == null) ? 0 : createComment.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createComment = createComment;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateComment.Mapper createCommentFieldMapper = new CreateComment.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateComment createComment = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateComment>() {
          @Override
          public CreateComment read(ResponseReader reader) {
            return createCommentFieldMapper.map(reader);
          }
        });
        return new Data(createComment);
      }
    }

    public static final class Builder {
      private @Nullable CreateComment createComment;

      Builder() {
      }

      public Builder createComment(@Nullable CreateComment createComment) {
        this.createComment = createComment;
        return this;
      }

      public Builder createComment(@Nonnull Mutator<CreateComment.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateComment.Builder builder = this.createComment != null ? this.createComment.toBuilder() : CreateComment.builder();
        mutator.accept(builder);
        this.createComment = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createComment);
      }
    }
  }

  public static class CreateComment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CreateComment(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "CreateComment{"
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
      if (o instanceof CreateComment) {
        CreateComment that = (CreateComment) o;
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

    public static final class Mapper implements ResponseFieldMapper<CreateComment> {
      @Override
      public CreateComment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new CreateComment(__typename, id);
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

      public CreateComment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new CreateComment(__typename, id);
      }
    }
  }
}
