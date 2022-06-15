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
public final class CreateCommentInput {
  private final @Nonnull String entityType;

  private final @Nonnull String entityId;

  private final @Nonnull String text;

  CreateCommentInput(@Nonnull String entityType, @Nonnull String entityId, @Nonnull String text) {
    this.entityType = entityType;
    this.entityId = entityId;
    this.text = text;
  }

  /**
   *  Type of the entity. For example `ORDER`, `FULFILMENT`, `ORDERITEM`, `PRODUCTCATALOGUE` etc.
   */
  public @Nonnull String entityType() {
    return this.entityType;
  }

  /**
   *  ID of the entity <br/>
   *  Note: Please note that while the type of this field is `ID`, currently it only supports _Integer_ values.
   */
  public @Nonnull String entityId() {
    return this.entityId;
  }

  /**
   *  Comment text. <br/>
   *  Max character limit: 200.
   */
  public @Nonnull String text() {
    return this.text;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("entityType", entityType);
        writer.writeCustom("entityId", com.fluentretail.graphql.type.CustomType.ID, entityId);
        writer.writeString("text", text);
      }
    };
  }

  public static final class Builder {
    private @Nonnull String entityType;

    private @Nonnull String entityId;

    private @Nonnull String text;

    Builder() {
    }

    /**
     *  Type of the entity. For example `ORDER`, `FULFILMENT`, `ORDERITEM`, `PRODUCTCATALOGUE` etc.
     */
    public Builder entityType(@Nonnull String entityType) {
      this.entityType = entityType;
      return this;
    }

    /**
     *  ID of the entity <br/>
     *  Note: Please note that while the type of this field is `ID`, currently it only supports _Integer_ values.
     */
    public Builder entityId(@Nonnull String entityId) {
      this.entityId = entityId;
      return this;
    }

    /**
     *  Comment text. <br/>
     *  Max character limit: 200.
     */
    public Builder text(@Nonnull String text) {
      this.text = text;
      return this;
    }

    public CreateCommentInput build() {
      Utils.checkNotNull(entityType, "entityType == null");
      Utils.checkNotNull(entityId, "entityId == null");
      Utils.checkNotNull(text, "text == null");
      return new CreateCommentInput(entityType, entityId, text);
    }
  }
}
