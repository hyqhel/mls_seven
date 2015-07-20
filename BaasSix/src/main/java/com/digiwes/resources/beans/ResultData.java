package com.digiwes.resources.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultData<T>  extends BaseResult implements Serializable{

    private static final long serialVersionUID = 1L;
    
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}



	public ResultData() {
		super();
	}

	public ResultData( T data) {
		super();

		this.data = data;
	}

}
