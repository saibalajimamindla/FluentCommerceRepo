package com.fluentcommerce.commonv2.graphql.query.fulfilmentOption;

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
import java.lang.Integer;
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
public final class GetFulfilmentOptionByIdQuery implements Query<GetFulfilmentOptionByIdQuery.Data, GetFulfilmentOptionByIdQuery.Data, GetFulfilmentOptionByIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetFulfilmentOptionById($id: ID!, $includeAttributes: Boolean!, $includeAddress: Boolean!, $includeProducts: Boolean!, $includePlans: Boolean!, $plansCount: Int, $plansCursor: String) {\n"
      + "  fulfilmentOptionById(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    type\n"
      + "    status\n"
      + "    createdOn\n"
      + "    updatedOn\n"
      + "    retailerId\n"
      + "    orderType\n"
      + "    locationRef\n"
      + "    trackingCode\n"
      + "    attributes @include(if: $includeAttributes) {\n"
      + "      __typename\n"
      + "      name\n"
      + "      type\n"
      + "      value\n"
      + "    }\n"
      + "    address @include(if: $includeAddress) {\n"
      + "      __typename\n"
      + "      name\n"
      + "      companyName\n"
      + "      addressLine1\n"
      + "      addressLine2\n"
      + "      city\n"
      + "      state\n"
      + "      postcode\n"
      + "      country\n"
      + "      longitude\n"
      + "      latitude\n"
      + "    }\n"
      + "    products @include(if: $includeProducts) {\n"
      + "      __typename\n"
      + "      productRef\n"
      + "      catalogueRef\n"
      + "      requestedQuantity\n"
      + "    }\n"
      + "    plans(first: $plansCount, after: $plansCursor) @include(if: $includePlans) {\n"
      + "      __typename\n"
      + "      plansEdge: edges {\n"
      + "        __typename\n"
      + "        plan: node {\n"
      + "          __typename\n"
      + "          type\n"
      + "          id\n"
      + "          status\n"
      + "          fulfilments {\n"
      + "            __typename\n"
      + "            fulfilmentType\n"
      + "            locationRef\n"
      + "            items {\n"
      + "              __typename\n"
      + "              productRef\n"
      + "              catalogueRef\n"
      + "              availableQuantity\n"
      + "              requestedQuantity\n"
      + "            }\n"
      + "          }\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetFulfilmentOptionById";
    }
  };

  private final GetFulfilmentOptionByIdQuery.Variables variables;

  public GetFulfilmentOptionByIdQuery(@Nonnull String id, boolean includeAttributes,
      boolean includeAddress, boolean includeProducts, boolean includePlans,
      @Nullable Integer plansCount, @Nullable String plansCursor) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetFulfilmentOptionByIdQuery.Variables(id, includeAttributes, includeAddress, includeProducts, includePlans, plansCount, plansCursor);
  }

  @Override
  public String operationId() {
    return "aa6d0556fce3129439018b2229e9e71fbca4675d4aba81b6bc4aecea35def7a6";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetFulfilmentOptionByIdQuery.Data wrapData(GetFulfilmentOptionByIdQuery.Data data) {
    return data;
  }

  @Override
  public GetFulfilmentOptionByIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetFulfilmentOptionByIdQuery.Data> responseFieldMapper() {
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

    private boolean includeAttributes;

    private boolean includeAddress;

    private boolean includeProducts;

    private boolean includePlans;

    private @Nullable Integer plansCount;

    private @Nullable String plansCursor;

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public Builder includeAttributes(boolean includeAttributes) {
      this.includeAttributes = includeAttributes;
      return this;
    }

    public Builder includeAddress(boolean includeAddress) {
      this.includeAddress = includeAddress;
      return this;
    }

    public Builder includeProducts(boolean includeProducts) {
      this.includeProducts = includeProducts;
      return this;
    }

    public Builder includePlans(boolean includePlans) {
      this.includePlans = includePlans;
      return this;
    }

    public Builder plansCount(@Nullable Integer plansCount) {
      this.plansCount = plansCount;
      return this;
    }

    public Builder plansCursor(@Nullable String plansCursor) {
      this.plansCursor = plansCursor;
      return this;
    }

    public GetFulfilmentOptionByIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetFulfilmentOptionByIdQuery(id, includeAttributes, includeAddress, includeProducts, includePlans, plansCount, plansCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final boolean includeAttributes;

    private final boolean includeAddress;

    private final boolean includeProducts;

    private final boolean includePlans;

    private final @Nullable Integer plansCount;

    private final @Nullable String plansCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, boolean includeAttributes, boolean includeAddress,
        boolean includeProducts, boolean includePlans, @Nullable Integer plansCount,
        @Nullable String plansCursor) {
      this.id = id;
      this.includeAttributes = includeAttributes;
      this.includeAddress = includeAddress;
      this.includeProducts = includeProducts;
      this.includePlans = includePlans;
      this.plansCount = plansCount;
      this.plansCursor = plansCursor;
      this.valueMap.put("id", id);
      this.valueMap.put("includeAttributes", includeAttributes);
      this.valueMap.put("includeAddress", includeAddress);
      this.valueMap.put("includeProducts", includeProducts);
      this.valueMap.put("includePlans", includePlans);
      this.valueMap.put("plansCount", plansCount);
      this.valueMap.put("plansCursor", plansCursor);
    }

    public @Nonnull String id() {
      return id;
    }

    public boolean includeAttributes() {
      return includeAttributes;
    }

    public boolean includeAddress() {
      return includeAddress;
    }

    public boolean includeProducts() {
      return includeProducts;
    }

    public boolean includePlans() {
      return includePlans;
    }

    public @Nullable Integer plansCount() {
      return plansCount;
    }

    public @Nullable String plansCursor() {
      return plansCursor;
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
          writer.writeBoolean("includeAttributes", includeAttributes);
          writer.writeBoolean("includeAddress", includeAddress);
          writer.writeBoolean("includeProducts", includeProducts);
          writer.writeBoolean("includePlans", includePlans);
          writer.writeInt("plansCount", plansCount);
          writer.writeString("plansCursor", plansCursor);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("fulfilmentOptionById", "fulfilmentOptionById", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable FulfilmentOptionById fulfilmentOptionById;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable FulfilmentOptionById fulfilmentOptionById) {
      this.fulfilmentOptionById = fulfilmentOptionById;
    }

    /**
     *  Find a FulfilmentOption entity
     */
    public @Nullable FulfilmentOptionById fulfilmentOptionById() {
      return this.fulfilmentOptionById;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], fulfilmentOptionById != null ? fulfilmentOptionById.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "fulfilmentOptionById=" + fulfilmentOptionById
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
        return ((this.fulfilmentOptionById == null) ? (that.fulfilmentOptionById == null) : this.fulfilmentOptionById.equals(that.fulfilmentOptionById));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (fulfilmentOptionById == null) ? 0 : fulfilmentOptionById.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.fulfilmentOptionById = fulfilmentOptionById;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final FulfilmentOptionById.Mapper fulfilmentOptionByIdFieldMapper = new FulfilmentOptionById.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final FulfilmentOptionById fulfilmentOptionById = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<FulfilmentOptionById>() {
          @Override
          public FulfilmentOptionById read(ResponseReader reader) {
            return fulfilmentOptionByIdFieldMapper.map(reader);
          }
        });
        return new Data(fulfilmentOptionById);
      }
    }

    public static final class Builder {
      private @Nullable FulfilmentOptionById fulfilmentOptionById;

      Builder() {
      }

      public Builder fulfilmentOptionById(@Nullable FulfilmentOptionById fulfilmentOptionById) {
        this.fulfilmentOptionById = fulfilmentOptionById;
        return this;
      }

      public Builder fulfilmentOptionById(@Nonnull Mutator<FulfilmentOptionById.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentOptionById.Builder builder = this.fulfilmentOptionById != null ? this.fulfilmentOptionById.toBuilder() : FulfilmentOptionById.builder();
        mutator.accept(builder);
        this.fulfilmentOptionById = builder.build();
        return this;
      }

      public Data build() {
        return new Data(fulfilmentOptionById);
      }
    }
  }

  public static class FulfilmentOptionById {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("retailerId", "retailerId", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("orderType", "orderType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("locationRef", "locationRef", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("trackingCode", "trackingCode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeAttributes", false))),
      ResponseField.forObject("address", "address", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeAddress", false))),
      ResponseField.forList("products", "products", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeProducts", false))),
      ResponseField.forObject("plans", "plans", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "plansCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "plansCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includePlans", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final int retailerId;

    final @Nullable String orderType;

    final @Nullable String locationRef;

    final @Nullable String trackingCode;

    final @Nullable List<Attribute> attributes;

    final @Nullable Address address;

    final @Nullable List<Product> products;

    final @Nullable Plans plans;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentOptionById(@Nonnull String __typename, @Nonnull String id,
        @Nullable String ref, @Nonnull String type, @Nullable String status,
        @Nullable Object createdOn, @Nullable Object updatedOn, int retailerId,
        @Nullable String orderType, @Nullable String locationRef, @Nullable String trackingCode,
        @Nullable List<Attribute> attributes, @Nullable Address address,
        @Nullable List<Product> products, @Nullable Plans plans) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.retailerId = retailerId;
      this.orderType = orderType;
      this.locationRef = locationRef;
      this.trackingCode = trackingCode;
      this.attributes = attributes;
      this.address = address;
      this.products = products;
      this.plans = plans;
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
     *  External reference. Recommended to be unique.
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  Type of the `FulfilmentOption`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  The current status of the `FulfilmentOption`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
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
     *  ID of the `Retailer`, typically used by the Orchestration Engine to determine the workflow that should be applied.
     */
    public int retailerId() {
      return this.retailerId;
    }

    /**
     *  Type of order. For example _click & collect (CC)_ or _home delivery (HD)_
     */
    public @Nullable String orderType() {
      return this.orderType;
    }

    /**
     *  The reference identifier for a location. May be used in orchestration rules to drive custom business logic. For example, you can have a rule to return plans only from this
     *   location or a rule to return plans from all locations but excluding this one.
     */
    public @Nullable String locationRef() {
      return this.locationRef;
    }

    /**
     *  A unique identifier for the clients to group related Fulfilment Plans.
     */
    public @Nullable String trackingCode() {
      return this.trackingCode;
    }

    /**
     *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    /**
     *  A type for passing address. Can be used as an input in creating Fulfilment Plans.
     */
    public @Nullable Address address() {
      return this.address;
    }

    /**
     *  Products being queried for availability
     */
    public @Nullable List<Product> products() {
      return this.products;
    }

    /**
     *  A list of `FulfilmentPlan` objects.
     */
    public @Nullable Plans plans() {
      return this.plans;
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
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[5], createdOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[6], updatedOn);
          writer.writeInt($responseFields[7], retailerId);
          writer.writeString($responseFields[8], orderType);
          writer.writeString($responseFields[9], locationRef);
          writer.writeString($responseFields[10], trackingCode);
          writer.writeList($responseFields[11], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeObject($responseFields[12], address != null ? address.marshaller() : null);
          writer.writeList($responseFields[13], products, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Product) value).marshaller());
            }
          });
          writer.writeObject($responseFields[14], plans != null ? plans.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentOptionById{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "retailerId=" + retailerId + ", "
          + "orderType=" + orderType + ", "
          + "locationRef=" + locationRef + ", "
          + "trackingCode=" + trackingCode + ", "
          + "attributes=" + attributes + ", "
          + "address=" + address + ", "
          + "products=" + products + ", "
          + "plans=" + plans
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FulfilmentOptionById) {
        FulfilmentOptionById that = (FulfilmentOptionById) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.type.equals(that.type)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && this.retailerId == that.retailerId
         && ((this.orderType == null) ? (that.orderType == null) : this.orderType.equals(that.orderType))
         && ((this.locationRef == null) ? (that.locationRef == null) : this.locationRef.equals(that.locationRef))
         && ((this.trackingCode == null) ? (that.trackingCode == null) : this.trackingCode.equals(that.trackingCode))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.address == null) ? (that.address == null) : this.address.equals(that.address))
         && ((this.products == null) ? (that.products == null) : this.products.equals(that.products))
         && ((this.plans == null) ? (that.plans == null) : this.plans.equals(that.plans));
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
        h ^= (createdOn == null) ? 0 : createdOn.hashCode();
        h *= 1000003;
        h ^= (updatedOn == null) ? 0 : updatedOn.hashCode();
        h *= 1000003;
        h ^= retailerId;
        h *= 1000003;
        h ^= (orderType == null) ? 0 : orderType.hashCode();
        h *= 1000003;
        h ^= (locationRef == null) ? 0 : locationRef.hashCode();
        h *= 1000003;
        h ^= (trackingCode == null) ? 0 : trackingCode.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (address == null) ? 0 : address.hashCode();
        h *= 1000003;
        h ^= (products == null) ? 0 : products.hashCode();
        h *= 1000003;
        h ^= (plans == null) ? 0 : plans.hashCode();
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
      builder.createdOn = createdOn;
      builder.updatedOn = updatedOn;
      builder.retailerId = retailerId;
      builder.orderType = orderType;
      builder.locationRef = locationRef;
      builder.trackingCode = trackingCode;
      builder.attributes = attributes;
      builder.address = address;
      builder.products = products;
      builder.plans = plans;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentOptionById> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final Address.Mapper addressFieldMapper = new Address.Mapper();

      final Product.Mapper productFieldMapper = new Product.Mapper();

      final Plans.Mapper plansFieldMapper = new Plans.Mapper();

      @Override
      public FulfilmentOptionById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[6]);
        final int retailerId = reader.readInt($responseFields[7]);
        final String orderType = reader.readString($responseFields[8]);
        final String locationRef = reader.readString($responseFields[9]);
        final String trackingCode = reader.readString($responseFields[10]);
        final List<Attribute> attributes = reader.readList($responseFields[11], new ResponseReader.ListReader<Attribute>() {
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
        final Address address = reader.readObject($responseFields[12], new ResponseReader.ObjectReader<Address>() {
          @Override
          public Address read(ResponseReader reader) {
            return addressFieldMapper.map(reader);
          }
        });
        final List<Product> products = reader.readList($responseFields[13], new ResponseReader.ListReader<Product>() {
          @Override
          public Product read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Product>() {
              @Override
              public Product read(ResponseReader reader) {
                return productFieldMapper.map(reader);
              }
            });
          }
        });
        final Plans plans = reader.readObject($responseFields[14], new ResponseReader.ObjectReader<Plans>() {
          @Override
          public Plans read(ResponseReader reader) {
            return plansFieldMapper.map(reader);
          }
        });
        return new FulfilmentOptionById(__typename, id, ref, type, status, createdOn, updatedOn, retailerId, orderType, locationRef, trackingCode, attributes, address, products, plans);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

      private int retailerId;

      private @Nullable String orderType;

      private @Nullable String locationRef;

      private @Nullable String trackingCode;

      private @Nullable List<Attribute> attributes;

      private @Nullable Address address;

      private @Nullable List<Product> products;

      private @Nullable Plans plans;

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

      public Builder createdOn(@Nullable Object createdOn) {
        this.createdOn = createdOn;
        return this;
      }

      public Builder updatedOn(@Nullable Object updatedOn) {
        this.updatedOn = updatedOn;
        return this;
      }

      public Builder retailerId(int retailerId) {
        this.retailerId = retailerId;
        return this;
      }

      public Builder orderType(@Nullable String orderType) {
        this.orderType = orderType;
        return this;
      }

      public Builder locationRef(@Nullable String locationRef) {
        this.locationRef = locationRef;
        return this;
      }

      public Builder trackingCode(@Nullable String trackingCode) {
        this.trackingCode = trackingCode;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder address(@Nullable Address address) {
        this.address = address;
        return this;
      }

      public Builder products(@Nullable List<Product> products) {
        this.products = products;
        return this;
      }

      public Builder plans(@Nullable Plans plans) {
        this.plans = plans;
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

      public Builder address(@Nonnull Mutator<Address.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Address.Builder builder = this.address != null ? this.address.toBuilder() : Address.builder();
        mutator.accept(builder);
        this.address = builder.build();
        return this;
      }

      public Builder products(@Nonnull Mutator<List<Product.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Product.Builder> builders = new ArrayList<>();
        if (this.products != null) {
          for (Product item : this.products) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Product> products = new ArrayList<>();
        for (Product.Builder item : builders) {
          products.add(item != null ? item.build() : null);
        }
        this.products = products;
        return this;
      }

      public Builder plans(@Nonnull Mutator<Plans.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Plans.Builder builder = this.plans != null ? this.plans.toBuilder() : Plans.builder();
        mutator.accept(builder);
        this.plans = builder.build();
        return this;
      }

      public FulfilmentOptionById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new FulfilmentOptionById(__typename, id, ref, type, status, createdOn, updatedOn, retailerId, orderType, locationRef, trackingCode, attributes, address, products, plans);
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

  public static class Address {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("companyName", "companyName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("addressLine1", "addressLine1", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("addressLine2", "addressLine2", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("city", "city", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("state", "state", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("postcode", "postcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("longitude", "longitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("latitude", "latitude", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String name;

    final @Nullable String companyName;

    final @Nullable String addressLine1;

    final @Nullable String addressLine2;

    final @Nullable String city;

    final @Nullable String state;

    final @Nullable String postcode;

    final @Nullable String country;

    final @Nullable Double longitude;

    final @Nullable Double latitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Address(@Nonnull String __typename, @Nullable String name, @Nullable String companyName,
        @Nullable String addressLine1, @Nullable String addressLine2, @Nullable String city,
        @Nullable String state, @Nullable String postcode, @Nullable String country,
        @Nullable Double longitude, @Nullable Double latitude) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.name = name;
      this.companyName = companyName;
      this.addressLine1 = addressLine1;
      this.addressLine2 = addressLine2;
      this.city = city;
      this.state = state;
      this.postcode = postcode;
      this.country = country;
      this.longitude = longitude;
      this.latitude = latitude;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Name
     */
    public @Nullable String name() {
      return this.name;
    }

    /**
     *  Company Name
     */
    public @Nullable String companyName() {
      return this.companyName;
    }

    /**
     *  Address Line
     */
    public @Nullable String addressLine1() {
      return this.addressLine1;
    }

    /**
     *  Address Line
     */
    public @Nullable String addressLine2() {
      return this.addressLine2;
    }

    /**
     *  City or Town
     */
    public @Nullable String city() {
      return this.city;
    }

    /**
     *  State or County
     */
    public @Nullable String state() {
      return this.state;
    }

    /**
     *  Postcode or Zipcode
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
     *  Geographical coordinate that specifies the east–west position of a point on the Earth's surface
     */
    public @Nullable Double longitude() {
      return this.longitude;
    }

    /**
     *  Geographical coordinate that specifies the north–south position of a point on the Earth's surface
     */
    public @Nullable Double latitude() {
      return this.latitude;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], name);
          writer.writeString($responseFields[2], companyName);
          writer.writeString($responseFields[3], addressLine1);
          writer.writeString($responseFields[4], addressLine2);
          writer.writeString($responseFields[5], city);
          writer.writeString($responseFields[6], state);
          writer.writeString($responseFields[7], postcode);
          writer.writeString($responseFields[8], country);
          writer.writeDouble($responseFields[9], longitude);
          writer.writeDouble($responseFields[10], latitude);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Address{"
          + "__typename=" + __typename + ", "
          + "name=" + name + ", "
          + "companyName=" + companyName + ", "
          + "addressLine1=" + addressLine1 + ", "
          + "addressLine2=" + addressLine2 + ", "
          + "city=" + city + ", "
          + "state=" + state + ", "
          + "postcode=" + postcode + ", "
          + "country=" + country + ", "
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
      if (o instanceof Address) {
        Address that = (Address) o;
        return this.__typename.equals(that.__typename)
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.companyName == null) ? (that.companyName == null) : this.companyName.equals(that.companyName))
         && ((this.addressLine1 == null) ? (that.addressLine1 == null) : this.addressLine1.equals(that.addressLine1))
         && ((this.addressLine2 == null) ? (that.addressLine2 == null) : this.addressLine2.equals(that.addressLine2))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.state == null) ? (that.state == null) : this.state.equals(that.state))
         && ((this.postcode == null) ? (that.postcode == null) : this.postcode.equals(that.postcode))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
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
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= (companyName == null) ? 0 : companyName.hashCode();
        h *= 1000003;
        h ^= (addressLine1 == null) ? 0 : addressLine1.hashCode();
        h *= 1000003;
        h ^= (addressLine2 == null) ? 0 : addressLine2.hashCode();
        h *= 1000003;
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (state == null) ? 0 : state.hashCode();
        h *= 1000003;
        h ^= (postcode == null) ? 0 : postcode.hashCode();
        h *= 1000003;
        h ^= (country == null) ? 0 : country.hashCode();
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
      builder.name = name;
      builder.companyName = companyName;
      builder.addressLine1 = addressLine1;
      builder.addressLine2 = addressLine2;
      builder.city = city;
      builder.state = state;
      builder.postcode = postcode;
      builder.country = country;
      builder.longitude = longitude;
      builder.latitude = latitude;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Address> {
      @Override
      public Address map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String companyName = reader.readString($responseFields[2]);
        final String addressLine1 = reader.readString($responseFields[3]);
        final String addressLine2 = reader.readString($responseFields[4]);
        final String city = reader.readString($responseFields[5]);
        final String state = reader.readString($responseFields[6]);
        final String postcode = reader.readString($responseFields[7]);
        final String country = reader.readString($responseFields[8]);
        final Double longitude = reader.readDouble($responseFields[9]);
        final Double latitude = reader.readDouble($responseFields[10]);
        return new Address(__typename, name, companyName, addressLine1, addressLine2, city, state, postcode, country, longitude, latitude);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String name;

      private @Nullable String companyName;

      private @Nullable String addressLine1;

      private @Nullable String addressLine2;

      private @Nullable String city;

      private @Nullable String state;

      private @Nullable String postcode;

      private @Nullable String country;

      private @Nullable Double longitude;

      private @Nullable Double latitude;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder name(@Nullable String name) {
        this.name = name;
        return this;
      }

      public Builder companyName(@Nullable String companyName) {
        this.companyName = companyName;
        return this;
      }

      public Builder addressLine1(@Nullable String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
      }

      public Builder addressLine2(@Nullable String addressLine2) {
        this.addressLine2 = addressLine2;
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

      public Builder longitude(@Nullable Double longitude) {
        this.longitude = longitude;
        return this;
      }

      public Builder latitude(@Nullable Double latitude) {
        this.latitude = latitude;
        return this;
      }

      public Address build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Address(__typename, name, companyName, addressLine1, addressLine2, city, state, postcode, country, longitude, latitude);
      }
    }
  }

  public static class Product {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("productRef", "productRef", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("catalogueRef", "catalogueRef", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("requestedQuantity", "requestedQuantity", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String productRef;

    final @Nullable String catalogueRef;

    final int requestedQuantity;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Product(@Nonnull String __typename, @Nonnull String productRef,
        @Nullable String catalogueRef, int requestedQuantity) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.productRef = Utils.checkNotNull(productRef, "productRef == null");
      this.catalogueRef = catalogueRef;
      this.requestedQuantity = requestedQuantity;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A reference to identify a Product
     */
    public @Nonnull String productRef() {
      return this.productRef;
    }

    /**
     *  A reference to identify the Catalogue
     */
    public @Nullable String catalogueRef() {
      return this.catalogueRef;
    }

    /**
     *  The requested quantity for the product
     */
    public int requestedQuantity() {
      return this.requestedQuantity;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], productRef);
          writer.writeString($responseFields[2], catalogueRef);
          writer.writeInt($responseFields[3], requestedQuantity);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Product{"
          + "__typename=" + __typename + ", "
          + "productRef=" + productRef + ", "
          + "catalogueRef=" + catalogueRef + ", "
          + "requestedQuantity=" + requestedQuantity
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Product) {
        Product that = (Product) o;
        return this.__typename.equals(that.__typename)
         && this.productRef.equals(that.productRef)
         && ((this.catalogueRef == null) ? (that.catalogueRef == null) : this.catalogueRef.equals(that.catalogueRef))
         && this.requestedQuantity == that.requestedQuantity;
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
        h ^= productRef.hashCode();
        h *= 1000003;
        h ^= (catalogueRef == null) ? 0 : catalogueRef.hashCode();
        h *= 1000003;
        h ^= requestedQuantity;
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.productRef = productRef;
      builder.catalogueRef = catalogueRef;
      builder.requestedQuantity = requestedQuantity;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Product> {
      @Override
      public Product map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String productRef = reader.readString($responseFields[1]);
        final String catalogueRef = reader.readString($responseFields[2]);
        final int requestedQuantity = reader.readInt($responseFields[3]);
        return new Product(__typename, productRef, catalogueRef, requestedQuantity);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String productRef;

      private @Nullable String catalogueRef;

      private int requestedQuantity;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder productRef(@Nonnull String productRef) {
        this.productRef = productRef;
        return this;
      }

      public Builder catalogueRef(@Nullable String catalogueRef) {
        this.catalogueRef = catalogueRef;
        return this;
      }

      public Builder requestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
        return this;
      }

      public Product build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(productRef, "productRef == null");
        return new Product(__typename, productRef, catalogueRef, requestedQuantity);
      }
    }
  }

  public static class Plans {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("plansEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<PlansEdge> plansEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Plans(@Nonnull String __typename, @Nullable List<PlansEdge> plansEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.plansEdge = plansEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to FulfilmentPlan type node
     */
    public @Nullable List<PlansEdge> plansEdge() {
      return this.plansEdge;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], plansEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((PlansEdge) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Plans{"
          + "__typename=" + __typename + ", "
          + "plansEdge=" + plansEdge
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Plans) {
        Plans that = (Plans) o;
        return this.__typename.equals(that.__typename)
         && ((this.plansEdge == null) ? (that.plansEdge == null) : this.plansEdge.equals(that.plansEdge));
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
        h ^= (plansEdge == null) ? 0 : plansEdge.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.plansEdge = plansEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Plans> {
      final PlansEdge.Mapper plansEdgeFieldMapper = new PlansEdge.Mapper();

      @Override
      public Plans map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<PlansEdge> plansEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<PlansEdge>() {
          @Override
          public PlansEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<PlansEdge>() {
              @Override
              public PlansEdge read(ResponseReader reader) {
                return plansEdgeFieldMapper.map(reader);
              }
            });
          }
        });
        return new Plans(__typename, plansEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<PlansEdge> plansEdge;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder plansEdge(@Nullable List<PlansEdge> plansEdge) {
        this.plansEdge = plansEdge;
        return this;
      }

      public Builder plansEdge(@Nonnull Mutator<List<PlansEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<PlansEdge.Builder> builders = new ArrayList<>();
        if (this.plansEdge != null) {
          for (PlansEdge item : this.plansEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<PlansEdge> plansEdge = new ArrayList<>();
        for (PlansEdge.Builder item : builders) {
          plansEdge.add(item != null ? item.build() : null);
        }
        this.plansEdge = plansEdge;
        return this;
      }

      public Plans build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Plans(__typename, plansEdge);
      }
    }
  }

  public static class PlansEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("plan", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Plan plan;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PlansEdge(@Nonnull String __typename, @Nullable Plan plan) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.plan = plan;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the FulfilmentPlan edge
     */
    public @Nullable Plan plan() {
      return this.plan;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], plan != null ? plan.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PlansEdge{"
          + "__typename=" + __typename + ", "
          + "plan=" + plan
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PlansEdge) {
        PlansEdge that = (PlansEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.plan == null) ? (that.plan == null) : this.plan.equals(that.plan));
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
        h ^= (plan == null) ? 0 : plan.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.plan = plan;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<PlansEdge> {
      final Plan.Mapper planFieldMapper = new Plan.Mapper();

      @Override
      public PlansEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Plan plan = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Plan>() {
          @Override
          public Plan read(ResponseReader reader) {
            return planFieldMapper.map(reader);
          }
        });
        return new PlansEdge(__typename, plan);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Plan plan;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder plan(@Nullable Plan plan) {
        this.plan = plan;
        return this;
      }

      public Builder plan(@Nonnull Mutator<Plan.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Plan.Builder builder = this.plan != null ? this.plan.toBuilder() : Plan.builder();
        mutator.accept(builder);
        this.plan = builder.build();
        return this;
      }

      public PlansEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new PlansEdge(__typename, plan);
      }
    }
  }

  public static class Plan {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("fulfilments", "fulfilments", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String type;

    final @Nonnull String id;

    final @Nullable String status;

    final @Nullable List<Fulfilment> fulfilments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Plan(@Nonnull String __typename, @Nonnull String type, @Nonnull String id,
        @Nullable String status, @Nullable List<Fulfilment> fulfilments) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.type = Utils.checkNotNull(type, "type == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.status = status;
      this.fulfilments = fulfilments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Type of the `FulfilmentPlan`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  ID of the object
     */
    public @Nonnull String id() {
      return this.id;
    }

    /**
     *  The current status of the `FulfilmentPlan`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Represents fulfilments under this Fulfilment Plan
     */
    public @Nullable List<Fulfilment> fulfilments() {
      return this.fulfilments;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], type);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], id);
          writer.writeString($responseFields[3], status);
          writer.writeList($responseFields[4], fulfilments, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Fulfilment) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Plan{"
          + "__typename=" + __typename + ", "
          + "type=" + type + ", "
          + "id=" + id + ", "
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
      if (o instanceof Plan) {
        Plan that = (Plan) o;
        return this.__typename.equals(that.__typename)
         && this.type.equals(that.type)
         && this.id.equals(that.id)
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
        h ^= type.hashCode();
        h *= 1000003;
        h ^= id.hashCode();
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
      builder.type = type;
      builder.id = id;
      builder.status = status;
      builder.fulfilments = fulfilments;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Plan> {
      final Fulfilment.Mapper fulfilmentFieldMapper = new Fulfilment.Mapper();

      @Override
      public Plan map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String type = reader.readString($responseFields[1]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final List<Fulfilment> fulfilments = reader.readList($responseFields[4], new ResponseReader.ListReader<Fulfilment>() {
          @Override
          public Fulfilment read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Fulfilment>() {
              @Override
              public Fulfilment read(ResponseReader reader) {
                return fulfilmentFieldMapper.map(reader);
              }
            });
          }
        });
        return new Plan(__typename, type, id, status, fulfilments);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String type;

      private @Nonnull String id;

      private @Nullable String status;

      private @Nullable List<Fulfilment> fulfilments;

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

      public Builder id(@Nonnull String id) {
        this.id = id;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder fulfilments(@Nullable List<Fulfilment> fulfilments) {
        this.fulfilments = fulfilments;
        return this;
      }

      public Builder fulfilments(@Nonnull Mutator<List<Fulfilment.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Fulfilment.Builder> builders = new ArrayList<>();
        if (this.fulfilments != null) {
          for (Fulfilment item : this.fulfilments) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Fulfilment> fulfilments = new ArrayList<>();
        for (Fulfilment.Builder item : builders) {
          fulfilments.add(item != null ? item.build() : null);
        }
        this.fulfilments = fulfilments;
        return this;
      }

      public Plan build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(id, "id == null");
        return new Plan(__typename, type, id, status, fulfilments);
      }
    }
  }

  public static class Fulfilment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("fulfilmentType", "fulfilmentType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("locationRef", "locationRef", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("items", "items", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String fulfilmentType;

    final @Nullable String locationRef;

    final @Nullable List<Item> items;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilment(@Nonnull String __typename, @Nullable String fulfilmentType,
        @Nullable String locationRef, @Nullable List<Item> items) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilmentType = fulfilmentType;
      this.locationRef = locationRef;
      this.items = items;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Type of fulfilment.
     */
    public @Nullable String fulfilmentType() {
      return this.fulfilmentType;
    }

    /**
     *  Reference to identify the fulfilment location for this fulfilment.
     */
    public @Nullable String locationRef() {
      return this.locationRef;
    }

    /**
     *  List of products with their requested and available quantities
     */
    public @Nullable List<Item> items() {
      return this.items;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], fulfilmentType);
          writer.writeString($responseFields[2], locationRef);
          writer.writeList($responseFields[3], items, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Item) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Fulfilment{"
          + "__typename=" + __typename + ", "
          + "fulfilmentType=" + fulfilmentType + ", "
          + "locationRef=" + locationRef + ", "
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
      if (o instanceof Fulfilment) {
        Fulfilment that = (Fulfilment) o;
        return this.__typename.equals(that.__typename)
         && ((this.fulfilmentType == null) ? (that.fulfilmentType == null) : this.fulfilmentType.equals(that.fulfilmentType))
         && ((this.locationRef == null) ? (that.locationRef == null) : this.locationRef.equals(that.locationRef))
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
        h ^= (fulfilmentType == null) ? 0 : fulfilmentType.hashCode();
        h *= 1000003;
        h ^= (locationRef == null) ? 0 : locationRef.hashCode();
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
      builder.fulfilmentType = fulfilmentType;
      builder.locationRef = locationRef;
      builder.items = items;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Fulfilment> {
      final Item.Mapper itemFieldMapper = new Item.Mapper();

      @Override
      public Fulfilment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String fulfilmentType = reader.readString($responseFields[1]);
        final String locationRef = reader.readString($responseFields[2]);
        final List<Item> items = reader.readList($responseFields[3], new ResponseReader.ListReader<Item>() {
          @Override
          public Item read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Item>() {
              @Override
              public Item read(ResponseReader reader) {
                return itemFieldMapper.map(reader);
              }
            });
          }
        });
        return new Fulfilment(__typename, fulfilmentType, locationRef, items);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String fulfilmentType;

      private @Nullable String locationRef;

      private @Nullable List<Item> items;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilmentType(@Nullable String fulfilmentType) {
        this.fulfilmentType = fulfilmentType;
        return this;
      }

      public Builder locationRef(@Nullable String locationRef) {
        this.locationRef = locationRef;
        return this;
      }

      public Builder items(@Nullable List<Item> items) {
        this.items = items;
        return this;
      }

      public Builder items(@Nonnull Mutator<List<Item.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Item.Builder> builders = new ArrayList<>();
        if (this.items != null) {
          for (Item item : this.items) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Item> items = new ArrayList<>();
        for (Item.Builder item : builders) {
          items.add(item != null ? item.build() : null);
        }
        this.items = items;
        return this;
      }

      public Fulfilment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Fulfilment(__typename, fulfilmentType, locationRef, items);
      }
    }
  }

  public static class Item {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("productRef", "productRef", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("catalogueRef", "catalogueRef", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("availableQuantity", "availableQuantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("requestedQuantity", "requestedQuantity", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String productRef;

    final @Nullable String catalogueRef;

    final int availableQuantity;

    final int requestedQuantity;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Item(@Nonnull String __typename, @Nonnull String productRef,
        @Nullable String catalogueRef, int availableQuantity, int requestedQuantity) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.productRef = Utils.checkNotNull(productRef, "productRef == null");
      this.catalogueRef = catalogueRef;
      this.availableQuantity = availableQuantity;
      this.requestedQuantity = requestedQuantity;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  External reference of the product.
     */
    public @Nonnull String productRef() {
      return this.productRef;
    }

    /**
     *  A reference to identify the Catalogue
     */
    public @Nullable String catalogueRef() {
      return this.catalogueRef;
    }

    /**
     *  Quantity of the product available as per the plan
     */
    public int availableQuantity() {
      return this.availableQuantity;
    }

    /**
     *  Requested quantity of the product.
     */
    public int requestedQuantity() {
      return this.requestedQuantity;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], productRef);
          writer.writeString($responseFields[2], catalogueRef);
          writer.writeInt($responseFields[3], availableQuantity);
          writer.writeInt($responseFields[4], requestedQuantity);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Item{"
          + "__typename=" + __typename + ", "
          + "productRef=" + productRef + ", "
          + "catalogueRef=" + catalogueRef + ", "
          + "availableQuantity=" + availableQuantity + ", "
          + "requestedQuantity=" + requestedQuantity
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Item) {
        Item that = (Item) o;
        return this.__typename.equals(that.__typename)
         && this.productRef.equals(that.productRef)
         && ((this.catalogueRef == null) ? (that.catalogueRef == null) : this.catalogueRef.equals(that.catalogueRef))
         && this.availableQuantity == that.availableQuantity
         && this.requestedQuantity == that.requestedQuantity;
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
        h ^= productRef.hashCode();
        h *= 1000003;
        h ^= (catalogueRef == null) ? 0 : catalogueRef.hashCode();
        h *= 1000003;
        h ^= availableQuantity;
        h *= 1000003;
        h ^= requestedQuantity;
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.productRef = productRef;
      builder.catalogueRef = catalogueRef;
      builder.availableQuantity = availableQuantity;
      builder.requestedQuantity = requestedQuantity;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Item> {
      @Override
      public Item map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String productRef = reader.readString($responseFields[1]);
        final String catalogueRef = reader.readString($responseFields[2]);
        final int availableQuantity = reader.readInt($responseFields[3]);
        final int requestedQuantity = reader.readInt($responseFields[4]);
        return new Item(__typename, productRef, catalogueRef, availableQuantity, requestedQuantity);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String productRef;

      private @Nullable String catalogueRef;

      private int availableQuantity;

      private int requestedQuantity;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder productRef(@Nonnull String productRef) {
        this.productRef = productRef;
        return this;
      }

      public Builder catalogueRef(@Nullable String catalogueRef) {
        this.catalogueRef = catalogueRef;
        return this;
      }

      public Builder availableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
        return this;
      }

      public Builder requestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
        return this;
      }

      public Item build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(productRef, "productRef == null");
        return new Item(__typename, productRef, catalogueRef, availableQuantity, requestedQuantity);
      }
    }
  }
}
