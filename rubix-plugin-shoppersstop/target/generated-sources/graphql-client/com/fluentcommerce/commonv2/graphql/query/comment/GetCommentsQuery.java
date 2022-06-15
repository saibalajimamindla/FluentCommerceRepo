package com.fluentcommerce.commonv2.graphql.query.comment;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.Mutator;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import com.fluentretail.graphql.type.CustomType;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class GetCommentsQuery implements Query<GetCommentsQuery.Data, GetCommentsQuery.Data, GetCommentsQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query getComments($entityType: [String!], $entityId: [ID!]) {\n"
      + "  comments(entityType: $entityType, entityId: $entityId) {\n"
      + "    __typename\n"
      + "    edges {\n"
      + "      __typename\n"
      + "      node {\n"
      + "        __typename\n"
      + "        id\n"
      + "        entityType\n"
      + "        entityId\n"
      + "        text\n"
      + "        createdOn\n"
      + "        updatedOn\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "getComments";
    }
  };

  private final GetCommentsQuery.Variables variables;

  public GetCommentsQuery(@Nullable List<String> entityType, @Nullable List<String> entityId) {
    variables = new GetCommentsQuery.Variables(entityType, entityId);
  }

  @Override
  public String operationId() {
    return "6e0fc02ab9325e4f78715353ce0758e30d37e64ee17503c5ea4ce353ca16c204";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetCommentsQuery.Data wrapData(GetCommentsQuery.Data data) {
    return data;
  }

  @Override
  public GetCommentsQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetCommentsQuery.Data> responseFieldMapper() {
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
    private @Nullable List<String> entityType;

    private @Nullable List<String> entityId;

    Builder() {
    }

    public Builder entityType(@Nullable List<String> entityType) {
      this.entityType = entityType;
      return this;
    }

    public Builder entityId(@Nullable List<String> entityId) {
      this.entityId = entityId;
      return this;
    }

    public GetCommentsQuery build() {
      return new GetCommentsQuery(entityType, entityId);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable List<String> entityType;

    private final @Nullable List<String> entityId;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable List<String> entityType, @Nullable List<String> entityId) {
      this.entityType = entityType;
      this.entityId = entityId;
      this.valueMap.put("entityType", entityType);
      this.valueMap.put("entityId", entityId);
    }

    public @Nullable List<String> entityType() {
      return entityType;
    }

    public @Nullable List<String> entityId() {
      return entityId;
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
          writer.writeList("entityType", entityType != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : entityType) {
                listItemWriter.writeString($item);
              }
            }
          } : null);
          writer.writeList("entityId", entityId != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : entityId) {
                listItemWriter.writeCustom(CustomType.ID, $item);
              }
            }
          } : null);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("comments", "comments", new UnmodifiableMapBuilder<String, Object>(2)
        .put("entityType", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "entityType")
        .build())
        .put("entityId", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "entityId")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable Comments comments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Comments comments) {
      this.comments = comments;
    }

    /**
     *  Search for Comment entities
     */
    public @Nullable Comments comments() {
      return this.comments;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], comments != null ? comments.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "comments=" + comments
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
        return ((this.comments == null) ? (that.comments == null) : this.comments.equals(that.comments));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (comments == null) ? 0 : comments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.comments = comments;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Comments.Mapper commentsFieldMapper = new Comments.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Comments comments = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Comments>() {
          @Override
          public Comments read(ResponseReader reader) {
            return commentsFieldMapper.map(reader);
          }
        });
        return new Data(comments);
      }
    }

    public static final class Builder {
      private @Nullable Comments comments;

      Builder() {
      }

      public Builder comments(@Nullable Comments comments) {
        this.comments = comments;
        return this;
      }

      public Builder comments(@Nonnull Mutator<Comments.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Comments.Builder builder = this.comments != null ? this.comments.toBuilder() : Comments.builder();
        mutator.accept(builder);
        this.comments = builder.build();
        return this;
      }

      public Data build() {
        return new Data(comments);
      }
    }
  }

  public static class Comments {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Comments(@Nonnull String __typename, @Nullable List<Edge> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Comment type node
     */
    public @Nullable List<Edge> edges() {
      return this.edges;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], edges, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Edge) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Comments{"
          + "__typename=" + __typename + ", "
          + "edges=" + edges
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Comments) {
        Comments that = (Comments) o;
        return this.__typename.equals(that.__typename)
         && ((this.edges == null) ? (that.edges == null) : this.edges.equals(that.edges));
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
        h ^= (edges == null) ? 0 : edges.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.edges = edges;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Comments> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      @Override
      public Comments map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<Edge> edges = reader.readList($responseFields[1], new ResponseReader.ListReader<Edge>() {
          @Override
          public Edge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Edge>() {
              @Override
              public Edge read(ResponseReader reader) {
                return edgeFieldMapper.map(reader);
              }
            });
          }
        });
        return new Comments(__typename, edges);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge> edges;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder edges(@Nullable List<Edge> edges) {
        this.edges = edges;
        return this;
      }

      public Builder edges(@Nonnull Mutator<List<Edge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Edge.Builder> builders = new ArrayList<>();
        if (this.edges != null) {
          for (Edge item : this.edges) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Edge> edges = new ArrayList<>();
        for (Edge.Builder item : builders) {
          edges.add(item != null ? item.build() : null);
        }
        this.edges = edges;
        return this;
      }

      public Comments build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Comments(__typename, edges);
      }
    }
  }

  public static class Edge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Node node;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge(@Nonnull String __typename, @Nullable Node node) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.node = node;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Comment edge
     */
    public @Nullable Node node() {
      return this.node;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], node != null ? node.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Edge{"
          + "__typename=" + __typename + ", "
          + "node=" + node
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Edge) {
        Edge that = (Edge) o;
        return this.__typename.equals(that.__typename)
         && ((this.node == null) ? (that.node == null) : this.node.equals(that.node));
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
        h ^= (node == null) ? 0 : node.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.node = node;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Edge> {
      final Node.Mapper nodeFieldMapper = new Node.Mapper();

      @Override
      public Edge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Node node = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Node>() {
          @Override
          public Node read(ResponseReader reader) {
            return nodeFieldMapper.map(reader);
          }
        });
        return new Edge(__typename, node);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Node node;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder node(@Nullable Node node) {
        this.node = node;
        return this;
      }

      public Builder node(@Nonnull Mutator<Node.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Node.Builder builder = this.node != null ? this.node.toBuilder() : Node.builder();
        mutator.accept(builder);
        this.node = builder.build();
        return this;
      }

      public Edge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Edge(__typename, node);
      }
    }
  }

  public static class Node {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("entityType", "entityType", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("entityId", "entityId", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("text", "text", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String entityType;

    final @Nonnull String entityId;

    final @Nonnull String text;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nonnull String id, @Nonnull String entityType,
        @Nonnull String entityId, @Nonnull String text, @Nullable Object createdOn,
        @Nullable Object updatedOn) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.entityType = Utils.checkNotNull(entityType, "entityType == null");
      this.entityId = Utils.checkNotNull(entityId, "entityId == null");
      this.text = Utils.checkNotNull(text, "text == null");
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
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
     *  Type of the entity. For example `ORDER`, `FULFILMENT`, `ORDERITEM`, `PRODUCTCATALOGUE` etc.
     */
    public @Nonnull String entityType() {
      return this.entityType;
    }

    /**
     *  ID of the entity
     */
    public @Nonnull String entityId() {
      return this.entityId;
    }

    /**
     *  Comment text
     */
    public @Nonnull String text() {
      return this.text;
    }

    /**
     *  Time of creation
     */
    public @Nullable Object createdOn() {
      return this.createdOn;
    }

    /**
     *  Time of last update
     */
    public @Nullable Object updatedOn() {
      return this.updatedOn;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], entityType);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[3], entityId);
          writer.writeString($responseFields[4], text);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[5], createdOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[6], updatedOn);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "entityType=" + entityType + ", "
          + "entityId=" + entityId + ", "
          + "text=" + text + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Node) {
        Node that = (Node) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.entityType.equals(that.entityType)
         && this.entityId.equals(that.entityId)
         && this.text.equals(that.text)
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn));
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
        h ^= entityType.hashCode();
        h *= 1000003;
        h ^= entityId.hashCode();
        h *= 1000003;
        h ^= text.hashCode();
        h *= 1000003;
        h ^= (createdOn == null) ? 0 : createdOn.hashCode();
        h *= 1000003;
        h ^= (updatedOn == null) ? 0 : updatedOn.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      builder.entityType = entityType;
      builder.entityId = entityId;
      builder.text = text;
      builder.createdOn = createdOn;
      builder.updatedOn = updatedOn;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node> {
      @Override
      public Node map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String entityType = reader.readString($responseFields[2]);
        final String entityId = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        final String text = reader.readString($responseFields[4]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[6]);
        return new Node(__typename, id, entityType, entityId, text, createdOn, updatedOn);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String entityType;

      private @Nonnull String entityId;

      private @Nonnull String text;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

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

      public Builder entityType(@Nonnull String entityType) {
        this.entityType = entityType;
        return this;
      }

      public Builder entityId(@Nonnull String entityId) {
        this.entityId = entityId;
        return this;
      }

      public Builder text(@Nonnull String text) {
        this.text = text;
        return this;
      }

      public Builder createdOn(@Nullable Object createdOn) {
        this.createdOn = createdOn;
        return this;
      }

      public Builder updatedOn(@Nullable Object updatedOn) {
        this.updatedOn = updatedOn;
        return this;
      }

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(entityType, "entityType == null");
        Utils.checkNotNull(entityId, "entityId == null");
        Utils.checkNotNull(text, "text == null");
        return new Node(__typename, id, entityType, entityId, text, createdOn, updatedOn);
      }
    }
  }
}
