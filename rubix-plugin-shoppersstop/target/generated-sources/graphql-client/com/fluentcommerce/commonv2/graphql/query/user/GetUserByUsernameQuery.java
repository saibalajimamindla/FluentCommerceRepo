package com.fluentcommerce.commonv2.graphql.query.user;

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
public final class GetUserByUsernameQuery implements Query<GetUserByUsernameQuery.Data, GetUserByUsernameQuery.Data, GetUserByUsernameQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetUserByUsername($username: [String!]) {\n"
      + "  users(username: $username) {\n"
      + "    __typename\n"
      + "    edges {\n"
      + "      __typename\n"
      + "      node {\n"
      + "        __typename\n"
      + "        id\n"
      + "        username\n"
      + "        status\n"
      + "        type\n"
      + "        title\n"
      + "        firstName\n"
      + "        lastName\n"
      + "        primaryEmail\n"
      + "        primaryPhone\n"
      + "        attributes {\n"
      + "          __typename\n"
      + "          name\n"
      + "          value\n"
      + "          type\n"
      + "        }\n"
      + "        department\n"
      + "        country\n"
      + "        timezone\n"
      + "        language {\n"
      + "          __typename\n"
      + "          value\n"
      + "          label\n"
      + "        }\n"
      + "        promotionOptIn\n"
      + "        primaryRetailer {\n"
      + "          __typename\n"
      + "          id\n"
      + "        }\n"
      + "        primaryLocation {\n"
      + "          __typename\n"
      + "          id\n"
      + "          ref\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetUserByUsername";
    }
  };

  private final GetUserByUsernameQuery.Variables variables;

  public GetUserByUsernameQuery(@Nullable List<String> username) {
    variables = new GetUserByUsernameQuery.Variables(username);
  }

  @Override
  public String operationId() {
    return "a80627ca16362f86fc175a897b8a8fdf2db32732b5442ebbda5b6934d78d5812";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetUserByUsernameQuery.Data wrapData(GetUserByUsernameQuery.Data data) {
    return data;
  }

  @Override
  public GetUserByUsernameQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetUserByUsernameQuery.Data> responseFieldMapper() {
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
    private @Nullable List<String> username;

    Builder() {
    }

    public Builder username(@Nullable List<String> username) {
      this.username = username;
      return this;
    }

    public GetUserByUsernameQuery build() {
      return new GetUserByUsernameQuery(username);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable List<String> username;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable List<String> username) {
      this.username = username;
      this.valueMap.put("username", username);
    }

    public @Nullable List<String> username() {
      return username;
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
          writer.writeList("username", username != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (String $item : username) {
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
      ResponseField.forObject("users", "users", new UnmodifiableMapBuilder<String, Object>(1)
        .put("username", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "username")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable Users users;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Users users) {
      this.users = users;
    }

    /**
     *  Search for User entities
     */
    public @Nullable Users users() {
      return this.users;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], users != null ? users.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "users=" + users
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
        return ((this.users == null) ? (that.users == null) : this.users.equals(that.users));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (users == null) ? 0 : users.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.users = users;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Users.Mapper usersFieldMapper = new Users.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Users users = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Users>() {
          @Override
          public Users read(ResponseReader reader) {
            return usersFieldMapper.map(reader);
          }
        });
        return new Data(users);
      }
    }

    public static final class Builder {
      private @Nullable Users users;

      Builder() {
      }

      public Builder users(@Nullable Users users) {
        this.users = users;
        return this;
      }

      public Builder users(@Nonnull Mutator<Users.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Users.Builder builder = this.users != null ? this.users.toBuilder() : Users.builder();
        mutator.accept(builder);
        this.users = builder.build();
        return this;
      }

      public Data build() {
        return new Data(users);
      }
    }
  }

  public static class Users {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("edges", "edges", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Edge> edges;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Users(@Nonnull String __typename, @Nullable List<Edge> edges) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.edges = edges;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     *  A list of edges that links to User type node
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
        $toString = "Users{"
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
      if (o instanceof Users) {
        Users that = (Users) o;
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

    public static final class Mapper implements ResponseFieldMapper<Users> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      @Override
      public Users map(ResponseReader reader) {
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
        return new Users(__typename, edges);
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

      public Users build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Users(__typename, edges);
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
     *  The item at the end of the User edge
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
      ResponseField.forString("username", "username", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("title", "title", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("firstName", "firstName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("lastName", "lastName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("primaryEmail", "primaryEmail", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("primaryPhone", "primaryPhone", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("attributes", "attributes", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("department", "department", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("country", "country", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("timezone", "timezone", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("language", "language", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("promotionOptIn", "promotionOptIn", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("primaryRetailer", "primaryRetailer", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("primaryLocation", "primaryLocation", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String username;

    final @Nullable String status;

    final @Nonnull String type;

    final @Nullable String title;

    final @Nullable String firstName;

    final @Nullable String lastName;

    final @Nullable String primaryEmail;

    final @Nullable String primaryPhone;

    final @Nullable List<Attribute> attributes;

    final @Nullable String department;

    final @Nullable String country;

    final @Nullable String timezone;

    final @Nullable Language language;

    final @Nullable Boolean promotionOptIn;

    final @Nullable PrimaryRetailer primaryRetailer;

    final @Nullable PrimaryLocation primaryLocation;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Node(@Nonnull String __typename, @Nonnull String id, @Nonnull String username,
        @Nullable String status, @Nonnull String type, @Nullable String title,
        @Nullable String firstName, @Nullable String lastName, @Nullable String primaryEmail,
        @Nullable String primaryPhone, @Nullable List<Attribute> attributes,
        @Nullable String department, @Nullable String country, @Nullable String timezone,
        @Nullable Language language, @Nullable Boolean promotionOptIn,
        @Nullable PrimaryRetailer primaryRetailer, @Nullable PrimaryLocation primaryLocation) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.username = Utils.checkNotNull(username, "username == null");
      this.status = status;
      this.type = Utils.checkNotNull(type, "type == null");
      this.title = title;
      this.firstName = firstName;
      this.lastName = lastName;
      this.primaryEmail = primaryEmail;
      this.primaryPhone = primaryPhone;
      this.attributes = attributes;
      this.department = department;
      this.country = country;
      this.timezone = timezone;
      this.language = language;
      this.promotionOptIn = promotionOptIn;
      this.primaryRetailer = primaryRetailer;
      this.primaryLocation = primaryLocation;
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
     *  Unique name for the user used for identification and logging purposes.
     */
    public @Nonnull String username() {
      return this.username;
    }

    /**
     *  Status
     */
    public @Nullable String status() {
      return this.status;
    }

    /**
     *  Type of the user
     */
    public @Nonnull String type() {
      return this.type;
    }

    /**
     *  The user's title. For example _Mr._, _Miss_, _Dr._, _Ms._ etc
     */
    public @Nullable String title() {
      return this.title;
    }

    /**
     *  User's first name
     */
    public @Nullable String firstName() {
      return this.firstName;
    }

    /**
     *  User's last name
     */
    public @Nullable String lastName() {
      return this.lastName;
    }

    /**
     *  User's primary email
     */
    public @Nullable String primaryEmail() {
      return this.primaryEmail;
    }

    /**
     *  User's primary phone number
     */
    public @Nullable String primaryPhone() {
      return this.primaryPhone;
    }

    /**
     *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public @Nullable List<Attribute> attributes() {
      return this.attributes;
    }

    /**
     *  Department
     */
    public @Nullable String department() {
      return this.department;
    }

    /**
     *  Country
     */
    public @Nullable String country() {
      return this.country;
    }

    /**
     *  Timezone
     */
    public @Nullable String timezone() {
      return this.timezone;
    }

    /**
     *  User language (leave null to allow users to self-select their language preference)
     */
    public @Nullable Language language() {
      return this.language;
    }

    /**
     *  Determines if the user has opted to receive promotions
     */
    public @Nullable Boolean promotionOptIn() {
      return this.promotionOptIn;
    }

    /**
     *  User's retailer context
     */
    public @Nullable PrimaryRetailer primaryRetailer() {
      return this.primaryRetailer;
    }

    /**
     *  User's location context
     */
    public @Nullable PrimaryLocation primaryLocation() {
      return this.primaryLocation;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], username);
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], type);
          writer.writeString($responseFields[5], title);
          writer.writeString($responseFields[6], firstName);
          writer.writeString($responseFields[7], lastName);
          writer.writeString($responseFields[8], primaryEmail);
          writer.writeString($responseFields[9], primaryPhone);
          writer.writeList($responseFields[10], attributes, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Attribute) value).marshaller());
            }
          });
          writer.writeString($responseFields[11], department);
          writer.writeString($responseFields[12], country);
          writer.writeString($responseFields[13], timezone);
          writer.writeObject($responseFields[14], language != null ? language.marshaller() : null);
          writer.writeBoolean($responseFields[15], promotionOptIn);
          writer.writeObject($responseFields[16], primaryRetailer != null ? primaryRetailer.marshaller() : null);
          writer.writeObject($responseFields[17], primaryLocation != null ? primaryLocation.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Node{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "username=" + username + ", "
          + "status=" + status + ", "
          + "type=" + type + ", "
          + "title=" + title + ", "
          + "firstName=" + firstName + ", "
          + "lastName=" + lastName + ", "
          + "primaryEmail=" + primaryEmail + ", "
          + "primaryPhone=" + primaryPhone + ", "
          + "attributes=" + attributes + ", "
          + "department=" + department + ", "
          + "country=" + country + ", "
          + "timezone=" + timezone + ", "
          + "language=" + language + ", "
          + "promotionOptIn=" + promotionOptIn + ", "
          + "primaryRetailer=" + primaryRetailer + ", "
          + "primaryLocation=" + primaryLocation
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
         && this.username.equals(that.username)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.type.equals(that.type)
         && ((this.title == null) ? (that.title == null) : this.title.equals(that.title))
         && ((this.firstName == null) ? (that.firstName == null) : this.firstName.equals(that.firstName))
         && ((this.lastName == null) ? (that.lastName == null) : this.lastName.equals(that.lastName))
         && ((this.primaryEmail == null) ? (that.primaryEmail == null) : this.primaryEmail.equals(that.primaryEmail))
         && ((this.primaryPhone == null) ? (that.primaryPhone == null) : this.primaryPhone.equals(that.primaryPhone))
         && ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         && ((this.department == null) ? (that.department == null) : this.department.equals(that.department))
         && ((this.country == null) ? (that.country == null) : this.country.equals(that.country))
         && ((this.timezone == null) ? (that.timezone == null) : this.timezone.equals(that.timezone))
         && ((this.language == null) ? (that.language == null) : this.language.equals(that.language))
         && ((this.promotionOptIn == null) ? (that.promotionOptIn == null) : this.promotionOptIn.equals(that.promotionOptIn))
         && ((this.primaryRetailer == null) ? (that.primaryRetailer == null) : this.primaryRetailer.equals(that.primaryRetailer))
         && ((this.primaryLocation == null) ? (that.primaryLocation == null) : this.primaryLocation.equals(that.primaryLocation));
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
        h ^= username.hashCode();
        h *= 1000003;
        h ^= (status == null) ? 0 : status.hashCode();
        h *= 1000003;
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (title == null) ? 0 : title.hashCode();
        h *= 1000003;
        h ^= (firstName == null) ? 0 : firstName.hashCode();
        h *= 1000003;
        h ^= (lastName == null) ? 0 : lastName.hashCode();
        h *= 1000003;
        h ^= (primaryEmail == null) ? 0 : primaryEmail.hashCode();
        h *= 1000003;
        h ^= (primaryPhone == null) ? 0 : primaryPhone.hashCode();
        h *= 1000003;
        h ^= (attributes == null) ? 0 : attributes.hashCode();
        h *= 1000003;
        h ^= (department == null) ? 0 : department.hashCode();
        h *= 1000003;
        h ^= (country == null) ? 0 : country.hashCode();
        h *= 1000003;
        h ^= (timezone == null) ? 0 : timezone.hashCode();
        h *= 1000003;
        h ^= (language == null) ? 0 : language.hashCode();
        h *= 1000003;
        h ^= (promotionOptIn == null) ? 0 : promotionOptIn.hashCode();
        h *= 1000003;
        h ^= (primaryRetailer == null) ? 0 : primaryRetailer.hashCode();
        h *= 1000003;
        h ^= (primaryLocation == null) ? 0 : primaryLocation.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.id = id;
      builder.username = username;
      builder.status = status;
      builder.type = type;
      builder.title = title;
      builder.firstName = firstName;
      builder.lastName = lastName;
      builder.primaryEmail = primaryEmail;
      builder.primaryPhone = primaryPhone;
      builder.attributes = attributes;
      builder.department = department;
      builder.country = country;
      builder.timezone = timezone;
      builder.language = language;
      builder.promotionOptIn = promotionOptIn;
      builder.primaryRetailer = primaryRetailer;
      builder.primaryLocation = primaryLocation;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Node> {
      final Attribute.Mapper attributeFieldMapper = new Attribute.Mapper();

      final Language.Mapper languageFieldMapper = new Language.Mapper();

      final PrimaryRetailer.Mapper primaryRetailerFieldMapper = new PrimaryRetailer.Mapper();

      final PrimaryLocation.Mapper primaryLocationFieldMapper = new PrimaryLocation.Mapper();

      @Override
      public Node map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String username = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String type = reader.readString($responseFields[4]);
        final String title = reader.readString($responseFields[5]);
        final String firstName = reader.readString($responseFields[6]);
        final String lastName = reader.readString($responseFields[7]);
        final String primaryEmail = reader.readString($responseFields[8]);
        final String primaryPhone = reader.readString($responseFields[9]);
        final List<Attribute> attributes = reader.readList($responseFields[10], new ResponseReader.ListReader<Attribute>() {
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
        final String department = reader.readString($responseFields[11]);
        final String country = reader.readString($responseFields[12]);
        final String timezone = reader.readString($responseFields[13]);
        final Language language = reader.readObject($responseFields[14], new ResponseReader.ObjectReader<Language>() {
          @Override
          public Language read(ResponseReader reader) {
            return languageFieldMapper.map(reader);
          }
        });
        final Boolean promotionOptIn = reader.readBoolean($responseFields[15]);
        final PrimaryRetailer primaryRetailer = reader.readObject($responseFields[16], new ResponseReader.ObjectReader<PrimaryRetailer>() {
          @Override
          public PrimaryRetailer read(ResponseReader reader) {
            return primaryRetailerFieldMapper.map(reader);
          }
        });
        final PrimaryLocation primaryLocation = reader.readObject($responseFields[17], new ResponseReader.ObjectReader<PrimaryLocation>() {
          @Override
          public PrimaryLocation read(ResponseReader reader) {
            return primaryLocationFieldMapper.map(reader);
          }
        });
        return new Node(__typename, id, username, status, type, title, firstName, lastName, primaryEmail, primaryPhone, attributes, department, country, timezone, language, promotionOptIn, primaryRetailer, primaryLocation);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String username;

      private @Nullable String status;

      private @Nonnull String type;

      private @Nullable String title;

      private @Nullable String firstName;

      private @Nullable String lastName;

      private @Nullable String primaryEmail;

      private @Nullable String primaryPhone;

      private @Nullable List<Attribute> attributes;

      private @Nullable String department;

      private @Nullable String country;

      private @Nullable String timezone;

      private @Nullable Language language;

      private @Nullable Boolean promotionOptIn;

      private @Nullable PrimaryRetailer primaryRetailer;

      private @Nullable PrimaryLocation primaryLocation;

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

      public Builder username(@Nonnull String username) {
        this.username = username;
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

      public Builder title(@Nullable String title) {
        this.title = title;
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

      public Builder primaryEmail(@Nullable String primaryEmail) {
        this.primaryEmail = primaryEmail;
        return this;
      }

      public Builder primaryPhone(@Nullable String primaryPhone) {
        this.primaryPhone = primaryPhone;
        return this;
      }

      public Builder attributes(@Nullable List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
      }

      public Builder department(@Nullable String department) {
        this.department = department;
        return this;
      }

      public Builder country(@Nullable String country) {
        this.country = country;
        return this;
      }

      public Builder timezone(@Nullable String timezone) {
        this.timezone = timezone;
        return this;
      }

      public Builder language(@Nullable Language language) {
        this.language = language;
        return this;
      }

      public Builder promotionOptIn(@Nullable Boolean promotionOptIn) {
        this.promotionOptIn = promotionOptIn;
        return this;
      }

      public Builder primaryRetailer(@Nullable PrimaryRetailer primaryRetailer) {
        this.primaryRetailer = primaryRetailer;
        return this;
      }

      public Builder primaryLocation(@Nullable PrimaryLocation primaryLocation) {
        this.primaryLocation = primaryLocation;
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

      public Builder language(@Nonnull Mutator<Language.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        Language.Builder builder = this.language != null ? this.language.toBuilder() : Language.builder();
        mutator.accept(builder);
        this.language = builder.build();
        return this;
      }

      public Builder primaryRetailer(@Nonnull Mutator<PrimaryRetailer.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PrimaryRetailer.Builder builder = this.primaryRetailer != null ? this.primaryRetailer.toBuilder() : PrimaryRetailer.builder();
        mutator.accept(builder);
        this.primaryRetailer = builder.build();
        return this;
      }

      public Builder primaryLocation(@Nonnull Mutator<PrimaryLocation.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        PrimaryLocation.Builder builder = this.primaryLocation != null ? this.primaryLocation.toBuilder() : PrimaryLocation.builder();
        mutator.accept(builder);
        this.primaryLocation = builder.build();
        return this;
      }

      public Node build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(username, "username == null");
        Utils.checkNotNull(type, "type == null");
        return new Node(__typename, id, username, status, type, title, firstName, lastName, primaryEmail, primaryPhone, attributes, department, country, timezone, language, promotionOptIn, primaryRetailer, primaryLocation);
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

  public static class Language {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("value", "value", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("label", "label", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable String value;

    final @Nullable String label;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Language(@Nonnull String __typename, @Nullable String value, @Nullable String label) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.value = value;
      this.label = label;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String value() {
      return this.value;
    }

    public @Nullable String label() {
      return this.label;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], value);
          writer.writeString($responseFields[2], label);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Language{"
          + "__typename=" + __typename + ", "
          + "value=" + value + ", "
          + "label=" + label
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Language) {
        Language that = (Language) o;
        return this.__typename.equals(that.__typename)
         && ((this.value == null) ? (that.value == null) : this.value.equals(that.value))
         && ((this.label == null) ? (that.label == null) : this.label.equals(that.label));
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
        h ^= (value == null) ? 0 : value.hashCode();
        h *= 1000003;
        h ^= (label == null) ? 0 : label.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.value = value;
      builder.label = label;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Language> {
      @Override
      public Language map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String value = reader.readString($responseFields[1]);
        final String label = reader.readString($responseFields[2]);
        return new Language(__typename, value, label);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nullable String value;

      private @Nullable String label;

      Builder() {
      }

      public Builder __typename(@Nonnull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder value(@Nullable String value) {
        this.value = value;
        return this;
      }

      public Builder label(@Nullable String label) {
        this.label = label;
        return this;
      }

      public Language build() {
        Utils.checkNotNull(__typename, "__typename == null");
        return new Language(__typename, value, label);
      }
    }
  }

  public static class PrimaryRetailer {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PrimaryRetailer(@Nonnull String __typename, @Nonnull String id) {
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
        $toString = "PrimaryRetailer{"
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
      if (o instanceof PrimaryRetailer) {
        PrimaryRetailer that = (PrimaryRetailer) o;
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

    public static final class Mapper implements ResponseFieldMapper<PrimaryRetailer> {
      @Override
      public PrimaryRetailer map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        return new PrimaryRetailer(__typename, id);
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

      public PrimaryRetailer build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new PrimaryRetailer(__typename, id);
      }
    }
  }

  public static class PrimaryLocation {
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

    public PrimaryLocation(@Nonnull String __typename, @Nonnull String id, @Nullable String ref) {
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
     *  The location (i.e. store) id provided by the retailer
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
        $toString = "PrimaryLocation{"
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
      if (o instanceof PrimaryLocation) {
        PrimaryLocation that = (PrimaryLocation) o;
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

    public static final class Mapper implements ResponseFieldMapper<PrimaryLocation> {
      @Override
      public PrimaryLocation map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        return new PrimaryLocation(__typename, id, ref);
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

      public PrimaryLocation build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        return new PrimaryLocation(__typename, id, ref);
      }
    }
  }
}
