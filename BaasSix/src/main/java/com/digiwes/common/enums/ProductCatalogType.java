package com.digiwes.common.enums;

/**
 * Created by liuwei29 on 2015/7/16.
 */
public enum ProductCatalogType {
    WEB("1", "web"),
    BOOK("2", "book");
    private String value;
    private String name;

    ProductCatalogType(String value, String name) {
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
        for (ProductCatalogType c : ProductCatalogType.values()) {
            if (c.getValue().equals(value)) {
                return c.name;
            }
        }
        return "";
    }
}
