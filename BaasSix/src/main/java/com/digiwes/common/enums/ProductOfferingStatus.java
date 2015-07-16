package com.digiwes.common.enums;

/**
 * Created by liuwei29 on 2015/7/16.
 */
public enum ProductOfferingStatus {

    PLANNED("0", "PLANNED"),
    OBSOLETE("1", "OBSOLETE"),
    ACTIVE("2", "ACTIVE");
    private String value;
    private String name;

    ProductOfferingStatus(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static String getName(String value) {
        for (ProductOfferingStatus c : ProductOfferingStatus.values()) {
            if (c.getValue().equals(value)) {
                return c.name;
            }
        }
        return "";
    }
}
