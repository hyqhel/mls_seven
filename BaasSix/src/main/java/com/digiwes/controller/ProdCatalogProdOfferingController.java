package com.digiwes.controller;

import com.digiwes.basetype.Condition;
import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProductCatalogErrorEnum;
import com.digiwes.common.util.ConvertUtils;
import com.digiwes.product.offering.*;
import com.digiwes.product.offering.catalog.ProdCatalogProdOffer;
import com.digiwes.product.offering.catalog.ProductCatalog;
import com.digiwes.product.spec.ProdSpecCharValueUse;
import com.digiwes.product.spec.ProductSpecCharUse;
import com.digiwes.resources.ConfigData;
import com.digiwes.resources.beans.*;
import com.sun.istack.NotNull;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuwei29 on 2015/7/18.
 */
public class ProdCatalogProdOfferingController {

    public ProductCatalogResponse retrieveOffering(String productCatalogId, Date retrieveTime, List<Condition>
            conditions) {
        ProductCatalogResponse response = new ProductCatalogResponse();

        ProductCatalog productCatalog = retrieveProductCatalog(productCatalogId);
        List<ProdCatalogOffering> productCatalogOfferings = null;
        List<ProdCatalogProdOffer> prodCatalogProdOffers = new ArrayList<ProdCatalogProdOffer>();

        if (null != productCatalog) {
            prodCatalogProdOffers = productCatalog.retrieveOffering(retrieveTime);
        }

        productCatalogOfferings = retrieveProductCatalogOffering(prodCatalogProdOffers, conditions);

        response.setID(productCatalogId);
        response.setName(productCatalog.getName());
        response.setType(productCatalog.getType());
        response.setValidFor(productCatalog.getValidFor());
        response.setProdCatalogOfferings(productCatalogOfferings);

        return response;
    }

    public ProductCatalog retrieveProductCatalog(String productCatalogId) {
        if (StringUtils.isNotEmpty(productCatalogId)) {
            for (ProductCatalog prodCatalog : ConfigData.productCatalogList) {
                if (productCatalogId.equals(prodCatalog.getID())) {
                    return prodCatalog;
                }
            }
        }
        return null;
    }


    public ProductOffering retrieveProductOffering( String offeringId) {
        if (StringUtils.isNotEmpty(offeringId)) {
            for (ProductOffering pc : ConfigData.offerings) {
                if (offeringId.equals(pc.getId())) {
                    return pc;
                }
            }
        }
        return null;
    }

    public int publishOffering(String catalogId, String offeringId, TimePeriod validFor) {
        ProductCatalog pc = retrieveProductCatalog(catalogId);
        int returnCode = -1;
        if (null != pc) {
            ProductOffering productOffering = retrieveProductOffering(offeringId);
            returnCode = pc.publish(productOffering, validFor);
        } else {
            returnCode = ProductCatalogErrorEnum.PRODUCT_CATALOG_IS_NULL.getCode();
        }
        return returnCode;
    }

    public int retiredOffering(String catalogId, String offeringId) {
        ProductCatalog pc = retrieveProductCatalog(catalogId);
        int returnCode = -1;
        if (null != pc) {
            ProductOffering prodOffering = retrieveProductOffering(offeringId);
            returnCode = pc.retired(prodOffering);
        } else {
            returnCode = ProductCatalogErrorEnum.PRODUCT_CATALOG_IS_NULL.getCode();
        }
        return returnCode;
    }

    private List<ProdCatalogOffering> retrieveProductCatalogOffering(List<ProdCatalogProdOffer> prodCatalogProdOffers,
                                                                     List<Condition> conditions) {
        List<ProdCatalogOffering> prodCatalogOfferings = new ArrayList<ProdCatalogOffering>();

        String charName = "";
        String charValue = "";
        if (null != conditions) {
            for (Condition condition : conditions) {
                if ("charName".equals(condition.getCode())) {
                    charName = condition.getValue();
                }
                if ("charValue".equals(condition.getCode())) {
                    charValue = condition.getValue();
                }
            }
        }

        boolean breakKey = false;
        for (ProdCatalogProdOffer prodCatalogProdOffer : prodCatalogProdOffers) {
            if (prodCatalogProdOffer.getProdOffering() instanceof SimpleProductOffering) {
                SimpleProductOffering offering = (SimpleProductOffering) prodCatalogProdOffer.getProdOffering();
                breakKey = false;

                for (ProductSpecCharUse productSpecCharUse : offering.getProductSpecification().getProdSpecChar()) {
                    if (StringUtils.isNotEmpty(charName)) {
                        if (charName.equals(productSpecCharUse.getName())) {
                            for (ProdSpecCharValueUse valueUse : productSpecCharUse.getProdSpecCharValue()) {
                                if (charValue.equals(valueUse.getProdSpecCharValue().getValue())) {
                                    prodCatalogOfferings.add(ConvertUtils.convertBeanType(prodCatalogProdOffer));
                                    breakKey = true;
                                    break;
                                }
                            }
                            if (breakKey) {
                                break;
                            }
                        }
                    } else {
                        prodCatalogOfferings.add(ConvertUtils.convertBeanType(prodCatalogProdOffer));
                        break;
                    }
                }


            }
        }
        return prodCatalogOfferings;
    }
}
