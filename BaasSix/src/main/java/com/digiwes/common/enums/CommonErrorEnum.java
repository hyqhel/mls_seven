package com.digiwes.common.enums;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public enum CommonErrorEnum {
    SUCCESS(0, "SUCCESS"),
    VALIDFOR_IS_NULL(1, "the validFor is null."),
    TIME_IS_NULL(2, "the time is null");
    private int code;
    private String message;

    CommonErrorEnum(int code, String message) {
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
        for (CommonErrorEnum c : CommonErrorEnum.values()) {
            if (code == c.getCode()) {
                return c.message;
            }
        }
        return "";
    }
}
