package com.digiwes.resources.beans;

import java.util.*;

public class ProductSpecChar {

    private String name;
    /**
     * A narrative that explains the CharacteristicSpecification.
     */
    private String description;
    /**
     * The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
     */
    private int minCardinality;
    /**
     * The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
     */
    private int maxCardinality;
    List<ProductSpecCharValue> productSpecCharValues;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinCardinality() {
        return this.minCardinality;
    }

    public void setMinCardinality(int minCardinality) {
        this.minCardinality = minCardinality;
    }

    public int getMaxCardinality() {
        return this.maxCardinality;
    }

    public void setMaxCardinality(int maxCardinality) {
        this.maxCardinality = maxCardinality;
    }

    public List<ProductSpecCharValue> getProductSpecCharValues() {
        return this.productSpecCharValues;
    }

    public void setProductSpecCharValues(List<ProductSpecCharValue> productSpecCharValues) {
        this.productSpecCharValues = productSpecCharValues;
    }

}