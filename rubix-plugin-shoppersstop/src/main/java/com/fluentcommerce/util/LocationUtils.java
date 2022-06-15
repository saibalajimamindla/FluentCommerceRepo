package com.fluentcommerce.util;

import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationCoordinatesRefQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationsForNetworkRefQuery;
import com.fluentcommerce.commonv2.graphql.type.*;
import com.fluentcommerce.model.address.Address;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.network.Network;
import com.fluentcommerce.model.openingSchedule.OpeningSchedule;
import com.fluentcommerce.model.storageArea.StorageArea;
import com.fluentretail.api.model.location.Coordinates;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Holger.
 */
@Slf4j
public class LocationUtils {

    private LocationUtils() {}

    public static Location mapLocationToDto(GetLocationsForNetworkRefQuery.Location location) {
        Location.Builder locationDto = Location.builder()
            .id(location.id())
            .ref(location.ref())
            .type(location.type())
            .longitude(location.primaryAddress().longitude())
            .latitude(location.primaryAddress().latitude());
        return locationDto.build();
    }

    public static Double getNearestLocationDistance(Collection<Location> locations) {
        List<Location> sortedLocations = new ArrayList<>(locations);
        Collections.sort(sortedLocations, Comparator.comparing(Location::getDistance));
        Double nearestLocationDistance = sortedLocations.stream().findFirst().get().getDistance();
        return nearestLocationDistance;
    }

    public static double findDistance(Coordinates coordinate1, Coordinates coordinate2) {
        return distance(coordinate1, coordinate2);
    }

    public static Coordinates getLocationCoordinates(ContextWrapper context, String locationRef) {
        GetLocationCoordinatesRefQuery query = GetLocationCoordinatesRefQuery.builder().ref(locationRef).build();
        GetLocationCoordinatesRefQuery.Data data = (GetLocationCoordinatesRefQuery.Data) context.api().query(query);

        Coordinates coordinates = Coordinates.builder()
            .longitude(data.location().primaryAddress().longitude())
            .latitude(data.location().primaryAddress().latitude()).build();
        return coordinates;
    }

