package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class CreateConsignmentInput {
  private final @Nonnull String ref;

  private final @Nonnull String consignmentReference;

  private final Input<String> trackingLabel;

  private final Input<String> labelUrl;

  private final Input<String> orderSummaryUrl;

  private final @Nonnull CarrierId carrier;

  private final @Nonnull RetailerId retailer;

  private final @Nonnull List<CreateConsignmentArticleWithConsignmentInput> consignmentArticles;

  CreateConsignmentInput(@Nonnull String ref, @Nonnull String consignmentReference,
      Input<String> trackingLabel, Input<String> labelUrl, Input<String> orderSummaryUrl,
      @Nonnull CarrierId carrier, @Nonnull RetailerId retailer,
      @Nonnull List<CreateConsignmentArticleWithConsignmentInput> consignmentArticles) {
    this.ref = ref;
    this.consignmentReference = consignmentReference;
    this.trackingLabel = trackingLabel;
    this.labelUrl = labelUrl;
    this.orderSummaryUrl = orderSummaryUrl;
    this.carrier = carrier;
    this.retailer = retailer;
    this.consignmentArticles = consignmentArticles;
  }

  /**
   *  External reference of the object. Recommended to be unique.
   */
  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  The external consignment reference assigned by the carrier. <br/>
   *  Max character limit: 100.
   */
  public @Nonnull String consignmentReference() {
    return this.consignmentReference;
  }

  /**
   *  Tracking label of the consignment. <br/>
   *  Max character limit: 100.
   */
  public @Nullable String trackingLabel() {
    return this.trackingLabel.value;
  }

  /**
   *  The URL used to retrieve the shipping label
   */
  public @Nullable String labelUrl() {
    return this.labelUrl.value;
  }

  /**
   *  A url to represent the order summary. Usually the manifest url from the service provider.
   */
  public @Nullable String orderSummaryUrl() {
    return this.orderSummaryUrl.value;
  }

  /**
   *  Carrier used for the consignment
   */
  public @Nonnull CarrierId carrier() {
    return this.carrier;
  }

  /**
   *  Retailer who is booking the consignment
   */
  public @Nonnull RetailerId retailer() {
    return this.retailer;
  }

  /**
   *  Input for creating `ConsignmentArticle`s for this consignment
   */
  public @Nonnull List<CreateConsignmentArticleWithConsignmentInput> consignmentArticles() {
    return this.consignmentArticles;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("ref", ref);
        writer.writeString("consignmentReference", consignmentReference);
        if (trackingLabel.defined) {
          writer.writeString("trackingLabel", trackingLabel.value);
        }
        if (labelUrl.defined) {
          writer.writeString("labelUrl", labelUrl.value);
        }
        if (orderSummaryUrl.defined) {
          writer.writeString("orderSummaryUrl", orderSummaryUrl.value);
        }
        writer.writeObject("carrier", carrier.marshaller());
        writer.writeObject("retailer", retailer.marshaller());
        writer.writeList("consignmentArticles", new InputFieldWriter.ListWriter() {
          @Override
          public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
            for (CreateConsignmentArticleWithConsignmentInput $item : consignmentArticles) {
              listItemWriter.writeObject($item.marshaller());
            }
          }
        });
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private @Nonnull String consignmentReference;

    private Input<String> trackingLabel = Input.absent();

    private Input<String> labelUrl = Input.absent();

    private Input<String> orderSummaryUrl = Input.absent();

    private @Nonnull CarrierId carrier;

    private @Nonnull RetailerId retailer;

    private @Nonnull List<CreateConsignmentArticleWithConsignmentInput> consignmentArticles;

    Builder() {
    }

    /**
     *  External reference of the object. Recommended to be unique.
     */
    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  The external consignment reference assigned by the carrier. <br/>
     *  Max character limit: 100.
     */
    public Builder consignmentReference(@Nonnull String consignmentReference) {
      this.consignmentReference = consignmentReference;
      return this;
    }

    /**
     *  Tracking label of the consignment. <br/>
     *  Max character limit: 100.
     */
    public Builder trackingLabel(@Nullable String trackingLabel) {
      this.trackingLabel = Input.fromNullable(trackingLabel);
      return this;
    }

    /**
     *  The URL used to retrieve the shipping label
     */
    public Builder labelUrl(@Nullable String labelUrl) {
      this.labelUrl = Input.fromNullable(labelUrl);
      return this;
    }

    /**
     *  A url to represent the order summary. Usually the manifest url from the service provider.
     */
    public Builder orderSummaryUrl(@Nullable String orderSummaryUrl) {
      this.orderSummaryUrl = Input.fromNullable(orderSummaryUrl);
      return this;
    }

    /**
     *  Carrier used for the consignment
     */
    public Builder carrier(@Nonnull CarrierId carrier) {
      this.carrier = carrier;
      return this;
    }

    /**
     *  Retailer who is booking the consignment
     */
    public Builder retailer(@Nonnull RetailerId retailer) {
      this.retailer = retailer;
      return this;
    }

    /**
     *  Input for creating `ConsignmentArticle`s for this consignment
     */
    public Builder consignmentArticles(@Nonnull List<CreateConsignmentArticleWithConsignmentInput> consignmentArticles) {
      this.consignmentArticles = consignmentArticles;
      return this;
    }

    public CreateConsignmentInput build() {
      Utils.checkNotNull(ref, "ref == null");
      Utils.checkNotNull(consignmentReference, "consignmentReference == null");
      Utils.checkNotNull(carrier, "carrier == null");
      Utils.checkNotNull(retailer, "retailer == null");
      Utils.checkNotNull(consignmentArticles, "consignmentArticles == null");
      return new CreateConsignmentInput(ref, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl, carrier, retailer, consignmentArticles);
    }
  }
}
