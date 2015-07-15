package com.digiwes.product.offering.price;

import com.digiwes.basetype.*;

import java.util.Map;

/**
 * An amount, usually of money, that is asked for or allowed when a ProductOffering is bought, rented, or leased. The price is valid for a defined period of time and may not represent the actual price paid by a customer.
 */
public abstract class ProductOfferingPrice {

    /**
     * A short descriptive name such as "affinity discount" .
     */
    private String name;
    /**
     * A narrative that explains in detail the semantics of this component.
     */
    private String description;
    /**
     * The period for which the price is valid.
     */
    private TimePeriod validFor;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    /**
     * 
     * @param name
     * @param validFor
     */
    public ProductOfferingPrice(String name, TimePeriod validFor) {
        // TODO - implement ProductOfferingPrice.ProductOfferingPrice
        throw new UnsupportedOperationException();
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO - implement ProductOfferingPrice.getBasicInfo
        throw new UnsupportedOperationException();
    }

    /**
     * Basic info of the class ouput to String
     */
    public String basicInfoToString() {
        // TODO - implement ProductOfferingPrice.basicInfoToString
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement ProductOfferingPrice.toString
        throw new UnsupportedOperationException();
    }

}