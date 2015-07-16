package com.digiwes.common.enums;

/**
 * Created by liuwei29 on 2015/7/16.
 */
public enum ProdSpecType {

    TEXT("1", "ÎÄ±¾"),
    NUMERIC("2", "Êý×Ö"),
    FORTH("3", "FORTH");
    private String value;
    private String name;

    ProdSpecType(String value, String name) {
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
        for (ProdSpecType c : ProdSpecType.values()) {
            if (c.getValue().equals(value)) {
                return c.name;
            }
        }
        return "";
    }
}
