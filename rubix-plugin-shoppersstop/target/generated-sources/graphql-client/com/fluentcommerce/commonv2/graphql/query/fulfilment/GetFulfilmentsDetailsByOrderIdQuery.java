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
import java.lang.Boolean;
import java.lang.Double;
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
public final class GetFulfilmentsDetailsByOrderIdQuery implements Query<GetFulfilmentsDetailsByOrderIdQuery.Data, GetFulfilmentsDetailsByOrderIdQuery.Data, GetFulfilmentsDetailsByOrderIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetFulfilmentsDetailsByOrderId($id: ID!, $fulfilmentItemCount: Int, $fulfilmentItemCursor: String, $fulfilmentCount: Int, $fulfilmentCursor: String) {\n"
      + "  orderById(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    type\n"
      + "    status\n"
      + "    fulfilments(first: $fulfilmentCount, after: $fulfilmentCursor) {\n"
      + "      __typename\n"
      + "      edges {\n"
      + "        __typename\n"
      + "        node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          status\n"
      + "          type\n"
      + "          ref\n"
      + "          items(first: $fulfilmentItemCount, after: $fulfilmentItemCursor) {\n"
      + "            __typename\n"
      + "            edges {\n"
      + "              __typename\n"
      + "              node {\n"
      + "                __typename\n"
      + "                id\n"
      + "                ref\n"
      + "                filledQuantity\n"
      + "                requestedQuantity\n"
      + "                filledQuantity\n"
      + "                rejectedQuantity\n"
      + "                status\n"
      + "                orderItem {\n"
      + "                  __typename\n"
      + "                  paidPrice\n"
      + "                  currency\n"
      + "                  taxPrice\n"
      + "                  totalPrice\n"
      + "                  totalTaxPrice\n"
      + "                }\n"
      + "              }\n"
      + "              cursor\n"
      + "            }\n"
      + "            pageInfo {\n"
      + "              __typename\n"
      + "              hasNextPage\n"
      + "            }\n"
      + "          }\n"
      + "        }\n"
      + "        cursor\n"
      + "      }\n"
      + "      pageInfo {\n"
      + "        __typename\n"
      + "        hasNextPage\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetFulfilmentsDetailsByOrderId";
    }
  };

  private final GetFulfilmentsDetailsByOrderIdQuery.Variables variables;

  public GetFulfilmentsDetailsByOrderIdQuery(@Nonnull String id,
      @Nullable Integer fulfilmentItemCount, @Nullable String fulfilmentItemCursor,
      @Nullable Integer fulfilmentCount, @Nullable String fulfilmentCursor) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetFulfilmentsDetailsByOrderIdQuery.Variables(id, fulfilmentItemCount, fulfilmentItemCursor, fulfilmentCount, fulfilmentCursor);
  }

  @Override
  public String operationId() {
    return "c1a877c172f2abb2ec5ef7344d6db10441868e01017368b6495bdc85ed28ec3d";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetFulfilmentsDetailsByOrderIdQuery.Data wrapData(GetFulfilmentsDetailsByOrderIdQuery.Data data) {
    return data;
  }

  @Override
  public GetFulfilmentsDetailsByOrderIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetFulfilmentsDetailsByOrderIdQuery.Data> responseFieldMapper() {
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

    private @Nullable Integer fulfilmentItemCount;

    private @Nullable String fulfilmentItemCursor;

    private @Nullable Integer fulfilmentCount;

    private @Nullable String fulfilmentCursor;

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public Builder fulfilmentItemCount(@Nullable Integer fulfilmentItemCount) {
      this.fulfilmentItemCount = fulfilmentItemCount;
      return this;
    }

    public Builder fulfilmentItemCursor(@Nullable String fulfilmentItemCursor) {
      this.fulfilmentItemCursor = fulfilmentItemCursor;
      return this;
    }

    public Builder fulfilmentCount(@Nullable Integer fulfilmentCount) {
      this.fulfilmentCount = fulfilmentCount;
      return this;
    }

    public Builder fulfilmentCursor(@Nullable String fulfilmentCursor) {
      this.fulfilmentCursor = fulfilmentCursor;
      return this;
    }

    public GetFulfilmentsDetailsByOrderIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetFulfilmentsDetailsByOrderIdQuery(id, fulfilmentItemCount, fulfilmentItemCursor, fulfilmentCount, fulfilmentCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final @Nullable Integer fulfilmentItemCount;

    private final @Nullable String fulfilmentItemCursor;

    private final @Nullable Integer fulfilmentCount;

    private final @Nullable String fulfilmentCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, @Nullable Integer fulfilmentItemCount,
        @Nullable String fulfilmentItemCursor, @Nullable Integer fulfilmentCount,
        @Nullable String fulfilmentCursor) {
      this.id = id;
      this.fulfilmentItemCount = fulfilmentItemCount;
      this.fulfilmentItemCursor = fulfilmentItemCursor;
      this.fulfilmentCount = fulfilmentCount;
      this.fulfilmentCursor = fulfilmentCursor;
      this.valueMap.put("id", id);
      this.valueMap.put("fulfilmentItemCount", fulfilmentItemCount);
      this.valueMap.put("fulfilmentItemCursor", fulfilmentItemCursor);
      this.valueMap.put("fulfilmentCount", fulfilmentCount);
      this.valueMap.put("fulfilmentCursor", fulfilmentCursor);
    }

    public @Nonnull String id() {
      return id;
    }

    public @Nullable Integer fulfilmentItemCount() {
      return fulfilmentItemCount;
    }

    public @Nullable String fulfilmentItemCursor() {
      return fulfilmentItemCursor;
    }

    public @Nullable Integer fulfilmentCount() {
      return fulfilmentCount;
    }

    public @Nullable String fulfilmentCursor() {
      return fulfilmentCursor;
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
          writer.writeInt("fulfilmentItemCount", fulfilmentItemCount);
          writer.writeString("fulfilmentItemCursor", fulfilmentItemCursor);
          writer.writeInt("fulfilmentCount", fulfilmentCount);
          writer.writeString("fulfilmentCursor", fulfilmentCursor);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("orderById", "orderById", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable OrderById orderById;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable OrderById orderById) {
      this.orderById = orderById;
    }

    /**
     *  Find a Order entity
     */
    public @Nullable OrderById orderById() {
      return this.orderById;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], orderById != null ? orderById.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "orderById=" + orderById
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
        return ((this.orderById == null) ? (that.orderById == null) : this.orderById.equals(that.orderById));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (orderById == null) ? 0 : orderById.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.orderById = orderById;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final OrderById.Mapper orderByIdFieldMapper = new OrderById.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final OrderById orderById = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<OrderById>() {
          @Override
          public OrderById read(ResponseReader reader) {
            return orderByIdFieldMapper.map(reader);
          }
        });
        return new Data(orderById);
      }
    }

    public static final class Builder {
      private @Nullable OrderById orderById;

      Builder() {
      }

      public Builder orderById(@Nullable OrderById orderById) {
        this.orderById = orderById;
        return this;
      }

      public Builder orderById(@Nonnull Mutator<OrderById.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        OrderById.Builder builder = this.orderById != null ? this.orderById.toBuilder() : OrderById.builder();
        mutator.accept(builder);
        this.orderById = builder.build();
        return this;
      }

      public Data build() {
        return new Data(orderById);
      }
    }
  }

  public static class OrderById {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilments", "fulfilments", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentCount")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable Fulfilments fulfilments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OrderById(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable Fulfilments fulfilments) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.fulfilments = fulfilments;
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

    /**
     *  Type of the `Order`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     *  Currently supports values _CC_, _SFS_, _HD_ for _Click and Collect_, _Ship from Store_ and _Home Delivery_ type orders respectively
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  The current status of the `Order`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Connection representing a list of `Fulfilment`s
     */
    public @Nullable Fulfilments fulfilments() {
      return this.fulfilments;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], type);
          writer.writeString($responseFields[4], status);
          writer.writeObject($responseFields[5], fulfilments != null ? fulfilments.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OrderById{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "fulfilments=" + fulfilments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof OrderById) {
        OrderById that = (OrderById) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.type.equals(that.type)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.fulfilments == null) ? (that.fulfilments == null) : this.fulfilments.equals(that.fulfilments));
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
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (fulfilments == null) ? 0 : fulfilments.hashCode();
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
      builder.type = type;
      builder.status = status;
      builder.fulfilments = fulfilments;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OrderById> {
      final Fulfilments.Mapper fulfilmentsFieldMapper = new Fulfilments.Mapper();

      @Override
      public OrderById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final Fulfilments fulfilments = reader.readObject($responseFields[5], new ResponseReader.ObjectReader<Fulfilments>() {
          @Override
          public Fulfilments read(ResponseReader reader) {
            return fulfilmentsFieldMapper.map(reader);
          }
        });
        return new OrderById(__typename, id, ref, type, status, fulfilments);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable Fulfilments fulfilments;

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

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder fulfilments(@Nullable Fulfilments fulfilments) {
        this.fulfilments = fulfilments;
        return this;
      }

      public Builder fulfilments(@Nonnull Mutator<Fulfilments.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Fulfilments.Builder builder = this.fulfilments != null ? this.fulfilments.toBuilder() : Fulfilments.builder();
        mutator.accept(builder);
        this.fulfilments = builder.build();
        return this;
      }

      public OrderById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new OrderById(__typename, id, ref, type, status, fulfilments);
      }
    }
  }

  public static class Fulfilments {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge> edges;

    final @Nullable PageInfo1 pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilments(@Nonnull String __typename, @Nullable List<Edge> edges,
        @Nullable PageInfo1 pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Fulfilment type node
     */
    public @Nullable List<Edge> edges() {
      return this.edges;
    }

    /**
     *  Information to aid in pagination
     */
    public @Nullable PageInfo1 pageInfo() {
      return this.pageInfo;
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
          writer.writeObject($responseFields[2], pageInfo != null ? pageInfo.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Fulfilments{"
          + "__typename=" + __typename + ", "
          + "edges=" + edges + ", "
          + "pageInfo=" + pageInfo
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Fulfilments) {
        Fulfilments that = (Fulfilments) o;
        return this.__typename.equals(that.__typename)
         && ((this.edges == null) ? (that.edges == null) : this.edges.equals(that.edges))
         && ((this.pageInfo == null) ? (that.pageInfo == null) : this.pageInfo.equals(that.pageInfo));
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
        h *= 1000003;
        h ^= (pageInfo == null) ? 0 : pageInfo.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.edges = edges;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Fulfilments> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      final PageInfo1.Mapper pageInfo1FieldMapper = new PageInfo1.Mapper();

      @Override
      public Fulfilments map(ResponseReader reader) {
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
        final PageInfo1 pageInfo = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<PageInfo1>() {
          @Override
          public PageInfo1 read(ResponseReader reader) {
            return pageInfo1FieldMapper.map(reader);
          }
        });
        return new Fulfilments(__typename, edges, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge> edges;

      private @Nullable PageInfo1 pageInfo;

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

      public Builder pageInfo(@Nullable PageInfo1 pageInfo) {
        this.pageInfo = pageInfo;
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

      public Builder pageInfo(@Nonnull Mutator<PageInfo1.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo1.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo1.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public Fulfilments build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Fulfilments(__typename, edges, pageInfo);
      }
    }
  }

  public static class Edge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Node node;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge(@Nonnull String __typename, @Nullable Node node, @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.node = node;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Fulfilment edge
     */
    public @Nullable Node node() {
      return this.node;
    }

    /**
     *  A cursor for use in pagination
     */
    public @Nullable String cursor() {
      return this.cursor;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], node != null ? node.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Edge{"
          + "__typename=" + __typename + ", "
          + "node=" + node + ", "
          + "cursor=" + cursor
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
         && ((this.node == null) ? (that.node == null) : this.node.equals(that.node))
         && ((this.cursor == null) ? (that.cursor == null) : this.cursor.equals(that.cursor));
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
        h *= 1000003;
        h ^= (cursor == null) ? 0 : cursor.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.node = node;
      builder.cursor = cursor;
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
        final String cursor = reader.readString($responseFields[2]);
        return new Edge(__typename, node, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Node node;

      private @Nullable String cursor;

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

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
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
        return new Edge(__typename, node, cursor);
      }
    }
  }

  public static class Node {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("items", "items", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemCount")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String status;

    final @Nonnull String type;

    final @Nullable String ref;

    final @Nullable Items items;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nonnull String id, @Nullable String status,
        @Nonnull String type, @Nullable String ref, @Nullable Items items) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.status = status;
      this.type = Utils.checkNotNull(type, "type == null");
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
     *  The current status of the `Fulfilment`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Type of the `Fulfilment`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     *  Type of fulfilment. Supported types are <br/>
     *  - *CC_PFS* for Click & Collect - Pick from Store
     *  - *CC_PFDC* for Click & Collect - Pick from DC
     *  - *HD_PFS* for Home Delivery - Pick from Store
     *  - *HD_PFDC* for Home Delivery - Pick from DC
     */
    public @Nonnull String type() {
      return this.type;
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
          writer.writeString($responseFields[2], status);
          writer.writeString($responseFields[3], type);
          writer.writeString($responseFields[4], ref);
          writer.writeObject($responseFields[5], items != null ? items.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "status=" + status + ", "
          + "type=" + type + ", "
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
      if (o instanceof Node) {
        Node that = (Node) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.type.equals(that.type)
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
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
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
      builder.status = status;
      builder.type = type;
      builder.ref = ref;
      builder.items = items;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node> {
      final Items.Mapper itemsFieldMapper = new Items.Mapper();

      @Override
      public Node map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String status = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String ref = reader.readString($responseFields[4]);
        final Items items = reader.readObject($responseFields[5], new ResponseReader.ObjectReader<Items>() {
          @Override
          public Items read(ResponseReader reader) {
            return itemsFieldMapper.map(reader);
          }
        });
        return new Node(__typename, id, status, type, ref, items);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String status;

      private @Nonnull String type;

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

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder type(@Nonnull String type) {
        this.type = type;
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

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Node(__typename, id, status, type, ref, items);
      }
    }
  }

  public static class Items {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge1> edges;

    final @Nullable PageInfo pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Items(@Nonnull String __typename, @Nullable List<Edge1> edges,
        @Nullable PageInfo pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to FulfilmentItem type node
     */
    public @Nullable List<Edge1> edges() {
      return this.edges;
    }

    /**
     *  Information to aid in pagination
     */
    public @Nullable PageInfo pageInfo() {
      return this.pageInfo;
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
          writer.writeObject($responseFields[2], pageInfo != null ? pageInfo.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Items{"
          + "__typename=" + __typename + ", "
          + "edges=" + edges + ", "
          + "pageInfo=" + pageInfo
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
         && ((this.edges == null) ? (that.edges == null) : this.edges.equals(that.edges))
         && ((this.pageInfo == null) ? (that.pageInfo == null) : this.pageInfo.equals(that.pageInfo));
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
        h *= 1000003;
        h ^= (pageInfo == null) ? 0 : pageInfo.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.edges = edges;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Items> {
      final Edge1.Mapper edge1FieldMapper = new Edge1.Mapper();

      final PageInfo.Mapper pageInfoFieldMapper = new PageInfo.Mapper();

      @Override
      public Items map(ResponseReader reader) {
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
        final PageInfo pageInfo = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<PageInfo>() {
          @Override
          public PageInfo read(ResponseReader reader) {
            return pageInfoFieldMapper.map(reader);
          }
        });
        return new Items(__typename, edges, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge1> edges;

      private @Nullable PageInfo pageInfo;

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

      public Builder pageInfo(@Nullable PageInfo pageInfo) {
        this.pageInfo = pageInfo;
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

      public Builder pageInfo(@Nonnull Mutator<PageInfo.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public Items build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Items(__typename, edges, pageInfo);
      }
    }
  }

  public static class Edge1 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Node1 node;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge1(@Nonnull String __typename, @Nullable Node1 node, @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.node = node;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the FulfilmentItem edge
     */
    public @Nullable Node1 node() {
      return this.node;
    }

    /**
     *  A cursor for use in pagination
     */
    public @Nullable String cursor() {
      return this.cursor;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], node != null ? node.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Edge1{"
          + "__typename=" + __typename + ", "
          + "node=" + node + ", "
          + "cursor=" + cursor
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
         && ((this.node == null) ? (that.node == null) : this.node.equals(that.node))
         && ((this.cursor == null) ? (that.cursor == null) : this.cursor.equals(that.cursor));
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
        h *= 1000003;
        h ^= (cursor == null) ? 0 : cursor.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.node = node;
      builder.cursor = cursor;
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
        final String cursor = reader.readString($responseFields[2]);
        return new Edge1(__typename, node, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Node1 node;

      private @Nullable String cursor;

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

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
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
        return new Edge1(__typename, node, cursor);
      }
    }
  }

  public static class Node1 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("filledQuantity", "filledQuantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("requestedQuantity", "requestedQuantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("rejectedQuantity", "rejectedQuantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("orderItem", "orderItem", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final int filledQuantity;

    final @Nullable Integer requestedQuantity;

    final int rejectedQuantity;

    final @Nonnull String status;

    final @Nullable OrderItem orderItem;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node1(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        int filledQuantity, @Nullable Integer requestedQuantity, int rejectedQuantity,
        @Nonnull String status, @Nullable OrderItem orderItem) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.filledQuantity = filledQuantity;
      this.requestedQuantity = requestedQuantity;
      this.rejectedQuantity = rejectedQuantity;
      this.status = Utils.checkNotNull(status, "status == null");
      this.orderItem = orderItem;
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
     *  Number of `OrderItem`s confirmed
     */
    public int filledQuantity() {
      return this.filledQuantity;
    }

    /**
     *  Number of `OrderItem`s assigned to the fulfilment
     */
    public @Nullable Integer requestedQuantity() {
      return this.requestedQuantity;
    }

    /**
     *  Number of `OrderItem`s rejected
     */
    public int rejectedQuantity() {
      return this.rejectedQuantity;
    }

    /**
     *  Status
     */
    public @Nonnull String status() {
      return this.status;
    }

    /**
     *  The associated `OrderItem`
     */
    public @Nullable OrderItem orderItem() {
      return this.orderItem;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeInt($responseFields[3], filledQuantity);
          writer.writeInt($responseFields[4], requestedQuantity);
          writer.writeInt($responseFields[5], rejectedQuantity);
          writer.writeString($responseFields[6], status);
          writer.writeObject($responseFields[7], orderItem != null ? orderItem.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node1{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "filledQuantity=" + filledQuantity + ", "
          + "requestedQuantity=" + requestedQuantity + ", "
          + "rejectedQuantity=" + rejectedQuantity + ", "
          + "status=" + status + ", "
          + "orderItem=" + orderItem
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
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.filledQuantity == that.filledQuantity
         && ((this.requestedQuantity == null) ? (that.requestedQuantity == null) : this.requestedQuantity.equals(that.requestedQuantity))
         && this.rejectedQuantity == that.rejectedQuantity
         && this.status.equals(that.status)
         && ((this.orderItem == null) ? (that.orderItem == null) : this.orderItem.equals(that.orderItem));
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
        h ^= filledQuantity;
        h *= 1000003;
        h ^= (requestedQuantity == null) ? 0 : requestedQuantity.hashCode();
        h *= 1000003;
        h ^= rejectedQuantity;
        h *= 1000003;
        h ^= status.hashCode();
        h *= 1000003;
        h ^= (orderItem == null) ? 0 : orderItem.hashCode();
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
      builder.filledQuantity = filledQuantity;
      builder.requestedQuantity = requestedQuantity;
      builder.rejectedQuantity = rejectedQuantity;
      builder.status = status;
      builder.orderItem = orderItem;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node1> {
      final OrderItem.Mapper orderItemFieldMapper = new OrderItem.Mapper();

      @Override
      public Node1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final int filledQuantity = reader.readInt($responseFields[3]);
        final Integer requestedQuantity = reader.readInt($responseFields[4]);
        final int rejectedQuantity = reader.readInt($responseFields[5]);
        final String status = reader.readString($responseFields[6]);
        final OrderItem orderItem = reader.readObject($responseFields[7], new ResponseReader.ObjectReader<OrderItem>() {
          @Override
          public OrderItem read(ResponseReader reader) {
            return orderItemFieldMapper.map(reader);
          }
        });
        return new Node1(__typename, id, ref, filledQuantity, requestedQuantity, rejectedQuantity, status, orderItem);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private int filledQuantity;

      private @Nullable Integer requestedQuantity;

      private int rejectedQuantity;

      private @Nonnull String status;

      private @Nullable OrderItem orderItem;

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

      public Builder filledQuantity(int filledQuantity) {
        this.filledQuantity = filledQuantity;
        return this;
      }

      public Builder requestedQuantity(@Nullable Integer requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
        return this;
      }

      public Builder rejectedQuantity(int rejectedQuantity) {
        this.rejectedQuantity = rejectedQuantity;
        return this;
      }

      public Builder status(@Nonnull String status) {
        this.status = status;
        return this;
      }

      public Builder orderItem(@Nullable OrderItem orderItem) {
        this.orderItem = orderItem;
        return this;
      }

      public Builder orderItem(@Nonnull Mutator<OrderItem.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        OrderItem.Builder builder = this.orderItem != null ? this.orderItem.toBuilder() : OrderItem.builder();
        mutator.accept(builder);
        this.orderItem = builder.build();
        return this;
      }

      public Node1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(status, "status == null");
        return new Node1(__typename, id, ref, filledQuantity, requestedQuantity, rejectedQuantity, status, orderItem);
      }
    }
  }

  public static class OrderItem {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("paidPrice", "paidPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("currency", "currency", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("taxPrice", "taxPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("totalPrice", "totalPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("totalTaxPrice", "totalTaxPrice", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Double paidPrice;

    final @Nullable String currency;

    final @Nullable Double taxPrice;

    final @Nullable Double totalPrice;

    final @Nullable Double totalTaxPrice;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OrderItem(@Nonnull String __typename, @Nullable Double paidPrice,
        @Nullable String currency, @Nullable Double taxPrice, @Nullable Double totalPrice,
        @Nullable Double totalTaxPrice) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.paidPrice = paidPrice;
      this.currency = currency;
      this.taxPrice = taxPrice;
      this.totalPrice = totalPrice;
      this.totalTaxPrice = totalTaxPrice;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Price paid. Excludes tax.
     */
    public @Nullable Double paidPrice() {
      return this.paidPrice;
    }

    /**
     *  Currency. Should ideally be a 3 letter ISO currency code. For instance _AUD_.
     */
    public @Nullable String currency() {
      return this.currency;
    }

    /**
     *  Tax price
     */
    public @Nullable Double taxPrice() {
      return this.taxPrice;
    }

    /**
     *  Total price
     */
    public @Nullable Double totalPrice() {
      return this.totalPrice;
    }

    /**
     *  Total tax price
     */
    public @Nullable Double totalTaxPrice() {
      return this.totalTaxPrice;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeDouble($responseFields[1], paidPrice);
          writer.writeString($responseFields[2], currency);
          writer.writeDouble($responseFields[3], taxPrice);
          writer.writeDouble($responseFields[4], totalPrice);
          writer.writeDouble($responseFields[5], totalTaxPrice);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OrderItem{"
          + "__typename=" + __typename + ", "
          + "paidPrice=" + paidPrice + ", "
          + "currency=" + currency + ", "
          + "taxPrice=" + taxPrice + ", "
          + "totalPrice=" + totalPrice + ", "
          + "totalTaxPrice=" + totalTaxPrice
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof OrderItem) {
        OrderItem that = (OrderItem) o;
        return this.__typename.equals(that.__typename)
         && ((this.paidPrice == null) ? (that.paidPrice == null) : this.paidPrice.equals(that.paidPrice))
         && ((this.currency == null) ? (that.currency == null) : this.currency.equals(that.currency))
         && ((this.taxPrice == null) ? (that.taxPrice == null) : this.taxPrice.equals(that.taxPrice))
         && ((this.totalPrice == null) ? (that.totalPrice == null) : this.totalPrice.equals(that.totalPrice))
         && ((this.totalTaxPrice == null) ? (that.totalTaxPrice == null) : this.totalTaxPrice.equals(that.totalTaxPrice));
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
        h ^= (paidPrice == null) ? 0 : paidPrice.hashCode();
        h *= 1000003;
        h ^= (currency == null) ? 0 : currency.hashCode();
        h *= 1000003;
        h ^= (taxPrice == null) ? 0 : taxPrice.hashCode();
        h *= 1000003;
        h ^= (totalPrice == null) ? 0 : totalPrice.hashCode();
        h *= 1000003;
        h ^= (totalTaxPrice == null) ? 0 : totalTaxPrice.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.paidPrice = paidPrice;
      builder.currency = currency;
      builder.taxPrice = taxPrice;
      builder.totalPrice = totalPrice;
      builder.totalTaxPrice = totalTaxPrice;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OrderItem> {
      @Override
      public OrderItem map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Double paidPrice = reader.readDouble($responseFields[1]);
        final String currency = reader.readString($responseFields[2]);
        final Double taxPrice = reader.readDouble($responseFields[3]);
        final Double totalPrice = reader.readDouble($responseFields[4]);
        final Double totalTaxPrice = reader.readDouble($responseFields[5]);
        return new OrderItem(__typename, paidPrice, currency, taxPrice, totalPrice, totalTaxPrice);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Double paidPrice;

      private @Nullable String currency;

      private @Nullable Double taxPrice;

      private @Nullable Double totalPrice;

      private @Nullable Double totalTaxPrice;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder paidPrice(@Nullable Double paidPrice) {
        this.paidPrice = paidPrice;
        return this;
      }

      public Builder currency(@Nullable String currency) {
        this.currency = currency;
        return this;
      }

      public Builder taxPrice(@Nullable Double taxPrice) {
        this.taxPrice = taxPrice;
        return this;
      }

      public Builder totalPrice(@Nullable Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
      }

      public Builder totalTaxPrice(@Nullable Double totalTaxPrice) {
        this.totalTaxPrice = totalTaxPrice;
        return this;
      }

      public OrderItem build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new OrderItem(__typename, paidPrice, currency, taxPrice, totalPrice, totalTaxPrice);
      }
    }
  }

  public static class PageInfo {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("hasNextPage", "hasNextPage", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Boolean hasNextPage;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PageInfo(@Nonnull String __typename, @Nullable Boolean hasNextPage) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.hasNextPage = hasNextPage;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  true if there are one or more pages of items beyond the current page
     */
    public @Nullable Boolean hasNextPage() {
      return this.hasNextPage;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeBoolean($responseFields[1], hasNextPage);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PageInfo{"
          + "__typename=" + __typename + ", "
          + "hasNextPage=" + hasNextPage
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PageInfo) {
        PageInfo that = (PageInfo) o;
        return this.__typename.equals(that.__typename)
         && ((this.hasNextPage == null) ? (that.hasNextPage == null) : this.hasNextPage.equals(that.hasNextPage));
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
        h ^= (hasNextPage == null) ? 0 : hasNextPage.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.hasNextPage = hasNextPage;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<PageInfo> {
      @Override
      public PageInfo map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Boolean hasNextPage = reader.readBoolean($responseFields[1]);
        return new PageInfo(__typename, hasNextPage);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Boolean hasNextPage;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder hasNextPage(@Nullable Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
      }

      public PageInfo build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new PageInfo(__typename, hasNextPage);
      }
    }
  }

  public static class PageInfo1 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("hasNextPage", "hasNextPage", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Boolean hasNextPage;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PageInfo1(@Nonnull String __typename, @Nullable Boolean hasNextPage) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.hasNextPage = hasNextPage;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  true if there are one or more pages of items beyond the current page
     */
    public @Nullable Boolean hasNextPage() {
      return this.hasNextPage;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeBoolean($responseFields[1], hasNextPage);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PageInfo1{"
          + "__typename=" + __typename + ", "
          + "hasNextPage=" + hasNextPage
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PageInfo1) {
        PageInfo1 that = (PageInfo1) o;
        return this.__typename.equals(that.__typename)
         && ((this.hasNextPage == null) ? (that.hasNextPage == null) : this.hasNextPage.equals(that.hasNextPage));
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
        h ^= (hasNextPage == null) ? 0 : hasNextPage.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.hasNextPage = hasNextPage;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<PageInfo1> {
      @Override
      public PageInfo1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Boolean hasNextPage = reader.readBoolean($responseFields[1]);
        return new PageInfo1(__typename, hasNextPage);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Boolean hasNextPage;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder hasNextPage(@Nullable Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
      }

      public PageInfo1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new PageInfo1(__typename, hasNextPage);
      }
    }
  }
}
