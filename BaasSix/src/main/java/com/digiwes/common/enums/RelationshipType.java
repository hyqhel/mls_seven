package com.digiwes.common.enums;

/**
 * Created by liuwei29 on 2015/7/16.
 */
public enum RelationshipType {
    AGGREGATION("1", "�ۺ�"),
    DEPENDENCY("2", "����"),
    MIGRATION("3", "Ǩ��"),
    SUBSTITUTION("4", "�滻"),
    EXCLUSIVITY("5", "����");
    private String value;
    private String name;

    RelationshipType(String value, String name) {
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
        for (RelationshipType c : RelationshipType.values()) {
            if (c.getValue().equals(value)) {
                return c.name;
            }
        }
        return "";
    }
}
