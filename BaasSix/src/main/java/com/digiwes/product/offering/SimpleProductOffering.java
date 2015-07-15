package com.digiwes.product.offering;

import com.digiwes.product.spec.*;
import com.digiwes.basetype.*;

import java.util.Map;

/**
 * A type of ProductOffering that does not have any subordinate ProductOfferings, that is, an SimpleProductOffering is a leaf-level ProductOffering.
 */
public class SimpleProductOffering extends ProductOffering {

    ProductSpecification productSpecification;

    /**
     * 
     * @param id
     * @param name
     * @param description
     * @param validFor
     * @param prodSpec
     */
    public SimpleProductOffering(String id, String name, String description, TimePeriod validFor, ProductSpecification prodSpec) {
        // TODO - implement SimpleProductOffering.SimpleProductOffering
        super(id, name, description, validFor);
        throw new UnsupportedOperationException();
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO - implement SimpleProductOffering.getBasicInfo
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement SimpleProductOffering.toString
        throw new UnsupportedOperationException();
    }

}