package com.digiwes.product.offering.catalog;

import com.digiwes.product.offering.*;
import java.util.*;
import com.digiwes.product.offering.price.*;
import com.digiwes.basetype.*;

/**
 * The appearance of a ProductOffering in a ProductCatalog.
 */
public class ProdCatalogProdOffer {

    public ProductOffering prodOffering;
    public List<ProductOfferingPrice> productOfferingPrice;
    /**
     * The period during which the ProductOffering appears in the ProductCatalog.
     */
    private TimePeriod validFor;

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    /**
     * 
     * @param offering
     * @param validFor
     */
    public ProdCatalogProdOffer(ProductOffering offering, TimePeriod validFor) {
        // TODO - implement ProdCatalogProdOffer.ProdCatalogProdOffer
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param validFor
     * @param price
     */
    public ProdCatalogProdOffer(ProductOffering offering, TimePeriod validFor, ProductOfferingPrice[] price) {
        // TODO - implement ProdCatalogProdOffer.ProdCatalogProdOffer
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param price
     */
    public int specifyPrice(ProductOfferingPrice price) {
        // TODO - implement ProdCatalogProdOffer.specifyPrice
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param newPrice
     */
    public int alterPrice(ProductOfferingPrice[] newPrice) {
        // TODO - implement ProdCatalogProdOffer.alterPrice
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement ProdCatalogProdOffer.equals
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        // TODO - implement ProdCatalogProdOffer.hashCode
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement ProdCatalogProdOffer.toString
        throw new UnsupportedOperationException();
    }

}