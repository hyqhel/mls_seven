package com.digiwes.product.offering;

import java.util.*;

import com.digiwes.basetype.*;
import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductOfferingErrorEnum;
import com.digiwes.common.util.CommonUtils;
import org.apache.log4j.Logger;

public class BundledProductOffering extends ProductOffering {

    private static Logger logger = Logger.getLogger(BundledProductOffering.class);

    public List<BundledProdOfferOption> bundledProdOfferOption;

    public List<BundledProdOfferOption> getBundledProdOfferOption() {
        return this.bundledProdOfferOption;
    }

    public void setBundledProdOfferOption(List<BundledProdOfferOption> bundledProdOfferOption) {
        this.bundledProdOfferOption = bundledProdOfferOption;
    }

    /**
     * @param id
     * @param name
     * @param description
     * @param validFor
     */
    public BundledProductOffering(String id, String name, String description, TimePeriod validFor) {
        super(id, name, description, validFor);
    }

    /**
     * @param offering
     */
    public int composedOf(ProductOffering offering) {
        return composeOf(offering, -1, -1);
    }

    /**
     * @param offering
     * @param lowerLimit
     * @param upperLimit
     */
    public int composeOf(ProductOffering offering, int lowerLimit, int upperLimit) {

        if (null == this.bundledProdOfferOption) {
            this.bundledProdOfferOption = new ArrayList<BundledProdOfferOption>();
        }
        if (lowerLimit < -1 || upperLimit < -1) {
            return ProductOfferingErrorEnum.NUMBER_REL_OFFER_LIMIT_INVALID.getCode();
        }
        if (lowerLimit > upperLimit) {
            return ProductOfferingErrorEnum.LOWERLIMIT_GREATER_UPPERLIMIT.getCode();
        }
        if (CommonUtils.checkParamIsNull(offering)) {
            return ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode();
        }
        if (this.equals(offering)) {
            return ProductOfferingErrorEnum.OFFERING_ASSOCIATE_ITSELF.getCode();
        }
        BundledProdOfferOption subOfferingOption = new BundledProdOfferOption(offering, lowerLimit, upperLimit);
        if (this.bundledProdOfferOption.size() > 0) {
            for (BundledProdOfferOption bundledOfferingOption : this.bundledProdOfferOption) {
                if (bundledOfferingOption.equals(subOfferingOption)) {
                    return ProductOfferingErrorEnum.COMPOSE_REPETITIVE_OFFERING.getCode();
                }
            }
        }

        this.bundledProdOfferOption.add(subOfferingOption);
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param offering
     * @param lowerLimit
     * @param upperLimit
     */
    public int modifyOption(ProductOffering offering, int lowerLimit, int upperLimit) {
        // TODO - implement BundledProductOffering.modifyOption
        return CommonErrorEnum.SUCCESS.getCode();
    }

    public List<ProductOffering> retrieveOffering() {
        // TODO - implement BundledProductOffering.retrieveOffering
        return null;
    }

    public String toString() {
        // TODO - implement BundledProductOffering.toString
        return "";
    }

}