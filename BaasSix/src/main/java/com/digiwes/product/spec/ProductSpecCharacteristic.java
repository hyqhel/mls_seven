package com.digiwes.product.spec;

import java.util.*;
import com.digiwes.basetype.*;
import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductSpecErrorEnum;
import com.digiwes.common.enums.RelationshipType;
import com.digiwes.common.util.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * A characteristic quality or distinctive feature of a ProductSpecification. The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.
 */
public class ProductSpecCharacteristic {
    private static final Logger logger = Logger.getLogger(ProductSpecCharacteristic.class);

    public Set<ProductSpecCharacteristicValue> prodSpecCharValue;
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

    public List<ProductSpecCharRelationship> getProdSpecCharRelationship() {
        return prodSpecCharRelationship;
    }

    public Set<ProductSpecCharacteristicValue> getProdSpecCharValue() {
        return prodSpecCharValue;
    }

    public void setProdSpecCharValue(Set<ProductSpecCharacteristicValue> prodSpecCharValue) {
        this.prodSpecCharValue = prodSpecCharValue;
    }

    public void setProdSpecCharRelationship(List<ProductSpecCharRelationship> prodSpecCharRelationship) {
        this.prodSpecCharRelationship = prodSpecCharRelationship;
    }

    /**
     * 
     * @param id
     * @param name
     * @param valueType
     */
    public ProductSpecCharacteristic(String id, String name, String valueType) {
        assert !StringUtils.isEmpty(id):"id should not be null";
        assert !StringUtils.isEmpty(valueType):"valueType should not be null";
        assert !StringUtils.isEmpty(name):"name should not be null";
        this.ID = id;
        this.name = name;
        this.valueType = valueType;
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
        assert !StringUtils.isEmpty(id):"id should not be null";
        assert !StringUtils.isEmpty(valueType):"valueType should not be null";
        assert !StringUtils.isEmpty(name):"name should not be null";
        assert !(minCardinality>maxCardinality):"maxCardinality is less than minCardinality";
        this.ID = id;
        this.name = name;
        this.valueType = valueType;
        this.validFor = validFor;
        this.unique = unique;
        this.minCardinality = minCardinality;
        this.maxCardinality = maxCardinality;
        this.extensible = extensible;
        this.description = description;
        this.derivationFormula = derivationFormula;
    }

