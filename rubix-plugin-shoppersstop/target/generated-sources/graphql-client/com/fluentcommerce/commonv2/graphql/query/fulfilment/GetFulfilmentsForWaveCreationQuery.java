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
import com.fluentcommerce.commonv2.graphql.type.LocationLinkInput;
import java.io.IOException;
import java.lang.Boolean;
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
public final class GetFulfilmentsForWaveCreationQuery implements Query<GetFulfilmentsForWaveCreationQuery.Data, GetFulfilmentsForWaveCreationQuery.Data, GetFulfilmentsForWaveCreationQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetFulfilmentsForWaveCreation($status: [String], $fromLocation: LocationLinkInput, $fulfilmentsCount: Int, $fulfilmentsCursor: String) {\n"
      + "  fulfilments(status: $status, fromLocation: $fromLocation, first: $fulfilmentsCount, after: $fulfilmentsCursor) {\n"
      + "    __typename\n"
      + "    pageInfo {\n"
      + "      __typename\n"
      + "      hasNextPage\n"
      + "    }\n"
      + "    edges {\n"
      + "      __typename\n"
      + "      cursor\n"
      + "      node {\n"
      + "        __typename\n"
      + "        id\n"
      + "        ref\n"
      + "        status\n"
      + "        createdOn\n"
      + "        updatedOn\n"
      + "        eta\n"
      + "        expiryTime\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetFulfilmentsForWaveCreation";
    }
  };

  private final GetFulfilmentsForWaveCreationQuery.Variables variables;

  public GetFulfilmentsForWaveCreationQuery(@Nullable List<String> status,
      @Nullable LocationLinkInput fromLocation, @Nullable Integer fulfilmentsCount,
      @Nullable String fulfilmentsCursor) {
    variables = new GetFulfilmentsForWaveCreationQuery.Variables(status, fromLocation, fulfilmentsCount, fulfilmentsCursor);
  }

  @Override
  public String operationId() {
    return "e7183dd78001184df742e4d39f4f7ebbebfa6a27b36c36fda39d432b12e0d158";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetFulfilmentsForWaveCreationQuery.Data wrapData(GetFulfilmentsForWaveCreationQuery.Data data) {
    return data;
  }

  @Override
  public GetFulfilmentsForWaveCreationQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetFulfilmentsForWaveCreationQuery.Data> responseFieldMapper() {
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
    private @Nullable List<String> status;

    private @Nullable LocationLinkInput fromLocation;

    private @Nullable Integer fulfilmentsCount;

    private @Nullable String fulfilmentsCursor;

    Builder() {
    }

    public Builder status(@Nullable List<String> status) {
      this.status = status;
      return this;
    }

    public Builder fromLocation(@Nullable LocationLinkInput fromLocation) {
      this.fromLocation = fromLocation;
      return this;
    }

    public Builder fulfilmentsCount(@Nullable Integer fulfilmentsCount) {
      this.fulfilmentsCount = fulfilmentsCount;
      return this;
    }

    public Builder fulfilmentsCursor(@Nullable String fulfilmentsCursor) {
      this.fulfilmentsCursor = fulfilmentsCursor;
      return this;
    }

    public GetFulfilmentsForWaveCreationQuery build() {
      return new GetFulfilmentsForWaveCreationQuery(status, fromLocation, fulfilmentsCount, fulfilmentsCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable List<String> status;

    private final @Nullable LocationLinkInput fromLocation;

    private final @Nullable Integer fulfilmentsCount;

    private final @Nullable String fulfilmentsCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable List<String> status, @Nullable LocationLinkInput fromLocation,
        @Nullable Integer fulfilmentsCount, @Nullable String fulfilmentsCursor) {
      this.status = status;
      this.fromLocation = fromLocation;
      this.fulfilmentsCount = fulfilmentsCount;
      this.fulfilmentsCursor = fulfilmentsCursor;
      this.valueMap.put("status", status);
      this.valueMap.put("fromLocation", fromLocation);
      this.valueMap.put("fulfilmentsCount", fulfilmentsCount);
      this.valueMap.put("fulfilmentsCursor", fulfilmentsCursor);
    }

    public @Nullable List<String> status() {
      return status;
    }

    public @Nullable LocationLinkInput fromLocation() {
      return fromLocation;
    }

    public @Nullable Integer fulfilmentsCount() {
      return fulfilmentsCount;
    }

    public @Nullable String fulfilmentsCursor() {
      return fulfilmentsCursor;
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
          writer.writeList("status", status != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : status) {
                listItemWriter.writeString($item);
              }
            }
          } : null);
          writer.writeObject("fromLocation", fromLocation != null ? fromLocation.marshaller() : null);
          writer.writeInt("fulfilmentsCount", fulfilmentsCount);
          writer.writeString("fulfilmentsCursor", fulfilmentsCursor);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("fulfilments", "fulfilments", new UnmodifiableMapBuilder<String, Object>(4)
        .put("fromLocation", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fromLocation")
        .build())
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentsCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentsCount")
        .build())
        .put("status", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "status")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable Fulfilments fulfilments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Fulfilments fulfilments) {
      this.fulfilments = fulfilments;
    }

    /**
     *  Search for Fulfilment entities
     */
    public @Nullable Fulfilments fulfilments() {
      return this.fulfilments;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], fulfilments != null ? fulfilments.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
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
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.fulfilments == null) ? (that.fulfilments == null) : this.fulfilments.equals(that.fulfilments));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (fulfilments == null) ? 0 : fulfilments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.fulfilments = fulfilments;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Fulfilments.Mapper fulfilmentsFieldMapper = new Fulfilments.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Fulfilments fulfilments = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Fulfilments>() {
          @Override
          public Fulfilments read(ResponseReader reader) {
            return fulfilmentsFieldMapper.map(reader);
          }
        });
        return new Data(fulfilments);
      }
    }

    public static final class Builder {
      private @Nullable Fulfilments fulfilments;

      Builder() {
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

      public Data build() {
        return new Data(fulfilments);
      }
    }
  }

  public static class Fulfilments {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable PageInfo pageInfo;

    final @Nullable List<Edge> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilments(@Nonnull String __typename, @Nullable PageInfo pageInfo,
        @Nullable List<Edge> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.pageInfo = pageInfo;
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Information to aid in pagination
     */
    public @Nullable PageInfo pageInfo() {
      return this.pageInfo;
    }

    /**
     *  A list of edges that links to Fulfilment type node
     */
    public @Nullable List<Edge> edges() {
      return this.edges;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], pageInfo != null ? pageInfo.marshaller() : null);
          writer.writeList($responseFields[2], edges, new ResponseWriter.ListWriter() {
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
        $toString = "Fulfilments{"
          + "__typename=" + __typename + ", "
          + "pageInfo=" + pageInfo + ", "
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
      if (o instanceof Fulfilments) {
        Fulfilments that = (Fulfilments) o;
        return this.__typename.equals(that.__typename)
         && ((this.pageInfo == null) ? (that.pageInfo == null) : this.pageInfo.equals(that.pageInfo))
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
        h ^= (pageInfo == null) ? 0 : pageInfo.hashCode();
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
      builder.pageInfo = pageInfo;
      builder.edges = edges;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Fulfilments> {
      final PageInfo.Mapper pageInfoFieldMapper = new PageInfo.Mapper();

      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      @Override
      public Fulfilments map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final PageInfo pageInfo = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<PageInfo>() {
          @Override
          public PageInfo read(ResponseReader reader) {
            return pageInfoFieldMapper.map(reader);
          }
        });
        final List<Edge> edges = reader.readList($responseFields[2], new ResponseReader.ListReader<Edge>() {
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
        return new Fulfilments(__typename, pageInfo, edges);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable PageInfo pageInfo;

      private @Nullable List<Edge> edges;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder pageInfo(@Nullable PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
      }

      public Builder edges(@Nullable List<Edge> edges) {
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

      public Fulfilments build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Fulfilments(__typename, pageInfo, edges);
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

  public static class Edge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String cursor;

    final @Nullable Node node;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge(@Nonnull String __typename, @Nullable String cursor, @Nullable Node node) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.cursor = cursor;
      this.node = node;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A cursor for use in pagination
     */
    public @Nullable String cursor() {
      return this.cursor;
    }

    /**
     *  The item at the end of the Fulfilment edge
     */
    public @Nullable Node node() {
      return this.node;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], cursor);
          writer.writeObject($responseFields[2], node != null ? node.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Edge{"
          + "__typename=" + __typename + ", "
          + "cursor=" + cursor + ", "
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
         && ((this.cursor == null) ? (that.cursor == null) : this.cursor.equals(that.cursor))
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
        h ^= (cursor == null) ? 0 : cursor.hashCode();
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
      builder.cursor = cursor;
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
        final String cursor = reader.readString($responseFields[1]);
        final Node node = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<Node>() {
          @Override
          public Node read(ResponseReader reader) {
            return nodeFieldMapper.map(reader);
          }
        });
        return new Edge(__typename, cursor, node);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String cursor;

      private @Nullable Node node;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
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
        return new Edge(__typename, cursor, node);
      }
    }
  }

  public static class Node {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("eta", "eta", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("expiryTime", "expiryTime", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable String eta;

    final @Nullable Object expiryTime;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable Object createdOn, @Nullable Object updatedOn,
        @Nullable String eta, @Nullable Object expiryTime) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.eta = eta;
      this.expiryTime = expiryTime;
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
     *  The current status of the `Fulfilment`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
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

    /**
     *  The estimated time of completing the fulfilment.
     */
    public @Nullable String eta() {
      return this.eta;
    }

    /**
     *  Expiry time for the fulfilment
     */
    public @Nullable Object expiryTime() {
      return this.expiryTime;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[4], createdOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[5], updatedOn);
          writer.writeString($responseFields[6], eta);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[7], expiryTime);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "eta=" + eta + ", "
          + "expiryTime=" + expiryTime
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
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.eta == null) ? (that.eta == null) : this.eta.equals(that.eta))
         && ((this.expiryTime == null) ? (that.expiryTime == null) : this.expiryTime.equals(that.expiryTime));
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
        h ^= (createdOn == null) ? 0 : createdOn.hashCode();
        h *= 1000003;
        h ^= (updatedOn == null) ? 0 : updatedOn.hashCode();
        h *= 1000003;
        h ^= (eta == null) ? 0 : eta.hashCode();
        h *= 1000003;
        h ^= (expiryTime == null) ? 0 : expiryTime.hashCode();
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
      builder.createdOn = createdOn;
      builder.updatedOn = updatedOn;
      builder.eta = eta;
      builder.expiryTime = expiryTime;
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
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[4]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final String eta = reader.readString($responseFields[6]);
        final Object expiryTime = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[7]);
        return new Node(__typename, id, ref, status, createdOn, updatedOn, eta, expiryTime);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

      private @Nullable String eta;

      private @Nullable Object expiryTime;

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

      public Builder createdOn(@Nullable Object createdOn) {
        this.createdOn = createdOn;
        return this;
      }

      public Builder updatedOn(@Nullable Object updatedOn) {
        this.updatedOn = updatedOn;
        return this;
      }

      public Builder eta(@Nullable String eta) {
        this.eta = eta;
        return this;
      }

      public Builder expiryTime(@Nullable Object expiryTime) {
        this.expiryTime = expiryTime;
        return this;
      }

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Node(__typename, id, ref, status, createdOn, updatedOn, eta, expiryTime);
      }
    }
  }
}
