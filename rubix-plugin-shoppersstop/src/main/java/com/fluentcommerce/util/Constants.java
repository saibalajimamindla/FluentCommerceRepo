package com.fluentcommerce.util;

import java.text.SimpleDateFormat;

/**
 * Use this class to define all the constants you will use in your rules.
 */
public final class Constants {

    private Constants() { }

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public static final Integer ZERO = 0;
    public static final int BD_SCALE = 2;
    public static final String DECIMAL_FORMAT_PATTERN = ",###.00";
    public static final String TILDE = "~";
    public static final String RADIUS = "radius";
    public static final String DISTANCE = "distance";
    public static final String PICKUP_LOCATION_REF = "pickupLocationRef";
    public static final Integer METER_TO_KILOMETER_FACTOR = 1000;

    public static final int DEFAULT_PAGE_SIZE = 100;
    public static final int DEFAULT_GI_PAGE_SIZE = 1000;
    public static final int DEFAULT_HALF_PAGE_SIZE = 50;
    public static final String DEFAULT_QUANTITY_WEIGHTING_FACTOR ="50";
    public static final String DEFAULT_PROXIMITY_WEIGHTING_FACTOR ="50";


    public interface Setting {
        String SETTING_QUANTITY_WEIGHTING_FACTOR ="QUANTITY.WEIGHTING.FACTOR";
        String SETTING_PROXIMITY_WEIGHTING_FACTOR ="PROXIMITY.WEIGHTING.FACTOR";
        String SETTING_EMAIL_SERVICE_CONFIG = "EMAIL.SERVICE.CONFIG";
        String SETTING_EMAIL_SERVICE_CONFIG_MANDILL_KEY = "MANDRILL_PROD_KEY";
        String SETTING_CONTEXT_AGENT = "AGENT";
        String SETTING_CONTEXT_RETAILER = "RETAILER";
        String SETTING_CONTEXT_ACCOUNT = "ACCOUNT";
        String SETTING_CONTEXT_GLOBAL = "GLOBAL";
        String SETTING_CONTEXT_ACCOUNT_ID = "0";
        String SETTING_CONTEXT_GLOBAL_ID = "0";
        String SETTING_GEOCODER_API_KEY_SETTING = "GEOCODER.API";
        String DEFAULT_GEOCODER_API_KEY = "";
    }

    public interface ErrorCode {
        Integer ERROR_CODE_400 = 400;
        Integer ERROR_CODE_404 = 404;
        String EXCEPTION_TYPE = "exception_type";
        String EXCEPTION_MESSAGE = "exception_message";
    }

    public interface EntityType {
        String ENTITY_TYPE_INVENTORY_CATALOGUE = "INVENTORY_CATALOGUE";
        String ENTITY_TYPE_INVENTORY_QUANTITY = "INVENTORY_QUANTITY";
        String ENTITY_TYPE_INVENTORY_POSITION = "INVENTORY_POSITION";

        String ENTITY_TYPE_CATEGORY = "CATEGORY";
        String ENTITY_TYPE_PRODUCT = "PRODUCT";
        String ENTITY_TYPE_PRODUCT_CATALOGUE = "PRODUCT_CATALOGUE";
        String ENTITY_TYPE_STANDARD_PRODUCT = "STANDARD_PRODUCT";
        String ENTITY_TYPE_VARIANT_PRODUCT = "VARIANT_PRODUCT";
        String ENTITY_TYPE_VIRTUAL_CATALOGUE = "VIRTUAL_CATALOGUE";
        String ENTITY_TYPE_VIRTUAL_POSITION = "VIRTUAL_POSITION";

        String ENTITY_TYPE_ORDER = "ORDER";
        String ENTITY_TYPE_FULFILMENT = "FULFILMENT";
        String ENTITY_TYPE_ARTICLE = "ARTICLE";
        String ENTITY_TYPE_CONSIGNMENT = "CONSIGNMENT";

        String ENTITY_TYPE_LOCATION = "LOCATION";
        String ENTITY_TYPE_WAVE = "WAVE";

        String ENTITY_TYPE_FULFILMENT_PLAN = "FULFILMENT_PLAN";
        String ENTITY_TYPE_FULFILMENT_OPTIONS = "FULFILMENT_OPTIONS";
    }
    public interface EntitySubType {
        String ENTITY_SUBTYPE_ORDER_CC = "CC";
        String ENTITY_SUBTYPE_ORDER_HD = "HD";
    }

    public interface PropertyField {
        String PROP_EVENT_NAME = "eventName";
        String PROP_EVENT_NAME_IF_LOCATION_EXISTS= "responseEventIfLocationExists";
        String PROP_EVENT_NAME_IF_LOCATION_NOT_EXISTS = "responseEventIfLocationNotExists";
        String PROP_FULFILMENT_ITEMS ="fulfilmentItems";
        String PROP_LOCATION_REFS = "locationRefs";
        String PROP_LOCATION_STATUSES = "locationStatuses";
        String PROP_LOCATION_PICKUP_RADIUS = "locationPickupRadius";
        String PROP_NETWORK_REF = "networkRef";
        String PROP_STATE = "state";
        String PROP_VIRTUAL_CATALOGUE_REF = "virtualCatalogueRef";
        String LOCATION_REF = "LocationRef";

        String PROP_RETRY_FULFILMENT_EVENT = "retryFulfilmentEvent";
        String PROP_TERMINATE_FULFILMENT_EVENT= "terminateFulfilmentEvent";
        String PROP_MAX_SPLIT_LIMIT = "maxSplitLimit";
        String PROP_EXCLUDED_FULFILMENT_STATUSES = "excludedFulfilmentStatuses";
        String PROP_DEFAULT_VARIANT_PRODUCT_REF = "defaultVariantProductRef";
        String PROP_PRODUCT_CATALOGUE_REF = "productCatalogueRef";
        String PROP_NO_LOCATION_FOUND_EVENT = "noLocationFoundEvent" ;

