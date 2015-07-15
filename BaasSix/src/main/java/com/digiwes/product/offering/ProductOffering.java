package com.digiwes.product.offering;

import java.util.*;
import com.digiwes.product.offering.price.*;
import com.digiwes.basetype.*;

/**
 * The presentation of one or more ProductSpecifications to the marketplace for sale, rental, or lease for a ProductOfferingPrice. A ProductOffering may target one or more MarketSegments, be included in one or more ProductCatalog, presented in support of one or more ProductStrategies, and made available in one or more Places. ProductOffering may represent a simple offering of a single ProductSpecification or could represent a bundling of one or more other ProductOffering.
 */
public abstract class ProductOffering {

    public List<ProductOfferingPrice> productOfferingPrice;
    public List<ProductOfferingRelationship> prodOfferingRelationship;
    /**
     * A unique identifier for the ProductOffering.
     */
    private String id;
    /**
     * A word, term, or phrase by which the ProductOffeirng is known and distinguished from other ProductOfferings.
     */
    private String name;
    /**
     * A narrative that explains what the offering is.
     */
    private String description;
    /**
     * The period during which the offering is applicable.
     */
    private TimePeriod validFor;
    /**
     * The condition in which the offering exists, such as planned, obsolete, active
     */
    private String status;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getStatus() {
        return this.status;
    }

    /**
     * 
     * @param id
     * @param name
     * @param description
     * @param validFor
     */
    public ProductOffering(String id, String name, String description, TimePeriod validFor) {
        // TODO - implement ProductOffering.ProductOffering
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     * @param relationType
     * @param validFor
     */
    public int associate(ProductOffering offering, String relationType, TimePeriod validFor) {
        // TODO - implement ProductOffering.associate
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param offering
     */
    public int dissociate(ProductOffering offering) {
        // TODO - implement ProductOffering.dissociate
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param relationType
     */
    public ProductOffering[] retrieveRelatedOffering(String relationType) {
        // TODO - implement ProductOffering.retrieveRelatedOffering
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param relationType
     * @param time
     */
    public ProductOffering[] retrieveRelatedOffering(String relationType, Date time) {
        // TODO - implement ProductOffering.retrieveRelatedOffering
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param price
     */
    public int specifyPrice(ProductOfferingPrice price) {
        // TODO - implement ProductOffering.specifyPrice
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param price
     */
    private int removePrice(ProductOfferingPrice price) {
        // TODO - implement ProductOffering.removePrice
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param newPrice
     */
    public void alterPrice(ProductOfferingPrice[] newPrice) {
        // TODO - implement ProductOffering.alterPrice
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param time
     */
    public ProductOfferingPrice[] retrievePrice(Date time) {
        // TODO - implement ProductOffering.retrievePrice
        throw new UnsupportedOperationException();
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO - implement ProductOffering.getBasicInfo
        throw new UnsupportedOperationException();
    }

    /**
     * Basic info of the class ouput to String
     */
    public String basicInfoToString() {
        // TODO - implement ProductOffering.basicInfoToString
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement ProductOffering.equals
        throw new UnsupportedOperationException();
    }

}