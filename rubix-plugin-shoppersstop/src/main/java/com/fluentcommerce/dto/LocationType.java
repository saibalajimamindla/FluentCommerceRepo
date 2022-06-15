package com.fluentcommerce.dto;

/**
 * @author Holger
 */
public enum LocationType {

    STORE("PFS"),

    WAREHOUSE("PFDC");

    private final String pickType;

    LocationType(String pickType) {
        this.pickType = pickType;
    }

    public String getValue() {
        return pickType;
    }

}
