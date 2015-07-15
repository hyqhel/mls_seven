package com.digiwes.product.spec;

import java.util.*;
import com.digiwes.basetype.*;

public class ProductSpecCharUse {

    ProductSpecCharacteristic prodSpecChar;
    public List<ProdSpecCharValueUse> prodSpecCharValue;
    /**
     * A word, term, or phrase by which the CharacteristicSpecification is known and distinguished from other CharacteristicSpecifications.
     */
    private String name;
    /**
     * A narrative that explains the CharacteristicSpecification.
     */
    private String description;
    /**
     * An indicator that specifies if a value is unique for the specification.
     * 
     * Possible values are: "unique while value is in effect" and "unique whether value is in effect or not"
     */
    private String unique;
    /**
     * An indicator that specifies if the associated CharacteristicSpecification is a composite.
     */
    private boolean isPackage;
    /**
     * An indicator that specifies that the CharacteristicSpecValues associated with the CharacteristicSpec cannot be changed when instantiating a ServiceCharacteristicValue. For example, a bandwidth of 64 MB cannot be changed.
     */
    private boolean canBeOveridden;
    /**
     * The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
     */
    private int minCardinality;
    /**
     * The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
     */
    private int maxCardinality;
    /**
     * An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a Service.
     */
    private boolean extensible;

    public ProductSpecCharacteristic getProdSpecChar() {
        return this.prodSpecChar;
    }

    public void setProdSpecChar(ProductSpecCharacteristic prodSpecChar) {
        this.prodSpecChar = prodSpecChar;
    }

    public List<ProdSpecCharValueUse> getProdSpecCharValue() {
        return this.prodSpecCharValue;
    }

    public void setProdSpecCharValue(List<ProdSpecCharValueUse> prodSpecCharValue) {
        this.prodSpecCharValue = prodSpecCharValue;
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

    public boolean isIsPackage() {
        return this.isPackage;
    }

    public void setIsPackage(boolean isPackage) {
        this.isPackage = isPackage;
    }

    public boolean isCanBeOveridden() {
        return this.canBeOveridden;
    }

    public void setCanBeOveridden(boolean canBeOveridden) {
        this.canBeOveridden = canBeOveridden;
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

    /**
     * 
     * @param specChar
     * @param canBeOveridden
     * @param isPackage
     * @param validFor
     * @param name
     */
    public ProductSpecCharUse(ProductSpecCharacteristic specChar, boolean canBeOveridden, boolean isPackage, TimePeriod validFor, String name) {
        // TODO - implement ProductSpecCharUse.ProductSpecCharUse
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param specChar
     * @param canBeOveridden
     * @param isPackage
     * @param validFor
     * @param name
     * @param unique
     * @param minCardinality
     * @param maxCardinality
     * @param extensible
     * @param description
     */
    public ProductSpecCharUse(ProductSpecCharacteristic specChar, boolean canBeOveridden, boolean isPackage, TimePeriod validFor, String name, String unique, int minCardinality, int maxCardinality, boolean extensible, String description) {
        // TODO - implement ProductSpecCharUse.ProductSpecCharUse
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param minCardinality
     * @param maxCardinality
     */
    public int specifyCardinality(int minCardinality, int maxCardinality) {
        // TODO - implement ProductSpecCharUse.specifyCardinality
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charValue
     * @param isDefault
     * @param validFor
     */
    public int assignValue(ProductSpecCharacteristicValue charValue, boolean isDefault, TimePeriod validFor) {
        // TODO - implement ProductSpecCharUse.assignValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charValue
     */
    public int removeValue(ProductSpecCharacteristicValue charValue) {
        // TODO - implement ProductSpecCharUse.removeValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param defaultValue
     */
    public int specifyDefaultCharacteristicValue(ProductSpecCharacteristicValue defaultValue) {
        // TODO - implement ProductSpecCharUse.specifyDefaultCharacteristicValue
        throw new UnsupportedOperationException();
    }

    public ProdSpecCharValueUse[] retrieveDefaultValueUse() {
        // TODO - implement ProductSpecCharUse.retrieveDefaultValueUse
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param defaultValue
     */
    public int clearDefaultValueUse(ProductSpecCharacteristicValue defaultValue) {
        // TODO - implement ProductSpecCharUse.clearDefaultValueUse
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charValue
     */
    private ProdSpecCharValueUse retrieveProdSpecCharValueUse(ProductSpecCharacteristicValue charValue) {
        // TODO - implement ProductSpecCharUse.retrieveProdSpecCharValueUse
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        // TODO - implement ProductSpecCharUse.hashCode
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement ProductSpecCharUse.equals
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO - implement ProductSpecCharUse.toString
        throw new UnsupportedOperationException();
    }

}