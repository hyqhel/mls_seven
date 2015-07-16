package com.digiwes.product.offering;

import java.util.*;

import com.digiwes.basetype.*;
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
            logger.error("Parameter [lowerLimit]¡¢[upperLimit] is not valid. lowerLimit=" + lowerLimit + "; " +
                    "upperLimit=" + upperLimit);
            return 0;
        }
        if (lowerLimit > upperLimit) {
            logger.error("the lowLimit must be much lower than upperLimit. lowerLimit=" + lowerLimit + "; " +
                    "upperLimit=" + upperLimit);
            return 0;
        }
        if (CommonUtils.checkParamIsNull(offering)) {
            logger.error("Parameter [offering] cannot be null.");
            return 0;
        }
        if (this.equals(offering)) {
            logger.error("Cannot add subOffering with it self!");
            return 0;
        }
        BundledProdOfferOption subOfferingOption = new BundledProdOfferOption(offering, lowerLimit, upperLimit);
        if (this.bundledProdOfferOption.size() > 0) {
            for (BundledProdOfferOption bundledOfferingOption : this.bundledProdOfferOption) {
                if (bundledOfferingOption.equals(subOfferingOption)) {
                    logger.error("the subProdSpec already exist, Cannot repeatedly create subOffering. OfferingID="
                            + offering.getId());
                    return 0;
                }
            }
        }

        this.bundledProdOfferOption.add(subOfferingOption);
        return 0;
    }

    /**
     * @param offering
     * @param lowerLimit
     * @param upperLimit
     */
    public int modifyOption(ProductOffering offering, int lowerLimit, int upperLimit) {
        // TODO - implement BundledProductOffering.modifyOption
        return 0;
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