package com.digiwes.resources.beans;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultResponse {

    private String message;
    private int code;
    private ProductCatalogResponse productCatalogResponse;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ProductCatalogResponse getProductCatalogResponse() {
        return productCatalogResponse;
    }

    public void setProductCatalogResponse(ProductCatalogResponse productCatalogResponse) {
        this.productCatalogResponse = productCatalogResponse;
    }
}