package com.fluentcommerce.commonv2.graphql.query.fulfilment;

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
import java.lang.Integer;
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
public final class GetFulfilmentItemsByIdQuery implements Query<GetFulfilmentItemsByIdQuery.Data, GetFulfilmentItemsByIdQuery.Data, GetFulfilmentItemsByIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetFulfilmentItemsById($id: ID!, $fulfilmentItemsCount: Int) {\n"
      + "  fulfilmentById(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    items(first: $fulfilmentItemsCount) {\n"
      + "      __typename\n"
      + "      edges {\n"
      + "        __typename\n"
      + "        node {\n"
      + "          __typename\n"
      + "          ref\n"
      + "          id\n"
      + "          requestedQuantity\n"
      + "          filledQuantity\n"
      + "          rejectedQuantity\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetFulfilmentItemsById";
    }
  };

  private final GetFulfilmentItemsByIdQuery.Variables variables;

  public GetFulfilmentItemsByIdQuery(@Nonnull String id, @Nullable Integer fulfilmentItemsCount) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetFulfilmentItemsByIdQuery.Variables(id, fulfilmentItemsCount);
  }

  @Override
  public String operationId() {
    return "58233a21b3c9be61d2695ad11dcb7a594ca97430206da8c9edf39a56568668a1";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetFulfilmentItemsByIdQuery.Data wrapData(GetFulfilmentItemsByIdQuery.Data data) {
    return data;
  }

  @Override
  public GetFulfilmentItemsByIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetFulfilmentItemsByIdQuery.Data> responseFieldMapper() {
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
    private @Nonnull String id;

    private @Nullable Integer fulfilmentItemsCount;

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public Builder fulfilmentItemsCount(@Nullable Integer fulfilmentItemsCount) {
      this.fulfilmentItemsCount = fulfilmentItemsCount;
      return this;
    }

    public GetFulfilmentItemsByIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetFulfilmentItemsByIdQuery(id, fulfilmentItemsCount);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final @Nullable Integer fulfilmentItemsCount;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, @Nullable Integer fulfilmentItemsCount) {
      this.id = id;
      this.fulfilmentItemsCount = fulfilmentItemsCount;
      this.valueMap.put("id", id);
      this.valueMap.put("fulfilmentItemsCount", fulfilmentItemsCount);
    }

    public @Nonnull String id() {
      return id;
    }

    public @Nullable Integer fulfilmentItemsCount() {
      return fulfilmentItemsCount;
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
          writer.writeCustom("id", com.fluentretail.graphql.type.CustomType.ID, id);
          writer.writeInt("fulfilmentItemsCount", fulfilmentItemsCount);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("fulfilmentById", "fulfilmentById", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
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
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("items", "items", new UnmodifiableMapBuilder<String, Object>(1)
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemsCount")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable Items items;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentById(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable Items items) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.items = items;
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
     *  Connection representing a list of `FulfilmentItem`s
     */
    public @Nullable Items items() {
      return this.items;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeObject($responseFields[3], items != null ? items.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentById{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "items=" + items
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
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.items == null) ? (that.items == null) : this.items.equals(that.items));
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
        h ^= (items == null) ? 0 : items.hashCode();
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
      builder.items = items;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentById> {
      final Items.Mapper itemsFieldMapper = new Items.Mapper();

      @Override
      public FulfilmentById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final Items items = reader.readObject($responseFields[3], new ResponseReader.ObjectReader<Items>() {
          @Override
          public Items read(ResponseReader reader) {
            return itemsFieldMapper.map(reader);
          }
        });
        return new FulfilmentById(__typename, id, ref, items);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable Items items;

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

      public Builder items(@Nullable Items items) {
        this.items = items;
        return this;
      }

      public Builder items(@Nonnull Mutator<Items.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Items.Builder builder = this.items != null ? this.items.toBuilder() : Items.builder();
        mutator.accept(builder);
        this.items = builder.build();
        return this;
      }

      public FulfilmentById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new FulfilmentById(__typename, id, ref, items);
      }
    }
  }

  public static class Items {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Items(@Nonnull String __typename, @Nullable List<Edge> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to FulfilmentItem type node
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
        $toString = "Items{"
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
      if (o instanceof Items) {
        Items that = (Items) o;
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

    public static final class Mapper implements ResponseFieldMapper<Items> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      @Override
      public Items map(ResponseReader reader) {
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
        return new Items(__typename, edges);
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

      public Items build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Items(__typename, edges);
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
     *  The item at the end of the FulfilmentItem edge
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
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("requestedQuantity", "requestedQuantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("filledQuantity", "filledQuantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("rejectedQuantity", "rejectedQuantity", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String ref;

    final @Nonnull String id;

    final @Nullable Integer requestedQuantity;

    final int filledQuantity;

    final int rejectedQuantity;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nullable String ref, @Nonnull String id,
        @Nullable Integer requestedQuantity, int filledQuantity, int rejectedQuantity) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = ref;
      this.id = Utils.checkNotNull(id, "id == null");
      this.requestedQuantity = requestedQuantity;
      this.filledQuantity = filledQuantity;
      this.rejectedQuantity = rejectedQuantity;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  External reference of the object. Recommended to be unique.
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  ID of the object
     */
    public @Nonnull String id() {
      return this.id;
    }

    /**
     *  Number of `OrderItem`s assigned to the fulfilment
     */
    public @Nullable Integer requestedQuantity() {
      return this.requestedQuantity;
    }

    /**
     *  Number of `OrderItem`s confirmed
     */
    public int filledQuantity() {
      return this.filledQuantity;
    }

    /**
     *  Number of `OrderItem`s rejected
     */
    public int rejectedQuantity() {
      return this.rejectedQuantity;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], id);
          writer.writeInt($responseFields[3], requestedQuantity);
          writer.writeInt($responseFields[4], filledQuantity);
          writer.writeInt($responseFields[5], rejectedQuantity);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
          + "id=" + id + ", "
          + "requestedQuantity=" + requestedQuantity + ", "
          + "filledQuantity=" + filledQuantity + ", "
          + "rejectedQuantity=" + rejectedQuantity
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
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.id.equals(that.id)
         && ((this.requestedQuantity == null) ? (that.requestedQuantity == null) : this.requestedQuantity.equals(that.requestedQuantity))
         && this.filledQuantity == that.filledQuantity
         && this.rejectedQuantity == that.rejectedQuantity;
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
        h ^= (ref == null) ? 0 : ref.hashCode();
        h *= 1000003;
        h ^= id.hashCode();
        h *= 1000003;
        h ^= (requestedQuantity == null) ? 0 : requestedQuantity.hashCode();
        h *= 1000003;
        h ^= filledQuantity;
        h *= 1000003;
        h ^= rejectedQuantity;
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.ref = ref;
      builder.id = id;
      builder.requestedQuantity = requestedQuantity;
      builder.filledQuantity = filledQuantity;
      builder.rejectedQuantity = rejectedQuantity;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node> {
      @Override
      public Node map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final Integer requestedQuantity = reader.readInt($responseFields[3]);
        final int filledQuantity = reader.readInt($responseFields[4]);
        final int rejectedQuantity = reader.readInt($responseFields[5]);
        return new Node(__typename, ref, id, requestedQuantity, filledQuantity, rejectedQuantity);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String ref;

      private @Nonnull String id;

      private @Nullable Integer requestedQuantity;

      private int filledQuantity;

      private int rejectedQuantity;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder ref(@Nullable String ref) {
        this.ref = ref;
        return this;
      }

      public Builder id(@Nonnull String id) {
        this.id = id;
        return this;
      }

      public Builder requestedQuantity(@Nullable Integer requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
        return this;
      }

      public Builder filledQuantity(int filledQuantity) {
        this.filledQuantity = filledQuantity;
        return this;
      }

      public Builder rejectedQuantity(int rejectedQuantity) {
        this.rejectedQuantity = rejectedQuantity;
        return this;
      }

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Node(__typename, ref, id, requestedQuantity, filledQuantity, rejectedQuantity);
      }
    }
  }
}
