package com.digiwes.resources.beans;

import java.util.*;

public class ResultResponse {

    private String message;
    private int code;
    private List<ProdCatalogOffering> prodCatalogOfferings;

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

    public List<ProdCatalogOffering> getProdCatalogOfferings() {
        return this.prodCatalogOfferings;
    }

    public void setProdCatalogOfferings(List<ProdCatalogOffering> prodCatalogOfferings) {
        this.prodCatalogOfferings = prodCatalogOfferings;
    }

}