package com.digiwes.common.enums;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public enum ProductCatalogErrorEnum {
    SUCCESS(0,"SUCCESS");
    private int value;
    private String name;

    ProductCatalogErrorEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static String getName(int value) {
        for (ProductCatalogErrorEnum c : ProductCatalogErrorEnum.values()) {
            if (value == c.getValue()) {
                return c.name;
            }
        }
        return "";
    }
}
