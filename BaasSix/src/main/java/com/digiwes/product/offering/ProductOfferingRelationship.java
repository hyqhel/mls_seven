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

    public ProductOffering getTargetOffering() {
        return targetOffering;
    }

    public void setTargetOffering(ProductOffering targetOffering) {
        this.targetOffering = targetOffering;
    }

    public ProductOffering getSourceOffering() {
        return sourceOffering;
    }

    public void setSourceOffering(ProductOffering sourceOffering) {
        this.sourceOffering = sourceOffering;
    }

    /**
     * @param sourceOffering
     * @param targetOffering
     * @param type
     * @param validFor
     */
    public ProductOfferingRelationship(ProductOffering sourceOffering, ProductOffering targetOffering, String type, TimePeriod validFor) {
        this.sourceOffering = sourceOffering;
        this.targetOffering = targetOffering;
        this.typeRelationship = type;
        this.validFor = validFor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductOfferingRelationship that = (ProductOfferingRelationship) o;

        if (targetOffering != null ? !targetOffering.equals(that.targetOffering) : that.targetOffering != null)
            return false;
        if (sourceOffering != null ? !sourceOffering.equals(that.sourceOffering) : that.sourceOffering != null)
            return false;
        if (typeRelationship != null ? !typeRelationship.equals(that.typeRelationship) : that.typeRelationship != null)
            return false;
        return !(validFor != null ? !validFor.equals(that.validFor) : that.validFor != null);

    }

    @Override
    public int hashCode() {
        int result = targetOffering != null ? targetOffering.hashCode() : 0;
        result = 31 * result + (sourceOffering != null ? sourceOffering.hashCode() : 0);
        result = 31 * result + (typeRelationship != null ? typeRelationship.hashCode() : 0);
        result = 31 * result + (validFor != null ? validFor.hashCode() : 0);
        return result;
    }

    public String toString() {
        // TODO - implement ProductOfferingRelationship.toString
        return "";
    }

}