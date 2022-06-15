package com.fluentcommerce.commonv2.graphql.query.product;

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
public final class GetStandardProductByRefQuery implements Query<GetStandardProductByRefQuery.Data, GetStandardProductByRefQuery.Data, GetStandardProductByRefQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetStandardProductByRef($productRef: String!, $catalogueRef: String!) {\n"
      + "  standardProduct(ref: $productRef, catalogue: {ref: $catalogueRef}) {\n"
      + "    __typename\n"
      + "    ref\n"
      + "    type\n"
      + "    gtin\n"
      + "    name\n"
      + "    status\n"
      + "    attributes {\n"
      + "      __typename\n"
      + "      name\n"
      + "      type\n"
      + "      value\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetStandardProductByRef";
    }
  };

  private final GetStandardProductByRefQuery.Variables variables;

  public GetStandardProductByRefQuery(@Nonnull String productRef, @Nonnull String catalogueRef) {
    Utils.checkNotNull(productRef, "productRef == null");
    Utils.checkNotNull(catalogueRef, "catalogueRef == null");
    variables = new GetStandardProductByRefQuery.Variables(productRef, catalogueRef);
  }

  @Override
  public String operationId() {
    return "ab3d583431370d25f954f5e43ddfc4916bbeaf863da24c4c9b5edfd85ac6480b";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetStandardProductByRefQuery.Data wrapData(GetStandardProductByRefQuery.Data data) {
    return data;
  }

  @Override
  public GetStandardProductByRefQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetStandardProductByRefQuery.Data> responseFieldMapper() {
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
    private @Nonnull String productRef;

    private @Nonnull String catalogueRef;

    Builder() {
    }

    public Builder productRef(@Nonnull String productRef) {
      this.productRef = productRef;
      return this;
    }

    public Builder catalogueRef(@Nonnull String catalogueRef) {
      this.catalogueRef = catalogueRef;
      return this;
    }

    public GetStandardProductByRefQuery build() {
      Utils.checkNotNull(productRef, "productRef == null");
      Utils.checkNotNull(catalogueRef, "catalogueRef == null");
      return new GetStandardProductByRefQuery(productRef, catalogueRef);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String productRef;

    private final @Nonnull String catalogueRef;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String productRef, @Nonnull String catalogueRef) {
      this.productRef = productRef;
      this.catalogueRef = catalogueRef;
      this.valueMap.put("productRef", productRef);
      this.valueMap.put("catalogueRef", catalogueRef);
    }

    public @Nonnull String productRef() {
      return productRef;
    }

    public @Nonnull String catalogueRef() {
      return catalogueRef;
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
          writer.writeString("productRef", productRef);
          writer.writeString("catalogueRef", catalogueRef);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("standardProduct", "standardProduct", new UnmodifiableMapBuilder<String, Object>(2)
        .put("ref", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "productRef")
        .build())
        .put("catalogue", new UnmodifiableMapBuilder<String, Object>(1)
          .put("ref", new UnmodifiableMapBuilder<String, Object>(2)
            .put("kind", "Variable")
            .put("variableName", "catalogueRef")
          .build())
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable StandardProduct standardProduct;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable StandardProduct standardProduct) {
      this.standardProduct = standardProduct;
    }

    /**
     *  Find a StandardProduct entity
     */
    public @Nullable StandardProduct standardProduct() {
      return this.standardProduct;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], standardProduct != null ? standardProduct.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "standardProduct=" + standardProduct
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
        return ((this.standardProduct == null) ? (that.standardProduct == null) : this.standardProduct.equals(that.standardProduct));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (standardProduct == null) ? 0 : standardProduct.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.standardProduct = standardProduct;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final StandardProduct.Mapper standardProductFieldMapper = new StandardProduct.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final StandardProduct standardProduct = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<StandardProduct>() {
          @Override
          public StandardProduct read(ResponseReader reader) {
            return standardProductFieldMapper.map(reader);
          }
        });
        return new Data(standardProduct);
      }
    }

    public static final class Builder {
      private @Nullable StandardProduct standardProduct;

      Builder() {
      }

      public Builder standardProduct(@Nullable StandardProduct standardProduct) {
        this.standardProduct = standardProduct;
        return this;
      }

      public Builder standardProduct(@Nonnull Mutator<StandardProduct.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        StandardProduct.Builder builder = this.standardProduct != null ? this.standardProduct.toBuilder() : StandardProduct.builder();
        mutator.accept(builder);
        this.standardProduct = builder.build();
        return this;
      }

      public Data build() {
        return new Data(standardProduct);
      }
    }
  }

  public static class StandardProduct {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("gtin", "gtin", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String ref;

    final @Nonnull String type;

    final @Nonnull String gtin;

    final @Nonnull String name;

    final @Nullable String status;

    final @Nullable List<Attribute> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public StandardProduct(@Nonnull String __typename, @Nonnull String ref, @Nonnull String type,
        @Nonnull String gtin, @Nonnull String name, @Nullable String status,
        @Nullable List<Attribute> attributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.type = Utils.checkNotNull(type, "type == null");
      this.gtin = Utils.checkNotNull(gtin, "gtin == null");
      this.name = Utils.checkNotNull(name, "name == null");
      this.status = status;
      this.attributes = attributes;
    }

    public @Nonnull String __typename() {
      return this.__typename;
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
     *  The Global Trade Item Number (GTIN) for this Product
     */
    public @Nonnull String gtin() {
      return this.gtin;
    }

    /**
     *  The name of the Product
     */
    public @Nonnull String name() {
      return this.name;
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
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], ref);
          writer.writeString($responseFields[2], type);
          writer.writeString($responseFields[3], gtin);
          writer.writeString($responseFields[4], name);
          writer.writeString($responseFields[5], status);
          writer.writeList($responseFields[6], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "StandardProduct{"
          + "__typename=" + __typename + ", "
          + "ref=" + ref + ", "
          + "type=" + type + ", "
          + "gtin=" + gtin + ", "
          + "name=" + name + ", "
          + "status=" + status + ", "
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
      if (o instanceof StandardProduct) {
        StandardProduct that = (StandardProduct) o;
        return this.__typename.equals(that.__typename)
         && this.ref.equals(that.ref)
         && this.type.equals(that.type)
         && this.gtin.equals(that.gtin)
         && this.name.equals(that.name)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
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
        h ^= ref.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= gtin.hashCode();
        h *= 1000003;
        h ^= name.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
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
      builder.ref = ref;
      builder.type = type;
      builder.gtin = gtin;
      builder.name = name;
      builder.status = status;
      builder.attributes = attributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<StandardProduct> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      @Override
      public StandardProduct map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String ref = reader.readString($responseFields[1]);
        final String type = reader.readString($responseFields[2]);
        final String gtin = reader.readString($responseFields[3]);
        final String name = reader.readString($responseFields[4]);
        final String status = reader.readString($responseFields[5]);
        final List<Attribute> attributes = reader.readList($responseFields[6], new ResponseReader.ListReader<Attribute>() {
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
        return new StandardProduct(__typename, ref, type, gtin, name, status, attributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String ref;

      private @Nonnull String type;

      private @Nonnull String gtin;

      private @Nonnull String name;

      private @Nullable String status;

      private @Nullable List<Attribute> attributes;

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

      public Builder type(@Nonnull String type) {
        this.type = type;
        return this;
      }

      public Builder gtin(@Nonnull String gtin) {
        this.gtin = gtin;
        return this;
      }

      public Builder name(@Nonnull String name) {
        this.name = name;
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

      public StandardProduct build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(ref, "ref == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(gtin, "gtin == null");
        Utils.checkNotNull(name, "name == null");
        return new StandardProduct(__typename, ref, type, gtin, name, status, attributes);
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
}
