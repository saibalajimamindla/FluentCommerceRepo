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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class GetLocationByIdQuery implements Query<GetLocationByIdQuery.Data, GetLocationByIdQuery.Data, GetLocationByIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetLocationById($id: ID!) {\n"
      + "  locationById(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    type\n"
      + "    status\n"
      + "    attributes {\n"
      + "      __typename\n"
      + "      name\n"
      + "      type\n"
      + "      value\n"
      + "    }\n"
      + "    name\n"
      + "    supportPhoneNumber\n"
      + "    defaultCarrier\n"
      + "    defaultCarrierName\n"
      + "    primaryAddress {\n"
      + "      __typename\n"
      + "      id\n"
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
      + "      longitude\n"
      + "      ref\n"
      + "      timeZone\n"
      + "    }\n"
      + "    retailer {\n"
      + "      __typename\n"
      + "      id\n"
      + "      status\n"
      + "      ref\n"
      + "      summary\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetLocationById";
    }
  };

  private final GetLocationByIdQuery.Variables variables;

  public GetLocationByIdQuery(@Nonnull String id) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetLocationByIdQuery.Variables(id);
  }

  @Override
  public String operationId() {
    return "a066038b6f215e2c3f96635a657d0824e55fbb2246ade3aa56cedb02122f7b1d";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetLocationByIdQuery.Data wrapData(GetLocationByIdQuery.Data data) {
    return data;
  }

  @Override
  public GetLocationByIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetLocationByIdQuery.Data> responseFieldMapper() {
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

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public GetLocationByIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetLocationByIdQuery(id);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id) {
      this.id = id;
      this.valueMap.put("id", id);
    }

    public @Nonnull String id() {
      return id;
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
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("locationById", "locationById", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable LocationById locationById;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable LocationById locationById) {
      this.locationById = locationById;
    }

    /**
     *  Find a Location entity
     */
    public @Nullable LocationById locationById() {
      return this.locationById;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], locationById != null ? locationById.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "locationById=" + locationById
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
        return ((this.locationById == null) ? (that.locationById == null) : this.locationById.equals(that.locationById));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (locationById == null) ? 0 : locationById.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.locationById = locationById;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final LocationById.Mapper locationByIdFieldMapper = new LocationById.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final LocationById locationById = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<LocationById>() {
          @Override
          public LocationById read(ResponseReader reader) {
            return locationByIdFieldMapper.map(reader);
          }
        });
        return new Data(locationById);
      }
    }

    public static final class Builder {
      private @Nullable LocationById locationById;

      Builder() {
      }

      public Builder locationById(@Nullable LocationById locationById) {
        this.locationById = locationById;
        return this;
      }

      public Builder locationById(@Nonnull Mutator<LocationById.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        LocationById.Builder builder = this.locationById != null ? this.locationById.toBuilder() : LocationById.builder();
        mutator.accept(builder);
        this.locationById = builder.build();
        return this;
      }

      public Data build() {
        return new Data(locationById);
      }
    }
  }

  public static class LocationById {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("supportPhoneNumber", "supportPhoneNumber", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("defaultCarrier", "defaultCarrier", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("defaultCarrierName", "defaultCarrierName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("primaryAddress", "primaryAddress", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("retailer", "retailer", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String type;

    final @Nullable String status;

    final @Nullable List<Attribute> attributes;

    final @Nullable String name;

    final @Nullable String supportPhoneNumber;

    final @Nullable String defaultCarrier;

    final @Nullable String defaultCarrierName;

    final @Nullable PrimaryAddress primaryAddress;

    final @Nullable Retailer retailer;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public LocationById(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String type, @Nullable String status, @Nullable List<Attribute> attributes,
        @Nullable String name, @Nullable String supportPhoneNumber, @Nullable String defaultCarrier,
        @Nullable String defaultCarrierName, @Nullable PrimaryAddress primaryAddress,
        @Nullable Retailer retailer) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = type;
      this.status = status;
      this.attributes = attributes;
      this.name = name;
      this.supportPhoneNumber = supportPhoneNumber;
      this.defaultCarrier = defaultCarrier;
      this.defaultCarrierName = defaultCarrierName;
      this.primaryAddress = primaryAddress;
      this.retailer = retailer;
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
     *  Attributes
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
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
     *  Retailer
     */
    public @Nullable Retailer retailer() {
      return this.retailer;
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
          writer.writeList($responseFields[5], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeString($responseFields[6], name);
          writer.writeString($responseFields[7], supportPhoneNumber);
          writer.writeString($responseFields[8], defaultCarrier);
          writer.writeString($responseFields[9], defaultCarrierName);
          writer.writeObject($responseFields[10], primaryAddress != null ? primaryAddress.marshaller() : null);
          writer.writeObject($responseFields[11], retailer != null ? retailer.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "LocationById{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "attributes=" + attributes + ", "
          + "name=" + name + ", "
          + "supportPhoneNumber=" + supportPhoneNumber + ", "
          + "defaultCarrier=" + defaultCarrier + ", "
          + "defaultCarrierName=" + defaultCarrierName + ", "
          + "primaryAddress=" + primaryAddress + ", "
          + "retailer=" + retailer
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof LocationById) {
        LocationById that = (LocationById) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.supportPhoneNumber == null) ? (that.supportPhoneNumber == null) : this.supportPhoneNumber.equals(that.supportPhoneNumber))
         && ((this.defaultCarrier == null) ? (that.defaultCarrier == null) : this.defaultCarrier.equals(that.defaultCarrier))
         && ((this.defaultCarrierName == null) ? (that.defaultCarrierName == null) : this.defaultCarrierName.equals(that.defaultCarrierName))
         && ((this.primaryAddress == null) ? (that.primaryAddress == null) : this.primaryAddress.equals(that.primaryAddress))
         && ((this.retailer == null) ? (that.retailer == null) : this.retailer.equals(that.retailer));
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
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
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
        h ^= (retailer == null) ? 0 : retailer.hashCode();
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
      builder.attributes = attributes;
      builder.name = name;
      builder.supportPhoneNumber = supportPhoneNumber;
      builder.defaultCarrier = defaultCarrier;
      builder.defaultCarrierName = defaultCarrierName;
      builder.primaryAddress = primaryAddress;
      builder.retailer = retailer;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<LocationById> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final PrimaryAddress.Mapper primaryAddressFieldMapper = new PrimaryAddress.Mapper();

      final Retailer.Mapper retailerFieldMapper = new Retailer.Mapper();

      @Override
      public LocationById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final List<Attribute> attributes = reader.readList($responseFields[5], new ResponseReader.ListReader<Attribute>() {
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
        final String name = reader.readString($responseFields[6]);
        final String supportPhoneNumber = reader.readString($responseFields[7]);
        final String defaultCarrier = reader.readString($responseFields[8]);
        final String defaultCarrierName = reader.readString($responseFields[9]);
        final PrimaryAddress primaryAddress = reader.readObject($responseFields[10], new ResponseReader.ObjectReader<PrimaryAddress>() {
          @Override
          public PrimaryAddress read(ResponseReader reader) {
            return primaryAddressFieldMapper.map(reader);
          }
        });
        final Retailer retailer = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<Retailer>() {
          @Override
          public Retailer read(ResponseReader reader) {
            return retailerFieldMapper.map(reader);
          }
        });
        return new LocationById(__typename, id, ref, type, status, attributes, name, supportPhoneNumber, defaultCarrier, defaultCarrierName, primaryAddress, retailer);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String type;

      private @Nullable String status;

      private @Nullable List<Attribute> attributes;

      private @Nullable String name;

      private @Nullable String supportPhoneNumber;

      private @Nullable String defaultCarrier;

      private @Nullable String defaultCarrierName;

      private @Nullable PrimaryAddress primaryAddress;

      private @Nullable Retailer retailer;

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

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
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

      public Builder retailer(@Nullable Retailer retailer) {
        this.retailer = retailer;
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

      public Builder primaryAddress(@Nonnull Mutator<PrimaryAddress.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PrimaryAddress.Builder builder = this.primaryAddress != null ? this.primaryAddress.toBuilder() : PrimaryAddress.builder();
        mutator.accept(builder);
        this.primaryAddress = builder.build();
        return this;
      }

      public Builder retailer(@Nonnull Mutator<Retailer.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Retailer.Builder builder = this.retailer != null ? this.retailer.toBuilder() : Retailer.builder();
        mutator.accept(builder);
        this.retailer = builder.build();
        return this;
      }

      public LocationById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new LocationById(__typename, id, ref, type, status, attributes, name, supportPhoneNumber, defaultCarrier, defaultCarrierName, primaryAddress, retailer);
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

  public static class PrimaryAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
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
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("timeZone", "timeZone", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

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

    final @Nullable String ref;

    final @Nullable String timeZone;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PrimaryAddress(@Nonnull String __typename, @Nonnull String id, @Nullable String type,
        @Nullable String companyName, @Nullable String name, @Nullable String street,
        @Nullable String city, @Nullable String state, @Nullable String postcode,
        @Nullable String region, @Nullable String country, @Nullable Double latitude,
        @Nullable Double longitude, @Nullable String ref, @Nullable String timeZone) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
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
      this.ref = ref;
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
     *  Location reference
     */
    public @Nullable String ref() {
      return this.ref;
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
          writer.writeString($responseFields[2], type);
          writer.writeString($responseFields[3], companyName);
          writer.writeString($responseFields[4], name);
          writer.writeString($responseFields[5], street);
          writer.writeString($responseFields[6], city);
          writer.writeString($responseFields[7], state);
          writer.writeString($responseFields[8], postcode);
          writer.writeString($responseFields[9], region);
          writer.writeString($responseFields[10], country);
          writer.writeDouble($responseFields[11], latitude);
          writer.writeDouble($responseFields[12], longitude);
          writer.writeString($responseFields[13], ref);
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
          + "ref=" + ref + ", "
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
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
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
        h ^= (ref == null) ? 0 : ref.hashCode();
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
      builder.ref = ref;
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
        final String type = reader.readString($responseFields[2]);
        final String companyName = reader.readString($responseFields[3]);
        final String name = reader.readString($responseFields[4]);
        final String street = reader.readString($responseFields[5]);
        final String city = reader.readString($responseFields[6]);
        final String state = reader.readString($responseFields[7]);
        final String postcode = reader.readString($responseFields[8]);
        final String region = reader.readString($responseFields[9]);
        final String country = reader.readString($responseFields[10]);
        final Double latitude = reader.readDouble($responseFields[11]);
        final Double longitude = reader.readDouble($responseFields[12]);
        final String ref = reader.readString($responseFields[13]);
        final String timeZone = reader.readString($responseFields[14]);
        return new PrimaryAddress(__typename, id, type, companyName, name, street, city, state, postcode, region, country, latitude, longitude, ref, timeZone);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

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

      private @Nullable String ref;

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

      public Builder ref(@Nullable String ref) {
        this.ref = ref;
        return this;
      }

      public Builder timeZone(@Nullable String timeZone) {
        this.timeZone = timeZone;
        return this;
      }

      public PrimaryAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new PrimaryAddress(__typename, id, type, companyName, name, street, city, state, postcode, region, country, latitude, longitude, ref, timeZone);
      }
    }
  }

  public static class Retailer {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("summary", "summary", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String status;

    final @Nonnull String ref;

    final @Nullable String summary;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Retailer(@Nonnull String __typename, @Nonnull String id, @Nullable String status,
        @Nonnull String ref, @Nullable String summary) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.status = status;
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.summary = summary;
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
     *  Status of the retailer
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Reference for the retailer
     */
    public @Nonnull String ref() {
      return this.ref;
    }

    /**
     *  Short description of the retailer
     */
    public @Nullable String summary() {
      return this.summary;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], status);
          writer.writeString($responseFields[3], ref);
          writer.writeString($responseFields[4], summary);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Retailer{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "status=" + status + ", "
          + "ref=" + ref + ", "
          + "summary=" + summary
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
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.ref.equals(that.ref)
         && ((this.summary == null) ? (that.summary == null) : this.summary.equals(that.summary));
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
        h ^= ref.hashCode();
        h *= 1000003;
        h ^= (summary == null) ? 0 : summary.hashCode();
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
      builder.ref = ref;
      builder.summary = summary;
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
        final String status = reader.readString($responseFields[2]);
        final String ref = reader.readString($responseFields[3]);
        final String summary = reader.readString($responseFields[4]);
        return new Retailer(__typename, id, status, ref, summary);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String status;

      private @Nonnull String ref;

      private @Nullable String summary;

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

      public Builder ref(@Nonnull String ref) {
        this.ref = ref;
        return this;
      }

      public Builder summary(@Nullable String summary) {
        this.summary = summary;
        return this;
      }

      public Retailer build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        return new Retailer(__typename, id, status, ref, summary);
      }
    }
  }
}
