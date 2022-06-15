package com.fluentcommerce.commonv2.graphql.query.consignment;

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
public final class GetConsignmentsByFulfilmentIdQuery implements Query<GetConsignmentsByFulfilmentIdQuery.Data, GetConsignmentsByFulfilmentIdQuery.Data, GetConsignmentsByFulfilmentIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetConsignmentsByFulfilmentId($fulfilmentId: ID!) {\n"
      + "  fulfilmentById(id: $fulfilmentId) {\n"
      + "    __typename\n"
      + "    order {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "    }\n"
      + "    articles {\n"
      + "      __typename\n"
      + "      edges {\n"
      + "        __typename\n"
      + "        node {\n"
      + "          __typename\n"
      + "          consignmentArticles {\n"
      + "            __typename\n"
      + "            edges {\n"
      + "              __typename\n"
      + "              node {\n"
      + "                __typename\n"
      + "                consignment {\n"
      + "                  __typename\n"
      + "                  id\n"
      + "                  ref\n"
      + "                  status\n"
      + "                  trackingLabel\n"
      + "                  labelUrl\n"
      + "                  carrier {\n"
      + "                    __typename\n"
      + "                    id\n"
      + "                    name\n"
      + "                  }\n"
      + "                }\n"
      + "              }\n"
      + "            }\n"
      + "          }\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "    attributes {\n"
      + "      __typename\n"
      + "      name\n"
      + "      type\n"
      + "      value\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetConsignmentsByFulfilmentId";
    }
  };

  private final GetConsignmentsByFulfilmentIdQuery.Variables variables;

  public GetConsignmentsByFulfilmentIdQuery(@Nonnull String fulfilmentId) {
    Utils.checkNotNull(fulfilmentId, "fulfilmentId == null");
    variables = new GetConsignmentsByFulfilmentIdQuery.Variables(fulfilmentId);
  }

  @Override
  public String operationId() {
    return "2960eea668a6cd41362ce631ae9f74b5fdc16a5ed610b2c245ed104285ef1713";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetConsignmentsByFulfilmentIdQuery.Data wrapData(GetConsignmentsByFulfilmentIdQuery.Data data) {
    return data;
  }

  @Override
  public GetConsignmentsByFulfilmentIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetConsignmentsByFulfilmentIdQuery.Data> responseFieldMapper() {
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
    private @Nonnull String fulfilmentId;

    Builder() {
    }

    public Builder fulfilmentId(@Nonnull String fulfilmentId) {
      this.fulfilmentId = fulfilmentId;
      return this;
    }

    public GetConsignmentsByFulfilmentIdQuery build() {
      Utils.checkNotNull(fulfilmentId, "fulfilmentId == null");
      return new GetConsignmentsByFulfilmentIdQuery(fulfilmentId);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String fulfilmentId;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String fulfilmentId) {
      this.fulfilmentId = fulfilmentId;
      this.valueMap.put("fulfilmentId", fulfilmentId);
    }

    public @Nonnull String fulfilmentId() {
      return fulfilmentId;
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
          writer.writeCustom("fulfilmentId", com.fluentretail.graphql.type.CustomType.ID, fulfilmentId);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("fulfilmentById", "fulfilmentById", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentId")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable FulfilmentById fulfilmentById;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable FulfilmentById fulfilmentById) {
      this.fulfilmentById = fulfilmentById;
    }

    /**
     *  Find a Fulfilment entity
     */
    public @Nullable FulfilmentById fulfilmentById() {
      return this.fulfilmentById;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], fulfilmentById != null ? fulfilmentById.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "fulfilmentById=" + fulfilmentById
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
        return ((this.fulfilmentById == null) ? (that.fulfilmentById == null) : this.fulfilmentById.equals(that.fulfilmentById));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (fulfilmentById == null) ? 0 : fulfilmentById.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.fulfilmentById = fulfilmentById;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final FulfilmentById.Mapper fulfilmentByIdFieldMapper = new FulfilmentById.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final FulfilmentById fulfilmentById = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<FulfilmentById>() {
          @Override
          public FulfilmentById read(ResponseReader reader) {
            return fulfilmentByIdFieldMapper.map(reader);
          }
        });
        return new Data(fulfilmentById);
      }
    }

    public static final class Builder {
      private @Nullable FulfilmentById fulfilmentById;

      Builder() {
      }

      public Builder fulfilmentById(@Nullable FulfilmentById fulfilmentById) {
        this.fulfilmentById = fulfilmentById;
        return this;
      }

      public Builder fulfilmentById(@Nonnull Mutator<FulfilmentById.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentById.Builder builder = this.fulfilmentById != null ? this.fulfilmentById.toBuilder() : FulfilmentById.builder();
        mutator.accept(builder);
        this.fulfilmentById = builder.build();
        return this;
      }

      public Data build() {
        return new Data(fulfilmentById);
      }
    }
  }

  public static class FulfilmentById {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("order", "order", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("articles", "articles", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Order order;

    final @Nullable Articles articles;

    final @Nullable List<Attribute> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentById(@Nonnull String __typename, @Nullable Order order,
        @Nullable Articles articles, @Nullable List<Attribute> attributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.order = order;
      this.articles = articles;
      this.attributes = attributes;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The associated `Order`
     */
    public @Nullable Order order() {
      return this.order;
    }

    /**
     *  Connection representing a list of `Article`s
     */
    public @Nullable Articles articles() {
      return this.articles;
    }

    /**
     *  Attributes of fulfilment
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], order != null ? order.marshaller() : null);
          writer.writeObject($responseFields[2], articles != null ? articles.marshaller() : null);
          writer.writeList($responseFields[3], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentById{"
          + "__typename=" + __typename + ", "
          + "order=" + order + ", "
          + "articles=" + articles + ", "
          + "attributes=" + attributes
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FulfilmentById) {
        FulfilmentById that = (FulfilmentById) o;
        return this.__typename.equals(that.__typename)
         && ((this.order == null) ? (that.order == null) : this.order.equals(that.order))
         && ((this.articles == null) ? (that.articles == null) : this.articles.equals(that.articles))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes));
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
        h ^= (order == null) ? 0 : order.hashCode();
        h *= 1000003;
        h ^= (articles == null) ? 0 : articles.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.order = order;
      builder.articles = articles;
      builder.attributes = attributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentById> {
      final Order.Mapper orderFieldMapper = new Order.Mapper();

      final Articles.Mapper articlesFieldMapper = new Articles.Mapper();

      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      @Override
      public FulfilmentById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Order order = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Order>() {
          @Override
          public Order read(ResponseReader reader) {
            return orderFieldMapper.map(reader);
          }
        });
        final Articles articles = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<Articles>() {
          @Override
          public Articles read(ResponseReader reader) {
            return articlesFieldMapper.map(reader);
          }
        });
        final List<Attribute> attributes = reader.readList($responseFields[3], new ResponseReader.ListReader<Attribute>() {
          @Override
          public Attribute read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Attribute>() {
              @Override
              public Attribute read(ResponseReader reader) {
                return attributeFieldMapper.map(reader);
              }
            });
          }
        });
        return new FulfilmentById(__typename, order, articles, attributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Order order;

      private @Nullable Articles articles;

      private @Nullable List<Attribute> attributes;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder order(@Nullable Order order) {
        this.order = order;
        return this;
      }

      public Builder articles(@Nullable Articles articles) {
        this.articles = articles;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder order(@Nonnull Mutator<Order.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Order.Builder builder = this.order != null ? this.order.toBuilder() : Order.builder();
        mutator.accept(builder);
        this.order = builder.build();
        return this;
      }

      public Builder articles(@Nonnull Mutator<Articles.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Articles.Builder builder = this.articles != null ? this.articles.toBuilder() : Articles.builder();
        mutator.accept(builder);
        this.articles = builder.build();
        return this;
      }

      public Builder attributes(@Nonnull Mutator<List<Attribute.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Attribute.Builder> builders = new ArrayList<>();
        if (this.attributes != null) {
          for (Attribute item : this.attributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Attribute> attributes = new ArrayList<>();
        for (Attribute.Builder item : builders) {
          attributes.add(item != null ? item.build() : null);
        }
        this.attributes = attributes;
        return this;
      }

      public FulfilmentById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FulfilmentById(__typename, order, articles, attributes);
      }
    }
  }

  public static class Order {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Order(@Nonnull String __typename, @Nonnull String id, @Nullable String ref) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
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
    public @Nullable String ref() {
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
        $toString = "Order{"
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
      if (o instanceof Order) {
        Order that = (Order) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref));
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
        h ^= (ref == null) ? 0 : ref.hashCode();
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

    public static final class Mapper implements ResponseFieldMapper<Order> {
      @Override
      public Order map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        return new Order(__typename, id, ref);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

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

      public Builder ref(@Nullable String ref) {
        this.ref = ref;
        return this;
      }

      public Order build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Order(__typename, id, ref);
      }
    }
  }

  public static class Articles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Articles(@Nonnull String __typename, @Nullable List<Edge> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Article type node
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
        $toString = "Articles{"
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
      if (o instanceof Articles) {
        Articles that = (Articles) o;
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

    public static final class Mapper implements ResponseFieldMapper<Articles> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      @Override
      public Articles map(ResponseReader reader) {
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
        return new Articles(__typename, edges);
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

      public Articles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Articles(__typename, edges);
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
     *  The item at the end of the Article edge
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
      ResponseField.forObject("consignmentArticles", "consignmentArticles", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable ConsignmentArticles consignmentArticles;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nullable ConsignmentArticles consignmentArticles) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.consignmentArticles = consignmentArticles;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Relationships between consignment and article
     */
    public @Nullable ConsignmentArticles consignmentArticles() {
      return this.consignmentArticles;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], consignmentArticles != null ? consignmentArticles.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "consignmentArticles=" + consignmentArticles
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
         && ((this.consignmentArticles == null) ? (that.consignmentArticles == null) : this.consignmentArticles.equals(that.consignmentArticles));
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
        h ^= (consignmentArticles == null) ? 0 : consignmentArticles.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.consignmentArticles = consignmentArticles;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node> {
      final ConsignmentArticles.Mapper consignmentArticlesFieldMapper = new ConsignmentArticles.Mapper();

      @Override
      public Node map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final ConsignmentArticles consignmentArticles = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<ConsignmentArticles>() {
          @Override
          public ConsignmentArticles read(ResponseReader reader) {
            return consignmentArticlesFieldMapper.map(reader);
          }
        });
        return new Node(__typename, consignmentArticles);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable ConsignmentArticles consignmentArticles;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder consignmentArticles(@Nullable ConsignmentArticles consignmentArticles) {
        this.consignmentArticles = consignmentArticles;
        return this;
      }

      public Builder consignmentArticles(@Nonnull Mutator<ConsignmentArticles.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ConsignmentArticles.Builder builder = this.consignmentArticles != null ? this.consignmentArticles.toBuilder() : ConsignmentArticles.builder();
        mutator.accept(builder);
        this.consignmentArticles = builder.build();
        return this;
      }

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Node(__typename, consignmentArticles);
      }
    }
  }

  public static class ConsignmentArticles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge1> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ConsignmentArticles(@Nonnull String __typename, @Nullable List<Edge1> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to ConsignmentArticle type node
     */
    public @Nullable List<Edge1> edges() {
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
              listItemWriter.writeObject(((Edge1) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ConsignmentArticles{"
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
      if (o instanceof ConsignmentArticles) {
        ConsignmentArticles that = (ConsignmentArticles) o;
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

    public static final class Mapper implements ResponseFieldMapper<ConsignmentArticles> {
      final Edge1.Mapper edge1FieldMapper = new Edge1.Mapper();

      @Override
      public ConsignmentArticles map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<Edge1> edges = reader.readList($responseFields[1], new ResponseReader.ListReader<Edge1>() {
          @Override
          public Edge1 read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Edge1>() {
              @Override
              public Edge1 read(ResponseReader reader) {
                return edge1FieldMapper.map(reader);
              }
            });
          }
        });
        return new ConsignmentArticles(__typename, edges);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge1> edges;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder edges(@Nullable List<Edge1> edges) {
        this.edges = edges;
        return this;
      }

      public Builder edges(@Nonnull Mutator<List<Edge1.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Edge1.Builder> builders = new ArrayList<>();
        if (this.edges != null) {
          for (Edge1 item : this.edges) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Edge1> edges = new ArrayList<>();
        for (Edge1.Builder item : builders) {
          edges.add(item != null ? item.build() : null);
        }
        this.edges = edges;
        return this;
      }

      public ConsignmentArticles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ConsignmentArticles(__typename, edges);
      }
    }
  }

  public static class Edge1 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Node1 node;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge1(@Nonnull String __typename, @Nullable Node1 node) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.node = node;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the ConsignmentArticle edge
     */
    public @Nullable Node1 node() {
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
        $toString = "Edge1{"
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
      if (o instanceof Edge1) {
        Edge1 that = (Edge1) o;
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

    public static final class Mapper implements ResponseFieldMapper<Edge1> {
      final Node1.Mapper node1FieldMapper = new Node1.Mapper();

      @Override
      public Edge1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Node1 node = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Node1>() {
          @Override
          public Node1 read(ResponseReader reader) {
            return node1FieldMapper.map(reader);
          }
        });
        return new Edge1(__typename, node);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Node1 node;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder node(@Nullable Node1 node) {
        this.node = node;
        return this;
      }

      public Builder node(@Nonnull Mutator<Node1.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Node1.Builder builder = this.node != null ? this.node.toBuilder() : Node1.builder();
        mutator.accept(builder);
        this.node = builder.build();
        return this;
      }

      public Edge1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Edge1(__typename, node);
      }
    }
  }

  public static class Node1 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("consignment", "consignment", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Consignment consignment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node1(@Nonnull String __typename, @Nullable Consignment consignment) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.consignment = consignment;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Consignment
     */
    public @Nullable Consignment consignment() {
      return this.consignment;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], consignment != null ? consignment.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node1{"
          + "__typename=" + __typename + ", "
          + "consignment=" + consignment
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Node1) {
        Node1 that = (Node1) o;
        return this.__typename.equals(that.__typename)
         && ((this.consignment == null) ? (that.consignment == null) : this.consignment.equals(that.consignment));
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
        h ^= (consignment == null) ? 0 : consignment.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.consignment = consignment;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node1> {
      final Consignment.Mapper consignmentFieldMapper = new Consignment.Mapper();

      @Override
      public Node1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Consignment consignment = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Consignment>() {
          @Override
          public Consignment read(ResponseReader reader) {
            return consignmentFieldMapper.map(reader);
          }
        });
        return new Node1(__typename, consignment);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Consignment consignment;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder consignment(@Nullable Consignment consignment) {
        this.consignment = consignment;
        return this;
      }

      public Builder consignment(@Nonnull Mutator<Consignment.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Consignment.Builder builder = this.consignment != null ? this.consignment.toBuilder() : Consignment.builder();
        mutator.accept(builder);
        this.consignment = builder.build();
        return this;
      }

      public Node1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Node1(__typename, consignment);
      }
    }
  }

  public static class Consignment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("trackingLabel", "trackingLabel", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("labelUrl", "labelUrl", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("carrier", "carrier", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable String trackingLabel;

    final @Nullable String labelUrl;

    final @Nullable Carrier carrier;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Consignment(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable String trackingLabel, @Nullable String labelUrl,
        @Nullable Carrier carrier) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.trackingLabel = trackingLabel;
      this.labelUrl = labelUrl;
      this.carrier = carrier;
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
     *  External reference of the object. Recommended to be unique.
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  The status of the consignment
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Tracking label of the consignment
     */
    public @Nullable String trackingLabel() {
      return this.trackingLabel;
    }

    /**
     *  The URL used to retrieve the shipping label
     */
    public @Nullable String labelUrl() {
      return this.labelUrl;
    }

    /**
     *  Carrier used for the consignment
     */
    public @Nullable Carrier carrier() {
      return this.carrier;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], trackingLabel);
          writer.writeString($responseFields[5], labelUrl);
          writer.writeObject($responseFields[6], carrier != null ? carrier.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Consignment{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "trackingLabel=" + trackingLabel + ", "
          + "labelUrl=" + labelUrl + ", "
          + "carrier=" + carrier
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Consignment) {
        Consignment that = (Consignment) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.trackingLabel == null) ? (that.trackingLabel == null) : this.trackingLabel.equals(that.trackingLabel))
         && ((this.labelUrl == null) ? (that.labelUrl == null) : this.labelUrl.equals(that.labelUrl))
         && ((this.carrier == null) ? (that.carrier == null) : this.carrier.equals(that.carrier));
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
        h ^= (ref == null) ? 0 : ref.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (trackingLabel == null) ? 0 : trackingLabel.hashCode();
        h *= 1000003;
        h ^= (labelUrl == null) ? 0 : labelUrl.hashCode();
        h *= 1000003;
        h ^= (carrier == null) ? 0 : carrier.hashCode();
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
      builder.status = status;
      builder.trackingLabel = trackingLabel;
      builder.labelUrl = labelUrl;
      builder.carrier = carrier;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Consignment> {
      final Carrier.Mapper carrierFieldMapper = new Carrier.Mapper();

      @Override
      public Consignment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String trackingLabel = reader.readString($responseFields[4]);
        final String labelUrl = reader.readString($responseFields[5]);
        final Carrier carrier = reader.readObject($responseFields[6], new ResponseReader.ObjectReader<Carrier>() {
          @Override
          public Carrier read(ResponseReader reader) {
            return carrierFieldMapper.map(reader);
          }
        });
        return new Consignment(__typename, id, ref, status, trackingLabel, labelUrl, carrier);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable String trackingLabel;

      private @Nullable String labelUrl;

      private @Nullable Carrier carrier;

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

      public Builder ref(@Nullable String ref) {
        this.ref = ref;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder trackingLabel(@Nullable String trackingLabel) {
        this.trackingLabel = trackingLabel;
        return this;
      }

      public Builder labelUrl(@Nullable String labelUrl) {
        this.labelUrl = labelUrl;
        return this;
      }

      public Builder carrier(@Nullable Carrier carrier) {
        this.carrier = carrier;
        return this;
      }

      public Builder carrier(@Nonnull Mutator<Carrier.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Carrier.Builder builder = this.carrier != null ? this.carrier.toBuilder() : Carrier.builder();
        mutator.accept(builder);
        this.carrier = builder.build();
        return this;
      }

      public Consignment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Consignment(__typename, id, ref, status, trackingLabel, labelUrl, carrier);
      }
    }
  }

  public static class Carrier {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String name;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Carrier(@Nonnull String __typename, @Nonnull String id, @Nonnull String name) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.name = Utils.checkNotNull(name, "name == null");
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
     *  The carrier name
     */
    public @Nonnull String name() {
      return this.name;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], name);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Carrier{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "name=" + name
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Carrier) {
        Carrier that = (Carrier) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.name.equals(that.name);
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
        h ^= name.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      builder.name = name;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Carrier> {
      @Override
      public Carrier map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        return new Carrier(__typename, id, name);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String name;

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

      public Builder name(@Nonnull String name) {
        this.name = name;
        return this;
      }

      public Carrier build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(name, "name == null");
        return new Carrier(__typename, id, name);
      }
    }
  }

  public static class Attribute {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("value", "value", null, false, CustomType.JSON, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String name;

    final @Nonnull String type;

    final @Nonnull Object value;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Attribute(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
        @Nonnull Object value) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.name = Utils.checkNotNull(name, "name == null");
      this.type = Utils.checkNotNull(type, "type == null");
      this.value = Utils.checkNotNull(value, "value == null");
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Name of the `attribute`
     */
    public @Nonnull String name() {
      return this.name;
    }

    /**
     *  Type of the attribute's `value`. This is a free string and can be used by the client to interpret and cast the `value` into the appropriate type.
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  Value of the `attribute`
     */
    public @Nonnull Object value() {
      return this.value;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], name);
          writer.writeString($responseFields[2], type);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[3], value);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Attribute{"
          + "__typename=" + __typename + ", "
          + "name=" + name + ", "
          + "type=" + type + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Attribute) {
        Attribute that = (Attribute) o;
        return this.__typename.equals(that.__typename)
         && this.name.equals(that.name)
         && this.type.equals(that.type)
         && this.value.equals(that.value);
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
        h ^= name.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= value.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.name = name;
      builder.type = type;
      builder.value = value;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Attribute> {
      @Override
      public Attribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new Attribute(__typename, name, type, value);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String name;

      private @Nonnull String type;

      private @Nonnull Object value;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder name(@Nonnull String name) {
        this.name = name;
        return this;
      }

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder value(@Nonnull Object value) {
        this.value = value;
        return this;
      }

      public Attribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new Attribute(__typename, name, type, value);
      }
    }
  }
}
