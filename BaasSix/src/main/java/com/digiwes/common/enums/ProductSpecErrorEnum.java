package com.digiwes.common.enums;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public enum ProductSpecErrorEnum {
    SPEC_NAME_IS_NULL(286064640, "name is null or empty"),
    PROD_SPEC_IS_NULL(286064641, "productSpecification is null"),
    PROD_SPEC_RELATIONSHIP_TYPE_IS_NULL(286064642, "product specification relationshipType is null"),
    PROD_SPEC_EQUALS_TO_CURRENT(286064643, "the designated productSpecification equal to current productSpecification"),
    PROD_SPEC_HAS_RELATED_TO_CURRENT(286064644, "the designated productSpecification equal to current value"),
    PROD_SPEC_CHAR_IS_NULL(286064645, "Char is null"),
    PROD_SPEC_CHAR_MAX_LESS_THAN_MIN(286064646, "maxCardinality is less than minCardinality"),
    PROD_SPEC_CHAR_TYPE_DIFFERENT_CHAR_VALUE_TYPE(286064647, "The valueType of Character and the valueType of " +
            "CharacterValue are the same"),
    PROD_SPEC_CHAR_VALUE_IS_NULL(286064648, "charVal is null"),
    PROD_SPEC_CHAR_VALUE_NOT_BELONG_TO_CHAR(286064649, "The charValue do not belong to this char"),
    PROD_SPEC_CHAR_HAS_NO_CHAR_VALUE(286064650, "no charValue under the current char"),
    PROD_SPEC_CHAR_RELATIONSHIP_TYPE_IS_NULL(286064651, "relationshipType is null"),
    PROD_SPEC_CHAR_EQUALS_TO_CURRENT(286064652, "the designated productSpecCharacteristic equal to current value"),
    PROD_SPEC_CHAR_HAS_RELATED_TO_CURRENT(286064653, "Characteristic has been established associate relationship in " +
            "the specified time"),
    CHAR_USE_NAME_IS_NULL(286064654, "char use name is null"),
    THE_CHAR_HAS_EXISTS_INSPEC(286064655, "the spec has already use the char"),
    THE_SPEC_NO_USE_CHAR(286064656, "the spec no use any char "),
    THE_SPEC_NO_USE_THE_CHAR(286064657, "the spec no use any char "),
    THE_SPEC_CHAR_HAS_USE_THE_VALUE(286064658, "the spec no use any char "),
    THE_SPEC_NO_USE_VALUE(286064659, "the spec no use any char "),
    VALUE_RELATIONSHIP_EXISTING(286064660,"Characteristic value relationship has exists"),
    CHAR_RELATIONSHIP_IS_NULL(286064661,"Characteristic value relationship has exists"),
    PROD_CHAR_USE_HAS_EXISTS_THE_VALUE(286064662,"Characteristic value relationship has exists"),
    THE_CHAR_NOT_EXISTS_THE_VALUE(286064663,"Characteristic value relationship has exists"),
    PROD_CHAR_USE_NOT_USE_THE_VALUE(286064664,"Characteristic value relationship has exists");



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
