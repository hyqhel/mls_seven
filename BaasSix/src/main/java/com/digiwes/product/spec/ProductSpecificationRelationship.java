package com.digiwes.product.spec;

import com.digiwes.basetype.*;

/**
 * A migration, substitution, dependency, or exclusivity relationship between/among ProductSpecifications.
 */
public class ProductSpecificationRelationship {

    ProductSpecification targetProdSpec;
    ProductSpecification sourceSpec;
    /**
     * A categorization of the relationship, such as migration, substitution, dependency, exclusivity.
     */
    private String type;
    /**
     * The period for which the relationship is applicable.
     */
    private TimePeriod validFor;

    /**
     * 
     * @param sourceSpec
     * @param targetSpec
     * @param type
     * @param validFor
     */
    public ProductSpecificationRelationship(ProductSpecification sourceSpec, ProductSpecification targetSpec, String type, TimePeriod validFor) {
        // TODO - implement ProductSpecificationRelationship.ProductSpecificationRelationship
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        // TODO - implement ProductSpecificationRelationship.hashCode
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement ProductSpecificationRelationship.equals
        throw new UnsupportedOperationException();
    }

}