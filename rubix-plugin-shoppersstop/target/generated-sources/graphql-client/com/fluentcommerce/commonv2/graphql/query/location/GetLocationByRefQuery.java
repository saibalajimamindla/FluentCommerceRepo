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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class GetLocationByRefQuery implements Query<GetLocationByRefQuery.Data, GetLocationByRefQuery.Data, GetLocationByRefQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetLocationByRef($ref: String!, $includePrimaryAddress: Boolean!, $includeAttributes: Boolean!, $includeOpeningSchedule: Boolean!, $includeRetailer: Boolean!, $includeNetworks: Boolean!, $includeStorageAreas: Boolean!) {\n"
      + "  location(ref: $ref) {\n"
      + "    __typename\n"
      + "    ref\n"
      + "    id\n"
      + "    type\n"
      + "    status\n"
      + "    name\n"
      + "    supportPhoneNumber\n"
      + "    defaultCarrier\n"
      + "    defaultCarrierName\n"
      + "    primaryAddress @include(if: $includePrimaryAddress) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "      type\n"
      + "      companyName\n"
      + "      name\n"
      + "      street\n"
      + "      city\n"
      + "      state\n"
      + "      postcode\n"
      + "      region\n"
      + "      country\n"
      + "      latitude\n"
      + "      longitude\n"
      + "      timeZone\n"
      + "    }\n"
      + "    attributes @include(if: $includeAttributes) {\n"
      + "      __typename\n"
      + "      type\n"
      + "      name\n"
      + "      value\n"
      + "    }\n"
      + "    openingSchedule @include(if: $includeOpeningSchedule) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      createdOn\n"
      + "      updatedOn\n"
      + "      allHours\n"
      + "      monEnd\n"
      + "      monStart\n"
      + "      tueEnd\n"
      + "      tueStart\n"
      + "      wedEnd\n"
      + "      wedStart\n"
      + "      thuEnd\n"
      + "      thuStart\n"
      + "      friEnd\n"
      + "      friStart\n"
      + "      satEnd\n"
      + "      satStart\n"
      + "      sunEnd\n"
      + "      sunStart\n"
      + "    }\n"
      + "    retailer @include(if: $includeRetailer) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "    }\n"
      + "    networks @include(if: $includeNetworks) {\n"
      + "      __typename\n"
      + "      networkEdge: edges {\n"
      + "        __typename\n"
      + "        networkNode: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "          status\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "    storageAreas @include(if: $includeStorageAreas) {\n"
      + "      __typename\n"
      + "      storageEdge: edges {\n"
      + "        __typename\n"
      + "        storageNode: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          status\n"
      + "          type\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetLocationByRef";
    }
  };

  private final GetLocationByRefQuery.Variables variables;

  public GetLocationByRefQuery(@Nonnull String ref, boolean includePrimaryAddress,
      boolean includeAttributes, boolean includeOpeningSchedule, boolean includeRetailer,
      boolean includeNetworks, boolean includeStorageAreas) {
    Utils.checkNotNull(ref, "ref == null");
    variables = new GetLocationByRefQuery.Variables(ref, includePrimaryAddress, includeAttributes, includeOpeningSchedule, includeRetailer, includeNetworks, includeStorageAreas);
  }

  @Override
  public String operationId() {
    return "d20833b10ec9bfbd44622a8035ca5e70d5930c60db83dcbf7f317654a0840737";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetLocationByRefQuery.Data wrapData(GetLocationByRefQuery.Data data) {
    return data;
  }

  @Override
  public GetLocationByRefQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetLocationByRefQuery.Data> responseFieldMapper() {
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

    private boolean includePrimaryAddress;

    private boolean includeAttributes;

    private boolean includeOpeningSchedule;

    private boolean includeRetailer;

    private boolean includeNetworks;

    private boolean includeStorageAreas;

    Builder() {
    }

    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    public Builder includePrimaryAddress(boolean includePrimaryAddress) {
      this.includePrimaryAddress = includePrimaryAddress;
      return this;
    }

    public Builder includeAttributes(boolean includeAttributes) {
      this.includeAttributes = includeAttributes;
      return this;
    }

    public Builder includeOpeningSchedule(boolean includeOpeningSchedule) {
      this.includeOpeningSchedule = includeOpeningSchedule;
      return this;
    }

    public Builder includeRetailer(boolean includeRetailer) {
      this.includeRetailer = includeRetailer;
      return this;
    }

    public Builder includeNetworks(boolean includeNetworks) {
      this.includeNetworks = includeNetworks;
      return this;
    }

    public Builder includeStorageAreas(boolean includeStorageAreas) {
      this.includeStorageAreas = includeStorageAreas;
      return this;
    }

    public GetLocationByRefQuery build() {
      Utils.checkNotNull(ref, "ref == null");
      return new GetLocationByRefQuery(ref, includePrimaryAddress, includeAttributes, includeOpeningSchedule, includeRetailer, includeNetworks, includeStorageAreas);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String ref;

    private final boolean includePrimaryAddress;

    private final boolean includeAttributes;

    private final boolean includeOpeningSchedule;

    private final boolean includeRetailer;

    private final boolean includeNetworks;

    private final boolean includeStorageAreas;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String ref, boolean includePrimaryAddress, boolean includeAttributes,
        boolean includeOpeningSchedule, boolean includeRetailer, boolean includeNetworks,
        boolean includeStorageAreas) {
      this.ref = ref;
      this.includePrimaryAddress = includePrimaryAddress;
      this.includeAttributes = includeAttributes;
      this.includeOpeningSchedule = includeOpeningSchedule;
      this.includeRetailer = includeRetailer;
      this.includeNetworks = includeNetworks;
      this.includeStorageAreas = includeStorageAreas;
      this.valueMap.put("ref", ref);
      this.valueMap.put("includePrimaryAddress", includePrimaryAddress);
      this.valueMap.put("includeAttributes", includeAttributes);
      this.valueMap.put("includeOpeningSchedule", includeOpeningSchedule);
      this.valueMap.put("includeRetailer", includeRetailer);
      this.valueMap.put("includeNetworks", includeNetworks);
      this.valueMap.put("includeStorageAreas", includeStorageAreas);
    }

    public @Nonnull String ref() {
      return ref;
    }

    public boolean includePrimaryAddress() {
      return includePrimaryAddress;
    }

    public boolean includeAttributes() {
      return includeAttributes;
    }

    public boolean includeOpeningSchedule() {
      return includeOpeningSchedule;
    }

    public boolean includeRetailer() {
      return includeRetailer;
    }

    public boolean includeNetworks() {
      return includeNetworks;
    }

    public boolean includeStorageAreas() {
      return includeStorageAreas;
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
          writer.writeBoolean("includePrimaryAddress", includePrimaryAddress);
          writer.writeBoolean("includeAttributes", includeAttributes);
          writer.writeBoolean("includeOpeningSchedule", includeOpeningSchedule);
          writer.writeBoolean("includeRetailer", includeRetailer);
          writer.writeBoolean("includeNetworks", includeNetworks);
          writer.writeBoolean("includeStorageAreas", includeStorageAreas);
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
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("supportPhoneNumber", "supportPhoneNumber", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("defaultCarrier", "defaultCarrier", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("defaultCarrierName", "defaultCarrierName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("primaryAddress", "primaryAddress", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includePrimaryAddress", false))),
      ResponseField.forList("attributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeAttributes", false))),
      ResponseField.forObject("openingSchedule", "openingSchedule", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeOpeningSchedule", false))),
      ResponseField.forObject("retailer", "retailer", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeRetailer", false))),
      ResponseField.forObject("networks", "networks", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeNetworks", false))),
      ResponseField.forObject("storageAreas", "storageAreas", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeStorageAreas", false)))
    };

    final @Nonnull String __typename;

    final @Nullable String ref;

    final @Nonnull String id;

    final @Nullable String type;

    final @Nullable String status;

    final @Nullable String name;

    final @Nullable String supportPhoneNumber;

    final @Nullable String defaultCarrier;

    final @Nullable String defaultCarrierName;

    final @Nullable PrimaryAddress primaryAddress;

    final @Nullable List<Attribute> attributes;

    final @Nullable OpeningSchedule openingSchedule;

    final @Nullable Retailer retailer;

    final @Nullable Networks networks;

    final @Nullable StorageAreas storageAreas;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Location(@Nonnull String __typename, @Nullable String ref, @Nonnull String id,
        @Nullable String type, @Nullable String status, @Nullable String name,
        @Nullable String supportPhoneNumber, @Nullable String defaultCarrier,
        @Nullable String defaultCarrierName, @Nullable PrimaryAddress primaryAddress,
        @Nullable List<Attribute> attributes, @Nullable OpeningSchedule openingSchedule,
        @Nullable Retailer retailer, @Nullable Networks networks,
        @Nullable StorageAreas storageAreas) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = ref;
      this.id = Utils.checkNotNull(id, "id == null");
      this.type = type;
      this.status = status;
      this.name = name;
      this.supportPhoneNumber = supportPhoneNumber;
      this.defaultCarrier = defaultCarrier;
      this.defaultCarrierName = defaultCarrierName;
      this.primaryAddress = primaryAddress;
      this.attributes = attributes;
      this.openingSchedule = openingSchedule;
      this.retailer = retailer;
      this.networks = networks;
      this.storageAreas = storageAreas;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The location (i.e. store) id provided by the retailer
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
     *  Type
     */
    public @Nullable String type() {
      return this.type;
    }

    /**
     *  The location status. Possible values are 'ACTIVE', 'INACTIVE'.
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Name of location
     */
    public @Nullable String name() {
      return this.name;
    }

    /**
     *  The location contact number
     */
    public @Nullable String supportPhoneNumber() {
      return this.supportPhoneNumber;
    }

    /**
     *  Default carrier
     */
    public @Nullable String defaultCarrier() {
      return this.defaultCarrier;
    }

    /**
     *  Default carrier of the location
     */
    public @Nullable String defaultCarrierName() {
      return this.defaultCarrierName;
    }

    /**
     *  Store location of the the location
     */
    public @Nullable PrimaryAddress primaryAddress() {
      return this.primaryAddress;
    }

    /**
     *  Attributes
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    /**
     *  Opening Schedule
     */
    public @Nullable OpeningSchedule openingSchedule() {
      return this.openingSchedule;
    }

    /**
     *  Retailer
     */
    public @Nullable Retailer retailer() {
      return this.retailer;
    }

    /**
     *  Networks the location is assigned to
     */
    public @Nullable Networks networks() {
      return this.networks;
    }

    /**
     *  Storage areas at the location
     */
    public @Nullable StorageAreas storageAreas() {
      return this.storageAreas;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], id);
          writer.writeString($responseFields[3], type);
          writer.writeString($responseFields[4], status);
          writer.writeString($responseFields[5], name);
          writer.writeString($responseFields[6], supportPhoneNumber);
          writer.writeString($responseFields[7], defaultCarrier);
          writer.writeString($responseFields[8], defaultCarrierName);
          writer.writeObject($responseFields[9], primaryAddress != null ? primaryAddress.marshaller() : null);
          writer.writeList($responseFields[10], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeObject($responseFields[11], openingSchedule != null ? openingSchedule.marshaller() : null);
          writer.writeObject($responseFields[12], retailer != null ? retailer.marshaller() : null);
          writer.writeObject($responseFields[13], networks != null ? networks.marshaller() : null);
          writer.writeObject($responseFields[14], storageAreas != null ? storageAreas.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Location{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
          + "id=" + id + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "name=" + name + ", "
          + "supportPhoneNumber=" + supportPhoneNumber + ", "
          + "defaultCarrier=" + defaultCarrier + ", "
          + "defaultCarrierName=" + defaultCarrierName + ", "
          + "primaryAddress=" + primaryAddress + ", "
          + "attributes=" + attributes + ", "
          + "openingSchedule=" + openingSchedule + ", "
          + "retailer=" + retailer + ", "
          + "networks=" + networks + ", "
          + "storageAreas=" + storageAreas
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
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.id.equals(that.id)
         && ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.supportPhoneNumber == null) ? (that.supportPhoneNumber == null) : this.supportPhoneNumber.equals(that.supportPhoneNumber))
         && ((this.defaultCarrier == null) ? (that.defaultCarrier == null) : this.defaultCarrier.equals(that.defaultCarrier))
         && ((this.defaultCarrierName == null) ? (that.defaultCarrierName == null) : this.defaultCarrierName.equals(that.defaultCarrierName))
         && ((this.primaryAddress == null) ? (that.primaryAddress == null) : this.primaryAddress.equals(that.primaryAddress))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.openingSchedule == null) ? (that.openingSchedule == null) : this.openingSchedule.equals(that.openingSchedule))
         && ((this.retailer == null) ? (that.retailer == null) : this.retailer.equals(that.retailer))
         && ((this.networks == null) ? (that.networks == null) : this.networks.equals(that.networks))
         && ((this.storageAreas == null) ? (that.storageAreas == null) : this.storageAreas.equals(that.storageAreas));
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
        h ^= (type == null) ? 0 : type.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= (supportPhoneNumber == null) ? 0 : supportPhoneNumber.hashCode();
        h *= 1000003;
        h ^= (defaultCarrier == null) ? 0 : defaultCarrier.hashCode();
        h *= 1000003;
        h ^= (defaultCarrierName == null) ? 0 : defaultCarrierName.hashCode();
        h *= 1000003;
        h ^= (primaryAddress == null) ? 0 : primaryAddress.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (openingSchedule == null) ? 0 : openingSchedule.hashCode();
        h *= 1000003;
        h ^= (retailer == null) ? 0 : retailer.hashCode();
        h *= 1000003;
        h ^= (networks == null) ? 0 : networks.hashCode();
        h *= 1000003;
        h ^= (storageAreas == null) ? 0 : storageAreas.hashCode();
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
      builder.type = type;
      builder.status = status;
      builder.name = name;
      builder.supportPhoneNumber = supportPhoneNumber;
      builder.defaultCarrier = defaultCarrier;
      builder.defaultCarrierName = defaultCarrierName;
      builder.primaryAddress = primaryAddress;
      builder.attributes = attributes;
      builder.openingSchedule = openingSchedule;
      builder.retailer = retailer;
      builder.networks = networks;
      builder.storageAreas = storageAreas;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Location> {
      final PrimaryAddress.Mapper primaryAddressFieldMapper = new PrimaryAddress.Mapper();

      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final OpeningSchedule.Mapper openingScheduleFieldMapper = new OpeningSchedule.Mapper();

      final Retailer.Mapper retailerFieldMapper = new Retailer.Mapper();

      final Networks.Mapper networksFieldMapper = new Networks.Mapper();

      final StorageAreas.Mapper storageAreasFieldMapper = new StorageAreas.Mapper();

      @Override
      public Location map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final String name = reader.readString($responseFields[5]);
        final String supportPhoneNumber = reader.readString($responseFields[6]);
        final String defaultCarrier = reader.readString($responseFields[7]);
        final String defaultCarrierName = reader.readString($responseFields[8]);
        final PrimaryAddress primaryAddress = reader.readObject($responseFields[9], new ResponseReader.ObjectReader<PrimaryAddress>() {
          @Override
          public PrimaryAddress read(ResponseReader reader) {
            return primaryAddressFieldMapper.map(reader);
          }
        });
        final List<Attribute> attributes = reader.readList($responseFields[10], new ResponseReader.ListReader<Attribute>() {
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
        final OpeningSchedule openingSchedule = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<OpeningSchedule>() {
          @Override
          public OpeningSchedule read(ResponseReader reader) {
            return openingScheduleFieldMapper.map(reader);
          }
        });
        final Retailer retailer = reader.readObject($responseFields[12], new ResponseReader.ObjectReader<Retailer>() {
          @Override
          public Retailer read(ResponseReader reader) {
            return retailerFieldMapper.map(reader);
          }
        });
        final Networks networks = reader.readObject($responseFields[13], new ResponseReader.ObjectReader<Networks>() {
          @Override
          public Networks read(ResponseReader reader) {
            return networksFieldMapper.map(reader);
          }
        });
        final StorageAreas storageAreas = reader.readObject($responseFields[14], new ResponseReader.ObjectReader<StorageAreas>() {
          @Override
          public StorageAreas read(ResponseReader reader) {
            return storageAreasFieldMapper.map(reader);
          }
        });
        return new Location(__typename, ref, id, type, status, name, supportPhoneNumber, defaultCarrier, defaultCarrierName, primaryAddress, attributes, openingSchedule, retailer, networks, storageAreas);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String ref;

      private @Nonnull String id;

      private @Nullable String type;

      private @Nullable String status;

      private @Nullable String name;

      private @Nullable String supportPhoneNumber;

      private @Nullable String defaultCarrier;

      private @Nullable String defaultCarrierName;

      private @Nullable PrimaryAddress primaryAddress;

      private @Nullable List<Attribute> attributes;

      private @Nullable OpeningSchedule openingSchedule;

      private @Nullable Retailer retailer;

      private @Nullable Networks networks;

      private @Nullable StorageAreas storageAreas;

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

      public Builder type(@Nullable String type) {
        this.type = type;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder name(@Nullable String name) {
        this.name = name;
        return this;
      }

      public Builder supportPhoneNumber(@Nullable String supportPhoneNumber) {
        this.supportPhoneNumber = supportPhoneNumber;
        return this;
      }

      public Builder defaultCarrier(@Nullable String defaultCarrier) {
        this.defaultCarrier = defaultCarrier;
        return this;
      }

      public Builder defaultCarrierName(@Nullable String defaultCarrierName) {
        this.defaultCarrierName = defaultCarrierName;
        return this;
      }

      public Builder primaryAddress(@Nullable PrimaryAddress primaryAddress) {
        this.primaryAddress = primaryAddress;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder openingSchedule(@Nullable OpeningSchedule openingSchedule) {
        this.openingSchedule = openingSchedule;
        return this;
      }

      public Builder retailer(@Nullable Retailer retailer) {
        this.retailer = retailer;
        return this;
      }

      public Builder networks(@Nullable Networks networks) {
        this.networks = networks;
        return this;
      }

      public Builder storageAreas(@Nullable StorageAreas storageAreas) {
        this.storageAreas = storageAreas;
        return this;
      }

      public Builder primaryAddress(@Nonnull Mutator<PrimaryAddress.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PrimaryAddress.Builder builder = this.primaryAddress != null ? this.primaryAddress.toBuilder() : PrimaryAddress.builder();
        mutator.accept(builder);
        this.primaryAddress = builder.build();
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

      public Builder openingSchedule(@Nonnull Mutator<OpeningSchedule.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        OpeningSchedule.Builder builder = this.openingSchedule != null ? this.openingSchedule.toBuilder() : OpeningSchedule.builder();
        mutator.accept(builder);
        this.openingSchedule = builder.build();
        return this;
      }

      public Builder retailer(@Nonnull Mutator<Retailer.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Retailer.Builder builder = this.retailer != null ? this.retailer.toBuilder() : Retailer.builder();
        mutator.accept(builder);
        this.retailer = builder.build();
        return this;
      }

      public Builder networks(@Nonnull Mutator<Networks.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Networks.Builder builder = this.networks != null ? this.networks.toBuilder() : Networks.builder();
        mutator.accept(builder);
        this.networks = builder.build();
        return this;
      }

      public Builder storageAreas(@Nonnull Mutator<StorageAreas.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        StorageAreas.Builder builder = this.storageAreas != null ? this.storageAreas.toBuilder() : StorageAreas.builder();
        mutator.accept(builder);
        this.storageAreas = builder.build();
        return this;
      }

      public Location build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Location(__typename, ref, id, type, status, name, supportPhoneNumber, defaultCarrier, defaultCarrierName, primaryAddress, attributes, openingSchedule, retailer, networks, storageAreas);
      }
    }
  }

  public static class PrimaryAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("companyName", "companyName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("street", "street", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("city", "city", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("state", "state", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("postcode", "postcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("region", "region", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("latitude", "latitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("longitude", "longitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("timeZone", "timeZone", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String type;

    final @Nullable String companyName;

    final @Nullable String name;

    final @Nullable String street;

    final @Nullable String city;

    final @Nullable String state;

    final @Nullable String postcode;

    final @Nullable String region;

    final @Nullable String country;

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    final @Nullable String timeZone;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PrimaryAddress(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String type, @Nullable String companyName, @Nullable String name,
        @Nullable String street, @Nullable String city, @Nullable String state,
        @Nullable String postcode, @Nullable String region, @Nullable String country,
        @Nullable Double latitude, @Nullable Double longitude, @Nullable String timeZone) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = type;
      this.companyName = companyName;
      this.name = name;
      this.street = street;
      this.city = city;
      this.state = state;
      this.postcode = postcode;
      this.region = region;
      this.country = country;
      this.latitude = latitude;
      this.longitude = longitude;
      this.timeZone = timeZone;
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
     *  Location reference
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  Type of Address, to support legacy address, the value can be AGENT and ORDER
     */
    public @Nullable String type() {
      return this.type;
    }

    /**
     *  Company name
     */
    public @Nullable String companyName() {
      return this.companyName;
    }

    /**
     *  Name
     */
    public @Nullable String name() {
      return this.name;
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
     *  Region
     */
    public @Nullable String region() {
      return this.region;
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

    /**
     *  Timezone
     */
    public @Nullable String timeZone() {
      return this.timeZone;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], type);
          writer.writeString($responseFields[4], companyName);
          writer.writeString($responseFields[5], name);
          writer.writeString($responseFields[6], street);
          writer.writeString($responseFields[7], city);
          writer.writeString($responseFields[8], state);
          writer.writeString($responseFields[9], postcode);
          writer.writeString($responseFields[10], region);
          writer.writeString($responseFields[11], country);
          writer.writeDouble($responseFields[12], latitude);
          writer.writeDouble($responseFields[13], longitude);
          writer.writeString($responseFields[14], timeZone);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PrimaryAddress{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "companyName=" + companyName + ", "
          + "name=" + name + ", "
          + "street=" + street + ", "
          + "city=" + city + ", "
          + "state=" + state + ", "
          + "postcode=" + postcode + ", "
          + "region=" + region + ", "
          + "country=" + country + ", "
          + "latitude=" + latitude + ", "
          + "longitude=" + longitude + ", "
          + "timeZone=" + timeZone
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
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         && ((this.companyName == null) ? (that.companyName == null) : this.companyName.equals(that.companyName))
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.street == null) ? (that.street == null) : this.street.equals(that.street))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.state == null) ? (that.state == null) : this.state.equals(that.state))
         && ((this.postcode == null) ? (that.postcode == null) : this.postcode.equals(that.postcode))
         && ((this.region == null) ? (that.region == null) : this.region.equals(that.region))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
         && ((this.latitude == null) ? (that.latitude == null) : this.latitude.equals(that.latitude))
         && ((this.longitude == null) ? (that.longitude == null) : this.longitude.equals(that.longitude))
         && ((this.timeZone == null) ? (that.timeZone == null) : this.timeZone.equals(that.timeZone));
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
        h ^= (type == null) ? 0 : type.hashCode();
        h *= 1000003;
        h ^= (companyName == null) ? 0 : companyName.hashCode();
        h *= 1000003;
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= (street == null) ? 0 : street.hashCode();
        h *= 1000003;
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (state == null) ? 0 : state.hashCode();
        h *= 1000003;
        h ^= (postcode == null) ? 0 : postcode.hashCode();
        h *= 1000003;
        h ^= (region == null) ? 0 : region.hashCode();
        h *= 1000003;
        h ^= (country == null) ? 0 : country.hashCode();
        h *= 1000003;
        h ^= (latitude == null) ? 0 : latitude.hashCode();
        h *= 1000003;
        h ^= (longitude == null) ? 0 : longitude.hashCode();
        h *= 1000003;
        h ^= (timeZone == null) ? 0 : timeZone.hashCode();
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
      builder.companyName = companyName;
      builder.name = name;
      builder.street = street;
      builder.city = city;
      builder.state = state;
      builder.postcode = postcode;
      builder.region = region;
      builder.country = country;
      builder.latitude = latitude;
      builder.longitude = longitude;
      builder.timeZone = timeZone;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<PrimaryAddress> {
      @Override
      public PrimaryAddress map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String companyName = reader.readString($responseFields[4]);
        final String name = reader.readString($responseFields[5]);
        final String street = reader.readString($responseFields[6]);
        final String city = reader.readString($responseFields[7]);
        final String state = reader.readString($responseFields[8]);
        final String postcode = reader.readString($responseFields[9]);
        final String region = reader.readString($responseFields[10]);
        final String country = reader.readString($responseFields[11]);
        final Double latitude = reader.readDouble($responseFields[12]);
        final Double longitude = reader.readDouble($responseFields[13]);
        final String timeZone = reader.readString($responseFields[14]);
        return new PrimaryAddress(__typename, id, ref, type, companyName, name, street, city, state, postcode, region, country, latitude, longitude, timeZone);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String type;

      private @Nullable String companyName;

      private @Nullable String name;

      private @Nullable String street;

      private @Nullable String city;

      private @Nullable String state;

      private @Nullable String postcode;

      private @Nullable String region;

      private @Nullable String country;

      private @Nullable Double latitude;

      private @Nullable Double longitude;

      private @Nullable String timeZone;

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

      public Builder type(@Nullable String type) {
        this.type = type;
        return this;
      }

      public Builder companyName(@Nullable String companyName) {
        this.companyName = companyName;
        return this;
      }

      public Builder name(@Nullable String name) {
        this.name = name;
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

      public Builder region(@Nullable String region) {
        this.region = region;
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

      public Builder timeZone(@Nullable String timeZone) {
        this.timeZone = timeZone;
        return this;
      }

      public PrimaryAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new PrimaryAddress(__typename, id, ref, type, companyName, name, street, city, state, postcode, region, country, latitude, longitude, timeZone);
      }
    }
  }

  public static class Attribute {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("value", "value", null, false, CustomType.JSON, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String type;

    final @Nonnull String name;

    final @Nonnull Object value;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Attribute(@Nonnull String __typename, @Nonnull String type, @Nonnull String name,
        @Nonnull Object value) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.type = Utils.checkNotNull(type, "type == null");
      this.name = Utils.checkNotNull(name, "name == null");
      this.value = Utils.checkNotNull(value, "value == null");
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Type of the attribute's `value`. This is a free string and can be used by the client to interpret and cast the `value` into the appropriate type.
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  Name of the `attribute`
     */
    public @Nonnull String name() {
      return this.name;
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
          writer.writeString($responseFields[1], type);
          writer.writeString($responseFields[2], name);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[3], value);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Attribute{"
          + "__typename=" + __typename + ", "
          + "type=" + type + ", "
          + "name=" + name + ", "
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
         && this.type.equals(that.type)
         && this.name.equals(that.name)
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
        h ^= type.hashCode();
        h *= 1000003;
        h ^= name.hashCode();
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
      builder.type = type;
      builder.name = name;
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
        final String type = reader.readString($responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new Attribute(__typename, type, name, value);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String type;

      private @Nonnull String name;

      private @Nonnull Object value;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder name(@Nonnull String name) {
        this.name = name;
        return this;
      }

      public Builder value(@Nonnull Object value) {
        this.value = value;
        return this;
      }

      public Attribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(value, "value == null");
        return new Attribute(__typename, type, name, value);
      }
    }
  }

  public static class OpeningSchedule {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("allHours", "allHours", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("monEnd", "monEnd", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("monStart", "monStart", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("tueEnd", "tueEnd", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("tueStart", "tueStart", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("wedEnd", "wedEnd", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("wedStart", "wedStart", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("thuEnd", "thuEnd", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("thuStart", "thuStart", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("friEnd", "friEnd", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("friStart", "friStart", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("satEnd", "satEnd", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("satStart", "satStart", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("sunEnd", "sunEnd", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("sunStart", "sunStart", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final boolean allHours;

    final int monEnd;

    final int monStart;

    final int tueEnd;

    final int tueStart;

    final int wedEnd;

    final int wedStart;

    final int thuEnd;

    final int thuStart;

    final int friEnd;

    final int friStart;

    final int satEnd;

    final int satStart;

    final int sunEnd;

    final int sunStart;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OpeningSchedule(@Nonnull String __typename, @Nonnull String id,
        @Nullable Object createdOn, @Nullable Object updatedOn, boolean allHours, int monEnd,
        int monStart, int tueEnd, int tueStart, int wedEnd, int wedStart, int thuEnd, int thuStart,
        int friEnd, int friStart, int satEnd, int satStart, int sunEnd, int sunStart) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.allHours = allHours;
      this.monEnd = monEnd;
      this.monStart = monStart;
      this.tueEnd = tueEnd;
      this.tueStart = tueStart;
      this.wedEnd = wedEnd;
      this.wedStart = wedStart;
      this.thuEnd = thuEnd;
      this.thuStart = thuStart;
      this.friEnd = friEnd;
      this.friStart = friStart;
      this.satEnd = satEnd;
      this.satStart = satStart;
      this.sunEnd = sunEnd;
      this.sunStart = sunStart;
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
     *  Is the location open 24hrs
     */
    public boolean allHours() {
      return this.allHours;
    }

    /**
     *  Closing time on Monday (HHmm)
     */
    public int monEnd() {
      return this.monEnd;
    }

    /**
     *  Opening time on Monday (HHmm).
     */
    public int monStart() {
      return this.monStart;
    }

    /**
     *  Closing time on Tuesday (HHmm)
     */
    public int tueEnd() {
      return this.tueEnd;
    }

    /**
     *  Opening time on Tuesday (HHmm)
     */
    public int tueStart() {
      return this.tueStart;
    }

    /**
     *  Closing time on Wednesday (HHmm)
     */
    public int wedEnd() {
      return this.wedEnd;
    }

    /**
     *  Opening time on Wednesday (HHmm)
     */
    public int wedStart() {
      return this.wedStart;
    }

    /**
     *  Closing time on Thursday (HHmm)
     */
    public int thuEnd() {
      return this.thuEnd;
    }

    /**
     *  Opening time on Thursday (HHmm)
     */
    public int thuStart() {
      return this.thuStart;
    }

    /**
     *  Closing time on Friday (HHmm)
     */
    public int friEnd() {
      return this.friEnd;
    }

    /**
     *  Opening time on Friday (HHmm)
     */
    public int friStart() {
      return this.friStart;
    }

    /**
     *  Closing time on Saturday (HHmm)
     */
    public int satEnd() {
      return this.satEnd;
    }

    /**
     *  Opening time on Saturday (HHmm)
     */
    public int satStart() {
      return this.satStart;
    }

    /**
     *  Closing time on Sunday (HHmm)
     */
    public int sunEnd() {
      return this.sunEnd;
    }

    /**
     *  Opening time on Sunday (HHmm)
     */
    public int sunStart() {
      return this.sunStart;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], createdOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[3], updatedOn);
          writer.writeBoolean($responseFields[4], allHours);
          writer.writeInt($responseFields[5], monEnd);
          writer.writeInt($responseFields[6], monStart);
          writer.writeInt($responseFields[7], tueEnd);
          writer.writeInt($responseFields[8], tueStart);
          writer.writeInt($responseFields[9], wedEnd);
          writer.writeInt($responseFields[10], wedStart);
          writer.writeInt($responseFields[11], thuEnd);
          writer.writeInt($responseFields[12], thuStart);
          writer.writeInt($responseFields[13], friEnd);
          writer.writeInt($responseFields[14], friStart);
          writer.writeInt($responseFields[15], satEnd);
          writer.writeInt($responseFields[16], satStart);
          writer.writeInt($responseFields[17], sunEnd);
          writer.writeInt($responseFields[18], sunStart);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OpeningSchedule{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "allHours=" + allHours + ", "
          + "monEnd=" + monEnd + ", "
          + "monStart=" + monStart + ", "
          + "tueEnd=" + tueEnd + ", "
          + "tueStart=" + tueStart + ", "
          + "wedEnd=" + wedEnd + ", "
          + "wedStart=" + wedStart + ", "
          + "thuEnd=" + thuEnd + ", "
          + "thuStart=" + thuStart + ", "
          + "friEnd=" + friEnd + ", "
          + "friStart=" + friStart + ", "
          + "satEnd=" + satEnd + ", "
          + "satStart=" + satStart + ", "
          + "sunEnd=" + sunEnd + ", "
          + "sunStart=" + sunStart
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof OpeningSchedule) {
        OpeningSchedule that = (OpeningSchedule) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && this.allHours == that.allHours
         && this.monEnd == that.monEnd
         && this.monStart == that.monStart
         && this.tueEnd == that.tueEnd
         && this.tueStart == that.tueStart
         && this.wedEnd == that.wedEnd
         && this.wedStart == that.wedStart
         && this.thuEnd == that.thuEnd
         && this.thuStart == that.thuStart
         && this.friEnd == that.friEnd
         && this.friStart == that.friStart
         && this.satEnd == that.satEnd
         && this.satStart == that.satStart
         && this.sunEnd == that.sunEnd
         && this.sunStart == that.sunStart;
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
        h ^= (createdOn == null) ? 0 : createdOn.hashCode();
        h *= 1000003;
        h ^= (updatedOn == null) ? 0 : updatedOn.hashCode();
        h *= 1000003;
        h ^= Boolean.valueOf(allHours).hashCode();
        h *= 1000003;
        h ^= monEnd;
        h *= 1000003;
        h ^= monStart;
        h *= 1000003;
        h ^= tueEnd;
        h *= 1000003;
        h ^= tueStart;
        h *= 1000003;
        h ^= wedEnd;
        h *= 1000003;
        h ^= wedStart;
        h *= 1000003;
        h ^= thuEnd;
        h *= 1000003;
        h ^= thuStart;
        h *= 1000003;
        h ^= friEnd;
        h *= 1000003;
        h ^= friStart;
        h *= 1000003;
        h ^= satEnd;
        h *= 1000003;
        h ^= satStart;
        h *= 1000003;
        h ^= sunEnd;
        h *= 1000003;
        h ^= sunStart;
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      builder.createdOn = createdOn;
      builder.updatedOn = updatedOn;
      builder.allHours = allHours;
      builder.monEnd = monEnd;
      builder.monStart = monStart;
      builder.tueEnd = tueEnd;
      builder.tueStart = tueStart;
      builder.wedEnd = wedEnd;
      builder.wedStart = wedStart;
      builder.thuEnd = thuEnd;
      builder.thuStart = thuStart;
      builder.friEnd = friEnd;
      builder.friStart = friStart;
      builder.satEnd = satEnd;
      builder.satStart = satStart;
      builder.sunEnd = sunEnd;
      builder.sunStart = sunStart;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OpeningSchedule> {
      @Override
      public OpeningSchedule map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        final boolean allHours = reader.readBoolean($responseFields[4]);
        final int monEnd = reader.readInt($responseFields[5]);
        final int monStart = reader.readInt($responseFields[6]);
        final int tueEnd = reader.readInt($responseFields[7]);
        final int tueStart = reader.readInt($responseFields[8]);
        final int wedEnd = reader.readInt($responseFields[9]);
        final int wedStart = reader.readInt($responseFields[10]);
        final int thuEnd = reader.readInt($responseFields[11]);
        final int thuStart = reader.readInt($responseFields[12]);
        final int friEnd = reader.readInt($responseFields[13]);
        final int friStart = reader.readInt($responseFields[14]);
        final int satEnd = reader.readInt($responseFields[15]);
        final int satStart = reader.readInt($responseFields[16]);
        final int sunEnd = reader.readInt($responseFields[17]);
        final int sunStart = reader.readInt($responseFields[18]);
        return new OpeningSchedule(__typename, id, createdOn, updatedOn, allHours, monEnd, monStart, tueEnd, tueStart, wedEnd, wedStart, thuEnd, thuStart, friEnd, friStart, satEnd, satStart, sunEnd, sunStart);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

      private boolean allHours;

      private int monEnd;

      private int monStart;

      private int tueEnd;

      private int tueStart;

      private int wedEnd;

      private int wedStart;

      private int thuEnd;

      private int thuStart;

      private int friEnd;

      private int friStart;

      private int satEnd;

      private int satStart;

      private int sunEnd;

      private int sunStart;

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

      public Builder createdOn(@Nullable Object createdOn) {
        this.createdOn = createdOn;
        return this;
      }

      public Builder updatedOn(@Nullable Object updatedOn) {
        this.updatedOn = updatedOn;
        return this;
      }

      public Builder allHours(boolean allHours) {
        this.allHours = allHours;
        return this;
      }

      public Builder monEnd(int monEnd) {
        this.monEnd = monEnd;
        return this;
      }

      public Builder monStart(int monStart) {
        this.monStart = monStart;
        return this;
      }

      public Builder tueEnd(int tueEnd) {
        this.tueEnd = tueEnd;
        return this;
      }

      public Builder tueStart(int tueStart) {
        this.tueStart = tueStart;
        return this;
      }

      public Builder wedEnd(int wedEnd) {
        this.wedEnd = wedEnd;
        return this;
      }

      public Builder wedStart(int wedStart) {
        this.wedStart = wedStart;
        return this;
      }

      public Builder thuEnd(int thuEnd) {
        this.thuEnd = thuEnd;
        return this;
      }

      public Builder thuStart(int thuStart) {
        this.thuStart = thuStart;
        return this;
      }

      public Builder friEnd(int friEnd) {
        this.friEnd = friEnd;
        return this;
      }

      public Builder friStart(int friStart) {
        this.friStart = friStart;
        return this;
      }

      public Builder satEnd(int satEnd) {
        this.satEnd = satEnd;
        return this;
      }

      public Builder satStart(int satStart) {
        this.satStart = satStart;
        return this;
      }

      public Builder sunEnd(int sunEnd) {
        this.sunEnd = sunEnd;
        return this;
      }

      public Builder sunStart(int sunStart) {
        this.sunStart = sunStart;
        return this;
      }

      public OpeningSchedule build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new OpeningSchedule(__typename, id, createdOn, updatedOn, allHours, monEnd, monStart, tueEnd, tueStart, wedEnd, wedStart, thuEnd, thuStart, friEnd, friStart, satEnd, satStart, sunEnd, sunStart);
      }
    }
  }

  public static class Retailer {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String ref;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Retailer(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
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
     *  Reference for the retailer
     */
    public @Nonnull String ref() {
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
        $toString = "Retailer{"
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
      if (o instanceof Retailer) {
        Retailer that = (Retailer) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.ref.equals(that.ref);
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
        h ^= ref.hashCode();
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

    public static final class Mapper implements ResponseFieldMapper<Retailer> {
      @Override
      public Retailer map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        return new Retailer(__typename, id, ref);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String ref;

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

      public Builder ref(@Nonnull String ref) {
        this.ref = ref;
        return this;
      }

      public Retailer build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        return new Retailer(__typename, id, ref);
      }
    }
  }

  public static class Networks {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("networkEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<NetworkEdge> networkEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Networks(@Nonnull String __typename, @Nullable List<NetworkEdge> networkEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.networkEdge = networkEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Network type node
     */
    public @Nullable List<NetworkEdge> networkEdge() {
      return this.networkEdge;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], networkEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((NetworkEdge) value).marshaller());
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
          + "networkEdge=" + networkEdge
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
         && ((this.networkEdge == null) ? (that.networkEdge == null) : this.networkEdge.equals(that.networkEdge));
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
        h ^= (networkEdge == null) ? 0 : networkEdge.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.networkEdge = networkEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Networks> {
      final NetworkEdge.Mapper networkEdgeFieldMapper = new NetworkEdge.Mapper();

      @Override
      public Networks map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<NetworkEdge> networkEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<NetworkEdge>() {
          @Override
          public NetworkEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<NetworkEdge>() {
              @Override
              public NetworkEdge read(ResponseReader reader) {
                return networkEdgeFieldMapper.map(reader);
              }
            });
          }
        });
        return new Networks(__typename, networkEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<NetworkEdge> networkEdge;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder networkEdge(@Nullable List<NetworkEdge> networkEdge) {
        this.networkEdge = networkEdge;
        return this;
      }

      public Builder networkEdge(@Nonnull Mutator<List<NetworkEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<NetworkEdge.Builder> builders = new ArrayList<>();
        if (this.networkEdge != null) {
          for (NetworkEdge item : this.networkEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<NetworkEdge> networkEdge = new ArrayList<>();
        for (NetworkEdge.Builder item : builders) {
          networkEdge.add(item != null ? item.build() : null);
        }
        this.networkEdge = networkEdge;
        return this;
      }

      public Networks build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Networks(__typename, networkEdge);
      }
    }
  }

  public static class NetworkEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("networkNode", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable NetworkNode networkNode;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NetworkEdge(@Nonnull String __typename, @Nullable NetworkNode networkNode) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.networkNode = networkNode;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Network edge
     */
    public @Nullable NetworkNode networkNode() {
      return this.networkNode;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], networkNode != null ? networkNode.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NetworkEdge{"
          + "__typename=" + __typename + ", "
          + "networkNode=" + networkNode
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NetworkEdge) {
        NetworkEdge that = (NetworkEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.networkNode == null) ? (that.networkNode == null) : this.networkNode.equals(that.networkNode));
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
        h ^= (networkNode == null) ? 0 : networkNode.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.networkNode = networkNode;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<NetworkEdge> {
      final NetworkNode.Mapper networkNodeFieldMapper = new NetworkNode.Mapper();

      @Override
      public NetworkEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final NetworkNode networkNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<NetworkNode>() {
          @Override
          public NetworkNode read(ResponseReader reader) {
            return networkNodeFieldMapper.map(reader);
          }
        });
        return new NetworkEdge(__typename, networkNode);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable NetworkNode networkNode;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder networkNode(@Nullable NetworkNode networkNode) {
        this.networkNode = networkNode;
        return this;
      }

      public Builder networkNode(@Nonnull Mutator<NetworkNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        NetworkNode.Builder builder = this.networkNode != null ? this.networkNode.toBuilder() : NetworkNode.builder();
        mutator.accept(builder);
        this.networkNode = builder.build();
        return this;
      }

      public NetworkEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new NetworkEdge(__typename, networkNode);
      }
    }
  }

  public static class NetworkNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NetworkNode(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
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
     *  Reference to the network. This is the name of the network you passed in while creating the network. Recommended to be unique.
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  Status of the network
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
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NetworkNode{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
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
      if (o instanceof NetworkNode) {
        NetworkNode that = (NetworkNode) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
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
        h ^= (ref == null) ? 0 : ref.hashCode();
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
      builder.ref = ref;
      builder.status = status;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<NetworkNode> {
      @Override
      public NetworkNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        return new NetworkNode(__typename, id, ref, status);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

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

      public Builder ref(@Nullable String ref) {
        this.ref = ref;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public NetworkNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new NetworkNode(__typename, id, ref, status);
      }
    }
  }

  public static class StorageAreas {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("storageEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<StorageEdge> storageEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public StorageAreas(@Nonnull String __typename, @Nullable List<StorageEdge> storageEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.storageEdge = storageEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to StorageArea type node
     */
    public @Nullable List<StorageEdge> storageEdge() {
      return this.storageEdge;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], storageEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((StorageEdge) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "StorageAreas{"
          + "__typename=" + __typename + ", "
          + "storageEdge=" + storageEdge
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof StorageAreas) {
        StorageAreas that = (StorageAreas) o;
        return this.__typename.equals(that.__typename)
         && ((this.storageEdge == null) ? (that.storageEdge == null) : this.storageEdge.equals(that.storageEdge));
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
        h ^= (storageEdge == null) ? 0 : storageEdge.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.storageEdge = storageEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<StorageAreas> {
      final StorageEdge.Mapper storageEdgeFieldMapper = new StorageEdge.Mapper();

      @Override
      public StorageAreas map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<StorageEdge> storageEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<StorageEdge>() {
          @Override
          public StorageEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<StorageEdge>() {
              @Override
              public StorageEdge read(ResponseReader reader) {
                return storageEdgeFieldMapper.map(reader);
              }
            });
          }
        });
        return new StorageAreas(__typename, storageEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<StorageEdge> storageEdge;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder storageEdge(@Nullable List<StorageEdge> storageEdge) {
        this.storageEdge = storageEdge;
        return this;
      }

      public Builder storageEdge(@Nonnull Mutator<List<StorageEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<StorageEdge.Builder> builders = new ArrayList<>();
        if (this.storageEdge != null) {
          for (StorageEdge item : this.storageEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<StorageEdge> storageEdge = new ArrayList<>();
        for (StorageEdge.Builder item : builders) {
          storageEdge.add(item != null ? item.build() : null);
        }
        this.storageEdge = storageEdge;
        return this;
      }

      public StorageAreas build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new StorageAreas(__typename, storageEdge);
      }
    }
  }

  public static class StorageEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("storageNode", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable StorageNode storageNode;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public StorageEdge(@Nonnull String __typename, @Nullable StorageNode storageNode) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.storageNode = storageNode;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the StorageArea edge
     */
    public @Nullable StorageNode storageNode() {
      return this.storageNode;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], storageNode != null ? storageNode.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "StorageEdge{"
          + "__typename=" + __typename + ", "
          + "storageNode=" + storageNode
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof StorageEdge) {
        StorageEdge that = (StorageEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.storageNode == null) ? (that.storageNode == null) : this.storageNode.equals(that.storageNode));
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
        h ^= (storageNode == null) ? 0 : storageNode.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.storageNode = storageNode;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<StorageEdge> {
      final StorageNode.Mapper storageNodeFieldMapper = new StorageNode.Mapper();

      @Override
      public StorageEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final StorageNode storageNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<StorageNode>() {
          @Override
          public StorageNode read(ResponseReader reader) {
            return storageNodeFieldMapper.map(reader);
          }
        });
        return new StorageEdge(__typename, storageNode);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable StorageNode storageNode;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder storageNode(@Nullable StorageNode storageNode) {
        this.storageNode = storageNode;
        return this;
      }

      public Builder storageNode(@Nonnull Mutator<StorageNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        StorageNode.Builder builder = this.storageNode != null ? this.storageNode.toBuilder() : StorageNode.builder();
        mutator.accept(builder);
        this.storageNode = builder.build();
        return this;
      }

      public StorageEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new StorageEdge(__typename, storageNode);
      }
    }
  }

  public static class StorageNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String status;

    final @Nullable String type;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public StorageNode(@Nonnull String __typename, @Nonnull String id, @Nullable String status,
        @Nullable String type) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.status = status;
      this.type = type;
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
     *  Status
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], status);
          writer.writeString($responseFields[3], type);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "StorageNode{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "status=" + status + ", "
          + "type=" + type
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof StorageNode) {
        StorageNode that = (StorageNode) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.type == null) ? (that.type == null) : this.type.equals(that.type));
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
        h ^= (type == null) ? 0 : type.hashCode();
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
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<StorageNode> {
      @Override
      public StorageNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String status = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        return new StorageNode(__typename, id, status, type);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String status;

      private @Nullable String type;

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

      public Builder type(@Nullable String type) {
        this.type = type;
        return this;
      }

      public StorageNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new StorageNode(__typename, id, status, type);
      }
    }
  }
}
