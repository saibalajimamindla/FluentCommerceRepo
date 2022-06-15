package com.fluentcommerce.commonv2.graphql.query.consignment;

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
public final class GetConsignmentByIdQuery implements Query<GetConsignmentByIdQuery.Data, GetConsignmentByIdQuery.Data, GetConsignmentByIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetConsignmentById($id: ID!, $includeArticles: Boolean!, $articlesCount: Int, $articlesCursor: String, $includeFulfilments: Boolean!, $fulfilmentCount: Int, $fulfilmentCursor: String) {\n"
      + "  consignmentById(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    status\n"
      + "    consignmentReference\n"
      + "    trackingLabel\n"
      + "    labelUrl\n"
      + "    orderSummaryUrl\n"
      + "    consignmentArticles(first: $articlesCount, after: $articlesCursor) @include(if: $includeArticles) {\n"
      + "      __typename\n"
      + "      articleEdge: edges {\n"
      + "        __typename\n"
      + "        articleNode: node {\n"
      + "          __typename\n"
      + "          article {\n"
      + "            __typename\n"
      + "            id\n"
      + "            ref\n"
      + "            type\n"
      + "            status\n"
      + "            attributes {\n"
      + "              __typename\n"
      + "              name\n"
      + "              type\n"
      + "              value\n"
      + "            }\n"
      + "            description\n"
      + "            height\n"
      + "            length\n"
      + "            name\n"
      + "            weight\n"
      + "            width\n"
      + "            quantity\n"
      + "            fulfilments(first: $fulfilmentCount, after: $fulfilmentCursor) @include(if: $includeFulfilments) {\n"
      + "              __typename\n"
      + "              fulfilmentEdge: edges {\n"
      + "                __typename\n"
      + "                fulfilment: node {\n"
      + "                  __typename\n"
      + "                  id\n"
      + "                  ref\n"
      + "                  status\n"
      + "                  attributes {\n"
      + "                    __typename\n"
      + "                    name\n"
      + "                    type\n"
      + "                    value\n"
      + "                  }\n"
      + "                  deliveryType\n"
      + "                  type\n"
      + "                  eta\n"
      + "                  expiryTime\n"
      + "                }\n"
      + "              }\n"
      + "            }\n"
      + "          }\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "    carrier {\n"
      + "      __typename\n"
      + "      id\n"
      + "      name\n"
      + "    }\n"
      + "    retailer {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetConsignmentById";
    }
  };

  private final GetConsignmentByIdQuery.Variables variables;

  public GetConsignmentByIdQuery(@Nonnull String id, boolean includeArticles,
      @Nullable Integer articlesCount, @Nullable String articlesCursor, boolean includeFulfilments,
      @Nullable Integer fulfilmentCount, @Nullable String fulfilmentCursor) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetConsignmentByIdQuery.Variables(id, includeArticles, articlesCount, articlesCursor, includeFulfilments, fulfilmentCount, fulfilmentCursor);
  }

  @Override
  public String operationId() {
    return "926a07442faf2bbf10379b41baaef9a34f65fb36dd9fac003516981f46fc5411";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetConsignmentByIdQuery.Data wrapData(GetConsignmentByIdQuery.Data data) {
    return data;
  }

  @Override
  public GetConsignmentByIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetConsignmentByIdQuery.Data> responseFieldMapper() {
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

    private boolean includeArticles;

    private @Nullable Integer articlesCount;

    private @Nullable String articlesCursor;

    private boolean includeFulfilments;

    private @Nullable Integer fulfilmentCount;

    private @Nullable String fulfilmentCursor;

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public Builder includeArticles(boolean includeArticles) {
      this.includeArticles = includeArticles;
      return this;
    }

    public Builder articlesCount(@Nullable Integer articlesCount) {
      this.articlesCount = articlesCount;
      return this;
    }

    public Builder articlesCursor(@Nullable String articlesCursor) {
      this.articlesCursor = articlesCursor;
      return this;
    }

    public Builder includeFulfilments(boolean includeFulfilments) {
      this.includeFulfilments = includeFulfilments;
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

    public GetConsignmentByIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetConsignmentByIdQuery(id, includeArticles, articlesCount, articlesCursor, includeFulfilments, fulfilmentCount, fulfilmentCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final boolean includeArticles;

    private final @Nullable Integer articlesCount;

    private final @Nullable String articlesCursor;

    private final boolean includeFulfilments;

    private final @Nullable Integer fulfilmentCount;

    private final @Nullable String fulfilmentCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, boolean includeArticles, @Nullable Integer articlesCount,
        @Nullable String articlesCursor, boolean includeFulfilments,
        @Nullable Integer fulfilmentCount, @Nullable String fulfilmentCursor) {
      this.id = id;
      this.includeArticles = includeArticles;
      this.articlesCount = articlesCount;
      this.articlesCursor = articlesCursor;
      this.includeFulfilments = includeFulfilments;
      this.fulfilmentCount = fulfilmentCount;
      this.fulfilmentCursor = fulfilmentCursor;
      this.valueMap.put("id", id);
      this.valueMap.put("includeArticles", includeArticles);
      this.valueMap.put("articlesCount", articlesCount);
      this.valueMap.put("articlesCursor", articlesCursor);
      this.valueMap.put("includeFulfilments", includeFulfilments);
      this.valueMap.put("fulfilmentCount", fulfilmentCount);
      this.valueMap.put("fulfilmentCursor", fulfilmentCursor);
    }

    public @Nonnull String id() {
      return id;
    }

    public boolean includeArticles() {
      return includeArticles;
    }

    public @Nullable Integer articlesCount() {
      return articlesCount;
    }

    public @Nullable String articlesCursor() {
      return articlesCursor;
    }

    public boolean includeFulfilments() {
      return includeFulfilments;
    }

    public @Nullable Integer fulfilmentCount() {
      return fulfilmentCount;
    }

    public @Nullable String fulfilmentCursor() {
      return fulfilmentCursor;
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
          writer.writeBoolean("includeArticles", includeArticles);
          writer.writeInt("articlesCount", articlesCount);
          writer.writeString("articlesCursor", articlesCursor);
          writer.writeBoolean("includeFulfilments", includeFulfilments);
          writer.writeInt("fulfilmentCount", fulfilmentCount);
          writer.writeString("fulfilmentCursor", fulfilmentCursor);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("consignmentById", "consignmentById", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable ConsignmentById consignmentById;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable ConsignmentById consignmentById) {
      this.consignmentById = consignmentById;
    }

    /**
     *  Find a Consignment entity
     */
    public @Nullable ConsignmentById consignmentById() {
      return this.consignmentById;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], consignmentById != null ? consignmentById.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "consignmentById=" + consignmentById
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
        return ((this.consignmentById == null) ? (that.consignmentById == null) : this.consignmentById.equals(that.consignmentById));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (consignmentById == null) ? 0 : consignmentById.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.consignmentById = consignmentById;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final ConsignmentById.Mapper consignmentByIdFieldMapper = new ConsignmentById.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final ConsignmentById consignmentById = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<ConsignmentById>() {
          @Override
          public ConsignmentById read(ResponseReader reader) {
            return consignmentByIdFieldMapper.map(reader);
          }
        });
        return new Data(consignmentById);
      }
    }

    public static final class Builder {
      private @Nullable ConsignmentById consignmentById;

      Builder() {
      }

      public Builder consignmentById(@Nullable ConsignmentById consignmentById) {
        this.consignmentById = consignmentById;
        return this;
      }

      public Builder consignmentById(@Nonnull Mutator<ConsignmentById.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ConsignmentById.Builder builder = this.consignmentById != null ? this.consignmentById.toBuilder() : ConsignmentById.builder();
        mutator.accept(builder);
        this.consignmentById = builder.build();
        return this;
      }

      public Data build() {
        return new Data(consignmentById);
      }
    }
  }

  public static class ConsignmentById {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("consignmentReference", "consignmentReference", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("trackingLabel", "trackingLabel", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("labelUrl", "labelUrl", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("orderSummaryUrl", "orderSummaryUrl", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("consignmentArticles", "consignmentArticles", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "articlesCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "articlesCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeArticles", false))),
      ResponseField.forObject("carrier", "carrier", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("retailer", "retailer", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nonnull String consignmentReference;

    final @Nullable String trackingLabel;

    final @Nullable String labelUrl;

    final @Nullable String orderSummaryUrl;

    final @Nullable ConsignmentArticles consignmentArticles;

    final @Nullable Carrier carrier;

    final @Nullable Retailer retailer;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ConsignmentById(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nonnull String consignmentReference,
        @Nullable String trackingLabel, @Nullable String labelUrl, @Nullable String orderSummaryUrl,
        @Nullable ConsignmentArticles consignmentArticles, @Nullable Carrier carrier,
        @Nullable Retailer retailer) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.consignmentReference = Utils.checkNotNull(consignmentReference, "consignmentReference == null");
      this.trackingLabel = trackingLabel;
      this.labelUrl = labelUrl;
      this.orderSummaryUrl = orderSummaryUrl;
      this.consignmentArticles = consignmentArticles;
      this.carrier = carrier;
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
     *  External reference of the object. Recommended to be unique.
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  The status of the consignment
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  The external consignment reference assigned by the carrier
     */
    public @Nonnull String consignmentReference() {
      return this.consignmentReference;
    }

    /**
     *  Tracking label of the consignment
     */
    public @Nullable String trackingLabel() {
      return this.trackingLabel;
    }

    /**
     *  The URL used to retrieve the shipping label
     */
    public @Nullable String labelUrl() {
      return this.labelUrl;
    }

    /**
     *  A url to represent the order summary. Usually the manifest url from the service provider.
     */
    public @Nullable String orderSummaryUrl() {
      return this.orderSummaryUrl;
    }

    /**
     *  Relationships between consignment and article
     */
    public @Nullable ConsignmentArticles consignmentArticles() {
      return this.consignmentArticles;
    }

    /**
     *  Carrier used for the consignment
     */
    public @Nullable Carrier carrier() {
      return this.carrier;
    }

    /**
     *  Retailer who is booking the consignment
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
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], consignmentReference);
          writer.writeString($responseFields[5], trackingLabel);
          writer.writeString($responseFields[6], labelUrl);
          writer.writeString($responseFields[7], orderSummaryUrl);
          writer.writeObject($responseFields[8], consignmentArticles != null ? consignmentArticles.marshaller() : null);
          writer.writeObject($responseFields[9], carrier != null ? carrier.marshaller() : null);
          writer.writeObject($responseFields[10], retailer != null ? retailer.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ConsignmentById{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "consignmentReference=" + consignmentReference + ", "
          + "trackingLabel=" + trackingLabel + ", "
          + "labelUrl=" + labelUrl + ", "
          + "orderSummaryUrl=" + orderSummaryUrl + ", "
          + "consignmentArticles=" + consignmentArticles + ", "
          + "carrier=" + carrier + ", "
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
      if (o instanceof ConsignmentById) {
        ConsignmentById that = (ConsignmentById) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.consignmentReference.equals(that.consignmentReference)
         && ((this.trackingLabel == null) ? (that.trackingLabel == null) : this.trackingLabel.equals(that.trackingLabel))
         && ((this.labelUrl == null) ? (that.labelUrl == null) : this.labelUrl.equals(that.labelUrl))
         && ((this.orderSummaryUrl == null) ? (that.orderSummaryUrl == null) : this.orderSummaryUrl.equals(that.orderSummaryUrl))
         && ((this.consignmentArticles == null) ? (that.consignmentArticles == null) : this.consignmentArticles.equals(that.consignmentArticles))
         && ((this.carrier == null) ? (that.carrier == null) : this.carrier.equals(that.carrier))
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
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= consignmentReference.hashCode();
        h *= 1000003;
        h ^= (trackingLabel == null) ? 0 : trackingLabel.hashCode();
        h *= 1000003;
        h ^= (labelUrl == null) ? 0 : labelUrl.hashCode();
        h *= 1000003;
        h ^= (orderSummaryUrl == null) ? 0 : orderSummaryUrl.hashCode();
        h *= 1000003;
        h ^= (consignmentArticles == null) ? 0 : consignmentArticles.hashCode();
        h *= 1000003;
        h ^= (carrier == null) ? 0 : carrier.hashCode();
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
      builder.status = status;
      builder.consignmentReference = consignmentReference;
      builder.trackingLabel = trackingLabel;
      builder.labelUrl = labelUrl;
      builder.orderSummaryUrl = orderSummaryUrl;
      builder.consignmentArticles = consignmentArticles;
      builder.carrier = carrier;
      builder.retailer = retailer;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ConsignmentById> {
      final ConsignmentArticles.Mapper consignmentArticlesFieldMapper = new ConsignmentArticles.Mapper();

      final Carrier.Mapper carrierFieldMapper = new Carrier.Mapper();

      final Retailer.Mapper retailerFieldMapper = new Retailer.Mapper();

      @Override
      public ConsignmentById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String consignmentReference = reader.readString($responseFields[4]);
        final String trackingLabel = reader.readString($responseFields[5]);
        final String labelUrl = reader.readString($responseFields[6]);
        final String orderSummaryUrl = reader.readString($responseFields[7]);
        final ConsignmentArticles consignmentArticles = reader.readObject($responseFields[8], new ResponseReader.ObjectReader<ConsignmentArticles>() {
          @Override
          public ConsignmentArticles read(ResponseReader reader) {
            return consignmentArticlesFieldMapper.map(reader);
          }
        });
        final Carrier carrier = reader.readObject($responseFields[9], new ResponseReader.ObjectReader<Carrier>() {
          @Override
          public Carrier read(ResponseReader reader) {
            return carrierFieldMapper.map(reader);
          }
        });
        final Retailer retailer = reader.readObject($responseFields[10], new ResponseReader.ObjectReader<Retailer>() {
          @Override
          public Retailer read(ResponseReader reader) {
            return retailerFieldMapper.map(reader);
          }
        });
        return new ConsignmentById(__typename, id, ref, status, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl, consignmentArticles, carrier, retailer);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nonnull String consignmentReference;

      private @Nullable String trackingLabel;

      private @Nullable String labelUrl;

      private @Nullable String orderSummaryUrl;

      private @Nullable ConsignmentArticles consignmentArticles;

      private @Nullable Carrier carrier;

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

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder consignmentReference(@Nonnull String consignmentReference) {
        this.consignmentReference = consignmentReference;
        return this;
      }

      public Builder trackingLabel(@Nullable String trackingLabel) {
        this.trackingLabel = trackingLabel;
        return this;
      }

      public Builder labelUrl(@Nullable String labelUrl) {
        this.labelUrl = labelUrl;
        return this;
      }

      public Builder orderSummaryUrl(@Nullable String orderSummaryUrl) {
        this.orderSummaryUrl = orderSummaryUrl;
        return this;
      }

      public Builder consignmentArticles(@Nullable ConsignmentArticles consignmentArticles) {
        this.consignmentArticles = consignmentArticles;
        return this;
      }

      public Builder carrier(@Nullable Carrier carrier) {
        this.carrier = carrier;
        return this;
      }

      public Builder retailer(@Nullable Retailer retailer) {
        this.retailer = retailer;
        return this;
      }

      public Builder consignmentArticles(@Nonnull Mutator<ConsignmentArticles.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ConsignmentArticles.Builder builder = this.consignmentArticles != null ? this.consignmentArticles.toBuilder() : ConsignmentArticles.builder();
        mutator.accept(builder);
        this.consignmentArticles = builder.build();
        return this;
      }

      public Builder carrier(@Nonnull Mutator<Carrier.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Carrier.Builder builder = this.carrier != null ? this.carrier.toBuilder() : Carrier.builder();
        mutator.accept(builder);
        this.carrier = builder.build();
        return this;
      }

      public Builder retailer(@Nonnull Mutator<Retailer.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Retailer.Builder builder = this.retailer != null ? this.retailer.toBuilder() : Retailer.builder();
        mutator.accept(builder);
        this.retailer = builder.build();
        return this;
      }

      public ConsignmentById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(consignmentReference, "consignmentReference == null");
        return new ConsignmentById(__typename, id, ref, status, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl, consignmentArticles, carrier, retailer);
      }
    }
  }

  public static class ConsignmentArticles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("articleEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<ArticleEdge> articleEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ConsignmentArticles(@Nonnull String __typename,
        @Nullable List<ArticleEdge> articleEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.articleEdge = articleEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to ConsignmentArticle type node
     */
    public @Nullable List<ArticleEdge> articleEdge() {
      return this.articleEdge;
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
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ConsignmentArticles{"
          + "__typename=" + __typename + ", "
          + "articleEdge=" + articleEdge
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
         && ((this.articleEdge == null) ? (that.articleEdge == null) : this.articleEdge.equals(that.articleEdge));
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
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.articleEdge = articleEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ConsignmentArticles> {
      final ArticleEdge.Mapper articleEdgeFieldMapper = new ArticleEdge.Mapper();

      @Override
      public ConsignmentArticles map(ResponseReader reader) {
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
        return new ConsignmentArticles(__typename, articleEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<ArticleEdge> articleEdge;

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

      public ConsignmentArticles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ConsignmentArticles(__typename, articleEdge);
      }
    }
  }

  public static class ArticleEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("articleNode", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable ArticleNode articleNode;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ArticleEdge(@Nonnull String __typename, @Nullable ArticleNode articleNode) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.articleNode = articleNode;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the ConsignmentArticle edge
     */
    public @Nullable ArticleNode articleNode() {
      return this.articleNode;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], articleNode != null ? articleNode.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ArticleEdge{"
          + "__typename=" + __typename + ", "
          + "articleNode=" + articleNode
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
         && ((this.articleNode == null) ? (that.articleNode == null) : this.articleNode.equals(that.articleNode));
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
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.articleNode = articleNode;
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
        return new ArticleEdge(__typename, articleNode);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable ArticleNode articleNode;

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

      public Builder articleNode(@Nonnull Mutator<ArticleNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ArticleNode.Builder builder = this.articleNode != null ? this.articleNode.toBuilder() : ArticleNode.builder();
        mutator.accept(builder);
        this.articleNode = builder.build();
        return this;
      }

      public ArticleEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ArticleEdge(__typename, articleNode);
      }
    }
  }

  public static class ArticleNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("article", "article", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Article article;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ArticleNode(@Nonnull String __typename, @Nullable Article article) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.article = article;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Article
     */
    public @Nullable Article article() {
      return this.article;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], article != null ? article.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ArticleNode{"
          + "__typename=" + __typename + ", "
          + "article=" + article
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
         && ((this.article == null) ? (that.article == null) : this.article.equals(that.article));
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
        h ^= (article == null) ? 0 : article.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.article = article;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ArticleNode> {
      final Article.Mapper articleFieldMapper = new Article.Mapper();

      @Override
      public ArticleNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Article article = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Article>() {
          @Override
          public Article read(ResponseReader reader) {
            return articleFieldMapper.map(reader);
          }
        });
        return new ArticleNode(__typename, article);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Article article;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder article(@Nullable Article article) {
        this.article = article;
        return this;
      }

      public Builder article(@Nonnull Mutator<Article.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Article.Builder builder = this.article != null ? this.article.toBuilder() : Article.builder();
        mutator.accept(builder);
        this.article = builder.build();
        return this;
      }

      public ArticleNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ArticleNode(__typename, article);
      }
    }
  }

  public static class Article {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("description", "description", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("height", "height", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("length", "length", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("weight", "weight", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("width", "width", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilments", "fulfilments", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeFulfilments", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable List<Attribute> attributes;

    final @Nullable String description;

    final double height;

    final double length;

    final @Nullable String name;

    final double weight;

    final double width;

    final @Nullable Integer quantity;

    final @Nullable Fulfilments fulfilments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Article(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable List<Attribute> attributes,
        @Nullable String description, double height, double length, @Nullable String name,
        double weight, double width, @Nullable Integer quantity,
        @Nullable Fulfilments fulfilments) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.type = Utils.checkNotNull(type, "type == null");
      this.status = status;
      this.attributes = attributes;
      this.description = description;
      this.height = height;
      this.length = length;
      this.name = name;
      this.weight = weight;
      this.width = width;
      this.quantity = quantity;
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
          writer.writeList($responseFields[5], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeString($responseFields[6], description);
          writer.writeDouble($responseFields[7], height);
          writer.writeDouble($responseFields[8], length);
          writer.writeString($responseFields[9], name);
          writer.writeDouble($responseFields[10], weight);
          writer.writeDouble($responseFields[11], width);
          writer.writeInt($responseFields[12], quantity);
          writer.writeObject($responseFields[13], fulfilments != null ? fulfilments.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Article{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "status=" + status + ", "
          + "attributes=" + attributes + ", "
          + "description=" + description + ", "
          + "height=" + height + ", "
          + "length=" + length + ", "
          + "name=" + name + ", "
          + "weight=" + weight + ", "
          + "width=" + width + ", "
          + "quantity=" + quantity + ", "
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
      if (o instanceof Article) {
        Article that = (Article) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && this.type.equals(that.type)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.description == null) ? (that.description == null) : this.description.equals(that.description))
         && Double.doubleToLongBits(this.height) == Double.doubleToLongBits(that.height)
         && Double.doubleToLongBits(this.length) == Double.doubleToLongBits(that.length)
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(that.weight)
         && Double.doubleToLongBits(this.width) == Double.doubleToLongBits(that.width)
         && ((this.quantity == null) ? (that.quantity == null) : this.quantity.equals(that.quantity))
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
      builder.attributes = attributes;
      builder.description = description;
      builder.height = height;
      builder.length = length;
      builder.name = name;
      builder.weight = weight;
      builder.width = width;
      builder.quantity = quantity;
      builder.fulfilments = fulfilments;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Article> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final Fulfilments.Mapper fulfilmentsFieldMapper = new Fulfilments.Mapper();

      @Override
      public Article map(ResponseReader reader) {
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
        final String description = reader.readString($responseFields[6]);
        final double height = reader.readDouble($responseFields[7]);
        final double length = reader.readDouble($responseFields[8]);
        final String name = reader.readString($responseFields[9]);
        final double weight = reader.readDouble($responseFields[10]);
        final double width = reader.readDouble($responseFields[11]);
        final Integer quantity = reader.readInt($responseFields[12]);
        final Fulfilments fulfilments = reader.readObject($responseFields[13], new ResponseReader.ObjectReader<Fulfilments>() {
          @Override
          public Fulfilments read(ResponseReader reader) {
            return fulfilmentsFieldMapper.map(reader);
          }
        });
        return new Article(__typename, id, ref, type, status, attributes, description, height, length, name, weight, width, quantity, fulfilments);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable List<Attribute> attributes;

      private @Nullable String description;

      private double height;

      private double length;

      private @Nullable String name;

      private double weight;

      private double width;

      private @Nullable Integer quantity;

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

      public Builder fulfilments(@Nonnull Mutator<Fulfilments.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Fulfilments.Builder builder = this.fulfilments != null ? this.fulfilments.toBuilder() : Fulfilments.builder();
        mutator.accept(builder);
        this.fulfilments = builder.build();
        return this;
      }

      public Article build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Article(__typename, id, ref, type, status, attributes, description, height, length, name, weight, width, quantity, fulfilments);
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
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("deliveryType", "deliveryType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("eta", "eta", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("expiryTime", "expiryTime", null, true, CustomType.DATETIME, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable List<Attribute1> attributes;

    final @Nullable String deliveryType;

    final @Nonnull String type;

    final @Nullable String eta;

    final @Nullable Object expiryTime;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilment(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable List<Attribute1> attributes,
        @Nullable String deliveryType, @Nonnull String type, @Nullable String eta,
        @Nullable Object expiryTime) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.attributes = attributes;
      this.deliveryType = deliveryType;
      this.type = Utils.checkNotNull(type, "type == null");
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
          writer.writeList($responseFields[4], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute1) value).marshaller());
            }
          });
          writer.writeString($responseFields[5], deliveryType);
          writer.writeString($responseFields[6], type);
          writer.writeString($responseFields[7], eta);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[8], expiryTime);
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
          + "attributes=" + attributes + ", "
          + "deliveryType=" + deliveryType + ", "
          + "type=" + type + ", "
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
      if (o instanceof Fulfilment) {
        Fulfilment that = (Fulfilment) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.deliveryType == null) ? (that.deliveryType == null) : this.deliveryType.equals(that.deliveryType))
         && this.type.equals(that.type)
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
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (deliveryType == null) ? 0 : deliveryType.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
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
      builder.attributes = attributes;
      builder.deliveryType = deliveryType;
      builder.type = type;
      builder.eta = eta;
      builder.expiryTime = expiryTime;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Fulfilment> {
      final Attribute1.Mapper attribute1FieldMapper = new Attribute1.Mapper();

      @Override
      public Fulfilment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final List<Attribute1> attributes = reader.readList($responseFields[4], new ResponseReader.ListReader<Attribute1>() {
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
        final String deliveryType = reader.readString($responseFields[5]);
        final String type = reader.readString($responseFields[6]);
        final String eta = reader.readString($responseFields[7]);
        final Object expiryTime = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[8]);
        return new Fulfilment(__typename, id, ref, status, attributes, deliveryType, type, eta, expiryTime);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable List<Attribute1> attributes;

      private @Nullable String deliveryType;

      private @Nonnull String type;

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

      public Fulfilment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Fulfilment(__typename, id, ref, status, attributes, deliveryType, type, eta, expiryTime);
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

  public static class Carrier {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String name;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Carrier(@Nonnull String __typename, @Nonnull String id, @Nonnull String name) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.name = Utils.checkNotNull(name, "name == null");
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
     *  The carrier name
     */
    public @Nonnull String name() {
      return this.name;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], name);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Carrier{"
          + "__typename=" + __typename + ", "
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
      if (o instanceof Carrier) {
        Carrier that = (Carrier) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.name.equals(that.name);
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
        h ^= name.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      builder.name = name;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Carrier> {
      @Override
      public Carrier map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        return new Carrier(__typename, id, name);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String name;

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

      public Builder name(@Nonnull String name) {
        this.name = name;
        return this;
      }

      public Carrier build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(name, "name == null");
        return new Carrier(__typename, id, name);
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
}
