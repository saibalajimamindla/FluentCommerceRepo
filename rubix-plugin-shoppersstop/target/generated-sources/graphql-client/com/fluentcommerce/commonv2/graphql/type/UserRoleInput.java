package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Override;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("Apollo GraphQL")
public final class UserRoleInput {
  private final @Nonnull RoleKey role;

  private final @Nonnull List<RoleContextInput> contexts;

  UserRoleInput(@Nonnull RoleKey role, @Nonnull List<RoleContextInput> contexts) {
    this.role = role;
    this.contexts = contexts;
  }

  /**
   *  Input to identify the role to be assigned
   */
  public @Nonnull RoleKey role() {
    return this.role;
  }

  /**
   *  Context for the role being assigned
   */
  public @Nonnull List<RoleContextInput> contexts() {
    return this.contexts;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeObject("role", role.marshaller());
        writer.writeList("contexts", new InputFieldWriter.ListWriter() {
          @Override
          public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
            for (RoleContextInput $item : contexts) {
              listItemWriter.writeObject($item.marshaller());
            }
          }
        });
      }
    };
  }

  public static final class Builder {
    private @Nonnull RoleKey role;

    private @Nonnull List<RoleContextInput> contexts;

    Builder() {
    }

    /**
     *  Input to identify the role to be assigned
     */
    public Builder role(@Nonnull RoleKey role) {
      this.role = role;
      return this;
    }

    /**
     *  Context for the role being assigned
     */
    public Builder contexts(@Nonnull List<RoleContextInput> contexts) {
      this.contexts = contexts;
      return this;
    }

    public UserRoleInput build() {
      Utils.checkNotNull(role, "role == null");
      Utils.checkNotNull(contexts, "contexts == null");
      return new UserRoleInput(role, contexts);
    }
  }
}
