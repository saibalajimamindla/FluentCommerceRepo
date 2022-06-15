package com.fluentcommerce.commonv2.graphql.query.inventory;

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
import com.fluentcommerce.commonv2.graphql.type.GeoCoordinateInput;
import com.fluentcommerce.commonv2.graphql.type.ProductQuantityInput;
import com.fluentcommerce.commonv2.graphql.type.VirtualCatalogueKey;
import java.io.IOException;
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
public final class SearchVirtualInventoryQuery implements Query<SearchVirtualInventoryQuery.Data, SearchVirtualInventoryQuery.Data, SearchVirtualInventoryQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query SearchVirtualInventory($virtualCatalogue: VirtualCatalogueKey!, $productQuantities: [ProductQuantityInput!]!, $excludedLocationRefs: [String!], $orderByProximity: GeoCoordinateInput, $count: Int) {\n"
      + "  searchVirtualInventory(virtualCatalogue: $virtualCatalogue, productQuantities: $productQuantities, excludedLocationRefs: $excludedLocationRefs, orderByProximity: $orderByProximity, first: $count) {\n"
      + "    __typename\n"
      + "    edges {\n"
      + "      __typename\n"
      + "      node {\n"
      + "        __typename\n"
      + "        location {\n"
      + "          __typename\n"
      + "          type\n"
      + "          id\n"
      + "          ref\n"
      + "          networks {\n"
      + "            __typename\n"
      + "            edges {\n"
      + "              __typename\n"
      + "              node {\n"
      + "                __typename\n"
      + "                ref\n"
      + "              }\n"
      + "            }\n"
      + "          }\n"
      + "          primaryAddress {\n"
      + "            __typename\n"
      + "            street\n"
      + "            city\n"
      + "            state\n"
      + "            postcode\n"
      + "            country\n"
      + "            latitude\n"
      + "            longitude\n"
      + "          }\n"
      + "        }\n"
      + "        virtualPositions {\n"
      + "          __typename\n"
      + "          status\n"
      + "          ref\n"
      + "          productRef\n"
      + "          quantity\n"
      + "          groupRef\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "SearchVirtualInventory";
    }
  };

  private final SearchVirtualInventoryQuery.Variables variables;

  public SearchVirtualInventoryQuery(@Nonnull VirtualCatalogueKey virtualCatalogue,
      @Nonnull List<ProductQuantityInput> productQuantities,
      @Nullable List<String> excludedLocationRefs, @Nullable GeoCoordinateInput orderByProximity,
      @Nullable Integer count) {
    Utils.checkNotNull(virtualCatalogue, "virtualCatalogue == null");
    Utils.checkNotNull(productQuantities, "productQuantities == null");
    variables = new SearchVirtualInventoryQuery.Variables(virtualCatalogue, productQuantities, excludedLocationRefs, orderByProximity, count);
  }

  @Override
  public String operationId() {
    return "1251d4bc0f619b37b6de3360cd20a59297682ce81cb6788faa7d82a094d527af";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public SearchVirtualInventoryQuery.Data wrapData(SearchVirtualInventoryQuery.Data data) {
    return data;
  }

  @Override
  public SearchVirtualInventoryQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<SearchVirtualInventoryQuery.Data> responseFieldMapper() {
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
    private @Nonnull VirtualCatalogueKey virtualCatalogue;

    private @Nonnull List<ProductQuantityInput> productQuantities;

    private @Nullable List<String> excludedLocationRefs;

    private @Nullable GeoCoordinateInput orderByProximity;

    private @Nullable Integer count;

    Builder() {
    }

    public Builder virtualCatalogue(@Nonnull VirtualCatalogueKey virtualCatalogue) {
      this.virtualCatalogue = virtualCatalogue;
      return this;
    }

    public Builder productQuantities(@Nonnull List<ProductQuantityInput> productQuantities) {
      this.productQuantities = productQuantities;
      return this;
    }

    public Builder excludedLocationRefs(@Nullable List<String> excludedLocationRefs) {
      this.excludedLocationRefs = excludedLocationRefs;
      return this;
    }

    public Builder orderByProximity(@Nullable GeoCoordinateInput orderByProximity) {
      this.orderByProximity = orderByProximity;
      return this;
    }

    public Builder count(@Nullable Integer count) {
      this.count = count;
      return this;
    }

    public SearchVirtualInventoryQuery build() {
      Utils.checkNotNull(virtualCatalogue, "virtualCatalogue == null");
      Utils.checkNotNull(productQuantities, "productQuantities == null");
      return new SearchVirtualInventoryQuery(virtualCatalogue, productQuantities, excludedLocationRefs, orderByProximity, count);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull VirtualCatalogueKey virtualCatalogue;

    private final @Nonnull List<ProductQuantityInput> productQuantities;

    private final @Nullable List<String> excludedLocationRefs;

    private final @Nullable GeoCoordinateInput orderByProximity;

    private final @Nullable Integer count;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull VirtualCatalogueKey virtualCatalogue,
        @Nonnull List<ProductQuantityInput> productQuantities,
        @Nullable List<String> excludedLocationRefs, @Nullable GeoCoordinateInput orderByProximity,
        @Nullable Integer count) {
      this.virtualCatalogue = virtualCatalogue;
      this.productQuantities = productQuantities;
      this.excludedLocationRefs = excludedLocationRefs;
      this.orderByProximity = orderByProximity;
      this.count = count;
      this.valueMap.put("virtualCatalogue", virtualCatalogue);
      this.valueMap.put("productQuantities", productQuantities);
      this.valueMap.put("excludedLocationRefs", excludedLocationRefs);
      this.valueMap.put("orderByProximity", orderByProximity);
      this.valueMap.put("count", count);
    }

    public @Nonnull VirtualCatalogueKey virtualCatalogue() {
      return virtualCatalogue;
    }

    public @Nonnull List<ProductQuantityInput> productQuantities() {
      return productQuantities;
    }

    public @Nullable List<String> excludedLocationRefs() {
      return excludedLocationRefs;
    }

    public @Nullable GeoCoordinateInput orderByProximity() {
      return orderByProximity;
    }

    public @Nullable Integer count() {
      return count;
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
          writer.writeObject("virtualCatalogue", virtualCatalogue.marshaller());
          writer.writeList("productQuantities", new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (ProductQuantityInput $item : productQuantities) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          });
          writer.writeList("excludedLocationRefs", excludedLocationRefs != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : excludedLocationRefs) {
                listItemWriter.writeString($item);
              }
            }
          } : null);
          writer.writeObject("orderByProximity", orderByProximity != null ? orderByProximity.marshaller() : null);
          writer.writeInt("count", count);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("searchVirtualInventory", "searchVirtualInventory", new UnmodifiableMapBuilder<String, Object>(5)
        .put("excludedLocationRefs", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "excludedLocationRefs")
        .build())
        .put("virtualCatalogue", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "virtualCatalogue")
        .build())
        .put("orderByProximity", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "orderByProximity")
        .build())
        .put("productQuantities", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "productQuantities")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "count")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable SearchVirtualInventory searchVirtualInventory;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable SearchVirtualInventory searchVirtualInventory) {
      this.searchVirtualInventory = searchVirtualInventory;
    }

    /**
     *  This query searches the virtual inventory to return locations and available-to-sell stock for the requested products and their given quantities.
     */
    public @Nullable SearchVirtualInventory searchVirtualInventory() {
      return this.searchVirtualInventory;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], searchVirtualInventory != null ? searchVirtualInventory.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "searchVirtualInventory=" + searchVirtualInventory
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
        return ((this.searchVirtualInventory == null) ? (that.searchVirtualInventory == null) : this.searchVirtualInventory.equals(that.searchVirtualInventory));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (searchVirtualInventory == null) ? 0 : searchVirtualInventory.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.searchVirtualInventory = searchVirtualInventory;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final SearchVirtualInventory.Mapper searchVirtualInventoryFieldMapper = new SearchVirtualInventory.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final SearchVirtualInventory searchVirtualInventory = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<SearchVirtualInventory>() {
          @Override
          public SearchVirtualInventory read(ResponseReader reader) {
            return searchVirtualInventoryFieldMapper.map(reader);
          }
        });
        return new Data(searchVirtualInventory);
      }
    }

    public static final class Builder {
      private @Nullable SearchVirtualInventory searchVirtualInventory;

      Builder() {
      }

      public Builder searchVirtualInventory(@Nullable SearchVirtualInventory searchVirtualInventory) {
        this.searchVirtualInventory = searchVirtualInventory;
        return this;
      }

      public Builder searchVirtualInventory(@Nonnull Mutator<SearchVirtualInventory.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        SearchVirtualInventory.Builder builder = this.searchVirtualInventory != null ? this.searchVirtualInventory.toBuilder() : SearchVirtualInventory.builder();
        mutator.accept(builder);
        this.searchVirtualInventory = builder.build();
        return this;
      }

      public Data build() {
        return new Data(searchVirtualInventory);
      }
    }
  }

  public static class SearchVirtualInventory {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public SearchVirtualInventory(@Nonnull String __typename, @Nullable List<Edge> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to VirtualInventory type node
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
        $toString = "SearchVirtualInventory{"
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
      if (o instanceof SearchVirtualInventory) {
        SearchVirtualInventory that = (SearchVirtualInventory) o;
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

    public static final class Mapper implements ResponseFieldMapper<SearchVirtualInventory> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      @Override
      public SearchVirtualInventory map(ResponseReader reader) {
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
        return new SearchVirtualInventory(__typename, edges);
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

      public SearchVirtualInventory build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new SearchVirtualInventory(__typename, edges);
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
     *  The item at the end of the VirtualInventory edge
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
      ResponseField.forObject("location", "location", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("virtualPositions", "virtualPositions", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Location location;

    final @Nullable List<VirtualPosition> virtualPositions;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nullable Location location,
        @Nullable List<VirtualPosition> virtualPositions) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.location = location;
      this.virtualPositions = virtualPositions;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  `Location` of the stock
     */
    public @Nullable Location location() {
      return this.location;
    }

    /**
     *  An array of `VirtualPositions`. This will contain all necessary information pertaining to products and corresponding available-to-sell stock.
     */
    public @Nullable List<VirtualPosition> virtualPositions() {
      return this.virtualPositions;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], location != null ? location.marshaller() : null);
          writer.writeList($responseFields[2], virtualPositions, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((VirtualPosition) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "location=" + location + ", "
          + "virtualPositions=" + virtualPositions
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
         && ((this.location == null) ? (that.location == null) : this.location.equals(that.location))
         && ((this.virtualPositions == null) ? (that.virtualPositions == null) : this.virtualPositions.equals(that.virtualPositions));
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
        h ^= (location == null) ? 0 : location.hashCode();
        h *= 1000003;
        h ^= (virtualPositions == null) ? 0 : virtualPositions.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.location = location;
      builder.virtualPositions = virtualPositions;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node> {
      final Location.Mapper locationFieldMapper = new Location.Mapper();

      final VirtualPosition.Mapper virtualPositionFieldMapper = new VirtualPosition.Mapper();

      @Override
      public Node map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Location location = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Location>() {
          @Override
          public Location read(ResponseReader reader) {
            return locationFieldMapper.map(reader);
          }
        });
        final List<VirtualPosition> virtualPositions = reader.readList($responseFields[2], new ResponseReader.ListReader<VirtualPosition>() {
          @Override
          public VirtualPosition read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<VirtualPosition>() {
              @Override
              public VirtualPosition read(ResponseReader reader) {
                return virtualPositionFieldMapper.map(reader);
              }
            });
          }
        });
        return new Node(__typename, location, virtualPositions);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Location location;

      private @Nullable List<VirtualPosition> virtualPositions;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder location(@Nullable Location location) {
        this.location = location;
        return this;
      }

      public Builder virtualPositions(@Nullable List<VirtualPosition> virtualPositions) {
        this.virtualPositions = virtualPositions;
        return this;
      }

      public Builder location(@Nonnull Mutator<Location.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Location.Builder builder = this.location != null ? this.location.toBuilder() : Location.builder();
        mutator.accept(builder);
        this.location = builder.build();
        return this;
      }

      public Builder virtualPositions(@Nonnull Mutator<List<VirtualPosition.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<VirtualPosition.Builder> builders = new ArrayList<>();
        if (this.virtualPositions != null) {
          for (VirtualPosition item : this.virtualPositions) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<VirtualPosition> virtualPositions = new ArrayList<>();
        for (VirtualPosition.Builder item : builders) {
          virtualPositions.add(item != null ? item.build() : null);
        }
        this.virtualPositions = virtualPositions;
        return this;
      }

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Node(__typename, location, virtualPositions);
      }
    }
  }

  public static class Location {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("networks", "networks", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("primaryAddress", "primaryAddress", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String type;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable Networks networks;

    final @Nullable PrimaryAddress primaryAddress;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Location(@Nonnull String __typename, @Nullable String type, @Nonnull String id,
        @Nullable String ref, @Nullable Networks networks,
        @Nullable PrimaryAddress primaryAddress) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.type = type;
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.networks = networks;
      this.primaryAddress = primaryAddress;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Type
     */
    public @Nullable String type() {
      return this.type;
    }

    /**
     *  ID of the object
     */
    public @Nonnull String id() {
      return this.id;
    }

    /**
     *  The location (i.e. store) id provided by the retailer
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  Networks the location is assigned to
     */
    public @Nullable Networks networks() {
      return this.networks;
    }

    /**
     *  Store location of the the location
     */
    public @Nullable PrimaryAddress primaryAddress() {
      return this.primaryAddress;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], type);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], id);
          writer.writeString($responseFields[3], ref);
          writer.writeObject($responseFields[4], networks != null ? networks.marshaller() : null);
          writer.writeObject($responseFields[5], primaryAddress != null ? primaryAddress.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Location{"
          + "__typename=" + __typename + ", "
          + "type=" + type + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "networks=" + networks + ", "
          + "primaryAddress=" + primaryAddress
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Location) {
        Location that = (Location) o;
        return this.__typename.equals(that.__typename)
         && ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.networks == null) ? (that.networks == null) : this.networks.equals(that.networks))
         && ((this.primaryAddress == null) ? (that.primaryAddress == null) : this.primaryAddress.equals(that.primaryAddress));
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
        h ^= (type == null) ? 0 : type.hashCode();
        h *= 1000003;
        h ^= id.hashCode();
        h *= 1000003;
        h ^= (ref == null) ? 0 : ref.hashCode();
        h *= 1000003;
        h ^= (networks == null) ? 0 : networks.hashCode();
        h *= 1000003;
        h ^= (primaryAddress == null) ? 0 : primaryAddress.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.type = type;
      builder.id = id;
      builder.ref = ref;
      builder.networks = networks;
      builder.primaryAddress = primaryAddress;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Location> {
      final Networks.Mapper networksFieldMapper = new Networks.Mapper();

      final PrimaryAddress.Mapper primaryAddressFieldMapper = new PrimaryAddress.Mapper();

      @Override
      public Location map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String type = reader.readString($responseFields[1]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final String ref = reader.readString($responseFields[3]);
        final Networks networks = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<Networks>() {
          @Override
          public Networks read(ResponseReader reader) {
            return networksFieldMapper.map(reader);
          }
        });
        final PrimaryAddress primaryAddress = reader.readObject($responseFields[5], new ResponseReader.ObjectReader<PrimaryAddress>() {
          @Override
          public PrimaryAddress read(ResponseReader reader) {
            return primaryAddressFieldMapper.map(reader);
          }
        });
        return new Location(__typename, type, id, ref, networks, primaryAddress);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String type;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable Networks networks;

      private @Nullable PrimaryAddress primaryAddress;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder type(@Nullable String type) {
        this.type = type;
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

      public Builder networks(@Nullable Networks networks) {
        this.networks = networks;
        return this;
      }

      public Builder primaryAddress(@Nullable PrimaryAddress primaryAddress) {
        this.primaryAddress = primaryAddress;
        return this;
      }

      public Builder networks(@Nonnull Mutator<Networks.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Networks.Builder builder = this.networks != null ? this.networks.toBuilder() : Networks.builder();
        mutator.accept(builder);
        this.networks = builder.build();
        return this;
      }

      public Builder primaryAddress(@Nonnull Mutator<PrimaryAddress.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PrimaryAddress.Builder builder = this.primaryAddress != null ? this.primaryAddress.toBuilder() : PrimaryAddress.builder();
        mutator.accept(builder);
        this.primaryAddress = builder.build();
        return this;
      }

      public Location build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Location(__typename, type, id, ref, networks, primaryAddress);
      }
    }
  }

  public static class Networks {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge1> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Networks(@Nonnull String __typename, @Nullable List<Edge1> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Network type node
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
        $toString = "Networks{"
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
      if (o instanceof Networks) {
        Networks that = (Networks) o;
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

    public static final class Mapper implements ResponseFieldMapper<Networks> {
      final Edge1.Mapper edge1FieldMapper = new Edge1.Mapper();

      @Override
      public Networks map(ResponseReader reader) {
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
        return new Networks(__typename, edges);
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

      public Networks build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Networks(__typename, edges);
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
     *  The item at the end of the Network edge
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
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String ref;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node1(@Nonnull String __typename, @Nullable String ref) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = ref;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Reference to the network. This is the name of the network you passed in while creating the network. Recommended to be unique.
     */
    public @Nullable String ref() {
      return this.ref;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node1{"
          + "__typename=" + __typename + ", "
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
      if (o instanceof Node1) {
        Node1 that = (Node1) o;
        return this.__typename.equals(that.__typename)
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
        h ^= (ref == null) ? 0 : ref.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.ref = ref;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node1> {
      @Override
      public Node1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        return new Node1(__typename, ref);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String ref;

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

      public Node1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Node1(__typename, ref);
      }
    }
  }

  public static class PrimaryAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("street", "street", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("city", "city", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("state", "state", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("postcode", "postcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("latitude", "latitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("longitude", "longitude", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String street;

    final @Nullable String city;

    final @Nullable String state;

    final @Nullable String postcode;

    final @Nullable String country;

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PrimaryAddress(@Nonnull String __typename, @Nullable String street,
        @Nullable String city, @Nullable String state, @Nullable String postcode,
        @Nullable String country, @Nullable Double latitude, @Nullable Double longitude) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.street = street;
      this.city = city;
      this.state = state;
      this.postcode = postcode;
      this.country = country;
      this.latitude = latitude;
      this.longitude = longitude;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Street
     */
    public @Nullable String street() {
      return this.street;
    }

    /**
     *  City
     */
    public @Nullable String city() {
      return this.city;
    }

    /**
     *  State
     */
    public @Nullable String state() {
      return this.state;
    }

    /**
     *  Postcode
     */
    public @Nullable String postcode() {
      return this.postcode;
    }

    /**
     *  Country
     */
    public @Nullable String country() {
      return this.country;
    }

    /**
     *  Latitude
     */
    public @Nullable Double latitude() {
      return this.latitude;
    }

    /**
     *  Longitude
     */
    public @Nullable Double longitude() {
      return this.longitude;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], street);
          writer.writeString($responseFields[2], city);
          writer.writeString($responseFields[3], state);
          writer.writeString($responseFields[4], postcode);
          writer.writeString($responseFields[5], country);
          writer.writeDouble($responseFields[6], latitude);
          writer.writeDouble($responseFields[7], longitude);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PrimaryAddress{"
          + "__typename=" + __typename + ", "
          + "street=" + street + ", "
          + "city=" + city + ", "
          + "state=" + state + ", "
          + "postcode=" + postcode + ", "
          + "country=" + country + ", "
          + "latitude=" + latitude + ", "
          + "longitude=" + longitude
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PrimaryAddress) {
        PrimaryAddress that = (PrimaryAddress) o;
        return this.__typename.equals(that.__typename)
         && ((this.street == null) ? (that.street == null) : this.street.equals(that.street))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.state == null) ? (that.state == null) : this.state.equals(that.state))
         && ((this.postcode == null) ? (that.postcode == null) : this.postcode.equals(that.postcode))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
         && ((this.latitude == null) ? (that.latitude == null) : this.latitude.equals(that.latitude))
         && ((this.longitude == null) ? (that.longitude == null) : this.longitude.equals(that.longitude));
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
        h ^= (street == null) ? 0 : street.hashCode();
        h *= 1000003;
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (state == null) ? 0 : state.hashCode();
        h *= 1000003;
        h ^= (postcode == null) ? 0 : postcode.hashCode();
        h *= 1000003;
        h ^= (country == null) ? 0 : country.hashCode();
        h *= 1000003;
        h ^= (latitude == null) ? 0 : latitude.hashCode();
        h *= 1000003;
        h ^= (longitude == null) ? 0 : longitude.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.street = street;
      builder.city = city;
      builder.state = state;
      builder.postcode = postcode;
      builder.country = country;
      builder.latitude = latitude;
      builder.longitude = longitude;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<PrimaryAddress> {
      @Override
      public PrimaryAddress map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String street = reader.readString($responseFields[1]);
        final String city = reader.readString($responseFields[2]);
        final String state = reader.readString($responseFields[3]);
        final String postcode = reader.readString($responseFields[4]);
        final String country = reader.readString($responseFields[5]);
        final Double latitude = reader.readDouble($responseFields[6]);
        final Double longitude = reader.readDouble($responseFields[7]);
        return new PrimaryAddress(__typename, street, city, state, postcode, country, latitude, longitude);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String street;

      private @Nullable String city;

      private @Nullable String state;

      private @Nullable String postcode;

      private @Nullable String country;

      private @Nullable Double latitude;

      private @Nullable Double longitude;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder street(@Nullable String street) {
        this.street = street;
        return this;
      }

      public Builder city(@Nullable String city) {
        this.city = city;
        return this;
      }

      public Builder state(@Nullable String state) {
        this.state = state;
        return this;
      }

      public Builder postcode(@Nullable String postcode) {
        this.postcode = postcode;
        return this;
      }

      public Builder country(@Nullable String country) {
        this.country = country;
        return this;
      }

      public Builder latitude(@Nullable Double latitude) {
        this.latitude = latitude;
        return this;
      }

      public Builder longitude(@Nullable Double longitude) {
        this.longitude = longitude;
        return this;
      }

      public PrimaryAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new PrimaryAddress(__typename, street, city, state, postcode, country, latitude, longitude);
      }
    }
  }

  public static class VirtualPosition {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("productRef", "productRef", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("groupRef", "groupRef", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String status;

    final @Nonnull String ref;

    final @Nullable String productRef;

    final @Nullable Integer quantity;

    final @Nullable String groupRef;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public VirtualPosition(@Nonnull String __typename, @Nullable String status, @Nonnull String ref,
        @Nullable String productRef, @Nullable Integer quantity, @Nullable String groupRef) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.status = status;
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.productRef = productRef;
      this.quantity = quantity;
      this.groupRef = groupRef;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The current status of the `VirtualPosition`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  The reference identifier used to identify an entity
     */
    public @Nonnull String ref() {
      return this.ref;
    }

    /**
     *  Product reference
     */
    public @Nullable String productRef() {
      return this.productRef;
    }

    /**
     *  On hand quantity
     */
    public @Nullable Integer quantity() {
      return this.quantity;
    }

    /**
     *  Group - reference to Location or Category
     */
    public @Nullable String groupRef() {
      return this.groupRef;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], status);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], productRef);
          writer.writeInt($responseFields[4], quantity);
          writer.writeString($responseFields[5], groupRef);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "VirtualPosition{"
          + "__typename=" + __typename + ", "
          + "status=" + status + ", "
          + "ref=" + ref + ", "
          + "productRef=" + productRef + ", "
          + "quantity=" + quantity + ", "
          + "groupRef=" + groupRef
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof VirtualPosition) {
        VirtualPosition that = (VirtualPosition) o;
        return this.__typename.equals(that.__typename)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.ref.equals(that.ref)
         && ((this.productRef == null) ? (that.productRef == null) : this.productRef.equals(that.productRef))
         && ((this.quantity == null) ? (that.quantity == null) : this.quantity.equals(that.quantity))
         && ((this.groupRef == null) ? (that.groupRef == null) : this.groupRef.equals(that.groupRef));
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
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= ref.hashCode();
        h *= 1000003;
        h ^= (productRef == null) ? 0 : productRef.hashCode();
        h *= 1000003;
        h ^= (quantity == null) ? 0 : quantity.hashCode();
        h *= 1000003;
        h ^= (groupRef == null) ? 0 : groupRef.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.status = status;
      builder.ref = ref;
      builder.productRef = productRef;
      builder.quantity = quantity;
      builder.groupRef = groupRef;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<VirtualPosition> {
      @Override
      public VirtualPosition map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String status = reader.readString($responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String productRef = reader.readString($responseFields[3]);
        final Integer quantity = reader.readInt($responseFields[4]);
        final String groupRef = reader.readString($responseFields[5]);
        return new VirtualPosition(__typename, status, ref, productRef, quantity, groupRef);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String status;

      private @Nonnull String ref;

      private @Nullable String productRef;

      private @Nullable Integer quantity;

      private @Nullable String groupRef;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder ref(@Nonnull String ref) {
        this.ref = ref;
        return this;
      }

      public Builder productRef(@Nullable String productRef) {
        this.productRef = productRef;
        return this;
      }

      public Builder quantity(@Nullable Integer quantity) {
        this.quantity = quantity;
        return this;
      }

      public Builder groupRef(@Nullable String groupRef) {
        this.groupRef = groupRef;
        return this;
      }

      public VirtualPosition build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(ref, "ref == null");
        return new VirtualPosition(__typename, status, ref, productRef, quantity, groupRef);
      }
    }
  }
}