        String PROP_STATUSES = "statuses";
        String PROP_STATUS = "status";
        String PROP_ATTRIBUTE_NAME = "attributeName";
        String PROP_ATTRIBUTE_VALUE = "attributeValue";
        String PROP_NO_MATCH_EVENT_NAME = "noMatchEventName";
        String PROP_QUANTITY = "quantity";

        String PROP_DEFAULT_ETA = "defaultEta";
        String PROP_ORDER_TYPE = "orderType";

        String PROP_EMAIL_CONFIG_SETTING = "emailTemplate";
        String PROP_VALID_ADDRESS_EVENT_NAME = "validAddress";
        String PROP_INVALID_ADDRESS_EVENT_NAME = "invalidAddress";
        String PROP_MISSING_ADDRESS_EVENT_NAME = "missingAddress";


        String PROP_PICK_N_PACK_TIME_LIMIT_SETTING = "pickAndPackTimeLimitSetting";


        String PROP_WEBHOOK_NAME = "webhookName";
        String PROP_WEBHOOK_ENDPOINT = "webhookEndpoint";


        String PROP_PICK_N_PACK_TIME_LIMIT_SETTING_SD = "pickAndPackTimeLimitSDSetting";
        String PROP_PICK_N_PACK_TIME_LIMIT_SETTING_ED = "pickAndPackTimeLimitEDSetting";
        String PROP_PICK_N_PACK_TIME_LIMIT_SETTING_HLD = "pickAndPackTimeLimitHLDSetting";

        String SD_EVENT_NAME = "standardDeliveryEvent";
        String ED_EVENT_NAME = "expressDeliveryEvent";


        String STANDARD_DELIVERY_TYPE = "standardDeliveryValue";
        String Express_DELIVERY_TYPE = "expressDeliveryValue";

        String PROP_EVENT_NAME_IF_VIRTUAL_POSITIONS_EXISTS= "responseEventIfVirtualPositionsExists";
        String PROP_EVENT_NAME_IF_VIRTUAL_POSITIONS_NOT_EXISTS = "responseEventIfVirtualPositionsNotExists";
        String LOCATION_TYPE = "expressDeliveryValue";
    }

    public interface EventField {
        String EVENT_FIELD_ATTRIBUTES = "attributes";
        String EVENT_FIELD_EXCLUDED_LOCATIONS = "excludedLocations";

        String EVENT_FIELD_LOCATIONS = "locations";
        String SD_EVENT_FIELD_LOCATIONS = "sdLocations";
        String EVENT_FIELD_PROPOSED_FULFILMENT = "proposedFulfilment";
        String EVENT_FIELD_PROPOSED_FULFILMENTS = "proposedFulfilments";
        String SD_EVENT_FIELD_PROPOSED_FULFILMENTS = "sdProposedFulfilments";
        String EVENT_FIELD_FULFILMENT_PLANS = "fulfilmentPlans";
        String SD_EVENT_FIELD_FULFILMENT_PLANS = "sdFulfilmentPlans";
        String EVENT_FIELD_CREATED_FULFILMENT_PLANS = "createdFulfilmentPlans";
        String EVENT_FIELD_VIRTUAL_POSITIONS = "virtualPositions";
        String SD_EVENT_FIELD_VIRTUAL_POSITIONS = "sdVirtualPositions";
        String EVENT_FIELD_PRODUCT_FILTER_CRITERIA = "productFilterCriteria";
        String EVENT_FIELD_EMAIL_COMMAND = "emailCommand";
        String EVENT_FIELD_UPSERT_LOCATION_DTO = "locationDTO";
        String EVENT_FIELD_LOCATION_ENTITY = "locationEntity";
        String EVENT_FIELD_FULFILMENT_TYPE_CC_PFS = "CC_PFS";
        String EVENT_FIELD_FULFILMENT_TYPE_CC_PFCP = "CC_PFCP";
        String EVENT_FIELD_FULFILMENT_TYPE = "FulfilmentType";
        String EVENT_FIELD_PRODUCTS = "products";
        String EVENT_FIELD_REF = "ref";
        String EVENT_FIELD_TYPE = "type";
        String EVENT_FIELD_ADDRESS_LINE1 = "addressLine1";
        String EVENT_FIELD_ADDRESS_LINE2 = "addressLine2";
        String EVENT_FIELD_CITY = "city";
        String EVENT_FIELD_STATE = "state";
        String EVENT_FIELD_POSTCODE = "postcode";
        String EVENT_FIELD_COUNTRY = "country";
        String EVENT_FIELD_LONGITUDE= "longitude";
        String EVENT_FIELD_LATITUDE = "latitude";
        String EVENT_FIELD_ORDER_TYPE = "orderType";
        String EVENT_FIELD_PICKUP_LOCATION_REF = "pickupLocationRef";
        String EVENT_FIELD_TRANSACTION_ID = "transactionId";
        String EVENT_FIELD_TRANSACTION_CODE = "transactionCode";
    }
    public interface Status {
        String STATUS_FULFILLED = "FULFILLED";
        String STATUS_PARTIALLY_FULFILLED = "PARTIALLY_FULFILLED";
        String STATUS_REJECTED = "REJECTED";
    }

    public interface AttributeType {
        String STRING_TYPE = "STRING";
        String DOUBLE_TYPE = "DOUBLE";
    }
}
