package com.digiwes.common.enums;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public enum CommonErrorEnum {
    SUCCESS(0,"SUCCESS"),
    TIME_IS_NULL(1,"Time is null."),
    VALIDFOR_IS_NULL(2,"validFor is null");
    private int value;
    private String name;

    CommonErrorEnum(int value, String name) {
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
        for (CommonErrorEnum c : CommonErrorEnum.values()) {
            if (value == c.getValue()) {
                return c.name;
            }
        }
        return "";
    }
}
