package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import java.io.IOException;
import java.lang.Override;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateConsignmentArticleWithConsignmentInput {
  private final Input<ArticleId> article;

  CreateConsignmentArticleWithConsignmentInput(Input<ArticleId> article) {
    this.article = article;
  }

  public @Nullable ArticleId article() {
    return this.article.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        if (article.defined) {
          writer.writeObject("article", article.value != null ? article.value.marshaller() : null);
        }
      }
    };
  }

  public static final class Builder {
    private Input<ArticleId> article = Input.absent();

    Builder() {
    }

    public Builder article(@Nullable ArticleId article) {
      this.article = Input.fromNullable(article);
      return this;
    }

    public CreateConsignmentArticleWithConsignmentInput build() {
      return new CreateConsignmentArticleWithConsignmentInput(article);
    }
  }
}
