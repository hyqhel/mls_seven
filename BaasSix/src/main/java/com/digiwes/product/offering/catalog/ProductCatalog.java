package com.digiwes.product.offering.catalog;

import com.digiwes.common.catalog.*;

import java.text.SimpleDateFormat;
import java.util.*;

import com.digiwes.basetype.*;
import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductCatalogErrorEnum;
import com.digiwes.common.enums.ProductOfferingErrorEnum;
import com.digiwes.common.util.CommonUtils;
import com.digiwes.common.util.DateUtils;
import com.digiwes.product.offering.*;
import com.digiwes.product.offering.price.*;
import org.apache.log4j.Logger;

/**
 * A list of ProductOfferings for sale, with prices and illustrations, for example in book form or on the web. ProductCatalogs can be used by Customers during a self-care ordering process and may be used across one or more DistributionChannels.
 * <p/>
 * A list of ProductOfferings for sale, with prices and illustrations, for example in book form or on the web. ProductCatalogs can be used by Customers during a self-care ordering process and may be used across one or more DistributionChannels.
 * ?
 */
public class ProductCatalog extends Catalog {
    private static final Logger logger = Logger.getLogger(ProductCatalog.class);
    public List<ProdCatalogProdOffer> prodCatalogProdOffer;

    public List<ProdCatalogProdOffer> getProdCatalogProdOffer() {
        return prodCatalogProdOffer;
    }

    public void setProdCatalogProdOffer(List<ProdCatalogProdOffer> prodCatalogProdOffer) {
        this.prodCatalogProdOffer = prodCatalogProdOffer;
    }

    /**
     * @param id
     * @param name
     * @param type
     */
    public ProductCatalog(String id, String name, String type) {
        super(id, name, type);
    }

    /**
     * @param id
     * @param name
     * @param type
     * @param validFor
     */
    public ProductCatalog(String id, String name, String type, TimePeriod validFor) {
        super(id, name, type, validFor);
    }

    /**
     * @param offering
     * @param validFor
     */
    public int publish(ProductOffering offering, TimePeriod validFor) {

        int code = checkOffering(offering, validFor);
        if (CommonErrorEnum.SUCCESS.getCode() == code){
            ProdCatalogProdOffer catalogProdOffer=new ProdCatalogProdOffer(offering,validFor);
            prodCatalogProdOffer.add(catalogProdOffer);
            return CommonErrorEnum.SUCCESS.getCode();
        }
        return code;
    }

