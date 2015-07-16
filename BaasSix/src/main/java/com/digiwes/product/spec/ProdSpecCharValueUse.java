package com.digiwes.product.spec;

import com.digiwes.basetype.*;

/**
 * A use of the ProdSpecCharacteristicValue by an ProductSpecification to which additional properties (attributes) apply or override the properties of similar properties contained in ProdSpecCharacteristicValue.
 */
public class ProdSpecCharValueUse {

    public ProductSpecCharacteristicValue prodSpecCharValue;
    /**
     * Indicates if the value is the default value for a characteristic.
     */
    private boolean isDefault;
    /**
     * The period of time for which the use of the CharacteristicSpecificationValue is applicable.
     */
    private TimePeriod validFor;

    public boolean isIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public ProductSpecCharacteristicValue getProdSpecCharValue() {
        return prodSpecCharValue;
    }

    public void setProdSpecCharValue(ProductSpecCharacteristicValue prodSpecCharValue) {
        this.prodSpecCharValue = prodSpecCharValue;
    }

    /**
     * 
     * @param charVal
     * @param isDefault
     * @param validFor
     */
    public ProdSpecCharValueUse(ProductSpecCharacteristicValue charVal, boolean isDefault, TimePeriod validFor) {
        // TODO - implement ProdSpecCharValueUse.ProdSpecCharValueUse
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        // TODO - implement ProdSpecCharValueUse.hashCode
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement ProdSpecCharValueUse.equals
        throw new UnsupportedOperationException();
    }

    public String toString() {
        // TODO
        return null;
    }

}