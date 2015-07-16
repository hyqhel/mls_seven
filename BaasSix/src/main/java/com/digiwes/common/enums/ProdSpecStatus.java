package com.digiwes.common.enums;

/**
 * Created by liuwei29 on 2015/7/16.
 */
public enum ProdSpecStatus {

    STATUS_INACTIVE("0", "����Ծ"),
    STATUS_ACTIVE("1", "��Ծ"),
    STATUS_PLANED("2", "�ƻ���");
    private String value;
    private String name;

    ProdSpecStatus(String value, String name) {
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
        for (ProdSpecStatus c : ProdSpecStatus.values()) {
            if (c.getValue().equals(value)) {
                return c.name;
            }
        }
        return "";
    }
}
