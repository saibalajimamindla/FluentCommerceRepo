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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class GetUserByRefQuery implements Query<GetUserByRefQuery.Data, GetUserByRefQuery.Data, GetUserByRefQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetUserByRef($username: String!) {\n"
      + "  user(username: $username) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    ref\n"
      + "    status\n"
      + "    type\n"
      + "    title\n"
      + "    firstName\n"
      + "    lastName\n"
      + "    username\n"
      + "    primaryEmail\n"
      + "    primaryPhone\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetUserByRef";
    }
  };

  private final GetUserByRefQuery.Variables variables;

  public GetUserByRefQuery(@Nonnull String username) {
    Utils.checkNotNull(username, "username == null");
    variables = new GetUserByRefQuery.Variables(username);
  }

  @Override
  public String operationId() {
    return "5bd8eb77c84dd4d319297e624907ba15271f72812d0e41e70ef6bd57dbce2191";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetUserByRefQuery.Data wrapData(GetUserByRefQuery.Data data) {
    return data;
  }

  @Override
  public GetUserByRefQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetUserByRefQuery.Data> responseFieldMapper() {
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
    private @Nonnull String username;

    Builder() {
    }

    public Builder username(@Nonnull String username) {
      this.username = username;
      return this;
    }

    public GetUserByRefQuery build() {
      Utils.checkNotNull(username, "username == null");
      return new GetUserByRefQuery(username);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String username;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String username) {
      this.username = username;
      this.valueMap.put("username", username);
    }

    public @Nonnull String username() {
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
          writer.writeString("username", username);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("user", "user", new UnmodifiableMapBuilder<String, Object>(1)
        .put("username", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "username")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable User user;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable User user) {
      this.user = user;
    }

    /**
     *  Find a User entity
     */
    public @Nullable User user() {
      return this.user;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], user != null ? user.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "user=" + user
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
        return ((this.user == null) ? (that.user == null) : this.user.equals(that.user));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (user == null) ? 0 : user.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.user = user;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final User.Mapper userFieldMapper = new User.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final User user = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<User>() {
          @Override
          public User read(ResponseReader reader) {
            return userFieldMapper.map(reader);
          }
        });
        return new Data(user);
      }
    }

    public static final class Builder {
      private @Nullable User user;

      Builder() {
      }

      public Builder user(@Nullable User user) {
        this.user = user;
        return this;
      }

      public Builder user(@Nonnull Mutator<User.Builder> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        User.Builder builder = this.user != null ? this.user.toBuilder() : User.builder();
        mutator.accept(builder);
        this.user = builder.build();
        return this;
      }

      public Data build() {
        return new Data(user);
      }
    }
  }

  public static class User {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("ref", "ref", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("status", "status", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("type", "type", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("title", "title", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("firstName", "firstName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("lastName", "lastName", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("username", "username", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("primaryEmail", "primaryEmail", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("primaryPhone", "primaryPhone", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String ref;

    final @Nullable String status;

    final @Nonnull String type;

    final @Nullable String title;

    final @Nullable String firstName;

    final @Nullable String lastName;

    final @Nonnull String username;

    final @Nullable String primaryEmail;

    final @Nullable String primaryPhone;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public User(@Nonnull String __typename, @Nonnull String id, @Nonnull String ref,
        @Nullable String status, @Nonnull String type, @Nullable String title,
        @Nullable String firstName, @Nullable String lastName, @Nonnull String username,
        @Nullable String primaryEmail, @Nullable String primaryPhone) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.ref = Utils.checkNotNull(ref, "ref == null");
      this.status = status;
      this.type = Utils.checkNotNull(type, "type == null");
      this.title = title;
      this.firstName = firstName;
      this.lastName = lastName;
      this.username = Utils.checkNotNull(username, "username == null");
      this.primaryEmail = primaryEmail;
      this.primaryPhone = primaryPhone;
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
    public @Nonnull String ref() {
      return this.ref;
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
     *  Unique name for the user used for identification and logging purposes.
     */
    public @Nonnull String username() {
      return this.username;
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

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], ref);
          writer.writeString($responseFields[3], status);
          writer.writeString($responseFields[4], type);
          writer.writeString($responseFields[5], title);
          writer.writeString($responseFields[6], firstName);
          writer.writeString($responseFields[7], lastName);
          writer.writeString($responseFields[8], username);
          writer.writeString($responseFields[9], primaryEmail);
          writer.writeString($responseFields[10], primaryPhone);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "User{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "ref=" + ref + ", "
          + "status=" + status + ", "
          + "type=" + type + ", "
          + "title=" + title + ", "
          + "firstName=" + firstName + ", "
          + "lastName=" + lastName + ", "
          + "username=" + username + ", "
          + "primaryEmail=" + primaryEmail + ", "
          + "primaryPhone=" + primaryPhone
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof User) {
        User that = (User) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.ref.equals(that.ref)
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && this.type.equals(that.type)
         && ((this.title == null) ? (that.title == null) : this.title.equals(that.title))
         && ((this.firstName == null) ? (that.firstName == null) : this.firstName.equals(that.firstName))
         && ((this.lastName == null) ? (that.lastName == null) : this.lastName.equals(that.lastName))
         && this.username.equals(that.username)
         && ((this.primaryEmail == null) ? (that.primaryEmail == null) : this.primaryEmail.equals(that.primaryEmail))
         && ((this.primaryPhone == null) ? (that.primaryPhone == null) : this.primaryPhone.equals(that.primaryPhone));
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
        h ^= type.hashCode();
        h *= 1000003;
        h ^= (title == null) ? 0 : title.hashCode();
        h *= 1000003;
        h ^= (firstName == null) ? 0 : firstName.hashCode();
        h *= 1000003;
        h ^= (lastName == null) ? 0 : lastName.hashCode();
        h *= 1000003;
        h ^= username.hashCode();
        h *= 1000003;
        h ^= (primaryEmail == null) ? 0 : primaryEmail.hashCode();
        h *= 1000003;
        h ^= (primaryPhone == null) ? 0 : primaryPhone.hashCode();
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
      builder.type = type;
      builder.title = title;
      builder.firstName = firstName;
      builder.lastName = lastName;
      builder.username = username;
      builder.primaryEmail = primaryEmail;
      builder.primaryPhone = primaryPhone;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<User> {
      @Override
      public User map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String ref = reader.readString($responseFields[2]);
        final String status = reader.readString($responseFields[3]);
        final String type = reader.readString($responseFields[4]);
        final String title = reader.readString($responseFields[5]);
        final String firstName = reader.readString($responseFields[6]);
        final String lastName = reader.readString($responseFields[7]);
        final String username = reader.readString($responseFields[8]);
        final String primaryEmail = reader.readString($responseFields[9]);
        final String primaryPhone = reader.readString($responseFields[10]);
        return new User(__typename, id, ref, status, type, title, firstName, lastName, username, primaryEmail, primaryPhone);
      }
    }

    public static final class Builder {
      private @Nonnull String __typename;

      private @Nonnull String id;

      private @Nonnull String ref;

      private @Nullable String status;

      private @Nonnull String type;

      private @Nullable String title;

      private @Nullable String firstName;

      private @Nullable String lastName;

      private @Nonnull String username;

      private @Nullable String primaryEmail;

      private @Nullable String primaryPhone;

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

      public Builder username(@Nonnull String username) {
        this.username = username;
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

      public User build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(id, "id == null");
        Utils.checkNotNull(ref, "ref == null");
        Utils.checkNotNull(type, "type == null");
        Utils.checkNotNull(username, "username == null");
        return new User(__typename, id, ref, status, type, title, firstName, lastName, username, primaryEmail, primaryPhone);
      }
    }
  }
}
