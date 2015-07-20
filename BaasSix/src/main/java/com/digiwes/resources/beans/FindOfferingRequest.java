package com.digiwes.resources.beans;

import com.digiwes.basetype.*;
import com.digiwes.common.util.DateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

public class FindOfferingRequest {

    private List<Condition> condition;
    private String productCatalogId;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date retrieveTime;

    public Date getRetrieveTime() {
        return retrieveTime;
    }

    public void setRetrieveTime(Date retrieveTime) {
        this.retrieveTime = retrieveTime;
    }

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