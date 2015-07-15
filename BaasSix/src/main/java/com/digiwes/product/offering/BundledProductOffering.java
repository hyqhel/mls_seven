package com.digiwes.product.offering;

import java.util.*;
import com.digiwes.basetype.*;

public class BundledProductOffering extends ProductOffering {

    public List<BundledProdOfferOption> bundledProdOfferOption;

    public List<BundledProdOfferOption> getBundledProdOfferOption() {
        return this.bundledProdOfferOption;
    }

    public void setBundledProdOfferOption(List<BundledProdOfferOption> bundledProdOfferOption) {
        this.bundledProdOfferOption = bundledProdOfferOption;
    }

    /**
     * 
     * @param id
     * @param name
     * @param description
     * @param validFor
     */
    public BundledProductOffering(String id, String name, String description, TimePeriod validFor) {
        // TODO - implement BundledProductOffering.BundledProductOffering
        super(id, name, description, validFor);
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     */
    public int composedOf(ProductOffering offering) {
        // TODO - implement BundledProductOffering.composedOf
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param lowerLimit
     * @param upperLimit
     */
    public int composeOf(ProductOffering offering, int lowerLimit, int upperLimit) {
        // TODO - implement BundledProductOffering.composeOf
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param lowerLimit
     * @param upperLimit
     */
    public int modifyOption(ProductOffering offering, int lowerLimit, int upperLimit) {
        // TODO - implement BundledProductOffering.modifyOption
        throw new UnsupportedOperationException();
    }

    public ProductOffering[] retrieveOffering() {
        // TODO - implement BundledProductOffering.retrieveOffering
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement BundledProductOffering.toString
        throw new UnsupportedOperationException();
    }

}