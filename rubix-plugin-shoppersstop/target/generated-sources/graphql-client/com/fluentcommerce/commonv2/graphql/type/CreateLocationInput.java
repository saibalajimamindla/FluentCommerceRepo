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
public final class CreateLocationInput {
  private final @Nonnull String ref;

  private final @Nonnull String type;

  private final Input<List<AttributeInput>> attributes;

  private final @Nonnull String name;

  private final Input<String> supportPhoneNumber;

  private final Input<String> defaultCarrier;

  private final @Nonnull CreateStoreAddressInput primaryAddress;

  private final @Nonnull RetailerId retailer;

  private final @Nonnull CreateOpeningScheduleInput openingSchedule;

  private final Input<List<NetworkId>> networks;

  private final Input<List<CreateStorageAreaWithLocationInput>> storageAreas;

  CreateLocationInput(@Nonnull String ref, @Nonnull String type,
      Input<List<AttributeInput>> attributes, @Nonnull String name,
      Input<String> supportPhoneNumber, Input<String> defaultCarrier,
      @Nonnull CreateStoreAddressInput primaryAddress, @Nonnull RetailerId retailer,
      @Nonnull CreateOpeningScheduleInput openingSchedule, Input<List<NetworkId>> networks,
      Input<List<CreateStorageAreaWithLocationInput>> storageAreas) {
    this.ref = ref;
    this.type = type;
    this.attributes = attributes;
    this.name = name;
    this.supportPhoneNumber = supportPhoneNumber;
    this.defaultCarrier = defaultCarrier;
    this.primaryAddress = primaryAddress;
    this.retailer = retailer;
    this.openingSchedule = openingSchedule;
    this.networks = networks;
    this.storageAreas = storageAreas;
  }

  /**
   *  Max character limit: 8.
   */
  public @Nonnull String ref() {
    return this.ref;
  }

  /**
   *  Max character limit: 25.
   */
  public @Nonnull String type() {
    return this.type;
  }

  public @Nullable List<AttributeInput> attributes() {
    return this.attributes.value;
  }

  /**
   *  Max character limit: 100.
   */
  public @Nonnull String name() {
    return this.name;
  }

  /**
   *  Max character limit: 20.
   */
  public @Nullable String supportPhoneNumber() {
    return this.supportPhoneNumber.value;
  }

  /**
   *  Max character limit: 50.
   */
  public @Nullable String defaultCarrier() {
    return this.defaultCarrier.value;
  }

  public @Nonnull CreateStoreAddressInput primaryAddress() {
    return this.primaryAddress;
  }

  public @Nonnull RetailerId retailer() {
    return this.retailer;
  }

  public @Nonnull CreateOpeningScheduleInput openingSchedule() {
    return this.openingSchedule;
  }

  public @Nullable List<NetworkId> networks() {
    return this.networks.value;
  }

  public @Nullable List<CreateStorageAreaWithLocationInput> storageAreas() {
    return this.storageAreas.value;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeString("ref", ref);
        writer.writeString("type", type);
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
        writer.writeString("name", name);
        if (supportPhoneNumber.defined) {
          writer.writeString("supportPhoneNumber", supportPhoneNumber.value);
        }
        if (defaultCarrier.defined) {
          writer.writeString("defaultCarrier", defaultCarrier.value);
        }
        writer.writeObject("primaryAddress", primaryAddress.marshaller());
        writer.writeObject("retailer", retailer.marshaller());
        writer.writeObject("openingSchedule", openingSchedule.marshaller());
        if (networks.defined) {
          writer.writeList("networks", networks.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (NetworkId $item : networks.value) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
        if (storageAreas.defined) {
          writer.writeList("storageAreas", storageAreas.value != null ? new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (CreateStorageAreaWithLocationInput $item : storageAreas.value) {
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

    private @Nonnull String type;

    private Input<List<AttributeInput>> attributes = Input.absent();

    private @Nonnull String name;

    private Input<String> supportPhoneNumber = Input.absent();

    private Input<String> defaultCarrier = Input.absent();

    private @Nonnull CreateStoreAddressInput primaryAddress;

    private @Nonnull RetailerId retailer;

    private @Nonnull CreateOpeningScheduleInput openingSchedule;

    private Input<List<NetworkId>> networks = Input.absent();

    private Input<List<CreateStorageAreaWithLocationInput>> storageAreas = Input.absent();

    Builder() {
    }

    /**
     *  Max character limit: 8.
     */
    public Builder ref(@Nonnull String ref) {
      this.ref = ref;
      return this;
    }

    /**
     *  Max character limit: 25.
     */
    public Builder type(@Nonnull String type) {
      this.type = type;
      return this;
    }

    public Builder attributes(@Nullable List<AttributeInput> attributes) {
      this.attributes = Input.fromNullable(attributes);
      return this;
    }

    /**
     *  Max character limit: 100.
     */
    public Builder name(@Nonnull String name) {
      this.name = name;
      return this;
    }

    /**
     *  Max character limit: 20.
     */
    public Builder supportPhoneNumber(@Nullable String supportPhoneNumber) {
      this.supportPhoneNumber = Input.fromNullable(supportPhoneNumber);
      return this;
    }

    /**
     *  Max character limit: 50.
     */
    public Builder defaultCarrier(@Nullable String defaultCarrier) {
      this.defaultCarrier = Input.fromNullable(defaultCarrier);
      return this;
    }

    public Builder primaryAddress(@Nonnull CreateStoreAddressInput primaryAddress) {
      this.primaryAddress = primaryAddress;
      return this;
    }

    public Builder retailer(@Nonnull RetailerId retailer) {
      this.retailer = retailer;
      return this;
    }

    public Builder openingSchedule(@Nonnull CreateOpeningScheduleInput openingSchedule) {
      this.openingSchedule = openingSchedule;
      return this;
    }

    public Builder networks(@Nullable List<NetworkId> networks) {
      this.networks = Input.fromNullable(networks);
      return this;
    }

    public Builder storageAreas(@Nullable List<CreateStorageAreaWithLocationInput> storageAreas) {
      this.storageAreas = Input.fromNullable(storageAreas);
      return this;
    }

    public CreateLocationInput build() {
      Utils.checkNotNull(ref, "ref == null");
      Utils.checkNotNull(type, "type == null");
      Utils.checkNotNull(name, "name == null");
      Utils.checkNotNull(primaryAddress, "primaryAddress == null");
      Utils.checkNotNull(retailer, "retailer == null");
      Utils.checkNotNull(openingSchedule, "openingSchedule == null");
      return new CreateLocationInput(ref, type, attributes, name, supportPhoneNumber, defaultCarrier, primaryAddress, retailer, openingSchedule, networks, storageAreas);
    }
  }
}
