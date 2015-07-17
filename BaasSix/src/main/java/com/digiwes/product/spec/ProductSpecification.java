package com.digiwes.product.spec;

import java.util.*;

import com.digiwes.basetype.*;
import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProdSpecStatus;
import com.digiwes.common.enums.ProductSpecErrorEnum;
import com.digiwes.common.enums.RelationshipType;
import com.digiwes.common.util.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * A detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to Customers or other Parties playing a PartyRole. A ProductSpecification may consist of other ProductSpecifications supplied together as a collection. Members of the collection may be offered in their own right. ProductSpecifications may also exist within groupings, such as ProductCategories, ProductLines, and ProductTypes.
 */
public abstract class ProductSpecification {

    private static final Logger log = Logger.getLogger(ProductSpecification.class);

    public List<ProductSpecificationCost> productSpecificationCost;
    public List<ProductSpecificationRelationship> prodSpecRelationship;
    public List<ProductSpecificationVersion> prodSpecVersion;
    public Set<ProductSpecCharUse> prodSpecChar;
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

    public List<CompositeProductSpecification> getCompositeProdSpec() {
        return compositeProdSpec;
    }

    public void setCompositeProdSpec(List<CompositeProductSpecification> compositeProdSpec) {
        this.compositeProdSpec = compositeProdSpec;
    }

    public List<ProductSpecificationCost> getProductSpecificationCost() {
        return productSpecificationCost;
    }

    public void setProductSpecificationCost(List<ProductSpecificationCost> productSpecificationCost) {
        this.productSpecificationCost = productSpecificationCost;
    }

    public List<ProductSpecificationRelationship> getProdSpecRelationship() {
        return prodSpecRelationship;
    }

    public void setProdSpecRelationship(List<ProductSpecificationRelationship> prodSpecRelationship) {
        this.prodSpecRelationship = prodSpecRelationship;
    }

    public List<ProductSpecificationVersion> getProdSpecVersion() {
        return prodSpecVersion;
    }

    public void setProdSpecVersion(List<ProductSpecificationVersion> prodSpecVersion) {
        this.prodSpecVersion = prodSpecVersion;
    }

    public Set<ProductSpecCharUse> getProdSpecChar() {
        return prodSpecChar;
    }

    public void setProdSpecChar(Set<ProductSpecCharUse> prodSpecChar) {
        this.prodSpecChar = prodSpecChar;
    }

    /**
     * Initializes a newly created {@code ProductSpecification} object so that it represents the all information. When the specification is a new one, the state of the specification will be initialized as "planned"
     *
     * @param productNumber An identification number assigned to uniquely identify the specification.
     * @param name          The name of the product specification.
     * @param brand         The manufacturer or trademark of the specification.
     */
    public ProductSpecification(String productNumber, String name, String brand) {

        assert StringUtils.isNotEmpty(productNumber) : "The parameter [productNumber] must be not null";

        this.name = name;
        this.productNumber = productNumber;
        this.brand = brand;
        this.lifecycleStatus = ProdSpecStatus.ACTIVE.getValue();
    }

    /**
     * Initializes a newly created {@code ProductSpecification} object so that it represents the all information. When the specification is a new one, the state of the specification will be initialized as "planned"
     *
     * @param productNumber An identification number assigned to uniquely identify the specification.
     * @param name          The name of the product specification.
     * @param brand         The manufacturer or trademark of the specification.
     * @param validFor      The period of time for which the use of the ProductSpecification is applicable.
     * @param description   A narrative that explains in detail what the product spec is.
     */
    public ProductSpecification(String productNumber, String name, String brand, TimePeriod validFor, String description) {

        assert StringUtils.isNotEmpty(productNumber) : "The parameter [productNumber] must be not null";

        this.name = name;
        this.productNumber = productNumber;
        this.brand = brand;
        this.validFor = validFor;
        this.description = description;
        this.lifecycleStatus = ProdSpecStatus.ACTIVE.getValue();
    }

