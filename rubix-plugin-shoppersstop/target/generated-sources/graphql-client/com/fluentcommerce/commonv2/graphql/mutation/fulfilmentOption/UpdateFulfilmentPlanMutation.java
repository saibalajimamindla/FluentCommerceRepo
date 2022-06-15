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
import com.fluentcommerce.commonv2.graphql.type.UpdateFulfilmentPlanInput;
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
public final class UpdateFulfilmentPlanMutation implements Mutation<UpdateFulfilmentPlanMutation.Data, UpdateFulfilmentPlanMutation.Data, UpdateFulfilmentPlanMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdateFulfilmentPlan($input: UpdateFulfilmentPlanInput) {\n"
      + "  updateFulfilmentPlan(input: $input) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    status\n"
      + "    eta\n"
      + "    attributes {\n"
      + "      __typename\n"
      + "      type\n"
      + "      name\n"
      + "      value\n"
      + "    }\n"
      + "    exceptions {\n"
      + "      __typename\n"
      + "      code\n"
      + "      message\n"
      + "      attributes {\n"
      + "        __typename\n"
      + "        type\n"
      + "        name\n"
      + "        value\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "UpdateFulfilmentPlan";
    }
  };

  private final UpdateFulfilmentPlanMutation.Variables variables;

  public UpdateFulfilmentPlanMutation(@Nullable UpdateFulfilmentPlanInput input) {
    variables = new UpdateFulfilmentPlanMutation.Variables(input);
  }

  @Override
  public String operationId() {
    return "9b10776c9d6c5e35edf86b40c46d8029a045d8eaec693c89d771929a7a96881d";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public UpdateFulfilmentPlanMutation.Data wrapData(UpdateFulfilmentPlanMutation.Data data) {
    return data;
  }

  @Override
  public UpdateFulfilmentPlanMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<UpdateFulfilmentPlanMutation.Data> responseFieldMapper() {
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
    private @Nullable UpdateFulfilmentPlanInput input;

    Builder() {
    }

    public Builder input(@Nullable UpdateFulfilmentPlanInput input) {
      this.input = input;
      return this;
    }

    public UpdateFulfilmentPlanMutation build() {
      return new UpdateFulfilmentPlanMutation(input);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable UpdateFulfilmentPlanInput input;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable UpdateFulfilmentPlanInput input) {
      this.input = input;
      this.valueMap.put("input", input);
    }

    public @Nullable UpdateFulfilmentPlanInput input() {
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
      ResponseField.forObject("updateFulfilmentPlan", "updateFulfilmentPlan", new UnmodifiableMapBuilder<String, Object>(1)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdateFulfilmentPlan updateFulfilmentPlan;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdateFulfilmentPlan updateFulfilmentPlan) {
      this.updateFulfilmentPlan = updateFulfilmentPlan;
    }

    public @Nullable UpdateFulfilmentPlan updateFulfilmentPlan() {
      return this.updateFulfilmentPlan;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updateFulfilmentPlan != null ? updateFulfilmentPlan.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateFulfilmentPlan=" + updateFulfilmentPlan
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
        return ((this.updateFulfilmentPlan == null) ? (that.updateFulfilmentPlan == null) : this.updateFulfilmentPlan.equals(that.updateFulfilmentPlan));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updateFulfilmentPlan == null) ? 0 : updateFulfilmentPlan.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.updateFulfilmentPlan = updateFulfilmentPlan;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdateFulfilmentPlan.Mapper updateFulfilmentPlanFieldMapper = new UpdateFulfilmentPlan.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdateFulfilmentPlan updateFulfilmentPlan = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdateFulfilmentPlan>() {
          @Override
          public UpdateFulfilmentPlan read(ResponseReader reader) {
            return updateFulfilmentPlanFieldMapper.map(reader);
          }
        });
        return new Data(updateFulfilmentPlan);
      }
    }

    public static final class Builder {
      private @Nullable UpdateFulfilmentPlan updateFulfilmentPlan;

      Builder() {
      }

      public Builder updateFulfilmentPlan(@Nullable UpdateFulfilmentPlan updateFulfilmentPlan) {
        this.updateFulfilmentPlan = updateFulfilmentPlan;
        return this;
      }

      public Builder updateFulfilmentPlan(@Nonnull Mutator<UpdateFulfilmentPlan.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        UpdateFulfilmentPlan.Builder builder = this.updateFulfilmentPlan != null ? this.updateFulfilmentPlan.toBuilder() : UpdateFulfilmentPlan.builder();
        mutator.accept(builder);
        this.updateFulfilmentPlan = builder.build();
        return this;
      }

      public Data build() {
        return new Data(updateFulfilmentPlan);
      }
    }
  }

  public static class UpdateFulfilmentPlan {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("eta", "eta", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("exceptions", "exceptions", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nullable String ref;

    final @Nullable String status;

    final @Nullable String eta;

    final @Nullable List<Attribute> attributes;

    final @Nullable List<Exception> exceptions;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public UpdateFulfilmentPlan(@Nonnull String __typename, @Nonnull String id,
        @Nullable String ref, @Nullable String status, @Nullable String eta,
        @Nullable List<Attribute> attributes, @Nullable List<Exception> exceptions) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = ref;
      this.status = status;
      this.eta = eta;
      this.attributes = attributes;
      this.exceptions = exceptions;
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
     *  The current status of the `FulfilmentPlan`.<br/>By default, the initial value will be CREATED, however no other status values are enforced by the platform.<br/>The status field is also used within ruleset selection during orchestration. For more info, see <a href="https://lingo.fluentcommerce.com/ORCHESTRATION-PLATFORM/" target="_blank">Orchestration</a><br/>
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  ETA of the `FulfilmentPlan`. Although this can be set explicitly, we recommend that this be determined and set in the workflow.
     */
    public @Nullable String eta() {
      return this.eta;
    }

    /**
     *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    /**
     *  Exceptions can be used to augment the existing object with any useful information in case of exceptions.
     */
    public @Nullable List<Exception> exceptions() {
      return this.exceptions;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], eta);
          writer.writeList($responseFields[5], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeList($responseFields[6], exceptions, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Exception) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UpdateFulfilmentPlan{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "eta=" + eta + ", "
          + "attributes=" + attributes + ", "
          + "exceptions=" + exceptions
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateFulfilmentPlan) {
        UpdateFulfilmentPlan that = (UpdateFulfilmentPlan) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && ((this.ref == null) ? (that.ref == null) : this.ref.equals(that.ref))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.eta == null) ? (that.eta == null) : this.eta.equals(that.eta))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.exceptions == null) ? (that.exceptions == null) : this.exceptions.equals(that.exceptions));
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
        h ^= (eta == null) ? 0 : eta.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (exceptions == null) ? 0 : exceptions.hashCode();
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
      builder.eta = eta;
      builder.attributes = attributes;
      builder.exceptions = exceptions;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<UpdateFulfilmentPlan> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final Exception.Mapper exceptionFieldMapper = new Exception.Mapper();

      @Override
      public UpdateFulfilmentPlan map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String eta = reader.readString($responseFields[4]);
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
        final List<Exception> exceptions = reader.readList($responseFields[6], new ResponseReader.ListReader<Exception>() {
          @Override
          public Exception read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Exception>() {
              @Override
              public Exception read(ResponseReader reader) {
                return exceptionFieldMapper.map(reader);
              }
            });
          }
        });
        return new UpdateFulfilmentPlan(__typename, id, ref, status, eta, attributes, exceptions);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nullable String ref;

      private @Nullable String status;

      private @Nullable String eta;

      private @Nullable List<Attribute> attributes;

      private @Nullable List<Exception> exceptions;

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

      public Builder eta(@Nullable String eta) {
        this.eta = eta;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder exceptions(@Nullable List<Exception> exceptions) {
        this.exceptions = exceptions;
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

      public Builder exceptions(@Nonnull Mutator<List<Exception.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Exception.Builder> builders = new ArrayList<>();
        if (this.exceptions != null) {
          for (Exception item : this.exceptions) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Exception> exceptions = new ArrayList<>();
        for (Exception.Builder item : builders) {
          exceptions.add(item != null ? item.build() : null);
        }
        this.exceptions = exceptions;
        return this;
      }

      public UpdateFulfilmentPlan build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new UpdateFulfilmentPlan(__typename, id, ref, status, eta, attributes, exceptions);
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

  public static class Exception {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("code", "code", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("message", "message", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String code;

    final @Nullable String message;

    final @Nullable List<Attribute1> attributes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Exception(@Nonnull String __typename, @Nullable String code, @Nullable String message,
        @Nullable List<Attribute1> attributes) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.code = code;
      this.message = message;
      this.attributes = attributes;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The exception code
     */
    public @Nullable String code() {
      return this.code;
    }

    /**
     *  The english like description of the exception
     */
    public @Nullable String message() {
      return this.message;
    }

    /**
     *  Attributes may contain useful information about the exception
     */
    public @Nullable List<Attribute1> attributes() {
      return this.attributes;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], code);
          writer.writeString($responseFields[2], message);
          writer.writeList($responseFields[3], attributes, new ResponseWriter.ListWriter() {
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
        $toString = "Exception{"
          + "__typename=" + __typename + ", "
          + "code=" + code + ", "
          + "message=" + message + ", "
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
      if (o instanceof Exception) {
        Exception that = (Exception) o;
        return this.__typename.equals(that.__typename)
         && ((this.code == null) ? (that.code == null) : this.code.equals(that.code))
         && ((this.message == null) ? (that.message == null) : this.message.equals(that.message))
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
        h ^= (code == null) ? 0 : code.hashCode();
        h *= 1000003;
        h ^= (message == null) ? 0 : message.hashCode();
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
      builder.code = code;
      builder.message = message;
      builder.attributes = attributes;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Exception> {
      final Attribute1.Mapper attribute1FieldMapper = new Attribute1.Mapper();

      @Override
      public Exception map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String code = reader.readString($responseFields[1]);
        final String message = reader.readString($responseFields[2]);
        final List<Attribute1> attributes = reader.readList($responseFields[3], new ResponseReader.ListReader<Attribute1>() {
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
        return new Exception(__typename, code, message, attributes);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String code;

      private @Nullable String message;

      private @Nullable List<Attribute1> attributes;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder code(@Nullable String code) {
        this.code = code;
        return this;
      }

      public Builder message(@Nullable String message) {
        this.message = message;
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

      public Exception build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Exception(__typename, code, message, attributes);
      }
    }
  }

  public static class Attribute1 {
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

    public Attribute1(@Nonnull String __typename, @Nonnull String type, @Nonnull String name,
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
        $toString = "Attribute1{"
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
      if (o instanceof Attribute1) {
        Attribute1 that = (Attribute1) o;
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

    public static final class Mapper implements ResponseFieldMapper<Attribute1> {
      @Override
      public Attribute1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String type = reader.readString($responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final Object value = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new Attribute1(__typename, type, name, value);
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

      public Attribute1 build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(value, "value == null");
        return new Attribute1(__typename, type, name, value);
      }
    }
  }
}
