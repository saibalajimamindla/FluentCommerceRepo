package com.fluentcommerce.commonv2.graphql.mutation.fulfilmentOption;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.Mutator;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import com.fluentretail.graphql.type.CustomType;
import com.fluentcommerce.commonv2.graphql.type.UpdateFulfilmentOptionInput;
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
public final class UpdateFulfilmentOptionMutation implements Mutation<UpdateFulfilmentOptionMutation.Data, UpdateFulfilmentOptionMutation.Data, UpdateFulfilmentOptionMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdateFulfilmentOption($input: UpdateFulfilmentOptionInput) {\n"
      + "  updateFulfilmentOption(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    status\n"
      + "    trackingCode\n"
      + "    attributes {\n"
      + "      __typename\n"
      + "      type\n"
      + "      name\n"
      + "      value\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "UpdateFulfilmentOption";
    }
  };

  private final UpdateFulfilmentOptionMutation.Variables variables;

  public UpdateFulfilmentOptionMutation(@Nullable UpdateFulfilmentOptionInput input) {
    variables = new UpdateFulfilmentOptionMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "d9668b9dcbb9f7dd6adf4189bbf12d142006d80a634004bc05fff9509866c690";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public UpdateFulfilmentOptionMutation.Data wrapData(UpdateFulfilmentOptionMutation.Data data) {
    return data;
  }

  @Override
  public UpdateFulfilmentOptionMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<UpdateFulfilmentOptionMutation.Data> responseFieldMapper() {
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
    private @Nullable UpdateFulfilmentOptionInput input;

    Builder() {
    }

    public Builder input(@Nullable UpdateFulfilmentOptionInput input) {
      this.input = input;
      return this;
    }

    public UpdateFulfilmentOptionMutation build() {
      return new UpdateFulfilmentOptionMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable UpdateFulfilmentOptionInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable UpdateFulfilmentOptionInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable UpdateFulfilmentOptionInput input() {
      return input;
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
          writer.writeObject("input", input != null ? input.marshaller() : null);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("updateFulfilmentOption", "updateFulfilmentOption", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdateFulfilmentOption updateFulfilmentOption;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdateFulfilmentOption updateFulfilmentOption) {
      this.updateFulfilmentOption = updateFulfilmentOption;
    }

    public @Nullable UpdateFulfilmentOption updateFulfilmentOption() {
      return this.updateFulfilmentOption;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updateFulfilmentOption != null ? updateFulfilmentOption.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateFulfilmentOption=" + updateFulfilmentOption
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
        return ((this.updateFulfilmentOption == null) ? (that.updateFulfilmentOption == null) : this.updateFulfilmentOption.equals(that.updateFulfilmentOption));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updateFulfilmentOption == null) ? 0 : updateFulfilmentOption.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.updateFulfilmentOption = updateFulfilmentOption;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdateFulfilmentOption.Mapper updateFulfilmentOptionFieldMapper = new UpdateFulfilmentOption.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdateFulfilmentOption updateFulfilmentOption = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdateFulfilmentOption>() {
          @Override
          public UpdateFulfilmentOption read(ResponseReader reader) {
            return updateFulfilmentOptionFieldMapper.map(reader);
          }
        });
        return new Data(updateFulfilmentOption);
      }
    }

    public static final class Builder {
      private @Nullable UpdateFulfilmentOption updateFulfilmentOption;

      Builder() {
      }

      public Builder updateFulfilmentOption(@Nullable UpdateFulfilmentOption updateFulfilmentOption) {
        this.updateFulfilmentOption = updateFulfilmentOption;
        return this;
      }

      public Builder updateFulfilmentOption(@Nonnull Mutator<UpdateFulfilmentOption.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        UpdateFulfilmentOption.Builder builder = this.updateFulfilmentOption != null ? this.updateFulfilmentOption.toBuilder() : UpdateFulfilmentOption.builder();
        mutator.accept(builder);
        this.updateFulfilmentOption = builder.build();
        return this;
      }

      public Data build() {
        return new Data(updateFulfilmentOption);
      }
    }
  }

  public static class UpdateFulfilmentOption {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("trackingCode", "trackingCode", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable String trackingCode;

    final @Nullable List<Attribute> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public UpdateFulfilmentOption(@Nonnull String __typename, @Nonnull String id,
        @Nullable String ref, @Nullable String status, @Nullable String trackingCode,
        @Nullable List<Attribute> attributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.trackingCode = trackingCode;
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
     *  External reference. Recommended to be unique.
     */
    public @Nullable String ref() {
      return this.ref;
    }

    /**
     *  The current status of the `FulfilmentOption`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], trackingCode);
          writer.writeList($responseFields[5], attributes, new ResponseWriter.ListWriter() {
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
        $toString = "UpdateFulfilmentOption{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "trackingCode=" + trackingCode + ", "
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
      if (o instanceof UpdateFulfilmentOption) {
        UpdateFulfilmentOption that = (UpdateFulfilmentOption) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.trackingCode == null) ? (that.trackingCode == null) : this.trackingCode.equals(that.trackingCode))
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
        h ^= (trackingCode == null) ? 0 : trackingCode.hashCode();
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
      builder.trackingCode = trackingCode;
      builder.attributes = attributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<UpdateFulfilmentOption> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      @Override
      public UpdateFulfilmentOption map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String trackingCode = reader.readString($responseFields[4]);
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
        return new UpdateFulfilmentOption(__typename, id, ref, status, trackingCode, attributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable String trackingCode;

      private @Nullable List<Attribute> attributes;

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

      public Builder trackingCode(@Nullable String trackingCode) {
        this.trackingCode = trackingCode;
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

      public UpdateFulfilmentOption build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new UpdateFulfilmentOption(__typename, id, ref, status, trackingCode, attributes);
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
}
