package com.digiwes.product.offering;

import com.digiwes.common.util.CommonUtils;
import com.digiwes.product.spec.*;
import com.digiwes.basetype.*;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * A type of ProductOffering that does not have any subordinate ProductOfferings, that is, an SimpleProductOffering is a leaf-level ProductOffering.
 */
public class SimpleProductOffering extends ProductOffering {

    private static Logger logger = Logger.getLogger(SimpleProductOffering.class);

    ProductSpecification productSpecification;

    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }

    /**
     * @param id
     * @param name
     * @param description
     * @param validFor
     * @param prodSpec
     */
    public SimpleProductOffering(String id, String name, String description, TimePeriod validFor, ProductSpecification prodSpec) {
        super(id, name, description, validFor);
        assert !CommonUtils.checkParamIsNull(prodSpec) : "Param [prodSpec] must be not null!";
        this.productSpecification = prodSpec;
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO - implement SimpleProductOffering.getBasicInfo
        return null;
    }

    public String toString() {
        // TODO - implement SimpleProductOffering.toString
        return "";
    }

}