package com.fluentcommerce.util;

import com.fluentcommerce.dto.FulfilmentRating;
import com.fluentcommerce.dto.LocationType;
import com.fluentcommerce.dto.ProposedFulfilment;
import com.fluentcommerce.model.location.Location;
import com.fluentcommerce.model.order.Order;
import com.fluentcommerce.model.virtual.VirtualPosition;
import com.fluentcommerce.service.SettingService;
import com.fluentretail.rubix.exceptions.RubixException;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static com.fluentcommerce.util.Constants.DEFAULT_PROXIMITY_WEIGHTING_FACTOR;
import static com.fluentcommerce.util.Constants.DEFAULT_QUANTITY_WEIGHTING_FACTOR;
import static com.fluentcommerce.util.Constants.ErrorCode.ERROR_CODE_400;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_EXCLUDED_LOCATIONS;
import static com.fluentcommerce.util.Constants.Setting.SETTING_PROXIMITY_WEIGHTING_FACTOR;
import static com.fluentcommerce.util.Constants.Setting.SETTING_QUANTITY_WEIGHTING_FACTOR;
import static java.lang.Double.parseDouble;

@Slf4j
public class FulfilmentUtils {

    private static final String CLASS_NAME = FulfilmentUtils.class.getSimpleName();

    private FulfilmentUtils() {}

