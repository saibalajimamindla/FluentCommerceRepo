package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateUserInput {
  private final @Nonnull String ref;

  private final @Nonnull String username;

  private final @Nonnull String password;

  private final Input<String> title;

  private final @Nonnull String firstName;

  private final Input<String> lastName;

  private final @Nonnull String primaryEmail;

  private final Input<String> primaryPhone;

  private final @Nonnull String type;

  private final Input<String> apiKey;

  private final Input<List<AttributeInput>> attributes;

  private final Input<String> department;

  private final Input<String> country;

  private final @Nonnull String timezone;

  private final Input<SettingValueTypeInput> language;

  private final Input<Boolean> promotionOptIn;

  private final Input<RetailerId> primaryRetailer;

  private final Input<LocationId> primaryLocation;

  private final Input<List<UserRoleInput>> roles;

  CreateUserInput(@Nonnull String ref, @Nonnull String username, @Nonnull String password,
      Input<String> title, @Nonnull String firstName, Input<String> lastName,
      @Nonnull String primaryEmail, Input<String> primaryPhone, @Nonnull String type,
      Input<String> apiKey, Input<List<AttributeInput>> attributes, Input<String> department,
      Input<String> country, @Nonnull String timezone, Input<SettingValueTypeInput> language,
      Input<Boolean> promotionOptIn, Input<RetailerId> primaryRetailer,
      Input<LocationId> primaryLocation, Input<List<UserRoleInput>> roles) {
    this.ref = ref;
    this.username = username;
    this.password = password;
    this.title = title;
    this.firstName = firstName;
    this.lastName = lastName;
    this.primaryEmail = primaryEmail;
    this.primaryPhone = primaryPhone;
    this.type = type;
    this.apiKey = apiKey;
    this.attributes = attributes;
    this.department = department;
    this.country = country;
    this.timezone = timezone;
    this.language = language;
    this.promotionOptIn = promotionOptIn;
    this.primaryRetailer = primaryRetailer;
    this.primaryLocation = primaryLocation;
    this.roles = roles;
  }

  /**
   *  External reference of the object. Recommended to be unique. <br/>
   *  Max character limit: 100.
   */
  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  Unique name for the user used for identification and logging purposes. <br/>
   *  Max character limit: 250.
   */
  public @Nonnull String username() {
    return this.username;
  }

  /**
   *  Password. # **Note** <br /><br />
   *  Please note that password once created can not be retrieved via the API at the moment. We are working on a security model that will enable password viewing to
   *  authenticated customers but until then, we request you to remember the password you created the `User` with. <br/>
   *  Max character limit: 128.
   */
  public @Nonnull String password() {
    return this.password;
  }

  /**
   *  The user's title. For example _Mr._, _Miss_, _Dr._, _Ms._ etc <br/>
   *  Max character limit: 50.
   */
  public @Nullable String title() {
    return this.title.value;
  }

  /**
   *  User's first name. <br/>
   *  Max character limit: 50.
   */
  public @Nonnull String firstName() {
    return this.firstName;
  }

  /**
   *  User's last name. <br/>
   *  Max character limit: 50.
   */
  public @Nullable String lastName() {
    return this.lastName.value;
  }

  /**
   *  User's primary email. <br/>
   *  Max character limit: 250.
   */
  public @Nonnull String primaryEmail() {
    return this.primaryEmail;
  }

  /**
   *  User's primary phone number. <br/>
   *  Max character limit: 20.
   */
  public @Nullable String primaryPhone() {
    return this.primaryPhone.value;
  }

  /**
   *  Type of the user. This type is currently supports one of the following three values: _ADMIN_, _RETAILER_, _LOCATION_
   */
  public @Nonnull String type() {
    return this.type;
  }

  /**
   *  API Key. To be used with the Fluent Widget. <br/>
   *  Max character limit: 128.
   */
  public @Nullable String apiKey() {
    return this.apiKey.value;
  }

  /**
   *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
   */
  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  /**
   *  Department
   */
  public @Nullable String department() {
    return this.department.value;
  }

  /**
   *  Country. <br/>
   *  Max character limit: 100.
   */
  public @Nullable String country() {
    return this.country.value;
  }

  /**
   *  Timezone. <br/>
   *  Max character limit: 32.
   */
  public @Nonnull String timezone() {
    return this.timezone;
  }

  /**
   *  User language (leave null to allow users to self-select their language preference)
   */
  public @Nullable SettingValueTypeInput language() {
    return this.language.value;
  }

  /**
   *  Determines if the user has opted to receive promotions
   */
  public @Nullable Boolean promotionOptIn() {
    return this.promotionOptIn.value;
  }

  /**
   *  User's retailer context
   */
  public @Nullable RetailerId primaryRetailer() {
    return this.primaryRetailer.value;
  }

  /**
   *  User's location context
   */
  public @Nullable LocationId primaryLocation() {
    return this.primaryLocation.value;
  }

  /**
   *  A list of roles along with their contexts which are to be assigned to the user.
   */
  public @Nullable List<UserRoleInput> roles() {
    return this.roles.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("ref", ref);
        writer.writeString("username", username);
        writer.writeString("password", password);
        if (title.defined) {
          writer.writeString("title", title.value);
        }
        writer.writeString("firstName", firstName);
        if (lastName.defined) {
          writer.writeString("lastName", lastName.value);
        }
        writer.writeString("primaryEmail", primaryEmail);
        if (primaryPhone.defined) {
          writer.writeString("primaryPhone", primaryPhone.value);
        }
        writer.writeString("type", type);
        if (apiKey.defined) {
          writer.writeString("apiKey", apiKey.value);
        }
        if (attributes.defined) {
          writer.writeList("attributes", attributes.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (AttributeInput $item : attributes.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
        if (department.defined) {
          writer.writeString("department", department.value);
        }
        if (country.defined) {
          writer.writeString("country", country.value);
        }
        writer.writeString("timezone", timezone);
        if (language.defined) {
          writer.writeObject("language", language.value != null ? language.value.marshaller() : null);
        }
        if (promotionOptIn.defined) {
          writer.writeBoolean("promotionOptIn", promotionOptIn.value);
        }
        if (primaryRetailer.defined) {
          writer.writeObject("primaryRetailer", primaryRetailer.value != null ? primaryRetailer.value.marshaller() : null);
        }
        if (primaryLocation.defined) {
          writer.writeObject("primaryLocation", primaryLocation.value != null ? primaryLocation.value.marshaller() : null);
        }
        if (roles.defined) {
          writer.writeList("roles", roles.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (UserRoleInput $item : roles.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private @Nonnull String username;

    private @Nonnull String password;

    private Input<String> title = Input.absent();

    private @Nonnull String firstName;

    private Input<String> lastName = Input.absent();

    private @Nonnull String primaryEmail;

    private Input<String> primaryPhone = Input.absent();

    private @Nonnull String type;

    private Input<String> apiKey = Input.absent();

    private Input<List<AttributeInput>> attributes = Input.absent();

    private Input<String> department = Input.absent();

    private Input<String> country = Input.absent();

    private @Nonnull String timezone;

    private Input<SettingValueTypeInput> language = Input.absent();

    private Input<Boolean> promotionOptIn = Input.absent();

    private Input<RetailerId> primaryRetailer = Input.absent();

    private Input<LocationId> primaryLocation = Input.absent();

    private Input<List<UserRoleInput>> roles = Input.absent();

    Builder() {
    }

    /**
     *  External reference of the object. Recommended to be unique. <br/>
     *  Max character limit: 100.
     */
    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  Unique name for the user used for identification and logging purposes. <br/>
     *  Max character limit: 250.
     */
    public Builder username(@Nonnull String username) {
      this.username = username;
      return this;
    }

    /**
     *  Password. # **Note** <br /><br />
     *  Please note that password once created can not be retrieved via the API at the moment. We are working on a security model that will enable password viewing to
     *  authenticated customers but until then, we request you to remember the password you created the `User` with. <br/>
     *  Max character limit: 128.
     */
    public Builder password(@Nonnull String password) {
      this.password = password;
      return this;
    }

    /**
     *  The user's title. For example _Mr._, _Miss_, _Dr._, _Ms._ etc <br/>
     *  Max character limit: 50.
     */
    public Builder title(@Nullable String title) {
      this.title = Input.fromNullable(title);
      return this;
    }

    /**
     *  User's first name. <br/>
     *  Max character limit: 50.
     */
    public Builder firstName(@Nonnull String firstName) {
      this.firstName = firstName;
      return this;
    }

    /**
     *  User's last name. <br/>
     *  Max character limit: 50.
     */
    public Builder lastName(@Nullable String lastName) {
      this.lastName = Input.fromNullable(lastName);
      return this;
    }

    /**
     *  User's primary email. <br/>
     *  Max character limit: 250.
     */
    public Builder primaryEmail(@Nonnull String primaryEmail) {
      this.primaryEmail = primaryEmail;
      return this;
    }

    /**
     *  User's primary phone number. <br/>
     *  Max character limit: 20.
     */
    public Builder primaryPhone(@Nullable String primaryPhone) {
      this.primaryPhone = Input.fromNullable(primaryPhone);
      return this;
    }

    /**
     *  Type of the user. This type is currently supports one of the following three values: _ADMIN_, _RETAILER_, _LOCATION_
     */
    public Builder type(@Nonnull String type) {
      this.type = type;
      return this;
    }

    /**
     *  API Key. To be used with the Fluent Widget. <br/>
     *  Max character limit: 128.
     */
    public Builder apiKey(@Nullable String apiKey) {
      this.apiKey = Input.fromNullable(apiKey);
      return this;
    }

    /**
     *  A list of attributes associated with this object. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    /**
     *  Department
     */
    public Builder department(@Nullable String department) {
      this.department = Input.fromNullable(department);
      return this;
    }

    /**
     *  Country. <br/>
     *  Max character limit: 100.
     */
    public Builder country(@Nullable String country) {
      this.country = Input.fromNullable(country);
      return this;
    }

    /**
     *  Timezone. <br/>
     *  Max character limit: 32.
     */
    public Builder timezone(@Nonnull String timezone) {
      this.timezone = timezone;
      return this;
    }

    /**
     *  User language (leave null to allow users to self-select their language preference)
     */
    public Builder language(@Nullable SettingValueTypeInput language) {
      this.language = Input.fromNullable(language);
      return this;
    }

    /**
     *  Determines if the user has opted to receive promotions
     */
    public Builder promotionOptIn(@Nullable Boolean promotionOptIn) {
      this.promotionOptIn = Input.fromNullable(promotionOptIn);
      return this;
    }

    /**
     *  User's retailer context
     */
    public Builder primaryRetailer(@Nullable RetailerId primaryRetailer) {
      this.primaryRetailer = Input.fromNullable(primaryRetailer);
      return this;
    }

    /**
     *  User's location context
     */
    public Builder primaryLocation(@Nullable LocationId primaryLocation) {
      this.primaryLocation = Input.fromNullable(primaryLocation);
      return this;
    }

    /**
     *  A list of roles along with their contexts which are to be assigned to the user.
     */
    public Builder roles(@Nullable List<UserRoleInput> roles) {
      this.roles = Input.fromNullable(roles);
      return this;
    }

    public CreateUserInput build() {
      Utils.checkNotNull(ref, "ref == null");
      Utils.checkNotNull(username, "username == null");
      Utils.checkNotNull(password, "password == null");
      Utils.checkNotNull(firstName, "firstName == null");
      Utils.checkNotNull(primaryEmail, "primaryEmail == null");
      Utils.checkNotNull(type, "type == null");
      Utils.checkNotNull(timezone, "timezone == null");
      return new CreateUserInput(ref, username, password, title, firstName, lastName, primaryEmail, primaryPhone, type, apiKey, attributes, department, country, timezone, language, promotionOptIn, primaryRetailer, primaryLocation, roles);
    }
  }
}
