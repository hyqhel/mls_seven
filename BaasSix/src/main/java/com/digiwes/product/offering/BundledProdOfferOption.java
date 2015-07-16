package com.digiwes.product.offering;

import com.digiwes.common.util.CommonUtils;

/**
 * A set of numbers that specifies the lower and upper limits for a ProductOffering that can be procured as part of the related BundledProductOffering.
 * <p>
 * Values can range from 0 to unbounded.
 */
public class BundledProdOfferOption {

    public ProductOffering productOffering;
    /**
     * The lower limit of related ProductOfferings that can be procured as part of the BundledProductOffering.
     * <p>
     * Values can range from 0 to unbounded.
     */
    private int numberRelOfferLowerLimit;
    /**
     * The upper limit of related ProductOfferings that can be procured as part of the BundledProductOffering.
     * <p>
     * Values can range from 0 to unbounded.
     */
    private int numberRelOfferUpperLimit;

    public ProductOffering getProductOffering() {
        return this.productOffering;
    }

    public void setProductOffering(ProductOffering productOffering) {
        this.productOffering = productOffering;
    }

    public int getNumberRelOfferLowerLimit() {
        return this.numberRelOfferLowerLimit;
    }

    public void setNumberRelOfferLowerLimit(int numberRelOfferLowerLimit) {
        this.numberRelOfferLowerLimit = numberRelOfferLowerLimit;
    }

    public int getNumberRelOfferUpperLimit() {
        return this.numberRelOfferUpperLimit;
    }

    public void setNumberRelOfferUpperLimit(int numberRelOfferUpperLimit) {
        this.numberRelOfferUpperLimit = numberRelOfferUpperLimit;
    }

    /**
     * @param offering
     * @param lowerLimit
     * @param upperLimit
     */
    public BundledProdOfferOption(ProductOffering offering, int lowerLimit, int upperLimit) {
        assert !CommonUtils.checkParamIsNull(offering) : "Parameter [offering] must be not null";
        this.productOffering = offering;
        this.numberRelOfferLowerLimit = lowerLimit;
        this.numberRelOfferUpperLimit = upperLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BundledProdOfferOption that = (BundledProdOfferOption) o;

        return productOffering.equals(that.productOffering);

    }

    @Override
    public int hashCode() {
        return productOffering.hashCode();
    }

    public String toString() {
        // TODO - implement BundledProdOfferOption.toString
        return "";
    }

}