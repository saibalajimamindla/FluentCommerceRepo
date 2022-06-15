package com.fluentcommerce.util;

import com.fluentretail.api.model.location.Coordinates;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeoUtils {

    public static Coordinates getCoordinatesByAddress(String addressStr, String apiKey) {
        GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();
        GeocodingApiRequest req = GeocodingApi.newRequest(context).address(addressStr);
        Coordinates coordinates = null;
        try {
            GeocodingResult[] result = req.await();
            if (result != null && result.length > 0) {
                LatLng latLng= result[0].geometry.location;
               coordinates = Coordinates.builder().latitude(latLng.lat).longitude(latLng.lng).build();
            }
        } catch (Exception e) {
            log.info("Address \"{}\" cannot be reliably determined by Google.", addressStr);
        }
        return coordinates;
    }

    public static String buildAddressString(String street, String city, String state, String postCode, String country) {
        StringBuilder addressBuilder = new StringBuilder();
        addressBuilder.append(" ");
        addressBuilder.append(street);
        addressBuilder.append(" ");
        addressBuilder.append(city);
        addressBuilder.append(" ");
        addressBuilder.append(state);
        addressBuilder.append(" ");
        addressBuilder.append(postCode);
        addressBuilder.append(" ");
        addressBuilder.append(country);
        return addressBuilder.toString();
    }

    /*
     * Calculate distance between two points in latitude and longitude NOT taking
     * into account height difference.
     * lat1, lon1 Start point lat2, lon2 End point
     */
    public static Double distance(double lat1, double lat2, double lon1, double lon2) {

        final int radius = 6371; // Radius of the earth

        Double latDistance = deg2rad(lat2 - lat1);
        Double lonDistance = deg2rad(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return radius * c * 1000; // convert to meters
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
}