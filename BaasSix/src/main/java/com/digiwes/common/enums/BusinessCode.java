package com.digiwes.common.enums;

public enum BusinessCode {
    SUCCESS(0, "SUCCESS"),
    COMMON_CATALOG_ID_IS_NULL(0x8401,"Catalog ID must not be null"),
    PROD_OFFERING_NAME_IS_NULL_OR_EMPTY(0x2601,"name is null or empty"),
    PROD_OFFERING_IS_NULL(0x2602,"offering is null or empty"),
    PROD_OFFERING_RELATIONSHIP_TYPE_IS_NULL_OR_EMPTY(0x2603,"relationshpType is null or empty"),
    PROD_OFFERING_RELATIONSHIP_EXISTED(0x2604,"relationship is already existing"),
    PROD_OFFERING_ASSOCIATE_WITH_ITSELF(0x2605,"Its associated himself"),
    PROD_OFFERING_BUNDLED_OPTION_LOWERLIMIT_GT_UPPERLIMIT(0x2606,"lowerlimit is greater than upperlimit"),
    PROD_OFFERING_BUNDLED_OFFERING_EXISTED(0x2607,"bundledProdOffering is already composed of offering"),
    PROD_OFFERING_IS_INVALID(0x2608,"Offering is invalid"),
    PROD_OFFERING_CATALOG_OFFERING_HAS_BEEN_PUBLISHED(0x2609,"offering has been published"),
    PROD_OFFERING_PUBLISHED_STARTTIME_LT_CURRENT(0x260A,"publish offering's validFor is invalid"),
    PROD_OFFERING_CATALOG_OFFERING_NOT_BE_PUBLISHED(0x260B,"offering has not be published"),
    PROD_OFFERING_PUBLISHED_VALIDPERIOD_NOT_IN_OFFERING_VALIDPERIOD(0x260C,"publish offering validFor is invalid"),
    PROD_SPEC_NAME_IS_NULL_OR_EMPTY(0x2501,"ProductSpecification name is null or empty"),
    PROD_SPEC_SPEC_IS_NULL(0x2502,"ProductSpecification is null"),
    PROD_SPEC_RELATIONSHIP_TYPE_IS_NULL(0x2503,"relationshipType is null"),
    PROD_SPEC_COMPOSE_OF_ITSELF(0x2504,"The composed ProductSpecification is itself"),
    PROD_SPEC_ASSOCIATE_WITH_ITSELF(0x2505,"The associate ProductSpecificaton is itself"),
    PROD_SPEC_RELATIONSHIP_EXISTED(0x2506,"the designated productSpecification has be associated"),
    PROD_SPEC_CHAR_IS_NULL(0x2507,"Char is null"),
    PROD_SPEC_CHAR_CARDINALITY_MAX_LT_MIN(0x2508,"MaxCardinality is less than minCardinality"),
    PROD_SPEC_CHAR_VALUETYPE_DIFF_FROM_VALUE_VALUETYPE(0x2509,"The valueType of Character and the valueType of CharacterValue are the same"),
    PROD_SPEC_CHAR_VALUE_IS_NULL(0x250A,"charVal is null"),
    PROD_SPEC_CHAR_VALUE_NOT_BELONG_TO_CHAR(0x250B,"The charValue do not belong to this char"),
    PROD_SPEC_CHAR_HAS_NO_CHAR_VALUE(0x250C,"No charValue under the current char"),
    PROD_SPEC_CHAR_RELATIONSHIP_TYPE_IS_NULL(0x250D,"relationshipType is null"),
    PROD_SPEC_CHAR_ASSOCIATE_WITH_ITSELF(0x250E,"The designated productSpecCharacteristic equal to current value"),
    PROD_SPEC_CHAR_RELATIONSHIP_EXISTED(0x250F,"Characteristic has been established associate relationship in the specified time"),
    PROD_SPEC_CHAR_VALUE_RELATIONSHIP_TYPE_IS_NULL(0x2510,"relationshipType is null"),
    PROD_SPEC_CHAR_VALUE_ASSOCIATE_WITH_ITSELF(0x2511,"The designated productSpecCharacteristicValue equal to current value"),
    PROD_SPEC_CHAR_VALUE_RELATIONSHIP_EXISTED(0x2512,"CharacteristicValue has been established associate relationship in the specified time"),
    PROD_SPEC_CHAR_USE_NAME_IS_NULL_OR_EMPTY(0x2513,"ProductSpecCharUse's name is null or empty"),
    PROD_SPEC_CHAR_USE_VALIDPERIOD_NOT_IN_CHAR_VALIDPERIOD(0x2514,"The specify time not belong of ProductSPecifcationChar's validFor"),
    PROD_SPEC_CHAR_HAS_BEEN_ATTACHED_TO_SPEC(0x2515,"The ProductSpecification has the Characteristic"),
    PROD_SPEC_CHAR_VALUE_USE_VALIDPERIOD_NOT_IN_CHAR_VALUE_VALIDPERIOD(0x2516,"The specify time not belong of ProductSPecifcationCharValue's validFor"),
    PROD_SPEC_NOT_ATTACH_CHAR(0x2517,"The Characteristic is not used by the ProductSpecification"),
    PROD_SPEC_CHAR_NOT_INCLUDE_VALUE(0x2518,"The char not include this value"),
    PROD_SPEC_CHAR_VALUE_EXISTED(0x251A,"prodSpecCharValue has been used");

    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    /**
     *
     * @param code
     * @param message
     */
    BusinessCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}