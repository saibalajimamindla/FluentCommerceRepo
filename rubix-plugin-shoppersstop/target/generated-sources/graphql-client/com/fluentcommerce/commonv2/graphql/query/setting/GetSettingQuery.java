package com.fluentcommerce.commonv2.graphql.query.setting;

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
public final class GetSettingQuery implements Query<GetSettingQuery.Data, GetSettingQuery.Data, GetSettingQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetSetting($name: [String], $context: [String!], $contextId: [Int!]) {\n"
      + "  settings(name: $name, context: $context, contextId: $contextId) {\n"
      + "    __typename\n"
      + "    settingEdge: edges {\n"
      + "      __typename\n"
      + "      settingNode: node {\n"
      + "        __typename\n"
      + "        id\n"
      + "        name\n"
      + "        value\n"
      + "        valueType\n"
      + "        lobValue\n"
      + "        context\n"
      + "        contextId\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetSetting";
    }
  };

  private final GetSettingQuery.Variables variables;

  public GetSettingQuery(@Nullable List<String> name, @Nullable List<String> context,
      @Nullable List<Integer> contextId) {
    variables = new GetSettingQuery.Variables(name, context, contextId);
  }

  @Override
  public String operationId() {
    return "be94cca0010c92fea8023af5a849cbd8faf2de91ec4d1728a0099ac19171e448";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetSettingQuery.Data wrapData(GetSettingQuery.Data data) {
    return data;
  }

  @Override
  public GetSettingQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetSettingQuery.Data> responseFieldMapper() {
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
    private @Nullable List<String> name;

    private @Nullable List<String> context;

    private @Nullable List<Integer> contextId;

    Builder() {
    }

    public Builder name(@Nullable List<String> name) {
      this.name = name;
      return this;
    }

    public Builder context(@Nullable List<String> context) {
      this.context = context;
      return this;
    }

    public Builder contextId(@Nullable List<Integer> contextId) {
      this.contextId = contextId;
      return this;
    }

    public GetSettingQuery build() {
      return new GetSettingQuery(name, context, contextId);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable List<String> name;

    private final @Nullable List<String> context;

    private final @Nullable List<Integer> contextId;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable List<String> name, @Nullable List<String> context,
        @Nullable List<Integer> contextId) {
      this.name = name;
      this.context = context;
      this.contextId = contextId;
      this.valueMap.put("name", name);
      this.valueMap.put("context", context);
      this.valueMap.put("contextId", contextId);
    }

    public @Nullable List<String> name() {
      return name;
    }

    public @Nullable List<String> context() {
      return context;
    }

    public @Nullable List<Integer> contextId() {
      return contextId;
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
          writer.writeList("name", name != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : name) {
                listItemWriter.writeString($item);
              }
            }
          } : null);
          writer.writeList("context", context != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : context) {
                listItemWriter.writeString($item);
              }
            }
          } : null);
          writer.writeList("contextId", contextId != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (Integer $item : contextId) {
                listItemWriter.writeInt($item);
              }
            }
          } : null);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("settings", "settings", new UnmodifiableMapBuilder<String, Object>(3)
        .put("name", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "name")
        .build())
        .put("context", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "context")
        .build())
        .put("contextId", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "contextId")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable Settings settings;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Settings settings) {
      this.settings = settings;
    }

    /**
     *  Search for Setting entities
     */
    public @Nullable Settings settings() {
      return this.settings;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], settings != null ? settings.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "settings=" + settings
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
        return ((this.settings == null) ? (that.settings == null) : this.settings.equals(that.settings));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (settings == null) ? 0 : settings.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.settings = settings;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Settings.Mapper settingsFieldMapper = new Settings.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Settings settings = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Settings>() {
          @Override
          public Settings read(ResponseReader reader) {
            return settingsFieldMapper.map(reader);
          }
        });
        return new Data(settings);
      }
    }

    public static final class Builder {
      private @Nullable Settings settings;

      Builder() {
      }

      public Builder settings(@Nullable Settings settings) {
        this.settings = settings;
        return this;
      }

      public Builder settings(@Nonnull Mutator<Settings.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Settings.Builder builder = this.settings != null ? this.settings.toBuilder() : Settings.builder();
        mutator.accept(builder);
        this.settings = builder.build();
        return this;
      }

      public Data build() {
        return new Data(settings);
      }
    }
  }

  public static class Settings {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("settingEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<SettingEdge> settingEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Settings(@Nonnull String __typename, @Nullable List<SettingEdge> settingEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.settingEdge = settingEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to Setting type node
     */
    public @Nullable List<SettingEdge> settingEdge() {
      return this.settingEdge;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], settingEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((SettingEdge) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Settings{"
          + "__typename=" + __typename + ", "
          + "settingEdge=" + settingEdge
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Settings) {
        Settings that = (Settings) o;
        return this.__typename.equals(that.__typename)
         && ((this.settingEdge == null) ? (that.settingEdge == null) : this.settingEdge.equals(that.settingEdge));
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
        h ^= (settingEdge == null) ? 0 : settingEdge.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.settingEdge = settingEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Settings> {
      final SettingEdge.Mapper settingEdgeFieldMapper = new SettingEdge.Mapper();

      @Override
      public Settings map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<SettingEdge> settingEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<SettingEdge>() {
          @Override
          public SettingEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<SettingEdge>() {
              @Override
              public SettingEdge read(ResponseReader reader) {
                return settingEdgeFieldMapper.map(reader);
              }
            });
          }
        });
        return new Settings(__typename, settingEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<SettingEdge> settingEdge;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder settingEdge(@Nullable List<SettingEdge> settingEdge) {
        this.settingEdge = settingEdge;
        return this;
      }

      public Builder settingEdge(@Nonnull Mutator<List<SettingEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<SettingEdge.Builder> builders = new ArrayList<>();
        if (this.settingEdge != null) {
          for (SettingEdge item : this.settingEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<SettingEdge> settingEdge = new ArrayList<>();
        for (SettingEdge.Builder item : builders) {
          settingEdge.add(item != null ? item.build() : null);
        }
        this.settingEdge = settingEdge;
        return this;
      }

      public Settings build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Settings(__typename, settingEdge);
      }
    }
  }

  public static class SettingEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("settingNode", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable SettingNode settingNode;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public SettingEdge(@Nonnull String __typename, @Nullable SettingNode settingNode) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.settingNode = settingNode;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the Setting edge
     */
    public @Nullable SettingNode settingNode() {
      return this.settingNode;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], settingNode != null ? settingNode.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "SettingEdge{"
          + "__typename=" + __typename + ", "
          + "settingNode=" + settingNode
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof SettingEdge) {
        SettingEdge that = (SettingEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.settingNode == null) ? (that.settingNode == null) : this.settingNode.equals(that.settingNode));
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
        h ^= (settingNode == null) ? 0 : settingNode.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.settingNode = settingNode;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<SettingEdge> {
      final SettingNode.Mapper settingNodeFieldMapper = new SettingNode.Mapper();

      @Override
      public SettingEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final SettingNode settingNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<SettingNode>() {
          @Override
          public SettingNode read(ResponseReader reader) {
            return settingNodeFieldMapper.map(reader);
          }
        });
        return new SettingEdge(__typename, settingNode);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable SettingNode settingNode;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder settingNode(@Nullable SettingNode settingNode) {
        this.settingNode = settingNode;
        return this;
      }

      public Builder settingNode(@Nonnull Mutator<SettingNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        SettingNode.Builder builder = this.settingNode != null ? this.settingNode.toBuilder() : SettingNode.builder();
        mutator.accept(builder);
        this.settingNode = builder.build();
        return this;
      }

      public SettingEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new SettingEdge(__typename, settingNode);
      }
    }
  }

  public static class SettingNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("value", "value", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("valueType", "valueType", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("lobValue", "lobValue", null, true, CustomType.JSON, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("context", "context", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("contextId", "contextId", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String name;

    final @Nullable String value;

    final @Nullable String valueType;

    final @Nullable Object lobValue;

    final @Nonnull String context;

    final int contextId;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public SettingNode(@Nonnull String __typename, @Nonnull String id, @Nullable String name,
        @Nullable String value, @Nullable String valueType, @Nullable Object lobValue,
        @Nonnull String context, int contextId) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.name = name;
      this.value = value;
      this.valueType = valueType;
      this.lobValue = lobValue;
      this.context = Utils.checkNotNull(context, "context == null");
      this.contextId = contextId;
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
     *  Name of the setting.
     */
    public @Nullable String name() {
      return this.name;
    }

    /**
     *  Value of the setting. Use this if the value is NOT a JSON.
     */
    public @Nullable String value() {
      return this.value;
    }

    /**
     *  Data type of the setting's value. Supported types are _LOB_, _STRING_, _INTEGER_, _BOOLEAN_ and _JSON_.
     */
    public @Nullable String valueType() {
      return this.valueType;
    }

    /**
     *  Value of the setting. Use this if the value is a JSON.
     */
    public @Nullable Object lobValue() {
      return this.lobValue;
    }

    /**
     *  The context of the setting. Supported values are ACCOUNT, RETAILER, AGENT or CUSTOMER
     */
    public @Nonnull String context() {
      return this.context;
    }

    /**
     *  `ID` of the context. For instance, use a retailer's ID when using _RETAILER_ context.
     */
    public int contextId() {
      return this.contextId;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], name);
          writer.writeString($responseFields[3], value);
          writer.writeString($responseFields[4], valueType);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[5], lobValue);
          writer.writeString($responseFields[6], context);
          writer.writeInt($responseFields[7], contextId);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "SettingNode{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "name=" + name + ", "
          + "value=" + value + ", "
          + "valueType=" + valueType + ", "
          + "lobValue=" + lobValue + ", "
          + "context=" + context + ", "
          + "contextId=" + contextId
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof SettingNode) {
        SettingNode that = (SettingNode) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.value == null) ? (that.value == null) : this.value.equals(that.value))
         && ((this.valueType == null) ? (that.valueType == null) : this.valueType.equals(that.valueType))
         && ((this.lobValue == null) ? (that.lobValue == null) : this.lobValue.equals(that.lobValue))
         && this.context.equals(that.context)
         && this.contextId == that.contextId;
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
        h ^= (value == null) ? 0 : value.hashCode();
        h *= 1000003;
        h ^= (valueType == null) ? 0 : valueType.hashCode();
        h *= 1000003;
        h ^= (lobValue == null) ? 0 : lobValue.hashCode();
        h *= 1000003;
        h ^= context.hashCode();
        h *= 1000003;
        h ^= contextId;
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
      builder.value = value;
      builder.valueType = valueType;
      builder.lobValue = lobValue;
      builder.context = context;
      builder.contextId = contextId;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<SettingNode> {
      @Override
      public SettingNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String value = reader.readString($responseFields[3]);
        final String valueType = reader.readString($responseFields[4]);
        final Object lobValue = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[5]);
        final String context = reader.readString($responseFields[6]);
        final int contextId = reader.readInt($responseFields[7]);
        return new SettingNode(__typename, id, name, value, valueType, lobValue, context, contextId);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String name;

      private @Nullable String value;

      private @Nullable String valueType;

      private @Nullable Object lobValue;

      private @Nonnull String context;

      private int contextId;

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

      public Builder value(@Nullable String value) {
        this.value = value;
        return this;
      }

      public Builder valueType(@Nullable String valueType) {
        this.valueType = valueType;
        return this;
      }

      public Builder lobValue(@Nullable Object lobValue) {
        this.lobValue = lobValue;
        return this;
      }

      public Builder context(@Nonnull String context) {
        this.context = context;
        return this;
      }

      public Builder contextId(int contextId) {
        this.contextId = contextId;
        return this;
      }

      public SettingNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(context, "context == null");
        return new SettingNode(__typename, id, name, value, valueType, lobValue, context, contextId);
      }
    }
  }
}