    private static Double distance(Coordinates coordinate1, Coordinates coordinate2) {
        double lat1 = coordinate1.getLatitude();
        double lat2 = coordinate2.getLatitude();
        double lon1 = coordinate1.getLongitude();
        double lon2 = coordinate2.getLongitude();

        final int radius = 6371; // Radius of the earth

        double latDistance = deg2rad(lat2 - lat1);
        double lonDistance = deg2rad(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return radius * c * 1000; // convert to meters
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }


    public static CreateStoreAddressInput constructStoreAddressInput(Address address) {

        CreateStoreAddressInput createStoreAddressInput = CreateStoreAddressInput.builder()
                .ref(address.getRef())
                .companyName(address.getCompanyName())
                .name(address.getName())
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .postcode(address.getPostcode())
                .region(address.getRegion())
                .country(address.getCountry())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .timeZone(address.getTimeZone())
                .build();

        return createStoreAddressInput;
    }

    public static CreateOpeningScheduleInput constructOpeningScheduleInput(OpeningSchedule openingSchedule) {
        CreateOpeningScheduleInput createOpeningScheduleInput = CreateOpeningScheduleInput.builder()
                .allHours(openingSchedule.getAllHours())
                .monStart(openingSchedule.getMonStart())
                .monEnd(openingSchedule.getMonEnd())
                .tueStart(openingSchedule.getTueStart())
                .tueEnd(openingSchedule.getTueEnd())
                .wedStart(openingSchedule.getWedStart())
                .wedStart(openingSchedule.getWedEnd())
                .thuStart(openingSchedule.getThuStart())
                .thuStart(openingSchedule.getThuStart())
                .friStart(openingSchedule.getFriStart())
                .friEnd(openingSchedule.getFriEnd())
                .satStart(openingSchedule.getSatStart())
                .satEnd(openingSchedule.getSatEnd())
                .sunStart(openingSchedule.getSunStart())
                .sunEnd(openingSchedule.getSunEnd())
                .build();
        return createOpeningScheduleInput;
    }

    public static UpdateStoreAddressInput constructStoreAddressInput(Address primaryAddressFromUpsert,
                                                                     Address primaryAddressFromDB) {

        UpdateStoreAddressInput.Builder updateStoreAddressBuilder = UpdateStoreAddressInput.builder();
        updateStoreAddressBuilder.id(primaryAddressFromDB.getId());

        if(primaryAddressFromUpsert.getCompanyName() != null){
            updateStoreAddressBuilder.companyName(primaryAddressFromUpsert.getCompanyName());
        }
        if(primaryAddressFromUpsert.getName() != null){
           updateStoreAddressBuilder.name(primaryAddressFromUpsert.getName());
        }
        if(primaryAddressFromUpsert.getStreet() != null){
            updateStoreAddressBuilder.street(primaryAddressFromUpsert.getStreet());
        }
        if(primaryAddressFromUpsert.getCity()!= null){
            updateStoreAddressBuilder.city(primaryAddressFromUpsert.getCity());
        }
        if(primaryAddressFromUpsert.getState() != null){
            updateStoreAddressBuilder.state(primaryAddressFromUpsert.getState());
        }
        if(primaryAddressFromUpsert.getPostcode() != null){
            updateStoreAddressBuilder.postcode(primaryAddressFromUpsert.getPostcode());
        }
        if(primaryAddressFromUpsert.getRegion() != null){
            updateStoreAddressBuilder.region(primaryAddressFromUpsert.getRegion());
        }
        if(primaryAddressFromUpsert.getCountry() != null){
            updateStoreAddressBuilder.country(primaryAddressFromUpsert.getCountry());
        }
        if(primaryAddressFromUpsert.getLatitude() != null){
            updateStoreAddressBuilder.latitude(primaryAddressFromUpsert.getLatitude());
        }
        if(primaryAddressFromUpsert.getLongitude() != null){
            updateStoreAddressBuilder.longitude(primaryAddressFromUpsert.getLongitude());
        }
        if(primaryAddressFromUpsert.getTimeZone() != null){
            updateStoreAddressBuilder.timeZone(primaryAddressFromUpsert.getTimeZone());
        }
        return updateStoreAddressBuilder.build();
    }

    public static UpdateOpeningScheduleInput constructOpeningScheduleInput(OpeningSchedule openingScheduleFromUpsert, OpeningSchedule openingScheduleFromDB) {

        UpdateOpeningScheduleInput.Builder updateOpeningScheduleBuilder = UpdateOpeningScheduleInput.builder();
        updateOpeningScheduleBuilder.id(openingScheduleFromDB.getId());

        if(openingScheduleFromUpsert.getAllHours() != null){
            updateOpeningScheduleBuilder.allHours(openingScheduleFromUpsert.getAllHours());
        }
        if(openingScheduleFromUpsert.getMonEnd() != null){
            updateOpeningScheduleBuilder.monEnd(openingScheduleFromUpsert.getMonEnd());
        }
        if(openingScheduleFromUpsert.getMonStart() != null){
            updateOpeningScheduleBuilder.monStart(openingScheduleFromUpsert.getMonStart());
        }
        if(openingScheduleFromUpsert.getTueEnd() != null){
            updateOpeningScheduleBuilder.tueEnd(openingScheduleFromUpsert.getTueEnd());
        }
        if(openingScheduleFromUpsert.getTueStart() != null){
            updateOpeningScheduleBuilder.tueStart(openingScheduleFromUpsert.getTueStart());
        }
        if(openingScheduleFromUpsert.getWedEnd() != null){
            updateOpeningScheduleBuilder.wedEnd(openingScheduleFromUpsert.getWedStart());
        }
        if(openingScheduleFromUpsert.getWedStart() != null){
            updateOpeningScheduleBuilder.wedStart(openingScheduleFromUpsert.getWedStart());
        }
        if(openingScheduleFromUpsert.getThuEnd() != null){
            updateOpeningScheduleBuilder.thuEnd(openingScheduleFromUpsert.getThuEnd());
        }
        if(openingScheduleFromUpsert.getThuStart() != null){
            updateOpeningScheduleBuilder.thuStart(openingScheduleFromUpsert.getThuStart());
        }
        if(openingScheduleFromUpsert.getFriStart() != null){
            updateOpeningScheduleBuilder.friStart(openingScheduleFromUpsert.getFriStart());
        }
        if(openingScheduleFromUpsert.getFriEnd() != null){
            updateOpeningScheduleBuilder.friEnd(openingScheduleFromUpsert.getFriEnd());
        }
        if(openingScheduleFromUpsert.getSatEnd() != null){
            updateOpeningScheduleBuilder.satEnd(openingScheduleFromUpsert.getSatEnd());
        }
        if(openingScheduleFromUpsert.getSatStart() != null){
            updateOpeningScheduleBuilder.satStart(openingScheduleFromUpsert.getSatStart());
        }
        if(openingScheduleFromUpsert.getSunEnd() != null){
            updateOpeningScheduleBuilder.sunEnd(openingScheduleFromUpsert.getSunEnd());
        }
        if(openingScheduleFromUpsert.getSunStart() != null){
            updateOpeningScheduleBuilder.sunStart(openingScheduleFromUpsert.getSunStart());
        }

        return updateOpeningScheduleBuilder.build();

    }

    public static List<NetworkId> constructNetworkIDList(List<Network> networkListFromUpsert) {
        if(networkListFromUpsert != null){
            return networkListFromUpsert.stream()
                    .map(network -> NetworkId.builder().id(network.getId()).build())
                    .collect(Collectors.toList());
        }
        return null;
    }

    public static List<UpdateStorageAreaWithLocationInput> constructStorageAreaWithLocationInputForUpdate( List<StorageArea> storageAreaListFromUpsert) {
        if(storageAreaListFromUpsert !=  null){
            return storageAreaListFromUpsert.stream()
                    .map(storageArea -> UpdateStorageAreaWithLocationInput.builder()
                            .id(storageArea.getId())
                            .status(storageArea.getStatus())
                            .type(storageArea.getType())
                            .attributes(AttributeUtils.of(storageArea.getAttributes())).build())
                    .collect(Collectors.toList());
        }
        return null;

    }

    public static List<CreateStorageAreaWithLocationInput> constructStorageAreaWithLocationInputForCreate(List<StorageArea> storageAreaList) {
        if(storageAreaList !=  null){
            return storageAreaList.stream()
                    .map(storageArea -> CreateStorageAreaWithLocationInput.builder()
                            .ref(storageArea.getRef())
                            .type(storageArea.getType())
                            .attributes(AttributeUtils.of(storageArea.getAttributes())).build())
                    .collect(Collectors.toList());
        }
        return null;
    }
}

