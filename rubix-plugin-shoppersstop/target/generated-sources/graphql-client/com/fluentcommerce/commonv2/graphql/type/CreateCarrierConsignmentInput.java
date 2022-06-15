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
public final class CreateCarrierConsignmentInput {
  private final @Nonnull String ref;

  private final Input<String> consignmentReference;

  private final Input<String> trackingLabel;

  private final Input<String> labelUrl;

  private final Input<String> orderSummaryUrl;

  private final @Nonnull CarrierId carrier;

  private final @Nonnull RetailerId retailer;

  private final @Nonnull List<CreateConsignmentArticleWithConsignmentInput> carrierConsignmentArticles;

  private final Input<List<AttributeInput>> attributes;

  CreateCarrierConsignmentInput(@Nonnull String ref, Input<String> consignmentReference,
      Input<String> trackingLabel, Input<String> labelUrl, Input<String> orderSummaryUrl,
      @Nonnull CarrierId carrier, @Nonnull RetailerId retailer,
      @Nonnull List<CreateConsignmentArticleWithConsignmentInput> carrierConsignmentArticles,
      Input<List<AttributeInput>> attributes) {
    this.ref = ref;
    this.consignmentReference = consignmentReference;
    this.trackingLabel = trackingLabel;
    this.labelUrl = labelUrl;
    this.orderSummaryUrl = orderSummaryUrl;
    this.carrier = carrier;
    this.retailer = retailer;
    this.carrierConsignmentArticles = carrierConsignmentArticles;
    this.attributes = attributes;
  }

  /**
   *  External reference of the object. Must be unique.
   */
  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  The external consignment reference assigned by the carrier. <br/>
   *  Max character limit: 100.
   */
  public @Nullable String consignmentReference() {
    return this.consignmentReference.value;
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
  public @Nonnull List<CreateConsignmentArticleWithConsignmentInput> carrierConsignmentArticles() {
    return this.carrierConsignmentArticles;
  }

  /**
   *  A list of attributes associated with this Consignment. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
   */
  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("ref", ref);
        if (consignmentReference.defined) {
          writer.writeString("consignmentReference", consignmentReference.value);
        }
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
        writer.writeList("carrierConsignmentArticles", new InputFieldWriter.ListWriter() {
          @Override
          public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
            for (CreateConsignmentArticleWithConsignmentInput $item : carrierConsignmentArticles) {
              listItemWriter.writeObject($item.marshaller());
            }
          }
        });
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
      }
    };
  }

  public static final class Builder {
    private @Nonnull String ref;

    private Input<String> consignmentReference = Input.absent();

    private Input<String> trackingLabel = Input.absent();

    private Input<String> labelUrl = Input.absent();

    private Input<String> orderSummaryUrl = Input.absent();

    private @Nonnull CarrierId carrier;

    private @Nonnull RetailerId retailer;

    private @Nonnull List<CreateConsignmentArticleWithConsignmentInput> carrierConsignmentArticles;

    private Input<List<AttributeInput>> attributes = Input.absent();

    Builder() {
    }

    /**
     *  External reference of the object. Must be unique.
     */
    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  The external consignment reference assigned by the carrier. <br/>
     *  Max character limit: 100.
     */
    public Builder consignmentReference(@Nullable String consignmentReference) {
      this.consignmentReference = Input.fromNullable(consignmentReference);
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
    public Builder carrierConsignmentArticles(@Nonnull List<CreateConsignmentArticleWithConsignmentInput> carrierConsignmentArticles) {
      this.carrierConsignmentArticles = carrierConsignmentArticles;
      return this;
    }

    /**
     *  A list of attributes associated with this Consignment. This can be used to extend the existing data structure with additional data for use in orchestration rules, etc.
     */
    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    public CreateCarrierConsignmentInput build() {
      Utils.checkNotNull(ref, "ref == null");
      Utils.checkNotNull(carrier, "carrier == null");
      Utils.checkNotNull(retailer, "retailer == null");
      Utils.checkNotNull(carrierConsignmentArticles, "carrierConsignmentArticles == null");
      return new CreateCarrierConsignmentInput(ref, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl, carrier, retailer, carrierConsignmentArticles, attributes);
    }
  }
}
