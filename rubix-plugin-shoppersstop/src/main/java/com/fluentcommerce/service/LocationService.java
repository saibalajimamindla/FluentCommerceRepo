package com.fluentcommerce.service;

import com.fluentcommerce.commonv2.graphql.query.location.GetLocationByRefQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationForPrimaryAddressQuery;
import com.fluentcommerce.commonv2.graphql.query.location.GetLocationsForNetworkRefQuery;
import com.fluentcommerce.commonv2.graphql.query.user.GetUserByRefQuery;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.rubix.exceptions.RubixException;
import com.fluentretail.rubix.v2.context.Context;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.fluentcommerce.util.Constants.DEFAULT_PAGE_SIZE;

@Slf4j
public class LocationService {

    private static final String CLASS_NAME = LocationService.class.getSimpleName();

    private Context context;

    public LocationService(Context context) {
        this.context = context;
    }

    public List<Location> loadLocationsForNetwork(
        String networkRef,
        List<String> locationStatuses) {
        List<Location> networkLocations = new ArrayList<>();
        loadLocationsForNetwork(networkRef, locationStatuses, networkLocations, null);
        return networkLocations;
    }

    private List<Location> loadLocationsForNetwork(
        String networkRef,
        List<String> locationStatuses,
        List<Location> networkLocations,
        String locationCursor) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        log.info(logPrefix + " - query all the locations for network: {} in status:{}", networkRef, locationStatuses);
        GetLocationsForNetworkRefQuery.Builder query= GetLocationsForNetworkRefQuery.builder()
            .networkRef(networkRef)
            .locationStatuses(locationStatuses)
            .locationCount(DEFAULT_PAGE_SIZE);
        if(StringUtils.isNotBlank(locationCursor)) {
            query.locationCursor(locationCursor);
        }
        GetLocationsForNetworkRefQuery.Data result = (GetLocationsForNetworkRefQuery.Data) context.api().query(query.build());
        if(result != null
            && result.network() != null
            && result.network().locations() != null
            && result.network().locations().locationEdge() != null
            && !result.network().locations().locationEdge().isEmpty()
        ) {
            List<GetLocationsForNetworkRefQuery.LocationEdge> locationEdges = result.network().locations().locationEdge();
            for(GetLocationsForNetworkRefQuery.LocationEdge locationEdge : locationEdges) {
                if(locationEdge != null && locationEdge.location() != null) {
                    Location location = Location.from(locationEdge.location());
                    networkLocations.add(location);
                }
            }
            if(result.network().locations().pageInfo().hasNextPage()) {
                int size = locationEdges.size();
                int lastEntry = size - 1;
                String nextLocationCursor = locationEdges.get(lastEntry).cursor();
                loadLocationsForNetwork(networkRef, locationStatuses, networkLocations, nextLocationCursor);
            }
        } else {
            log.warn(logPrefix + " - cannot find locations for network ref:{}.", networkRef);
        }
        return networkLocations;
    }

    public GetLocationForPrimaryAddressQuery.PrimaryAddress getStoreAddressByLocationRef(String locationRef) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        try {
            log.info("{} - getting store address for location ref: {}", logPrefix, locationRef);
            GetLocationForPrimaryAddressQuery queryLocationForPrimaryAddress = GetLocationForPrimaryAddressQuery.builder().locationRef(Lists.newArrayList(locationRef)).build();
            GetLocationForPrimaryAddressQuery.Data data = (GetLocationForPrimaryAddressQuery.Data) context.api().query(queryLocationForPrimaryAddress);
            if (null != data.locations().edges() && CollectionUtils.isNotEmpty(data.locations().edges())) {
                return data.locations().edges().stream().findFirst().get().node().primaryAddress();
            }
            log.info("{} - store address for location ref: {} is not available.", logPrefix, data);
            throw new RubixException(404, "Store address id not found for ref: " + locationRef);
        } catch (Exception e) {
            log.error(logPrefix + " - Exception occured", e);
            throw new RubixException(404, "Exception occurred:" + e.getMessage() + " while getting Store address for location ref: " + locationRef);
        }
    }

    public GetLocationByRefQuery.Location getLocationByRefOrFail(String locationRef) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info("{} - getting location for ref - {}", logPrefix, locationRef);
        GetLocationByRefQuery getLocationDetails = GetLocationByRefQuery.builder()
                .ref(locationRef)
                .includeAttributes(true)
                .includeOpeningSchedule(true)
                .includePrimaryAddress(true)
                .includeRetailer(true)
                .includeNetworks(true)
                .includeStorageAreas(true)
                .build();
        return ((GetLocationByRefQuery.Data) context.api().query(getLocationDetails)).location();
    }

    public  boolean locationExists(String locationRef) {
        GetLocationByRefQuery getLocationDetails = GetLocationByRefQuery.builder()
                .ref(locationRef)
                .includeAttributes(false)
                .includeOpeningSchedule(false)
                .includePrimaryAddress(false)
                .includeRetailer(false)
                .includeNetworks(false)
                .includeStorageAreas(false)
                .build();
        final GetLocationByRefQuery.Data response = (GetLocationByRefQuery.Data) context.api().query(getLocationDetails);
        try {
            final String ref = response.location().ref();
            return StringUtils.equals(locationRef, ref);
        } catch (NullPointerException e) {
            return false;
        }
    }



    public GetUserByRefQuery.User getLocationUserByRef(String locationRef) {
        //TODO move to UserEntity
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info("{} - getting location user for ref - {}", logPrefix, locationRef);
        GetUserByRefQuery userByRefQuery = GetUserByRefQuery.builder().username(locationRef).build();
        return  ((GetUserByRefQuery.Data)context.api().query(userByRefQuery)).user();
    }
}
