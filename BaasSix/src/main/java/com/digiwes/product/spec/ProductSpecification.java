package com.digiwes.product.spec;

import java.util.*;
import com.digiwes.basetype.*;

/**
 * A detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to Customers or other Parties playing a PartyRole. A ProductSpecification may consist of other ProductSpecifications supplied together as a collection. Members of the collection may be offered in their own right. ProductSpecifications may also exist within groupings, such as ProductCategories, ProductLines, and ProductTypes.
 */
public abstract class ProductSpecification {

    public List<ProductSpecificationCost> productSpecificationCost;
    public List<ProductSpecificationRelationship> prodSpecRelationship;
    public List<ProductSpecificationVersion> prodSpecVersion;
    public List<ProductSpecCharUse> prodSpecChar;
    public List<CompositeProductSpecification> compositeProdSpec;
    /**
     * The name of the product specification.
     */
    private String name;
    /**
     * The manufacturer or trademark of the specification.
     */
    private String brand;
    /**
     * A narrative that explains in detail what the product spec is.
     */
    private String description;
    /**
     * An identification number assigned to uniquely identify the specification.
     */
    private String productNumber;
    /**
     * The period for which the product specification is valid.
     */
    private TimePeriod validFor;
    /**
     * The condition of the product specification, such as active, inactive, planned.
     */
    private String lifecycleStatus;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductNumber() {
        return this.productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public String getLifecycleStatus() {
        return this.lifecycleStatus;
    }

    /**
     * Initializes a newly created {@code ProductSpecification} object so that it represents the all information. When the specification is a new one, the state of the specification will be initialized as "planned"
     * @param productNumber An identification number assigned to uniquely identify the specification.
     * @param name The name of the product specification.
     * @param brand The manufacturer or trademark of the specification.
     */
    public ProductSpecification(String productNumber, String name, String brand) {
        // TODO - implement ProductSpecification.ProductSpecification
        throw new UnsupportedOperationException();
    }

    /**
     * Initializes a newly created {@code ProductSpecification} object so that it represents the all information. When the specification is a new one, the state of the specification will be initialized as "planned"
     * @param productNumber An identification number assigned to uniquely identify the specification.
     * @param name The name of the product specification.
     * @param brand The manufacturer or trademark of the specification.
     * @param validFor The period of time for which the use of the ProductSpecification is applicable.
     * @param description A narrative that explains in detail what the product spec is.
     */
    public ProductSpecification(String productNumber, String name, String brand, TimePeriod validFor, String description) {
        // TODO - implement ProductSpecification.ProductSpecification
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar A characteristic quality or distinctive feature of a ProductSpecification. The object must exist in the system
     * @param canBeOveridden An indicator that specifies that the CharacteristicSpecValues associated with the CharacteristicSpec cannot be changed when instantiating a ServiceCharacteristicValue. For example, a bandwidth of 64 MB cannot be changed.
     * @param isPackage An indicator that specifies if the associated CharacteristicSpecification is a composite. true£ºis a composite one
     * @param validFor The period of time for which the use of the CharacteristicSpecification is applicable.
     */
    public int attachCharacteristic(String charName, ProductSpecCharacteristic specChar, boolean canBeOveridden, boolean isPackage, TimePeriod validFor) {
        // TODO - implement ProductSpecification.attachCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName A word, term, or phrase by which the CharacteristicSpecification is known and distinguished from other CharacteristicSpecifications.
     * @param specChar A characteristic quality or distinctive feature of a ProductSpecification. The object must exist in the system
     * @param canBeOveridden An indicator that specifies that the CharacteristicSpecValues associated with the CharacteristicSpec cannot be changed when instantiating a ServiceCharacteristicValue. For example, a bandwidth of 64 MB cannot be changed.
     * @param isPackage An indicator that specifies if the associated CharacteristicSpecification is a composite.
     * @param validFor The period of time for which the use of the CharacteristicSpecification is applicable.
     * @param unique An indicator that specifies if a value is unique for the specification. Possible values are: "unique while value is in effect" and "unique whether value is in effect or not"
     * @param minCardinality The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
     * @param maxCardinality The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
     * @param extensible An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a Service.
     * @param description A narrative that explains the CharacteristicSpecification.
     */
    public int attachCharacteristic(String charName, ProductSpecCharacteristic specChar, boolean canBeOveridden, boolean isPackage, TimePeriod validFor, String unique, int minCardinality, int maxCardinality, boolean extensible, String description) {
        // TODO - implement ProductSpecification.attachCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar A characteristic quality or distinctive feature of a ProductSpecification. The {@code ProductSpecification} must have the Characteristic before.
     */
    public int detachCharacteristic(String charName, ProductSpecCharacteristic specChar) {
        // TODO - implement ProductSpecification.detachCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar A characteristic quality or distinctive feature of a ProductSpecification. The {@code ProductSpecification} must have the Characteristic.
     * @param canBeOveridden An indicator that specifies that the CharacteristicSpecValues associated with the CharacteristicSpec cannot be changed when instantiating a ServiceCharacteristicValue. For example, a bandwidth of 64 MB cannot be changed.
     * @param isPackage An indicator that specifies if the associated CharacteristicSpecification is a composite.
     * @param validFor The period of time for which the use of the CharacteristicSpecification is applicable.
     * @param unique An indicator that specifies if a value is unique for the specification. Possible values are: "unique while value is in effect" and "unique whether value is in effect or not"
     * @param minCardinality The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
     * @param maxCardinality The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
     * @param extensible An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a Service.
     * @param description A narrative that explains the CharacteristicSpecification.
     */
    public int modifyCharacteristicInfo(String charName, ProductSpecCharacteristic specChar, boolean canBeOveridden, boolean isPackage, TimePeriod validFor, String unique, int minCardinality, int maxCardinality, boolean extensible, String description) {
        // TODO - implement ProductSpecification.modifyCharacteristicInfo
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar A characteristic quality or distinctive feature of a ProductSpecification. The object must exist in the system
     * @param charValue A number or text that be assigned to a ProductSpecCharacteristic. The value must be in the characterisc's values.
     * @param isDefault Indicates if the value is the default value for a characteristic. true£ºis default value
     * @param validFor The period of time for which the use of the CharacteristicValue is applicable.
     */
    public int assignCharacteristicValue(String charName, ProductSpecCharacteristic specChar, ProductSpecCharacteristicValue charValue, boolean isDefault, TimePeriod validFor) {
        // TODO - implement ProductSpecification.assignCharacteristicValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar
     * @param charValue
     */
    public int removeCharacteristicValue(String charName, ProductSpecCharacteristic specChar, ProductSpecCharacteristicValue charValue) {
        // TODO - implement ProductSpecification.removeCharacteristicValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar
     * @param defaultCharValue
     */
    public int specifyDefaultCharacteristicValue(String charName, ProductSpecCharacteristic specChar, ProductSpecCharacteristicValue defaultCharValue) {
        // TODO - implement ProductSpecification.specifyDefaultCharacteristicValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param characteristic
     * @param defaultValue
     */
    public int clearDefaultCharacteristicValue(String charName, ProductSpecCharUse characteristic, ProductSpecCharacteristicValue defaultValue) {
        // TODO - implement ProductSpecification.clearDefaultCharacteristicValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param characteristic
     */
    public ProdSpecCharValueUse[] retrieveDefaultValue(String charName, ProductSpecCharacteristic characteristic) {
        // TODO - implement ProductSpecification.retrieveDefaultValue
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param time
     */
    public ProductSpecCharUse[] retrieveCharacteristic(Date time) {
        // TODO - implement ProductSpecification.retrieveCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar
     * @param time
     */
    public ProdSpecCharValueUse[] retrieveCharacteristicValue(String charName, ProductSpecCharacteristic specChar, Date time) {
        // TODO - implement ProductSpecification.retrieveCharacteristicValue
        throw new UnsupportedOperationException();
    }

    public ProductSpecCharUse[] retrieveRootCharacteristic() {
        // TODO - implement ProductSpecification.retrieveRootCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar
     * @param time
     */
    public ProductSpecCharUse[] retrieveLeafCharacteristic(String charName, ProductSpecCharacteristic specChar, Date time) {
        // TODO - implement ProductSpecification.retrieveLeafCharacteristic
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param specChar
     * @param minCardinality
     * @param maxCardinality
     */
    public int specifyCardinality(String charName, ProductSpecCharacteristic specChar, int minCardinality, int maxCardinality) {
        // TODO - implement ProductSpecification.specifyCardinality
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param verType
     * @param curTypeVersion
     * @param description
     * @param revisionDate
     * @param validFor
     */
    private int specifyVersion(String verType, String curTypeVersion, String description, int revisionDate, TimePeriod validFor) {
        // TODO - implement ProductSpecification.specifyVersion
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param version
     * @param description
     * @param revisionDate
     * @param validFor
     */
    public int specifyVersion(String version, String description, int revisionDate, TimePeriod validFor) {
        // TODO - implement ProductSpecification.specifyVersion
        throw new UnsupportedOperationException();
    }

    public ProductSpecificationVersion[] retrieveCurrentVersion() {
        // TODO - implement ProductSpecification.retrieveCurrentVersion
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param majorVersion
     * @param description
     * @param revisionDate
     */
    public String modifyMajorVersion(String majorVersion, String description, Date revisionDate) {
        // TODO - implement ProductSpecification.modifyMajorVersion
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param minorVersion
     * @param description
     * @param revisionDate
     */
    public String modifyMinorVersion(String minorVersion, String description, Date revisionDate) {
        // TODO - implement ProductSpecification.modifyMinorVersion
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param patchVersion
     * @param description
     * @param revisionDate
     */
    public String modifyPatchVersion(String patchVersion, String description, Date revisionDate) {
        // TODO - implement ProductSpecification.modifyPatchVersion
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param cost
     * @param validFor
     */
    public int incurCost(Money cost, TimePeriod validFor) {
        // TODO - implement ProductSpecification.incurCost
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param cost
     * @param validFor
     */
    public int modifyCostPeriod(ProductSpecificationCost cost, TimePeriod validFor) {
        // TODO - implement ProductSpecification.modifyCostPeriod
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param time
     */
    public ProductSpecificationCost[] retrieveCost(Date time) {
        // TODO - implement ProductSpecification.retrieveCost
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param prodSpec
     * @param type
     * @param validFor
     */
    public int associate(ProductSpecification prodSpec, String type, TimePeriod validFor) {
        // TODO - implement ProductSpecification.associate
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param prodSpec
     */
    public int dissociate(ProductSpecification prodSpec) {
        // TODO - implement ProductSpecification.dissociate
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param type
     */
    public ProductSpecification[] retrieveRelatedProdSpec(String type) {
        // TODO - implement ProductSpecification.retrieveRelatedProdSpec
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param type
     * @param time
     */
    public ProductSpecification[] retrieveRelatedProdSpec(String type, Date time) {
        // TODO - implement ProductSpecification.retrieveRelatedProdSpec
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param prodSpec
     * @param validFor
     */
    public int modifyRelatedSpecValidPeriod(String charName, ProductSpecification prodSpec, TimePeriod validFor) {
        // TODO - implement ProductSpecification.modifyRelatedSpecValidPeriod
        throw new UnsupportedOperationException();
    }

    /**
     * return a ProductSpecCharUse ?by ProductSpecCharUse and ProductCharacteristic object.
     * 
     * callers are whose parameters including ?charName(use to ?uniqidentify ?uniquely a ProductSpecCharUse ) and ProductspecCharUse Object
     * @param charName
     * @param characteristic
     */
    private ProductSpecCharUse retrieveProdSpecCharUse(String charName, ProductSpecCharacteristic characteristic) {
        // TODO - implement ProductSpecification.retrieveProdSpecCharUse
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param charName
     * @param characteristic
     */
    private boolean contains(String charName, ProductSpecCharacteristic characteristic) {
        // TODO - implement ProductSpecification.contains
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param o
     */
    public boolean equals(Object o) {
        // TODO - implement ProductSpecification.equals
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        // TODO - implement ProductSpecification.hashCode
        throw new UnsupportedOperationException();
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO - implement ProductSpecification.getBasicInfo
        throw new UnsupportedOperationException();
    }

    /**
     * Basic info of the class ouput to String
     */
    public String basicInfoToString() {
        // TODO - implement ProductSpecification.basicInfoToString
        throw new UnsupportedOperationException();
    }

    /**
     * Basic info of the class ouput to String
     */
    public String toString() {
        // TODO - implement ProductSpecification.toString
        throw new UnsupportedOperationException();
    }

}