package com.digiwes.product.offering;

import java.util.*;

import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductOfferingErrorEnum;
import com.digiwes.common.enums.ProductOfferingStatus;
import com.digiwes.common.util.CommonUtils;
import com.digiwes.product.offering.price.*;
import com.digiwes.basetype.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * The presentation of one or more ProductSpecifications to the marketplace for sale, rental, or lease for a ProductOfferingPrice. A ProductOffering may target one or more MarketSegments, be included in one or more ProductCatalog, presented in support of one or more ProductStrategies, and made available in one or more Places. ProductOffering may represent a simple offering of a single ProductSpecification or could represent a bundling of one or more other ProductOffering.
 */
public abstract class ProductOffering {

    private static Logger logger = Logger.getLogger(ProductOffering.class);

    public List<ProductOfferingPrice> productOfferingPrice;
    public List<ProductOfferingRelationship> prodOfferingRelationship;

    public List<ProductOfferingRelationship> getProdOfferingRelationship() {
        return prodOfferingRelationship;
    }

    public List<ProductOfferingPrice> getProductOfferingPrice() {
        return productOfferingPrice;
    }

    public void setProductOfferingPrice(List<ProductOfferingPrice> productOfferingPrice) {
        this.productOfferingPrice = productOfferingPrice;
    }

    public void setProdOfferingRelationship(List<ProductOfferingRelationship> prodOfferingRelationship) {
        this.prodOfferingRelationship = prodOfferingRelationship;
    }

    /**
     * A unique identifier for the ProductOffering.
     */
    private String id;
    /**
     * A word, term, or phrase by which the ProductOffeirng is known and distinguished from other ProductOfferings.
     */
    private String name;
    /**
     * A narrative that explains what the offering is.
     */
    private String description;
    /**
     * The period during which the offering is applicable.
     */
    private TimePeriod validFor;
    /**
     * The condition in which the offering exists, such as planned, obsolete, active
     */
    private String status;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public TimePeriod getValidFor() {
        return this.validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public String getStatus() {
        return this.status;
    }


    /**
     * @param id
     * @param name
     * @param description
     * @param validFor
     */
    public ProductOffering(String id, String name, String description, TimePeriod validFor) {

        assert StringUtils.isNotEmpty(id) : "Param [id] must be not null!";

        this.id = id;
        this.name = name;
        this.description = description;
        this.validFor = validFor;
        this.status = ProductOfferingStatus.PLANNED.getValue();
    }

    /**
     * @param offering
     * @param relationType
     * @param validFor
     */
    public int associate(ProductOffering offering, String relationType, TimePeriod validFor) {
        if (null == this.prodOfferingRelationship) {
            this.prodOfferingRelationship = new ArrayList<ProductOfferingRelationship>();
        }
        if (CommonUtils.checkParamIsNull(offering)) {
            return ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode();
        }
        if (StringUtils.isEmpty(relationType)) {
            return ProductOfferingErrorEnum.OFFERING_RELATIONSHIP_TYPE_IS_NULL.getCode();
        }
        if (this.equals(offering)) {
            return ProductOfferingErrorEnum.OFFERING_ASSOCIATE_ITSELF.getCode();
        }
        if (this.prodOfferingRelationship.size() > 0) {
            for (ProductOfferingRelationship offeringRelationship : this.prodOfferingRelationship) {
                if (offering.equals(offeringRelationship.getTargetOffering()) && relationType.equals
                        (offeringRelationship.getTypeRelationship()) && offeringRelationship.getValidFor().isOverlap(validFor)) {
                    return ProductOfferingErrorEnum.OFFERING_RELATIONSHIP_EXISTING.getCode();
                }
            }
        }

        ProductOfferingRelationship offeringRelationship = new ProductOfferingRelationship(this, offering, relationType, validFor);
        this.prodOfferingRelationship.add(offeringRelationship);
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param offering
     */
    public int dissociate(ProductOffering offering) {
        // TODO - implement ProductOffering.dissociate
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param relationType
     */
    public List<ProductOffering> retrieveRelatedOffering(String relationType) {
        List<ProductOffering> offerings = new ArrayList<ProductOffering>();
        if (StringUtils.isNotEmpty(relationType)) {
            if (null != this.prodOfferingRelationship && this.prodOfferingRelationship.size() > 0) {
                for (ProductOfferingRelationship relationship : prodOfferingRelationship) {
                    if (relationType.equals(relationship.getTypeRelationship())) {
                        offerings.add(relationship.getTargetOffering());
                    }
                }
            }
        }
        return offerings;
    }

    /**
     * @param relationType
     * @param time
     */
    public List<ProductOffering> retrieveRelatedOffering(String relationType, Date time) {
        List<ProductOffering> offerings = new ArrayList<ProductOffering>();
        if (StringUtils.isNotEmpty(relationType) && CommonUtils.checkParamIsNull(time)) {
            if (null != this.prodOfferingRelationship && this.prodOfferingRelationship.size() > 0) {
                for (ProductOfferingRelationship relationship : prodOfferingRelationship) {
                    if (relationType.equals(relationship.getTypeRelationship()) && 0 == relationship.getValidFor().isInTimePeriod(time) && 0 == relationship.getValidFor().isInTimePeriod(time)) {
                        offerings.add(relationship.getTargetOffering());
                    }
                }
            }
        }
        return offerings;
    }

    /**
     * @param price
     */
    public int specifyPrice(ProductOfferingPrice price) {
        // TODO - implement ProductOffering.specifyPrice
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param price
     */
    private int removePrice(ProductOfferingPrice price) {
        // TODO - implement ProductOffering.removePrice
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param newPrice
     */
    public void alterPrice(ProductOfferingPrice[] newPrice) {
        // TODO - implement ProductOffering.alterPrice
    }

    /**
     * @param time
     */
    public List<ProductOfferingPrice> retrievePrice(Date time) {
        // TODO - implement ProductOffering.retrievePrice
        return null;
    }

    /**
     * Basic information of the class output into the Map
     */
    protected Map getBasicInfo() {
        // TODO - implement ProductOffering.getBasicInfo
        return null;
    }

    /**
     * Basic info of the class ouput to String
     */
    public String basicInfoToString() {
        // TODO - implement ProductOffering.basicInfoToString
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductOffering that = (ProductOffering) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}