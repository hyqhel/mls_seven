package com.digiwes.resources.beans;

import com.digiwes.basetype.*;

public class RelatedOffering {

    private String offeringId;
    private String offeringName;
    /**
     * A categorization of the relationship, such as supplier/partner equivalent, alternate, and so forth.
     */
    private String relationshipType;
    /**
     * The period during which the relationship is applicable.
     */
    private TimePeriod validFor;

    public String getRelationshipType() {
        return this.relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

}