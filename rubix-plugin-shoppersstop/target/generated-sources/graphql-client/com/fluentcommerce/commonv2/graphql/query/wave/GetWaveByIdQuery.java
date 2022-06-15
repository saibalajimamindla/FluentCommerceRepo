package com.fluentcommerce.commonv2.graphql.query.wave;

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
public final class GetWaveByIdQuery implements Query<GetWaveByIdQuery.Data, GetWaveByIdQuery.Data, GetWaveByIdQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetWaveById($id: ID!, $includeAttributes: Boolean!, $includeLocation: Boolean!, $includefulfilments: Boolean!, $includeArticles: Boolean!, $fulfilmentItemsCount: Int, $fulfilmentItemsCursor: String, $articlesCount: Int, $articlesCursor: String) {\n"
      + "  waveById(id: $id) {\n"
      + "    __typename\n"
      + "    ref\n"
      + "    name\n"
      + "    status\n"
      + "    type\n"
      + "    attributes @include(if: $includeAttributes) {\n"
      + "      __typename\n"
      + "      name\n"
      + "      value\n"
      + "      type\n"
      + "    }\n"
      + "    location @include(if: $includeLocation) {\n"
      + "      __typename\n"
      + "      id\n"
      + "      ref\n"
      + "      status\n"
      + "      name\n"
      + "      defaultCarrier\n"
      + "      defaultCarrierName\n"
      + "      supportPhoneNumber\n"
      + "      attributes {\n"
      + "        __typename\n"
      + "        name\n"
      + "        type\n"
      + "        value\n"
      + "      }\n"
      + "    }\n"
      + "    fulfilments(first: $fulfilmentItemsCount, after: $fulfilmentItemsCursor) @include(if: $includefulfilments) {\n"
      + "      __typename\n"
      + "      edges {\n"
      + "        __typename\n"
      + "        node {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "          status\n"
      + "          order {\n"
      + "            __typename\n"
      + "            id\n"
      + "            ref\n"
      + "          }\n"
      + "          fromAddress {\n"
      + "            __typename\n"
      + "            id\n"
      + "            ref\n"
      + "            name\n"
      + "            country\n"
      + "            street\n"
      + "            city\n"
      + "            postcode\n"
      + "            state\n"
      + "            region\n"
      + "            companyName\n"
      + "          }\n"
      + "          toAddress {\n"
      + "            __typename\n"
      + "            id\n"
      + "            ref\n"
      + "            name\n"
      + "            country\n"
      + "            street\n"
      + "            city\n"
      + "            postcode\n"
      + "            state\n"
      + "            region\n"
      + "            companyName\n"
      + "          }\n"
      + "          articles(first: $articlesCount, after: $articlesCursor) @include(if: $includeArticles) {\n"
      + "            __typename\n"
      + "            edges {\n"
      + "              __typename\n"
      + "              cursor\n"
      + "              node {\n"
      + "                __typename\n"
      + "                id\n"
      + "                name\n"
      + "                type\n"
      + "                ref\n"
      + "                description\n"
      + "                quantity\n"
      + "                length\n"
      + "                height\n"
      + "                weight\n"
      + "                width\n"
      + "                attributes {\n"
      + "                  __typename\n"
      + "                  name\n"
      + "                  type\n"
      + "                  value\n"
      + "                }\n"
      + "              }\n"
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
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetWaveById";
    }
  };

  private final GetWaveByIdQuery.Variables variables;

  public GetWaveByIdQuery(@Nonnull String id, boolean includeAttributes, boolean includeLocation,
      boolean includefulfilments, boolean includeArticles, @Nullable Integer fulfilmentItemsCount,
      @Nullable String fulfilmentItemsCursor, @Nullable Integer articlesCount,
      @Nullable String articlesCursor) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetWaveByIdQuery.Variables(id, includeAttributes, includeLocation, includefulfilments, includeArticles, fulfilmentItemsCount, fulfilmentItemsCursor, articlesCount, articlesCursor);
  }

  @Override
  public String operationId() {
    return "90c3ba05677b4d71956b58e9600bdb555dab0ff057d398a903b08a7351112505";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetWaveByIdQuery.Data wrapData(GetWaveByIdQuery.Data data) {
    return data;
  }

  @Override
  public GetWaveByIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetWaveByIdQuery.Data> responseFieldMapper() {
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

    private boolean includeLocation;

    private boolean includefulfilments;

    private boolean includeArticles;

    private @Nullable Integer fulfilmentItemsCount;

    private @Nullable String fulfilmentItemsCursor;

    private @Nullable Integer articlesCount;

    private @Nullable String articlesCursor;

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

    public Builder includeLocation(boolean includeLocation) {
      this.includeLocation = includeLocation;
      return this;
    }

    public Builder includefulfilments(boolean includefulfilments) {
      this.includefulfilments = includefulfilments;
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

    public Builder articlesCount(@Nullable Integer articlesCount) {
      this.articlesCount = articlesCount;
      return this;
    }

    public Builder articlesCursor(@Nullable String articlesCursor) {
      this.articlesCursor = articlesCursor;
      return this;
    }

    public GetWaveByIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetWaveByIdQuery(id, includeAttributes, includeLocation, includefulfilments, includeArticles, fulfilmentItemsCount, fulfilmentItemsCursor, articlesCount, articlesCursor);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final boolean includeAttributes;

    private final boolean includeLocation;

    private final boolean includefulfilments;

    private final boolean includeArticles;

    private final @Nullable Integer fulfilmentItemsCount;

    private final @Nullable String fulfilmentItemsCursor;

    private final @Nullable Integer articlesCount;

    private final @Nullable String articlesCursor;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id, boolean includeAttributes, boolean includeLocation,
        boolean includefulfilments, boolean includeArticles, @Nullable Integer fulfilmentItemsCount,
        @Nullable String fulfilmentItemsCursor, @Nullable Integer articlesCount,
        @Nullable String articlesCursor) {
      this.id = id;
      this.includeAttributes = includeAttributes;
      this.includeLocation = includeLocation;
      this.includefulfilments = includefulfilments;
      this.includeArticles = includeArticles;
      this.fulfilmentItemsCount = fulfilmentItemsCount;
      this.fulfilmentItemsCursor = fulfilmentItemsCursor;
      this.articlesCount = articlesCount;
      this.articlesCursor = articlesCursor;
      this.valueMap.put("id", id);
      this.valueMap.put("includeAttributes", includeAttributes);
      this.valueMap.put("includeLocation", includeLocation);
      this.valueMap.put("includefulfilments", includefulfilments);
      this.valueMap.put("includeArticles", includeArticles);
      this.valueMap.put("fulfilmentItemsCount", fulfilmentItemsCount);
      this.valueMap.put("fulfilmentItemsCursor", fulfilmentItemsCursor);
      this.valueMap.put("articlesCount", articlesCount);
      this.valueMap.put("articlesCursor", articlesCursor);
    }

    public @Nonnull String id() {
      return id;
    }

    public boolean includeAttributes() {
      return includeAttributes;
    }

    public boolean includeLocation() {
      return includeLocation;
    }

    public boolean includefulfilments() {
      return includefulfilments;
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

    public @Nullable Integer articlesCount() {
      return articlesCount;
    }

    public @Nullable String articlesCursor() {
      return articlesCursor;
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
          writer.writeBoolean("includeLocation", includeLocation);
          writer.writeBoolean("includefulfilments", includefulfilments);
          writer.writeBoolean("includeArticles", includeArticles);
          writer.writeInt("fulfilmentItemsCount", fulfilmentItemsCount);
          writer.writeString("fulfilmentItemsCursor", fulfilmentItemsCursor);
          writer.writeInt("articlesCount", articlesCount);
          writer.writeString("articlesCursor", articlesCursor);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("waveById", "waveById", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable WaveById waveById;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable WaveById waveById) {
      this.waveById = waveById;
    }

    /**
     *  Find a Wave entity
     */
    public @Nullable WaveById waveById() {
      return this.waveById;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], waveById != null ? waveById.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "waveById=" + waveById
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
        return ((this.waveById == null) ? (that.waveById == null) : this.waveById.equals(that.waveById));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (waveById == null) ? 0 : waveById.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.waveById = waveById;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final WaveById.Mapper waveByIdFieldMapper = new WaveById.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final WaveById waveById = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<WaveById>() {
          @Override
          public WaveById read(ResponseReader reader) {
            return waveByIdFieldMapper.map(reader);
          }
        });
        return new Data(waveById);
      }
    }

    public static final class Builder {
      private @Nullable WaveById waveById;

      Builder() {
      }

      public Builder waveById(@Nullable WaveById waveById) {
        this.waveById = waveById;
        return this;
      }

      public Builder waveById(@Nonnull Mutator<WaveById.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        WaveById.Builder builder = this.waveById != null ? this.waveById.toBuilder() : WaveById.builder();
        mutator.accept(builder);
        this.waveById = builder.build();
        return this;
      }

      public Data build() {
        return new Data(waveById);
      }
    }
  }

  public static class WaveById {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeAttributes", false))),
      ResponseField.forObject("location", "location", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeLocation", false))),
      ResponseField.forObject("fulfilments", "fulfilments", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemsCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "fulfilmentItemsCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includefulfilments", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String ref;

    final @Nullable String name;

    final @Nullable String status;

    final @Nonnull String type;

    final @Nullable List<Attribute> attributes;

    final @Nullable Location location;

    final @Nullable Fulfilments fulfilments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public WaveById(@Nonnull String __typename, @Nonnull String ref, @Nullable String name,
        @Nullable String status, @Nonnull String type, @Nullable List<Attribute> attributes,
        @Nullable Location location, @Nullable Fulfilments fulfilments) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.name = name;
      this.status = status;
      this.type = Utils.checkNotNull(type, "type == null");
      this.attributes = attributes;
      this.location = location;
      this.fulfilments = fulfilments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  External reference of the object. Must be unique.
     */
    public @Nonnull String ref() {
      return this.ref;
    }

    /**
     *  Name of the wave
     */
    public @Nullable String name() {
      return this.name;
    }

    /**
     *  The current status of the `Wave`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Type of the `Wave`, typically used by the Orchestration Engine to determine the workflow that should be applied. Unless stated otherwise, no values are enforced by the platform.<br/>
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  A list of attributes associated with this wave. Attributes can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    /**
     *  Location of the wave operation
     */
    public @Nullable Location location() {
      return this.location;
    }

    /**
     *  Fulfilments associated with the wave
     */
    public @Nullable Fulfilments fulfilments() {
      return this.fulfilments;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
          writer.writeString($responseFields[2], name);
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], type);
          writer.writeList($responseFields[5], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeObject($responseFields[6], location != null ? location.marshaller() : null);
          writer.writeObject($responseFields[7], fulfilments != null ? fulfilments.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "WaveById{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
          + "name=" + name + ", "
          + "status=" + status + ", "
          + "type=" + type + ", "
          + "attributes=" + attributes + ", "
          + "location=" + location + ", "
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
      if (o instanceof WaveById) {
        WaveById that = (WaveById) o;
        return this.__typename.equals(that.__typename)
         && this.ref.equals(that.ref)
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.type.equals(that.type)
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.location == null) ? (that.location == null) : this.location.equals(that.location))
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
        h ^= ref.hashCode();
        h *= 1000003;
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (location == null) ? 0 : location.hashCode();
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
      builder.ref = ref;
      builder.name = name;
      builder.status = status;
      builder.type = type;
      builder.attributes = attributes;
      builder.location = location;
      builder.fulfilments = fulfilments;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<WaveById> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final Location.Mapper locationFieldMapper = new Location.Mapper();

      final Fulfilments.Mapper fulfilmentsFieldMapper = new Fulfilments.Mapper();

      @Override
      public WaveById map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String type = reader.readString($responseFields[4]);
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
        final Location location = reader.readObject($responseFields[6], new ResponseReader.ObjectReader<Location>() {
          @Override
          public Location read(ResponseReader reader) {
            return locationFieldMapper.map(reader);
          }
        });
        final Fulfilments fulfilments = reader.readObject($responseFields[7], new ResponseReader.ObjectReader<Fulfilments>() {
          @Override
          public Fulfilments read(ResponseReader reader) {
            return fulfilmentsFieldMapper.map(reader);
          }
        });
        return new WaveById(__typename, ref, name, status, type, attributes, location, fulfilments);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String ref;

      private @Nullable String name;

      private @Nullable String status;

      private @Nonnull String type;

      private @Nullable List<Attribute> attributes;

      private @Nullable Location location;

      private @Nullable Fulfilments fulfilments;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder ref(@Nonnull String ref) {
        this.ref = ref;
        return this;
      }

      public Builder name(@Nullable String name) {
        this.name = name;
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

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder location(@Nullable Location location) {
        this.location = location;
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

      public Builder location(@Nonnull Mutator<Location.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Location.Builder builder = this.location != null ? this.location.toBuilder() : Location.builder();
        mutator.accept(builder);
        this.location = builder.build();
        return this;
      }

      public Builder fulfilments(@Nonnull Mutator<Fulfilments.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Fulfilments.Builder builder = this.fulfilments != null ? this.fulfilments.toBuilder() : Fulfilments.builder();
        mutator.accept(builder);
        this.fulfilments = builder.build();
        return this;
      }

      public WaveById build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(ref, "ref == null");
        Utils.checkNotNull(type, "type == null");
        return new WaveById(__typename, ref, name, status, type, attributes, location, fulfilments);
      }
    }
  }

  public static class Attribute {
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

    public Attribute(@Nonnull String __typename, @Nonnull String name, @Nonnull Object value,
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
        $toString = "Attribute{"
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
      if (o instanceof Attribute) {
        Attribute that = (Attribute) o;
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

    public static final class Mapper implements ResponseFieldMapper<Attribute> {
      @Override
      public Attribute map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        return new Attribute(__typename, name, value, type);
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

      public Attribute build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(value, "value == null");
        Utils.checkNotNull(type, "type == null");
        return new Attribute(__typename, name, value, type);
      }
    }
  }

  public static class Location {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("defaultCarrier", "defaultCarrier", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("defaultCarrierName", "defaultCarrierName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("supportPhoneNumber", "supportPhoneNumber", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable String name;

    final @Nullable String defaultCarrier;

    final @Nullable String defaultCarrierName;

    final @Nullable String supportPhoneNumber;

    final @Nullable List<Attribute1> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Location(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable String name, @Nullable String defaultCarrier,
        @Nullable String defaultCarrierName, @Nullable String supportPhoneNumber,
        @Nullable List<Attribute1> attributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.name = name;
      this.defaultCarrier = defaultCarrier;
      this.defaultCarrierName = defaultCarrierName;
      this.supportPhoneNumber = supportPhoneNumber;
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
     *  Name of location
     */
    public @Nullable String name() {
      return this.name;
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
     *  The location contact number
     */
    public @Nullable String supportPhoneNumber() {
      return this.supportPhoneNumber;
    }

    /**
     *  Attributes
     */
    public @Nullable List<Attribute1> attributes() {
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
          writer.writeString($responseFields[4], name);
          writer.writeString($responseFields[5], defaultCarrier);
          writer.writeString($responseFields[6], defaultCarrierName);
          writer.writeString($responseFields[7], supportPhoneNumber);
          writer.writeList($responseFields[8], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute1) value).marshaller());
            }
          });
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
          + "name=" + name + ", "
          + "defaultCarrier=" + defaultCarrier + ", "
          + "defaultCarrierName=" + defaultCarrierName + ", "
          + "supportPhoneNumber=" + supportPhoneNumber + ", "
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
      if (o instanceof Location) {
        Location that = (Location) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.defaultCarrier == null) ? (that.defaultCarrier == null) : this.defaultCarrier.equals(that.defaultCarrier))
         && ((this.defaultCarrierName == null) ? (that.defaultCarrierName == null) : this.defaultCarrierName.equals(that.defaultCarrierName))
         && ((this.supportPhoneNumber == null) ? (that.supportPhoneNumber == null) : this.supportPhoneNumber.equals(that.supportPhoneNumber))
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
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= (defaultCarrier == null) ? 0 : defaultCarrier.hashCode();
        h *= 1000003;
        h ^= (defaultCarrierName == null) ? 0 : defaultCarrierName.hashCode();
        h *= 1000003;
        h ^= (supportPhoneNumber == null) ? 0 : supportPhoneNumber.hashCode();
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
      builder.name = name;
      builder.defaultCarrier = defaultCarrier;
      builder.defaultCarrierName = defaultCarrierName;
      builder.supportPhoneNumber = supportPhoneNumber;
      builder.attributes = attributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Location> {
      final Attribute1.Mapper attribute1FieldMapper = new Attribute1.Mapper();

      @Override
      public Location map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String name = reader.readString($responseFields[4]);
        final String defaultCarrier = reader.readString($responseFields[5]);
        final String defaultCarrierName = reader.readString($responseFields[6]);
        final String supportPhoneNumber = reader.readString($responseFields[7]);
        final List<Attribute1> attributes = reader.readList($responseFields[8], new ResponseReader.ListReader<Attribute1>() {
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
        return new Location(__typename, id, ref, status, name, defaultCarrier, defaultCarrierName, supportPhoneNumber, attributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable String name;

      private @Nullable String defaultCarrier;

      private @Nullable String defaultCarrierName;

      private @Nullable String supportPhoneNumber;

      private @Nullable List<Attribute1> attributes;

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

      public Builder name(@Nullable String name) {
        this.name = name;
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

      public Builder supportPhoneNumber(@Nullable String supportPhoneNumber) {
        this.supportPhoneNumber = supportPhoneNumber;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute1> attributes) {
        this.attributes = attributes;
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

      public Location build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Location(__typename, id, ref, status, name, defaultCarrier, defaultCarrierName, supportPhoneNumber, attributes);
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
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge> edges;

    final @Nullable PageInfo1 pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Fulfilments(@Nonnull String __typename, @Nullable List<Edge> edges,
        @Nullable PageInfo1 pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Fulfilment type node
     */
    public @Nullable List<Edge> edges() {
      return this.edges;
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
          writer.writeList($responseFields[1], edges, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Edge) value).marshaller());
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
          + "edges=" + edges + ", "
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
         && ((this.edges == null) ? (that.edges == null) : this.edges.equals(that.edges))
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
        h ^= (edges == null) ? 0 : edges.hashCode();
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
      builder.edges = edges;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Fulfilments> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      final PageInfo1.Mapper pageInfo1FieldMapper = new PageInfo1.Mapper();

      @Override
      public Fulfilments map(ResponseReader reader) {
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
        final PageInfo1 pageInfo = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<PageInfo1>() {
          @Override
          public PageInfo1 read(ResponseReader reader) {
            return pageInfo1FieldMapper.map(reader);
          }
        });
        return new Fulfilments(__typename, edges, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge> edges;

      private @Nullable PageInfo1 pageInfo;

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

      public Builder pageInfo(@Nullable PageInfo1 pageInfo) {
        this.pageInfo = pageInfo;
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

      public Builder pageInfo(@Nonnull Mutator<PageInfo1.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo1.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo1.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public Fulfilments build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Fulfilments(__typename, edges, pageInfo);
      }
    }
  }

  public static class Edge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable Node node;

    final @Nullable String cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge(@Nonnull String __typename, @Nullable Node node, @Nullable String cursor) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.node = node;
      this.cursor = cursor;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Fulfilment edge
     */
    public @Nullable Node node() {
      return this.node;
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
          writer.writeObject($responseFields[1], node != null ? node.marshaller() : null);
          writer.writeString($responseFields[2], cursor);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Edge{"
          + "__typename=" + __typename + ", "
          + "node=" + node + ", "
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
      if (o instanceof Edge) {
        Edge that = (Edge) o;
        return this.__typename.equals(that.__typename)
         && ((this.node == null) ? (that.node == null) : this.node.equals(that.node))
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
        h ^= (node == null) ? 0 : node.hashCode();
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
      builder.node = node;
      builder.cursor = cursor;
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
        final String cursor = reader.readString($responseFields[2]);
        return new Edge(__typename, node, cursor);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable Node node;

      private @Nullable String cursor;

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

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
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
        return new Edge(__typename, node, cursor);
      }
    }
  }

  public static class Node {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("order", "order", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fromAddress", "fromAddress", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("toAddress", "toAddress", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("articles", "articles", new UnmodifiableMapBuilder<String, Object>(2)
        .put("after", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "articlesCursor")
        .build())
        .put("first", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "articlesCount")
        .build())
      .build(), true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeArticles", false)))
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable Order order;

    final @Nullable FromAddress fromAddress;

    final @Nullable ToAddress toAddress;

    final @Nullable Articles articles;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String status, @Nullable Order order, @Nullable FromAddress fromAddress,
        @Nullable ToAddress toAddress, @Nullable Articles articles) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.order = order;
      this.fromAddress = fromAddress;
      this.toAddress = toAddress;
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
     *  The associated `Order`
     */
    public @Nullable Order order() {
      return this.order;
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
          writer.writeObject($responseFields[4], order != null ? order.marshaller() : null);
          writer.writeObject($responseFields[5], fromAddress != null ? fromAddress.marshaller() : null);
          writer.writeObject($responseFields[6], toAddress != null ? toAddress.marshaller() : null);
          writer.writeObject($responseFields[7], articles != null ? articles.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "order=" + order + ", "
          + "fromAddress=" + fromAddress + ", "
          + "toAddress=" + toAddress + ", "
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
      if (o instanceof Node) {
        Node that = (Node) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.order == null) ? (that.order == null) : this.order.equals(that.order))
         && ((this.fromAddress == null) ? (that.fromAddress == null) : this.fromAddress.equals(that.fromAddress))
         && ((this.toAddress == null) ? (that.toAddress == null) : this.toAddress.equals(that.toAddress))
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
        h ^= (order == null) ? 0 : order.hashCode();
        h *= 1000003;
        h ^= (fromAddress == null) ? 0 : fromAddress.hashCode();
        h *= 1000003;
        h ^= (toAddress == null) ? 0 : toAddress.hashCode();
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
      builder.order = order;
      builder.fromAddress = fromAddress;
      builder.toAddress = toAddress;
      builder.articles = articles;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node> {
      final Order.Mapper orderFieldMapper = new Order.Mapper();

      final FromAddress.Mapper fromAddressFieldMapper = new FromAddress.Mapper();

      final ToAddress.Mapper toAddressFieldMapper = new ToAddress.Mapper();

      final Articles.Mapper articlesFieldMapper = new Articles.Mapper();

      @Override
      public Node map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final Order order = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<Order>() {
          @Override
          public Order read(ResponseReader reader) {
            return orderFieldMapper.map(reader);
          }
        });
        final FromAddress fromAddress = reader.readObject($responseFields[5], new ResponseReader.ObjectReader<FromAddress>() {
          @Override
          public FromAddress read(ResponseReader reader) {
            return fromAddressFieldMapper.map(reader);
          }
        });
        final ToAddress toAddress = reader.readObject($responseFields[6], new ResponseReader.ObjectReader<ToAddress>() {
          @Override
          public ToAddress read(ResponseReader reader) {
            return toAddressFieldMapper.map(reader);
          }
        });
        final Articles articles = reader.readObject($responseFields[7], new ResponseReader.ObjectReader<Articles>() {
          @Override
          public Articles read(ResponseReader reader) {
            return articlesFieldMapper.map(reader);
          }
        });
        return new Node(__typename, id, ref, status, order, fromAddress, toAddress, articles);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable Order order;

      private @Nullable FromAddress fromAddress;

      private @Nullable ToAddress toAddress;

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

      public Builder order(@Nullable Order order) {
        this.order = order;
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

      public Builder articles(@Nullable Articles articles) {
        this.articles = articles;
        return this;
      }

      public Builder order(@Nonnull Mutator<Order.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Order.Builder builder = this.order != null ? this.order.toBuilder() : Order.builder();
        mutator.accept(builder);
        this.order = builder.build();
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

      public Builder articles(@Nonnull Mutator<Articles.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Articles.Builder builder = this.articles != null ? this.articles.toBuilder() : Articles.builder();
        mutator.accept(builder);
        this.articles = builder.build();
        return this;
      }

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Node(__typename, id, ref, status, order, fromAddress, toAddress, articles);
      }
    }
  }

  public static class Order {
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

    public Order(@Nonnull String __typename, @Nonnull String id, @Nullable String ref) {
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
     *  External reference of the object. Must be unique.
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
        $toString = "Order{"
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
      if (o instanceof Order) {
        Order that = (Order) o;
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

    public static final class Mapper implements ResponseFieldMapper<Order> {
      @Override
      public Order map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        return new Order(__typename, id, ref);
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

      public Order build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new Order(__typename, id, ref);
      }
    }
  }

  public static class FromAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("street", "street", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("city", "city", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("postcode", "postcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("state", "state", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("region", "region", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("companyName", "companyName", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String name;

    final @Nullable String country;

    final @Nullable String street;

    final @Nullable String city;

    final @Nullable String postcode;

    final @Nullable String state;

    final @Nullable String region;

    final @Nullable String companyName;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FromAddress(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String name, @Nullable String country, @Nullable String street,
        @Nullable String city, @Nullable String postcode, @Nullable String state,
        @Nullable String region, @Nullable String companyName) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.name = name;
      this.country = country;
      this.street = street;
      this.city = city;
      this.postcode = postcode;
      this.state = state;
      this.region = region;
      this.companyName = companyName;
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
     *  Name
     */
    public @Nullable String name() {
      return this.name;
    }

    /**
     *  Country
     */
    public @Nullable String country() {
      return this.country;
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
     *  Postcode
     */
    public @Nullable String postcode() {
      return this.postcode;
    }

    /**
     *  State
     */
    public @Nullable String state() {
      return this.state;
    }

    /**
     *  Region
     */
    public @Nullable String region() {
      return this.region;
    }

    /**
     *  Company name
     */
    public @Nullable String companyName() {
      return this.companyName;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], name);
          writer.writeString($responseFields[4], country);
          writer.writeString($responseFields[5], street);
          writer.writeString($responseFields[6], city);
          writer.writeString($responseFields[7], postcode);
          writer.writeString($responseFields[8], state);
          writer.writeString($responseFields[9], region);
          writer.writeString($responseFields[10], companyName);
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
          + "name=" + name + ", "
          + "country=" + country + ", "
          + "street=" + street + ", "
          + "city=" + city + ", "
          + "postcode=" + postcode + ", "
          + "state=" + state + ", "
          + "region=" + region + ", "
          + "companyName=" + companyName
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
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
         && ((this.street == null) ? (that.street == null) : this.street.equals(that.street))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.postcode == null) ? (that.postcode == null) : this.postcode.equals(that.postcode))
         && ((this.state == null) ? (that.state == null) : this.state.equals(that.state))
         && ((this.region == null) ? (that.region == null) : this.region.equals(that.region))
         && ((this.companyName == null) ? (that.companyName == null) : this.companyName.equals(that.companyName));
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
        h ^= (country == null) ? 0 : country.hashCode();
        h *= 1000003;
        h ^= (street == null) ? 0 : street.hashCode();
        h *= 1000003;
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (postcode == null) ? 0 : postcode.hashCode();
        h *= 1000003;
        h ^= (state == null) ? 0 : state.hashCode();
        h *= 1000003;
        h ^= (region == null) ? 0 : region.hashCode();
        h *= 1000003;
        h ^= (companyName == null) ? 0 : companyName.hashCode();
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
      builder.country = country;
      builder.street = street;
      builder.city = city;
      builder.postcode = postcode;
      builder.state = state;
      builder.region = region;
      builder.companyName = companyName;
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
        final String name = reader.readString($responseFields[3]);
        final String country = reader.readString($responseFields[4]);
        final String street = reader.readString($responseFields[5]);
        final String city = reader.readString($responseFields[6]);
        final String postcode = reader.readString($responseFields[7]);
        final String state = reader.readString($responseFields[8]);
        final String region = reader.readString($responseFields[9]);
        final String companyName = reader.readString($responseFields[10]);
        return new FromAddress(__typename, id, ref, name, country, street, city, postcode, state, region, companyName);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String name;

      private @Nullable String country;

      private @Nullable String street;

      private @Nullable String city;

      private @Nullable String postcode;

      private @Nullable String state;

      private @Nullable String region;

      private @Nullable String companyName;

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

      public Builder country(@Nullable String country) {
        this.country = country;
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

      public Builder postcode(@Nullable String postcode) {
        this.postcode = postcode;
        return this;
      }

      public Builder state(@Nullable String state) {
        this.state = state;
        return this;
      }

      public Builder region(@Nullable String region) {
        this.region = region;
        return this;
      }

      public Builder companyName(@Nullable String companyName) {
        this.companyName = companyName;
        return this;
      }

      public FromAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new FromAddress(__typename, id, ref, name, country, street, city, postcode, state, region, companyName);
      }
    }
  }

  public static class ToAddress {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("street", "street", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("city", "city", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("postcode", "postcode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("state", "state", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("region", "region", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("companyName", "companyName", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String name;

    final @Nullable String country;

    final @Nullable String street;

    final @Nullable String city;

    final @Nullable String postcode;

    final @Nullable String state;

    final @Nullable String region;

    final @Nullable String companyName;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ToAddress(@Nonnull String __typename, @Nonnull String id, @Nullable String ref,
        @Nullable String name, @Nullable String country, @Nullable String street,
        @Nullable String city, @Nullable String postcode, @Nullable String state,
        @Nullable String region, @Nullable String companyName) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.name = name;
      this.country = country;
      this.street = street;
      this.city = city;
      this.postcode = postcode;
      this.state = state;
      this.region = region;
      this.companyName = companyName;
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
     *  Name
     */
    public @Nullable String name() {
      return this.name;
    }

    /**
     *  Country
     */
    public @Nullable String country() {
      return this.country;
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
     *  Postcode
     */
    public @Nullable String postcode() {
      return this.postcode;
    }

    /**
     *  State
     */
    public @Nullable String state() {
      return this.state;
    }

    /**
     *  Region
     */
    public @Nullable String region() {
      return this.region;
    }

    /**
     *  Company name
     */
    public @Nullable String companyName() {
      return this.companyName;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], name);
          writer.writeString($responseFields[4], country);
          writer.writeString($responseFields[5], street);
          writer.writeString($responseFields[6], city);
          writer.writeString($responseFields[7], postcode);
          writer.writeString($responseFields[8], state);
          writer.writeString($responseFields[9], region);
          writer.writeString($responseFields[10], companyName);
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
          + "name=" + name + ", "
          + "country=" + country + ", "
          + "street=" + street + ", "
          + "city=" + city + ", "
          + "postcode=" + postcode + ", "
          + "state=" + state + ", "
          + "region=" + region + ", "
          + "companyName=" + companyName
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
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
         && ((this.street == null) ? (that.street == null) : this.street.equals(that.street))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.postcode == null) ? (that.postcode == null) : this.postcode.equals(that.postcode))
         && ((this.state == null) ? (that.state == null) : this.state.equals(that.state))
         && ((this.region == null) ? (that.region == null) : this.region.equals(that.region))
         && ((this.companyName == null) ? (that.companyName == null) : this.companyName.equals(that.companyName));
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
        h ^= (country == null) ? 0 : country.hashCode();
        h *= 1000003;
        h ^= (street == null) ? 0 : street.hashCode();
        h *= 1000003;
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (postcode == null) ? 0 : postcode.hashCode();
        h *= 1000003;
        h ^= (state == null) ? 0 : state.hashCode();
        h *= 1000003;
        h ^= (region == null) ? 0 : region.hashCode();
        h *= 1000003;
        h ^= (companyName == null) ? 0 : companyName.hashCode();
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
      builder.country = country;
      builder.street = street;
      builder.city = city;
      builder.postcode = postcode;
      builder.state = state;
      builder.region = region;
      builder.companyName = companyName;
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
        final String name = reader.readString($responseFields[3]);
        final String country = reader.readString($responseFields[4]);
        final String street = reader.readString($responseFields[5]);
        final String city = reader.readString($responseFields[6]);
        final String postcode = reader.readString($responseFields[7]);
        final String state = reader.readString($responseFields[8]);
        final String region = reader.readString($responseFields[9]);
        final String companyName = reader.readString($responseFields[10]);
        return new ToAddress(__typename, id, ref, name, country, street, city, postcode, state, region, companyName);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String name;

      private @Nullable String country;

      private @Nullable String street;

      private @Nullable String city;

      private @Nullable String postcode;

      private @Nullable String state;

      private @Nullable String region;

      private @Nullable String companyName;

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

      public Builder country(@Nullable String country) {
        this.country = country;
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

      public Builder postcode(@Nullable String postcode) {
        this.postcode = postcode;
        return this;
      }

      public Builder state(@Nullable String state) {
        this.state = state;
        return this;
      }

      public Builder region(@Nullable String region) {
        this.region = region;
        return this;
      }

      public Builder companyName(@Nullable String companyName) {
        this.companyName = companyName;
        return this;
      }

      public ToAddress build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new ToAddress(__typename, id, ref, name, country, street, city, postcode, state, region, companyName);
      }
    }
  }

  public static class Articles {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("pageInfo", "pageInfo", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge1> edges;

    final @Nullable PageInfo pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Articles(@Nonnull String __typename, @Nullable List<Edge1> edges,
        @Nullable PageInfo pageInfo) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
      this.pageInfo = pageInfo;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Article type node
     */
    public @Nullable List<Edge1> edges() {
      return this.edges;
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
          writer.writeList($responseFields[1], edges, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Edge1) value).marshaller());
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
          + "edges=" + edges + ", "
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
         && ((this.edges == null) ? (that.edges == null) : this.edges.equals(that.edges))
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
        h ^= (edges == null) ? 0 : edges.hashCode();
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
      builder.edges = edges;
      builder.pageInfo = pageInfo;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Articles> {
      final Edge1.Mapper edge1FieldMapper = new Edge1.Mapper();

      final PageInfo.Mapper pageInfoFieldMapper = new PageInfo.Mapper();

      @Override
      public Articles map(ResponseReader reader) {
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
        final PageInfo pageInfo = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<PageInfo>() {
          @Override
          public PageInfo read(ResponseReader reader) {
            return pageInfoFieldMapper.map(reader);
          }
        });
        return new Articles(__typename, edges, pageInfo);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<Edge1> edges;

      private @Nullable PageInfo pageInfo;

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

      public Builder pageInfo(@Nullable PageInfo pageInfo) {
        this.pageInfo = pageInfo;
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

      public Builder pageInfo(@Nonnull Mutator<PageInfo.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PageInfo.Builder builder = this.pageInfo != null ? this.pageInfo.toBuilder() : PageInfo.builder();
        mutator.accept(builder);
        this.pageInfo = builder.build();
        return this;
      }

      public Articles build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Articles(__typename, edges, pageInfo);
      }
    }
  }

  public static class Edge1 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("cursor", "cursor", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("node", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String cursor;

    final @Nullable Node1 node;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge1(@Nonnull String __typename, @Nullable String cursor, @Nullable Node1 node) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.cursor = cursor;
      this.node = node;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A cursor for use in pagination
     */
    public @Nullable String cursor() {
      return this.cursor;
    }

    /**
     *  The item at the end of the Article edge
     */
    public @Nullable Node1 node() {
      return this.node;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], cursor);
          writer.writeObject($responseFields[2], node != null ? node.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Edge1{"
          + "__typename=" + __typename + ", "
          + "cursor=" + cursor + ", "
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
         && ((this.cursor == null) ? (that.cursor == null) : this.cursor.equals(that.cursor))
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
        h ^= (cursor == null) ? 0 : cursor.hashCode();
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
      builder.cursor = cursor;
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
        final String cursor = reader.readString($responseFields[1]);
        final Node1 node = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<Node1>() {
          @Override
          public Node1 read(ResponseReader reader) {
            return node1FieldMapper.map(reader);
          }
        });
        return new Edge1(__typename, cursor, node);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String cursor;

      private @Nullable Node1 node;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder cursor(@Nullable String cursor) {
        this.cursor = cursor;
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
        return new Edge1(__typename, cursor, node);
      }
    }
  }

  public static class Node1 {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("description", "description", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("quantity", "quantity", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("length", "length", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("height", "height", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("weight", "weight", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("width", "width", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String name;

    final @Nonnull String type;

    final @Nullable String ref;

    final @Nullable String description;

    final @Nullable Integer quantity;

    final double length;

    final double height;

    final double weight;

    final double width;

    final @Nullable List<Attribute2> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node1(@Nonnull String __typename, @Nonnull String id, @Nullable String name,
        @Nonnull String type, @Nullable String ref, @Nullable String description,
        @Nullable Integer quantity, double length, double height, double weight, double width,
        @Nullable List<Attribute2> attributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.name = name;
      this.type = Utils.checkNotNull(type, "type == null");
      this.ref = ref;
      this.description = description;
      this.quantity = quantity;
      this.length = length;
      this.height = height;
      this.weight = weight;
      this.width = width;
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
     *  The unique article reference provided by the retailer
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  Description
     */
    public @Nullable String description() {
      return this.description;
    }

    /**
     *  Quantity
     */
    public @Nullable Integer quantity() {
      return this.quantity;
    }

    /**
     *  Length
     */
    public double length() {
      return this.length;
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
     *  Attributes of article
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
          writer.writeString($responseFields[2], name);
          writer.writeString($responseFields[3], type);
          writer.writeString($responseFields[4], ref);
          writer.writeString($responseFields[5], description);
          writer.writeInt($responseFields[6], quantity);
          writer.writeDouble($responseFields[7], length);
          writer.writeDouble($responseFields[8], height);
          writer.writeDouble($responseFields[9], weight);
          writer.writeDouble($responseFields[10], width);
          writer.writeList($responseFields[11], attributes, new ResponseWriter.ListWriter() {
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
        $toString = "Node1{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "name=" + name + ", "
          + "type=" + type + ", "
          + "ref=" + ref + ", "
          + "description=" + description + ", "
          + "quantity=" + quantity + ", "
          + "length=" + length + ", "
          + "height=" + height + ", "
          + "weight=" + weight + ", "
          + "width=" + width + ", "
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
      if (o instanceof Node1) {
        Node1 that = (Node1) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && this.type.equals(that.type)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.description == null) ? (that.description == null) : this.description.equals(that.description))
         && ((this.quantity == null) ? (that.quantity == null) : this.quantity.equals(that.quantity))
         && Double.doubleToLongBits(this.length) == Double.doubleToLongBits(that.length)
         && Double.doubleToLongBits(this.height) == Double.doubleToLongBits(that.height)
         && Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(that.weight)
         && Double.doubleToLongBits(this.width) == Double.doubleToLongBits(that.width)
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
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (ref == null) ? 0 : ref.hashCode();
        h *= 1000003;
        h ^= (description == null) ? 0 : description.hashCode();
        h *= 1000003;
        h ^= (quantity == null) ? 0 : quantity.hashCode();
        h *= 1000003;
        h ^= Double.valueOf(length).hashCode();
        h *= 1000003;
        h ^= Double.valueOf(height).hashCode();
        h *= 1000003;
        h ^= Double.valueOf(weight).hashCode();
        h *= 1000003;
        h ^= Double.valueOf(width).hashCode();
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
      builder.name = name;
      builder.type = type;
      builder.ref = ref;
      builder.description = description;
      builder.quantity = quantity;
      builder.length = length;
      builder.height = height;
      builder.weight = weight;
      builder.width = width;
      builder.attributes = attributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node1> {
      final Attribute2.Mapper attribute2FieldMapper = new Attribute2.Mapper();

      @Override
      public Node1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String type = reader.readString($responseFields[3]);
        final String ref = reader.readString($responseFields[4]);
        final String description = reader.readString($responseFields[5]);
        final Integer quantity = reader.readInt($responseFields[6]);
        final double length = reader.readDouble($responseFields[7]);
        final double height = reader.readDouble($responseFields[8]);
        final double weight = reader.readDouble($responseFields[9]);
        final double width = reader.readDouble($responseFields[10]);
        final List<Attribute2> attributes = reader.readList($responseFields[11], new ResponseReader.ListReader<Attribute2>() {
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
        return new Node1(__typename, id, name, type, ref, description, quantity, length, height, weight, width, attributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String name;

      private @Nonnull String type;

      private @Nullable String ref;

      private @Nullable String description;

      private @Nullable Integer quantity;

      private double length;

      private double height;

      private double weight;

      private double width;

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

      public Builder name(@Nullable String name) {
        this.name = name;
        return this;
      }

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder ref(@Nullable String ref) {
        this.ref = ref;
        return this;
      }

      public Builder description(@Nullable String description) {
        this.description = description;
        return this;
      }

      public Builder quantity(@Nullable Integer quantity) {
        this.quantity = quantity;
        return this;
      }

      public Builder length(double length) {
        this.length = length;
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

      public Node1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(type, "type == null");
        return new Node1(__typename, id, name, type, ref, description, quantity, length, height, weight, width, attributes);
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
