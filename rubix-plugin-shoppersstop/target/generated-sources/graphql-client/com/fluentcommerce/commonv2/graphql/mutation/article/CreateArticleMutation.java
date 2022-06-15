package com.fluentcommerce.commonv2.graphql.mutation.article;

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
import com.fluentcommerce.commonv2.graphql.type.CreateArticleInput;
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
public final class CreateArticleMutation implements Mutation<CreateArticleMutation.Data, CreateArticleMutation.Data, CreateArticleMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation createArticle($input: CreateArticleInput) {\n"
      + "  createArticle(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    status\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "createArticle";
    }
  };

  private final CreateArticleMutation.Variables variables;

  public CreateArticleMutation(@Nullable CreateArticleInput input) {
    variables = new CreateArticleMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "a37b66705edfb8188ee574a74ab2700095468aaa69d3c9d7dc8683d269779fa4";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CreateArticleMutation.Data wrapData(CreateArticleMutation.Data data) {
    return data;
  }

  @Override
  public CreateArticleMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateArticleMutation.Data> responseFieldMapper() {
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
    private @Nullable CreateArticleInput input;

    Builder() {
    }

    public Builder input(@Nullable CreateArticleInput input) {
      this.input = input;
      return this;
    }

    public CreateArticleMutation build() {
      return new CreateArticleMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable CreateArticleInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable CreateArticleInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable CreateArticleInput input() {
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
      ResponseField.forObject("createArticle", "createArticle", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable CreateArticle createArticle;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateArticle createArticle) {
      this.createArticle = createArticle;
    }

    /**
     *  This mutation creates an `Article`, an orchestratable entity inside the Fluent ecosystem. If the `Article` is successfully created, a CREATE event will be generate associated with the mutation.<br/>A sample of the event generated:<br/>{<br/>&nbsp;&nbsp;&nbsp;&nbsp;"name": "CREATE",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"type": "NORMAL",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"entityRef": "ARTICLE-001",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"entityType": "ARTICLE",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"retailerId": "1",<br/>&nbsp;&nbsp;&nbsp;&nbsp;"accountId": "ACCOUNT_ID"<br/>}<br/>
     */
    public @Nullable CreateArticle createArticle() {
      return this.createArticle;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createArticle != null ? createArticle.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createArticle=" + createArticle
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
        return ((this.createArticle == null) ? (that.createArticle == null) : this.createArticle.equals(that.createArticle));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (createArticle == null) ? 0 : createArticle.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.createArticle = createArticle;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateArticle.Mapper createArticleFieldMapper = new CreateArticle.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateArticle createArticle = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateArticle>() {
          @Override
          public CreateArticle read(ResponseReader reader) {
            return createArticleFieldMapper.map(reader);
          }
        });
        return new Data(createArticle);
      }
    }

    public static final class Builder {
      private @Nullable CreateArticle createArticle;

      Builder() {
      }

      public Builder createArticle(@Nullable CreateArticle createArticle) {
        this.createArticle = createArticle;
        return this;
      }

      public Builder createArticle(@Nonnull Mutator<CreateArticle.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CreateArticle.Builder builder = this.createArticle != null ? this.createArticle.toBuilder() : CreateArticle.builder();
        mutator.accept(builder);
        this.createArticle = builder.build();
        return this;
      }

      public Data build() {
        return new Data(createArticle);
      }
    }
  }

  public static class CreateArticle {
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

    public CreateArticle(@Nonnull String __typename, @Nonnull String id, @Nullable String status) {
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
     *  The current status of the `Article`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
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
        $toString = "CreateArticle{"
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
      if (o instanceof CreateArticle) {
        CreateArticle that = (CreateArticle) o;
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

    public static final class Mapper implements ResponseFieldMapper<CreateArticle> {
      @Override
      public CreateArticle map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String status = reader.readString($responseFields[2]);
        return new CreateArticle(__typename, id, status);
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

      public CreateArticle build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new CreateArticle(__typename, id, status);
      }
    }
  }
}
