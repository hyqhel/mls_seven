package com.digiwes.common.enums;

/**
 * Created by huangyq3 on 2015-07-16.
 */
public enum CommonErrorEnum {
    SUCCESS(200, "SUCCESS"),
    VALIDFOR_IS_NULL(1, "the validFor is null."),
    TIME_IS_NULL(2, "the time is null"),
    START_TIME_GREATER_THAN_END_TIME(3, "endDateTime must not be less than startDateTime."),
    START_TIME_LESS_THAN_CURRENT_TIME(4, "startDateTime must be less than currentTime.");
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
