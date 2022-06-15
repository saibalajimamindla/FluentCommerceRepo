package com.fluentcommerce.commonv2.graphql.query.fulfilmentOption;

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
public final class GetFulfilmentPlanIdByRefQuery implements Query<GetFulfilmentPlanIdByRefQuery.Data, GetFulfilmentPlanIdByRefQuery.Data, GetFulfilmentPlanIdByRefQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetFulfilmentPlanIdByRef($ref: [String!]) {\n"
      + "  fulfilmentPlans(ref: $ref) {\n"
      + "    __typename\n"
      + "    fulfilmentPlanEdge: edges {\n"
      + "      __typename\n"
      + "      fulfilmentPlanNode: node {\n"
      + "        __typename\n"
      + "        id\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetFulfilmentPlanIdByRef";
    }
  };

  private final GetFulfilmentPlanIdByRefQuery.Variables variables;

  public GetFulfilmentPlanIdByRefQuery(@Nullable List<String> ref) {
    variables = new GetFulfilmentPlanIdByRefQuery.Variables(ref);
  }

  @Override
  public String operationId() {
    return "21d996dc383e1c3994b0e76e88805155d9aca45e33a77ff5eb44dfc5d226f1df";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetFulfilmentPlanIdByRefQuery.Data wrapData(GetFulfilmentPlanIdByRefQuery.Data data) {
    return data;
  }

  @Override
  public GetFulfilmentPlanIdByRefQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetFulfilmentPlanIdByRefQuery.Data> responseFieldMapper() {
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

    public GetFulfilmentPlanIdByRefQuery build() {
      return new GetFulfilmentPlanIdByRefQuery(ref);
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
      ResponseField.forObject("fulfilmentPlans", "fulfilmentPlans", new UnmodifiableMapBuilder<String, Object>(1)
        .put("ref", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "ref")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable FulfilmentPlans fulfilmentPlans;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable FulfilmentPlans fulfilmentPlans) {
      this.fulfilmentPlans = fulfilmentPlans;
    }

    /**
     *  Search for FulfilmentPlan entities
     */
    public @Nullable FulfilmentPlans fulfilmentPlans() {
      return this.fulfilmentPlans;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], fulfilmentPlans != null ? fulfilmentPlans.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "fulfilmentPlans=" + fulfilmentPlans
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
        return ((this.fulfilmentPlans == null) ? (that.fulfilmentPlans == null) : this.fulfilmentPlans.equals(that.fulfilmentPlans));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (fulfilmentPlans == null) ? 0 : fulfilmentPlans.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.fulfilmentPlans = fulfilmentPlans;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final FulfilmentPlans.Mapper fulfilmentPlansFieldMapper = new FulfilmentPlans.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final FulfilmentPlans fulfilmentPlans = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<FulfilmentPlans>() {
          @Override
          public FulfilmentPlans read(ResponseReader reader) {
            return fulfilmentPlansFieldMapper.map(reader);
          }
        });
        return new Data(fulfilmentPlans);
      }
    }

    public static final class Builder {
      private @Nullable FulfilmentPlans fulfilmentPlans;

      Builder() {
      }

      public Builder fulfilmentPlans(@Nullable FulfilmentPlans fulfilmentPlans) {
        this.fulfilmentPlans = fulfilmentPlans;
        return this;
      }

      public Builder fulfilmentPlans(@Nonnull Mutator<FulfilmentPlans.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentPlans.Builder builder = this.fulfilmentPlans != null ? this.fulfilmentPlans.toBuilder() : FulfilmentPlans.builder();
        mutator.accept(builder);
        this.fulfilmentPlans = builder.build();
        return this;
      }

      public Data build() {
        return new Data(fulfilmentPlans);
      }
    }
  }

  public static class FulfilmentPlans {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("fulfilmentPlanEdge", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<FulfilmentPlanEdge> fulfilmentPlanEdge;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentPlans(@Nonnull String __typename,
        @Nullable List<FulfilmentPlanEdge> fulfilmentPlanEdge) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilmentPlanEdge = fulfilmentPlanEdge;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to FulfilmentPlan type node
     */
    public @Nullable List<FulfilmentPlanEdge> fulfilmentPlanEdge() {
      return this.fulfilmentPlanEdge;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], fulfilmentPlanEdge, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((FulfilmentPlanEdge) value).marshaller());
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentPlans{"
          + "__typename=" + __typename + ", "
          + "fulfilmentPlanEdge=" + fulfilmentPlanEdge
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FulfilmentPlans) {
        FulfilmentPlans that = (FulfilmentPlans) o;
        return this.__typename.equals(that.__typename)
         && ((this.fulfilmentPlanEdge == null) ? (that.fulfilmentPlanEdge == null) : this.fulfilmentPlanEdge.equals(that.fulfilmentPlanEdge));
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
        h ^= (fulfilmentPlanEdge == null) ? 0 : fulfilmentPlanEdge.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.fulfilmentPlanEdge = fulfilmentPlanEdge;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentPlans> {
      final FulfilmentPlanEdge.Mapper fulfilmentPlanEdgeFieldMapper = new FulfilmentPlanEdge.Mapper();

      @Override
      public FulfilmentPlans map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<FulfilmentPlanEdge> fulfilmentPlanEdge = reader.readList($responseFields[1], new ResponseReader.ListReader<FulfilmentPlanEdge>() {
          @Override
          public FulfilmentPlanEdge read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<FulfilmentPlanEdge>() {
              @Override
              public FulfilmentPlanEdge read(ResponseReader reader) {
                return fulfilmentPlanEdgeFieldMapper.map(reader);
              }
            });
          }
        });
        return new FulfilmentPlans(__typename, fulfilmentPlanEdge);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable List<FulfilmentPlanEdge> fulfilmentPlanEdge;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilmentPlanEdge(@Nullable List<FulfilmentPlanEdge> fulfilmentPlanEdge) {
        this.fulfilmentPlanEdge = fulfilmentPlanEdge;
        return this;
      }

      public Builder fulfilmentPlanEdge(@Nonnull Mutator<List<FulfilmentPlanEdge.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<FulfilmentPlanEdge.Builder> builders = new ArrayList<>();
        if (this.fulfilmentPlanEdge != null) {
          for (FulfilmentPlanEdge item : this.fulfilmentPlanEdge) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<FulfilmentPlanEdge> fulfilmentPlanEdge = new ArrayList<>();
        for (FulfilmentPlanEdge.Builder item : builders) {
          fulfilmentPlanEdge.add(item != null ? item.build() : null);
        }
        this.fulfilmentPlanEdge = fulfilmentPlanEdge;
        return this;
      }

      public FulfilmentPlans build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FulfilmentPlans(__typename, fulfilmentPlanEdge);
      }
    }
  }

  public static class FulfilmentPlanEdge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("fulfilmentPlanNode", "node", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable FulfilmentPlanNode fulfilmentPlanNode;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentPlanEdge(@Nonnull String __typename,
        @Nullable FulfilmentPlanNode fulfilmentPlanNode) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fulfilmentPlanNode = fulfilmentPlanNode;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  The item at the end of the FulfilmentPlan edge
     */
    public @Nullable FulfilmentPlanNode fulfilmentPlanNode() {
      return this.fulfilmentPlanNode;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], fulfilmentPlanNode != null ? fulfilmentPlanNode.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FulfilmentPlanEdge{"
          + "__typename=" + __typename + ", "
          + "fulfilmentPlanNode=" + fulfilmentPlanNode
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FulfilmentPlanEdge) {
        FulfilmentPlanEdge that = (FulfilmentPlanEdge) o;
        return this.__typename.equals(that.__typename)
         && ((this.fulfilmentPlanNode == null) ? (that.fulfilmentPlanNode == null) : this.fulfilmentPlanNode.equals(that.fulfilmentPlanNode));
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
        h ^= (fulfilmentPlanNode == null) ? 0 : fulfilmentPlanNode.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.fulfilmentPlanNode = fulfilmentPlanNode;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<FulfilmentPlanEdge> {
      final FulfilmentPlanNode.Mapper fulfilmentPlanNodeFieldMapper = new FulfilmentPlanNode.Mapper();

      @Override
      public FulfilmentPlanEdge map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final FulfilmentPlanNode fulfilmentPlanNode = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<FulfilmentPlanNode>() {
          @Override
          public FulfilmentPlanNode read(ResponseReader reader) {
            return fulfilmentPlanNodeFieldMapper.map(reader);
          }
        });
        return new FulfilmentPlanEdge(__typename, fulfilmentPlanNode);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable FulfilmentPlanNode fulfilmentPlanNode;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder fulfilmentPlanNode(@Nullable FulfilmentPlanNode fulfilmentPlanNode) {
        this.fulfilmentPlanNode = fulfilmentPlanNode;
        return this;
      }

      public Builder fulfilmentPlanNode(@Nonnull Mutator<FulfilmentPlanNode.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        FulfilmentPlanNode.Builder builder = this.fulfilmentPlanNode != null ? this.fulfilmentPlanNode.toBuilder() : FulfilmentPlanNode.builder();
        mutator.accept(builder);
        this.fulfilmentPlanNode = builder.build();
        return this;
      }

      public FulfilmentPlanEdge build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new FulfilmentPlanEdge(__typename, fulfilmentPlanNode);
      }
    }
  }

  public static class FulfilmentPlanNode {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FulfilmentPlanNode(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "FulfilmentPlanNode{"
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
      if (o instanceof FulfilmentPlanNode) {
        FulfilmentPlanNode that = (FulfilmentPlanNode) o;
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

    public static final class Mapper implements ResponseFieldMapper<FulfilmentPlanNode> {
      @Override
      public FulfilmentPlanNode map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new FulfilmentPlanNode(__typename, id);
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

      public FulfilmentPlanNode build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new FulfilmentPlanNode(__typename, id);
      }
    }
  }
}
