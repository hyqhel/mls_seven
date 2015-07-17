package com.digiwes.resources.beans;

import com.digiwes.basetype.*;

import java.util.List;

public class FindOfferingRequest {

    private List<Condition> condition;
    private String productCatalogId;

    public List<Condition> getCondition() {
        return condition;
    }

    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }

    public String getProductCatalogId() {
        return productCatalogId;
    }

    public void setProductCatalogId(String productCatalogId) {
        this.productCatalogId = productCatalogId;
    }
}