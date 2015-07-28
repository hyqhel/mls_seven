package com.digiwes.common.enums;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public enum ProductCatalogErrorEnum {
    PUBLISH_REPETITIVE_OFFERING(285736960, "Cannot publish the repetitive Offering!"),
    RETIRED_REPETITIVE_OFFERING(285736961, "the Object of ProductOffering Has not been published to the " +
            "ProductCatalog."),
    IS_NOT_PUBLISH_OFFERING(285736962, "the Object of ProductOffering Has not been published in the ProductCatalog."),
    PRODUCT_CATALOG_IS_NULL(285736963, "catalog is null!"),
    PUBLISH_INVALID_OFFERING(285736964, "the offering is invalid"),
    PUBLISH_VALIDFOR_INVALID(285736965, "publish validFor is invalid");

    private int code;
    private String message;

    ProductCatalogErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static String getMessage(int code) {
        for (ProductCatalogErrorEnum c : ProductCatalogErrorEnum.values()) {
            if (code == c.getCode()) {
                return c.message;
            }
        }
        return "";
    }
}
