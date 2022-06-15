package com.fluentcommerce.model.location;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationsForNetworkRefQuery;
import com.fluentcommerce.model.address.Address;
import com.fluentcommerce.model.attribute.Attribute;
import com.fluentcommerce.model.common.BaseEntity;
import com.fluentcommerce.model.network.Network;
import com.fluentcommerce.model.openingSchedule.OpeningSchedule;
import com.fluentcommerce.model.retailer.Retailer;
import com.fluentcommerce.model.storageArea.StorageArea;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = LocationDetails.Builder.class)
public class LocationDetails extends BaseEntity {

    private String id;
    private String ref;
    private String createdOn;
    private String updatedUpon;
    private String type;
    private String status;
    private String name;
    private String supportPhoneNumber;
    private String defaultCarrier;
    private String defaultCarrierName;

    private List<Attribute> attributes;

    private Address primaryAddress;
    public Retailer retailer;
    public List<Network> networks;
    private List<StorageArea> storageAreaList;
    private OpeningSchedule openingSchedule;

    private Double distance; // not an entity model attribute , this is an extra attribute

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {}

    public static LocationDetails from(GetLocationsForNetworkRefQuery.Location location) {
        return LocationDetails.builder()
            .id(location.id())
            .ref(location.ref())
            .status(location.status())
            .type(location.type())
            .primaryAddress(mapAddress(location.primaryAddress()))
            .build();
    }

    public static LocationDetails from(GetLocationByRefQuery.Location location) {
        return LocationDetails.builder()
            .id(location.id())
            .ref(location.ref())
            .status(location.status())
            .type(location.type())
            .name(location.name())
            .supportPhoneNumber(location.supportPhoneNumber())
            .defaultCarrier(location.defaultCarrier())
            .defaultCarrierName(location.defaultCarrierName())
            .attributes(mapAttributes(location.attributes()))
            .primaryAddress(mapAddress(location.primaryAddress()))
            .retailer(mapRetailer(location.retailer()))
            .networks(mapNetWork(location.networks()))
            .storageAreaList(mapStorageArea(location.storageAreas()))
            .openingSchedule(mapOpeningSchedule(location.openingSchedule()))
            .build();
    }

    private static List<StorageArea> mapStorageArea(GetLocationByRefQuery.StorageAreas storageAreas) {
        if (storageAreas == null) {
            return null;
        }
        return storageAreas.storageEdge().stream()
            .map(GetLocationByRefQuery.StorageEdge::storageNode)
            .filter(Objects::nonNull)
            .map(StorageArea::from)
            .collect(Collectors.toList());
    }

    private static List<Network> mapNetWork(GetLocationByRefQuery.Networks networks) {
        if (networks == null) {
            return null;
        }
        return networks.networkEdge().stream()
            .map(GetLocationByRefQuery.NetworkEdge::networkNode)
            .filter(Objects::nonNull)
            .map(Network::from)
            .collect(Collectors.toList());
    }

    private static Retailer mapRetailer(GetLocationByRefQuery.Retailer retailer) {
        if (retailer == null) {
            return null;
        }
        return Retailer.from(retailer);
    }

    private static OpeningSchedule mapOpeningSchedule(GetLocationByRefQuery.OpeningSchedule openingSchedule) {
        if (openingSchedule == null) {
            return null;
        }
        return OpeningSchedule.from(openingSchedule);
    }

    private static List<Attribute> mapAttributes(List<GetLocationByRefQuery.Attribute> attributes) {
        return attributes.stream()
            .map(Attribute::from)
            .collect(Collectors.toList());
    }

    private static Address mapAddress(GetLocationsForNetworkRefQuery.PrimaryAddress primaryAddress) {
        if (primaryAddress == null) {
            return null;
        }
        return Address.from(primaryAddress);
    }

    private static Address mapAddress(GetLocationByRefQuery.PrimaryAddress primaryAddress) {
        if (primaryAddress == null) {
            return null;
        }
        return Address.from(primaryAddress);
    }
}
