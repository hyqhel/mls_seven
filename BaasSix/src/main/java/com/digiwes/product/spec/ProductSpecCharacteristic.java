package com.digiwes.product.spec;

import java.util.*;
import com.digiwes.basetype.*;

/**
 * A characteristic quality or distinctive feature of a ProductSpecification. The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.
 */
public class ProductSpecCharacteristic {

    List<ProductSpecCharacteristicValue> prodSpecCharValue;
    public List<ProductSpecCharRelationship> prodSpecCharRelationship;
    /**
     * A unique identifier for the ProductSpecCharacteristic.
     * ?
     */
    private String ID;
    /**
     * A word, term, or phrase by which the characteristic is known and distinguished from characteristics.
     */
    private String name;
    /**
     * A narrative that explains the characteristic.
     */
    private String description;
    /**
     * An indicator that specifies if a value is unique for the specification.
     * 
     * Possible values are; "unique while value is in effect" and "unique whether value is in effect or not"
     */
    private String unique;
    /**
     * A kind of value that the characteristic can take on, such as numeric, text, and so forth.
     */
    private String valueType;
    /**
     * The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
     */
    private int minCardinality;
    /**
     * The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
     */
    private int maxCardinality;
    /**
     * An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for an Entity.
     */
    private boolean extensible;
    /**
     * A rule or principle represented in symbols, numbers, or letters, often in the form of an equation used to derive the value of a characteristic value.
     */
    private String derivationFormula;
    /**
     * The period of time for which a characteristic is applicable.
     */
    private TimePeriod validFor;

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getUnique() {
        return this.unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public String getValueType() {
        return this.valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public int getMinCardinality() {
        return this.minCardinality;
    }

    public void setMinCardinality(int minCardinality) {
        this.minCardinality = minCardinality;
    }

    public int getMaxCardinality() {
        return this.maxCardinality;
    }

    public void setMaxCardinality(int maxCardinality) {
        this.maxCardinality = maxCardinality;
    }

    public boolean isExtensible() {
        return this.extensible;
    }

    public void setExtensible(boolean extensible) {
        this.extensible = extensible;
    }

    public String getDerivationFormula() {
        return this.derivationFormula;
    }

    public void setDerivationFormula(String derivationFormula) {
        this.derivationFormula = derivationFormula;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    /**
     * 
     * @param id
     * @param name
     * @param valueType
     */
    public ProductSpecCharacteristic(String id, String name, String valueType) {
        // TODO - implement ProductSpecCharacteristic.ProductSpecCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param id
     * @param name
     * @param valueType
     * @param validFor
     * @param unique
     * @param minCardinality
     * @param maxCardinality
     * @param extensible
     * @param description
     * @param derivationFormula
     */
    public ProductSpecCharacteristic(String id, String name, String valueType, TimePeriod validFor, String unique, int minCardinality, int maxCardinality, boolean extensible, String description, String derivationFormula) {
        // TODO - implement ProductSpecCharacteristic.ProductSpecCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param minCardinality
     * @param maxCardinality
     */
    public int specifyCardinality(int minCardinality, int maxCardinality) {
        // TODO - implement ProductSpecCharacteristic.specifyCardinality
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charVal
     */
    public int assignValue(ProductSpecCharacteristicValue charVal) {
        // TODO - implement ProductSpecCharacteristic.assignValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charVal
     */
    public int removeValue(ProductSpecCharacteristicValue charVal) {
        // TODO - implement ProductSpecCharacteristic.removeValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param time
     */
    public ProductSpecCharacteristicValue[] retrieveValue(int time) {
        // TODO - implement ProductSpecCharacteristic.retrieveValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param defaultCharVal
     */
    public int specifyDefaultValue(ProductSpecCharacteristicValue defaultCharVal) {
        // TODO - implement ProductSpecCharacteristic.specifyDefaultValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param value
     */
    public int clearDefaultValue(ProductSpecCharacteristicValue value) {
        // TODO - implement ProductSpecCharacteristic.clearDefaultValue
        throw new UnsupportedOperationException();
    }

    public ProductSpecCharacteristicValue[] retrieveDefaultValue() {
        // TODO - implement ProductSpecCharacteristic.retrieveDefaultValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param specChar
     * @param type
     * @param validFor
     */
    public int associate(ProductSpecCharacteristic specChar, String type, TimePeriod validFor) {
        // TODO - implement ProductSpecCharacteristic.associate
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param specChar
     * @param type
     * @param validFor
     * @param charSpecSeq
     */
    public int associate(ProductSpecCharacteristic specChar, String type, TimePeriod validFor, int charSpecSeq) {
        // TODO - implement ProductSpecCharacteristic.associate
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param specChar
     */
    public int dissociate(ProductSpecCharacteristic specChar) {
        // TODO - implement ProductSpecCharacteristic.dissociate
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charRelationshipType
     */
    public ProductSpecCharacteristic[] retrieveRelatedCharacteristic(String charRelationshipType) {
        // TODO - implement ProductSpecCharacteristic.retrieveRelatedCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charRelationshipType
     * @param time
     */
    public ProductSpecCharacteristic[] retrieveRelatedCharacteristic(String charRelationshipType, Date time) {
        // TODO - implement ProductSpecCharacteristic.retrieveRelatedCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * Search the association that has existed between Characteristic. 
     * 
     * avoid to duplicate.
     * @param characteristic
     */
    private ProductSpecCharRelationship retrieveCharRelationship(ProductSpecCharacteristic characteristic) {
        // TODO - implement ProductSpecCharacteristic.retrieveCharRelationship
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param prodSpecChar
     * @param validFor
     */
    public int modifyRelationshipValidPeriod(ProductSpecCharacteristic prodSpecChar, TimePeriod validFor) {
        // TODO - implement ProductSpecCharacteristic.modifyRelationshipValidPeriod
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        // TODO - implement ProductSpecCharacteristic.hashCode
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement ProductSpecCharacteristic.equals
        throw new UnsupportedOperationException();
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO - implement ProductSpecCharacteristic.getBasicInfo
        throw new UnsupportedOperationException();
    }

    /**
     * Basic info of the class ouput to String
     */
    public String basicInfoToString() {
        // TODO - implement ProductSpecCharacteristic.basicInfoToString
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement ProductSpecCharacteristic.toString
        throw new UnsupportedOperationException();
    }

}