    /**
     * 
     * @param minCardinality
     * @param maxCardinality
     */
    public int specifyCardinality(int minCardinality, int maxCardinality) {
        if (minCardinality > maxCardinality){
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_MAX_LESS_THAN_MIN.getCode();
        }
        this.minCardinality =minCardinality;
        this.maxCardinality =maxCardinality;
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * 
     * @param charVal
     */
    public int assignValue(ProductSpecCharacteristicValue charVal) {
        if(CommonUtils.checkParamIsNull(charVal)){
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_VALUE_IS_NULL.getCode();
        }
        if(null == this.prodSpecCharValue){
            this.prodSpecCharValue = new HashSet<ProductSpecCharacteristicValue>();
        }
        for (ProductSpecCharacteristicValue pscv:prodSpecCharValue){
            if(pscv.equals(charVal)){
                return ProductSpecErrorEnum.THE_SPEC_CHAR_HAS_USE_THE_VALUE.getCode();
            }
        }
        this.prodSpecCharValue.add(charVal);
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * 
     * @param charVal
     */
    public int removeValue(ProductSpecCharacteristicValue charVal) {
        if(CommonUtils.checkParamIsNull(charVal)){
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_VALUE_IS_NULL.getCode();
        }
        if(null != this.prodSpecCharValue && this.prodSpecCharValue.size()>0){
            if(prodSpecCharValue.contains(charVal)){
                prodSpecCharValue.remove(charVal);
            }
        }
        return  CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * 
     * @param time
     */
    public List<ProductSpecCharacteristicValue> retrieveValue(Date time) {
        List<ProductSpecCharacteristicValue> productSpecCharValues = new ArrayList<ProductSpecCharacteristicValue>();
        if(CommonUtils.checkParamIsNull(time)){
            CommonErrorEnum.TIME_IS_NULL.getCode();
        }
        if ( null != this.prodSpecCharValue ) {
            for (ProductSpecCharacteristicValue charValue : prodSpecCharValue) {
                if (null != charValue.getValidFor() && 0 == charValue.getValidFor().isInTimePeriod(time)) {
                    productSpecCharValues.add(charValue);
                }
            }
        }
        return productSpecCharValues;
    }

    /**
     * 
     * @param defaultCharVal
     */
    public int specifyDefaultValue(ProductSpecCharacteristicValue defaultCharVal) {
        if(CommonUtils.checkParamIsNull(defaultCharVal)){
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_VALUE_IS_NULL.getCode();
        }
        if(null != this.prodSpecCharValue){
            for(ProductSpecCharacteristicValue productSpecCharacteristicValue:prodSpecCharValue){
                if(productSpecCharacteristicValue.equals(defaultCharVal)){
                    if(!productSpecCharacteristicValue.isIsDefault()){
                        productSpecCharacteristicValue.setIsDefault(true);
                    }
                }
            }
        }else{
            return ProductSpecErrorEnum.THE_SPEC_NO_USE_VALUE.getCode();
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * 
     * @param value
     */
    public int clearDefaultValue(ProductSpecCharacteristicValue value) {
        // TODO - implement ProductSpecCharacteristic.clearDefaultValue
        return 0;
    }

    public List<ProductSpecCharacteristicValue> retrieveDefaultValue() {
        if(CommonUtils.checkParamIsNull(this.prodSpecCharValue)) {
            return  null;
        }else{
            List<ProductSpecCharacteristicValue> psvcoll = new ArrayList<ProductSpecCharacteristicValue>();
            for(ProductSpecCharacteristicValue productSpecCharacteristicValue :prodSpecCharValue){
                if(productSpecCharacteristicValue.isIsDefault()){
                    psvcoll.add(productSpecCharacteristicValue);
                }
            }
            return psvcoll;
        }
    }

    /**
     * 
     * @param specChar
     * @param type
     * @param validFor
     */
    public int associate(ProductSpecCharacteristic specChar, String type, TimePeriod validFor) {
        if(CommonUtils.checkParamIsNull(prodSpecCharRelationship )){
            prodSpecCharRelationship = new ArrayList<ProductSpecCharRelationship>();
        }
        ProductSpecCharRelationship relationship=this.retrieveCharRelationship(specChar);
        if(null != relationship){
            if(type.equals(relationship.getCharRelationshipType()) && relationship.getValidFor().isOverlap(validFor)){
               return ProductSpecErrorEnum.PROD_SPEC_CHAR_HAS_RELATED_TO_CURRENT.getCode();
            }
        }
        ProductSpecCharRelationship pship = new ProductSpecCharRelationship(this,specChar,type,validFor);
        prodSpecCharRelationship.add(pship);
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * 
     * @param specChar
     * @param type
     * @param validFor
     * @param charSpecSeq
     */
    public int associate(ProductSpecCharacteristic specChar, String type, TimePeriod validFor, int charSpecSeq) {
        if(CommonUtils.checkParamIsNull(prodSpecCharRelationship )){
            this.prodSpecCharRelationship =new ArrayList<ProductSpecCharRelationship>();
        }
        ProductSpecCharRelationship relationship=this.retrieveCharRelationship(specChar);
        if(null != relationship){
            if(type.equals(relationship.getCharRelationshipType()) && relationship.getValidFor().isOverlap(validFor)){
                return ProductSpecErrorEnum.PROD_SPEC_CHAR_HAS_RELATED_TO_CURRENT.getCode();
            }
        }
        ProductSpecCharRelationship ship = new ProductSpecCharRelationship(this,specChar,type,validFor,charSpecSeq);
        this.prodSpecCharRelationship.add(ship);
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * 
     * @param specChar
     */
    public int dissociate(ProductSpecCharacteristic specChar) {
        if(CommonUtils.checkParamIsNull(specChar)){
            throw new IllegalArgumentException("Parameter specChar should not be  null");
        }
        if(CommonUtils.checkParamIsNull(prodSpecCharRelationship)){
            return 0;
        }
        for(ProductSpecCharRelationship psr:prodSpecCharRelationship){
            if(psr.getTargetProdSpecChar().equals(specChar)){
                prodSpecCharRelationship.remove(psr);
            }
        }
        return 0;
    }

    /**
     * 
     * @param charRelationshipType
     */
    public List<ProductSpecCharacteristic> retrieveRelatedCharacteristic(String charRelationshipType) {
        if(StringUtils.isEmpty(charRelationshipType)){
            throw new IllegalArgumentException("type should not be null.");
        }
        List<ProductSpecCharacteristic>  characteristic=new ArrayList<ProductSpecCharacteristic>();
        if ( null != prodSpecCharRelationship ) {
            for (ProductSpecCharRelationship productSpecCharRelationship : prodSpecCharRelationship) {
                if(charRelationshipType.equals(productSpecCharRelationship.getCharRelationshipType())){
                    characteristic.add(productSpecCharRelationship.getTargetProdSpecChar());
                }
            }
        }
        return characteristic;
    }

    /**
     * 
     * @param charRelationshipType
     * @param time
     */
    public List<ProductSpecCharacteristic> retrieveRelatedCharacteristic(String charRelationshipType, Date time) {
        if (StringUtils.isEmpty(charRelationshipType) ) {
            throw new IllegalArgumentException("type or dateTime  should not be null");
        }
        if(CommonUtils.checkParamIsNull(time)){
            logger.error(" dateTime  should not be null");
            throw new IllegalArgumentException(" dateTime  should not be null");
        }
        List<ProductSpecCharacteristic>  characteristic=new ArrayList<ProductSpecCharacteristic>();;
        if (null !=prodSpecCharRelationship ) {
            for (ProductSpecCharRelationship productSpecCharRelationship : prodSpecCharRelationship) {
                if(charRelationshipType.equals(productSpecCharRelationship.getCharRelationshipType()) && 0 == productSpecCharRelationship.getValidFor().isInTimePeriod(time)){
                    characteristic.add(productSpecCharRelationship.getTargetProdSpecChar());
                }
            }
        }
        return characteristic;
    }

    /**
     * Search the association that has existed between Characteristic. 
     * 
     * avoid to duplicate.
     * @param characteristic
     */
    private ProductSpecCharRelationship retrieveCharRelationship(ProductSpecCharacteristic characteristic) {
        if(CommonUtils.checkParamIsNull(characteristic)){
            logger.error("characteristic  should not be null");
            throw new IllegalArgumentException("characteristic  should not be null");
        }
        if (null !=prodSpecCharRelationship) {
            for (ProductSpecCharRelationship productSpecCharRelationship : prodSpecCharRelationship) {
                if( productSpecCharRelationship.getTargetProdSpecChar().equals(characteristic)){
                    return productSpecCharRelationship;
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param prodSpecChar
     * @param validFor
     */
    public int modifyRelationshipValidPeriod(ProductSpecCharacteristic prodSpecChar, TimePeriod validFor) {
        // TODO - implement ProductSpecCharacteristic.modifyRelationshipValidPeriod
        return 0;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
        if (!(o instanceof ProductSpecCharacteristic))
            return false;
        ProductSpecCharacteristic other = (ProductSpecCharacteristic) o;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        return true;
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO
        return null;
    }

    /**
     * Basic info of the class ouput to String
     */
    public String basicInfoToString() {
        // TODO
        return null;
    }

    public String toString() {
        // TODO
        return null;
    }

}