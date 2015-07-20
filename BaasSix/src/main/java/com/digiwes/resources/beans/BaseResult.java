package com.digiwes.resources.beans;

import java.io.Serializable;

/**
 * Created by huangyq3 on 2015-07-20.
 */
public class BaseResult implements Serializable  {

    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseResult() {
        super();
    }

    public BaseResult(int status, String message) {
        super();
        this.code = status;
        this.message = message;
    }
}
