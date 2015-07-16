package com.digiwes.product.offering.catalog;

import com.digiwes.common.util.CommonUtils;
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

    public ProductOffering getProdOffering() {
        return prodOffering;
    }

    public void setProdOffering(ProductOffering prodOffering) {
        this.prodOffering = prodOffering;
    }

    public List<ProductOfferingPrice> getProductOfferingPrice() {
        return productOfferingPrice;
    }

    public void setProductOfferingPrice(List<ProductOfferingPrice> productOfferingPrice) {
        this.productOfferingPrice = productOfferingPrice;
    }

    /**
     * @param offering
     * @param validFor
     */
    public ProdCatalogProdOffer(ProductOffering offering, TimePeriod validFor) {
        assert CommonUtils.checkParamIsNull(offering) : "parameter is error the Object of offering is null. ";
        assert CommonUtils.checkParamIsNull(validFor) : "parameter is error the validFor of offering is null. ";
        this.prodOffering = offering;
        this.validFor = validFor;
    }

    /**
     * @param offering
     * @param validFor
     * @param price
     */
    public ProdCatalogProdOffer(ProductOffering offering, TimePeriod validFor, List<ProductOfferingPrice> price) {
        assert CommonUtils.checkParamIsNull(offering) : "parameter is error the Object of offering is null. ";
        assert CommonUtils.checkParamIsNull(validFor) : "parameter is error the validFor of offering is null. ";
        this.prodOffering = offering;
        this.validFor = validFor;
        this.productOfferingPrice = price;
    }

    /**
     * @param price
     */
    public int specifyPrice(ProductOfferingPrice price) {
        // TODO - implement ProdCatalogProdOffer.specifyPrice
        return 0;
    }

    /**
     * @param newPrice
     */
    public int alterPrice(ProductOfferingPrice[] newPrice) {
        // TODO - implement ProdCatalogProdOffer.alterPrice
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdCatalogProdOffer that = (ProdCatalogProdOffer) o;

        if (!prodOffering.equals(that.prodOffering)) return false;
        if (productOfferingPrice != null ? !productOfferingPrice.equals(that.productOfferingPrice) : that
                .productOfferingPrice != null)
            return false;
        return validFor.equals(that.validFor);

    }

    @Override
    public int hashCode() {
        int result = prodOffering.hashCode();
        result = 31 * result + (productOfferingPrice != null ? productOfferingPrice.hashCode() : 0);
        result = 31 * result + validFor.hashCode();
        return result;
    }

    public String toString() {
        // TODO - implement ProdCatalogProdOffer.toString
        throw new UnsupportedOperationException();
    }

}