    /**
     * @param offering
     * @param validFor
     * @param price
     */
    public int publish(ProductOffering offering, TimePeriod validFor, List<ProductOfferingPrice> price) {

        if (CommonUtils.checkParamIsNull(offering)) {
            return ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode();
        }
        int retCode = validPublishDate(validFor);
        if (CommonErrorEnum.SUCCESS.getCode() != retCode) {
            return retCode;
        }
        if (null == prodCatalogProdOffer) {
            prodCatalogProdOffer = new ArrayList<ProdCatalogProdOffer>();
        }
        ProdCatalogProdOffer catalogOffer = retrieveProdCatalogProdOffer(offering, validFor);
        if (null != catalogOffer) {
            return ProductCatalogErrorEnum.PUBLISH_REPETITIVE_OFFERING.getCode();
        }
        ProdCatalogProdOffer catalogProdOffer = new ProdCatalogProdOffer(offering, validFor, price);
        if (!contains(offering, validFor)) {
            prodCatalogProdOffer.add(catalogProdOffer);
        } else {
            return ProductCatalogErrorEnum.PUBLISH_REPETITIVE_OFFERING.getCode();
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param offering
     * @param validFor
     */
    public int retired(ProductOffering offering, TimePeriod validFor) {

        if (CommonUtils.checkParamIsNull(offering)) {
            return ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode();
        }
        ProdCatalogProdOffer catalogOffer = retrieveProdCatalogProdOffer(offering, validFor);
        if (null != catalogOffer) {
            catalogOffer.getValidFor().setEndDateTime(new Date());
        } else {
            return ProductCatalogErrorEnum.RETIRED_REPETITIVE_OFFERING.getCode();
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param offering
     */
    public int retired(ProductOffering offering) {
        if (CommonUtils.checkParamIsNull(offering)) {
            return ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode();
        }
        List<ProdCatalogProdOffer> catalogOffers = retrieveProdCatalogProdOffer(offering);
        if (null != catalogOffers && 0 != catalogOffers.size()) {
            for (ProdCatalogProdOffer catalogOffer : catalogOffers) {
                catalogOffer.getValidFor().setEndDateTime(new Date());
            }
        } else {
            return ProductCatalogErrorEnum.RETIRED_REPETITIVE_OFFERING.getCode();
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param offering
     * @param time
     */
    public List<ProductOfferingPrice> retrieveOfferingPrice(ProductOffering offering, int time) {
        // TODO - implement ProductCatalog.retrieveOfferingPrice
        return null;
    }

    /**
     * @param offering
     * @param timePeriod
     * @param price
     */
    public int specifyOfferingPrice(ProductOffering offering, TimePeriod timePeriod, ProductOfferingPrice price) {
        // TODO - implement ProductCatalog.specifyOfferingPrice
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param offering
     * @param timePeriod
     * @param newPrice
     */
    public int alterOfferingPrice(ProductOffering offering, TimePeriod timePeriod, ProductOfferingPrice[] newPrice) {
        // TODO - implement ProductCatalog.alterOfferingPrice
        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param time
     */
    public List<ProdCatalogProdOffer> retrieveOffering(Date time) {
        CommonUtils.checkParameterIsNulForException(time,"time");
        List<ProdCatalogProdOffer> catalogProdOffers = new ArrayList<ProdCatalogProdOffer>();
        if (null != prodCatalogProdOffer) {
            for (ProdCatalogProdOffer catalogProdOffer : prodCatalogProdOffer) {
                if (0 == catalogProdOffer.getValidFor().isInTimePeriod(time)) {
                    catalogProdOffers.add(catalogProdOffer);
                }
            }
        }
        return catalogProdOffers;
    }

    /**
     * @param offeringName
     */
    public List<ProdCatalogProdOffer> retrieveOffering(String offeringName) {
        CommonUtils.checkParameterIsNulForException(offeringName,"offeringName");
        List<ProdCatalogProdOffer> catalogProdOffers = new ArrayList<ProdCatalogProdOffer>();
        if (null != prodCatalogProdOffer) {
            for (ProdCatalogProdOffer catalogProdOffer : prodCatalogProdOffer) {
                if (offeringName.equals(catalogProdOffer.getProdOffering().getName())) {
                    catalogProdOffers.add(catalogProdOffer);
                }
            }
        }
        return catalogProdOffers;
    }

    /**
     * @param time
     * @param offeringName
     */
    public List<ProdCatalogProdOffer> retrieveOffering(String offeringName,Date time) {
        CommonUtils.checkParameterIsNulForException(offeringName,"offeringName");
        CommonUtils.checkParameterIsNulForException(time,"time");
        List<ProdCatalogProdOffer> catalogProdOffers = new ArrayList<ProdCatalogProdOffer>();
        if (null != prodCatalogProdOffer) {
            for (ProdCatalogProdOffer catalogProdOffer : prodCatalogProdOffer) {
                if (0 == catalogProdOffer.getValidFor().isInTimePeriod(time)&&offeringName.equals(catalogProdOffer.getProdOffering().getName())) {
                    catalogProdOffers.add(catalogProdOffer);
                }
            }
        }
        return catalogProdOffers;
    }
    private int checkOffering(ProductOffering offering, TimePeriod validFor) {
        if(CommonUtils.checkParamIsNull(offering)){
            return ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode();
        }
        int retCode = validPublishDate(validFor);
        if(CommonErrorEnum.SUCCESS.getCode() != retCode) {
            return retCode;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = DateUtils.truncDate(new Date());
        if(now.compareTo(validFor.getStartDateTime()) ==1){
            return ProductCatalogErrorEnum.PUBLISH_VALIDFOR_INVALID.getCode();
        }
        if (contains(offering, validFor)){
            return ProductCatalogErrorEnum.PUBLISH_REPETITIVE_OFFERING.getCode();
        }

        if(!validFor.isInTimePeriod(offering.getValidFor())){
            return ProductCatalogErrorEnum.PUBLISH_VALIDFOR_INVALID.getCode();
        }

        return CommonErrorEnum.SUCCESS.getCode();
    }

    /**
     * @param offering
     * @param validFor
     */
    private ProdCatalogProdOffer retrieveProdCatalogProdOffer(ProductOffering offering, TimePeriod validFor) {
        if (null != this.prodCatalogProdOffer && this.prodCatalogProdOffer.size() > 0) {
            for (ProdCatalogProdOffer catalogProdOffer : this.prodCatalogProdOffer) {
                if (offering.equals(catalogProdOffer.getProdOffering()) && validFor.equals(catalogProdOffer.getValidFor
                        ())) {
                    return catalogProdOffer;
                }
            }
        }
        return null;
    }

    /**
     * @param offering
     */
    private List<ProdCatalogProdOffer> retrieveProdCatalogProdOffer(ProductOffering offering) {
        List<ProdCatalogProdOffer> prodCatalogProdOffers = new ArrayList<ProdCatalogProdOffer>();
        if (null != this.prodCatalogProdOffer && this.prodCatalogProdOffer.size() > 0) {
            for (ProdCatalogProdOffer catalogProdOffer : this.prodCatalogProdOffer) {
                if (offering.equals(catalogProdOffer.getProdOffering())) {
                    prodCatalogProdOffers.add(catalogProdOffer);
                }
            }
        }
        return prodCatalogProdOffers;
    }

    /**
     * @param offering
     * @param validFor
     */
    private boolean contains(ProductOffering offering, TimePeriod validFor) {
        if (null != this.prodCatalogProdOffer && this.prodCatalogProdOffer.size() > 0) {
            for (ProdCatalogProdOffer catalogProdOffer : this.prodCatalogProdOffer) {
                if (offering.equals(catalogProdOffer.getProdOffering()) && validFor.isOverlap(catalogProdOffer.getValidFor
                        ())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param offering
     * @param oldValidFor
     * @param newValidFor
     */
    public int modifyOfferingValidTime(ProductOffering offering, TimePeriod oldValidFor, TimePeriod newValidFor) {

        if (CommonUtils.checkParamIsNull(offering)) {
            return ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode();
        }
        if (CommonUtils.checkParamIsNull(oldValidFor)) {
            return CommonErrorEnum.VALIDFOR_IS_NULL.getCode();
        }
        if (CommonUtils.checkParamIsNull(newValidFor)) {
            return CommonErrorEnum.VALIDFOR_IS_NULL.getCode();
        }
        if (null != prodCatalogProdOffer) {
            ProdCatalogProdOffer catalogProdOffer = retrieveProdCatalogProdOffer(offering, oldValidFor);
            if (null != catalogProdOffer) {
                catalogProdOffer.setValidFor(newValidFor);
            } else {
                return ProductCatalogErrorEnum.IS_NOT_PUBLISH_OFFERING.getCode();
            }
        } else {
            return ProductCatalogErrorEnum.IS_NOT_PUBLISH_OFFERING.getCode();
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

    public String toString() {
        // TODO - implement ProductCatalog.toString
        return null;
    }

    private int validPublishDate(TimePeriod validFor) {
        if (CommonUtils.checkParamIsNull(validFor)) {
            return CommonErrorEnum.VALIDFOR_IS_NULL.getCode();
        }

        if (validFor.getStartDateTime().compareTo(validFor.getEndDateTime()) > 0) {
            return CommonErrorEnum.START_TIME_GREATER_THAN_END_TIME.getCode();
        }

        if (validFor.getStartDateTime().compareTo(new Date()) < 0) {
            return CommonErrorEnum.START_TIME_LESS_THAN_CURRENT_TIME.getCode();
        }
        return CommonErrorEnum.SUCCESS.getCode();
    }

}