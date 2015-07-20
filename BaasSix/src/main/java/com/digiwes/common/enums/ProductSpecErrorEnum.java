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
    PROD_SPEC_CHAR_TYPE_DIFFERENT_CHAR_VALUE_TYPE(286064646, "The valueType of Character and the valueType of " +
            "CharacterValue are the same"),
    PROD_SPEC_CHAR_VALUE_NOT_BELONG_TO_CHAR(286064647, "The charValue do not belong to this char"),
    PROD_SPEC_CHAR_HAS_NO_CHAR_VALUE(286064648, "no charValue under the current char"),
    PROD_SPEC_CHAR_EQUALS_TO_CURRENT(286064649, "the designated productSpecCharacteristic equal to current value"),
    CHAR_USE_NAME_IS_NULL(286064650, "char use name is null"),

    //spec char
    SPEC_NO_CHAR(286064651, "spec no char "),
    SPEC_ALREADY_EXISTS_THE_CHAR(286064652, "spec has already use the char"),
    SPEC_NO_USE_THE_CHAR(286064653, "the spec no use  the char "),
    SPEC_NO_CHAR_VALUE(286064654, "the spec no use char value "),
    SPEC_CHAR_ALREADY_USE_THE_VALUE(286064655, "spec characteristic value already the value"),
    SPEC_CHAR_NOT_USE_THE_VALUE(286064656, "spec characteristic  not use the value"),
    //char
    CHAR_ALREADY_USE_THE_VALUE(286064657, "the Characteristic already use the value "),
    CHAR_VALUE_RELATIONSHIP_EXISTING(286064658, "Characteristic value relationship has exists"),
    CHAR_RELATIONSHIP_IS_NULL(286064659, "Characteristic  relationship null"),
    CHAR_NOT_EXISTS_THE_VALUE(286064660, "Characteristic not exists the value"),
    CHAR_NO_VALUE(286064661, "Characteristic not exists the value"),
    CHAR_IS_NULL(286064662, "Characteristic is null"),
    CHAR_VALUE_IS_NULL(286064663, "Characteristic is null"),
    CHAR_RELATIONSHIP_TYPE_IS_NULL(286064664, "relationshipType is null"),
    MAX_CARDINALITY_LESS_THAN_MIN_CARDINALITY(286064665, "maxCardinality is less than minCardinality"),
    ASSOCIATE_REPETITIVE_CHAR(286064666, "Characteristic has been established associate " +
            "relationship in the specified time");


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
