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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class GetArticleByRefQuery implements Query<GetArticleByRefQuery.Data, GetArticleByRefQuery.Data, GetArticleByRefQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query getArticleByRef($ref: [String]) {\n"
      + "  articles(ref: $ref) {\n"
      + "    __typename\n"
      + "    articleEdge: edges {\n"
      + "      __typename\n"
      + "      articleNode: node {\n"
      + "        __typename\n"
      + "        id\n"
      + "        ref\n"
      + "        type\n"
      + "        status\n"
      + "        attributes {\n"
      + "          __typename\n"
      + "          name\n"
      + "          type\n"
      + "          value\n"
      + "        }\n"
      + "        description\n"
      + "        height\n"
      + "        length\n"
      + "        name\n"
      + "        weight\n"
      + "        width\n"
      + "        quantity\n"
      + "        items {\n"
      + "          __typename\n"
      + "          edges {\n"
      + "            __typename\n"
      + "            node {\n"
      + "              __typename\n"
      + "              id\n"
      + "              quantity\n"
      + "              barcode\n"
      + "              article {\n"
      + "                __typename\n"
      + "                id\n"
      + "                ref\n"
      + "                type\n"
      + "                status\n"
      + "                attributes {\n"
      + "                  __typename\n"
      + "                  name\n"
      + "                  type\n"
      + "                  value\n"
      + "                }\n"
      + "                description\n"
      + "                height\n"
      + "                length\n"
      + "                name\n"
      + "                weight\n"
      + "                width\n"
      + "                quantity\n"
      + "              }\n"
      + "            }\n"
      + "          }\n"
      + "        }\n"
      + "        fulfilments {\n"
      + "          __typename\n"
      + "          edges {\n"
      + "            __typename\n"
      + "            node {\n"
      + "              __typename\n"
      + "              id\n"
      + "              ref\n"
      + "              status\n"
      + "              createdOn\n"
      + "              updatedOn\n"
      + "              attributes {\n"
      + "                __typename\n"
      + "                name\n"
      + "                type\n"
      + "                value\n"
      + "              }\n"
      + "              deliveryType\n"
      + "              type\n"
      + "              eta\n"
      + "              expiryTime\n"
      + "              order {\n"
      + "                __typename\n"
      + "                id\n"
      + "                ref\n"
      + "                type\n"
      + "                status\n"
      + "                createdOn\n"
      + "                updatedOn\n"
      + "                attributes {\n"
      + "                  __typename\n"
      + "                  name\n"
      + "                  type\n"
      + "                  value\n"
      + "                }\n"
      + "              }\n"
      + "            }\n"
      + "          }\n"
      + "        }\n"
      + "        consignmentArticles {\n"
      + "          __typename\n"
      + "          edges {\n"
      + "            __typename\n"
      + "            node {\n"
      + "              __typename\n"
      + "              consignment {\n"
      + "                __typename\n"
      + "                id\n"
      + "                ref\n"
      + "                status\n"
      + "                consignmentReference\n"
      + "                trackingLabel\n"
      + "                labelUrl\n"
      + "                orderSummaryUrl\n"
      + "              }\n"
      + "            }\n"
      + "          }\n"
      + "        }\n"
      + "        carrierConsignmentArticles {\n"
      + "          __typename\n"
      + "          edges {\n"
      + "            __typename\n"
      + "            node {\n"
      + "              __typename\n"
      + "              carrierConsignment {\n"
      + "                __typename\n"
      + "                id\n"
      + "                ref\n"
      + "                status\n"
      + "                consignmentReference\n"
      + "                trackingLabel\n"
      + "                labelUrl\n"
      + "                orderSummaryUrl\n"
      + "                carrier {\n"
      + "                  __typename\n"
      + "                  id\n"
      + "                }\n"
      + "                retailer {\n"
      + "                  __typename\n"
      + "                  id\n"
      + "                }\n"
      + "                manifests {\n"
      + "                  __typename\n"
      + "                  edges {\n"
      + "                    __typename\n"
      + "                    node {\n"
      + "                      __typename\n"
      + "                      id\n"
      + "                    }\n"
      + "                  }\n"
      + "                }\n"
      + "                attributes {\n"
      + "                  __typename\n"
      + "                  name\n"
      + "                  type\n"
      + "                  value\n"
      + "                }\n"
      + "              }\n"
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
      return "getArticleByRef";
    }
  };

  private final GetArticleByRefQuery.Variables variables;

  public GetArticleByRefQuery(@Nullable List<String> ref) {
    variables = new GetArticleByRefQuery.Variables(ref);
  }

  @Override
  public String operationId() {
    return "0c32e528040ba7e6dfc31e9755fafce3481d3f72e087386b160d2a4993c8344b";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetArticleByRefQuery.Data wrapData(GetArticleByRefQuery.Data data) {
    return data;
  }

  @Override
  public GetArticleByRefQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetArticleByRefQuery.Data> responseFieldMapper() {
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
    private @Nullable List<String> ref;

    Builder() {
    }

    public Builder ref(@Nullable List<String> ref) {
      this.ref = ref;
      return this;
    }

    public GetArticleByRefQuery build() {
      return new GetArticleByRefQuery(ref);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable List<String> ref;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable List<String> ref) {
      this.ref = ref;
      this.valueMap.put("ref", ref);
    }

    public @Nullable List<String> ref() {
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
          writer.writeList("ref", ref != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : ref) {
                listItemWriter.writeString($item);
              }
            }
          } : null);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("articles", "articles", new UnmodifiableMapBuilder<String, Object>(1)
        .put("ref", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "ref")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable Articles articles;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Articles articles) {
      this.articles = articles;
    }

    /**
     *  Search for Article entities
     */
    public @Nullable Articles articles() {
      return this.articles;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], articles != null ? articles.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
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
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.articles == null) ? (that.articles == null) : this.articles.equals(that.articles));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (articles == null) ? 0 : articles.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.articles = articles;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Articles.Mapper articlesFieldMapper = new Articles.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Articles articles = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Articles>() {
          @Override
          public Articles read(ResponseReader reader) {
            return articlesFieldMapper.map(reader);
          }
        });
        return new Data(articles);
      }
    }

    public static final class Builder {
      private @Nullable Articles articles;

      Builder() {
      }

      public Builder articles(@Nullable Articles articles) {
        this.articles = articles;
        return this;
      }

      public Builder articles(@Nonnull Mutator<Articles.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Articles.Builder builder = this.articles != null ? this.articles.toBuilder() : Articles.builder();
        mutator.accept(builder);
        this.articles = builder.build();
        return this;
      }

      public Data build() {
        return new Data(articles);
      }
    }
  }

  public static class Articles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("articleEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<ArticleEdge> articleEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Articles(@Nonnull String __typename, @Nullable List<ArticleEdge> articleEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.articleEdge = articleEdge;
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
        $toString = "Articles{"
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
      if (o instanceof Articles) {
        Articles that = (Articles) o;
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

    public static final class Mapper implements ResponseFieldMapper<Articles> {
      final ArticleEdge.Mapper articleEdgeFieldMapper = new ArticleEdge.Mapper();

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
        return new Articles(__typename, articleEdge);
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

      public Articles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Articles(__typename, articleEdge);
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
     *  The item at the end of the Article edge
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
      ResponseField.forObject("items", "items", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilments", "fulfilments", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("consignmentArticles", "consignmentArticles", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("carrierConsignmentArticles", "carrierConsignmentArticles", null, true, Collections.<ResponseField.Condition>emptyList())
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

    final @Nullable Items items;

    final @Nullable Fulfilments fulfilments;

    final @Nullable ConsignmentArticles consignmentArticles;

    final @Nullable CarrierConsignmentArticles carrierConsignmentArticles;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ArticleNode(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable List<Attribute> attributes,
        @Nullable String description, double height, double length, @Nullable String name,
        double weight, double width, @Nullable Integer quantity, @Nullable Items items,
        @Nullable Fulfilments fulfilments, @Nullable ConsignmentArticles consignmentArticles,
        @Nullable CarrierConsignmentArticles carrierConsignmentArticles) {
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
      this.items = items;
      this.fulfilments = fulfilments;
      this.consignmentArticles = consignmentArticles;
      this.carrierConsignmentArticles = carrierConsignmentArticles;
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

    /**
     *  Relationships between consignment and article
     */
    public @Nullable ConsignmentArticles consignmentArticles() {
      return this.consignmentArticles;
    }

    /**
     *  Relationships between carrierConsignment and article
     */
    public @Nullable CarrierConsignmentArticles carrierConsignmentArticles() {
      return this.carrierConsignmentArticles;
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
          writer.writeObject($responseFields[13], items != null ? items.marshaller() : null);
          writer.writeObject($responseFields[14], fulfilments != null ? fulfilments.marshaller() : null);
          writer.writeObject($responseFields[15], consignmentArticles != null ? consignmentArticles.marshaller() : null);
          writer.writeObject($responseFields[16], carrierConsignmentArticles != null ? carrierConsignmentArticles.marshaller() : null);
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
          + "items=" + items + ", "
          + "fulfilments=" + fulfilments + ", "
          + "consignmentArticles=" + consignmentArticles + ", "
          + "carrierConsignmentArticles=" + carrierConsignmentArticles
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
         && ((this.items == null) ? (that.items == null) : this.items.equals(that.items))
         && ((this.fulfilments == null) ? (that.fulfilments == null) : this.fulfilments.equals(that.fulfilments))
         && ((this.consignmentArticles == null) ? (that.consignmentArticles == null) : this.consignmentArticles.equals(that.consignmentArticles))
         && ((this.carrierConsignmentArticles == null) ? (that.carrierConsignmentArticles == null) : this.carrierConsignmentArticles.equals(that.carrierConsignmentArticles));
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
        h ^= (items == null) ? 0 : items.hashCode();
        h *= 1000003;
        h ^= (fulfilments == null) ? 0 : fulfilments.hashCode();
        h *= 1000003;
        h ^= (consignmentArticles == null) ? 0 : consignmentArticles.hashCode();
        h *= 1000003;
        h ^= (carrierConsignmentArticles == null) ? 0 : carrierConsignmentArticles.hashCode();
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
      builder.items = items;
      builder.fulfilments = fulfilments;
      builder.consignmentArticles = consignmentArticles;
      builder.carrierConsignmentArticles = carrierConsignmentArticles;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<ArticleNode> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final Items.Mapper itemsFieldMapper = new Items.Mapper();

      final Fulfilments.Mapper fulfilmentsFieldMapper = new Fulfilments.Mapper();

      final ConsignmentArticles.Mapper consignmentArticlesFieldMapper = new ConsignmentArticles.Mapper();

      final CarrierConsignmentArticles.Mapper carrierConsignmentArticlesFieldMapper = new CarrierConsignmentArticles.Mapper();

      @Override
      public ArticleNode map(ResponseReader reader) {
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
        final Items items = reader.readObject($responseFields[13], new ResponseReader.ObjectReader<Items>() {
          @Override
          public Items read(ResponseReader reader) {
            return itemsFieldMapper.map(reader);
          }
        });
        final Fulfilments fulfilments = reader.readObject($responseFields[14], new ResponseReader.ObjectReader<Fulfilments>() {
          @Override
          public Fulfilments read(ResponseReader reader) {
            return fulfilmentsFieldMapper.map(reader);
          }
        });
        final ConsignmentArticles consignmentArticles = reader.readObject($responseFields[15], new ResponseReader.ObjectReader<ConsignmentArticles>() {
          @Override
          public ConsignmentArticles read(ResponseReader reader) {
            return consignmentArticlesFieldMapper.map(reader);
          }
        });
        final CarrierConsignmentArticles carrierConsignmentArticles = reader.readObject($responseFields[16], new ResponseReader.ObjectReader<CarrierConsignmentArticles>() {
          @Override
          public CarrierConsignmentArticles read(ResponseReader reader) {
            return carrierConsignmentArticlesFieldMapper.map(reader);
          }
        });
        return new ArticleNode(__typename, id, ref, type, status, attributes, description, height, length, name, weight, width, quantity, items, fulfilments, consignmentArticles, carrierConsignmentArticles);
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

      private @Nullable Items items;

      private @Nullable Fulfilments fulfilments;

      private @Nullable ConsignmentArticles consignmentArticles;

      private @Nullable CarrierConsignmentArticles carrierConsignmentArticles;

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

      public Builder items(@Nullable Items items) {
        this.items = items;
        return this;
      }

      public Builder fulfilments(@Nullable Fulfilments fulfilments) {
        this.fulfilments = fulfilments;
        return this;
      }

      public Builder consignmentArticles(@Nullable ConsignmentArticles consignmentArticles) {
        this.consignmentArticles = consignmentArticles;
        return this;
      }

      public Builder carrierConsignmentArticles(@Nullable CarrierConsignmentArticles carrierConsignmentArticles) {
        this.carrierConsignmentArticles = carrierConsignmentArticles;
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

      public Builder consignmentArticles(@Nonnull Mutator<ConsignmentArticles.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        ConsignmentArticles.Builder builder = this.consignmentArticles != null ? this.consignmentArticles.toBuilder() : ConsignmentArticles.builder();
        mutator.accept(builder);
        this.consignmentArticles = builder.build();
        return this;
      }

      public Builder carrierConsignmentArticles(@Nonnull Mutator<CarrierConsignmentArticles.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CarrierConsignmentArticles.Builder builder = this.carrierConsignmentArticles != null ? this.carrierConsignmentArticles.toBuilder() : CarrierConsignmentArticles.builder();
        mutator.accept(builder);
        this.carrierConsignmentArticles = builder.build();
        return this;
      }

      public ArticleNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new ArticleNode(__typename, id, ref, type, status, attributes, description, height, length, name, weight, width, quantity, items, fulfilments, consignmentArticles, carrierConsignmentArticles);
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
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Items(@Nonnull String __typename, @Nullable List<Edge> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to ArticleItem type node
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
        $toString = "Items{"
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
      if (o instanceof Items) {
        Items that = (Items) o;
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

    public static final class Mapper implements ResponseFieldMapper<Items> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      @Override
      public Items map(ResponseReader reader) {
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
        return new Items(__typename, edges);
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

      public Items build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Items(__typename, edges);
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
     *  The item at the end of the ArticleItem edge
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
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("barcode", "barcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("article", "article", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final int quantity;

    final @Nullable String barcode;

    final @Nullable Article article;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nonnull String id, int quantity,
        @Nullable String barcode, @Nullable Article article) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.quantity = quantity;
      this.barcode = barcode;
      this.article = article;
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
     *  Article associated with this item
     */
    public @Nullable Article article() {
      return this.article;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeInt($responseFields[2], quantity);
          writer.writeString($responseFields[3], barcode);
          writer.writeObject($responseFields[4], article != null ? article.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "quantity=" + quantity + ", "
          + "barcode=" + barcode + ", "
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
      if (o instanceof Node) {
        Node that = (Node) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.quantity == that.quantity
         && ((this.barcode == null) ? (that.barcode == null) : this.barcode.equals(that.barcode))
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
        h ^= id.hashCode();
        h *= 1000003;
        h ^= quantity;
        h *= 1000003;
        h ^= (barcode == null) ? 0 : barcode.hashCode();
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
      builder.id = id;
      builder.quantity = quantity;
      builder.barcode = barcode;
      builder.article = article;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node> {
      final Article.Mapper articleFieldMapper = new Article.Mapper();

      @Override
      public Node map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final int quantity = reader.readInt($responseFields[2]);
        final String barcode = reader.readString($responseFields[3]);
        final Article article = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<Article>() {
          @Override
          public Article read(ResponseReader reader) {
            return articleFieldMapper.map(reader);
          }
        });
        return new Node(__typename, id, quantity, barcode, article);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private int quantity;

      private @Nullable String barcode;

      private @Nullable Article article;

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

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Node(__typename, id, quantity, barcode, article);
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
      ResponseField.forInt("quantity", "quantity", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nonnull String type;

    final @Nullable String status;

    final @Nullable List<Attribute1> attributes;

    final @Nullable String description;

    final double height;

    final double length;

    final @Nullable String name;

    final double weight;

    final double width;

    final @Nullable Integer quantity;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Article(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable List<Attribute1> attributes,
        @Nullable String description, double height, double length, @Nullable String name,
        double weight, double width, @Nullable Integer quantity) {
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
    public @Nullable List<Attribute1> attributes() {
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
              listItemWriter.writeObject(((Attribute1) value).marshaller());
            }
          });
          writer.writeString($responseFields[6], description);
          writer.writeDouble($responseFields[7], height);
          writer.writeDouble($responseFields[8], length);
          writer.writeString($responseFields[9], name);
          writer.writeDouble($responseFields[10], weight);
          writer.writeDouble($responseFields[11], width);
          writer.writeInt($responseFields[12], quantity);
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
          + "quantity=" + quantity
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
         && ((this.quantity == null) ? (that.quantity == null) : this.quantity.equals(that.quantity));
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
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Article> {
      final Attribute1.Mapper attribute1FieldMapper = new Attribute1.Mapper();

      @Override
      public Article map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final List<Attribute1> attributes = reader.readList($responseFields[5], new ResponseReader.ListReader<Attribute1>() {
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
        final String description = reader.readString($responseFields[6]);
        final double height = reader.readDouble($responseFields[7]);
        final double length = reader.readDouble($responseFields[8]);
        final String name = reader.readString($responseFields[9]);
        final double weight = reader.readDouble($responseFields[10]);
        final double width = reader.readDouble($responseFields[11]);
        final Integer quantity = reader.readInt($responseFields[12]);
        return new Article(__typename, id, ref, type, status, attributes, description, height, length, name, weight, width, quantity);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nonnull String type;

      private @Nullable String status;

      private @Nullable List<Attribute1> attributes;

      private @Nullable String description;

      private double height;

      private double length;

      private @Nullable String name;

      private double weight;

      private double width;

      private @Nullable Integer quantity;

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

      public Builder attributes(@Nullable List<Attribute1> attributes) {
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

      public Article build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Article(__typename, id, ref, type, status, attributes, description, height, length, name, weight, width, quantity);
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

  public static class Fulfilments {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge1> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilments(@Nonnull String __typename, @Nullable List<Edge1> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Fulfilment type node
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
        $toString = "Fulfilments{"
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
      if (o instanceof Fulfilments) {
        Fulfilments that = (Fulfilments) o;
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

    public static final class Mapper implements ResponseFieldMapper<Fulfilments> {
      final Edge1.Mapper edge1FieldMapper = new Edge1.Mapper();

      @Override
      public Fulfilments map(ResponseReader reader) {
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
        return new Fulfilments(__typename, edges);
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

      public Fulfilments build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Fulfilments(__typename, edges);
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
     *  The item at the end of the Fulfilment edge
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
      ResponseField.forObject("order", "order", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable Object createdOn;

    final @Nullable Object updatedOn;

    final @Nullable List<Attribute2> attributes;

    final @Nullable String deliveryType;

    final @Nonnull String type;

    final @Nullable String eta;

    final @Nullable Object expiryTime;

    final @Nullable Order order;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node1(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable Object createdOn, @Nullable Object updatedOn,
        @Nullable List<Attribute2> attributes, @Nullable String deliveryType, @Nonnull String type,
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
    public @Nullable List<Attribute2> attributes() {
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
              listItemWriter.writeObject(((Attribute2) value).marshaller());
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
        $toString = "Node1{"
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
      if (o instanceof Node1) {
        Node1 that = (Node1) o;
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

    public static final class Mapper implements ResponseFieldMapper<Node1> {
      final Attribute2.Mapper attribute2FieldMapper = new Attribute2.Mapper();

      final Order.Mapper orderFieldMapper = new Order.Mapper();

      @Override
      public Node1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[4]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final List<Attribute2> attributes = reader.readList($responseFields[6], new ResponseReader.ListReader<Attribute2>() {
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
        return new Node1(__typename, id, ref, status, createdOn, updatedOn, attributes, deliveryType, type, eta, expiryTime, order);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable Object createdOn;

      private @Nullable Object updatedOn;

      private @Nullable List<Attribute2> attributes;

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

      public Builder attributes(@Nullable List<Attribute2> attributes) {
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

      public Builder order(@Nonnull Mutator<Order.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Order.Builder builder = this.order != null ? this.order.toBuilder() : Order.builder();
        mutator.accept(builder);
        this.order = builder.build();
        return this;
      }

      public Node1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Node1(__typename, id, ref, status, createdOn, updatedOn, attributes, deliveryType, type, eta, expiryTime, order);
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

    final @Nullable List<Attribute3> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Order(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nonnull String type, @Nullable String status, @Nullable Object createdOn,
        @Nullable Object updatedOn, @Nullable List<Attribute3> attributes) {
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
    public @Nullable List<Attribute3> attributes() {
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
              listItemWriter.writeObject(((Attribute3) value).marshaller());
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
      final Attribute3.Mapper attribute3FieldMapper = new Attribute3.Mapper();

      @Override
      public Order map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String status = reader.readString($responseFields[4]);
        final Object createdOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final Object updatedOn = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[6]);
        final List<Attribute3> attributes = reader.readList($responseFields[7], new ResponseReader.ListReader<Attribute3>() {
          @Override
          public Attribute3 read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Attribute3>() {
              @Override
              public Attribute3 read(ResponseReader reader) {
                return attribute3FieldMapper.map(reader);
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

      private @Nullable List<Attribute3> attributes;

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

      public Builder attributes(@Nullable List<Attribute3> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder attributes(@Nonnull Mutator<List<Attribute3.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Attribute3.Builder> builders = new ArrayList<>();
        if (this.attributes != null) {
          for (Attribute3 item : this.attributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Attribute3> attributes = new ArrayList<>();
        for (Attribute3.Builder item : builders) {
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

  public static class Attribute3 {
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

    public Attribute3(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
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
        $toString = "Attribute3{"
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
      if (o instanceof Attribute3) {
        Attribute3 that = (Attribute3) o;
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

    public static final class Mapper implements ResponseFieldMapper<Attribute3> {
      @Override
      public Attribute3 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new Attribute3(__typename, name, type, value);
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

      public Attribute3 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new Attribute3(__typename, name, type, value);
      }
    }
  }

  public static class ConsignmentArticles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge2> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ConsignmentArticles(@Nonnull String __typename, @Nullable List<Edge2> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to ConsignmentArticle type node
     */
    public @Nullable List<Edge2> edges() {
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
              listItemWriter.writeObject(((Edge2) value).marshaller());
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
      if (o instanceof ConsignmentArticles) {
        ConsignmentArticles that = (ConsignmentArticles) o;
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

    public static final class Mapper implements ResponseFieldMapper<ConsignmentArticles> {
      final Edge2.Mapper edge2FieldMapper = new Edge2.Mapper();

      @Override
      public ConsignmentArticles map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<Edge2> edges = reader.readList($responseFields[1], new ResponseReader.ListReader<Edge2>() {
          @Override
          public Edge2 read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Edge2>() {
              @Override
              public Edge2 read(ResponseReader reader) {
                return edge2FieldMapper.map(reader);
              }
            });
          }
        });
        return new ConsignmentArticles(__typename, edges);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge2> edges;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder edges(@Nullable List<Edge2> edges) {
        this.edges = edges;
        return this;
      }

      public Builder edges(@Nonnull Mutator<List<Edge2.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Edge2.Builder> builders = new ArrayList<>();
        if (this.edges != null) {
          for (Edge2 item : this.edges) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Edge2> edges = new ArrayList<>();
        for (Edge2.Builder item : builders) {
          edges.add(item != null ? item.build() : null);
        }
        this.edges = edges;
        return this;
      }

      public ConsignmentArticles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new ConsignmentArticles(__typename, edges);
      }
    }
  }

  public static class Edge2 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Node2 node;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge2(@Nonnull String __typename, @Nullable Node2 node) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.node = node;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the ConsignmentArticle edge
     */
    public @Nullable Node2 node() {
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
        $toString = "Edge2{"
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
      if (o instanceof Edge2) {
        Edge2 that = (Edge2) o;
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

    public static final class Mapper implements ResponseFieldMapper<Edge2> {
      final Node2.Mapper node2FieldMapper = new Node2.Mapper();

      @Override
      public Edge2 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Node2 node = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Node2>() {
          @Override
          public Node2 read(ResponseReader reader) {
            return node2FieldMapper.map(reader);
          }
        });
        return new Edge2(__typename, node);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Node2 node;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder node(@Nullable Node2 node) {
        this.node = node;
        return this;
      }

      public Builder node(@Nonnull Mutator<Node2.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Node2.Builder builder = this.node != null ? this.node.toBuilder() : Node2.builder();
        mutator.accept(builder);
        this.node = builder.build();
        return this;
      }

      public Edge2 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Edge2(__typename, node);
      }
    }
  }

  public static class Node2 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("consignment", "consignment", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Consignment consignment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node2(@Nonnull String __typename, @Nullable Consignment consignment) {
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
        $toString = "Node2{"
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
      if (o instanceof Node2) {
        Node2 that = (Node2) o;
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

    public static final class Mapper implements ResponseFieldMapper<Node2> {
      final Consignment.Mapper consignmentFieldMapper = new Consignment.Mapper();

      @Override
      public Node2 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Consignment consignment = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Consignment>() {
          @Override
          public Consignment read(ResponseReader reader) {
            return consignmentFieldMapper.map(reader);
          }
        });
        return new Node2(__typename, consignment);
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

      public Node2 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Node2(__typename, consignment);
      }
    }
  }

  public static class Consignment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("consignmentReference", "consignmentReference", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("trackingLabel", "trackingLabel", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("labelUrl", "labelUrl", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("orderSummaryUrl", "orderSummaryUrl", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nonnull String consignmentReference;

    final @Nullable String trackingLabel;

    final @Nullable String labelUrl;

    final @Nullable String orderSummaryUrl;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Consignment(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nonnull String consignmentReference,
        @Nullable String trackingLabel, @Nullable String labelUrl,
        @Nullable String orderSummaryUrl) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.consignmentReference = Utils.checkNotNull(consignmentReference, "consignmentReference == null");
      this.trackingLabel = trackingLabel;
      this.labelUrl = labelUrl;
      this.orderSummaryUrl = orderSummaryUrl;
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
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Consignment{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "consignmentReference=" + consignmentReference + ", "
          + "trackingLabel=" + trackingLabel + ", "
          + "labelUrl=" + labelUrl + ", "
          + "orderSummaryUrl=" + orderSummaryUrl
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
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.consignmentReference.equals(that.consignmentReference)
         && ((this.trackingLabel == null) ? (that.trackingLabel == null) : this.trackingLabel.equals(that.trackingLabel))
         && ((this.labelUrl == null) ? (that.labelUrl == null) : this.labelUrl.equals(that.labelUrl))
         && ((this.orderSummaryUrl == null) ? (that.orderSummaryUrl == null) : this.orderSummaryUrl.equals(that.orderSummaryUrl));
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
        final String status = reader.readString($responseFields[3]);
        final String consignmentReference = reader.readString($responseFields[4]);
        final String trackingLabel = reader.readString($responseFields[5]);
        final String labelUrl = reader.readString($responseFields[6]);
        final String orderSummaryUrl = reader.readString($responseFields[7]);
        return new Consignment(__typename, id, ref, status, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl);
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

      public Consignment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(consignmentReference, "consignmentReference == null");
        return new Consignment(__typename, id, ref, status, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl);
      }
    }
  }

  public static class CarrierConsignmentArticles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge3> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CarrierConsignmentArticles(@Nonnull String __typename, @Nullable List<Edge3> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to CarrierConsignmentArticle type node
     */
    public @Nullable List<Edge3> edges() {
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
              listItemWriter.writeObject(((Edge3) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CarrierConsignmentArticles{"
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
      if (o instanceof CarrierConsignmentArticles) {
        CarrierConsignmentArticles that = (CarrierConsignmentArticles) o;
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

    public static final class Mapper implements ResponseFieldMapper<CarrierConsignmentArticles> {
      final Edge3.Mapper edge3FieldMapper = new Edge3.Mapper();

      @Override
      public CarrierConsignmentArticles map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<Edge3> edges = reader.readList($responseFields[1], new ResponseReader.ListReader<Edge3>() {
          @Override
          public Edge3 read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Edge3>() {
              @Override
              public Edge3 read(ResponseReader reader) {
                return edge3FieldMapper.map(reader);
              }
            });
          }
        });
        return new CarrierConsignmentArticles(__typename, edges);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge3> edges;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder edges(@Nullable List<Edge3> edges) {
        this.edges = edges;
        return this;
      }

      public Builder edges(@Nonnull Mutator<List<Edge3.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Edge3.Builder> builders = new ArrayList<>();
        if (this.edges != null) {
          for (Edge3 item : this.edges) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Edge3> edges = new ArrayList<>();
        for (Edge3.Builder item : builders) {
          edges.add(item != null ? item.build() : null);
        }
        this.edges = edges;
        return this;
      }

      public CarrierConsignmentArticles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new CarrierConsignmentArticles(__typename, edges);
      }
    }
  }

  public static class Edge3 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Node3 node;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge3(@Nonnull String __typename, @Nullable Node3 node) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.node = node;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the CarrierConsignmentArticle edge
     */
    public @Nullable Node3 node() {
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
        $toString = "Edge3{"
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
      if (o instanceof Edge3) {
        Edge3 that = (Edge3) o;
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

    public static final class Mapper implements ResponseFieldMapper<Edge3> {
      final Node3.Mapper node3FieldMapper = new Node3.Mapper();

      @Override
      public Edge3 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Node3 node = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Node3>() {
          @Override
          public Node3 read(ResponseReader reader) {
            return node3FieldMapper.map(reader);
          }
        });
        return new Edge3(__typename, node);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Node3 node;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder node(@Nullable Node3 node) {
        this.node = node;
        return this;
      }

      public Builder node(@Nonnull Mutator<Node3.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Node3.Builder builder = this.node != null ? this.node.toBuilder() : Node3.builder();
        mutator.accept(builder);
        this.node = builder.build();
        return this;
      }

      public Edge3 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Edge3(__typename, node);
      }
    }
  }

  public static class Node3 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("carrierConsignment", "carrierConsignment", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable CarrierConsignment carrierConsignment;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node3(@Nonnull String __typename, @Nullable CarrierConsignment carrierConsignment) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.carrierConsignment = carrierConsignment;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  Consignment
     */
    public @Nullable CarrierConsignment carrierConsignment() {
      return this.carrierConsignment;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], carrierConsignment != null ? carrierConsignment.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node3{"
          + "__typename=" + __typename + ", "
          + "carrierConsignment=" + carrierConsignment
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Node3) {
        Node3 that = (Node3) o;
        return this.__typename.equals(that.__typename)
         && ((this.carrierConsignment == null) ? (that.carrierConsignment == null) : this.carrierConsignment.equals(that.carrierConsignment));
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
        h ^= (carrierConsignment == null) ? 0 : carrierConsignment.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.carrierConsignment = carrierConsignment;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node3> {
      final CarrierConsignment.Mapper carrierConsignmentFieldMapper = new CarrierConsignment.Mapper();

      @Override
      public Node3 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final CarrierConsignment carrierConsignment = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<CarrierConsignment>() {
          @Override
          public CarrierConsignment read(ResponseReader reader) {
            return carrierConsignmentFieldMapper.map(reader);
          }
        });
        return new Node3(__typename, carrierConsignment);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable CarrierConsignment carrierConsignment;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder carrierConsignment(@Nullable CarrierConsignment carrierConsignment) {
        this.carrierConsignment = carrierConsignment;
        return this;
      }

      public Builder carrierConsignment(@Nonnull Mutator<CarrierConsignment.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        CarrierConsignment.Builder builder = this.carrierConsignment != null ? this.carrierConsignment.toBuilder() : CarrierConsignment.builder();
        mutator.accept(builder);
        this.carrierConsignment = builder.build();
        return this;
      }

      public Node3 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Node3(__typename, carrierConsignment);
      }
    }
  }

  public static class CarrierConsignment {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("consignmentReference", "consignmentReference", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("trackingLabel", "trackingLabel", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("labelUrl", "labelUrl", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("orderSummaryUrl", "orderSummaryUrl", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("carrier", "carrier", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("retailer", "retailer", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("manifests", "manifests", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String ref;

    final @Nullable String status;

    final @Nullable String consignmentReference;

    final @Nullable String trackingLabel;

    final @Nullable String labelUrl;

    final @Nullable String orderSummaryUrl;

    final @Nullable Carrier carrier;

    final @Nullable Retailer retailer;

    final @Nullable Manifests manifests;

    final @Nullable List<Attribute4> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public CarrierConsignment(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref,
        @Nullable String status, @Nullable String consignmentReference,
        @Nullable String trackingLabel, @Nullable String labelUrl, @Nullable String orderSummaryUrl,
        @Nullable Carrier carrier, @Nullable Retailer retailer, @Nullable Manifests manifests,
        @Nullable List<Attribute4> attributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.status = status;
      this.consignmentReference = consignmentReference;
      this.trackingLabel = trackingLabel;
      this.labelUrl = labelUrl;
      this.orderSummaryUrl = orderSummaryUrl;
      this.carrier = carrier;
      this.retailer = retailer;
      this.manifests = manifests;
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
     *  External reference of the `Consignment`. Must be unique.
     */
    public @Nonnull String ref() {
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
    public @Nullable String consignmentReference() {
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

    /**
     *  Manifests that contain the consignment
     */
    public @Nullable Manifests manifests() {
      return this.manifests;
    }

    /**
     *  A list of attributes associated with this Consignment. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public @Nullable List<Attribute4> attributes() {
      return this.attributes;
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
          writer.writeObject($responseFields[8], carrier != null ? carrier.marshaller() : null);
          writer.writeObject($responseFields[9], retailer != null ? retailer.marshaller() : null);
          writer.writeObject($responseFields[10], manifests != null ? manifests.marshaller() : null);
          writer.writeList($responseFields[11], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute4) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CarrierConsignment{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "consignmentReference=" + consignmentReference + ", "
          + "trackingLabel=" + trackingLabel + ", "
          + "labelUrl=" + labelUrl + ", "
          + "orderSummaryUrl=" + orderSummaryUrl + ", "
          + "carrier=" + carrier + ", "
          + "retailer=" + retailer + ", "
          + "manifests=" + manifests + ", "
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
      if (o instanceof CarrierConsignment) {
        CarrierConsignment that = (CarrierConsignment) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.ref.equals(that.ref)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.consignmentReference == null) ? (that.consignmentReference == null) : this.consignmentReference.equals(that.consignmentReference))
         && ((this.trackingLabel == null) ? (that.trackingLabel == null) : this.trackingLabel.equals(that.trackingLabel))
         && ((this.labelUrl == null) ? (that.labelUrl == null) : this.labelUrl.equals(that.labelUrl))
         && ((this.orderSummaryUrl == null) ? (that.orderSummaryUrl == null) : this.orderSummaryUrl.equals(that.orderSummaryUrl))
         && ((this.carrier == null) ? (that.carrier == null) : this.carrier.equals(that.carrier))
         && ((this.retailer == null) ? (that.retailer == null) : this.retailer.equals(that.retailer))
         && ((this.manifests == null) ? (that.manifests == null) : this.manifests.equals(that.manifests))
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
        h ^= ref.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (consignmentReference == null) ? 0 : consignmentReference.hashCode();
        h *= 1000003;
        h ^= (trackingLabel == null) ? 0 : trackingLabel.hashCode();
        h *= 1000003;
        h ^= (labelUrl == null) ? 0 : labelUrl.hashCode();
        h *= 1000003;
        h ^= (orderSummaryUrl == null) ? 0 : orderSummaryUrl.hashCode();
        h *= 1000003;
        h ^= (carrier == null) ? 0 : carrier.hashCode();
        h *= 1000003;
        h ^= (retailer == null) ? 0 : retailer.hashCode();
        h *= 1000003;
        h ^= (manifests == null) ? 0 : manifests.hashCode();
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
      builder.status = status;
      builder.consignmentReference = consignmentReference;
      builder.trackingLabel = trackingLabel;
      builder.labelUrl = labelUrl;
      builder.orderSummaryUrl = orderSummaryUrl;
      builder.carrier = carrier;
      builder.retailer = retailer;
      builder.manifests = manifests;
      builder.attributes = attributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<CarrierConsignment> {
      final Carrier.Mapper carrierFieldMapper = new Carrier.Mapper();

      final Retailer.Mapper retailerFieldMapper = new Retailer.Mapper();

      final Manifests.Mapper manifestsFieldMapper = new Manifests.Mapper();

      final Attribute4.Mapper attribute4FieldMapper = new Attribute4.Mapper();

      @Override
      public CarrierConsignment map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String consignmentReference = reader.readString($responseFields[4]);
        final String trackingLabel = reader.readString($responseFields[5]);
        final String labelUrl = reader.readString($responseFields[6]);
        final String orderSummaryUrl = reader.readString($responseFields[7]);
        final Carrier carrier = reader.readObject($responseFields[8], new ResponseReader.ObjectReader<Carrier>() {
          @Override
          public Carrier read(ResponseReader reader) {
            return carrierFieldMapper.map(reader);
          }
        });
        final Retailer retailer = reader.readObject($responseFields[9], new ResponseReader.ObjectReader<Retailer>() {
          @Override
          public Retailer read(ResponseReader reader) {
            return retailerFieldMapper.map(reader);
          }
        });
        final Manifests manifests = reader.readObject($responseFields[10], new ResponseReader.ObjectReader<Manifests>() {
          @Override
          public Manifests read(ResponseReader reader) {
            return manifestsFieldMapper.map(reader);
          }
        });
        final List<Attribute4> attributes = reader.readList($responseFields[11], new ResponseReader.ListReader<Attribute4>() {
          @Override
          public Attribute4 read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Attribute4>() {
              @Override
              public Attribute4 read(ResponseReader reader) {
                return attribute4FieldMapper.map(reader);
              }
            });
          }
        });
        return new CarrierConsignment(__typename, id, ref, status, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl, carrier, retailer, manifests, attributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String ref;

      private @Nullable String status;

      private @Nullable String consignmentReference;

      private @Nullable String trackingLabel;

      private @Nullable String labelUrl;

      private @Nullable String orderSummaryUrl;

      private @Nullable Carrier carrier;

      private @Nullable Retailer retailer;

      private @Nullable Manifests manifests;

      private @Nullable List<Attribute4> attributes;

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

      public Builder status(@Nullable String status) {
        this.status = status;
        return this;
      }

      public Builder consignmentReference(@Nullable String consignmentReference) {
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

      public Builder carrier(@Nullable Carrier carrier) {
        this.carrier = carrier;
        return this;
      }

      public Builder retailer(@Nullable Retailer retailer) {
        this.retailer = retailer;
        return this;
      }

      public Builder manifests(@Nullable Manifests manifests) {
        this.manifests = manifests;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute4> attributes) {
        this.attributes = attributes;
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

      public Builder manifests(@Nonnull Mutator<Manifests.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Manifests.Builder builder = this.manifests != null ? this.manifests.toBuilder() : Manifests.builder();
        mutator.accept(builder);
        this.manifests = builder.build();
        return this;
      }

      public Builder attributes(@Nonnull Mutator<List<Attribute4.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Attribute4.Builder> builders = new ArrayList<>();
        if (this.attributes != null) {
          for (Attribute4 item : this.attributes) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Attribute4> attributes = new ArrayList<>();
        for (Attribute4.Builder item : builders) {
          attributes.add(item != null ? item.build() : null);
        }
        this.attributes = attributes;
        return this;
      }

      public CarrierConsignment build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        return new CarrierConsignment(__typename, id, ref, status, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl, carrier, retailer, manifests, attributes);
      }
    }
  }

  public static class Carrier {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Carrier(@Nonnull String __typename, @Nonnull String id) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Carrier{"
          + "__typename=" + __typename + ", "
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
      if (o instanceof Carrier) {
        Carrier that = (Carrier) o;
        return this.__typename.equals(that.__typename)
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
        h ^= id.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
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
        return new Carrier(__typename, id);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

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

      public Carrier build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Carrier(__typename, id);
      }
    }
  }

  public static class Retailer {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Retailer(@Nonnull String __typename, @Nonnull String id) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Retailer{"
          + "__typename=" + __typename + ", "
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
      if (o instanceof Retailer) {
        Retailer that = (Retailer) o;
        return this.__typename.equals(that.__typename)
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
        h ^= id.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
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
        return new Retailer(__typename, id);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

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

      public Retailer build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Retailer(__typename, id);
      }
    }
  }

  public static class Manifests {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge4> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Manifests(@Nonnull String __typename, @Nullable List<Edge4> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Manifest type node
     */
    public @Nullable List<Edge4> edges() {
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
              listItemWriter.writeObject(((Edge4) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Manifests{"
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
      if (o instanceof Manifests) {
        Manifests that = (Manifests) o;
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

    public static final class Mapper implements ResponseFieldMapper<Manifests> {
      final Edge4.Mapper edge4FieldMapper = new Edge4.Mapper();

      @Override
      public Manifests map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<Edge4> edges = reader.readList($responseFields[1], new ResponseReader.ListReader<Edge4>() {
          @Override
          public Edge4 read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Edge4>() {
              @Override
              public Edge4 read(ResponseReader reader) {
                return edge4FieldMapper.map(reader);
              }
            });
          }
        });
        return new Manifests(__typename, edges);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge4> edges;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder edges(@Nullable List<Edge4> edges) {
        this.edges = edges;
        return this;
      }

      public Builder edges(@Nonnull Mutator<List<Edge4.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Edge4.Builder> builders = new ArrayList<>();
        if (this.edges != null) {
          for (Edge4 item : this.edges) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Edge4> edges = new ArrayList<>();
        for (Edge4.Builder item : builders) {
          edges.add(item != null ? item.build() : null);
        }
        this.edges = edges;
        return this;
      }

      public Manifests build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Manifests(__typename, edges);
      }
    }
  }

  public static class Edge4 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Node4 node;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge4(@Nonnull String __typename, @Nullable Node4 node) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.node = node;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Manifest edge
     */
    public @Nullable Node4 node() {
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
        $toString = "Edge4{"
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
      if (o instanceof Edge4) {
        Edge4 that = (Edge4) o;
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

    public static final class Mapper implements ResponseFieldMapper<Edge4> {
      final Node4.Mapper node4FieldMapper = new Node4.Mapper();

      @Override
      public Edge4 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Node4 node = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Node4>() {
          @Override
          public Node4 read(ResponseReader reader) {
            return node4FieldMapper.map(reader);
          }
        });
        return new Edge4(__typename, node);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Node4 node;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder node(@Nullable Node4 node) {
        this.node = node;
        return this;
      }

      public Builder node(@Nonnull Mutator<Node4.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Node4.Builder builder = this.node != null ? this.node.toBuilder() : Node4.builder();
        mutator.accept(builder);
        this.node = builder.build();
        return this;
      }

      public Edge4 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Edge4(__typename, node);
      }
    }
  }

  public static class Node4 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node4(@Nonnull String __typename, @Nonnull String id) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node4{"
          + "__typename=" + __typename + ", "
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
      if (o instanceof Node4) {
        Node4 that = (Node4) o;
        return this.__typename.equals(that.__typename)
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
        h ^= id.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node4> {
      @Override
      public Node4 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new Node4(__typename, id);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

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

      public Node4 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Node4(__typename, id);
      }
    }
  }

  public static class Attribute4 {
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

    public Attribute4(@Nonnull String __typename, @Nonnull String name, @Nonnull String type,
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
        $toString = "Attribute4{"
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
      if (o instanceof Attribute4) {
        Attribute4 that = (Attribute4) o;
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

    public static final class Mapper implements ResponseFieldMapper<Attribute4> {
      @Override
      public Attribute4 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new Attribute4(__typename, name, type, value);
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

      public Attribute4 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(value, "value == null");
        return new Attribute4(__typename, name, type, value);
      }
    }
  }
}
