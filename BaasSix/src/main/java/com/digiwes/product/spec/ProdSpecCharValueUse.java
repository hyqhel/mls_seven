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
        this.prodSpecCharValue = charVal;
        this.isDefault = isDefault;
        this.validFor = validFor;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((prodSpecCharValue == null) ? 0 : prodSpecCharValue
                .hashCode());
        return result;
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        ProdSpecCharValueUse other = (ProdSpecCharValueUse) o;
        if (prodSpecCharValue == null) {
            if (other.prodSpecCharValue != null)
                return false;
        } else if (!prodSpecCharValue.equals(other.prodSpecCharValue))
            return false;
        return true;
    }

    public String toString() {
        // TODO
        return null;
    }

}