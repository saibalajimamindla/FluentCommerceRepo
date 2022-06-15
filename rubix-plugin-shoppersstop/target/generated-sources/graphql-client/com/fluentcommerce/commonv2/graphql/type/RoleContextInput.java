package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("Apollo GraphQL")
public final class RoleContextInput {
  private final @Nonnull String contextType;

  private final @Nonnull String contextId;

  RoleContextInput(@Nonnull String contextType, @Nonnull String contextId) {
    this.contextType = contextType;
    this.contextId = contextId;
  }

  /**
   *  Represents the type of context. For more information on contexts and how they relate to user and roles,
   *  please visit <a href="https://lingo.fluentretail.com/display/LIN/Flex+Academy+Users" target="_blank">User's section on Lingo</a>.
   */
  public @Nonnull String contextType() {
    return this.contextType;
  }

  /**
   *  Represents the identity of the context object.
   */
  public @Nonnull String contextId() {
    return this.contextId;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("contextType", contextType);
        writer.writeCustom("contextId", com.fluentretail.graphql.type.CustomType.ID, contextId);
      }
    };
  }

  public static final class Builder {
    private @Nonnull String contextType;

    private @Nonnull String contextId;

    Builder() {
    }

    /**
     *  Represents the type of context. For more information on contexts and how they relate to user and roles,
     *  please visit <a href="https://lingo.fluentretail.com/display/LIN/Flex+Academy+Users" target="_blank">User's section on Lingo</a>.
     */
    public Builder contextType(@Nonnull String contextType) {
      this.contextType = contextType;
      return this;
    }

    /**
     *  Represents the identity of the context object.
     */
    public Builder contextId(@Nonnull String contextId) {
      this.contextId = contextId;
      return this;
    }

    public RoleContextInput build() {
      Utils.checkNotNull(contextType, "contextType == null");
      Utils.checkNotNull(contextId, "contextId == null");
      return new RoleContextInput(contextType, contextId);
    }
  }
}
