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
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class GetFulfilmentByIdQuery implements Query<GetFulfilmentByIdQuery.Data, GetFulfilmentByIdQuery.Data, GetFulfilmentByIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetFulfilmentById($id: ID!, $includeAttributes: Boolean!, $includeItems: Boolean!, $includeFromAddress: Boolean!, $includeToAddress: Boolean!, $includeOrder: Boolean!, $includeArticles: Boolean!, $fulfilmentItemsCount: Int, $fulfilmentItemsCursor: String, $articleCount: Int, $articleCursor: String) {\n"
      + "  fulfilmentById: fulfilmentById(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    status\n"
      + "    type\n"
      + "    deliveryType\n"
      + "    createdOn\n"
      + "    updatedOn\n"
      + "    eta\n"
      + "    expiryTime\n"
      + "    attributes @include(if: $includeAttributes) {\n"
      + "      __typename\n"
      + "      name\n"
      + "      type\n"
      + "      value\n"
      + "    }\n"
      + "    items(first: $fulfilmentItemsCount, after: $fulfilmentItemsCursor) @include(if: $includeItems) {\n"
      + "      __typename\n"
      + "      itemEdge: edges {\n"
      + "        __typename\n"
      + "        itemNode: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "          status\n"
      + "          requestedQuantity\n"
      + "          filledQuantity\n"
      + "          rejectedQuantity\n"
      + "          orderItem {\n"
      + "            __typename\n"
      + "            id\n"
      + "            ref\n"
      + "            quantity\n"
      + "            product {\n"
      + "              __typename\n"
      + "              ... on VariantProduct {\n"
      + "                id\n"
      + "                ref\n"
      + "                type\n"
      + "                status\n"
      + "                vpAttributes: attributes {\n"
      + "                  __typename\n"
      + "                  name\n"
      + "                  type\n"
      + "                  value\n"
      + "                }\n"
      + "              }\n"
      + "              ... on StandardProduct {\n"
      + "                id\n"
      + "                ref\n"
      + "                type\n"
      + "                status\n"
      + "                spAttributes: attributes {\n"
      + "                  __typename\n"
      + "                  name\n"
      + "                  type\n"
      + "                  value\n"
      + "                }\n"
      + "              }\n"
      + "            }\n"
      + "            orderItemAttributes: attributes @include(if: $includeAttributes) {\n"
      + "              __typename\n"
      + "              name\n"
      + "              type\n"
      + "              value\n"
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
      + "    fromLocation {\n"
      + "      __typename\n"
      + "      ref\n"
      + "    }\n"
      + "    fromAddress @include(if: $includeFromAddress) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "      type\n"
      + "      companyName\n"
      + "      name\n"
      + "      street\n"
      + "      city\n"
      + "      country\n"
      + "      state\n"
      + "      postcode\n"
      + "      region\n"
      + "      latitude\n"
      + "      longitude\n"
      + "      timeZone\n"
      + "    }\n"
      + "    toAddress @include(if: $includeToAddress) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "      type\n"
      + "      companyName\n"
      + "      name\n"
      + "      street\n"
      + "      city\n"
      + "      country\n"
      + "      state\n"
      + "      postcode\n"
      + "      region\n"
      + "      latitude\n"
      + "      longitude\n"
      + "      timeZone\n"
      + "    }\n"
      + "    order @include(if: $includeOrder) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "      type\n"
      + "      status\n"
      + "    }\n"
      + "    articles(first: $articleCount, after: $articleCursor) @include(if: $includeArticles) {\n"
      + "      __typename\n"
      + "      articleEdge: edges {\n"
      + "        __typename\n"
      + "        articleNode: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "          name\n"
      + "          type\n"
      + "          status\n"
      + "          height\n"
      + "          weight\n"
      + "          width\n"
      + "          length\n"
      + "          quantity\n"
      + "          consignmentArticles {\n"
      + "            __typename\n"
      + "            consignmentEdge: edges {\n"
      + "              __typename\n"
      + "              consignmentNode: node {\n"
      + "                __typename\n"
      + "                consignment {\n"
      + "                  __typename\n"
      + "                  id\n"
      + "                  ref\n"
      + "                }\n"
      + "              }\n"
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
      return "GetFulfilmentById";
    }
  };

  private final GetFulfilmentByIdQuery.Variables variables;

  public GetFulfilmentByIdQuery(@Nonnull String id, boolean includeAttributes, boolean includeItems,
      boolean includeFromAddress, boolean includeToAddress, boolean includeOrder,
      boolean includeArticles, @Nullable Integer fulfilmentItemsCount,
      @Nullable String fulfilmentItemsCursor, @Nullable Integer articleCount,
      @Nullable String articleCursor) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetFulfilmentByIdQuery.Variables(id, includeAttributes, includeItems, includeFromAddress, includeToAddress, includeOrder, includeArticles, fulfilmentItemsCount, fulfilmentItemsCursor, articleCount, articleCursor);
  }

  @Override
  public String operationId() {
    return "fed37754be230eada36f83a7481a0d1c5013d84d76c15e1eb748fa0513367180";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetFulfilmentByIdQuery.Data wrapData(GetFulfilmentByIdQuery.Data data) {
    return data;
  }

  @Override
  public GetFulfilmentByIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetFulfilmentByIdQuery.Data> responseFieldMapper() {
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

    private boolean includeItems;

    private boolean includeFromAddress;

    private boolean includeToAddress;

    private boolean includeOrder;

    private boolean includeArticles;

    private @Nullable Integer fulfilmentItemsCount;

    private @Nullable String fulfilmentItemsCursor;

    private @Nullable Integer articleCount;

    private @Nullable String articleCursor;

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

    public Builder includeItems(boolean includeItems) {
      this.includeItems = includeItems;
      return this;
    }

    public Builder includeFromAddress(boolean includeFromAddress) {
      this.includeFromAddress = includeFromAddress;
      return this;
    }

    public Builder includeToAddress(boolean includeToAddress) {
      this.includeToAddress = includeToAddress;
      return this;
    }

    public Builder includeOrder(boolean includeOrder) {
      this.includeOrder = includeOrder;
      return this;
    }

    public Builder includeArticles(boolean includeArticles) {
      this.includeArticles = includeArticles;
      return this;
    }

    public Builder fulfilmentItemsCount(@Nullable Integer fulfilmentItemsCount) {
      this.fulfilmentItemsCount = fulfilmentItemsCount;
      return this;
    }

    public Builder fulfilmentItemsCursor(@Nullable String fulfilmentItemsCursor) {
      this.fulfilmentItemsCursor = fulfilmentItemsCursor;
      return this;
    }

    public Builder articleCount(@Nullable Integer articleCount) {
      this.articleCount = articleCount;
      return this;
    }

    public Builder articleCursor(@Nullable String articleCursor) {
      this.articleCursor = articleCursor;
      return this;
    }

    public GetFulfilmentByIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetFulfilmentByIdQuery(id, includeAttributes, includeItems, includeFromAddress, includeToAddress, includeOrder, includeArticles, fulfilmentItemsCount, fulfilmentItemsCursor, articleCount, articleCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final boolean includeAttributes;

    private final boolean includeItems;

    private final boolean includeFromAddress;

    private final boolean includeToAddress;

    private final boolean includeOrder;

    private final boolean includeArticles;

    private final @Nullable Integer fulfilmentItemsCount;

    private final @Nullable String fulfilmentItemsCursor;

    private final @Nullable Integer articleCount;

    private final @Nullable String articleCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, boolean includeAttributes, boolean includeItems,
        boolean includeFromAddress, boolean includeToAddress, boolean includeOrder,
        boolean includeArticles, @Nullable Integer fulfilmentItemsCount,
        @Nullable String fulfilmentItemsCursor, @Nullable Integer articleCount,
        @Nullable String articleCursor) {
      this.id = id;
      this.includeAttributes = includeAttributes;
      this.includeItems = includeItems;
      this.includeFromAddress = includeFromAddress;
      this.includeToAddress = includeToAddress;
      this.includeOrder = includeOrder;
      this.includeArticles = includeArticles;
      this.fulfilmentItemsCount = fulfilmentItemsCount;
      this.fulfilmentItemsCursor = fulfilmentItemsCursor;
      this.articleCount = articleCount;
      this.articleCursor = articleCursor;
      this.valueMap.put("id", id);
      this.valueMap.put("includeAttributes", includeAttributes);
      this.valueMap.put("includeItems", includeItems);
      this.valueMap.put("includeFromAddress", includeFromAddress);
      this.valueMap.put("includeToAddress", includeToAddress);
      this.valueMap.put("includeOrder", includeOrder);
      this.valueMap.put("includeArticles", includeArticles);
      this.valueMap.put("fulfilmentItemsCount", fulfilmentItemsCount);
      this.valueMap.put("fulfilmentItemsCursor", fulfilmentItemsCursor);
      this.valueMap.put("articleCount", articleCount);
      this.valueMap.put("articleCursor", articleCursor);
    }

    public @Nonnull String id() {
      return id;
    }

    public boolean includeAttributes() {
      return includeAttributes;
    }

    public boolean includeItems() {
      return includeItems;
    }

    public boolean includeFromAddress() {
      return includeFromAddress;
    }

    public boolean includeToAddress() {
      return includeToAddress;
    }

    public boolean includeOrder() {
      return includeOrder;
    }

    public boolean includeArticles() {
      return includeArticles;
    }

    public @Nullable Integer fulfilmentItemsCount() {
      return fulfilmentItemsCount;
    }

    public @Nullable String fulfilmentItemsCursor() {
      return fulfilmentItemsCursor;
    }

    public @Nullable Integer articleCount() {
      return articleCount;
    }

    public @Nullable String articleCursor() {
      return articleCursor;
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
          writer.writeBoolean("includeItems", includeItems);
          writer.writeBoolean("includeFromAddress", includeFromAddress);
          writer.writeBoolean("includeToAddress", includeToAddress);
          writer.writeBoolean("includeOrder", includeOrder);
          writer.writeBoolean("includeArticles", includeArticles);
          writer.writeInt("fulfilmentItemsCount", fulfilmentItemsCount);
          writer.writeString("fulfilmentItemsCursor", fulfilmentItemsCursor);
          writer.writeInt("articleCount", articleCount);
          writer.writeString("articleCursor", articleCursor);
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
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("deliveryType", "deliveryType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("eta", "eta", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("expiryTime", "expiryTime", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeAttributes", false))),
      ResponseField.forObject("items", "items", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemsCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemsCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeItems", false))),
      ResponseField.forObject("fromLocation", "fromLocation", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fromAddress", "fromAddress", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeFromAddress", false))),
      ResponseField.forObject("toAddress", "toAddress", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeToAddress", false))),
      ResponseField.forObject("order", "order", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeOrder", false))),
      ResponseField.forObject("articles", "articles", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "articleCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "articleCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeArticles", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nonnull String type;

    final @Nullable String deliveryType;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable String eta;

    final @Nullable Object expiryTime;

    final @Nullable List<Attribute> attributes;

    final @Nullable Items items;

    final @Nullable FromLocation fromLocation;

    final @Nullable FromAddress fromAddress;

    final @Nullable ToAddress toAddress;

    final @Nullable Order order;

    final @Nullable Articles articles;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentById(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nonnull String type, @Nullable String deliveryType,
        @Nullable Object createdOn, @Nullable Object updatedOn, @Nullable String eta,
        @Nullable Object expiryTime, @Nullable List<Attribute> attributes, @Nullable Items items,
        @Nullable FromLocation fromLocation, @Nullable FromAddress fromAddress,
        @Nullable ToAddress toAddress, @Nullable Order order, @Nullable Articles articles) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.type = Utils.checkNotNull(type, "type == null");
      this.deliveryType = deliveryType;
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.eta = eta;
      this.expiryTime = expiryTime;
      this.attributes = attributes;
      this.items = items;
      this.fromLocation = fromLocation;
      this.fromAddress = fromAddress;
      this.toAddress = toAddress;
      this.order = order;
      this.articles = articles;
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
     *  Type of delivery. Supported values are _STANDARD_, _OVERNIGHT_ and _EXPRESS_.
     */
    public @Nullable String deliveryType() {
      return this.deliveryType;
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

    /**
     *  Attributes of fulfilment
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    /**
     *  Connection representing a list of `FulfilmentItem`s
     */
    public @Nullable Items items() {
      return this.items;
    }

    /**
     *  The `Location` responsible for processing outbound `Fulfilment`s
     */
    public @Nullable FromLocation fromLocation() {
      return this.fromLocation;
    }

    /**
     *  `Address` of the fulfilment location
     */
    public @Nullable FromAddress fromAddress() {
      return this.fromAddress;
    }

    /**
     *  `Address` of the delivery location
     */
    public @Nullable ToAddress toAddress() {
      return this.toAddress;
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], type);
          writer.writeString($responseFields[5], deliveryType);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[6], createdOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[7], updatedOn);
          writer.writeString($responseFields[8], eta);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[9], expiryTime);
          writer.writeList($responseFields[10], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeObject($responseFields[11], items != null ? items.marshaller() : null);
          writer.writeObject($responseFields[12], fromLocation != null ? fromLocation.marshaller() : null);
          writer.writeObject($responseFields[13], fromAddress != null ? fromAddress.marshaller() : null);
          writer.writeObject($responseFields[14], toAddress != null ? toAddress.marshaller() : null);
          writer.writeObject($responseFields[15], order != null ? order.marshaller() : null);
          writer.writeObject($responseFields[16], articles != null ? articles.marshaller() : null);
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
          + "status=" + status + ", "
          + "type=" + type + ", "
          + "deliveryType=" + deliveryType + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "eta=" + eta + ", "
          + "expiryTime=" + expiryTime + ", "
          + "attributes=" + attributes + ", "
          + "items=" + items + ", "
          + "fromLocation=" + fromLocation + ", "
          + "fromAddress=" + fromAddress + ", "
          + "toAddress=" + toAddress + ", "
          + "order=" + order + ", "
          + "articles=" + articles
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
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.type.equals(that.type)
         && ((this.deliveryType == null) ? (that.deliveryType == null) : this.deliveryType.equals(that.deliveryType))
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.eta == null) ? (that.eta == null) : this.eta.equals(that.eta))
         && ((this.expiryTime == null) ? (that.expiryTime == null) : this.expiryTime.equals(that.expiryTime))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.items == null) ? (that.items == null) : this.items.equals(that.items))
         && ((this.fromLocation == null) ? (that.fromLocation == null) : this.fromLocation.equals(that.fromLocation))
         && ((this.fromAddress == null) ? (that.fromAddress == null) : this.fromAddress.equals(that.fromAddress))
         && ((this.toAddress == null) ? (that.toAddress == null) : this.toAddress.equals(that.toAddress))
         && ((this.order == null) ? (that.order == null) : this.order.equals(that.order))
         && ((this.articles == null) ? (that.articles == null) : this.articles.equals(that.articles));
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
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (deliveryType == null) ? 0 : deliveryType.hashCode();
        h *= 1000003;
        h ^= (createdOn == null) ? 0 : createdOn.hashCode();
        h *= 1000003;
        h ^= (updatedOn == null) ? 0 : updatedOn.hashCode();
        h *= 1000003;
        h ^= (eta == null) ? 0 : eta.hashCode();
        h *= 1000003;
        h ^= (expiryTime == null) ? 0 : expiryTime.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (items == null) ? 0 : items.hashCode();
        h *= 1000003;
        h ^= (fromLocation == null) ? 0 : fromLocation.hashCode();
        h *= 1000003;
        h ^= (fromAddress == null) ? 0 : fromAddress.hashCode();
        h *= 1000003;
        h ^= (toAddress == null) ? 0 : toAddress.hashCode();
        h *= 1000003;
        h ^= (order == null) ? 0 : order.hashCode();
        h *= 1000003;
        h ^= (articles == null) ? 0 : articles.hashCode();
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
      builder.deliveryType = deliveryType;
      builder.createdOn = createdOn;
      builder.updatedOn = updatedOn;
      builder.eta = eta;
      builder.expiryTime = expiryTime;
      builder.attributes = attributes;
      builder.items = items;
      builder.fromLocation = fromLocation;
      builder.fromAddress = fromAddress;
      builder.toAddress = toAddress;
      builder.order = order;
      builder.articles = articles;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentById> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final Items.Mapper itemsFieldMapper = new Items.Mapper();

      final FromLocation.Mapper fromLocationFieldMapper = new FromLocation.Mapper();

      final FromAddress.Mapper fromAddressFieldMapper = new FromAddress.Mapper();

      final ToAddress.Mapper toAddressFieldMapper = new ToAddress.Mapper();

      final Order.Mapper orderFieldMapper = new Order.Mapper();

      final Articles.Mapper articlesFieldMapper = new Articles.Mapper();

      @Override
      public FulfilmentById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String type = reader.readString($responseFields[4]);
        final String deliveryType = reader.readString($responseFields[5]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[6]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[7]);
        final String eta = reader.readString($responseFields[8]);
        final Object expiryTime = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[9]);
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
        final Items items = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<Items>() {
          @Override
          public Items read(ResponseReader reader) {
            return itemsFieldMapper.map(reader);
          }
        });
        final FromLocation fromLocation = reader.readObject($responseFields[12], new ResponseReader.ObjectReader<FromLocation>() {
          @Override
          public FromLocation read(ResponseReader reader) {
            return fromLocationFieldMapper.map(reader);
          }
        });
        final FromAddress fromAddress = reader.readObject($responseFields[13], new ResponseReader.ObjectReader<FromAddress>() {
          @Override
          public FromAddress read(ResponseReader reader) {
            return fromAddressFieldMapper.map(reader);
          }
        });
        final ToAddress toAddress = reader.readObject($responseFields[14], new ResponseReader.ObjectReader<ToAddress>() {
          @Override
          public ToAddress read(ResponseReader reader) {
            return toAddressFieldMapper.map(reader);
          }
        });
        final Order order = reader.readObject($responseFields[15], new ResponseReader.ObjectReader<Order>() {
          @Override
          public Order read(ResponseReader reader) {
            return orderFieldMapper.map(reader);
          }
        });
        final Articles articles = reader.readObject($responseFields[16], new ResponseReader.ObjectReader<Articles>() {
          @Override
          public Articles read(ResponseReader reader) {
            return articlesFieldMapper.map(reader);
          }
        });
        return new FulfilmentById(__typename, id, ref, status, type, deliveryType, createdOn, updatedOn, eta, expiryTime, attributes, items, fromLocation, fromAddress, toAddress, order, articles);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nonnull String type;

      private @Nullable String deliveryType;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

      private @Nullable String eta;

      private @Nullable Object expiryTime;

      private @Nullable List<Attribute> attributes;

      private @Nullable Items items;

      private @Nullable FromLocation fromLocation;

      private @Nullable FromAddress fromAddress;

      private @Nullable ToAddress toAddress;

      private @Nullable Order order;

      private @Nullable Articles articles;

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

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder deliveryType(@Nullable String deliveryType) {
        this.deliveryType = deliveryType;
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

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder items(@Nullable Items items) {
        this.items = items;
        return this;
      }

      public Builder fromLocation(@Nullable FromLocation fromLocation) {
        this.fromLocation = fromLocation;
        return this;
      }

      public Builder fromAddress(@Nullable FromAddress fromAddress) {
        this.fromAddress = fromAddress;
        return this;
      }

      public Builder toAddress(@Nullable ToAddress toAddress) {
        this.toAddress = toAddress;
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

      public Builder items(@Nonnull Mutator<Items.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Items.Builder builder = this.items != null ? this.items.toBuilder() : Items.builder();
        mutator.accept(builder);
        this.items = builder.build();
        return this;
      }

      public Builder fromLocation(@Nonnull Mutator<FromLocation.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FromLocation.Builder builder = this.fromLocation != null ? this.fromLocation.toBuilder() : FromLocation.builder();
        mutator.accept(builder);
        this.fromLocation = builder.build();
        return this;
      }

      public Builder fromAddress(@Nonnull Mutator<FromAddress.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FromAddress.Builder builder = this.fromAddress != null ? this.fromAddress.toBuilder() : FromAddress.builder();
        mutator.accept(builder);
        this.fromAddress = builder.build();
        return this;
      }

      public Builder toAddress(@Nonnull Mutator<ToAddress.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ToAddress.Builder builder = this.toAddress != null ? this.toAddress.toBuilder() : ToAddress.builder();
        mutator.accept(builder);
        this.toAddress = builder.build();
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

      public FulfilmentById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new FulfilmentById(__typename, id, ref, status, type, deliveryType, createdOn, updatedOn, eta, expiryTime, attributes, items, fromLocation, fromAddress, toAddress, order, articles);
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

  public static class Items {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("itemEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<ItemEdge> itemEdge;

    final @Nullable PageInfo pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Items(@Nonnull String __typename, @Nullable List<ItemEdge> itemEdge,
        @Nullable PageInfo pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.itemEdge = itemEdge;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to FulfilmentItem type node
     */
    public @Nullable List<ItemEdge> itemEdge() {
      return this.itemEdge;
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
          writer.writeList($responseFields[1], itemEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((ItemEdge) value).marshaller());
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
          + "itemEdge=" + itemEdge + ", "
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
         && ((this.itemEdge == null) ? (that.itemEdge == null) : this.itemEdge.equals(that.itemEdge))
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
        h ^= (itemEdge == null) ? 0 : itemEdge.hashCode();
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
      builder.itemEdge = itemEdge;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Items> {
      final ItemEdge.Mapper itemEdgeFieldMapper = new ItemEdge.Mapper();

      final PageInfo.Mapper pageInfoFieldMapper = new PageInfo.Mapper();

      @Override
      public Items map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<ItemEdge> itemEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<ItemEdge>() {
          @Override
          public ItemEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<ItemEdge>() {
              @Override
              public ItemEdge read(ResponseReader reader) {
                return itemEdgeFieldMapper.map(reader);
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
        return new Items(__typename, itemEdge, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<ItemEdge> itemEdge;

      private @Nullable PageInfo pageInfo;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder itemEdge(@Nullable List<ItemEdge> itemEdge) {
        this.itemEdge = itemEdge;
        return this;
      }

      public Builder pageInfo(@Nullable PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
      }

      public Builder itemEdge(@Nonnull Mutator<List<ItemEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<ItemEdge.Builder> builders = new ArrayList<>();
        if (this.itemEdge != null) {
          for (ItemEdge item : this.itemEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<ItemEdge> itemEdge = new ArrayList<>();
        for (ItemEdge.Builder item : builders) {
          itemEdge.add(item != null ? item.build() : null);
        }
        this.itemEdge = itemEdge;
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
        return new Items(__typename, itemEdge, pageInfo);
      }
    }
  }

  public static class ItemEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("itemNode", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable ItemNode itemNode;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ItemEdge(@Nonnull String __typename, @Nullable ItemNode itemNode,
        @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.itemNode = itemNode;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the FulfilmentItem edge
     */
    public @Nullable ItemNode itemNode() {
      return this.itemNode;
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
          writer.writeObject($responseFields[1], itemNode != null ? itemNode.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ItemEdge{"
          + "__typename=" + __typename + ", "
          + "itemNode=" + itemNode + ", "
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
      if (o instanceof ItemEdge) {
        ItemEdge that = (ItemEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.itemNode == null) ? (that.itemNode == null) : this.itemNode.equals(that.itemNode))
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
        h ^= (itemNode == null) ? 0 : itemNode.hashCode();
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
      builder.itemNode = itemNode;
      builder.cursor = cursor;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ItemEdge> {
      final ItemNode.Mapper itemNodeFieldMapper = new ItemNode.Mapper();

      @Override
      public ItemEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final ItemNode itemNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<ItemNode>() {
          @Override
          public ItemNode read(ResponseReader reader) {
            return itemNodeFieldMapper.map(reader);
          }
        });
        final String cursor = reader.readString($responseFields[2]);
        return new ItemEdge(__typename, itemNode, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable ItemNode itemNode;

      private @Nullable String cursor;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder itemNode(@Nullable ItemNode itemNode) {
        this.itemNode = itemNode;
        return this;
      }

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
        return this;
      }

      public Builder itemNode(@Nonnull Mutator<ItemNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ItemNode.Builder builder = this.itemNode != null ? this.itemNode.toBuilder() : ItemNode.builder();
        mutator.accept(builder);
        this.itemNode = builder.build();
        return this;
      }

      public ItemEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ItemEdge(__typename, itemNode, cursor);
      }
    }
  }

  public static class ItemNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("requestedQuantity", "requestedQuantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("filledQuantity", "filledQuantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("rejectedQuantity", "rejectedQuantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("orderItem", "orderItem", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String status;

    final @Nullable Integer requestedQuantity;

    final int filledQuantity;

    final int rejectedQuantity;

    final @Nullable OrderItem orderItem;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ItemNode(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String status, @Nullable Integer requestedQuantity, int filledQuantity,
        int rejectedQuantity, @Nullable OrderItem orderItem) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = Utils.checkNotNull(status, "status == null");
      this.requestedQuantity = requestedQuantity;
      this.filledQuantity = filledQuantity;
      this.rejectedQuantity = rejectedQuantity;
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
     *  Status
     */
    public @Nonnull String status() {
      return this.status;
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
          writer.writeString($responseFields[3], status);
          writer.writeInt($responseFields[4], requestedQuantity);
          writer.writeInt($responseFields[5], filledQuantity);
          writer.writeInt($responseFields[6], rejectedQuantity);
          writer.writeObject($responseFields[7], orderItem != null ? orderItem.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ItemNode{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "requestedQuantity=" + requestedQuantity + ", "
          + "filledQuantity=" + filledQuantity + ", "
          + "rejectedQuantity=" + rejectedQuantity + ", "
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
      if (o instanceof ItemNode) {
        ItemNode that = (ItemNode) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.status.equals(that.status)
         && ((this.requestedQuantity == null) ? (that.requestedQuantity == null) : this.requestedQuantity.equals(that.requestedQuantity))
         && this.filledQuantity == that.filledQuantity
         && this.rejectedQuantity == that.rejectedQuantity
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
        h ^= status.hashCode();
        h *= 1000003;
        h ^= (requestedQuantity == null) ? 0 : requestedQuantity.hashCode();
        h *= 1000003;
        h ^= filledQuantity;
        h *= 1000003;
        h ^= rejectedQuantity;
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
      builder.status = status;
      builder.requestedQuantity = requestedQuantity;
      builder.filledQuantity = filledQuantity;
      builder.rejectedQuantity = rejectedQuantity;
      builder.orderItem = orderItem;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ItemNode> {
      final OrderItem.Mapper orderItemFieldMapper = new OrderItem.Mapper();

      @Override
      public ItemNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final Integer requestedQuantity = reader.readInt($responseFields[4]);
        final int filledQuantity = reader.readInt($responseFields[5]);
        final int rejectedQuantity = reader.readInt($responseFields[6]);
        final OrderItem orderItem = reader.readObject($responseFields[7], new ResponseReader.ObjectReader<OrderItem>() {
          @Override
          public OrderItem read(ResponseReader reader) {
            return orderItemFieldMapper.map(reader);
          }
        });
        return new ItemNode(__typename, id, ref, status, requestedQuantity, filledQuantity, rejectedQuantity, orderItem);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nonnull String status;

      private @Nullable Integer requestedQuantity;

      private int filledQuantity;

      private int rejectedQuantity;

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

      public Builder status(@Nonnull String status) {
        this.status = status;
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

      public ItemNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(status, "status == null");
        return new ItemNode(__typename, id, ref, status, requestedQuantity, filledQuantity, rejectedQuantity, orderItem);
      }
    }
  }

  public static class OrderItem {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("product", "product", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("orderItemAttributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeAttributes", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final int quantity;

    final @Nonnull Product product;

    final @Nullable List<OrderItemAttribute> orderItemAttributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OrderItem(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        int quantity, @Nonnull Product product,
        @Nullable List<OrderItemAttribute> orderItemAttributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.quantity = quantity;
      this.product = Utils.checkNotNull(product, "product == null");
      this.orderItemAttributes = orderItemAttributes;
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
     *  Quantity ordered
     */
    public int quantity() {
      return this.quantity;
    }

    /**
     *  Represents the `Product` corresponding to this object
     */
    public @Nonnull Product product() {
      return this.product;
    }

    /**
     *  List of `OrderItem` `attribute`s.
     */
    public @Nullable List<OrderItemAttribute> orderItemAttributes() {
      return this.orderItemAttributes;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeInt($responseFields[3], quantity);
          writer.writeObject($responseFields[4], product.marshaller());
          writer.writeList($responseFields[5], orderItemAttributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((OrderItemAttribute) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OrderItem{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "quantity=" + quantity + ", "
          + "product=" + product + ", "
          + "orderItemAttributes=" + orderItemAttributes
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
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.quantity == that.quantity
         && this.product.equals(that.product)
         && ((this.orderItemAttributes == null) ? (that.orderItemAttributes == null) : this.orderItemAttributes.equals(that.orderItemAttributes));
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
        h ^= quantity;
        h *= 1000003;
        h ^= product.hashCode();
        h *= 1000003;
        h ^= (orderItemAttributes == null) ? 0 : orderItemAttributes.hashCode();
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
      builder.quantity = quantity;
      builder.product = product;
      builder.orderItemAttributes = orderItemAttributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OrderItem> {
      final Product.Mapper productFieldMapper = new Product.Mapper();

      final OrderItemAttribute.Mapper orderItemAttributeFieldMapper = new OrderItemAttribute.Mapper();

      @Override
      public OrderItem map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final int quantity = reader.readInt($responseFields[3]);
        final Product product = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<Product>() {
          @Override
          public Product read(ResponseReader reader) {
            return productFieldMapper.map(reader);
          }
        });
        final List<OrderItemAttribute> orderItemAttributes = reader.readList($responseFields[5], new ResponseReader.ListReader<OrderItemAttribute>() {
          @Override
          public OrderItemAttribute read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<OrderItemAttribute>() {
              @Override
              public OrderItemAttribute read(ResponseReader reader) {
                return orderItemAttributeFieldMapper.map(reader);
              }
            });
          }
        });
        return new OrderItem(__typename, id, ref, quantity, product, orderItemAttributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private int quantity;

      private @Nonnull Product product;

      private @Nullable List<OrderItemAttribute> orderItemAttributes;

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

      public Builder quantity(int quantity) {
        this.quantity = quantity;
        return this;
      }

      public Builder product(@Nonnull Product product) {
        this.product = product;
        return this;
      }

      public Builder orderItemAttributes(@Nullable List<OrderItemAttribute> orderItemAttributes) {
        this.orderItemAttributes = orderItemAttributes;
        return this;
      }

      public Builder product(@Nonnull Mutator<Product.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Product.Builder builder = this.product != null ? this.product.toBuilder() : Product.builder();
        mutator.accept(builder);
        this.product = builder.build();
        return this;
      }

      public Builder orderItemAttributes(@Nonnull Mutator<List<OrderItemAttribute.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<OrderItemAttribute.Builder> builders = new ArrayList<>();
        if (this.orderItemAttributes != null) {
          for (OrderItemAttribute item : this.orderItemAttributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<OrderItemAttribute> orderItemAttributes = new ArrayList<>();
        for (OrderItemAttribute.Builder item : builders) {
          orderItemAttributes.add(item != null ? item.build() : null);
        }
        this.orderItemAttributes = orderItemAttributes;
        return this;
      }

      public OrderItem build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(product, "product == null");
        return new OrderItem(__typename, id, ref, quantity, product, orderItemAttributes);
      }
    }
  }

  public static class Product {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInlineFragment("__typename", "__typename", Arrays.asList("VariantProduct")),
      ResponseField.forInlineFragment("__typename", "__typename", Arrays.asList("StandardProduct"))
    };

    final @Nonnull String __typename;

    final @Nullable AsVariantProduct asVariantProduct;

    final @Nullable AsStandardProduct asStandardProduct;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Product(@Nonnull String __typename, @Nullable AsVariantProduct asVariantProduct,
        @Nullable AsStandardProduct asStandardProduct) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.asVariantProduct = asVariantProduct;
      this.asStandardProduct = asStandardProduct;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable AsVariantProduct asVariantProduct() {
      return this.asVariantProduct;
    }

    public @Nullable AsStandardProduct asStandardProduct() {
      return this.asStandardProduct;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          final AsVariantProduct $asVariantProduct = asVariantProduct;
          if ($asVariantProduct != null) {
            $asVariantProduct.marshaller().marshal(writer);
          }
          final AsStandardProduct $asStandardProduct = asStandardProduct;
          if ($asStandardProduct != null) {
            $asStandardProduct.marshaller().marshal(writer);
          }
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Product{"
          + "__typename=" + __typename + ", "
          + "asVariantProduct=" + asVariantProduct + ", "
          + "asStandardProduct=" + asStandardProduct
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
         && ((this.asVariantProduct == null) ? (that.asVariantProduct == null) : this.asVariantProduct.equals(that.asVariantProduct))
         && ((this.asStandardProduct == null) ? (that.asStandardProduct == null) : this.asStandardProduct.equals(that.asStandardProduct));
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
        h ^= (asVariantProduct == null) ? 0 : asVariantProduct.hashCode();
        h *= 1000003;
        h ^= (asStandardProduct == null) ? 0 : asStandardProduct.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.asVariantProduct = asVariantProduct;
      builder.asStandardProduct = asStandardProduct;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Product> {
      final AsVariantProduct.Mapper asVariantProductFieldMapper = new AsVariantProduct.Mapper();

      final AsStandardProduct.Mapper asStandardProductFieldMapper = new AsStandardProduct.Mapper();

      @Override
      public Product map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final AsVariantProduct asVariantProduct = reader.readConditional($responseFields[1], new ResponseReader.ConditionalTypeReader<AsVariantProduct>() {
          @Override
          public AsVariantProduct read(String conditionalType, ResponseReader reader) {
            return asVariantProductFieldMapper.map(reader);
          }
        });
        final AsStandardProduct asStandardProduct = reader.readConditional($responseFields[2], new ResponseReader.ConditionalTypeReader<AsStandardProduct>() {
          @Override
          public AsStandardProduct read(String conditionalType, ResponseReader reader) {
            return asStandardProductFieldMapper.map(reader);
          }
        });
        return new Product(__typename, asVariantProduct, asStandardProduct);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable AsVariantProduct asVariantProduct;

      private @Nullable AsStandardProduct asStandardProduct;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder asVariantProduct(@Nullable AsVariantProduct asVariantProduct) {
        this.asVariantProduct = asVariantProduct;
        return this;
      }

      public Builder asStandardProduct(@Nullable AsStandardProduct asStandardProduct) {
        this.asStandardProduct = asStandardProduct;
        return this;
      }

      public Builder asVariantProduct(@Nonnull Mutator<AsVariantProduct.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        AsVariantProduct.Builder builder = this.asVariantProduct != null ? this.asVariantProduct.toBuilder() : AsVariantProduct.builder();
        mutator.accept(builder);
        this.asVariantProduct = builder.build();
        return this;
      }

      public Builder asStandardProduct(@Nonnull Mutator<AsStandardProduct.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        AsStandardProduct.Builder builder = this.asStandardProduct != null ? this.asStandardProduct.toBuilder() : AsStandardProduct.builder();
        mutator.accept(builder);
        this.asStandardProduct = builder.build();
        return this;
      }

      public Product build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Product(__typename, asVariantProduct, asStandardProduct);
      }
    }
  }

  public static class AsVariantProduct {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("vpAttributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable List<VpAttribute> vpAttributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public AsVariantProduct(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref,
        @Nonnull String type, @Nullable String status, @Nullable List<VpAttribute> vpAttributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.vpAttributes = vpAttributes;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  ID of the object. For internal use, should not be used externally or by any business logic
     */
    public @Nonnull String id() {
      return this.id;
    }

    /**
     *  The unique reference identifier for the Product
     */
    public @Nonnull String ref() {
      return this.ref;
    }

    /**
     *  Type of the `VariantProduct`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  The current status of the `VariantProduct`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  A list of attributes associated with this Product. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public @Nullable List<VpAttribute> vpAttributes() {
      return this.vpAttributes;
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
          writer.writeList($responseFields[5], vpAttributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((VpAttribute) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AsVariantProduct{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "vpAttributes=" + vpAttributes
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AsVariantProduct) {
        AsVariantProduct that = (AsVariantProduct) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.ref.equals(that.ref)
         && this.type.equals(that.type)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.vpAttributes == null) ? (that.vpAttributes == null) : this.vpAttributes.equals(that.vpAttributes));
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
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (vpAttributes == null) ? 0 : vpAttributes.hashCode();
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
      builder.vpAttributes = vpAttributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<AsVariantProduct> {
      final VpAttribute.Mapper vpAttributeFieldMapper = new VpAttribute.Mapper();

      @Override
      public AsVariantProduct map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final List<VpAttribute> vpAttributes = reader.readList($responseFields[5], new ResponseReader.ListReader<VpAttribute>() {
          @Override
          public VpAttribute read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<VpAttribute>() {
              @Override
              public VpAttribute read(ResponseReader reader) {
                return vpAttributeFieldMapper.map(reader);
              }
            });
          }
        });
        return new AsVariantProduct(__typename, id, ref, type, status, vpAttributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable List<VpAttribute> vpAttributes;

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

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder vpAttributes(@Nullable List<VpAttribute> vpAttributes) {
        this.vpAttributes = vpAttributes;
        return this;
      }

      public Builder vpAttributes(@Nonnull Mutator<List<VpAttribute.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<VpAttribute.Builder> builders = new ArrayList<>();
        if (this.vpAttributes != null) {
          for (VpAttribute item : this.vpAttributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<VpAttribute> vpAttributes = new ArrayList<>();
        for (VpAttribute.Builder item : builders) {
          vpAttributes.add(item != null ? item.build() : null);
        }
        this.vpAttributes = vpAttributes;
        return this;
      }

      public AsVariantProduct build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        Utils.checkNotNull(type, "type == null");
        return new AsVariantProduct(__typename, id, ref, type, status, vpAttributes);
      }
    }
  }

  public static class VpAttribute {
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

    public VpAttribute(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
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
        $toString = "VpAttribute{"
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
      if (o instanceof VpAttribute) {
        VpAttribute that = (VpAttribute) o;
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

    public static final class Mapper implements ResponseFieldMapper<VpAttribute> {
      @Override
      public VpAttribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new VpAttribute(__typename, name, type, value);
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

      public VpAttribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new VpAttribute(__typename, name, type, value);
      }
    }
  }

  public static class AsStandardProduct {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("spAttributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable List<SpAttribute> spAttributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public AsStandardProduct(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref,
        @Nonnull String type, @Nullable String status, @Nullable List<SpAttribute> spAttributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.spAttributes = spAttributes;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  ID of the object. For internal use, should not be used externally or by any business logic
     */
    public @Nonnull String id() {
      return this.id;
    }

    /**
     *  The unique reference identifier for the Product
     */
    public @Nonnull String ref() {
      return this.ref;
    }

    /**
     *  Type of the `StandardProduct`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  The current status of the `StandardProduct`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  A list of attributes associated with this Product. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public @Nullable List<SpAttribute> spAttributes() {
      return this.spAttributes;
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
          writer.writeList($responseFields[5], spAttributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((SpAttribute) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AsStandardProduct{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "spAttributes=" + spAttributes
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AsStandardProduct) {
        AsStandardProduct that = (AsStandardProduct) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.ref.equals(that.ref)
         && this.type.equals(that.type)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.spAttributes == null) ? (that.spAttributes == null) : this.spAttributes.equals(that.spAttributes));
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
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (spAttributes == null) ? 0 : spAttributes.hashCode();
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
      builder.spAttributes = spAttributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<AsStandardProduct> {
      final SpAttribute.Mapper spAttributeFieldMapper = new SpAttribute.Mapper();

      @Override
      public AsStandardProduct map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final List<SpAttribute> spAttributes = reader.readList($responseFields[5], new ResponseReader.ListReader<SpAttribute>() {
          @Override
          public SpAttribute read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<SpAttribute>() {
              @Override
              public SpAttribute read(ResponseReader reader) {
                return spAttributeFieldMapper.map(reader);
              }
            });
          }
        });
        return new AsStandardProduct(__typename, id, ref, type, status, spAttributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable List<SpAttribute> spAttributes;

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

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder spAttributes(@Nullable List<SpAttribute> spAttributes) {
        this.spAttributes = spAttributes;
        return this;
      }

      public Builder spAttributes(@Nonnull Mutator<List<SpAttribute.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<SpAttribute.Builder> builders = new ArrayList<>();
        if (this.spAttributes != null) {
          for (SpAttribute item : this.spAttributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<SpAttribute> spAttributes = new ArrayList<>();
        for (SpAttribute.Builder item : builders) {
          spAttributes.add(item != null ? item.build() : null);
        }
        this.spAttributes = spAttributes;
        return this;
      }

      public AsStandardProduct build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        Utils.checkNotNull(type, "type == null");
        return new AsStandardProduct(__typename, id, ref, type, status, spAttributes);
      }
    }
  }

  public static class SpAttribute {
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

    public SpAttribute(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
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
        $toString = "SpAttribute{"
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
      if (o instanceof SpAttribute) {
        SpAttribute that = (SpAttribute) o;
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

    public static final class Mapper implements ResponseFieldMapper<SpAttribute> {
      @Override
      public SpAttribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new SpAttribute(__typename, name, type, value);
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

      public SpAttribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new SpAttribute(__typename, name, type, value);
      }
    }
  }

  public static class OrderItemAttribute {
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

    public OrderItemAttribute(@Nonnull String __typename, @Nonnull String name,
        @Nonnull String type, @Nonnull Object value) {
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
        $toString = "OrderItemAttribute{"
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
      if (o instanceof OrderItemAttribute) {
        OrderItemAttribute that = (OrderItemAttribute) o;
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

    public static final class Mapper implements ResponseFieldMapper<OrderItemAttribute> {
      @Override
      public OrderItemAttribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new OrderItemAttribute(__typename, name, type, value);
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

      public OrderItemAttribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new OrderItemAttribute(__typename, name, type, value);
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

  public static class FromLocation {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String ref;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FromLocation(@Nonnull String __typename, @Nullable String ref) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = ref;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

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
        $toString = "FromLocation{"
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
      if (o instanceof FromLocation) {
        FromLocation that = (FromLocation) o;
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

    public static final class Mapper implements ResponseFieldMapper<FromLocation> {
      @Override
      public FromLocation map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        return new FromLocation(__typename, ref);
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

      public FromLocation build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FromLocation(__typename, ref);
      }
    }
  }

  public static class FromAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("companyName", "companyName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("street", "street", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("city", "city", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("state", "state", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("postcode", "postcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("region", "region", null, true, Collections.<ResponseField.Condition>emptyList()),
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

    final @Nullable String country;

    final @Nullable String state;

    final @Nullable String postcode;

    final @Nullable String region;

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    final @Nullable String timeZone;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FromAddress(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String type, @Nullable String companyName, @Nullable String name,
        @Nullable String street, @Nullable String city, @Nullable String country,
        @Nullable String state, @Nullable String postcode, @Nullable String region,
        @Nullable Double latitude, @Nullable Double longitude, @Nullable String timeZone) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = type;
      this.companyName = companyName;
      this.name = name;
      this.street = street;
      this.city = city;
      this.country = country;
      this.state = state;
      this.postcode = postcode;
      this.region = region;
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
     *  Country
     */
    public @Nullable String country() {
      return this.country;
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
          writer.writeString($responseFields[8], country);
          writer.writeString($responseFields[9], state);
          writer.writeString($responseFields[10], postcode);
          writer.writeString($responseFields[11], region);
          writer.writeDouble($responseFields[12], latitude);
          writer.writeDouble($responseFields[13], longitude);
          writer.writeString($responseFields[14], timeZone);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FromAddress{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "companyName=" + companyName + ", "
          + "name=" + name + ", "
          + "street=" + street + ", "
          + "city=" + city + ", "
          + "country=" + country + ", "
          + "state=" + state + ", "
          + "postcode=" + postcode + ", "
          + "region=" + region + ", "
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
      if (o instanceof FromAddress) {
        FromAddress that = (FromAddress) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         && ((this.companyName == null) ? (that.companyName == null) : this.companyName.equals(that.companyName))
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.street == null) ? (that.street == null) : this.street.equals(that.street))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
         && ((this.state == null) ? (that.state == null) : this.state.equals(that.state))
         && ((this.postcode == null) ? (that.postcode == null) : this.postcode.equals(that.postcode))
         && ((this.region == null) ? (that.region == null) : this.region.equals(that.region))
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
        h ^= (country == null) ? 0 : country.hashCode();
        h *= 1000003;
        h ^= (state == null) ? 0 : state.hashCode();
        h *= 1000003;
        h ^= (postcode == null) ? 0 : postcode.hashCode();
        h *= 1000003;
        h ^= (region == null) ? 0 : region.hashCode();
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
      builder.country = country;
      builder.state = state;
      builder.postcode = postcode;
      builder.region = region;
      builder.latitude = latitude;
      builder.longitude = longitude;
      builder.timeZone = timeZone;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FromAddress> {
      @Override
      public FromAddress map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String companyName = reader.readString($responseFields[4]);
        final String name = reader.readString($responseFields[5]);
        final String street = reader.readString($responseFields[6]);
        final String city = reader.readString($responseFields[7]);
        final String country = reader.readString($responseFields[8]);
        final String state = reader.readString($responseFields[9]);
        final String postcode = reader.readString($responseFields[10]);
        final String region = reader.readString($responseFields[11]);
        final Double latitude = reader.readDouble($responseFields[12]);
        final Double longitude = reader.readDouble($responseFields[13]);
        final String timeZone = reader.readString($responseFields[14]);
        return new FromAddress(__typename, id, ref, type, companyName, name, street, city, country, state, postcode, region, latitude, longitude, timeZone);
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

      private @Nullable String country;

      private @Nullable String state;

      private @Nullable String postcode;

      private @Nullable String region;

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

      public Builder country(@Nullable String country) {
        this.country = country;
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

      public FromAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new FromAddress(__typename, id, ref, type, companyName, name, street, city, country, state, postcode, region, latitude, longitude, timeZone);
      }
    }
  }

  public static class ToAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("companyName", "companyName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("street", "street", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("city", "city", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("state", "state", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("postcode", "postcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("region", "region", null, true, Collections.<ResponseField.Condition>emptyList()),
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

    final @Nullable String country;

    final @Nullable String state;

    final @Nullable String postcode;

    final @Nullable String region;

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    final @Nullable String timeZone;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ToAddress(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String type, @Nullable String companyName, @Nullable String name,
        @Nullable String street, @Nullable String city, @Nullable String country,
        @Nullable String state, @Nullable String postcode, @Nullable String region,
        @Nullable Double latitude, @Nullable Double longitude, @Nullable String timeZone) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = type;
      this.companyName = companyName;
      this.name = name;
      this.street = street;
      this.city = city;
      this.country = country;
      this.state = state;
      this.postcode = postcode;
      this.region = region;
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
     *  Country
     */
    public @Nullable String country() {
      return this.country;
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
          writer.writeString($responseFields[8], country);
          writer.writeString($responseFields[9], state);
          writer.writeString($responseFields[10], postcode);
          writer.writeString($responseFields[11], region);
          writer.writeDouble($responseFields[12], latitude);
          writer.writeDouble($responseFields[13], longitude);
          writer.writeString($responseFields[14], timeZone);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ToAddress{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "companyName=" + companyName + ", "
          + "name=" + name + ", "
          + "street=" + street + ", "
          + "city=" + city + ", "
          + "country=" + country + ", "
          + "state=" + state + ", "
          + "postcode=" + postcode + ", "
          + "region=" + region + ", "
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
      if (o instanceof ToAddress) {
        ToAddress that = (ToAddress) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         && ((this.companyName == null) ? (that.companyName == null) : this.companyName.equals(that.companyName))
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.street == null) ? (that.street == null) : this.street.equals(that.street))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
         && ((this.state == null) ? (that.state == null) : this.state.equals(that.state))
         && ((this.postcode == null) ? (that.postcode == null) : this.postcode.equals(that.postcode))
         && ((this.region == null) ? (that.region == null) : this.region.equals(that.region))
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
        h ^= (country == null) ? 0 : country.hashCode();
        h *= 1000003;
        h ^= (state == null) ? 0 : state.hashCode();
        h *= 1000003;
        h ^= (postcode == null) ? 0 : postcode.hashCode();
        h *= 1000003;
        h ^= (region == null) ? 0 : region.hashCode();
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
      builder.country = country;
      builder.state = state;
      builder.postcode = postcode;
      builder.region = region;
      builder.latitude = latitude;
      builder.longitude = longitude;
      builder.timeZone = timeZone;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ToAddress> {
      @Override
      public ToAddress map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String companyName = reader.readString($responseFields[4]);
        final String name = reader.readString($responseFields[5]);
        final String street = reader.readString($responseFields[6]);
        final String city = reader.readString($responseFields[7]);
        final String country = reader.readString($responseFields[8]);
        final String state = reader.readString($responseFields[9]);
        final String postcode = reader.readString($responseFields[10]);
        final String region = reader.readString($responseFields[11]);
        final Double latitude = reader.readDouble($responseFields[12]);
        final Double longitude = reader.readDouble($responseFields[13]);
        final String timeZone = reader.readString($responseFields[14]);
        return new ToAddress(__typename, id, ref, type, companyName, name, street, city, country, state, postcode, region, latitude, longitude, timeZone);
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

      private @Nullable String country;

      private @Nullable String state;

      private @Nullable String postcode;

      private @Nullable String region;

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

      public Builder country(@Nullable String country) {
        this.country = country;
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

      public ToAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new ToAddress(__typename, id, ref, type, companyName, name, street, city, country, state, postcode, region, latitude, longitude, timeZone);
      }
    }
  }

  public static class Order {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Order(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = Utils.checkNotNull(type, "type == null");
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], type);
          writer.writeString($responseFields[4], status);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Order{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
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
      if (o instanceof Order) {
        Order that = (Order) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.type.equals(that.type)
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
        h ^= type.hashCode();
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
      builder.type = type;
      builder.status = status;
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
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        return new Order(__typename, id, ref, type, status);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nonnull String type;

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

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Order build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Order(__typename, id, ref, type, status);
      }
    }
  }

  public static class Articles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("articleEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<ArticleEdge> articleEdge;

    final @Nullable PageInfo1 pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Articles(@Nonnull String __typename, @Nullable List<ArticleEdge> articleEdge,
        @Nullable PageInfo1 pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.articleEdge = articleEdge;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Article type node
     */
    public @Nullable List<ArticleEdge> articleEdge() {
      return this.articleEdge;
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
          writer.writeList($responseFields[1], articleEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((ArticleEdge) value).marshaller());
            }
          });
          writer.writeObject($responseFields[2], pageInfo != null ? pageInfo.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Articles{"
          + "__typename=" + __typename + ", "
          + "articleEdge=" + articleEdge + ", "
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
      if (o instanceof Articles) {
        Articles that = (Articles) o;
        return this.__typename.equals(that.__typename)
         && ((this.articleEdge == null) ? (that.articleEdge == null) : this.articleEdge.equals(that.articleEdge))
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
        h ^= (articleEdge == null) ? 0 : articleEdge.hashCode();
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
      builder.articleEdge = articleEdge;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Articles> {
      final ArticleEdge.Mapper articleEdgeFieldMapper = new ArticleEdge.Mapper();

      final PageInfo1.Mapper pageInfo1FieldMapper = new PageInfo1.Mapper();

      @Override
      public Articles map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<ArticleEdge> articleEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<ArticleEdge>() {
          @Override
          public ArticleEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<ArticleEdge>() {
              @Override
              public ArticleEdge read(ResponseReader reader) {
                return articleEdgeFieldMapper.map(reader);
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
        return new Articles(__typename, articleEdge, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<ArticleEdge> articleEdge;

      private @Nullable PageInfo1 pageInfo;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder articleEdge(@Nullable List<ArticleEdge> articleEdge) {
        this.articleEdge = articleEdge;
        return this;
      }

      public Builder pageInfo(@Nullable PageInfo1 pageInfo) {
        this.pageInfo = pageInfo;
        return this;
      }

      public Builder articleEdge(@Nonnull Mutator<List<ArticleEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<ArticleEdge.Builder> builders = new ArrayList<>();
        if (this.articleEdge != null) {
          for (ArticleEdge item : this.articleEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<ArticleEdge> articleEdge = new ArrayList<>();
        for (ArticleEdge.Builder item : builders) {
          articleEdge.add(item != null ? item.build() : null);
        }
        this.articleEdge = articleEdge;
        return this;
      }

      public Builder pageInfo(@Nonnull Mutator<PageInfo1.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo1.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo1.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public Articles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Articles(__typename, articleEdge, pageInfo);
      }
    }
  }

  public static class ArticleEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("articleNode", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable ArticleNode articleNode;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ArticleEdge(@Nonnull String __typename, @Nullable ArticleNode articleNode,
        @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.articleNode = articleNode;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Article edge
     */
    public @Nullable ArticleNode articleNode() {
      return this.articleNode;
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
          writer.writeObject($responseFields[1], articleNode != null ? articleNode.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ArticleEdge{"
          + "__typename=" + __typename + ", "
          + "articleNode=" + articleNode + ", "
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
      if (o instanceof ArticleEdge) {
        ArticleEdge that = (ArticleEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.articleNode == null) ? (that.articleNode == null) : this.articleNode.equals(that.articleNode))
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
        h ^= (articleNode == null) ? 0 : articleNode.hashCode();
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
      builder.articleNode = articleNode;
      builder.cursor = cursor;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ArticleEdge> {
      final ArticleNode.Mapper articleNodeFieldMapper = new ArticleNode.Mapper();

      @Override
      public ArticleEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final ArticleNode articleNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<ArticleNode>() {
          @Override
          public ArticleNode read(ResponseReader reader) {
            return articleNodeFieldMapper.map(reader);
          }
        });
        final String cursor = reader.readString($responseFields[2]);
        return new ArticleEdge(__typename, articleNode, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable ArticleNode articleNode;

      private @Nullable String cursor;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder articleNode(@Nullable ArticleNode articleNode) {
        this.articleNode = articleNode;
        return this;
      }

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
        return this;
      }

      public Builder articleNode(@Nonnull Mutator<ArticleNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ArticleNode.Builder builder = this.articleNode != null ? this.articleNode.toBuilder() : ArticleNode.builder();
        mutator.accept(builder);
        this.articleNode = builder.build();
        return this;
      }

      public ArticleEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ArticleEdge(__typename, articleNode, cursor);
      }
    }
  }

  public static class ArticleNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("height", "height", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("weight", "weight", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("width", "width", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("length", "length", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("consignmentArticles", "consignmentArticles", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String name;

    final @Nonnull String type;

    final @Nullable String status;

    final double height;

    final double weight;

    final double width;

    final double length;

    final @Nullable Integer quantity;

    final @Nullable ConsignmentArticles consignmentArticles;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ArticleNode(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String name, @Nonnull String type, @Nullable String status, double height,
        double weight, double width, double length, @Nullable Integer quantity,
        @Nullable ConsignmentArticles consignmentArticles) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.name = name;
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.height = height;
      this.weight = weight;
      this.width = width;
      this.length = length;
      this.quantity = quantity;
      this.consignmentArticles = consignmentArticles;
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
     *  The unique article reference provided by the retailer
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  Name
     */
    public @Nullable String name() {
      return this.name;
    }

    /**
     *  Type of the `Article`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  The current status of the `Article`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Height
     */
    public double height() {
      return this.height;
    }

    /**
     *  Weight
     */
    public double weight() {
      return this.weight;
    }

    /**
     *  Width
     */
    public double width() {
      return this.width;
    }

    /**
     *  Length
     */
    public double length() {
      return this.length;
    }

    /**
     *  Quantity
     */
    public @Nullable Integer quantity() {
      return this.quantity;
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
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], name);
          writer.writeString($responseFields[4], type);
          writer.writeString($responseFields[5], status);
          writer.writeDouble($responseFields[6], height);
          writer.writeDouble($responseFields[7], weight);
          writer.writeDouble($responseFields[8], width);
          writer.writeDouble($responseFields[9], length);
          writer.writeInt($responseFields[10], quantity);
          writer.writeObject($responseFields[11], consignmentArticles != null ? consignmentArticles.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ArticleNode{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "name=" + name + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "height=" + height + ", "
          + "weight=" + weight + ", "
          + "width=" + width + ", "
          + "length=" + length + ", "
          + "quantity=" + quantity + ", "
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
      if (o instanceof ArticleNode) {
        ArticleNode that = (ArticleNode) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && this.type.equals(that.type)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && Double.doubleToLongBits(this.height) == Double.doubleToLongBits(that.height)
         && Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(that.weight)
         && Double.doubleToLongBits(this.width) == Double.doubleToLongBits(that.width)
         && Double.doubleToLongBits(this.length) == Double.doubleToLongBits(that.length)
         && ((this.quantity == null) ? (that.quantity == null) : this.quantity.equals(that.quantity))
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
        h ^= id.hashCode();
        h *= 1000003;
        h ^= (ref == null) ? 0 : ref.hashCode();
        h *= 1000003;
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= Double.valueOf(height).hashCode();
        h *= 1000003;
        h ^= Double.valueOf(weight).hashCode();
        h *= 1000003;
        h ^= Double.valueOf(width).hashCode();
        h *= 1000003;
        h ^= Double.valueOf(length).hashCode();
        h *= 1000003;
        h ^= (quantity == null) ? 0 : quantity.hashCode();
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
      builder.id = id;
      builder.ref = ref;
      builder.name = name;
      builder.type = type;
      builder.status = status;
      builder.height = height;
      builder.weight = weight;
      builder.width = width;
      builder.length = length;
      builder.quantity = quantity;
      builder.consignmentArticles = consignmentArticles;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ArticleNode> {
      final ConsignmentArticles.Mapper consignmentArticlesFieldMapper = new ConsignmentArticles.Mapper();

      @Override
      public ArticleNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String name = reader.readString($responseFields[3]);
        final String type = reader.readString($responseFields[4]);
        final String status = reader.readString($responseFields[5]);
        final double height = reader.readDouble($responseFields[6]);
        final double weight = reader.readDouble($responseFields[7]);
        final double width = reader.readDouble($responseFields[8]);
        final double length = reader.readDouble($responseFields[9]);
        final Integer quantity = reader.readInt($responseFields[10]);
        final ConsignmentArticles consignmentArticles = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<ConsignmentArticles>() {
          @Override
          public ConsignmentArticles read(ResponseReader reader) {
            return consignmentArticlesFieldMapper.map(reader);
          }
        });
        return new ArticleNode(__typename, id, ref, name, type, status, height, weight, width, length, quantity, consignmentArticles);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String name;

      private @Nonnull String type;

      private @Nullable String status;

      private double height;

      private double weight;

      private double width;

      private double length;

      private @Nullable Integer quantity;

      private @Nullable ConsignmentArticles consignmentArticles;

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

      public Builder name(@Nullable String name) {
        this.name = name;
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

      public Builder height(double height) {
        this.height = height;
        return this;
      }

      public Builder weight(double weight) {
        this.weight = weight;
        return this;
      }

      public Builder width(double width) {
        this.width = width;
        return this;
      }

      public Builder length(double length) {
        this.length = length;
        return this;
      }

      public Builder quantity(@Nullable Integer quantity) {
        this.quantity = quantity;
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

      public ArticleNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new ArticleNode(__typename, id, ref, name, type, status, height, weight, width, length, quantity, consignmentArticles);
      }
    }
  }

  public static class ConsignmentArticles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("consignmentEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<ConsignmentEdge> consignmentEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ConsignmentArticles(@Nonnull String __typename,
        @Nullable List<ConsignmentEdge> consignmentEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.consignmentEdge = consignmentEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to ConsignmentArticle type node
     */
    public @Nullable List<ConsignmentEdge> consignmentEdge() {
      return this.consignmentEdge;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], consignmentEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((ConsignmentEdge) value).marshaller());
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
          + "consignmentEdge=" + consignmentEdge
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
         && ((this.consignmentEdge == null) ? (that.consignmentEdge == null) : this.consignmentEdge.equals(that.consignmentEdge));
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
        h ^= (consignmentEdge == null) ? 0 : consignmentEdge.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.consignmentEdge = consignmentEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ConsignmentArticles> {
      final ConsignmentEdge.Mapper consignmentEdgeFieldMapper = new ConsignmentEdge.Mapper();

      @Override
      public ConsignmentArticles map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<ConsignmentEdge> consignmentEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<ConsignmentEdge>() {
          @Override
          public ConsignmentEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<ConsignmentEdge>() {
              @Override
              public ConsignmentEdge read(ResponseReader reader) {
                return consignmentEdgeFieldMapper.map(reader);
              }
            });
          }
        });
        return new ConsignmentArticles(__typename, consignmentEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<ConsignmentEdge> consignmentEdge;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder consignmentEdge(@Nullable List<ConsignmentEdge> consignmentEdge) {
        this.consignmentEdge = consignmentEdge;
        return this;
      }

      public Builder consignmentEdge(@Nonnull Mutator<List<ConsignmentEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<ConsignmentEdge.Builder> builders = new ArrayList<>();
        if (this.consignmentEdge != null) {
          for (ConsignmentEdge item : this.consignmentEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<ConsignmentEdge> consignmentEdge = new ArrayList<>();
        for (ConsignmentEdge.Builder item : builders) {
          consignmentEdge.add(item != null ? item.build() : null);
        }
        this.consignmentEdge = consignmentEdge;
        return this;
      }

      public ConsignmentArticles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ConsignmentArticles(__typename, consignmentEdge);
      }
    }
  }

  public static class ConsignmentEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("consignmentNode", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable ConsignmentNode consignmentNode;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ConsignmentEdge(@Nonnull String __typename, @Nullable ConsignmentNode consignmentNode) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.consignmentNode = consignmentNode;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the ConsignmentArticle edge
     */
    public @Nullable ConsignmentNode consignmentNode() {
      return this.consignmentNode;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], consignmentNode != null ? consignmentNode.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ConsignmentEdge{"
          + "__typename=" + __typename + ", "
          + "consignmentNode=" + consignmentNode
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ConsignmentEdge) {
        ConsignmentEdge that = (ConsignmentEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.consignmentNode == null) ? (that.consignmentNode == null) : this.consignmentNode.equals(that.consignmentNode));
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
        h ^= (consignmentNode == null) ? 0 : consignmentNode.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.consignmentNode = consignmentNode;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ConsignmentEdge> {
      final ConsignmentNode.Mapper consignmentNodeFieldMapper = new ConsignmentNode.Mapper();

      @Override
      public ConsignmentEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final ConsignmentNode consignmentNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<ConsignmentNode>() {
          @Override
          public ConsignmentNode read(ResponseReader reader) {
            return consignmentNodeFieldMapper.map(reader);
          }
        });
        return new ConsignmentEdge(__typename, consignmentNode);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable ConsignmentNode consignmentNode;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder consignmentNode(@Nullable ConsignmentNode consignmentNode) {
        this.consignmentNode = consignmentNode;
        return this;
      }

      public Builder consignmentNode(@Nonnull Mutator<ConsignmentNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ConsignmentNode.Builder builder = this.consignmentNode != null ? this.consignmentNode.toBuilder() : ConsignmentNode.builder();
        mutator.accept(builder);
        this.consignmentNode = builder.build();
        return this;
      }

      public ConsignmentEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ConsignmentEdge(__typename, consignmentNode);
      }
    }
  }

  public static class ConsignmentNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("consignment", "consignment", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Consignment consignment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ConsignmentNode(@Nonnull String __typename, @Nullable Consignment consignment) {
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
        $toString = "ConsignmentNode{"
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
      if (o instanceof ConsignmentNode) {
        ConsignmentNode that = (ConsignmentNode) o;
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

    public static final class Mapper implements ResponseFieldMapper<ConsignmentNode> {
      final Consignment.Mapper consignmentFieldMapper = new Consignment.Mapper();

      @Override
      public ConsignmentNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Consignment consignment = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Consignment>() {
          @Override
          public Consignment read(ResponseReader reader) {
            return consignmentFieldMapper.map(reader);
          }
        });
        return new ConsignmentNode(__typename, consignment);
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

      public ConsignmentNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ConsignmentNode(__typename, consignment);
      }
    }
  }

  public static class Consignment {
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

    public Consignment(@Nonnull String __typename, @Nonnull String id, @Nullable String ref) {
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
     *  External reference of the object. Recommended to be unique.
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
        $toString = "Consignment{"
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
      if (o instanceof Consignment) {
        Consignment that = (Consignment) o;
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

    public static final class Mapper implements ResponseFieldMapper<Consignment> {
      @Override
      public Consignment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        return new Consignment(__typename, id, ref);
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

      public Consignment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Consignment(__typename, id, ref);
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
