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
import java.lang.Double;
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
public final class GetLocationCoordinatesRefQuery implements Query<GetLocationCoordinatesRefQuery.Data, GetLocationCoordinatesRefQuery.Data, GetLocationCoordinatesRefQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetLocationCoordinatesRef($ref: String!) {\n"
      + "  location(ref: $ref) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    status\n"
      + "    primaryAddress {\n"
      + "      __typename\n"
      + "      ref\n"
      + "      latitude\n"
      + "      longitude\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetLocationCoordinatesRef";
    }
  };

  private final GetLocationCoordinatesRefQuery.Variables variables;

  public GetLocationCoordinatesRefQuery(@Nonnull String ref) {
    Utils.checkNotNull(ref, "ref == null");
    variables = new GetLocationCoordinatesRefQuery.Variables(ref);
  }

  @Override
  public String operationId() {
    return "1f8e67e63e57f97ce1ce0823d0d81dae7e8fa30a27069377e06dc9138f4beac6";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetLocationCoordinatesRefQuery.Data wrapData(GetLocationCoordinatesRefQuery.Data data) {
    return data;
  }

  @Override
  public GetLocationCoordinatesRefQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetLocationCoordinatesRefQuery.Data> responseFieldMapper() {
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
    private @Nonnull String ref;

    Builder() {
    }

    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    public GetLocationCoordinatesRefQuery build() {
      Utils.checkNotNull(ref, "ref == null");
      return new GetLocationCoordinatesRefQuery(ref);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String ref;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String ref) {
      this.ref = ref;
      this.valueMap.put("ref", ref);
    }

    public @Nonnull String ref() {
      return ref;
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
          writer.writeString("ref", ref);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("location", "location", new UnmodifiableMapBuilder<String, Object>(1)
        .put("ref", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "ref")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable Location location;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Location location) {
      this.location = location;
    }

    /**
     *  Find a Location entity
     */
    public @Nullable Location location() {
      return this.location;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], location != null ? location.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "location=" + location
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
        return ((this.location == null) ? (that.location == null) : this.location.equals(that.location));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (location == null) ? 0 : location.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.location = location;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Location.Mapper locationFieldMapper = new Location.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Location location = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Location>() {
          @Override
          public Location read(ResponseReader reader) {
            return locationFieldMapper.map(reader);
          }
        });
        return new Data(location);
      }
    }

    public static final class Builder {
      private @Nullable Location location;

      Builder() {
      }

      public Builder location(@Nullable Location location) {
        this.location = location;
        return this;
      }

      public Builder location(@Nonnull Mutator<Location.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Location.Builder builder = this.location != null ? this.location.toBuilder() : Location.builder();
        mutator.accept(builder);
        this.location = builder.build();
        return this;
      }

      public Data build() {
        return new Data(location);
      }
    }
  }

  public static class Location {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("primaryAddress", "primaryAddress", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable PrimaryAddress primaryAddress;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Location(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable PrimaryAddress primaryAddress) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
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
          writer.writeObject($responseFields[4], primaryAddress != null ? primaryAddress.marshaller() : null);
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
        final PrimaryAddress primaryAddress = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<PrimaryAddress>() {
          @Override
          public PrimaryAddress read(ResponseReader reader) {
            return primaryAddressFieldMapper.map(reader);
          }
        });
        return new Location(__typename, id, ref, status, primaryAddress);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

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
        return new Location(__typename, id, ref, status, primaryAddress);
      }
    }
  }

  public static class PrimaryAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("latitude", "latitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("longitude", "longitude", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String ref;

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PrimaryAddress(@Nonnull String __typename, @Nullable String ref,
        @Nullable Double latitude, @Nullable Double longitude) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = ref;
      this.latitude = latitude;
      this.longitude = longitude;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Location reference
     */
    public @Nullable String ref() {
      return this.ref;
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
          writer.writeString($responseFields[1], ref);
          writer.writeDouble($responseFields[2], latitude);
          writer.writeDouble($responseFields[3], longitude);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PrimaryAddress{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
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
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
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
        h ^= (ref == null) ? 0 : ref.hashCode();
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
      builder.ref = ref;
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
        final String ref = reader.readString($responseFields[1]);
        final Double latitude = reader.readDouble($responseFields[2]);
        final Double longitude = reader.readDouble($responseFields[3]);
        return new PrimaryAddress(__typename, ref, latitude, longitude);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String ref;

      private @Nullable Double latitude;

      private @Nullable Double longitude;

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
        return new PrimaryAddress(__typename, ref, latitude, longitude);
      }
    }
  }
}
