package com.digiwes.product.spec;

import com.digiwes.basetype.*;

/**
 * A aggregation, migration, substitution, dependency, or exclusivity relationship between/among ProductSpecCharacteristics.
 */
public class ProductSpecCharRelationship {

    public ProductSpecCharacteristic targetProdSpecChar;
    public ProductSpecCharacteristic sourceProdSpecChar;
    /**
     * A categorization of the relationship, such as aggregation, migration, substitution, dependency, exclusivity.
     */
    private String charRelationshipType;
    /**
     * The order in which a CharacteristicSpecification appears within another CharacteristicSpecification that defines a grouping of CharacteristicSpecifications.
     * 
     * For example, a grouping may represent the name of an individual. The given name is first, the middle name is second, and the last name is third.
     */
    private int charSpecSeq;
    /**
     * The period for which the relationship is applicable.
     */
    private TimePeriod validFor;

    public String getCharRelationshipType() {
        return this.charRelationshipType;
    }

    public void setCharRelationshipType(String charRelationshipType) {
        this.charRelationshipType = charRelationshipType;
    }

    public int getCharSpecSeq() {
        return this.charSpecSeq;
    }

    public void setCharSpecSeq(int charSpecSeq) {
        this.charSpecSeq = charSpecSeq;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public ProductSpecCharacteristic getTargetProdSpecChar() {
        return targetProdSpecChar;
    }

    public ProductSpecCharacteristic getSourceProdSpecChar() {
        return sourceProdSpecChar;
    }

    public void setTargetProdSpecChar(ProductSpecCharacteristic targetProdSpecChar) {
        this.targetProdSpecChar = targetProdSpecChar;
    }

    public void setSourceProdSpecChar(ProductSpecCharacteristic sourceProdSpecChar) {
        this.sourceProdSpecChar = sourceProdSpecChar;
    }

    /**
     * 
     * @param srourceSpecChar
     * @param targetSpecChar
     * @param relationType
     * @param validFor
     */
    public ProductSpecCharRelationship(ProductSpecCharacteristic srourceSpecChar, ProductSpecCharacteristic targetSpecChar, String relationType, TimePeriod validFor) {
        // TODO - implement ProductSpecCharRelationship.ProductSpecCharRelationship
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param srourceSpecChar
     * @param targetSpecChar
     * @param relationType
     * @param validFor
     * @param specSeq
     */
    public ProductSpecCharRelationship(ProductSpecCharacteristic srourceSpecChar, ProductSpecCharacteristic targetSpecChar, String relationType, TimePeriod validFor, int specSeq) {
        // TODO - implement ProductSpecCharRelationship.ProductSpecCharRelationship
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        // TODO - implement ProductSpecCharRelationship.hashCode
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement ProductSpecCharRelationship.equals
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement ProductSpecCharRelationship.toString
        throw new UnsupportedOperationException();
    }

}