package com.fluentcommerce.commonv2.graphql.query.location;

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
public final class GetLocationsForNetworkRefQuery implements Query<GetLocationsForNetworkRefQuery.Data, GetLocationsForNetworkRefQuery.Data, GetLocationsForNetworkRefQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetLocationsForNetworkRef($networkRef: String!, $locationStatuses: [String]!, $locationCount: Int, $locationCursor: String) {\n"
      + "  network(ref: $networkRef) {\n"
      + "    __typename\n"
      + "    ref\n"
      + "    locations(status: $locationStatuses, first: $locationCount, after: $locationCursor) {\n"
      + "      __typename\n"
      + "      locationEdge: edges {\n"
      + "        __typename\n"
      + "        location: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "          status\n"
      + "          type\n"
      + "          primaryAddress {\n"
      + "            __typename\n"
      + "            longitude\n"
      + "            latitude\n"
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
      return "GetLocationsForNetworkRef";
    }
  };

  private final GetLocationsForNetworkRefQuery.Variables variables;

  public GetLocationsForNetworkRefQuery(@Nonnull String networkRef,
      @Nonnull List<String> locationStatuses, @Nullable Integer locationCount,
      @Nullable String locationCursor) {
    Utils.checkNotNull(networkRef, "networkRef == null");
    Utils.checkNotNull(locationStatuses, "locationStatuses == null");
    variables = new GetLocationsForNetworkRefQuery.Variables(networkRef, locationStatuses, locationCount, locationCursor);
  }

  @Override
  public String operationId() {
    return "b29b2181a1c06215e7c2d55ee2ca3b5be6b3c023c84eb0368917c0e8fb751082";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetLocationsForNetworkRefQuery.Data wrapData(GetLocationsForNetworkRefQuery.Data data) {
    return data;
  }

  @Override
  public GetLocationsForNetworkRefQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetLocationsForNetworkRefQuery.Data> responseFieldMapper() {
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
    private @Nonnull String networkRef;

    private @Nonnull List<String> locationStatuses;

    private @Nullable Integer locationCount;

    private @Nullable String locationCursor;

    Builder() {
    }

    public Builder networkRef(@Nonnull String networkRef) {
      this.networkRef = networkRef;
      return this;
    }

    public Builder locationStatuses(@Nonnull List<String> locationStatuses) {
      this.locationStatuses = locationStatuses;
      return this;
    }

    public Builder locationCount(@Nullable Integer locationCount) {
      this.locationCount = locationCount;
      return this;
    }

    public Builder locationCursor(@Nullable String locationCursor) {
      this.locationCursor = locationCursor;
      return this;
    }

    public GetLocationsForNetworkRefQuery build() {
      Utils.checkNotNull(networkRef, "networkRef == null");
      Utils.checkNotNull(locationStatuses, "locationStatuses == null");
      return new GetLocationsForNetworkRefQuery(networkRef, locationStatuses, locationCount, locationCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String networkRef;

    private final @Nonnull List<String> locationStatuses;

    private final @Nullable Integer locationCount;

    private final @Nullable String locationCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String networkRef, @Nonnull List<String> locationStatuses,
        @Nullable Integer locationCount, @Nullable String locationCursor) {
      this.networkRef = networkRef;
      this.locationStatuses = locationStatuses;
      this.locationCount = locationCount;
      this.locationCursor = locationCursor;
      this.valueMap.put("networkRef", networkRef);
      this.valueMap.put("locationStatuses", locationStatuses);
      this.valueMap.put("locationCount", locationCount);
      this.valueMap.put("locationCursor", locationCursor);
    }

    public @Nonnull String networkRef() {
      return networkRef;
    }

    public @Nonnull List<String> locationStatuses() {
      return locationStatuses;
    }

    public @Nullable Integer locationCount() {
      return locationCount;
    }

    public @Nullable String locationCursor() {
      return locationCursor;
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
          writer.writeString("networkRef", networkRef);
          writer.writeList("locationStatuses", new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : locationStatuses) {
                listItemWriter.writeString($item);
              }
            }
          });
          writer.writeInt("locationCount", locationCount);
          writer.writeString("locationCursor", locationCursor);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("network", "network", new UnmodifiableMapBuilder<String, Object>(1)
        .put("ref", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "networkRef")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable Network network;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Network network) {
      this.network = network;
    }

    /**
     *  Find a Network entity
     */
    public @Nullable Network network() {
      return this.network;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], network != null ? network.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "network=" + network
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
        return ((this.network == null) ? (that.network == null) : this.network.equals(that.network));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (network == null) ? 0 : network.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.network = network;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Network.Mapper networkFieldMapper = new Network.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Network network = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Network>() {
          @Override
          public Network read(ResponseReader reader) {
            return networkFieldMapper.map(reader);
          }
        });
        return new Data(network);
      }
    }

    public static final class Builder {
      private @Nullable Network network;

      Builder() {
      }

      public Builder network(@Nullable Network network) {
        this.network = network;
        return this;
      }

      public Builder network(@Nonnull Mutator<Network.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Network.Builder builder = this.network != null ? this.network.toBuilder() : Network.builder();
        mutator.accept(builder);
        this.network = builder.build();
        return this;
      }

      public Data build() {
        return new Data(network);
      }
    }
  }

  public static class Network {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("locations", "locations", new UnmodifiableMapBuilder<String, Object>(3)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "locationCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "locationCount")
        .build())
        .put("status", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "locationStatuses")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String ref;

    final @Nullable Locations locations;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Network(@Nonnull String __typename, @Nullable String ref,
        @Nullable Locations locations) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = ref;
      this.locations = locations;
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

    /**
     *  Locations in the network
     */
    public @Nullable Locations locations() {
      return this.locations;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
          writer.writeObject($responseFields[2], locations != null ? locations.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Network{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
          + "locations=" + locations
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Network) {
        Network that = (Network) o;
        return this.__typename.equals(that.__typename)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.locations == null) ? (that.locations == null) : this.locations.equals(that.locations));
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
        h ^= (locations == null) ? 0 : locations.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.ref = ref;
      builder.locations = locations;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Network> {
      final Locations.Mapper locationsFieldMapper = new Locations.Mapper();

      @Override
      public Network map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        final Locations locations = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<Locations>() {
          @Override
          public Locations read(ResponseReader reader) {
            return locationsFieldMapper.map(reader);
          }
        });
        return new Network(__typename, ref, locations);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String ref;

      private @Nullable Locations locations;

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

      public Builder locations(@Nullable Locations locations) {
        this.locations = locations;
        return this;
      }

      public Builder locations(@Nonnull Mutator<Locations.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Locations.Builder builder = this.locations != null ? this.locations.toBuilder() : Locations.builder();
        mutator.accept(builder);
        this.locations = builder.build();
        return this;
      }

      public Network build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Network(__typename, ref, locations);
      }
    }
  }

  public static class Locations {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("locationEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<LocationEdge> locationEdge;

    final @Nullable PageInfo pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Locations(@Nonnull String __typename, @Nullable List<LocationEdge> locationEdge,
        @Nullable PageInfo pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.locationEdge = locationEdge;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Location type node
     */
    public @Nullable List<LocationEdge> locationEdge() {
      return this.locationEdge;
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
          writer.writeList($responseFields[1], locationEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((LocationEdge) value).marshaller());
            }
          });
          writer.writeObject($responseFields[2], pageInfo != null ? pageInfo.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Locations{"
          + "__typename=" + __typename + ", "
          + "locationEdge=" + locationEdge + ", "
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
      if (o instanceof Locations) {
        Locations that = (Locations) o;
        return this.__typename.equals(that.__typename)
         && ((this.locationEdge == null) ? (that.locationEdge == null) : this.locationEdge.equals(that.locationEdge))
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
        h ^= (locationEdge == null) ? 0 : locationEdge.hashCode();
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
      builder.locationEdge = locationEdge;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Locations> {
      final LocationEdge.Mapper locationEdgeFieldMapper = new LocationEdge.Mapper();

      final PageInfo.Mapper pageInfoFieldMapper = new PageInfo.Mapper();

      @Override
      public Locations map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<LocationEdge> locationEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<LocationEdge>() {
          @Override
          public LocationEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<LocationEdge>() {
              @Override
              public LocationEdge read(ResponseReader reader) {
                return locationEdgeFieldMapper.map(reader);
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
        return new Locations(__typename, locationEdge, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<LocationEdge> locationEdge;

      private @Nullable PageInfo pageInfo;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder locationEdge(@Nullable List<LocationEdge> locationEdge) {
        this.locationEdge = locationEdge;
        return this;
      }

      public Builder pageInfo(@Nullable PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
      }

      public Builder locationEdge(@Nonnull Mutator<List<LocationEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<LocationEdge.Builder> builders = new ArrayList<>();
        if (this.locationEdge != null) {
          for (LocationEdge item : this.locationEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<LocationEdge> locationEdge = new ArrayList<>();
        for (LocationEdge.Builder item : builders) {
          locationEdge.add(item != null ? item.build() : null);
        }
        this.locationEdge = locationEdge;
        return this;
      }

      public Builder pageInfo(@Nonnull Mutator<PageInfo.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public Locations build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Locations(__typename, locationEdge, pageInfo);
      }
    }
  }

  public static class LocationEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("location", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Location location;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public LocationEdge(@Nonnull String __typename, @Nullable Location location,
        @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.location = location;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Location edge
     */
    public @Nullable Location location() {
      return this.location;
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
          writer.writeObject($responseFields[1], location != null ? location.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "LocationEdge{"
          + "__typename=" + __typename + ", "
          + "location=" + location + ", "
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
      if (o instanceof LocationEdge) {
        LocationEdge that = (LocationEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.location == null) ? (that.location == null) : this.location.equals(that.location))
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
        h ^= (location == null) ? 0 : location.hashCode();
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
      builder.location = location;
      builder.cursor = cursor;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<LocationEdge> {
      final Location.Mapper locationFieldMapper = new Location.Mapper();

      @Override
      public LocationEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Location location = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Location>() {
          @Override
          public Location read(ResponseReader reader) {
            return locationFieldMapper.map(reader);
          }
        });
        final String cursor = reader.readString($responseFields[2]);
        return new LocationEdge(__typename, location, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Location location;

      private @Nullable String cursor;

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

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
        return this;
      }

      public Builder location(@Nonnull Mutator<Location.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Location.Builder builder = this.location != null ? this.location.toBuilder() : Location.builder();
        mutator.accept(builder);
        this.location = builder.build();
        return this;
      }

      public LocationEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new LocationEdge(__typename, location, cursor);
      }
    }
  }

  public static class Location {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("primaryAddress", "primaryAddress", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable String type;

    final @Nullable PrimaryAddress primaryAddress;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Location(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable String type, @Nullable PrimaryAddress primaryAddress) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.type = type;
      this.primaryAddress = primaryAddress;
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
     *  The location (i.e. store) id provided by the retailer
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  The location status. Possible values are 'ACTIVE', 'INACTIVE'.
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Type
     */
    public @Nullable String type() {
      return this.type;
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
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], type);
          writer.writeObject($responseFields[5], primaryAddress != null ? primaryAddress.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Location{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "type=" + type + ", "
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
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
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
        h ^= id.hashCode();
        h *= 1000003;
        h ^= (ref == null) ? 0 : ref.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (type == null) ? 0 : type.hashCode();
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
      builder.id = id;
      builder.ref = ref;
      builder.status = status;
      builder.type = type;
      builder.primaryAddress = primaryAddress;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Location> {
      final PrimaryAddress.Mapper primaryAddressFieldMapper = new PrimaryAddress.Mapper();

      @Override
      public Location map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String type = reader.readString($responseFields[4]);
        final PrimaryAddress primaryAddress = reader.readObject($responseFields[5], new ResponseReader.ObjectReader<PrimaryAddress>() {
          @Override
          public PrimaryAddress read(ResponseReader reader) {
            return primaryAddressFieldMapper.map(reader);
          }
        });
        return new Location(__typename, id, ref, status, type, primaryAddress);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable String type;

      private @Nullable PrimaryAddress primaryAddress;

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

      public Builder type(@Nullable String type) {
        this.type = type;
        return this;
      }

      public Builder primaryAddress(@Nullable PrimaryAddress primaryAddress) {
        this.primaryAddress = primaryAddress;
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
        return new Location(__typename, id, ref, status, type, primaryAddress);
      }
    }
  }

  public static class PrimaryAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("longitude", "longitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("latitude", "latitude", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Double longitude;

    final @Nullable Double latitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PrimaryAddress(@Nonnull String __typename, @Nullable Double longitude,
        @Nullable Double latitude) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.longitude = longitude;
      this.latitude = latitude;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Longitude
     */
    public @Nullable Double longitude() {
      return this.longitude;
    }

    /**
     *  Latitude
     */
    public @Nullable Double latitude() {
      return this.latitude;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeDouble($responseFields[1], longitude);
          writer.writeDouble($responseFields[2], latitude);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PrimaryAddress{"
          + "__typename=" + __typename + ", "
          + "longitude=" + longitude + ", "
          + "latitude=" + latitude
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
         && ((this.longitude == null) ? (that.longitude == null) : this.longitude.equals(that.longitude))
         && ((this.latitude == null) ? (that.latitude == null) : this.latitude.equals(that.latitude));
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
        h ^= (longitude == null) ? 0 : longitude.hashCode();
        h *= 1000003;
        h ^= (latitude == null) ? 0 : latitude.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.longitude = longitude;
      builder.latitude = latitude;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<PrimaryAddress> {
      @Override
      public PrimaryAddress map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        final Double latitude = reader.readDouble($responseFields[2]);
        return new PrimaryAddress(__typename, longitude, latitude);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Double longitude;

      private @Nullable Double latitude;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder longitude(@Nullable Double longitude) {
        this.longitude = longitude;
        return this;
      }

      public Builder latitude(@Nullable Double latitude) {
        this.latitude = latitude;
        return this;
      }

      public PrimaryAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new PrimaryAddress(__typename, longitude, latitude);
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
}
