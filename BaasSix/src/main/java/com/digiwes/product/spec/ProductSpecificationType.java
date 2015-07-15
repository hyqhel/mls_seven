package com.digiwes.product.spec;

import java.util.*;

/**
 * A classification that groups ProductSpecifications that share common characteristics.
 */
public abstract class ProductSpecificationType {

    public List<ProductSpecification> prodSpec;
    /**
     * The name of the product specification type.
     */
    private String type;
    /**
     * A narrative that explains in detail what the product spec is.
     */
    private String description;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @param type
     * @param description
     */
    public ProductSpecificationType(String type, String description) {
        // TODO - implement ProductSpecificationType.ProductSpecificationType
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param prodSpec
     */
    public int group(ProductSpecification prodSpec) {
        // TODO - implement ProductSpecificationType.group
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param prodSpec
     */
    public int ungroup(ProductSpecification prodSpec) {
        // TODO - implement ProductSpecificationType.ungroup
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement ProductSpecificationType.toString
        throw new UnsupportedOperationException();
    }

}