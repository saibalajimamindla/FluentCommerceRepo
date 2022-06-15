package com.fluentcommerce.commonv2.graphql.query.article;

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
public final class GetArticleByIdQuery implements Query<GetArticleByIdQuery.Data, GetArticleByIdQuery.Data, GetArticleByIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetArticleById($id: ID!, $includeAttributes: Boolean!, $includeItems: Boolean!, $includeOrder: Boolean!, $includeFulfilments: Boolean!, $itemsCount: Int, $itemsCursor: String, $fulfilmentsCount: Int, $fulfilmentsCursor: String) {\n"
      + "  articleById(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    type\n"
      + "    status\n"
      + "    createdOn\n"
      + "    updatedOn\n"
      + "    attributes @include(if: $includeAttributes) {\n"
      + "      __typename\n"
      + "      name\n"
      + "      type\n"
      + "      value\n"
      + "    }\n"
      + "    description\n"
      + "    height\n"
      + "    length\n"
      + "    name\n"
      + "    weight\n"
      + "    width\n"
      + "    quantity\n"
      + "    items(first: $itemsCount, after: $itemsCursor) @include(if: $includeItems) {\n"
      + "      __typename\n"
      + "      itemsEdge: edges {\n"
      + "        __typename\n"
      + "        item: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          quantity\n"
      + "          barcode\n"
      + "          updatedOn\n"
      + "          createdOn\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "    fulfilments(first: $fulfilmentsCount, after: $fulfilmentsCursor) @include(if: $includeFulfilments) {\n"
      + "      __typename\n"
      + "      fulfilmentEdge: edges {\n"
      + "        __typename\n"
      + "        fulfilment: node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "          status\n"
      + "          createdOn\n"
      + "          updatedOn\n"
      + "          attributes {\n"
      + "            __typename\n"
      + "            name\n"
      + "            type\n"
      + "            value\n"
      + "          }\n"
      + "          deliveryType\n"
      + "          type\n"
      + "          eta\n"
      + "          expiryTime\n"
      + "          order @include(if: $includeOrder) {\n"
      + "            __typename\n"
      + "            id\n"
      + "            ref\n"
      + "            type\n"
      + "            status\n"
      + "            createdOn\n"
      + "            updatedOn\n"
      + "            attributes {\n"
      + "              __typename\n"
      + "              name\n"
      + "              type\n"
      + "              value\n"
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
      return "GetArticleById";
    }
  };

  private final GetArticleByIdQuery.Variables variables;

  public GetArticleByIdQuery(@Nonnull String id, boolean includeAttributes, boolean includeItems,
      boolean includeOrder, boolean includeFulfilments, @Nullable Integer itemsCount,
      @Nullable String itemsCursor, @Nullable Integer fulfilmentsCount,
      @Nullable String fulfilmentsCursor) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetArticleByIdQuery.Variables(id, includeAttributes, includeItems, includeOrder, includeFulfilments, itemsCount, itemsCursor, fulfilmentsCount, fulfilmentsCursor);
  }

  @Override
  public String operationId() {
    return "dca2f6456c2086c32b9b32078c72da2b3a29811c16b6b894d176f18629427c43";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetArticleByIdQuery.Data wrapData(GetArticleByIdQuery.Data data) {
    return data;
  }

  @Override
  public GetArticleByIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetArticleByIdQuery.Data> responseFieldMapper() {
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

    private boolean includeOrder;

    private boolean includeFulfilments;

    private @Nullable Integer itemsCount;

    private @Nullable String itemsCursor;

    private @Nullable Integer fulfilmentsCount;

    private @Nullable String fulfilmentsCursor;

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

    public Builder includeOrder(boolean includeOrder) {
      this.includeOrder = includeOrder;
      return this;
    }

    public Builder includeFulfilments(boolean includeFulfilments) {
      this.includeFulfilments = includeFulfilments;
      return this;
    }

    public Builder itemsCount(@Nullable Integer itemsCount) {
      this.itemsCount = itemsCount;
      return this;
    }

    public Builder itemsCursor(@Nullable String itemsCursor) {
      this.itemsCursor = itemsCursor;
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

    public GetArticleByIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetArticleByIdQuery(id, includeAttributes, includeItems, includeOrder, includeFulfilments, itemsCount, itemsCursor, fulfilmentsCount, fulfilmentsCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final boolean includeAttributes;

    private final boolean includeItems;

    private final boolean includeOrder;

    private final boolean includeFulfilments;

    private final @Nullable Integer itemsCount;

    private final @Nullable String itemsCursor;

    private final @Nullable Integer fulfilmentsCount;

    private final @Nullable String fulfilmentsCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, boolean includeAttributes, boolean includeItems,
        boolean includeOrder, boolean includeFulfilments, @Nullable Integer itemsCount,
        @Nullable String itemsCursor, @Nullable Integer fulfilmentsCount,
        @Nullable String fulfilmentsCursor) {
      this.id = id;
      this.includeAttributes = includeAttributes;
      this.includeItems = includeItems;
      this.includeOrder = includeOrder;
      this.includeFulfilments = includeFulfilments;
      this.itemsCount = itemsCount;
      this.itemsCursor = itemsCursor;
      this.fulfilmentsCount = fulfilmentsCount;
      this.fulfilmentsCursor = fulfilmentsCursor;
      this.valueMap.put("id", id);
      this.valueMap.put("includeAttributes", includeAttributes);
      this.valueMap.put("includeItems", includeItems);
      this.valueMap.put("includeOrder", includeOrder);
      this.valueMap.put("includeFulfilments", includeFulfilments);
      this.valueMap.put("itemsCount", itemsCount);
      this.valueMap.put("itemsCursor", itemsCursor);
      this.valueMap.put("fulfilmentsCount", fulfilmentsCount);
      this.valueMap.put("fulfilmentsCursor", fulfilmentsCursor);
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

    public boolean includeOrder() {
      return includeOrder;
    }

    public boolean includeFulfilments() {
      return includeFulfilments;
    }

    public @Nullable Integer itemsCount() {
      return itemsCount;
    }

    public @Nullable String itemsCursor() {
      return itemsCursor;
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
          writer.writeCustom("id", com.fluentretail.graphql.type.CustomType.ID, id);
          writer.writeBoolean("includeAttributes", includeAttributes);
          writer.writeBoolean("includeItems", includeItems);
          writer.writeBoolean("includeOrder", includeOrder);
          writer.writeBoolean("includeFulfilments", includeFulfilments);
          writer.writeInt("itemsCount", itemsCount);
          writer.writeString("itemsCursor", itemsCursor);
          writer.writeInt("fulfilmentsCount", fulfilmentsCount);
          writer.writeString("fulfilmentsCursor", fulfilmentsCursor);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("articleById", "articleById", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable ArticleById articleById;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable ArticleById articleById) {
      this.articleById = articleById;
    }

    /**
     *  Find a Article entity
     */
    public @Nullable ArticleById articleById() {
      return this.articleById;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], articleById != null ? articleById.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "articleById=" + articleById
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
        return ((this.articleById == null) ? (that.articleById == null) : this.articleById.equals(that.articleById));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (articleById == null) ? 0 : articleById.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.articleById = articleById;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final ArticleById.Mapper articleByIdFieldMapper = new ArticleById.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final ArticleById articleById = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<ArticleById>() {
          @Override
          public ArticleById read(ResponseReader reader) {
            return articleByIdFieldMapper.map(reader);
          }
        });
        return new Data(articleById);
      }
    }

    public static final class Builder {
      private @Nullable ArticleById articleById;

      Builder() {
      }

      public Builder articleById(@Nullable ArticleById articleById) {
        this.articleById = articleById;
        return this;
      }

      public Builder articleById(@Nonnull Mutator<ArticleById.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ArticleById.Builder builder = this.articleById != null ? this.articleById.toBuilder() : ArticleById.builder();
        mutator.accept(builder);
        this.articleById = builder.build();
        return this;
      }

      public Data build() {
        return new Data(articleById);
      }
    }
  }

  public static class ArticleById {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeAttributes", false))),
      ResponseField.forString("description", "description", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("height", "height", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("length", "length", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("weight", "weight", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("width", "width", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("items", "items", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "itemsCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "itemsCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeItems", false))),
      ResponseField.forObject("fulfilments", "fulfilments", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentsCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentsCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeFulfilments", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable List<Attribute> attributes;

    final @Nullable String description;

    final double height;

    final double length;

    final @Nullable String name;

    final double weight;

    final double width;

    final @Nullable Integer quantity;

    final @Nullable Items items;

    final @Nullable Fulfilments fulfilments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ArticleById(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable Object createdOn,
        @Nullable Object updatedOn, @Nullable List<Attribute> attributes,
        @Nullable String description, double height, double length, @Nullable String name,
        double weight, double width, @Nullable Integer quantity, @Nullable Items items,
        @Nullable Fulfilments fulfilments) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.attributes = attributes;
      this.description = description;
      this.height = height;
      this.length = length;
      this.name = name;
      this.weight = weight;
      this.width = width;
      this.quantity = quantity;
      this.items = items;
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
     *  The unique article reference provided by the retailer
     */
    public @Nullable String ref() {
      return this.ref;
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
     *  Attributes of article
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    /**
     *  Description
     */
    public @Nullable String description() {
      return this.description;
    }

    /**
     *  Height
     */
    public double height() {
      return this.height;
    }

    /**
     *  Length
     */
    public double length() {
      return this.length;
    }

    /**
     *  Name
     */
    public @Nullable String name() {
      return this.name;
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
     *  Quantity
     */
    public @Nullable Integer quantity() {
      return this.quantity;
    }

    /**
     *  Items within this article
     */
    public @Nullable Items items() {
      return this.items;
    }

    /**
     *  Fulfilments associated with this article
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
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[5], createdOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[6], updatedOn);
          writer.writeList($responseFields[7], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeString($responseFields[8], description);
          writer.writeDouble($responseFields[9], height);
          writer.writeDouble($responseFields[10], length);
          writer.writeString($responseFields[11], name);
          writer.writeDouble($responseFields[12], weight);
          writer.writeDouble($responseFields[13], width);
          writer.writeInt($responseFields[14], quantity);
          writer.writeObject($responseFields[15], items != null ? items.marshaller() : null);
          writer.writeObject($responseFields[16], fulfilments != null ? fulfilments.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ArticleById{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "attributes=" + attributes + ", "
          + "description=" + description + ", "
          + "height=" + height + ", "
          + "length=" + length + ", "
          + "name=" + name + ", "
          + "weight=" + weight + ", "
          + "width=" + width + ", "
          + "quantity=" + quantity + ", "
          + "items=" + items + ", "
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
      if (o instanceof ArticleById) {
        ArticleById that = (ArticleById) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.type.equals(that.type)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.description == null) ? (that.description == null) : this.description.equals(that.description))
         && Double.doubleToLongBits(this.height) == Double.doubleToLongBits(that.height)
         && Double.doubleToLongBits(this.length) == Double.doubleToLongBits(that.length)
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(that.weight)
         && Double.doubleToLongBits(this.width) == Double.doubleToLongBits(that.width)
         && ((this.quantity == null) ? (that.quantity == null) : this.quantity.equals(that.quantity))
         && ((this.items == null) ? (that.items == null) : this.items.equals(that.items))
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
        h ^= (createdOn == null) ? 0 : createdOn.hashCode();
        h *= 1000003;
        h ^= (updatedOn == null) ? 0 : updatedOn.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (description == null) ? 0 : description.hashCode();
        h *= 1000003;
        h ^= Double.valueOf(height).hashCode();
        h *= 1000003;
        h ^= Double.valueOf(length).hashCode();
        h *= 1000003;
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= Double.valueOf(weight).hashCode();
        h *= 1000003;
        h ^= Double.valueOf(width).hashCode();
        h *= 1000003;
        h ^= (quantity == null) ? 0 : quantity.hashCode();
        h *= 1000003;
        h ^= (items == null) ? 0 : items.hashCode();
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
      builder.createdOn = createdOn;
      builder.updatedOn = updatedOn;
      builder.attributes = attributes;
      builder.description = description;
      builder.height = height;
      builder.length = length;
      builder.name = name;
      builder.weight = weight;
      builder.width = width;
      builder.quantity = quantity;
      builder.items = items;
      builder.fulfilments = fulfilments;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ArticleById> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final Items.Mapper itemsFieldMapper = new Items.Mapper();

      final Fulfilments.Mapper fulfilmentsFieldMapper = new Fulfilments.Mapper();

      @Override
      public ArticleById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[6]);
        final List<Attribute> attributes = reader.readList($responseFields[7], new ResponseReader.ListReader<Attribute>() {
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
        final String description = reader.readString($responseFields[8]);
        final double height = reader.readDouble($responseFields[9]);
        final double length = reader.readDouble($responseFields[10]);
        final String name = reader.readString($responseFields[11]);
        final double weight = reader.readDouble($responseFields[12]);
        final double width = reader.readDouble($responseFields[13]);
        final Integer quantity = reader.readInt($responseFields[14]);
        final Items items = reader.readObject($responseFields[15], new ResponseReader.ObjectReader<Items>() {
          @Override
          public Items read(ResponseReader reader) {
            return itemsFieldMapper.map(reader);
          }
        });
        final Fulfilments fulfilments = reader.readObject($responseFields[16], new ResponseReader.ObjectReader<Fulfilments>() {
          @Override
          public Fulfilments read(ResponseReader reader) {
            return fulfilmentsFieldMapper.map(reader);
          }
        });
        return new ArticleById(__typename, id, ref, type, status, createdOn, updatedOn, attributes, description, height, length, name, weight, width, quantity, items, fulfilments);
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

      private @Nullable List<Attribute> attributes;

      private @Nullable String description;

      private double height;

      private double length;

      private @Nullable String name;

      private double weight;

      private double width;

      private @Nullable Integer quantity;

      private @Nullable Items items;

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

      public Builder createdOn(@Nullable Object createdOn) {
        this.createdOn = createdOn;
        return this;
      }

      public Builder updatedOn(@Nullable Object updatedOn) {
        this.updatedOn = updatedOn;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder description(@Nullable String description) {
        this.description = description;
        return this;
      }

      public Builder height(double height) {
        this.height = height;
        return this;
      }

      public Builder length(double length) {
        this.length = length;
        return this;
      }

      public Builder name(@Nullable String name) {
        this.name = name;
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

      public Builder quantity(@Nullable Integer quantity) {
        this.quantity = quantity;
        return this;
      }

      public Builder items(@Nullable Items items) {
        this.items = items;
        return this;
      }

      public Builder fulfilments(@Nullable Fulfilments fulfilments) {
        this.fulfilments = fulfilments;
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

      public Builder fulfilments(@Nonnull Mutator<Fulfilments.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Fulfilments.Builder builder = this.fulfilments != null ? this.fulfilments.toBuilder() : Fulfilments.builder();
        mutator.accept(builder);
        this.fulfilments = builder.build();
        return this;
      }

      public ArticleById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new ArticleById(__typename, id, ref, type, status, createdOn, updatedOn, attributes, description, height, length, name, weight, width, quantity, items, fulfilments);
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
      ResponseField.forList("itemsEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<ItemsEdge> itemsEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Items(@Nonnull String __typename, @Nullable List<ItemsEdge> itemsEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.itemsEdge = itemsEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to ArticleItem type node
     */
    public @Nullable List<ItemsEdge> itemsEdge() {
      return this.itemsEdge;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], itemsEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((ItemsEdge) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Items{"
          + "__typename=" + __typename + ", "
          + "itemsEdge=" + itemsEdge
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
         && ((this.itemsEdge == null) ? (that.itemsEdge == null) : this.itemsEdge.equals(that.itemsEdge));
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
        h ^= (itemsEdge == null) ? 0 : itemsEdge.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.itemsEdge = itemsEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Items> {
      final ItemsEdge.Mapper itemsEdgeFieldMapper = new ItemsEdge.Mapper();

      @Override
      public Items map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<ItemsEdge> itemsEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<ItemsEdge>() {
          @Override
          public ItemsEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<ItemsEdge>() {
              @Override
              public ItemsEdge read(ResponseReader reader) {
                return itemsEdgeFieldMapper.map(reader);
              }
            });
          }
        });
        return new Items(__typename, itemsEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<ItemsEdge> itemsEdge;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder itemsEdge(@Nullable List<ItemsEdge> itemsEdge) {
        this.itemsEdge = itemsEdge;
        return this;
      }

      public Builder itemsEdge(@Nonnull Mutator<List<ItemsEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<ItemsEdge.Builder> builders = new ArrayList<>();
        if (this.itemsEdge != null) {
          for (ItemsEdge item : this.itemsEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<ItemsEdge> itemsEdge = new ArrayList<>();
        for (ItemsEdge.Builder item : builders) {
          itemsEdge.add(item != null ? item.build() : null);
        }
        this.itemsEdge = itemsEdge;
        return this;
      }

      public Items build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Items(__typename, itemsEdge);
      }
    }
  }

  public static class ItemsEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("item", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Item item;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ItemsEdge(@Nonnull String __typename, @Nullable Item item) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.item = item;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the ArticleItem edge
     */
    public @Nullable Item item() {
      return this.item;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], item != null ? item.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ItemsEdge{"
          + "__typename=" + __typename + ", "
          + "item=" + item
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ItemsEdge) {
        ItemsEdge that = (ItemsEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.item == null) ? (that.item == null) : this.item.equals(that.item));
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
        h ^= (item == null) ? 0 : item.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.item = item;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ItemsEdge> {
      final Item.Mapper itemFieldMapper = new Item.Mapper();

      @Override
      public ItemsEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Item item = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Item>() {
          @Override
          public Item read(ResponseReader reader) {
            return itemFieldMapper.map(reader);
          }
        });
        return new ItemsEdge(__typename, item);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Item item;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder item(@Nullable Item item) {
        this.item = item;
        return this;
      }

      public Builder item(@Nonnull Mutator<Item.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Item.Builder builder = this.item != null ? this.item.toBuilder() : Item.builder();
        mutator.accept(builder);
        this.item = builder.build();
        return this;
      }

      public ItemsEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ItemsEdge(__typename, item);
      }
    }
  }

  public static class Item {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("barcode", "barcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final int quantity;

    final @Nullable String barcode;

    final @Nullable Object updatedOn;

    final @Nullable Object createdOn;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Item(@Nonnull String __typename, @Nonnull String id, int quantity,
        @Nullable String barcode, @Nullable Object updatedOn, @Nullable Object createdOn) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.quantity = quantity;
      this.barcode = barcode;
      this.updatedOn = updatedOn;
      this.createdOn = createdOn;
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
     *  Quantity of article item
     */
    public int quantity() {
      return this.quantity;
    }

    /**
     *  Barcode of article item
     */
    public @Nullable String barcode() {
      return this.barcode;
    }

    /**
     *  Time of last update
     */
    public @Nullable Object updatedOn() {
      return this.updatedOn;
    }

    /**
     *  Time of creation
     */
    public @Nullable Object createdOn() {
      return this.createdOn;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeInt($responseFields[2], quantity);
          writer.writeString($responseFields[3], barcode);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[4], updatedOn);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[5], createdOn);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Item{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "quantity=" + quantity + ", "
          + "barcode=" + barcode + ", "
          + "updatedOn=" + updatedOn + ", "
          + "createdOn=" + createdOn
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
         && this.id.equals(that.id)
         && this.quantity == that.quantity
         && ((this.barcode == null) ? (that.barcode == null) : this.barcode.equals(that.barcode))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn));
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
        h ^= quantity;
        h *= 1000003;
        h ^= (barcode == null) ? 0 : barcode.hashCode();
        h *= 1000003;
        h ^= (updatedOn == null) ? 0 : updatedOn.hashCode();
        h *= 1000003;
        h ^= (createdOn == null) ? 0 : createdOn.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      builder.quantity = quantity;
      builder.barcode = barcode;
      builder.updatedOn = updatedOn;
      builder.createdOn = createdOn;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Item> {
      @Override
      public Item map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final int quantity = reader.readInt($responseFields[2]);
        final String barcode = reader.readString($responseFields[3]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[4]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        return new Item(__typename, id, quantity, barcode, updatedOn, createdOn);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private int quantity;

      private @Nullable String barcode;

      private @Nullable Object updatedOn;

      private @Nullable Object createdOn;

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

      public Builder quantity(int quantity) {
        this.quantity = quantity;
        return this;
      }

      public Builder barcode(@Nullable String barcode) {
        this.barcode = barcode;
        return this;
      }

      public Builder updatedOn(@Nullable Object updatedOn) {
        this.updatedOn = updatedOn;
        return this;
      }

      public Builder createdOn(@Nullable Object createdOn) {
        this.createdOn = createdOn;
        return this;
      }

      public Item build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Item(__typename, id, quantity, barcode, updatedOn, createdOn);
      }
    }
  }

  public static class Fulfilments {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("fulfilmentEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<FulfilmentEdge> fulfilmentEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilments(@Nonnull String __typename, @Nullable List<FulfilmentEdge> fulfilmentEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilmentEdge = fulfilmentEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Fulfilment type node
     */
    public @Nullable List<FulfilmentEdge> fulfilmentEdge() {
      return this.fulfilmentEdge;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], fulfilmentEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((FulfilmentEdge) value).marshaller());
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
          + "fulfilmentEdge=" + fulfilmentEdge
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
         && ((this.fulfilmentEdge == null) ? (that.fulfilmentEdge == null) : this.fulfilmentEdge.equals(that.fulfilmentEdge));
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
        h ^= (fulfilmentEdge == null) ? 0 : fulfilmentEdge.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.fulfilmentEdge = fulfilmentEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Fulfilments> {
      final FulfilmentEdge.Mapper fulfilmentEdgeFieldMapper = new FulfilmentEdge.Mapper();

      @Override
      public Fulfilments map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<FulfilmentEdge> fulfilmentEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<FulfilmentEdge>() {
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
        return new Fulfilments(__typename, fulfilmentEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<FulfilmentEdge> fulfilmentEdge;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilmentEdge(@Nullable List<FulfilmentEdge> fulfilmentEdge) {
        this.fulfilmentEdge = fulfilmentEdge;
        return this;
      }

      public Builder fulfilmentEdge(@Nonnull Mutator<List<FulfilmentEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<FulfilmentEdge.Builder> builders = new ArrayList<>();
        if (this.fulfilmentEdge != null) {
          for (FulfilmentEdge item : this.fulfilmentEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<FulfilmentEdge> fulfilmentEdge = new ArrayList<>();
        for (FulfilmentEdge.Builder item : builders) {
          fulfilmentEdge.add(item != null ? item.build() : null);
        }
        this.fulfilmentEdge = fulfilmentEdge;
        return this;
      }

      public Fulfilments build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Fulfilments(__typename, fulfilmentEdge);
      }
    }
  }

  public static class FulfilmentEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilment", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Fulfilment fulfilment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentEdge(@Nonnull String __typename, @Nullable Fulfilment fulfilment) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilment = fulfilment;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Fulfilment edge
     */
    public @Nullable Fulfilment fulfilment() {
      return this.fulfilment;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], fulfilment != null ? fulfilment.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentEdge{"
          + "__typename=" + __typename + ", "
          + "fulfilment=" + fulfilment
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
         && ((this.fulfilment == null) ? (that.fulfilment == null) : this.fulfilment.equals(that.fulfilment));
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
        h ^= (fulfilment == null) ? 0 : fulfilment.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.fulfilment = fulfilment;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentEdge> {
      final Fulfilment.Mapper fulfilmentFieldMapper = new Fulfilment.Mapper();

      @Override
      public FulfilmentEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Fulfilment fulfilment = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Fulfilment>() {
          @Override
          public Fulfilment read(ResponseReader reader) {
            return fulfilmentFieldMapper.map(reader);
          }
        });
        return new FulfilmentEdge(__typename, fulfilment);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Fulfilment fulfilment;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilment(@Nullable Fulfilment fulfilment) {
        this.fulfilment = fulfilment;
        return this;
      }

      public Builder fulfilment(@Nonnull Mutator<Fulfilment.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Fulfilment.Builder builder = this.fulfilment != null ? this.fulfilment.toBuilder() : Fulfilment.builder();
        mutator.accept(builder);
        this.fulfilment = builder.build();
        return this;
      }

      public FulfilmentEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FulfilmentEdge(__typename, fulfilment);
      }
    }
  }

  public static class Fulfilment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("deliveryType", "deliveryType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("eta", "eta", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("expiryTime", "expiryTime", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("order", "order", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeOrder", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable List<Attribute1> attributes;

    final @Nullable String deliveryType;

    final @Nonnull String type;

    final @Nullable String eta;

    final @Nullable Object expiryTime;

    final @Nullable Order order;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilment(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable Object createdOn, @Nullable Object updatedOn,
        @Nullable List<Attribute1> attributes, @Nullable String deliveryType, @Nonnull String type,
        @Nullable String eta, @Nullable Object expiryTime, @Nullable Order order) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.attributes = attributes;
      this.deliveryType = deliveryType;
      this.type = Utils.checkNotNull(type, "type == null");
      this.eta = eta;
      this.expiryTime = expiryTime;
      this.order = order;
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
     *  Attributes of fulfilment
     */
    public @Nullable List<Attribute1> attributes() {
      return this.attributes;
    }

    /**
     *  Type of delivery. Supported values are _STANDARD_, _OVERNIGHT_ and _EXPRESS_.
     */
    public @Nullable String deliveryType() {
      return this.deliveryType;
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
     *  The associated `Order`
     */
    public @Nullable Order order() {
      return this.order;
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
          writer.writeList($responseFields[6], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute1) value).marshaller());
            }
          });
          writer.writeString($responseFields[7], deliveryType);
          writer.writeString($responseFields[8], type);
          writer.writeString($responseFields[9], eta);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[10], expiryTime);
          writer.writeObject($responseFields[11], order != null ? order.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Fulfilment{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "attributes=" + attributes + ", "
          + "deliveryType=" + deliveryType + ", "
          + "type=" + type + ", "
          + "eta=" + eta + ", "
          + "expiryTime=" + expiryTime + ", "
          + "order=" + order
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
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.deliveryType == null) ? (that.deliveryType == null) : this.deliveryType.equals(that.deliveryType))
         && this.type.equals(that.type)
         && ((this.eta == null) ? (that.eta == null) : this.eta.equals(that.eta))
         && ((this.expiryTime == null) ? (that.expiryTime == null) : this.expiryTime.equals(that.expiryTime))
         && ((this.order == null) ? (that.order == null) : this.order.equals(that.order));
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
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (deliveryType == null) ? 0 : deliveryType.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (eta == null) ? 0 : eta.hashCode();
        h *= 1000003;
        h ^= (expiryTime == null) ? 0 : expiryTime.hashCode();
        h *= 1000003;
        h ^= (order == null) ? 0 : order.hashCode();
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
      builder.attributes = attributes;
      builder.deliveryType = deliveryType;
      builder.type = type;
      builder.eta = eta;
      builder.expiryTime = expiryTime;
      builder.order = order;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Fulfilment> {
      final Attribute1.Mapper attribute1FieldMapper = new Attribute1.Mapper();

      final Order.Mapper orderFieldMapper = new Order.Mapper();

      @Override
      public Fulfilment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[4]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final List<Attribute1> attributes = reader.readList($responseFields[6], new ResponseReader.ListReader<Attribute1>() {
          @Override
          public Attribute1 read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Attribute1>() {
              @Override
              public Attribute1 read(ResponseReader reader) {
                return attribute1FieldMapper.map(reader);
              }
            });
          }
        });
        final String deliveryType = reader.readString($responseFields[7]);
        final String type = reader.readString($responseFields[8]);
        final String eta = reader.readString($responseFields[9]);
        final Object expiryTime = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[10]);
        final Order order = reader.readObject($responseFields[11], new ResponseReader.ObjectReader<Order>() {
          @Override
          public Order read(ResponseReader reader) {
            return orderFieldMapper.map(reader);
          }
        });
        return new Fulfilment(__typename, id, ref, status, createdOn, updatedOn, attributes, deliveryType, type, eta, expiryTime, order);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

      private @Nullable List<Attribute1> attributes;

      private @Nullable String deliveryType;

      private @Nonnull String type;

      private @Nullable String eta;

      private @Nullable Object expiryTime;

      private @Nullable Order order;

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

      public Builder attributes(@Nullable List<Attribute1> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder deliveryType(@Nullable String deliveryType) {
        this.deliveryType = deliveryType;
        return this;
      }

      public Builder type(@Nonnull String type) {
        this.type = type;
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

      public Builder order(@Nullable Order order) {
        this.order = order;
        return this;
      }

      public Builder attributes(@Nonnull Mutator<List<Attribute1.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Attribute1.Builder> builders = new ArrayList<>();
        if (this.attributes != null) {
          for (Attribute1 item : this.attributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Attribute1> attributes = new ArrayList<>();
        for (Attribute1.Builder item : builders) {
          attributes.add(item != null ? item.build() : null);
        }
        this.attributes = attributes;
        return this;
      }

      public Builder order(@Nonnull Mutator<Order.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Order.Builder builder = this.order != null ? this.order.toBuilder() : Order.builder();
        mutator.accept(builder);
        this.order = builder.build();
        return this;
      }

      public Fulfilment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Fulfilment(__typename, id, ref, status, createdOn, updatedOn, attributes, deliveryType, type, eta, expiryTime, order);
      }
    }
  }

  public static class Attribute1 {
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

    public Attribute1(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
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
        $toString = "Attribute1{"
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
      if (o instanceof Attribute1) {
        Attribute1 that = (Attribute1) o;
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

    public static final class Mapper implements ResponseFieldMapper<Attribute1> {
      @Override
      public Attribute1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new Attribute1(__typename, name, type, value);
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

      public Attribute1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new Attribute1(__typename, name, type, value);
      }
    }
  }

  public static class Order {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("createdOn", "createdOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("updatedOn", "updatedOn", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable List<Attribute2> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Order(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable Object createdOn,
        @Nullable Object updatedOn, @Nullable List<Attribute2> attributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.createdOn = createdOn;
      this.updatedOn = updatedOn;
      this.attributes = attributes;
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
     *  List of order `attribute`s
     */
    public @Nullable List<Attribute2> attributes() {
      return this.attributes;
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
          writer.writeList($responseFields[7], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute2) value).marshaller());
            }
          });
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
          + "status=" + status + ", "
          + "createdOn=" + createdOn + ", "
          + "updatedOn=" + updatedOn + ", "
          + "attributes=" + attributes
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
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.createdOn == null) ? (that.createdOn == null) : this.createdOn.equals(that.createdOn))
         && ((this.updatedOn == null) ? (that.updatedOn == null) : this.updatedOn.equals(that.updatedOn))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes));
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
        h ^= (attributes == null) ? 0 : attributes.hashCode();
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
      builder.attributes = attributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Order> {
      final Attribute2.Mapper attribute2FieldMapper = new Attribute2.Mapper();

      @Override
      public Order map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[6]);
        final List<Attribute2> attributes = reader.readList($responseFields[7], new ResponseReader.ListReader<Attribute2>() {
          @Override
          public Attribute2 read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Attribute2>() {
              @Override
              public Attribute2 read(ResponseReader reader) {
                return attribute2FieldMapper.map(reader);
              }
            });
          }
        });
        return new Order(__typename, id, ref, type, status, createdOn, updatedOn, attributes);
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

      private @Nullable List<Attribute2> attributes;

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

      public Builder attributes(@Nullable List<Attribute2> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder attributes(@Nonnull Mutator<List<Attribute2.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Attribute2.Builder> builders = new ArrayList<>();
        if (this.attributes != null) {
          for (Attribute2 item : this.attributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Attribute2> attributes = new ArrayList<>();
        for (Attribute2.Builder item : builders) {
          attributes.add(item != null ? item.build() : null);
        }
        this.attributes = attributes;
        return this;
      }

      public Order build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Order(__typename, id, ref, type, status, createdOn, updatedOn, attributes);
      }
    }
  }

  public static class Attribute2 {
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

    public Attribute2(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
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
        $toString = "Attribute2{"
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
      if (o instanceof Attribute2) {
        Attribute2 that = (Attribute2) o;
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

    public static final class Mapper implements ResponseFieldMapper<Attribute2> {
      @Override
      public Attribute2 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new Attribute2(__typename, name, type, value);
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

      public Attribute2 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new Attribute2(__typename, name, type, value);
      }
    }
  }
}
