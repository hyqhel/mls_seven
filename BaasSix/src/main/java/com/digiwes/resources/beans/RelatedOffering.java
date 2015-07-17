package com.digiwes.resources.beans;

import com.digiwes.basetype.*;

public class RelatedOffering {

    private String offeringId;
    private String offeringName;
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

}