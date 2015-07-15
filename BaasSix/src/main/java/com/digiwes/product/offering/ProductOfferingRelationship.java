package com.digiwes.product.offering;

import com.digiwes.basetype.*;

/**
 * A significant connection or similarity between two or more ProductOfferings. For example, the relationship between a provider's ProductOffering and a supplier/partner's ProductOffering used to fulfill the provider's ProductOffering; a service provider offers various photos for download and printing...a print shop prints them for the provider and considers one photo (ProductOffering) the same as any other from a pricing perspective...one partners' photo offering is related to many of the provider's photos.
 */
public class ProductOfferingRelationship {

    public ProductOffering targetOffering;
    public ProductOffering sourceOffering;
    /**
     * A categorization of the relationship, such as supplier/partner equivalent, alternate, and so forth.
     */
    private String typeRelationship;
    /**
     * The period during which the relationship is applicable.
     */
    private TimePeriod validFor;

    public String getTypeRelationship() {
        return this.typeRelationship;
    }

    public void setTypeRelationship(String typeRelationship) {
        this.typeRelationship = typeRelationship;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    /**
     * 
     * @param sourceOffering
     * @param targetOffering
     * @param type
     * @param validFor
     */
    public ProductOfferingRelationship(ProductOffering sourceOffering, ProductOffering targetOffering, String type, TimePeriod validFor) {
        // TODO - implement ProductOfferingRelationship.ProductOfferingRelationship
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement ProductOfferingRelationship.toString
        throw new UnsupportedOperationException();
    }

}