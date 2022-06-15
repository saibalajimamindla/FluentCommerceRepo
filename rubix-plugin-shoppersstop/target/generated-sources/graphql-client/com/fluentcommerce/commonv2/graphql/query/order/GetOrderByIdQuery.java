package com.fluentcommerce.commonv2.graphql.query.order;

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
public final class GetOrderByIdQuery implements Query<GetOrderByIdQuery.Data, GetOrderByIdQuery.Data, GetOrderByIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetOrderById($id: ID!, $includeOrderAttributes: Boolean!, $includeOrderProductAttributes: Boolean!, $includeFulfilmentChoice: Boolean!, $includeCustomer: Boolean!, $includeOrderItems: Boolean!, $includeFulfilments: Boolean!, $includeFulfilmentAttributes: Boolean!, $includeFulfilmentItems: Boolean!, $includeFulfilmentOrderItems: Boolean!, $orderItemCount: Int, $orderItemCursor: String, $fulfilmentCount: Int, $fulfilmentCursor: String, $fulfilmentItemCount: Int, $fulfilmentItemCursor: String) {\n"
      + "  orderById(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    type\n"
      + "    status\n"
      + "    createdOn\n"
      + "    updatedOn\n"
      + "    totalPrice\n"
      + "    totalTaxPrice\n"
      + "    orderItems: items(first: $orderItemCount, after: $orderItemCursor) @include(if: $includeOrderItems) {\n"
      + "      __typename\n"
      + "      orderItemEdge: edges {\n"
      + "        __typename\n"
      + "        orderItemNode: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "          quantity\n"
      + "          price\n"
      + "          paidPrice\n"
      + "          taxPrice\n"
      + "          taxType\n"
      + "          totalPrice\n"
      + "          totalTaxPrice\n"
      + "          currency\n"
      + "          orderItemProduct: product {\n"
      + "            __typename\n"
      + "            ... on VariantProduct {\n"
      + "              id\n"
      + "              ref\n"
      + "              type\n"
      + "              status\n"
      + "              orderVpAttributes: attributes @include(if: $includeOrderProductAttributes) {\n"
      + "                __typename\n"
      + "                name\n"
      + "                type\n"
      + "                value\n"
      + "              }\n"
      + "            }\n"
      + "            ... on StandardProduct {\n"
      + "              id\n"
      + "              ref\n"
      + "              type\n"
      + "              status\n"
      + "              orderSpAttributes: attributes @include(if: $includeOrderProductAttributes) {\n"
      + "                __typename\n"
      + "                name\n"
      + "                type\n"
      + "                value\n"
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
      + "    fulfilments(first: $fulfilmentCount, after: $fulfilmentCursor) @include(if: $includeFulfilments) {\n"
      + "      __typename\n"
      + "      fulfilmentEdges: edges {\n"
      + "        __typename\n"
      + "        fulfilmentNode: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "          type\n"
      + "          status\n"
      + "          type\n"
      + "          deliveryType\n"
      + "          createdOn\n"
      + "          updatedOn\n"
      + "          fromLocation {\n"
      + "            __typename\n"
      + "            ref\n"
      + "          }\n"
      + "          fulfilmentAttributes: attributes @include(if: $includeFulfilmentAttributes) {\n"
      + "            __typename\n"
      + "            name\n"
      + "            value\n"
      + "            type\n"
      + "          }\n"
      + "          fromAddress {\n"
      + "            __typename\n"
      + "            ref\n"
      + "            id\n"
      + "            name\n"
      + "          }\n"
      + "          toAddress {\n"
      + "            __typename\n"
      + "            ref\n"
      + "            id\n"
      + "          }\n"
      + "          fulfilmentItems: items(first: $fulfilmentItemCount, after: $fulfilmentItemCursor) @include(if: $includeFulfilmentItems) {\n"
      + "            __typename\n"
      + "            fulfilmentItemEdges: edges {\n"
      + "              __typename\n"
      + "              fulfilmentItemNode: node {\n"
      + "                __typename\n"
      + "                id\n"
      + "                ref\n"
      + "                requestedQuantity\n"
      + "                filledQuantity\n"
      + "                rejectedQuantity\n"
      + "                fulfilmentOrderItem: orderItem @include(if: $includeFulfilmentOrderItems) {\n"
      + "                  __typename\n"
      + "                  id\n"
      + "                  ref\n"
      + "                  quantity\n"
      + "                  fulfilmentOrderItemProduct: product {\n"
      + "                    __typename\n"
      + "                    ... on VariantProduct {\n"
      + "                      id\n"
      + "                      ref\n"
      + "                    }\n"
      + "                    ... on StandardProduct {\n"
      + "                      id\n"
      + "                      ref\n"
      + "                    }\n"
      + "                  }\n"
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
      + "    customer @include(if: $includeCustomer) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "      title\n"
      + "      country\n"
      + "      firstName\n"
      + "      lastName\n"
      + "      username\n"
      + "      primaryEmail\n"
      + "      primaryPhone\n"
      + "    }\n"
      + "    orderAttributes: attributes @include(if: $includeOrderAttributes) {\n"
      + "      __typename\n"
      + "      name\n"
      + "      value\n"
      + "      type\n"
      + "    }\n"
      + "    fulfilmentChoice @include(if: $includeFulfilmentChoice) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      createdOn\n"
      + "      updatedOn\n"
      + "      currency\n"
      + "      deliveryInstruction\n"
      + "      fulfilmentPrice\n"
      + "      deliveryType\n"
      + "      fulfilmentPrice\n"
      + "      fulfilmentType\n"
      + "      fulfilmentTaxPrice\n"
      + "      pickupLocationRef\n"
      + "      deliveryAddress {\n"
      + "        __typename\n"
      + "        id\n"
      + "        type\n"
      + "        companyName\n"
      + "        name\n"
      + "        street\n"
      + "        city\n"
      + "        state\n"
      + "        postcode\n"
      + "        region\n"
      + "        country\n"
      + "        region\n"
      + "        ref\n"
      + "        latitude\n"
      + "        longitude\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetOrderById";
    }
  };

  private final GetOrderByIdQuery.Variables variables;

  public GetOrderByIdQuery(@Nonnull String id, boolean includeOrderAttributes,
      boolean includeOrderProductAttributes, boolean includeFulfilmentChoice,
      boolean includeCustomer, boolean includeOrderItems, boolean includeFulfilments,
      boolean includeFulfilmentAttributes, boolean includeFulfilmentItems,
      boolean includeFulfilmentOrderItems, @Nullable Integer orderItemCount,
      @Nullable String orderItemCursor, @Nullable Integer fulfilmentCount,
      @Nullable String fulfilmentCursor, @Nullable Integer fulfilmentItemCount,
      @Nullable String fulfilmentItemCursor) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetOrderByIdQuery.Variables(id, includeOrderAttributes, includeOrderProductAttributes, includeFulfilmentChoice, includeCustomer, includeOrderItems, includeFulfilments, includeFulfilmentAttributes, includeFulfilmentItems, includeFulfilmentOrderItems, orderItemCount, orderItemCursor, fulfilmentCount, fulfilmentCursor, fulfilmentItemCount, fulfilmentItemCursor);
  }

  @Override
  public String operationId() {
    return "9eeadaa18391dddbfdd874bcc15863cc0bff549fa95f0cc44970d9bb3749680e";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetOrderByIdQuery.Data wrapData(GetOrderByIdQuery.Data data) {
    return data;
  }

  @Override
  public GetOrderByIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetOrderByIdQuery.Data> responseFieldMapper() {
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

    private boolean includeOrderAttributes;

    private boolean includeOrderProductAttributes;

    private boolean includeFulfilmentChoice;

    private boolean includeCustomer;

    private boolean includeOrderItems;

    private boolean includeFulfilments;

    private boolean includeFulfilmentAttributes;

    private boolean includeFulfilmentItems;

    private boolean includeFulfilmentOrderItems;

    private @Nullable Integer orderItemCount;

    private @Nullable String orderItemCursor;

    private @Nullable Integer fulfilmentCount;

    private @Nullable String fulfilmentCursor;

    private @Nullable Integer fulfilmentItemCount;

    private @Nullable String fulfilmentItemCursor;

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public Builder includeOrderAttributes(boolean includeOrderAttributes) {
      this.includeOrderAttributes = includeOrderAttributes;
      return this;
    }

    public Builder includeOrderProductAttributes(boolean includeOrderProductAttributes) {
      this.includeOrderProductAttributes = includeOrderProductAttributes;
      return this;
    }

    public Builder includeFulfilmentChoice(boolean includeFulfilmentChoice) {
      this.includeFulfilmentChoice = includeFulfilmentChoice;
      return this;
    }

    public Builder includeCustomer(boolean includeCustomer) {
      this.includeCustomer = includeCustomer;
      return this;
    }

    public Builder includeOrderItems(boolean includeOrderItems) {
      this.includeOrderItems = includeOrderItems;
      return this;
    }

    public Builder includeFulfilments(boolean includeFulfilments) {
      this.includeFulfilments = includeFulfilments;
      return this;
    }

    public Builder includeFulfilmentAttributes(boolean includeFulfilmentAttributes) {
      this.includeFulfilmentAttributes = includeFulfilmentAttributes;
      return this;
    }

    public Builder includeFulfilmentItems(boolean includeFulfilmentItems) {
      this.includeFulfilmentItems = includeFulfilmentItems;
      return this;
    }

    public Builder includeFulfilmentOrderItems(boolean includeFulfilmentOrderItems) {
      this.includeFulfilmentOrderItems = includeFulfilmentOrderItems;
      return this;
    }

    public Builder orderItemCount(@Nullable Integer orderItemCount) {
      this.orderItemCount = orderItemCount;
      return this;
    }

    public Builder orderItemCursor(@Nullable String orderItemCursor) {
      this.orderItemCursor = orderItemCursor;
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

    public Builder fulfilmentItemCount(@Nullable Integer fulfilmentItemCount) {
      this.fulfilmentItemCount = fulfilmentItemCount;
      return this;
    }

    public Builder fulfilmentItemCursor(@Nullable String fulfilmentItemCursor) {
      this.fulfilmentItemCursor = fulfilmentItemCursor;
      return this;
    }

    public GetOrderByIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetOrderByIdQuery(id, includeOrderAttributes, includeOrderProductAttributes, includeFulfilmentChoice, includeCustomer, includeOrderItems, includeFulfilments, includeFulfilmentAttributes, includeFulfilmentItems, includeFulfilmentOrderItems, orderItemCount, orderItemCursor, fulfilmentCount, fulfilmentCursor, fulfilmentItemCount, fulfilmentItemCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final boolean includeOrderAttributes;

    private final boolean includeOrderProductAttributes;

    private final boolean includeFulfilmentChoice;

    private final boolean includeCustomer;

    private final boolean includeOrderItems;

    private final boolean includeFulfilments;

    private final boolean includeFulfilmentAttributes;

    private final boolean includeFulfilmentItems;

    private final boolean includeFulfilmentOrderItems;

    private final @Nullable Integer orderItemCount;

    private final @Nullable String orderItemCursor;

    private final @Nullable Integer fulfilmentCount;

    private final @Nullable String fulfilmentCursor;

    private final @Nullable Integer fulfilmentItemCount;

    private final @Nullable String fulfilmentItemCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, boolean includeOrderAttributes,
        boolean includeOrderProductAttributes, boolean includeFulfilmentChoice,
        boolean includeCustomer, boolean includeOrderItems, boolean includeFulfilments,
        boolean includeFulfilmentAttributes, boolean includeFulfilmentItems,
        boolean includeFulfilmentOrderItems, @Nullable Integer orderItemCount,
        @Nullable String orderItemCursor, @Nullable Integer fulfilmentCount,
        @Nullable String fulfilmentCursor, @Nullable Integer fulfilmentItemCount,
        @Nullable String fulfilmentItemCursor) {
      this.id = id;
      this.includeOrderAttributes = includeOrderAttributes;
      this.includeOrderProductAttributes = includeOrderProductAttributes;
      this.includeFulfilmentChoice = includeFulfilmentChoice;
      this.includeCustomer = includeCustomer;
      this.includeOrderItems = includeOrderItems;
      this.includeFulfilments = includeFulfilments;
      this.includeFulfilmentAttributes = includeFulfilmentAttributes;
      this.includeFulfilmentItems = includeFulfilmentItems;
      this.includeFulfilmentOrderItems = includeFulfilmentOrderItems;
      this.orderItemCount = orderItemCount;
      this.orderItemCursor = orderItemCursor;
      this.fulfilmentCount = fulfilmentCount;
      this.fulfilmentCursor = fulfilmentCursor;
      this.fulfilmentItemCount = fulfilmentItemCount;
      this.fulfilmentItemCursor = fulfilmentItemCursor;
      this.valueMap.put("id", id);
      this.valueMap.put("includeOrderAttributes", includeOrderAttributes);
      this.valueMap.put("includeOrderProductAttributes", includeOrderProductAttributes);
      this.valueMap.put("includeFulfilmentChoice", includeFulfilmentChoice);
      this.valueMap.put("includeCustomer", includeCustomer);
      this.valueMap.put("includeOrderItems", includeOrderItems);
      this.valueMap.put("includeFulfilments", includeFulfilments);
      this.valueMap.put("includeFulfilmentAttributes", includeFulfilmentAttributes);
      this.valueMap.put("includeFulfilmentItems", includeFulfilmentItems);
      this.valueMap.put("includeFulfilmentOrderItems", includeFulfilmentOrderItems);
      this.valueMap.put("orderItemCount", orderItemCount);
      this.valueMap.put("orderItemCursor", orderItemCursor);
      this.valueMap.put("fulfilmentCount", fulfilmentCount);
      this.valueMap.put("fulfilmentCursor", fulfilmentCursor);
      this.valueMap.put("fulfilmentItemCount", fulfilmentItemCount);
      this.valueMap.put("fulfilmentItemCursor", fulfilmentItemCursor);
    }

    public @Nonnull String id() {
      return id;
    }

    public boolean includeOrderAttributes() {
      return includeOrderAttributes;
    }

    public boolean includeOrderProductAttributes() {
      return includeOrderProductAttributes;
    }

    public boolean includeFulfilmentChoice() {
      return includeFulfilmentChoice;
    }

    public boolean includeCustomer() {
      return includeCustomer;
    }

    public boolean includeOrderItems() {
      return includeOrderItems;
    }

    public boolean includeFulfilments() {
      return includeFulfilments;
    }

    public boolean includeFulfilmentAttributes() {
      return includeFulfilmentAttributes;
    }

    public boolean includeFulfilmentItems() {
      return includeFulfilmentItems;
    }

    public boolean includeFulfilmentOrderItems() {
      return includeFulfilmentOrderItems;
    }

    public @Nullable Integer orderItemCount() {
      return orderItemCount;
    }

    public @Nullable String orderItemCursor() {
      return orderItemCursor;
    }

    public @Nullable Integer fulfilmentCount() {
      return fulfilmentCount;
    }

    public @Nullable String fulfilmentCursor() {
      return fulfilmentCursor;
    }

    public @Nullable Integer fulfilmentItemCount() {
      return fulfilmentItemCount;
    }

    public @Nullable String fulfilmentItemCursor() {
      return fulfilmentItemCursor;
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
          writer.writeBoolean("includeOrderAttributes", includeOrderAttributes);
          writer.writeBoolean("includeOrderProductAttributes", includeOrderProductAttributes);
          writer.writeBoolean("includeFulfilmentChoice", includeFulfilmentChoice);
          writer.writeBoolean("includeCustomer", includeCustomer);
          writer.writeBoolean("includeOrderItems", includeOrderItems);
          writer.writeBoolean("includeFulfilments", includeFulfilments);
          writer.writeBoolean("includeFulfilmentAttributes", includeFulfilmentAttributes);
          writer.writeBoolean("includeFulfilmentItems", includeFulfilmentItems);
          writer.writeBoolean("includeFulfilmentOrderItems", includeFulfilmentOrderItems);
          writer.writeInt("orderItemCount", orderItemCount);
          writer.writeString("orderItemCursor", orderItemCursor);
          writer.writeInt("fulfilmentCount", fulfilmentCount);
          writer.writeString("fulfilmentCursor", fulfilmentCursor);
          writer.writeInt("fulfilmentItemCount", fulfilmentItemCount);
          writer.writeString("fulfilmentItemCursor", fulfilmentItemCursor);
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
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("totalPrice", "totalPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("totalTaxPrice", "totalTaxPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("orderItems", "items", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "orderItemCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "orderItemCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeOrderItems", false))),
      ResponseField.forObject("fulfilments", "fulfilments", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeFulfilments", false))),
      ResponseField.forObject("customer", "customer", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeCustomer", false))),
      ResponseField.forList("orderAttributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeOrderAttributes", false))),
      ResponseField.forObject("fulfilmentChoice", "fulfilmentChoice", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeFulfilmentChoice", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable Double totalPrice;

    final @Nullable Double totalTaxPrice;

    final @Nullable OrderItems orderItems;

    final @Nullable Fulfilments fulfilments;

    final @Nullable Customer customer;

    final @Nullable List<OrderAttribute> orderAttributes;

    final @Nullable FulfilmentChoice fulfilmentChoice;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OrderById(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable Object createdOn,
        @Nullable Object updatedOn, @Nullable Double totalPrice, @Nullable Double totalTaxPrice,
        @Nullable OrderItems orderItems, @Nullable Fulfilments fulfilments,
        @Nullable Customer customer, @Nullable List<OrderAttribute> orderAttributes,
        @Nullable FulfilmentChoice fulfilmentChoice) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.totalPrice = totalPrice;
      this.totalTaxPrice = totalTaxPrice;
      this.orderItems = orderItems;
      this.fulfilments = fulfilments;
      this.customer = customer;
      this.orderAttributes = orderAttributes;
      this.fulfilmentChoice = fulfilmentChoice;
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

    /**
     *  Connection representing a list of `OrderItem`s
     */
    public @Nullable OrderItems orderItems() {
      return this.orderItems;
    }

    /**
     *  Connection representing a list of `Fulfilment`s
     */
    public @Nullable Fulfilments fulfilments() {
      return this.fulfilments;
    }

    /**
     *  `Customer` of the order
     */
    public @Nullable Customer customer() {
      return this.customer;
    }

    /**
     *  List of order `attribute`s
     */
    public @Nullable List<OrderAttribute> orderAttributes() {
      return this.orderAttributes;
    }

    /**
     *  The `FulfilmentChoice` specified when booking the order
     */
    public @Nullable FulfilmentChoice fulfilmentChoice() {
      return this.fulfilmentChoice;
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
          writer.writeDouble($responseFields[7], totalPrice);
          writer.writeDouble($responseFields[8], totalTaxPrice);
          writer.writeObject($responseFields[9], orderItems != null ? orderItems.marshaller() : null);
          writer.writeObject($responseFields[10], fulfilments != null ? fulfilments.marshaller() : null);
          writer.writeObject($responseFields[11], customer != null ? customer.marshaller() : null);
          writer.writeList($responseFields[12], orderAttributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((OrderAttribute) value).marshaller());
            }
          });
          writer.writeObject($responseFields[13], fulfilmentChoice != null ? fulfilmentChoice.marshaller() : null);
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
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "totalPrice=" + totalPrice + ", "
          + "totalTaxPrice=" + totalTaxPrice + ", "
          + "orderItems=" + orderItems + ", "
          + "fulfilments=" + fulfilments + ", "
          + "customer=" + customer + ", "
          + "orderAttributes=" + orderAttributes + ", "
          + "fulfilmentChoice=" + fulfilmentChoice
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
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.totalPrice == null) ? (that.totalPrice == null) : this.totalPrice.equals(that.totalPrice))
         && ((this.totalTaxPrice == null) ? (that.totalTaxPrice == null) : this.totalTaxPrice.equals(that.totalTaxPrice))
         && ((this.orderItems == null) ? (that.orderItems == null) : this.orderItems.equals(that.orderItems))
         && ((this.fulfilments == null) ? (that.fulfilments == null) : this.fulfilments.equals(that.fulfilments))
         && ((this.customer == null) ? (that.customer == null) : this.customer.equals(that.customer))
         && ((this.orderAttributes == null) ? (that.orderAttributes == null) : this.orderAttributes.equals(that.orderAttributes))
         && ((this.fulfilmentChoice == null) ? (that.fulfilmentChoice == null) : this.fulfilmentChoice.equals(that.fulfilmentChoice));
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
        h ^= (totalPrice == null) ? 0 : totalPrice.hashCode();
        h *= 1000003;
        h ^= (totalTaxPrice == null) ? 0 : totalTaxPrice.hashCode();
        h *= 1000003;
        h ^= (orderItems == null) ? 0 : orderItems.hashCode();
        h *= 1000003;
        h ^= (fulfilments == null) ? 0 : fulfilments.hashCode();
        h *= 1000003;
        h ^= (customer == null) ? 0 : customer.hashCode();
        h *= 1000003;
        h ^= (orderAttributes == null) ? 0 : orderAttributes.hashCode();
        h *= 1000003;
        h ^= (fulfilmentChoice == null) ? 0 : fulfilmentChoice.hashCode();
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
      builder.totalPrice = totalPrice;
      builder.totalTaxPrice = totalTaxPrice;
      builder.orderItems = orderItems;
      builder.fulfilments = fulfilments;
      builder.customer = customer;
      builder.orderAttributes = orderAttributes;
      builder.fulfilmentChoice = fulfilmentChoice;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OrderById> {
      final OrderItems.Mapper orderItemsFieldMapper = new OrderItems.Mapper();

      final Fulfilments.Mapper fulfilmentsFieldMapper = new Fulfilments.Mapper();

      final Customer.Mapper customerFieldMapper = new Customer.Mapper();

      final OrderAttribute.Mapper orderAttributeFieldMapper = new OrderAttribute.Mapper();

      final FulfilmentChoice.Mapper fulfilmentChoiceFieldMapper = new FulfilmentChoice.Mapper();

      @Override
      public OrderById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[6]);
        final Double totalPrice = reader.readDouble($responseFields[7]);
        final Double totalTaxPrice = reader.readDouble($responseFields[8]);
        final OrderItems orderItems = reader.readObject($responseFields[9], new ResponseReader.ObjectReader<OrderItems>() {
          @Override
          public OrderItems read(ResponseReader reader) {
            return orderItemsFieldMapper.map(reader);
          }
        });
        final Fulfilments fulfilments = reader.readObject($responseFields[10], new ResponseReader.ObjectReader<Fulfilments>() {
          @Override
          public Fulfilments read(ResponseReader reader) {
            return fulfilmentsFieldMapper.map(reader);
          }
        });
        final Customer customer = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<Customer>() {
          @Override
          public Customer read(ResponseReader reader) {
            return customerFieldMapper.map(reader);
          }
        });
        final List<OrderAttribute> orderAttributes = reader.readList($responseFields[12], new ResponseReader.ListReader<OrderAttribute>() {
          @Override
          public OrderAttribute read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<OrderAttribute>() {
              @Override
              public OrderAttribute read(ResponseReader reader) {
                return orderAttributeFieldMapper.map(reader);
              }
            });
          }
        });
        final FulfilmentChoice fulfilmentChoice = reader.readObject($responseFields[13], new ResponseReader.ObjectReader<FulfilmentChoice>() {
          @Override
          public FulfilmentChoice read(ResponseReader reader) {
            return fulfilmentChoiceFieldMapper.map(reader);
          }
        });
        return new OrderById(__typename, id, ref, type, status, createdOn, updatedOn, totalPrice, totalTaxPrice, orderItems, fulfilments, customer, orderAttributes, fulfilmentChoice);
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

      private @Nullable Double totalPrice;

      private @Nullable Double totalTaxPrice;

      private @Nullable OrderItems orderItems;

      private @Nullable Fulfilments fulfilments;

      private @Nullable Customer customer;

      private @Nullable List<OrderAttribute> orderAttributes;

      private @Nullable FulfilmentChoice fulfilmentChoice;

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

      public Builder totalPrice(@Nullable Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
      }

      public Builder totalTaxPrice(@Nullable Double totalTaxPrice) {
        this.totalTaxPrice = totalTaxPrice;
        return this;
      }

      public Builder orderItems(@Nullable OrderItems orderItems) {
        this.orderItems = orderItems;
        return this;
      }

      public Builder fulfilments(@Nullable Fulfilments fulfilments) {
        this.fulfilments = fulfilments;
        return this;
      }

      public Builder customer(@Nullable Customer customer) {
        this.customer = customer;
        return this;
      }

      public Builder orderAttributes(@Nullable List<OrderAttribute> orderAttributes) {
        this.orderAttributes = orderAttributes;
        return this;
      }

      public Builder fulfilmentChoice(@Nullable FulfilmentChoice fulfilmentChoice) {
        this.fulfilmentChoice = fulfilmentChoice;
        return this;
      }

      public Builder orderItems(@Nonnull Mutator<OrderItems.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        OrderItems.Builder builder = this.orderItems != null ? this.orderItems.toBuilder() : OrderItems.builder();
        mutator.accept(builder);
        this.orderItems = builder.build();
        return this;
      }

      public Builder fulfilments(@Nonnull Mutator<Fulfilments.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Fulfilments.Builder builder = this.fulfilments != null ? this.fulfilments.toBuilder() : Fulfilments.builder();
        mutator.accept(builder);
        this.fulfilments = builder.build();
        return this;
      }

      public Builder customer(@Nonnull Mutator<Customer.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Customer.Builder builder = this.customer != null ? this.customer.toBuilder() : Customer.builder();
        mutator.accept(builder);
        this.customer = builder.build();
        return this;
      }

      public Builder orderAttributes(@Nonnull Mutator<List<OrderAttribute.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<OrderAttribute.Builder> builders = new ArrayList<>();
        if (this.orderAttributes != null) {
          for (OrderAttribute item : this.orderAttributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<OrderAttribute> orderAttributes = new ArrayList<>();
        for (OrderAttribute.Builder item : builders) {
          orderAttributes.add(item != null ? item.build() : null);
        }
        this.orderAttributes = orderAttributes;
        return this;
      }

      public Builder fulfilmentChoice(@Nonnull Mutator<FulfilmentChoice.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentChoice.Builder builder = this.fulfilmentChoice != null ? this.fulfilmentChoice.toBuilder() : FulfilmentChoice.builder();
        mutator.accept(builder);
        this.fulfilmentChoice = builder.build();
        return this;
      }

      public OrderById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new OrderById(__typename, id, ref, type, status, createdOn, updatedOn, totalPrice, totalTaxPrice, orderItems, fulfilments, customer, orderAttributes, fulfilmentChoice);
      }
    }
  }

  public static class OrderItems {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("orderItemEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<OrderItemEdge> orderItemEdge;

    final @Nullable PageInfo pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OrderItems(@Nonnull String __typename, @Nullable List<OrderItemEdge> orderItemEdge,
        @Nullable PageInfo pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.orderItemEdge = orderItemEdge;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to OrderItem type node
     */
    public @Nullable List<OrderItemEdge> orderItemEdge() {
      return this.orderItemEdge;
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
          writer.writeList($responseFields[1], orderItemEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((OrderItemEdge) value).marshaller());
            }
          });
          writer.writeObject($responseFields[2], pageInfo != null ? pageInfo.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OrderItems{"
          + "__typename=" + __typename + ", "
          + "orderItemEdge=" + orderItemEdge + ", "
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
      if (o instanceof OrderItems) {
        OrderItems that = (OrderItems) o;
        return this.__typename.equals(that.__typename)
         && ((this.orderItemEdge == null) ? (that.orderItemEdge == null) : this.orderItemEdge.equals(that.orderItemEdge))
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
        h ^= (orderItemEdge == null) ? 0 : orderItemEdge.hashCode();
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
      builder.orderItemEdge = orderItemEdge;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OrderItems> {
      final OrderItemEdge.Mapper orderItemEdgeFieldMapper = new OrderItemEdge.Mapper();

      final PageInfo.Mapper pageInfoFieldMapper = new PageInfo.Mapper();

      @Override
      public OrderItems map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<OrderItemEdge> orderItemEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<OrderItemEdge>() {
          @Override
          public OrderItemEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<OrderItemEdge>() {
              @Override
              public OrderItemEdge read(ResponseReader reader) {
                return orderItemEdgeFieldMapper.map(reader);
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
        return new OrderItems(__typename, orderItemEdge, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<OrderItemEdge> orderItemEdge;

      private @Nullable PageInfo pageInfo;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder orderItemEdge(@Nullable List<OrderItemEdge> orderItemEdge) {
        this.orderItemEdge = orderItemEdge;
        return this;
      }

      public Builder pageInfo(@Nullable PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
      }

      public Builder orderItemEdge(@Nonnull Mutator<List<OrderItemEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<OrderItemEdge.Builder> builders = new ArrayList<>();
        if (this.orderItemEdge != null) {
          for (OrderItemEdge item : this.orderItemEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<OrderItemEdge> orderItemEdge = new ArrayList<>();
        for (OrderItemEdge.Builder item : builders) {
          orderItemEdge.add(item != null ? item.build() : null);
        }
        this.orderItemEdge = orderItemEdge;
        return this;
      }

      public Builder pageInfo(@Nonnull Mutator<PageInfo.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public OrderItems build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new OrderItems(__typename, orderItemEdge, pageInfo);
      }
    }
  }

  public static class OrderItemEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("orderItemNode", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable OrderItemNode orderItemNode;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OrderItemEdge(@Nonnull String __typename, @Nullable OrderItemNode orderItemNode,
        @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.orderItemNode = orderItemNode;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the OrderItem edge
     */
    public @Nullable OrderItemNode orderItemNode() {
      return this.orderItemNode;
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
          writer.writeObject($responseFields[1], orderItemNode != null ? orderItemNode.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OrderItemEdge{"
          + "__typename=" + __typename + ", "
          + "orderItemNode=" + orderItemNode + ", "
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
      if (o instanceof OrderItemEdge) {
        OrderItemEdge that = (OrderItemEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.orderItemNode == null) ? (that.orderItemNode == null) : this.orderItemNode.equals(that.orderItemNode))
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
        h ^= (orderItemNode == null) ? 0 : orderItemNode.hashCode();
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
      builder.orderItemNode = orderItemNode;
      builder.cursor = cursor;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OrderItemEdge> {
      final OrderItemNode.Mapper orderItemNodeFieldMapper = new OrderItemNode.Mapper();

      @Override
      public OrderItemEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final OrderItemNode orderItemNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<OrderItemNode>() {
          @Override
          public OrderItemNode read(ResponseReader reader) {
            return orderItemNodeFieldMapper.map(reader);
          }
        });
        final String cursor = reader.readString($responseFields[2]);
        return new OrderItemEdge(__typename, orderItemNode, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable OrderItemNode orderItemNode;

      private @Nullable String cursor;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder orderItemNode(@Nullable OrderItemNode orderItemNode) {
        this.orderItemNode = orderItemNode;
        return this;
      }

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
        return this;
      }

      public Builder orderItemNode(@Nonnull Mutator<OrderItemNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        OrderItemNode.Builder builder = this.orderItemNode != null ? this.orderItemNode.toBuilder() : OrderItemNode.builder();
        mutator.accept(builder);
        this.orderItemNode = builder.build();
        return this;
      }

      public OrderItemEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new OrderItemEdge(__typename, orderItemNode, cursor);
      }
    }
  }

  public static class OrderItemNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("price", "price", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("paidPrice", "paidPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("taxPrice", "taxPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("taxType", "taxType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("totalPrice", "totalPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("totalTaxPrice", "totalTaxPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("currency", "currency", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("orderItemProduct", "product", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final int quantity;

    final @Nullable Double price;

    final @Nullable Double paidPrice;

    final @Nullable Double taxPrice;

    final @Nullable String taxType;

    final @Nullable Double totalPrice;

    final @Nullable Double totalTaxPrice;

    final @Nullable String currency;

    final @Nonnull OrderItemProduct orderItemProduct;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OrderItemNode(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        int quantity, @Nullable Double price, @Nullable Double paidPrice, @Nullable Double taxPrice,
        @Nullable String taxType, @Nullable Double totalPrice, @Nullable Double totalTaxPrice,
        @Nullable String currency, @Nonnull OrderItemProduct orderItemProduct) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.quantity = quantity;
      this.price = price;
      this.paidPrice = paidPrice;
      this.taxPrice = taxPrice;
      this.taxType = taxType;
      this.totalPrice = totalPrice;
      this.totalTaxPrice = totalTaxPrice;
      this.currency = currency;
      this.orderItemProduct = Utils.checkNotNull(orderItemProduct, "orderItemProduct == null");
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
     *  Price
     */
    public @Nullable Double price() {
      return this.price;
    }

    /**
     *  Price paid. Excludes tax.
     */
    public @Nullable Double paidPrice() {
      return this.paidPrice;
    }

    /**
     *  Tax price
     */
    public @Nullable Double taxPrice() {
      return this.taxPrice;
    }

    /**
     *  Tax type. Supported values are _GST_, _VAT_, _EXCLTAX_
     */
    public @Nullable String taxType() {
      return this.taxType;
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

    /**
     *  Currency. Should ideally be a 3 letter ISO currency code. For instance _AUD_.
     */
    public @Nullable String currency() {
      return this.currency;
    }

    /**
     *  Represents the `Product` corresponding to this object
     */
    public @Nonnull OrderItemProduct orderItemProduct() {
      return this.orderItemProduct;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeInt($responseFields[3], quantity);
          writer.writeDouble($responseFields[4], price);
          writer.writeDouble($responseFields[5], paidPrice);
          writer.writeDouble($responseFields[6], taxPrice);
          writer.writeString($responseFields[7], taxType);
          writer.writeDouble($responseFields[8], totalPrice);
          writer.writeDouble($responseFields[9], totalTaxPrice);
          writer.writeString($responseFields[10], currency);
          writer.writeObject($responseFields[11], orderItemProduct.marshaller());
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OrderItemNode{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "quantity=" + quantity + ", "
          + "price=" + price + ", "
          + "paidPrice=" + paidPrice + ", "
          + "taxPrice=" + taxPrice + ", "
          + "taxType=" + taxType + ", "
          + "totalPrice=" + totalPrice + ", "
          + "totalTaxPrice=" + totalTaxPrice + ", "
          + "currency=" + currency + ", "
          + "orderItemProduct=" + orderItemProduct
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof OrderItemNode) {
        OrderItemNode that = (OrderItemNode) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.quantity == that.quantity
         && ((this.price == null) ? (that.price == null) : this.price.equals(that.price))
         && ((this.paidPrice == null) ? (that.paidPrice == null) : this.paidPrice.equals(that.paidPrice))
         && ((this.taxPrice == null) ? (that.taxPrice == null) : this.taxPrice.equals(that.taxPrice))
         && ((this.taxType == null) ? (that.taxType == null) : this.taxType.equals(that.taxType))
         && ((this.totalPrice == null) ? (that.totalPrice == null) : this.totalPrice.equals(that.totalPrice))
         && ((this.totalTaxPrice == null) ? (that.totalTaxPrice == null) : this.totalTaxPrice.equals(that.totalTaxPrice))
         && ((this.currency == null) ? (that.currency == null) : this.currency.equals(that.currency))
         && this.orderItemProduct.equals(that.orderItemProduct);
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
        h ^= (price == null) ? 0 : price.hashCode();
        h *= 1000003;
        h ^= (paidPrice == null) ? 0 : paidPrice.hashCode();
        h *= 1000003;
        h ^= (taxPrice == null) ? 0 : taxPrice.hashCode();
        h *= 1000003;
        h ^= (taxType == null) ? 0 : taxType.hashCode();
        h *= 1000003;
        h ^= (totalPrice == null) ? 0 : totalPrice.hashCode();
        h *= 1000003;
        h ^= (totalTaxPrice == null) ? 0 : totalTaxPrice.hashCode();
        h *= 1000003;
        h ^= (currency == null) ? 0 : currency.hashCode();
        h *= 1000003;
        h ^= orderItemProduct.hashCode();
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
      builder.price = price;
      builder.paidPrice = paidPrice;
      builder.taxPrice = taxPrice;
      builder.taxType = taxType;
      builder.totalPrice = totalPrice;
      builder.totalTaxPrice = totalTaxPrice;
      builder.currency = currency;
      builder.orderItemProduct = orderItemProduct;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OrderItemNode> {
      final OrderItemProduct.Mapper orderItemProductFieldMapper = new OrderItemProduct.Mapper();

      @Override
      public OrderItemNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final int quantity = reader.readInt($responseFields[3]);
        final Double price = reader.readDouble($responseFields[4]);
        final Double paidPrice = reader.readDouble($responseFields[5]);
        final Double taxPrice = reader.readDouble($responseFields[6]);
        final String taxType = reader.readString($responseFields[7]);
        final Double totalPrice = reader.readDouble($responseFields[8]);
        final Double totalTaxPrice = reader.readDouble($responseFields[9]);
        final String currency = reader.readString($responseFields[10]);
        final OrderItemProduct orderItemProduct = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<OrderItemProduct>() {
          @Override
          public OrderItemProduct read(ResponseReader reader) {
            return orderItemProductFieldMapper.map(reader);
          }
        });
        return new OrderItemNode(__typename, id, ref, quantity, price, paidPrice, taxPrice, taxType, totalPrice, totalTaxPrice, currency, orderItemProduct);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private int quantity;

      private @Nullable Double price;

      private @Nullable Double paidPrice;

      private @Nullable Double taxPrice;

      private @Nullable String taxType;

      private @Nullable Double totalPrice;

      private @Nullable Double totalTaxPrice;

      private @Nullable String currency;

      private @Nonnull OrderItemProduct orderItemProduct;

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

      public Builder price(@Nullable Double price) {
        this.price = price;
        return this;
      }

      public Builder paidPrice(@Nullable Double paidPrice) {
        this.paidPrice = paidPrice;
        return this;
      }

      public Builder taxPrice(@Nullable Double taxPrice) {
        this.taxPrice = taxPrice;
        return this;
      }

      public Builder taxType(@Nullable String taxType) {
        this.taxType = taxType;
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

      public Builder currency(@Nullable String currency) {
        this.currency = currency;
        return this;
      }

      public Builder orderItemProduct(@Nonnull OrderItemProduct orderItemProduct) {
        this.orderItemProduct = orderItemProduct;
        return this;
      }

      public Builder orderItemProduct(@Nonnull Mutator<OrderItemProduct.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        OrderItemProduct.Builder builder = this.orderItemProduct != null ? this.orderItemProduct.toBuilder() : OrderItemProduct.builder();
        mutator.accept(builder);
        this.orderItemProduct = builder.build();
        return this;
      }

      public OrderItemNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(orderItemProduct, "orderItemProduct == null");
        return new OrderItemNode(__typename, id, ref, quantity, price, paidPrice, taxPrice, taxType, totalPrice, totalTaxPrice, currency, orderItemProduct);
      }
    }
  }

  public static class OrderItemProduct {
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

    public OrderItemProduct(@Nonnull String __typename, @Nullable AsVariantProduct asVariantProduct,
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
        $toString = "OrderItemProduct{"
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
      if (o instanceof OrderItemProduct) {
        OrderItemProduct that = (OrderItemProduct) o;
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

    public static final class Mapper implements ResponseFieldMapper<OrderItemProduct> {
      final AsVariantProduct.Mapper asVariantProductFieldMapper = new AsVariantProduct.Mapper();

      final AsStandardProduct.Mapper asStandardProductFieldMapper = new AsStandardProduct.Mapper();

      @Override
      public OrderItemProduct map(ResponseReader reader) {
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
        return new OrderItemProduct(__typename, asVariantProduct, asStandardProduct);
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

      public OrderItemProduct build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new OrderItemProduct(__typename, asVariantProduct, asStandardProduct);
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
      ResponseField.forList("orderVpAttributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeOrderProductAttributes", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable List<OrderVpAttribute> orderVpAttributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public AsVariantProduct(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref,
        @Nonnull String type, @Nullable String status,
        @Nullable List<OrderVpAttribute> orderVpAttributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.orderVpAttributes = orderVpAttributes;
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
    public @Nullable List<OrderVpAttribute> orderVpAttributes() {
      return this.orderVpAttributes;
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
          writer.writeList($responseFields[5], orderVpAttributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((OrderVpAttribute) value).marshaller());
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
          + "orderVpAttributes=" + orderVpAttributes
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
         && ((this.orderVpAttributes == null) ? (that.orderVpAttributes == null) : this.orderVpAttributes.equals(that.orderVpAttributes));
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
        h ^= (orderVpAttributes == null) ? 0 : orderVpAttributes.hashCode();
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
      builder.orderVpAttributes = orderVpAttributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<AsVariantProduct> {
      final OrderVpAttribute.Mapper orderVpAttributeFieldMapper = new OrderVpAttribute.Mapper();

      @Override
      public AsVariantProduct map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final List<OrderVpAttribute> orderVpAttributes = reader.readList($responseFields[5], new ResponseReader.ListReader<OrderVpAttribute>() {
          @Override
          public OrderVpAttribute read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<OrderVpAttribute>() {
              @Override
              public OrderVpAttribute read(ResponseReader reader) {
                return orderVpAttributeFieldMapper.map(reader);
              }
            });
          }
        });
        return new AsVariantProduct(__typename, id, ref, type, status, orderVpAttributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable List<OrderVpAttribute> orderVpAttributes;

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

      public Builder orderVpAttributes(@Nullable List<OrderVpAttribute> orderVpAttributes) {
        this.orderVpAttributes = orderVpAttributes;
        return this;
      }

      public Builder orderVpAttributes(@Nonnull Mutator<List<OrderVpAttribute.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<OrderVpAttribute.Builder> builders = new ArrayList<>();
        if (this.orderVpAttributes != null) {
          for (OrderVpAttribute item : this.orderVpAttributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<OrderVpAttribute> orderVpAttributes = new ArrayList<>();
        for (OrderVpAttribute.Builder item : builders) {
          orderVpAttributes.add(item != null ? item.build() : null);
        }
        this.orderVpAttributes = orderVpAttributes;
        return this;
      }

      public AsVariantProduct build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        Utils.checkNotNull(type, "type == null");
        return new AsVariantProduct(__typename, id, ref, type, status, orderVpAttributes);
      }
    }
  }

  public static class OrderVpAttribute {
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

    public OrderVpAttribute(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
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
        $toString = "OrderVpAttribute{"
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
      if (o instanceof OrderVpAttribute) {
        OrderVpAttribute that = (OrderVpAttribute) o;
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

    public static final class Mapper implements ResponseFieldMapper<OrderVpAttribute> {
      @Override
      public OrderVpAttribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new OrderVpAttribute(__typename, name, type, value);
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

      public OrderVpAttribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new OrderVpAttribute(__typename, name, type, value);
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
      ResponseField.forList("orderSpAttributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeOrderProductAttributes", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable List<OrderSpAttribute> orderSpAttributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public AsStandardProduct(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref,
        @Nonnull String type, @Nullable String status,
        @Nullable List<OrderSpAttribute> orderSpAttributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.orderSpAttributes = orderSpAttributes;
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
    public @Nullable List<OrderSpAttribute> orderSpAttributes() {
      return this.orderSpAttributes;
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
          writer.writeList($responseFields[5], orderSpAttributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((OrderSpAttribute) value).marshaller());
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
          + "orderSpAttributes=" + orderSpAttributes
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
         && ((this.orderSpAttributes == null) ? (that.orderSpAttributes == null) : this.orderSpAttributes.equals(that.orderSpAttributes));
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
        h ^= (orderSpAttributes == null) ? 0 : orderSpAttributes.hashCode();
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
      builder.orderSpAttributes = orderSpAttributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<AsStandardProduct> {
      final OrderSpAttribute.Mapper orderSpAttributeFieldMapper = new OrderSpAttribute.Mapper();

      @Override
      public AsStandardProduct map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final List<OrderSpAttribute> orderSpAttributes = reader.readList($responseFields[5], new ResponseReader.ListReader<OrderSpAttribute>() {
          @Override
          public OrderSpAttribute read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<OrderSpAttribute>() {
              @Override
              public OrderSpAttribute read(ResponseReader reader) {
                return orderSpAttributeFieldMapper.map(reader);
              }
            });
          }
        });
        return new AsStandardProduct(__typename, id, ref, type, status, orderSpAttributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable List<OrderSpAttribute> orderSpAttributes;

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

      public Builder orderSpAttributes(@Nullable List<OrderSpAttribute> orderSpAttributes) {
        this.orderSpAttributes = orderSpAttributes;
        return this;
      }

      public Builder orderSpAttributes(@Nonnull Mutator<List<OrderSpAttribute.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<OrderSpAttribute.Builder> builders = new ArrayList<>();
        if (this.orderSpAttributes != null) {
          for (OrderSpAttribute item : this.orderSpAttributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<OrderSpAttribute> orderSpAttributes = new ArrayList<>();
        for (OrderSpAttribute.Builder item : builders) {
          orderSpAttributes.add(item != null ? item.build() : null);
        }
        this.orderSpAttributes = orderSpAttributes;
        return this;
      }

      public AsStandardProduct build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        Utils.checkNotNull(type, "type == null");
        return new AsStandardProduct(__typename, id, ref, type, status, orderSpAttributes);
      }
    }
  }

  public static class OrderSpAttribute {
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

    public OrderSpAttribute(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
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
        $toString = "OrderSpAttribute{"
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
      if (o instanceof OrderSpAttribute) {
        OrderSpAttribute that = (OrderSpAttribute) o;
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

    public static final class Mapper implements ResponseFieldMapper<OrderSpAttribute> {
      @Override
      public OrderSpAttribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new OrderSpAttribute(__typename, name, type, value);
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

      public OrderSpAttribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new OrderSpAttribute(__typename, name, type, value);
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

  public static class Fulfilments {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("fulfilmentEdges", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<FulfilmentEdge> fulfilmentEdges;

    final @Nullable PageInfo2 pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilments(@Nonnull String __typename, @Nullable List<FulfilmentEdge> fulfilmentEdges,
        @Nullable PageInfo2 pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilmentEdges = fulfilmentEdges;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Fulfilment type node
     */
    public @Nullable List<FulfilmentEdge> fulfilmentEdges() {
      return this.fulfilmentEdges;
    }

    /**
     *  Information to aid in pagination
     */
    public @Nullable PageInfo2 pageInfo() {
      return this.pageInfo;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], fulfilmentEdges, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((FulfilmentEdge) value).marshaller());
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
          + "fulfilmentEdges=" + fulfilmentEdges + ", "
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
         && ((this.fulfilmentEdges == null) ? (that.fulfilmentEdges == null) : this.fulfilmentEdges.equals(that.fulfilmentEdges))
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
        h ^= (fulfilmentEdges == null) ? 0 : fulfilmentEdges.hashCode();
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
      builder.fulfilmentEdges = fulfilmentEdges;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Fulfilments> {
      final FulfilmentEdge.Mapper fulfilmentEdgeFieldMapper = new FulfilmentEdge.Mapper();

      final PageInfo2.Mapper pageInfo2FieldMapper = new PageInfo2.Mapper();

      @Override
      public Fulfilments map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<FulfilmentEdge> fulfilmentEdges = reader.readList($responseFields[1], new ResponseReader.ListReader<FulfilmentEdge>() {
          @Override
          public FulfilmentEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<FulfilmentEdge>() {
              @Override
              public FulfilmentEdge read(ResponseReader reader) {
                return fulfilmentEdgeFieldMapper.map(reader);
              }
            });
          }
        });
        final PageInfo2 pageInfo = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<PageInfo2>() {
          @Override
          public PageInfo2 read(ResponseReader reader) {
            return pageInfo2FieldMapper.map(reader);
          }
        });
        return new Fulfilments(__typename, fulfilmentEdges, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<FulfilmentEdge> fulfilmentEdges;

      private @Nullable PageInfo2 pageInfo;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilmentEdges(@Nullable List<FulfilmentEdge> fulfilmentEdges) {
        this.fulfilmentEdges = fulfilmentEdges;
        return this;
      }

      public Builder pageInfo(@Nullable PageInfo2 pageInfo) {
        this.pageInfo = pageInfo;
        return this;
      }

      public Builder fulfilmentEdges(@Nonnull Mutator<List<FulfilmentEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<FulfilmentEdge.Builder> builders = new ArrayList<>();
        if (this.fulfilmentEdges != null) {
          for (FulfilmentEdge item : this.fulfilmentEdges) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<FulfilmentEdge> fulfilmentEdges = new ArrayList<>();
        for (FulfilmentEdge.Builder item : builders) {
          fulfilmentEdges.add(item != null ? item.build() : null);
        }
        this.fulfilmentEdges = fulfilmentEdges;
        return this;
      }

      public Builder pageInfo(@Nonnull Mutator<PageInfo2.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo2.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo2.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public Fulfilments build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Fulfilments(__typename, fulfilmentEdges, pageInfo);
      }
    }
  }

  public static class FulfilmentEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilmentNode", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable FulfilmentNode fulfilmentNode;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentEdge(@Nonnull String __typename, @Nullable FulfilmentNode fulfilmentNode,
        @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilmentNode = fulfilmentNode;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Fulfilment edge
     */
    public @Nullable FulfilmentNode fulfilmentNode() {
      return this.fulfilmentNode;
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
          writer.writeObject($responseFields[1], fulfilmentNode != null ? fulfilmentNode.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentEdge{"
          + "__typename=" + __typename + ", "
          + "fulfilmentNode=" + fulfilmentNode + ", "
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
      if (o instanceof FulfilmentEdge) {
        FulfilmentEdge that = (FulfilmentEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.fulfilmentNode == null) ? (that.fulfilmentNode == null) : this.fulfilmentNode.equals(that.fulfilmentNode))
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
        h ^= (fulfilmentNode == null) ? 0 : fulfilmentNode.hashCode();
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
      builder.fulfilmentNode = fulfilmentNode;
      builder.cursor = cursor;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentEdge> {
      final FulfilmentNode.Mapper fulfilmentNodeFieldMapper = new FulfilmentNode.Mapper();

      @Override
      public FulfilmentEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final FulfilmentNode fulfilmentNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<FulfilmentNode>() {
          @Override
          public FulfilmentNode read(ResponseReader reader) {
            return fulfilmentNodeFieldMapper.map(reader);
          }
        });
        final String cursor = reader.readString($responseFields[2]);
        return new FulfilmentEdge(__typename, fulfilmentNode, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable FulfilmentNode fulfilmentNode;

      private @Nullable String cursor;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilmentNode(@Nullable FulfilmentNode fulfilmentNode) {
        this.fulfilmentNode = fulfilmentNode;
        return this;
      }

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
        return this;
      }

      public Builder fulfilmentNode(@Nonnull Mutator<FulfilmentNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentNode.Builder builder = this.fulfilmentNode != null ? this.fulfilmentNode.toBuilder() : FulfilmentNode.builder();
        mutator.accept(builder);
        this.fulfilmentNode = builder.build();
        return this;
      }

      public FulfilmentEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FulfilmentEdge(__typename, fulfilmentNode, cursor);
      }
    }
  }

  public static class FulfilmentNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("deliveryType", "deliveryType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fromLocation", "fromLocation", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("fulfilmentAttributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeFulfilmentAttributes", false))),
      ResponseField.forObject("fromAddress", "fromAddress", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("toAddress", "toAddress", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilmentItems", "items", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeFulfilmentItems", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable String deliveryType;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable FromLocation fromLocation;

    final @Nullable List<FulfilmentAttribute> fulfilmentAttributes;

    final @Nullable FromAddress fromAddress;

    final @Nullable ToAddress toAddress;

    final @Nullable FulfilmentItems fulfilmentItems;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentNode(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable String deliveryType,
        @Nullable Object createdOn, @Nullable Object updatedOn, @Nullable FromLocation fromLocation,
        @Nullable List<FulfilmentAttribute> fulfilmentAttributes, @Nullable FromAddress fromAddress,
        @Nullable ToAddress toAddress, @Nullable FulfilmentItems fulfilmentItems) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.deliveryType = deliveryType;
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.fromLocation = fromLocation;
      this.fulfilmentAttributes = fulfilmentAttributes;
      this.fromAddress = fromAddress;
      this.toAddress = toAddress;
      this.fulfilmentItems = fulfilmentItems;
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
     *  The current status of the `Fulfilment`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
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
     *  The `Location` responsible for processing outbound `Fulfilment`s
     */
    public @Nullable FromLocation fromLocation() {
      return this.fromLocation;
    }

    /**
     *  Attributes of fulfilment
     */
    public @Nullable List<FulfilmentAttribute> fulfilmentAttributes() {
      return this.fulfilmentAttributes;
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
     *  Connection representing a list of `FulfilmentItem`s
     */
    public @Nullable FulfilmentItems fulfilmentItems() {
      return this.fulfilmentItems;
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
          writer.writeString($responseFields[5], deliveryType);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[6], createdOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[7], updatedOn);
          writer.writeObject($responseFields[8], fromLocation != null ? fromLocation.marshaller() : null);
          writer.writeList($responseFields[9], fulfilmentAttributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((FulfilmentAttribute) value).marshaller());
            }
          });
          writer.writeObject($responseFields[10], fromAddress != null ? fromAddress.marshaller() : null);
          writer.writeObject($responseFields[11], toAddress != null ? toAddress.marshaller() : null);
          writer.writeObject($responseFields[12], fulfilmentItems != null ? fulfilmentItems.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentNode{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "deliveryType=" + deliveryType + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "fromLocation=" + fromLocation + ", "
          + "fulfilmentAttributes=" + fulfilmentAttributes + ", "
          + "fromAddress=" + fromAddress + ", "
          + "toAddress=" + toAddress + ", "
          + "fulfilmentItems=" + fulfilmentItems
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FulfilmentNode) {
        FulfilmentNode that = (FulfilmentNode) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.type.equals(that.type)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.deliveryType == null) ? (that.deliveryType == null) : this.deliveryType.equals(that.deliveryType))
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.fromLocation == null) ? (that.fromLocation == null) : this.fromLocation.equals(that.fromLocation))
         && ((this.fulfilmentAttributes == null) ? (that.fulfilmentAttributes == null) : this.fulfilmentAttributes.equals(that.fulfilmentAttributes))
         && ((this.fromAddress == null) ? (that.fromAddress == null) : this.fromAddress.equals(that.fromAddress))
         && ((this.toAddress == null) ? (that.toAddress == null) : this.toAddress.equals(that.toAddress))
         && ((this.fulfilmentItems == null) ? (that.fulfilmentItems == null) : this.fulfilmentItems.equals(that.fulfilmentItems));
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
        h ^= (deliveryType == null) ? 0 : deliveryType.hashCode();
        h *= 1000003;
        h ^= (createdOn == null) ? 0 : createdOn.hashCode();
        h *= 1000003;
        h ^= (updatedOn == null) ? 0 : updatedOn.hashCode();
        h *= 1000003;
        h ^= (fromLocation == null) ? 0 : fromLocation.hashCode();
        h *= 1000003;
        h ^= (fulfilmentAttributes == null) ? 0 : fulfilmentAttributes.hashCode();
        h *= 1000003;
        h ^= (fromAddress == null) ? 0 : fromAddress.hashCode();
        h *= 1000003;
        h ^= (toAddress == null) ? 0 : toAddress.hashCode();
        h *= 1000003;
        h ^= (fulfilmentItems == null) ? 0 : fulfilmentItems.hashCode();
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
      builder.deliveryType = deliveryType;
      builder.createdOn = createdOn;
      builder.updatedOn = updatedOn;
      builder.fromLocation = fromLocation;
      builder.fulfilmentAttributes = fulfilmentAttributes;
      builder.fromAddress = fromAddress;
      builder.toAddress = toAddress;
      builder.fulfilmentItems = fulfilmentItems;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentNode> {
      final FromLocation.Mapper fromLocationFieldMapper = new FromLocation.Mapper();

      final FulfilmentAttribute.Mapper fulfilmentAttributeFieldMapper = new FulfilmentAttribute.Mapper();

      final FromAddress.Mapper fromAddressFieldMapper = new FromAddress.Mapper();

      final ToAddress.Mapper toAddressFieldMapper = new ToAddress.Mapper();

      final FulfilmentItems.Mapper fulfilmentItemsFieldMapper = new FulfilmentItems.Mapper();

      @Override
      public FulfilmentNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final String deliveryType = reader.readString($responseFields[5]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[6]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[7]);
        final FromLocation fromLocation = reader.readObject($responseFields[8], new ResponseReader.ObjectReader<FromLocation>() {
          @Override
          public FromLocation read(ResponseReader reader) {
            return fromLocationFieldMapper.map(reader);
          }
        });
        final List<FulfilmentAttribute> fulfilmentAttributes = reader.readList($responseFields[9], new ResponseReader.ListReader<FulfilmentAttribute>() {
          @Override
          public FulfilmentAttribute read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<FulfilmentAttribute>() {
              @Override
              public FulfilmentAttribute read(ResponseReader reader) {
                return fulfilmentAttributeFieldMapper.map(reader);
              }
            });
          }
        });
        final FromAddress fromAddress = reader.readObject($responseFields[10], new ResponseReader.ObjectReader<FromAddress>() {
          @Override
          public FromAddress read(ResponseReader reader) {
            return fromAddressFieldMapper.map(reader);
          }
        });
        final ToAddress toAddress = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<ToAddress>() {
          @Override
          public ToAddress read(ResponseReader reader) {
            return toAddressFieldMapper.map(reader);
          }
        });
        final FulfilmentItems fulfilmentItems = reader.readObject($responseFields[12], new ResponseReader.ObjectReader<FulfilmentItems>() {
          @Override
          public FulfilmentItems read(ResponseReader reader) {
            return fulfilmentItemsFieldMapper.map(reader);
          }
        });
        return new FulfilmentNode(__typename, id, ref, type, status, deliveryType, createdOn, updatedOn, fromLocation, fulfilmentAttributes, fromAddress, toAddress, fulfilmentItems);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable String deliveryType;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

      private @Nullable FromLocation fromLocation;

      private @Nullable List<FulfilmentAttribute> fulfilmentAttributes;

      private @Nullable FromAddress fromAddress;

      private @Nullable ToAddress toAddress;

      private @Nullable FulfilmentItems fulfilmentItems;

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

      public Builder fromLocation(@Nullable FromLocation fromLocation) {
        this.fromLocation = fromLocation;
        return this;
      }

      public Builder fulfilmentAttributes(@Nullable List<FulfilmentAttribute> fulfilmentAttributes) {
        this.fulfilmentAttributes = fulfilmentAttributes;
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

      public Builder fulfilmentItems(@Nullable FulfilmentItems fulfilmentItems) {
        this.fulfilmentItems = fulfilmentItems;
        return this;
      }

      public Builder fromLocation(@Nonnull Mutator<FromLocation.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FromLocation.Builder builder = this.fromLocation != null ? this.fromLocation.toBuilder() : FromLocation.builder();
        mutator.accept(builder);
        this.fromLocation = builder.build();
        return this;
      }

      public Builder fulfilmentAttributes(@Nonnull Mutator<List<FulfilmentAttribute.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<FulfilmentAttribute.Builder> builders = new ArrayList<>();
        if (this.fulfilmentAttributes != null) {
          for (FulfilmentAttribute item : this.fulfilmentAttributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<FulfilmentAttribute> fulfilmentAttributes = new ArrayList<>();
        for (FulfilmentAttribute.Builder item : builders) {
          fulfilmentAttributes.add(item != null ? item.build() : null);
        }
        this.fulfilmentAttributes = fulfilmentAttributes;
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

      public Builder fulfilmentItems(@Nonnull Mutator<FulfilmentItems.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentItems.Builder builder = this.fulfilmentItems != null ? this.fulfilmentItems.toBuilder() : FulfilmentItems.builder();
        mutator.accept(builder);
        this.fulfilmentItems = builder.build();
        return this;
      }

      public FulfilmentNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new FulfilmentNode(__typename, id, ref, type, status, deliveryType, createdOn, updatedOn, fromLocation, fulfilmentAttributes, fromAddress, toAddress, fulfilmentItems);
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

  public static class FulfilmentAttribute {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("value", "value", null, false, CustomType.JSON, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String name;

    final @Nonnull Object value;

    final @Nonnull String type;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentAttribute(@Nonnull String __typename, @Nonnull String name,
        @Nonnull Object value, @Nonnull String type) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.name = Utils.checkNotNull(name, "name == null");
      this.value = Utils.checkNotNull(value, "value == null");
      this.type = Utils.checkNotNull(type, "type == null");
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
     *  Value of the `attribute`
     */
    public @Nonnull Object value() {
      return this.value;
    }

    /**
     *  Type of the attribute's `value`. This is a free string and can be used by the client to interpret and cast the `value` into the appropriate type.
     */
    public @Nonnull String type() {
      return this.type;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], name);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], value);
          writer.writeString($responseFields[3], type);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentAttribute{"
          + "__typename=" + __typename + ", "
          + "name=" + name + ", "
          + "value=" + value + ", "
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
      if (o instanceof FulfilmentAttribute) {
        FulfilmentAttribute that = (FulfilmentAttribute) o;
        return this.__typename.equals(that.__typename)
         && this.name.equals(that.name)
         && this.value.equals(that.value)
         && this.type.equals(that.type);
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
        h ^= value.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.name = name;
      builder.value = value;
      builder.type = type;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentAttribute> {
      @Override
      public FulfilmentAttribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        return new FulfilmentAttribute(__typename, name, value, type);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String name;

      private @Nonnull Object value;

      private @Nonnull String type;

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

      public Builder value(@Nonnull Object value) {
        this.value = value;
        return this;
      }

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public FulfilmentAttribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(value, "value == null");
        Utils.checkNotNull(type, "type == null");
        return new FulfilmentAttribute(__typename, name, value, type);
      }
    }
  }

  public static class FromAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String ref;

    final @Nonnull String id;

    final @Nullable String name;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FromAddress(@Nonnull String __typename, @Nullable String ref, @Nonnull String id,
        @Nullable String name) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = ref;
      this.id = Utils.checkNotNull(id, "id == null");
      this.name = name;
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
     *  ID of the object
     */
    public @Nonnull String id() {
      return this.id;
    }

    /**
     *  Name
     */
    public @Nullable String name() {
      return this.name;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], id);
          writer.writeString($responseFields[3], name);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FromAddress{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
          + "id=" + id + ", "
          + "name=" + name
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
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.id.equals(that.id)
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name));
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
        h ^= (name == null) ? 0 : name.hashCode();
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
      builder.name = name;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FromAddress> {
      @Override
      public FromAddress map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final String name = reader.readString($responseFields[3]);
        return new FromAddress(__typename, ref, id, name);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String ref;

      private @Nonnull String id;

      private @Nullable String name;

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

      public Builder name(@Nullable String name) {
        this.name = name;
        return this;
      }

      public FromAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new FromAddress(__typename, ref, id, name);
      }
    }
  }

  public static class ToAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String ref;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ToAddress(@Nonnull String __typename, @Nullable String ref, @Nonnull String id) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = ref;
      this.id = Utils.checkNotNull(id, "id == null");
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
     *  ID of the object
     */
    public @Nonnull String id() {
      return this.id;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], id);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ToAddress{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
          + "id=" + id
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
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.id.equals(that.id);
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
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ToAddress> {
      @Override
      public ToAddress map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        return new ToAddress(__typename, ref, id);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String ref;

      private @Nonnull String id;

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

      public ToAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new ToAddress(__typename, ref, id);
      }
    }
  }

  public static class FulfilmentItems {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("fulfilmentItemEdges", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<FulfilmentItemEdge> fulfilmentItemEdges;

    final @Nullable PageInfo1 pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentItems(@Nonnull String __typename,
        @Nullable List<FulfilmentItemEdge> fulfilmentItemEdges, @Nullable PageInfo1 pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilmentItemEdges = fulfilmentItemEdges;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to FulfilmentItem type node
     */
    public @Nullable List<FulfilmentItemEdge> fulfilmentItemEdges() {
      return this.fulfilmentItemEdges;
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
          writer.writeList($responseFields[1], fulfilmentItemEdges, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((FulfilmentItemEdge) value).marshaller());
            }
          });
          writer.writeObject($responseFields[2], pageInfo != null ? pageInfo.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentItems{"
          + "__typename=" + __typename + ", "
          + "fulfilmentItemEdges=" + fulfilmentItemEdges + ", "
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
      if (o instanceof FulfilmentItems) {
        FulfilmentItems that = (FulfilmentItems) o;
        return this.__typename.equals(that.__typename)
         && ((this.fulfilmentItemEdges == null) ? (that.fulfilmentItemEdges == null) : this.fulfilmentItemEdges.equals(that.fulfilmentItemEdges))
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
        h ^= (fulfilmentItemEdges == null) ? 0 : fulfilmentItemEdges.hashCode();
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
      builder.fulfilmentItemEdges = fulfilmentItemEdges;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentItems> {
      final FulfilmentItemEdge.Mapper fulfilmentItemEdgeFieldMapper = new FulfilmentItemEdge.Mapper();

      final PageInfo1.Mapper pageInfo1FieldMapper = new PageInfo1.Mapper();

      @Override
      public FulfilmentItems map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<FulfilmentItemEdge> fulfilmentItemEdges = reader.readList($responseFields[1], new ResponseReader.ListReader<FulfilmentItemEdge>() {
          @Override
          public FulfilmentItemEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<FulfilmentItemEdge>() {
              @Override
              public FulfilmentItemEdge read(ResponseReader reader) {
                return fulfilmentItemEdgeFieldMapper.map(reader);
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
        return new FulfilmentItems(__typename, fulfilmentItemEdges, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<FulfilmentItemEdge> fulfilmentItemEdges;

      private @Nullable PageInfo1 pageInfo;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilmentItemEdges(@Nullable List<FulfilmentItemEdge> fulfilmentItemEdges) {
        this.fulfilmentItemEdges = fulfilmentItemEdges;
        return this;
      }

      public Builder pageInfo(@Nullable PageInfo1 pageInfo) {
        this.pageInfo = pageInfo;
        return this;
      }

      public Builder fulfilmentItemEdges(@Nonnull Mutator<List<FulfilmentItemEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<FulfilmentItemEdge.Builder> builders = new ArrayList<>();
        if (this.fulfilmentItemEdges != null) {
          for (FulfilmentItemEdge item : this.fulfilmentItemEdges) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<FulfilmentItemEdge> fulfilmentItemEdges = new ArrayList<>();
        for (FulfilmentItemEdge.Builder item : builders) {
          fulfilmentItemEdges.add(item != null ? item.build() : null);
        }
        this.fulfilmentItemEdges = fulfilmentItemEdges;
        return this;
      }

      public Builder pageInfo(@Nonnull Mutator<PageInfo1.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo1.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo1.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public FulfilmentItems build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FulfilmentItems(__typename, fulfilmentItemEdges, pageInfo);
      }
    }
  }

  public static class FulfilmentItemEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilmentItemNode", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable FulfilmentItemNode fulfilmentItemNode;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentItemEdge(@Nonnull String __typename,
        @Nullable FulfilmentItemNode fulfilmentItemNode, @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilmentItemNode = fulfilmentItemNode;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the FulfilmentItem edge
     */
    public @Nullable FulfilmentItemNode fulfilmentItemNode() {
      return this.fulfilmentItemNode;
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
          writer.writeObject($responseFields[1], fulfilmentItemNode != null ? fulfilmentItemNode.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentItemEdge{"
          + "__typename=" + __typename + ", "
          + "fulfilmentItemNode=" + fulfilmentItemNode + ", "
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
      if (o instanceof FulfilmentItemEdge) {
        FulfilmentItemEdge that = (FulfilmentItemEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.fulfilmentItemNode == null) ? (that.fulfilmentItemNode == null) : this.fulfilmentItemNode.equals(that.fulfilmentItemNode))
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
        h ^= (fulfilmentItemNode == null) ? 0 : fulfilmentItemNode.hashCode();
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
      builder.fulfilmentItemNode = fulfilmentItemNode;
      builder.cursor = cursor;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentItemEdge> {
      final FulfilmentItemNode.Mapper fulfilmentItemNodeFieldMapper = new FulfilmentItemNode.Mapper();

      @Override
      public FulfilmentItemEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final FulfilmentItemNode fulfilmentItemNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<FulfilmentItemNode>() {
          @Override
          public FulfilmentItemNode read(ResponseReader reader) {
            return fulfilmentItemNodeFieldMapper.map(reader);
          }
        });
        final String cursor = reader.readString($responseFields[2]);
        return new FulfilmentItemEdge(__typename, fulfilmentItemNode, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable FulfilmentItemNode fulfilmentItemNode;

      private @Nullable String cursor;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilmentItemNode(@Nullable FulfilmentItemNode fulfilmentItemNode) {
        this.fulfilmentItemNode = fulfilmentItemNode;
        return this;
      }

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
        return this;
      }

      public Builder fulfilmentItemNode(@Nonnull Mutator<FulfilmentItemNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentItemNode.Builder builder = this.fulfilmentItemNode != null ? this.fulfilmentItemNode.toBuilder() : FulfilmentItemNode.builder();
        mutator.accept(builder);
        this.fulfilmentItemNode = builder.build();
        return this;
      }

      public FulfilmentItemEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FulfilmentItemEdge(__typename, fulfilmentItemNode, cursor);
      }
    }
  }

  public static class FulfilmentItemNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("requestedQuantity", "requestedQuantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("filledQuantity", "filledQuantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("rejectedQuantity", "rejectedQuantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilmentOrderItem", "orderItem", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeFulfilmentOrderItems", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable Integer requestedQuantity;

    final int filledQuantity;

    final int rejectedQuantity;

    final @Nullable FulfilmentOrderItem fulfilmentOrderItem;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentItemNode(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable Integer requestedQuantity, int filledQuantity, int rejectedQuantity,
        @Nullable FulfilmentOrderItem fulfilmentOrderItem) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.requestedQuantity = requestedQuantity;
      this.filledQuantity = filledQuantity;
      this.rejectedQuantity = rejectedQuantity;
      this.fulfilmentOrderItem = fulfilmentOrderItem;
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
    public @Nullable FulfilmentOrderItem fulfilmentOrderItem() {
      return this.fulfilmentOrderItem;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeInt($responseFields[3], requestedQuantity);
          writer.writeInt($responseFields[4], filledQuantity);
          writer.writeInt($responseFields[5], rejectedQuantity);
          writer.writeObject($responseFields[6], fulfilmentOrderItem != null ? fulfilmentOrderItem.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentItemNode{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "requestedQuantity=" + requestedQuantity + ", "
          + "filledQuantity=" + filledQuantity + ", "
          + "rejectedQuantity=" + rejectedQuantity + ", "
          + "fulfilmentOrderItem=" + fulfilmentOrderItem
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FulfilmentItemNode) {
        FulfilmentItemNode that = (FulfilmentItemNode) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.requestedQuantity == null) ? (that.requestedQuantity == null) : this.requestedQuantity.equals(that.requestedQuantity))
         && this.filledQuantity == that.filledQuantity
         && this.rejectedQuantity == that.rejectedQuantity
         && ((this.fulfilmentOrderItem == null) ? (that.fulfilmentOrderItem == null) : this.fulfilmentOrderItem.equals(that.fulfilmentOrderItem));
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
        h ^= (requestedQuantity == null) ? 0 : requestedQuantity.hashCode();
        h *= 1000003;
        h ^= filledQuantity;
        h *= 1000003;
        h ^= rejectedQuantity;
        h *= 1000003;
        h ^= (fulfilmentOrderItem == null) ? 0 : fulfilmentOrderItem.hashCode();
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
      builder.requestedQuantity = requestedQuantity;
      builder.filledQuantity = filledQuantity;
      builder.rejectedQuantity = rejectedQuantity;
      builder.fulfilmentOrderItem = fulfilmentOrderItem;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentItemNode> {
      final FulfilmentOrderItem.Mapper fulfilmentOrderItemFieldMapper = new FulfilmentOrderItem.Mapper();

      @Override
      public FulfilmentItemNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final Integer requestedQuantity = reader.readInt($responseFields[3]);
        final int filledQuantity = reader.readInt($responseFields[4]);
        final int rejectedQuantity = reader.readInt($responseFields[5]);
        final FulfilmentOrderItem fulfilmentOrderItem = reader.readObject($responseFields[6], new ResponseReader.ObjectReader<FulfilmentOrderItem>() {
          @Override
          public FulfilmentOrderItem read(ResponseReader reader) {
            return fulfilmentOrderItemFieldMapper.map(reader);
          }
        });
        return new FulfilmentItemNode(__typename, id, ref, requestedQuantity, filledQuantity, rejectedQuantity, fulfilmentOrderItem);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable Integer requestedQuantity;

      private int filledQuantity;

      private int rejectedQuantity;

      private @Nullable FulfilmentOrderItem fulfilmentOrderItem;

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

      public Builder fulfilmentOrderItem(@Nullable FulfilmentOrderItem fulfilmentOrderItem) {
        this.fulfilmentOrderItem = fulfilmentOrderItem;
        return this;
      }

      public Builder fulfilmentOrderItem(@Nonnull Mutator<FulfilmentOrderItem.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentOrderItem.Builder builder = this.fulfilmentOrderItem != null ? this.fulfilmentOrderItem.toBuilder() : FulfilmentOrderItem.builder();
        mutator.accept(builder);
        this.fulfilmentOrderItem = builder.build();
        return this;
      }

      public FulfilmentItemNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new FulfilmentItemNode(__typename, id, ref, requestedQuantity, filledQuantity, rejectedQuantity, fulfilmentOrderItem);
      }
    }
  }

  public static class FulfilmentOrderItem {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilmentOrderItemProduct", "product", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final int quantity;

    final @Nonnull FulfilmentOrderItemProduct fulfilmentOrderItemProduct;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentOrderItem(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        int quantity, @Nonnull FulfilmentOrderItemProduct fulfilmentOrderItemProduct) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.quantity = quantity;
      this.fulfilmentOrderItemProduct = Utils.checkNotNull(fulfilmentOrderItemProduct, "fulfilmentOrderItemProduct == null");
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
    public @Nonnull FulfilmentOrderItemProduct fulfilmentOrderItemProduct() {
      return this.fulfilmentOrderItemProduct;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeInt($responseFields[3], quantity);
          writer.writeObject($responseFields[4], fulfilmentOrderItemProduct.marshaller());
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentOrderItem{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "quantity=" + quantity + ", "
          + "fulfilmentOrderItemProduct=" + fulfilmentOrderItemProduct
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FulfilmentOrderItem) {
        FulfilmentOrderItem that = (FulfilmentOrderItem) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.quantity == that.quantity
         && this.fulfilmentOrderItemProduct.equals(that.fulfilmentOrderItemProduct);
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
        h ^= fulfilmentOrderItemProduct.hashCode();
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
      builder.fulfilmentOrderItemProduct = fulfilmentOrderItemProduct;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentOrderItem> {
      final FulfilmentOrderItemProduct.Mapper fulfilmentOrderItemProductFieldMapper = new FulfilmentOrderItemProduct.Mapper();

      @Override
      public FulfilmentOrderItem map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final int quantity = reader.readInt($responseFields[3]);
        final FulfilmentOrderItemProduct fulfilmentOrderItemProduct = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<FulfilmentOrderItemProduct>() {
          @Override
          public FulfilmentOrderItemProduct read(ResponseReader reader) {
            return fulfilmentOrderItemProductFieldMapper.map(reader);
          }
        });
        return new FulfilmentOrderItem(__typename, id, ref, quantity, fulfilmentOrderItemProduct);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private int quantity;

      private @Nonnull FulfilmentOrderItemProduct fulfilmentOrderItemProduct;

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

      public Builder fulfilmentOrderItemProduct(@Nonnull FulfilmentOrderItemProduct fulfilmentOrderItemProduct) {
        this.fulfilmentOrderItemProduct = fulfilmentOrderItemProduct;
        return this;
      }

      public Builder fulfilmentOrderItemProduct(@Nonnull Mutator<FulfilmentOrderItemProduct.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentOrderItemProduct.Builder builder = this.fulfilmentOrderItemProduct != null ? this.fulfilmentOrderItemProduct.toBuilder() : FulfilmentOrderItemProduct.builder();
        mutator.accept(builder);
        this.fulfilmentOrderItemProduct = builder.build();
        return this;
      }

      public FulfilmentOrderItem build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(fulfilmentOrderItemProduct, "fulfilmentOrderItemProduct == null");
        return new FulfilmentOrderItem(__typename, id, ref, quantity, fulfilmentOrderItemProduct);
      }
    }
  }

  public static class FulfilmentOrderItemProduct {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInlineFragment("__typename", "__typename", Arrays.asList("VariantProduct")),
      ResponseField.forInlineFragment("__typename", "__typename", Arrays.asList("StandardProduct"))
    };

    final @Nonnull String __typename;

    final @Nullable AsVariantProduct1 asVariantProduct;

    final @Nullable AsStandardProduct1 asStandardProduct;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentOrderItemProduct(@Nonnull String __typename,
        @Nullable AsVariantProduct1 asVariantProduct,
        @Nullable AsStandardProduct1 asStandardProduct) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.asVariantProduct = asVariantProduct;
      this.asStandardProduct = asStandardProduct;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable AsVariantProduct1 asVariantProduct() {
      return this.asVariantProduct;
    }

    public @Nullable AsStandardProduct1 asStandardProduct() {
      return this.asStandardProduct;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          final AsVariantProduct1 $asVariantProduct = asVariantProduct;
          if ($asVariantProduct != null) {
            $asVariantProduct.marshaller().marshal(writer);
          }
          final AsStandardProduct1 $asStandardProduct = asStandardProduct;
          if ($asStandardProduct != null) {
            $asStandardProduct.marshaller().marshal(writer);
          }
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentOrderItemProduct{"
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
      if (o instanceof FulfilmentOrderItemProduct) {
        FulfilmentOrderItemProduct that = (FulfilmentOrderItemProduct) o;
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

    public static final class Mapper implements ResponseFieldMapper<FulfilmentOrderItemProduct> {
      final AsVariantProduct1.Mapper asVariantProduct1FieldMapper = new AsVariantProduct1.Mapper();

      final AsStandardProduct1.Mapper asStandardProduct1FieldMapper = new AsStandardProduct1.Mapper();

      @Override
      public FulfilmentOrderItemProduct map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final AsVariantProduct1 asVariantProduct = reader.readConditional($responseFields[1], new ResponseReader.ConditionalTypeReader<AsVariantProduct1>() {
          @Override
          public AsVariantProduct1 read(String conditionalType, ResponseReader reader) {
            return asVariantProduct1FieldMapper.map(reader);
          }
        });
        final AsStandardProduct1 asStandardProduct = reader.readConditional($responseFields[2], new ResponseReader.ConditionalTypeReader<AsStandardProduct1>() {
          @Override
          public AsStandardProduct1 read(String conditionalType, ResponseReader reader) {
            return asStandardProduct1FieldMapper.map(reader);
          }
        });
        return new FulfilmentOrderItemProduct(__typename, asVariantProduct, asStandardProduct);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable AsVariantProduct1 asVariantProduct;

      private @Nullable AsStandardProduct1 asStandardProduct;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder asVariantProduct(@Nullable AsVariantProduct1 asVariantProduct) {
        this.asVariantProduct = asVariantProduct;
        return this;
      }

      public Builder asStandardProduct(@Nullable AsStandardProduct1 asStandardProduct) {
        this.asStandardProduct = asStandardProduct;
        return this;
      }

      public Builder asVariantProduct(@Nonnull Mutator<AsVariantProduct1.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        AsVariantProduct1.Builder builder = this.asVariantProduct != null ? this.asVariantProduct.toBuilder() : AsVariantProduct1.builder();
        mutator.accept(builder);
        this.asVariantProduct = builder.build();
        return this;
      }

      public Builder asStandardProduct(@Nonnull Mutator<AsStandardProduct1.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        AsStandardProduct1.Builder builder = this.asStandardProduct != null ? this.asStandardProduct.toBuilder() : AsStandardProduct1.builder();
        mutator.accept(builder);
        this.asStandardProduct = builder.build();
        return this;
      }

      public FulfilmentOrderItemProduct build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FulfilmentOrderItemProduct(__typename, asVariantProduct, asStandardProduct);
      }
    }
  }

  public static class AsVariantProduct1 {
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

    public AsVariantProduct1(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
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
        $toString = "AsVariantProduct1{"
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
      if (o instanceof AsVariantProduct1) {
        AsVariantProduct1 that = (AsVariantProduct1) o;
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

    public static final class Mapper implements ResponseFieldMapper<AsVariantProduct1> {
      @Override
      public AsVariantProduct1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        return new AsVariantProduct1(__typename, id, ref);
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

      public AsVariantProduct1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        return new AsVariantProduct1(__typename, id, ref);
      }
    }
  }

  public static class AsStandardProduct1 {
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

    public AsStandardProduct1(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
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
        $toString = "AsStandardProduct1{"
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
      if (o instanceof AsStandardProduct1) {
        AsStandardProduct1 that = (AsStandardProduct1) o;
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

    public static final class Mapper implements ResponseFieldMapper<AsStandardProduct1> {
      @Override
      public AsStandardProduct1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        return new AsStandardProduct1(__typename, id, ref);
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

      public AsStandardProduct1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        return new AsStandardProduct1(__typename, id, ref);
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

  public static class PageInfo2 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("hasNextPage", "hasNextPage", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Boolean hasNextPage;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PageInfo2(@Nonnull String __typename, @Nullable Boolean hasNextPage) {
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
        $toString = "PageInfo2{"
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
      if (o instanceof PageInfo2) {
        PageInfo2 that = (PageInfo2) o;
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

    public static final class Mapper implements ResponseFieldMapper<PageInfo2> {
      @Override
      public PageInfo2 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Boolean hasNextPage = reader.readBoolean($responseFields[1]);
        return new PageInfo2(__typename, hasNextPage);
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

      public PageInfo2 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new PageInfo2(__typename, hasNextPage);
      }
    }
  }

  public static class Customer {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("title", "title", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("firstName", "firstName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("lastName", "lastName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("username", "username", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("primaryEmail", "primaryEmail", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("primaryPhone", "primaryPhone", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String title;

    final @Nullable String country;

    final @Nullable String firstName;

    final @Nullable String lastName;

    final @Nullable String username;

    final @Nullable String primaryEmail;

    final @Nullable String primaryPhone;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Customer(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String title, @Nullable String country, @Nullable String firstName,
        @Nullable String lastName, @Nullable String username, @Nullable String primaryEmail,
        @Nullable String primaryPhone) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.title = title;
      this.country = country;
      this.firstName = firstName;
      this.lastName = lastName;
      this.username = username;
      this.primaryEmail = primaryEmail;
      this.primaryPhone = primaryPhone;
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
     *  Username of the customer
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  The customer's title
     */
    public @Nullable String title() {
      return this.title;
    }

    /**
     *  The country the customer is operating from
     */
    public @Nullable String country() {
      return this.country;
    }

    /**
     *  The customer's first name
     */
    public @Nullable String firstName() {
      return this.firstName;
    }

    /**
     *  The customer's last name
     */
    public @Nullable String lastName() {
      return this.lastName;
    }

    /**
     *  Username
     */
    public @Nullable String username() {
      return this.username;
    }

    /**
     *  Email
     */
    public @Nullable String primaryEmail() {
      return this.primaryEmail;
    }

    /**
     *  Phone number
     */
    public @Nullable String primaryPhone() {
      return this.primaryPhone;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], title);
          writer.writeString($responseFields[4], country);
          writer.writeString($responseFields[5], firstName);
          writer.writeString($responseFields[6], lastName);
          writer.writeString($responseFields[7], username);
          writer.writeString($responseFields[8], primaryEmail);
          writer.writeString($responseFields[9], primaryPhone);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Customer{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "title=" + title + ", "
          + "country=" + country + ", "
          + "firstName=" + firstName + ", "
          + "lastName=" + lastName + ", "
          + "username=" + username + ", "
          + "primaryEmail=" + primaryEmail + ", "
          + "primaryPhone=" + primaryPhone
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Customer) {
        Customer that = (Customer) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.title == null) ? (that.title == null) : this.title.equals(that.title))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
         && ((this.firstName == null) ? (that.firstName == null) : this.firstName.equals(that.firstName))
         && ((this.lastName == null) ? (that.lastName == null) : this.lastName.equals(that.lastName))
         && ((this.username == null) ? (that.username == null) : this.username.equals(that.username))
         && ((this.primaryEmail == null) ? (that.primaryEmail == null) : this.primaryEmail.equals(that.primaryEmail))
         && ((this.primaryPhone == null) ? (that.primaryPhone == null) : this.primaryPhone.equals(that.primaryPhone));
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
        h ^= (title == null) ? 0 : title.hashCode();
        h *= 1000003;
        h ^= (country == null) ? 0 : country.hashCode();
        h *= 1000003;
        h ^= (firstName == null) ? 0 : firstName.hashCode();
        h *= 1000003;
        h ^= (lastName == null) ? 0 : lastName.hashCode();
        h *= 1000003;
        h ^= (username == null) ? 0 : username.hashCode();
        h *= 1000003;
        h ^= (primaryEmail == null) ? 0 : primaryEmail.hashCode();
        h *= 1000003;
        h ^= (primaryPhone == null) ? 0 : primaryPhone.hashCode();
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
      builder.title = title;
      builder.country = country;
      builder.firstName = firstName;
      builder.lastName = lastName;
      builder.username = username;
      builder.primaryEmail = primaryEmail;
      builder.primaryPhone = primaryPhone;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Customer> {
      @Override
      public Customer map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String title = reader.readString($responseFields[3]);
        final String country = reader.readString($responseFields[4]);
        final String firstName = reader.readString($responseFields[5]);
        final String lastName = reader.readString($responseFields[6]);
        final String username = reader.readString($responseFields[7]);
        final String primaryEmail = reader.readString($responseFields[8]);
        final String primaryPhone = reader.readString($responseFields[9]);
        return new Customer(__typename, id, ref, title, country, firstName, lastName, username, primaryEmail, primaryPhone);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String title;

      private @Nullable String country;

      private @Nullable String firstName;

      private @Nullable String lastName;

      private @Nullable String username;

      private @Nullable String primaryEmail;

      private @Nullable String primaryPhone;

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

      public Builder title(@Nullable String title) {
        this.title = title;
        return this;
      }

      public Builder country(@Nullable String country) {
        this.country = country;
        return this;
      }

      public Builder firstName(@Nullable String firstName) {
        this.firstName = firstName;
        return this;
      }

      public Builder lastName(@Nullable String lastName) {
        this.lastName = lastName;
        return this;
      }

      public Builder username(@Nullable String username) {
        this.username = username;
        return this;
      }

      public Builder primaryEmail(@Nullable String primaryEmail) {
        this.primaryEmail = primaryEmail;
        return this;
      }

      public Builder primaryPhone(@Nullable String primaryPhone) {
        this.primaryPhone = primaryPhone;
        return this;
      }

      public Customer build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Customer(__typename, id, ref, title, country, firstName, lastName, username, primaryEmail, primaryPhone);
      }
    }
  }

  public static class OrderAttribute {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("value", "value", null, false, CustomType.JSON, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String name;

    final @Nonnull Object value;

    final @Nonnull String type;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OrderAttribute(@Nonnull String __typename, @Nonnull String name, @Nonnull Object value,
        @Nonnull String type) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.name = Utils.checkNotNull(name, "name == null");
      this.value = Utils.checkNotNull(value, "value == null");
      this.type = Utils.checkNotNull(type, "type == null");
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
     *  Value of the `attribute`
     */
    public @Nonnull Object value() {
      return this.value;
    }

    /**
     *  Type of the attribute's `value`. This is a free string and can be used by the client to interpret and cast the `value` into the appropriate type.
     */
    public @Nonnull String type() {
      return this.type;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], name);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], value);
          writer.writeString($responseFields[3], type);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OrderAttribute{"
          + "__typename=" + __typename + ", "
          + "name=" + name + ", "
          + "value=" + value + ", "
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
      if (o instanceof OrderAttribute) {
        OrderAttribute that = (OrderAttribute) o;
        return this.__typename.equals(that.__typename)
         && this.name.equals(that.name)
         && this.value.equals(that.value)
         && this.type.equals(that.type);
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
        h ^= value.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.name = name;
      builder.value = value;
      builder.type = type;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<OrderAttribute> {
      @Override
      public OrderAttribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        return new OrderAttribute(__typename, name, value, type);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String name;

      private @Nonnull Object value;

      private @Nonnull String type;

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

      public Builder value(@Nonnull Object value) {
        this.value = value;
        return this;
      }

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public OrderAttribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(value, "value == null");
        Utils.checkNotNull(type, "type == null");
        return new OrderAttribute(__typename, name, value, type);
      }
    }
  }

  public static class FulfilmentChoice {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("currency", "currency", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("deliveryInstruction", "deliveryInstruction", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("fulfilmentPrice", "fulfilmentPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("deliveryType", "deliveryType", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("fulfilmentType", "fulfilmentType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("fulfilmentTaxPrice", "fulfilmentTaxPrice", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("pickupLocationRef", "pickupLocationRef", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("deliveryAddress", "deliveryAddress", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable String currency;

    final @Nullable String deliveryInstruction;

    final @Nullable Double fulfilmentPrice;

    final @Nonnull String deliveryType;

    final @Nullable String fulfilmentType;

    final @Nullable Double fulfilmentTaxPrice;

    final @Nullable String pickupLocationRef;

    final @Nullable DeliveryAddress deliveryAddress;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentChoice(@Nonnull String __typename, @Nonnull String id,
        @Nullable Object createdOn, @Nullable Object updatedOn, @Nullable String currency,
        @Nullable String deliveryInstruction, @Nullable Double fulfilmentPrice,
        @Nonnull String deliveryType, @Nullable String fulfilmentType,
        @Nullable Double fulfilmentTaxPrice, @Nullable String pickupLocationRef,
        @Nullable DeliveryAddress deliveryAddress) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.currency = currency;
      this.deliveryInstruction = deliveryInstruction;
      this.fulfilmentPrice = fulfilmentPrice;
      this.deliveryType = Utils.checkNotNull(deliveryType, "deliveryType == null");
      this.fulfilmentType = fulfilmentType;
      this.fulfilmentTaxPrice = fulfilmentTaxPrice;
      this.pickupLocationRef = pickupLocationRef;
      this.deliveryAddress = deliveryAddress;
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
     *  The type of currency, 3 letter ISO currency code
     */
    public @Nullable String currency() {
      return this.currency;
    }

    /**
     *  Instruction provided by the customer (250 character limit)
     */
    public @Nullable String deliveryInstruction() {
      return this.deliveryInstruction;
    }

    /**
     *  FulfilmentPrice refers to shipping fees if order type is Home Delivery HD and C&C fees for Click & Collect orders
     */
    public @Nullable Double fulfilmentPrice() {
      return this.fulfilmentPrice;
    }

    /**
     *  The type of delivey determined by retailers' shipping options. Example values are STANDARD, EXPRESS, OVERNIGHT, 3HOURS
     */
    public @Nonnull String deliveryType() {
      return this.deliveryType;
    }

    /**
     *  Indicates the type of fulfilment. Possible values are CC_PFS ( Click & Collect - Pick from Store), CC_PFDC ( Click & Collect - Pick from DC), HD_PFS (Home Delivery - Pick
     *  from Store), HD_PFDC ( Home Delivery - Pick from DC)
     */
    public @Nullable String fulfilmentType() {
      return this.fulfilmentType;
    }

    /**
     *  This refers to the tax cost associated with the fulfilment price
     */
    public @Nullable Double fulfilmentTaxPrice() {
      return this.fulfilmentTaxPrice;
    }

    /**
     *  Pickup location. This is required for click & collect orders
     */
    public @Nullable String pickupLocationRef() {
      return this.pickupLocationRef;
    }

    /**
     *  Location of fulfilment choice
     */
    public @Nullable DeliveryAddress deliveryAddress() {
      return this.deliveryAddress;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], createdOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[3], updatedOn);
          writer.writeString($responseFields[4], currency);
          writer.writeString($responseFields[5], deliveryInstruction);
          writer.writeDouble($responseFields[6], fulfilmentPrice);
          writer.writeString($responseFields[7], deliveryType);
          writer.writeString($responseFields[8], fulfilmentType);
          writer.writeDouble($responseFields[9], fulfilmentTaxPrice);
          writer.writeString($responseFields[10], pickupLocationRef);
          writer.writeObject($responseFields[11], deliveryAddress != null ? deliveryAddress.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentChoice{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "currency=" + currency + ", "
          + "deliveryInstruction=" + deliveryInstruction + ", "
          + "fulfilmentPrice=" + fulfilmentPrice + ", "
          + "deliveryType=" + deliveryType + ", "
          + "fulfilmentType=" + fulfilmentType + ", "
          + "fulfilmentTaxPrice=" + fulfilmentTaxPrice + ", "
          + "pickupLocationRef=" + pickupLocationRef + ", "
          + "deliveryAddress=" + deliveryAddress
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FulfilmentChoice) {
        FulfilmentChoice that = (FulfilmentChoice) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.currency == null) ? (that.currency == null) : this.currency.equals(that.currency))
         && ((this.deliveryInstruction == null) ? (that.deliveryInstruction == null) : this.deliveryInstruction.equals(that.deliveryInstruction))
         && ((this.fulfilmentPrice == null) ? (that.fulfilmentPrice == null) : this.fulfilmentPrice.equals(that.fulfilmentPrice))
         && this.deliveryType.equals(that.deliveryType)
         && ((this.fulfilmentType == null) ? (that.fulfilmentType == null) : this.fulfilmentType.equals(that.fulfilmentType))
         && ((this.fulfilmentTaxPrice == null) ? (that.fulfilmentTaxPrice == null) : this.fulfilmentTaxPrice.equals(that.fulfilmentTaxPrice))
         && ((this.pickupLocationRef == null) ? (that.pickupLocationRef == null) : this.pickupLocationRef.equals(that.pickupLocationRef))
         && ((this.deliveryAddress == null) ? (that.deliveryAddress == null) : this.deliveryAddress.equals(that.deliveryAddress));
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
        h ^= (currency == null) ? 0 : currency.hashCode();
        h *= 1000003;
        h ^= (deliveryInstruction == null) ? 0 : deliveryInstruction.hashCode();
        h *= 1000003;
        h ^= (fulfilmentPrice == null) ? 0 : fulfilmentPrice.hashCode();
        h *= 1000003;
        h ^= deliveryType.hashCode();
        h *= 1000003;
        h ^= (fulfilmentType == null) ? 0 : fulfilmentType.hashCode();
        h *= 1000003;
        h ^= (fulfilmentTaxPrice == null) ? 0 : fulfilmentTaxPrice.hashCode();
        h *= 1000003;
        h ^= (pickupLocationRef == null) ? 0 : pickupLocationRef.hashCode();
        h *= 1000003;
        h ^= (deliveryAddress == null) ? 0 : deliveryAddress.hashCode();
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
      builder.currency = currency;
      builder.deliveryInstruction = deliveryInstruction;
      builder.fulfilmentPrice = fulfilmentPrice;
      builder.deliveryType = deliveryType;
      builder.fulfilmentType = fulfilmentType;
      builder.fulfilmentTaxPrice = fulfilmentTaxPrice;
      builder.pickupLocationRef = pickupLocationRef;
      builder.deliveryAddress = deliveryAddress;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentChoice> {
      final DeliveryAddress.Mapper deliveryAddressFieldMapper = new DeliveryAddress.Mapper();

      @Override
      public FulfilmentChoice map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        final String currency = reader.readString($responseFields[4]);
        final String deliveryInstruction = reader.readString($responseFields[5]);
        final Double fulfilmentPrice = reader.readDouble($responseFields[6]);
        final String deliveryType = reader.readString($responseFields[7]);
        final String fulfilmentType = reader.readString($responseFields[8]);
        final Double fulfilmentTaxPrice = reader.readDouble($responseFields[9]);
        final String pickupLocationRef = reader.readString($responseFields[10]);
        final DeliveryAddress deliveryAddress = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<DeliveryAddress>() {
          @Override
          public DeliveryAddress read(ResponseReader reader) {
            return deliveryAddressFieldMapper.map(reader);
          }
        });
        return new FulfilmentChoice(__typename, id, createdOn, updatedOn, currency, deliveryInstruction, fulfilmentPrice, deliveryType, fulfilmentType, fulfilmentTaxPrice, pickupLocationRef, deliveryAddress);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

      private @Nullable String currency;

      private @Nullable String deliveryInstruction;

      private @Nullable Double fulfilmentPrice;

      private @Nonnull String deliveryType;

      private @Nullable String fulfilmentType;

      private @Nullable Double fulfilmentTaxPrice;

      private @Nullable String pickupLocationRef;

      private @Nullable DeliveryAddress deliveryAddress;

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

      public Builder currency(@Nullable String currency) {
        this.currency = currency;
        return this;
      }

      public Builder deliveryInstruction(@Nullable String deliveryInstruction) {
        this.deliveryInstruction = deliveryInstruction;
        return this;
      }

      public Builder fulfilmentPrice(@Nullable Double fulfilmentPrice) {
        this.fulfilmentPrice = fulfilmentPrice;
        return this;
      }

      public Builder deliveryType(@Nonnull String deliveryType) {
        this.deliveryType = deliveryType;
        return this;
      }

      public Builder fulfilmentType(@Nullable String fulfilmentType) {
        this.fulfilmentType = fulfilmentType;
        return this;
      }

      public Builder fulfilmentTaxPrice(@Nullable Double fulfilmentTaxPrice) {
        this.fulfilmentTaxPrice = fulfilmentTaxPrice;
        return this;
      }

      public Builder pickupLocationRef(@Nullable String pickupLocationRef) {
        this.pickupLocationRef = pickupLocationRef;
        return this;
      }

      public Builder deliveryAddress(@Nullable DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
      }

      public Builder deliveryAddress(@Nonnull Mutator<DeliveryAddress.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        DeliveryAddress.Builder builder = this.deliveryAddress != null ? this.deliveryAddress.toBuilder() : DeliveryAddress.builder();
        mutator.accept(builder);
        this.deliveryAddress = builder.build();
        return this;
      }

      public FulfilmentChoice build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(deliveryType, "deliveryType == null");
        return new FulfilmentChoice(__typename, id, createdOn, updatedOn, currency, deliveryInstruction, fulfilmentPrice, deliveryType, fulfilmentType, fulfilmentTaxPrice, pickupLocationRef, deliveryAddress);
      }
    }
  }

  public static class DeliveryAddress {
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
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("latitude", "latitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("longitude", "longitude", null, true, Collections.<ResponseField.Condition>emptyList())
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

    final @Nullable String ref;

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public DeliveryAddress(@Nonnull String __typename, @Nonnull String id, @Nullable String type,
        @Nullable String companyName, @Nullable String name, @Nullable String street,
        @Nullable String city, @Nullable String state, @Nullable String postcode,
        @Nullable String region, @Nullable String country, @Nullable String ref,
        @Nullable Double latitude, @Nullable Double longitude) {
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
      this.ref = ref;
      this.latitude = latitude;
      this.longitude = longitude;
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
          writer.writeString($responseFields[11], ref);
          writer.writeDouble($responseFields[12], latitude);
          writer.writeDouble($responseFields[13], longitude);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "DeliveryAddress{"
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
      if (o instanceof DeliveryAddress) {
        DeliveryAddress that = (DeliveryAddress) o;
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
      builder.ref = ref;
      builder.latitude = latitude;
      builder.longitude = longitude;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<DeliveryAddress> {
      @Override
      public DeliveryAddress map(ResponseReader reader) {
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
        final String ref = reader.readString($responseFields[11]);
        final Double latitude = reader.readDouble($responseFields[12]);
        final Double longitude = reader.readDouble($responseFields[13]);
        return new DeliveryAddress(__typename, id, type, companyName, name, street, city, state, postcode, region, country, ref, latitude, longitude);
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

      private @Nullable String ref;

      private @Nullable Double latitude;

      private @Nullable Double longitude;

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

      public DeliveryAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new DeliveryAddress(__typename, id, type, companyName, name, street, city, state, postcode, region, country, ref, latitude, longitude);
      }
    }
  }
}
