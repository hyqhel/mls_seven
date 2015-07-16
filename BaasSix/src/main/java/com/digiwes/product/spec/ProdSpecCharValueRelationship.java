package com.digiwes.product.spec;

import com.digiwes.basetype.*;

public class ProdSpecCharValueRelationship {

    public ProductSpecCharacteristicValue sourceCharValue;
    public ProductSpecCharacteristicValue targetCharValue;
    /**
     * A categorization of the relationship between values, such as aggregation, migration, substitution, dependency, exclusivity.
     */
    private String charValueRelationshipType;
    /**
     * The period for which the relationship is applicable.
     */
    private TimePeriod validFor;

    public String getCharValueRelationshipType() {
        return this.charValueRelationshipType;
    }

    public void setCharValueRelationshipType(String charValueRelationshipType) {
        this.charValueRelationshipType = charValueRelationshipType;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public ProductSpecCharacteristicValue getSourceCharValue() {
        return sourceCharValue;
    }

    public void setSourceCharValue(ProductSpecCharacteristicValue sourceCharValue) {
        this.sourceCharValue = sourceCharValue;
    }

    public ProductSpecCharacteristicValue getTargetCharValue() {
        return targetCharValue;
    }

    public void setTargetCharValue(ProductSpecCharacteristicValue targetCharValue) {
        this.targetCharValue = targetCharValue;
    }

    /**
     * 
     * @param srourceCharValue
     * @param targetCharValue
     * @param relationType
     * @param validFor
     */
    public ProdSpecCharValueRelationship(ProductSpecCharacteristicValue srourceCharValue, ProductSpecCharacteristicValue targetCharValue, String relationType, TimePeriod validFor) {
        this.sourceCharValue = sourceCharValue;
        this.targetCharValue = targetCharValue;
        this.validFor = validFor;
        this.charValueRelationshipType = relationType;
    }


    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((charValueRelationshipType == null) ? 0
                : charValueRelationshipType.hashCode());
        result = prime
                * result
                + ((targetCharValue == null) ? 0
                : targetCharValue.hashCode());
        result = prime * result
                + ((validFor == null) ? 0 : validFor.hashCode());
        return result;
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (getClass() != o.getClass()){
            return false;
        }
        ProdSpecCharValueRelationship other = (ProdSpecCharValueRelationship) o;
        if (charValueRelationshipType == null) {
            if (other.charValueRelationshipType != null){
                return false;
            }
        } else if (!charValueRelationshipType
                .equals(other.charValueRelationshipType)){
            return false;
        }
        if (targetCharValue == null) {
            if (other.targetCharValue != null){
                return false;
            }
        } else if (!targetCharValue
                .equals(other.targetCharValue)){
            return false;
        }
        if (validFor == null) {
            if (other.validFor != null){
                return false;
            }
        } else if (!validFor.equals(other.validFor)){
            return false;
        }
        return true;
    }

    public String toString() {
        // TODO
        return null;
    }

}