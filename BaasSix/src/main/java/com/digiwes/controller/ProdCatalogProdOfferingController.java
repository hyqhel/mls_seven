package com.digiwes.controller;

import com.digiwes.basetype.Condition;
import com.digiwes.common.util.ConvertUtils;
import com.digiwes.product.offering.*;
import com.digiwes.product.offering.catalog.ProdCatalogProdOffer;
import com.digiwes.product.offering.catalog.ProductCatalog;
import com.digiwes.product.spec.ProdSpecCharValueUse;
import com.digiwes.product.spec.ProductSpecCharUse;
import com.digiwes.resources.ConfigData;
import com.digiwes.resources.beans.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuwei29 on 2015/7/18.
 */
public class ProdCatalogProdOfferingController {

    public ProductCatalogResponse retrieveOffering(String productCatalogId, List<Condition> conditions) {
        ProductCatalogResponse response = new ProductCatalogResponse();

        ProductCatalog productCatalog = retrieveProductCatalog(productCatalogId);
        List<ProdCatalogOffering> productCatalogOfferings = null;
        List<ProdCatalogProdOffer> prodCatalogProdOffers = null;

        if (null != productCatalog) {
            prodCatalogProdOffers = productCatalog.retrieveOffering(new Date());
        }

        productCatalogOfferings = retrieveProductOffering(prodCatalogProdOffers, conditions);

        response.setID(productCatalogId);
        response.setName(productCatalog.getName());
        response.setType(productCatalog.getType());
        response.setValidFor(productCatalog.getValidFor());
        response.setProdCatalogOfferings(productCatalogOfferings);

        return response;
    }

    private ProductCatalog retrieveProductCatalog(String productCatalogId) {
        for (ProductCatalog prodCatalog : ConfigData.productCatalogList) {
            if (productCatalogId.equals(prodCatalog.getID())) {
                return prodCatalog;
            }
        }
        return null;
    }

    private List<ProdCatalogOffering> retrieveProductOffering(List<ProdCatalogProdOffer> prodCatalogProdOffers,
                                                              List<Condition> conditions) {
        List<ProdCatalogOffering> prodCatalogOfferings = new ArrayList<ProdCatalogOffering>();

        String charName = "";
        String charValue = "";
        for (Condition condition : conditions) {
            if ("charName".equals(condition.getCode())) {
                charName = condition.getValue();
            }
            if ("charValue".equals(condition.getCode())) {
                charValue = condition.getValue();
            }
        }

        boolean breakKey = false;
        for (ProdCatalogProdOffer prodCatalogProdOffer : prodCatalogProdOffers) {
            if (prodCatalogProdOffer.getProdOffering() instanceof SimpleProductOffering) {
                SimpleProductOffering offering = (SimpleProductOffering) prodCatalogProdOffer.getProdOffering();
                breakKey = false;
                for (ProductSpecCharUse productSpecCharUse : offering.getProductSpecification().getProdSpecChar()) {
                    if (charName.equals(productSpecCharUse.getName())) {
                        for (ProdSpecCharValueUse valueUse : productSpecCharUse.getProdSpecCharValue()) {
                            if (charValue.equals(valueUse.getProdSpecCharValue().getValue())) {
                                //TODO  add breakKey and add convertType
                                prodCatalogOfferings.add(ConvertUtils.convertBeanType(prodCatalogProdOffer));
                                breakKey = true;
                                break;
                            }
                        }
                        if (breakKey) {
                            break;
                        }
                    }
                }


            }
        }
        return prodCatalogOfferings;
    }
}