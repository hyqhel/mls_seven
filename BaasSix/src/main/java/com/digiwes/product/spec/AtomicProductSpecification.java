package com.digiwes.product.spec;

import com.digiwes.basetype.*;
import com.digiwes.common.util.CommonUtils;

import java.util.Map;

/**
 * A type of ProductSpecification that does not have any subordinate ProductSpecifications, that is, an AtomicProductSpecification is a leaf-level ProductSpecification.
 */
public class AtomicProductSpecification extends ProductSpecification {

    /**
     * @param productNumber
     * @param name
     * @param brand
     */
    public AtomicProductSpecification(String productNumber, String name, String brand) {
        super(productNumber, name, brand);
    }

    /**
     * @param productNumber
     * @param name
     * @param brand
     * @param description
     * @param validFor
     */
    public AtomicProductSpecification(String productNumber, String name, String brand, String description, TimePeriod validFor) {
        super(productNumber, name, brand, validFor, description);
    }

    @Override
    public String toString() {
        // TODO - implement ProductSpecification.toString
        return "";
    }

}