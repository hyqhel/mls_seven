package com.digiwes.common.enums;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public enum ProductSpecErrorEnum {
    PROD_SPEC_NAME_IS_NULL_OR_EMPTY(1001, "name is null or empty"),
    PROD_SPEC_IS_NULL(1004, "productSpecification is null"),
    PROD_SPEC_RELATIONSHIP_TYPE_IS_NULL(1003, "relationshipType is null"),
    PROD_SPEC_EQUALS_TO_CURRENT(1005, "the designated productSpecification equal to current value"),
    PROD_SPEC_HAS_RELATED_TO_CURRENT(1006, "the designated productSpecification equal to current value"),
    PROD_SPEC_CHAR_IS_NULL(1007, "Char is null"),
    PROD_SPEC_CHAR_MAX_LESS_THAN_MAX(1008, "maxCardinality is less than minCardinality"),
    PROD_SPEC_CHAR_TYPE_DIFFERENT_CHAR_VALUE_TYPE(1009, "The valueType of Character and the valueType of CharacterValue are the same"),
    PROD_SPEC_CHAR_VALUE_IS_NULL(1010, "charVal is null"),
    PROD_SPEC_CHAR_VALUE_NOT_BELONG_TO_CHAR(1011, "The charValue do not belong to this char"),
    PROD_SPEC_CHAR_HAS_NO_CHAR_VALUE(1012, "no charValue under the current char"),
    PROD_SPEC_CHAR_RELATIONSHIP_TYPE_IS_NULL(1013, "relationshipType is null"),
    PROD_SPEC_CHAR_EQUALS_TO_CURRENT(1014, "the designated productSpecCharacteristic equal to current value"),
    PROD_SPEC_CHAR_HAS_RELATED_TO_CURRENT(1015, "Characteristic has been established associate relationship in the specified time");
    private int code;
    private String message;

    ProductSpecErrorEnum(int code, String message) {
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
        for (ProductSpecErrorEnum c : ProductSpecErrorEnum.values()) {
            if (code == c.getCode()) {
                return c.message;
            }
        }
        return "";
    }
}
