package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class UpdateConsignmentInput {
  private final @Nonnull String id;

  private final Input<String> status;

  private final Input<String> consignmentReference;

  private final Input<String> trackingLabel;

  private final Input<String> labelUrl;

  private final Input<String> orderSummaryUrl;

  private final Input<CarrierId> carrier;

  UpdateConsignmentInput(@Nonnull String id, Input<String> status,
      Input<String> consignmentReference, Input<String> trackingLabel, Input<String> labelUrl,
      Input<String> orderSummaryUrl, Input<CarrierId> carrier) {
    this.id = id;
    this.status = status;
    this.consignmentReference = consignmentReference;
    this.trackingLabel = trackingLabel;
    this.labelUrl = labelUrl;
    this.orderSummaryUrl = orderSummaryUrl;
    this.carrier = carrier;
  }

  /**
   *  ID of the object
   */
  public @Nonnull String id() {
    return this.id;
  }

  /**
   *  The status of the consignment. <br/>
   *  Max character limit: 25.
   */
  public @Nullable String status() {
    return this.status.value;
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
  public @Nullable CarrierId carrier() {
    return this.carrier.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeCustom("id", com.fluentretail.graphql.type.CustomType.ID, id);
        if (status.defined) {
          writer.writeString("status", status.value);
        }
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
        if (carrier.defined) {
          writer.writeObject("carrier", carrier.value != null ? carrier.value.marshaller() : null);
        }
      }
    };
  }

  public static final class Builder {
    private @Nonnull String id;

    private Input<String> status = Input.absent();

    private Input<String> consignmentReference = Input.absent();

    private Input<String> trackingLabel = Input.absent();

    private Input<String> labelUrl = Input.absent();

    private Input<String> orderSummaryUrl = Input.absent();

    private Input<CarrierId> carrier = Input.absent();

    Builder() {
    }

    /**
     *  ID of the object
     */
    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    /**
     *  The status of the consignment. <br/>
     *  Max character limit: 25.
     */
    public Builder status(@Nullable String status) {
      this.status = Input.fromNullable(status);
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
    public Builder carrier(@Nullable CarrierId carrier) {
      this.carrier = Input.fromNullable(carrier);
      return this;
    }

    public UpdateConsignmentInput build() {
      Utils.checkNotNull(id, "id == null");
      return new UpdateConsignmentInput(id, status, consignmentReference, trackingLabel, labelUrl, orderSummaryUrl, carrier);
    }
  }
}
