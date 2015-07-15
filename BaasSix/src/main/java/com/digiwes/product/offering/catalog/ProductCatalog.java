package com.digiwes.product.offering.catalog;

import com.digiwes.common.catalog.*;
import java.util.*;
import com.digiwes.basetype.*;
import com.digiwes.product.offering.*;
import com.digiwes.product.offering.price.*;

/**
 * A list of ProductOfferings for sale, with prices and illustrations, for example in book form or on the web. ProductCatalogs can be used by Customers during a self-care ordering process and may be used across one or more DistributionChannels.
 *  
 * A list of ProductOfferings for sale, with prices and illustrations, for example in book form or on the web. ProductCatalogs can be used by Customers during a self-care ordering process and may be used across one or more DistributionChannels.
 * ?
 */
public class ProductCatalog extends Catalog {

    public List<ProdCatalogProdOffer> prodCatalogProdOffer;

    /**
     * 
     * @param id
     * @param name
     * @param type
     */
    public ProductCatalog(String id, String name, String type) {
        // TODO - implement ProductCatalog.ProductCatalog
        super(id,name,type,null);
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param id
     * @param name
     * @param type
     * @param validFor
     */
    public ProductCatalog(String id, String name, String type, TimePeriod validFor) {
        // TODO - implement ProductCatalog.ProductCatalog
        super(id, name, type, validFor);
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param validFor
     */
    public int publish(ProductOffering offering, TimePeriod validFor) {
        // TODO - implement ProductCatalog.publish
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param validFor
     * @param price
     */
    public int publish(ProductOffering offering, TimePeriod validFor, ProductOfferingPrice[] price) {
        // TODO - implement ProductCatalog.publish
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param validFor
     */
    public int retired(ProductOffering offering, TimePeriod validFor) {
        // TODO - implement ProductCatalog.retired
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     */
    public int retired(ProductOffering offering) {
        // TODO - implement ProductCatalog.retired
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param time
     */
    public ProductOfferingPrice[] retrieveOfferingPrice(ProductOffering offering, int time) {
        // TODO - implement ProductCatalog.retrieveOfferingPrice
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param timePeriod
     * @param price
     */
    public int specifyOfferingPrice(ProductOffering offering, TimePeriod timePeriod, ProductOfferingPrice price) {
        // TODO - implement ProductCatalog.specifyOfferingPrice
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param timePeriod
     * @param newPrice
     */
    public int alterOfferingPrice(ProductOffering offering, TimePeriod timePeriod, ProductOfferingPrice[] newPrice) {
        // TODO - implement ProductCatalog.alterOfferingPrice
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param time
     */
    public ProdCatalogProdOffer[] retrieveOffering(int time) {
        // TODO - implement ProductCatalog.retrieveOffering
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offeringName
     */
    public ProdCatalogProdOffer[] retrieveOffering(String offeringName) {
        // TODO - implement ProductCatalog.retrieveOffering
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param validFor
     */
    private ProdCatalogProdOffer retrieveProdCatalogProdOffer(ProductOffering offering, TimePeriod validFor) {
        // TODO - implement ProductCatalog.retrieveProdCatalogProdOffer
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     */
    private ProdCatalogProdOffer[] retrieveProdCatalogProdOffer(ProductOffering offering) {
        // TODO - implement ProductCatalog.retrieveProdCatalogProdOffer
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param validFor
     */
    private boolean contains(ProductOffering offering, TimePeriod validFor) {
        // TODO - implement ProductCatalog.contains
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param oldValidFor
     * @param newValidFor
     */
    public int modifyOfferingValidTime(ProductOffering offering, TimePeriod oldValidFor, TimePeriod newValidFor) {
        // TODO - implement ProductCatalog.modifyOfferingValidTime
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement ProductCatalog.toString
        throw new UnsupportedOperationException();
    }

}