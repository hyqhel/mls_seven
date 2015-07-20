package com.digiwes.resources.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int code;//返回 0：失败；1：成功

	private T data;//具体的对的数据
	
	private String message;//错误时消息

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultData() {
		super();
	}

	public ResultData(int status, T data, String message) {
		super();
		this.code = status;
		this.data = data;
		this.message = message;
	}

}
