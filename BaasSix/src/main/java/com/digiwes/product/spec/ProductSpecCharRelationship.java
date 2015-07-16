package com.digiwes.product.spec;

import com.digiwes.basetype.*;
import com.digiwes.common.enums.ProductSpecErrorEnum;
import com.digiwes.common.util.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * A aggregation, migration, substitution, dependency, or exclusivity relationship between/among ProductSpecCharacteristics.
 */
public class ProductSpecCharRelationship {
    private static final Logger logger = Logger.getLogger(ProductSpecCharRelationship.class);

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
        assert !CommonUtils.checkParamIsNull(srourceSpecChar):"srcProdSpecChar should not be null";
        assert !CommonUtils.checkParamIsNull(targetSpecChar):"targetProdSpecChar should not be null";
        this.sourceProdSpecChar = srourceSpecChar;
        this.targetProdSpecChar = targetSpecChar;
        this.charRelationshipType = relationType;
        this.validFor = validFor;
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
        assert !CommonUtils.checkParamIsNull(srourceSpecChar):"srcProdSpecChar should not be null";
        assert !CommonUtils.checkParamIsNull(targetSpecChar):"targetProdSpecChar should not be null";
        this.sourceProdSpecChar = srourceSpecChar;
        this.targetProdSpecChar = targetSpecChar;
        this.charRelationshipType = relationType;
        this.validFor = validFor;
        this.charSpecSeq = specSeq;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((charRelationshipType == null) ? 0 : charRelationshipType
                .hashCode());
        result = prime
                * result
                + ((targetProdSpecChar == null) ? 0 : targetProdSpecChar
                .hashCode());
        result = prime * result
                + ((validFor == null) ? 0 : validFor.hashCode());
        result = prime * result + charSpecSeq;
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
        if (!(o instanceof ProductSpecCharRelationship)){
            return false;
        }
        ProductSpecCharRelationship other = (ProductSpecCharRelationship) o;
        if (charRelationshipType == null) {
            if (other.charRelationshipType != null){
                return false;
            }
        } else if (!charRelationshipType.equals(other.charRelationshipType)){
            return false;
        }
        if (targetProdSpecChar == null) {
            if (other.targetProdSpecChar != null){
                return false;
            }
        } else if (!targetProdSpecChar.equals(other.targetProdSpecChar)){
            return false;
        }
        if (charSpecSeq != other.charSpecSeq){
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