    /**
     * @param charName
     * @param specChar       A characteristic quality or distinctive feature of a ProductSpecification. The object must exist in the system
     * @param canBeOveridden An indicator that specifies that the CharacteristicSpecValues associated with the CharacteristicSpec cannot be changed when instantiating a ServiceCharacteristicValue. For example, a bandwidth of 64 MB cannot be changed.
     * @param isPackage      An indicator that specifies if the associated CharacteristicSpecification is a composite. true��is a composite one
     * @param validFor       The period of time for which the use of the CharacteristicSpecification is applicable.
     */
    public int attachCharacteristic(String charName, ProductSpecCharacteristic specChar, boolean canBeOveridden, boolean isPackage, TimePeriod validFor) {

        //the parameter of specChar is null
        if (CommonUtils.checkParamIsNull(specChar)) {
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_IS_NULL.getCode();
        }
        if (StringUtils.isEmpty(charName)) {
            return ProductSpecErrorEnum.CHAR_USE_NAME_IS_NULL.getCode();
        }

        //initialize set of ProductSpecCharUse
        initProdSpecCharUseSet();
        //the characteristic has been used under the specification, can't add characteristic again
        if (null == retrieveProdSpecCharUse(charName, specChar)) {
            ProductSpecCharUse prodSpecCharUse = new ProductSpecCharUse(specChar, canBeOveridden, isPackage, validFor, charName);
            prodSpecChar.add(prodSpecCharUse);
        } else {
            return ProductSpecErrorEnum.SPEC_ALREADY_EXISTS_THE_CHAR.getCode();
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param charName       A word, term, or phrase by which the CharacteristicSpecification is known and distinguished from other CharacteristicSpecifications.
     * @param specChar       A characteristic quality or distinctive feature of a ProductSpecification. The object must exist in the system
     * @param canBeOveridden An indicator that specifies that the CharacteristicSpecValues associated with the CharacteristicSpec cannot be changed when instantiating a ServiceCharacteristicValue. For example, a bandwidth of 64 MB cannot be changed.
     * @param isPackage      An indicator that specifies if the associated CharacteristicSpecification is a composite.
     * @param validFor       The period of time for which the use of the CharacteristicSpecification is applicable.
     * @param unique         An indicator that specifies if a value is unique for the specification. Possible values are: "unique while value is in effect" and "unique whether value is in effect or not"
     * @param minCardinality The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
     * @param maxCardinality The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
     * @param extensible     An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a Service.
     * @param description    A narrative that explains the CharacteristicSpecification.
     */
    public int attachCharacteristic(String charName, ProductSpecCharacteristic specChar, boolean canBeOveridden,
                                    boolean isPackage, TimePeriod validFor, String unique, int minCardinality, int
                                            maxCardinality, boolean extensible, String description) {
        //the parameter of specChar is null
        if (CommonUtils.checkParamIsNull(specChar)) {
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_IS_NULL.getCode();
        }
        if (StringUtils.isEmpty(charName)) {
            return ProductSpecErrorEnum.CHAR_USE_NAME_IS_NULL.getCode();
        }

        //initialize set of ProductSpecCharUse
        initProdSpecCharUseSet();
        //the characteristic has been used under the specification, can't add characteristic again
        if (null == retrieveProdSpecCharUse(charName, specChar)) {
            ProductSpecCharUse prodSpecCharUse = new ProductSpecCharUse(specChar, canBeOveridden, isPackage,
                    validFor, charName, unique, minCardinality, maxCardinality, extensible, description);
            prodSpecChar.add(prodSpecCharUse);
        } else {
            return ProductSpecErrorEnum.SPEC_ALREADY_EXISTS_THE_CHAR.getCode();
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param charName
     * @param specChar A characteristic quality or distinctive feature of a ProductSpecification. The {@code ProductSpecification} must have the Characteristic before.
     */
    public int detachCharacteristic(String charName, ProductSpecCharacteristic specChar) {
        // TODO - implement ProductSpecification.detachCharacteristic
        return 0;
    }

    /**
     * @param charName
     * @param specChar       A characteristic quality or distinctive feature of a ProductSpecification. The {@code ProductSpecification} must have the Characteristic.
     * @param canBeOveridden An indicator that specifies that the CharacteristicSpecValues associated with the CharacteristicSpec cannot be changed when instantiating a ServiceCharacteristicValue. For example, a bandwidth of 64 MB cannot be changed.
     * @param isPackage      An indicator that specifies if the associated CharacteristicSpecification is a composite.
     * @param validFor       The period of time for which the use of the CharacteristicSpecification is applicable.
     * @param unique         An indicator that specifies if a value is unique for the specification. Possible values are: "unique while value is in effect" and "unique whether value is in effect or not"
     * @param minCardinality The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
     * @param maxCardinality The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
     * @param extensible     An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a Service.
     * @param description    A narrative that explains the CharacteristicSpecification.
     */
    public int modifyCharacteristicInfo(String charName, ProductSpecCharacteristic specChar, boolean canBeOveridden, boolean isPackage, TimePeriod validFor, String unique, int minCardinality, int maxCardinality, boolean extensible, String description) {
        // TODO - implement ProductSpecification.modifyCharacteristicInfo
        return 0;
    }

    /**
     * @param charName
     * @param specChar  A characteristic quality or distinctive feature of a ProductSpecification. The object must exist in the system
     * @param charValue A number or text that be assigned to a ProductSpecCharacteristic. The value must be in the characterisc's values.
     * @param isDefault Indicates if the value is the default value for a characteristic. true��is default value
     * @param validFor  The period of time for which the use of the CharacteristicValue is applicable.
     */
    public int assignCharacteristicValue(String charName, ProductSpecCharacteristic specChar, ProductSpecCharacteristicValue charValue, boolean isDefault, TimePeriod validFor) {
        //the parameter of specChar is null
        if (CommonUtils.checkParamIsNull(specChar)) {
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_IS_NULL.getCode();
        }
        if (CommonUtils.checkParamIsNull(charValue)) {
            return ProductSpecErrorEnum.CHAR_VALUE_IS_NULL.getCode();
        }
        if (StringUtils.isEmpty(charName)) {
            return ProductSpecErrorEnum.CHAR_USE_NAME_IS_NULL.getCode();
        }
        if (this.prodSpecChar != null) {
            ProductSpecCharUse charUse = this.contains(charName, specChar);
            if (null != specChar.getProdSpecCharValue()
                    && specChar.getProdSpecCharValue().contains(charValue)) {
                charUse.assignValue(charValue, isDefault, validFor);
            } else {
                log.warn("Parameter characteristicValue is not belong to this characteristic ");
            }
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param charName
     * @param specChar
     * @param charValue
     */
    public int removeCharacteristicValue(String charName, ProductSpecCharacteristic specChar, ProductSpecCharacteristicValue charValue) {
        // TODO - implement ProductSpecification.removeCharacteristicValue
        return 0;
    }

    /**
     * @param charName
     * @param specChar
     * @param defaultCharValue
     */
    public int specifyDefaultCharacteristicValue(String charName, ProductSpecCharacteristic specChar, ProductSpecCharacteristicValue defaultCharValue) {
        //the parameter of specChar is null
        if (CommonUtils.checkParamIsNull(prodSpecChar)) {
            return ProductSpecErrorEnum.SPEC_NO_CHAR.getCode();
        }
        if (CommonUtils.checkParamIsNull(specChar)) {
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_IS_NULL.getCode();
        }
        if (CommonUtils.checkParamIsNull(defaultCharValue)) {
            return ProductSpecErrorEnum.CHAR_VALUE_IS_NULL.getCode();
        }
        if (StringUtils.isEmpty(charName)) {
            return ProductSpecErrorEnum.CHAR_USE_NAME_IS_NULL.getCode();
        }

        ProductSpecCharUse charUse = this.contains(charName, specChar);
        if (null != specChar.getProdSpecCharValue()
                && specChar.getProdSpecCharValue().contains(defaultCharValue)) {
            charUse.specifyDefaultCharacteristicValue(defaultCharValue);
        } else {
            log.warn("Parameter characteristicValue is not belong to this characteristic ");
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param charName
     * @param characteristic
     * @param defaultValue
     */
    public int clearDefaultCharacteristicValue(String charName, ProductSpecCharUse characteristic, ProductSpecCharacteristicValue defaultValue) {
        // TODO - implement ProductSpecification.clearDefaultCharacteristicValue
        return 0;
    }

    /**
     * @param charName
     * @param characteristic
     */
    public List<ProdSpecCharValueUse> retrieveDefaultValue(String charName, ProductSpecCharacteristic characteristic) {
        // TODO - implement ProductSpecification.retrieveDefaultValue
        return null;
    }

    /**
     * @param time
     */
    public List<ProductSpecCharUse> retrieveCharacteristic(Date time) {
        List<ProductSpecCharUse> prodSpecCharUseByDate = new ArrayList<ProductSpecCharUse>();
        CommonUtils.checkParamIsNull("time", time);
        if (!CommonUtils.checkParamIsNull(time)) {
            for (ProductSpecCharUse productSpecCharUse : prodSpecChar) {
                TimePeriod validForTime = productSpecCharUse.getProdSpecChar().getValidFor();
                if (0 == validForTime.isInTimePeriod(time)) {
                    prodSpecCharUseByDate.add(productSpecCharUse);
                }
            }
        }
        return prodSpecCharUseByDate;
    }

    /**
     * @param charName
     * @param specChar
     * @param time
     */
    public List<ProdSpecCharValueUse> retrieveCharacteristicValue(String charName, ProductSpecCharacteristic specChar,
                                                                  Date time) {

        List<ProdSpecCharValueUse> prodSpecCharValueUseByDate = new ArrayList<ProdSpecCharValueUse>();

        //the parameter of specChar is null
        if (!CommonUtils.checkParamIsNull(specChar) && StringUtils.isNotEmpty(charName)) {
            ProductSpecCharUse charUse = this.contains(charName, specChar);
            List<ProdSpecCharValueUse> valueUseAllList = charUse.getProdSpecCharValue();
            if (null != valueUseAllList) {
                for (ProdSpecCharValueUse charValueUse : valueUseAllList) {
                    TimePeriod validForTime = charValueUse.getValidFor();
                    if (0 == validForTime.isInTimePeriod(time)) {
                        prodSpecCharValueUseByDate.add(charValueUse);
                    }
                }
            } else {
                log.warn("The characteristic haven't charValue in use");
            }
        }
        return prodSpecCharValueUseByDate;
    }

    public List<ProductSpecCharUse> retrieveRootCharacteristic() {
        List<ProductSpecCharUse> charUseList = new ArrayList<ProductSpecCharUse>();
        if (null != this.prodSpecChar) {
            charUseList.addAll(this.prodSpecChar);
            for (ProductSpecCharUse charUse : this.prodSpecChar) {
                List<ProductSpecCharacteristic> subProdSpecChar = charUse.getProdSpecChar()
                        .retrieveRelatedCharacteristic(RelationshipType.AGGREGATION.getValue());
                if (null != subProdSpecChar) {
                    for (ProductSpecCharacteristic specChar : subProdSpecChar) {
                        ProductSpecCharUse subCharUse = this.retrieveProdSpecCharUse(charUse.getName(), specChar);
                        if (null != subCharUse) {
                            charUseList.remove(subCharUse);
                        }
                    }
                }
            }
        }
        return charUseList;
    }

    /**
     * @param charName
     * @param specChar
     * @param time
     */
    public List<ProductSpecCharUse> retrieveLeafCharacteristic(String charName, ProductSpecCharacteristic specChar,
                                                               Date time) {
        List<ProductSpecCharUse> charUses = new ArrayList<ProductSpecCharUse>();
        List<ProductSpecCharacteristic> subProdSpecChar = null;

        if (!CommonUtils.checkParamIsNull(specChar) && StringUtils.isNotEmpty(charName)) {
            if (CommonUtils.checkParamIsNull(time)) {
                subProdSpecChar = specChar.retrieveRelatedCharacteristic(
                        RelationshipType.AGGREGATION.getValue());
            } else {
                subProdSpecChar = specChar.retrieveRelatedCharacteristic(
                        RelationshipType.AGGREGATION.getValue(), time);
            }
            if (null != subProdSpecChar) {
                for (ProductSpecCharacteristic subSpecChar : subProdSpecChar) {
                    ProductSpecCharUse charUse = this.retrieveProdSpecCharUse(charName, subSpecChar);
                    if (null != charUse) {
                        charUses.add(charUse);
                    }
                }
            }
        }
        return charUses;
    }

    /**
     * @param charName
     * @param specChar
     * @param minCardinality
     * @param maxCardinality
     */
    public int specifyCardinality(String charName, ProductSpecCharacteristic specChar, int minCardinality, int maxCardinality) {
        if (CommonUtils.checkParamIsNull(specChar)) {
            return ProductSpecErrorEnum.PROD_SPEC_CHAR_IS_NULL.getCode();
        }
        if (StringUtils.isEmpty(charName)) {
            return ProductSpecErrorEnum.CHAR_USE_NAME_IS_NULL.getCode();
        }
        ProductSpecCharUse charUse = this.retrieveProdSpecCharUse(charName, specChar);
        if (null != charUse) {
            return charUse.specifyCardinality(minCardinality, maxCardinality);
        } else {
            return ProductSpecErrorEnum.SPEC_NO_USE_THE_CHAR.getCode();
        }
    }

    /**
     * @param verType
     * @param curTypeVersion
     * @param description
     * @param revisionDate
     * @param validFor
     */
    private int specifyVersion(String verType, String curTypeVersion, String description, int revisionDate, TimePeriod validFor) {
        // TODO - implement ProductSpecification.specifyVersion
        return 0;
    }

    /**
     * @param version
     * @param description
     * @param revisionDate
     * @param validFor
     */
    public int specifyVersion(String version, String description, int revisionDate, TimePeriod validFor) {
        // TODO - implement ProductSpecification.specifyVersion
        return 0;
    }

    public List<ProductSpecificationVersion> retrieveCurrentVersion() {
        // TODO - implement ProductSpecification.retrieveCurrentVersion
        return null;
    }

    /**
     * @param majorVersion
     * @param description
     * @param revisionDate
     */
    public String modifyMajorVersion(String majorVersion, String description, Date revisionDate) {
        // TODO - implement ProductSpecification.modifyMajorVersion
        return "";
    }

    /**
     * @param minorVersion
     * @param description
     * @param revisionDate
     */
    public String modifyMinorVersion(String minorVersion, String description, Date revisionDate) {
        // TODO - implement ProductSpecification.modifyMinorVersion
        return "";
    }

    /**
     * @param patchVersion
     * @param description
     * @param revisionDate
     */
    public String modifyPatchVersion(String patchVersion, String description, Date revisionDate) {
        // TODO - implement ProductSpecification.modifyPatchVersion
        return "";
    }

    /**
     * @param cost
     * @param validFor
     */
    public int incurCost(Money cost, TimePeriod validFor) {
        // TODO - implement ProductSpecification.incurCost
        return 0;
    }

    /**
     * @param cost
     * @param validFor
     */
    public int modifyCostPeriod(ProductSpecificationCost cost, TimePeriod validFor) {
        // TODO - implement ProductSpecification.modifyCostPeriod
        return 0;
    }

    /**
     * @param time
     */
    public List<ProductSpecificationCost> retrieveCost(Date time) {
        // TODO - implement ProductSpecification.retrieveCost
        return null;
    }

    /**
     * @param prodSpec
     * @param type
     * @param validFor
     */
    public int associate(ProductSpecification prodSpec, String type, TimePeriod validFor) {
        if (CommonUtils.checkParamIsNull(prodSpec)) {
            return ProductSpecErrorEnum.PROD_SPEC_IS_NULL.getCode();
        }
        if (StringUtils.isEmpty(type)) {
            return ProductSpecErrorEnum.PROD_SPEC_RELATIONSHIP_TYPE_IS_NULL.getCode();
        }

        if (CommonUtils.checkParamIsNull(this.prodSpecRelationship)) {
            this.prodSpecRelationship = new ArrayList<ProductSpecificationRelationship>();
        }
        if (this.equals(prodSpec)) {
            return ProductSpecErrorEnum.PROD_SPEC_EQUALS_TO_CURRENT.getCode();
        }

        ProductSpecificationRelationship productSpecificationRelationship = new ProductSpecificationRelationship(this,
                prodSpec, type, validFor);
        if (this.prodSpecRelationship.contains(productSpecificationRelationship)) {
            return ProductSpecErrorEnum.PROD_SPEC_HAS_RELATED_TO_CURRENT.getCode();
        }
        this.prodSpecRelationship.add(productSpecificationRelationship);
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param prodSpec
     */
    public int dissociate(ProductSpecification prodSpec) {
        // TODO - implement ProductSpecification.dissociate
        return 0;
    }

    /**
     * @param type
     */
    public List<ProductSpecification> retrieveRelatedProdSpec(String type) {
        List<ProductSpecification> productSpecifications = new ArrayList<ProductSpecification>();

        if (StringUtils.isNotEmpty(type)) {
            if (null != this.prodSpecRelationship) {
                Iterator<ProductSpecificationRelationship> iterator = this.prodSpecRelationship.iterator();
                while (iterator.hasNext()) {
                    ProductSpecificationRelationship productSpecRelationship = iterator.next();
                    if (type.equals(productSpecRelationship.getType())) {
                        productSpecifications.add(productSpecRelationship.getTargetProdSpec());
                    }
                }
            }
        }
        return productSpecifications;
    }

    /**
     * @param type
     * @param time
     */
    public List<ProductSpecification> retrieveRelatedProdSpec(String type, Date time) {

        List<ProductSpecification> rtnResultRelations = new ArrayList<ProductSpecification>();
        if (StringUtils.isNotEmpty(type) && CommonUtils.checkParamIsNull(this.prodSpecRelationship)) {
            if (CommonUtils.checkParamIsNull(time)) {
                for (ProductSpecificationRelationship prodSpecRelate : this.prodSpecRelationship) {
                    if (prodSpecRelate.getType().equals(type)) {
                        rtnResultRelations.add(prodSpecRelate.getTargetProdSpec());
                    }
                }
            } else {
                for (ProductSpecificationRelationship prodSpecRelate : this.prodSpecRelationship) {
                    if (prodSpecRelate.getValidFor().isInTimePeriod(time) == 0 && prodSpecRelate.getType().equals(type)) {
                        rtnResultRelations.add(prodSpecRelate.getTargetProdSpec());
                    }
                }
            }
        }
        return rtnResultRelations;
    }

    /**
     * @param charName
     * @param prodSpec
     * @param validFor
     */
    public int modifyRelatedSpecValidPeriod(String charName, ProductSpecification prodSpec, TimePeriod validFor) {
        // TODO - implement ProductSpecification.modifyRelatedSpecValidPeriod
        return 0;
    }

    /**
     * return a ProductSpecCharUse ?by ProductSpecCharUse and ProductCharacteristic object.
     * <p>
     * callers are whose parameters including ?charName(use to ?uniqidentify ?uniquely a ProductSpecCharUse ) and ProductspecCharUse Object
     *
     * @param charName
     * @param characteristic
     */
    private ProductSpecCharUse retrieveProdSpecCharUse(String charName, ProductSpecCharacteristic characteristic) {
        if (null != this.prodSpecChar) {
            for (ProductSpecCharUse charUse : this.prodSpecChar) {
                if (characteristic.equals(charUse.getProdSpecChar()) && charUse.getName().equals(name)) {
                    return charUse;
                }
            }
        }
        return null;
    }

    /**
     * @param charName
     * @param characteristic
     */
    private ProductSpecCharUse contains(String charName, ProductSpecCharacteristic characteristic) {
        ProductSpecCharUse charUse = this.retrieveProdSpecCharUse(charName, characteristic);
        return charUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSpecification that = (ProductSpecification) o;

        if (prodSpecVersion != null ? !prodSpecVersion.equals(that.prodSpecVersion) : that.prodSpecVersion != null)
            return false;
        return productNumber.equals(that.productNumber);

    }

    @Override
    public int hashCode() {
        int result = prodSpecVersion != null ? prodSpecVersion.hashCode() : 0;
        result = 31 * result + productNumber.hashCode();
        return result;
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO - implement ProductSpecification.getBasicInfo
        return null;
    }

    /**
     * Basic info of the class ouput to String
     */
    public String basicInfoToString() {
        // TODO - implement ProductSpecification.basicInfoToString
        return "";
    }

    /**
     * Basic info of the class ouput to String
     */
    public String toString() {
        // TODO - implement ProductSpecification.toString
        return "";
    }

    /**
     * initialize set of ProductSpecCharUse
     */
    private void initProdSpecCharUseSet() {
        if (null == prodSpecChar) {
            prodSpecChar = new HashSet<ProductSpecCharUse>();
        }
    }

}