    /**
     /**
     * The method returns list of excluded locations.
     * <p>
     * Excluded locations are filled from:
     * </p>
     * <p>
     * <ul>
     * <li>locations from previously fulfiled items for this order</li>
     * <li>locations from incoming event attribute named excludedLocations </li>
     * </ul>
     * </p>
     * @param context
     * @param order
     * @return list of location references to exclude form inventory search graphql query
     */
    public static List<String> getExcludedLocationRefs(
        Context context,
        Order order) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        List<String> excludedLocationRefs = new ArrayList<>();
        if (order.getFulfilments() != null) {
            order.getFulfilments().forEach(fulfilmentEntity -> excludedLocationRefs.add(fulfilmentEntity.getFromAddressRef()));
        }
        if (null != context.getEvent().getAttributeList(EVENT_FIELD_EXCLUDED_LOCATIONS, String.class)) {
            final List<String> excludedLocationRefsFromEvent = context.getEvent().getAttributeList(
                EVENT_FIELD_EXCLUDED_LOCATIONS, String.class);
            log.info("{} - excluded locations refs from Event Attribute: {}", logPrefix, excludedLocationRefs);
            excludedLocationRefs.addAll(excludedLocationRefsFromEvent);
        }
        log.info("{} - Excluded Locations size: {},  Excluded Locations refs: {}", logPrefix,
            excludedLocationRefs.size(), excludedLocationRefs);
        return CollectionUtils.isEmpty(excludedLocationRefs) ? null : excludedLocationRefs;
    }

    public static Map<String, ProposedFulfilment> createProposedFulfilments(
        Context context,
        Map<String, Map<String, VirtualPosition>> locationRefProductRefVirtualPositionMap,
        Map<String, Location> locationsByLocationRef
    ) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        final Map<String, ProposedFulfilment> proposedFulfilmentsPerLocation = new HashMap<>();
        for (Map.Entry<String, Map<String, VirtualPosition>> entry : locationRefProductRefVirtualPositionMap.entrySet()) {
            Location location = locationsByLocationRef.get(entry.getKey());
            List<VirtualPosition> virtualPositions = new ArrayList<>(entry.getValue().values());
            proposedFulfilmentsPerLocation.put(
                location.getRef(),
                ProposedFulfilment.builder()
                    .locationRef(location.getRef())
                    .distance(location.getDistance())
                    .locationType(location.getType())
                    .virtualPositions(virtualPositions)
                    .build());
        }
        log.info("{} - number of proposed fulfilments: {}", logPrefix, proposedFulfilmentsPerLocation.size());
        return proposedFulfilmentsPerLocation;
    }

    /**
     *
     * @param virtualPositions
     * @param includedLocationsByLocationRef
     * @return
     */
    public static Map<String, Map<String, VirtualPosition>> getLocationRefVirtualPositionMap(
        List<VirtualPosition> virtualPositions, Map<String, Location> includedLocationsByLocationRef) {
        final Map<String, Map<String, VirtualPosition>> locationRefProductRefVirtualPositionMap =  new HashMap<>();
        for (VirtualPosition virtualPosition : virtualPositions) {
            // filter out virtual positions where the location is not included
            if (includedLocationsByLocationRef.get(virtualPosition.getGroupRef()) == null) {
                continue;
            }
            Map<String, VirtualPosition> productRefVirtualPositionMap =
                locationRefProductRefVirtualPositionMap.get(virtualPosition.getGroupRef());
            if (productRefVirtualPositionMap == null) {
                productRefVirtualPositionMap = new HashMap<>();
                locationRefProductRefVirtualPositionMap.put(virtualPosition.getGroupRef(), productRefVirtualPositionMap);
            }
            productRefVirtualPositionMap.put(virtualPosition.getProductRef(), virtualPosition);
        }
        return locationRefProductRefVirtualPositionMap;
    }

    /**
     *
     * @param locations
     * @return locations map - (locationRef,location)
     */
    public static Map<String, Location> getIncludedLocationsGroupedByLocationRef(
        Context context,
        final List<Location> locations,
        final List<String> locationExclusionRefs
    ) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        Map<String, Location> locationMap = new HashMap<>();
        for (Location location: locations){
            if (CollectionUtils.isEmpty(locationExclusionRefs)
                || !locationExclusionRefs.contains(location.getRef())){
                locationMap.put(location.getRef(), location);
            } else {
                log.info("{} - location with ref:{} has been excluded.", logPrefix, location.getRef());
            }
        }
        return locationMap;
    }

    /**
     * The method is responsible for calculating rating for each proposed fulfilment
     * and return it in descending order.
     *
     * @param context
     * @param inventory
     * @param unfulfilledItems
     * @param locationsByLocationRef
     * @param nearestLocationDistance
     * @return
     */
    public static NavigableMap<FulfilmentRating, ProposedFulfilment> getRatedProposedFulfilments(
        Context context,
        Map<String, ProposedFulfilment> inventory,
        Map<String, Integer> unfulfilledItems,
        Map<String, Location> locationsByLocationRef,
        Double nearestLocationDistance
        ) {

        if (MapUtils.isEmpty(inventory)) {
            return Collections.emptyNavigableMap();
        }
        final double proximityWeightingFactor = getProximityWeightingFactor(context);
        final double quantityWeightingFactor = getQuantityWeightingFactor(context);

        final NavigableMap<FulfilmentRating, ProposedFulfilment> ratedFulfilments = new TreeMap<>();
        inventory.forEach((locRef, proposedFulfilment) -> {
            final double proximityScore = calculateDistanceScore(context, nearestLocationDistance,
                locationsByLocationRef.get(locRef).getDistance(), proximityWeightingFactor);
            final double fulfilmentScore = calculateFulfilmentScore(context, unfulfilledItems,
                proposedFulfilment.getVirtualPositions(), quantityWeightingFactor);

            final FulfilmentRating fulfilmentRating = createFulfilmentRatingForFulfilment(
                locRef,
                fulfilmentScore,
                proximityScore
            );
            ratedFulfilments.put(fulfilmentRating, proposedFulfilment);
        });
        return ratedFulfilments;
    }

    /**
     * The Method calculates distance score by taking weightingFactor into account.
     * The score varies between 0 to weightingFactor
     *
     * Calculation: nearestDistance / locationDistance * weightingFactor
     *
     * (lowest distance will have maximum distance score)
     *
     * @param context
     * @param nearestDistance
     * @param locationDistance
     * @param weightingFactor
     * @return distance score for a location
     */
    public static Double calculateDistanceScore(Context context,
        Double nearestDistance,
        Double locationDistance,
        double weightingFactor) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());
        log.info("{} - Calculating distance score, nearestDistance :{} locationDistance :{} weightingFactor :{}",
            logPrefix, nearestDistance, locationDistance, weightingFactor);
        if (nearestDistance <= 0) {
            nearestDistance = 0.01;
        }
        Double distanceScore = (nearestDistance / locationDistance) * weightingFactor;
        log.info("{} - Calculated distance score:{}", logPrefix, nearestDistance, distanceScore);
        return distanceScore;
    }

    /**
     * The method Calculates Fulfilment score. The score varies between 0 to
     * weightingFactor
     *
     * Calculation : if inventory available Qty > requested quantity consider the
     * fulfilable fraction as 1 else calculate fulfillable fraction as available
     * qty/requested Qty. Score is calculated by taking an average of fulfillable
     * fractions and multiplied weightingFactor
     *
     * @param context
     * @param requiredItems
     * @param virtualPositions
     * @param weightingFactor
     * @return Fulfilment score for a location
     */
    public static Double calculateFulfilmentScore(
        Context context,
        Map<String, Integer> requiredItems,
        List<VirtualPosition> virtualPositions,
        double weightingFactor) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        final long totalOrderedQty = requiredItems.values().stream().mapToLong(Number::longValue).sum();

        log.info("{} - calculating fulfilment score where requiredItems : {}, virtualPositions:{} weightingFactor:{} "
                + "and total unfulfilled quantities: {}",
            logPrefix, requiredItems, virtualPositions, weightingFactor, totalOrderedQty);
        Double quantityFulfilment = 0d;
        for (final VirtualPosition virtualPosition : virtualPositions) {
            if (requiredItems.containsKey(virtualPosition.getProductRef())) {
                final Integer availableQty = virtualPosition.getQuantity();
                if (availableQty < requiredItems.get(virtualPosition.getProductRef())) {
                    quantityFulfilment += (double) availableQty / totalOrderedQty;
                } else if (availableQty >= requiredItems.get(virtualPosition.getProductRef())) {
                    quantityFulfilment += (double) requiredItems.get(virtualPosition.getProductRef()) / totalOrderedQty;
                }
            }
        }
        log.info("{} - calculated fulfilment score :{}", logPrefix, (quantityFulfilment * weightingFactor));
        return quantityFulfilment * weightingFactor;
    }


    /**
     *
     * @param locationRef
     * @param fulfilmentScore
     * @param proximityScore
     * @return
     */
    private static FulfilmentRating createFulfilmentRatingForFulfilment(
        String locationRef,
        double fulfilmentScore,
        double proximityScore) {

        final FulfilmentRating fulfilmentRating = FulfilmentRating.builder()
            .locRef(locationRef)
            .rating(fulfilmentScore > 0 ? proximityScore + fulfilmentScore : 0)
            .build();
        return fulfilmentRating;
    }

    /**
     * @param context
     * @return
     */
    public static double getQuantityWeightingFactor(Context context) {
        SettingService settingService = new SettingService(context);
        return parseDouble(
            settingService.getSettingValue(SETTING_QUANTITY_WEIGHTING_FACTOR, DEFAULT_QUANTITY_WEIGHTING_FACTOR));
    }

    /**
     * @param context
     * @return
     */
    public static double getProximityWeightingFactor(Context context) {
        SettingService settingService = new SettingService(context);
        return parseDouble(
            settingService.getSettingValue(SETTING_PROXIMITY_WEIGHTING_FACTOR, DEFAULT_PROXIMITY_WEIGHTING_FACTOR));
    }

    public static String getFulfilmentType(Order order, String locationType) {
        String fulfilmentType;
        switch (order.getType()) {
            case com.fluentretail.api.model.order.Order.Type.ClickAndCollect:
            case com.fluentretail.api.model.order.Order.Type.HomeDelivery:
                fulfilmentType = order.getType() + "_" + getSuffixAsPerLocationType(order, locationType);
                break;
            default:
                throw new RubixException(ERROR_CODE_400, "Invalid order type " + order.getType());
        }
        return fulfilmentType;
    }

    public static String getSuffixAsPerLocationType(Order order, String locationType) {
        if (StringUtils.equalsIgnoreCase(locationType, LocationType.STORE.name())) {
            return LocationType.STORE.getValue();
        } else if (StringUtils.equalsIgnoreCase(locationType, LocationType.WAREHOUSE.name())) {
            return LocationType.WAREHOUSE.getValue();
        } else {
            throw new RubixException(ERROR_CODE_400, "Invalid location type" + locationType);
        }
    }
}
