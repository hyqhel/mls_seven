package com.digiwes.product.spec;

import com.digiwes.basetype.*;

/**
 * A type of ProductSpecification that does not have any subordinate ProductSpecifications, that is, an AtomicProductSpecification is a leaf-level ProductSpecification.
 */
public class AtomicProductSpecification extends ProductSpecification {

    /**
     * 
     * @param productNumber
     * @param name
     * @param brand
     */
    public AtomicProductSpecification(String productNumber, String name, String brand) {
        // TODO - implement AtomicProductSpecification.AtomicProductSpecification
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param productNumber
     * @param name
     * @param brand
     * @param description
     * @param validFor
     */
    public AtomicProductSpecification(String productNumber, String name, String brand, String description, TimePeriod validFor) {
        // TODO - implement AtomicProductSpecification.AtomicProductSpecification
        throw new UnsupportedOperationException();
    }

}