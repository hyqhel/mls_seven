package com.digiwes.common.enums;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public enum ProductOfferingErrorEnum {
    OFFERING_NAME_IS_NULL(285605888, "name is null or empty"),
    OFFERING_IS_NULL(285605889, "offering is null or empty"),
    OFFERING_RELATIONSHIP_TYPE_IS_NULL(285605890, "productOffering relationshipType is null or empty"),
    OFFERING_RELATIONSHIP_EXISTING(285605891, "the relationship already exist as the same timePeriod. Cannot associate " +
            "relationship again."),
    OFFERING_ASSOCIATE_ITSELF(285605892, "Cannot associate relationship with itself!"),
    NUMBER_REL_OFFER_LIMIT_INVALID(285605892, "Parameter [lowerLimit]、[upperLimit] is not valid."),
    LOWERLIMIT_GREATER_UPPERLIMIT(285605893, "the lowLimit must be much lower than upperLimit."),
    COMPOSE_REPETITIVE_OFFERING(285605894, "Cannot compose the repetitive Offering!"),
    BUNDLE_OFFERING_NOT_EXISTS_OFFERING(285605895, "the bundle offering not exists the offering!");

    private int code;
    private String message;

    ProductOfferingErrorEnum(int code, String message) {
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
        for (ProductOfferingErrorEnum c : ProductOfferingErrorEnum.values()) {
            if (code == c.getCode()) {
                return c.message;
            }
        }
        return "";
    }
}
