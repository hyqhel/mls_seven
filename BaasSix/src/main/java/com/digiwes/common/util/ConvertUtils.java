package com.digiwes.common.util;

import com.digiwes.product.offering.*;
import com.digiwes.product.offering.catalog.ProdCatalogProdOffer;
import com.digiwes.product.spec.ProdSpecCharValueUse;
import com.digiwes.product.spec.ProductSpecCharUse;
import com.digiwes.product.spec.ProductSpecification;
import com.digiwes.resources.beans.*;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuwei29 on 2015/7/18.
 */
public class ConvertUtils {

    public static ProdCatalogOffering convertBeanType(ProdCatalogProdOffer prodCatalogProdOffer) {
        ProdCatalogOffering retProdCatalogOffering = new ProdCatalogOffering();
        retProdCatalogOffering.setProdOffering(convertBeanType(prodCatalogProdOffer.getProdOffering()));
        retProdCatalogOffering.setValidFor(prodCatalogProdOffer.getValidFor());
        return retProdCatalogOffering;
    }

    public static ProdOffering convertBeanType(ProductOffering offering) {
        ProdOffering retProdOffering = new ProdOffering();

        try {
            //copy base properties
            BeanUtils.copyProperties(retProdOffering, offering);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        if (offering instanceof BundledProductOffering) {
            retProdOffering.setIsBundle(true);
            List<BundledOffering> bundledOfferings = new ArrayList<BundledOffering>();
            BundledProductOffering bundledProductOffering = (BundledProductOffering) offering;
            if (null != bundledProductOffering.getBundledProdOfferOption() && bundledProductOffering
                    .getBundledProdOfferOption().size() > 0) {
                for (BundledProdOfferOption bundledProdOfferOption : bundledProductOffering.getBundledProdOfferOption
                        ()) {
                    BundledOffering bundledOffering = new BundledOffering();
                    bundledOffering.setOfferingId(bundledProdOfferOption.getProductOffering().getId());
                    bundledOffering.setName(bundledProdOfferOption.getProductOffering().getName());
                    bundledOfferings.add(bundledOffering);
                }
            }
            retProdOffering.setBundledOfferings(bundledOfferings);
        } else {
            retProdOffering.setIsBundle(false);
            SimpleProductOffering simpleProductOffering = (SimpleProductOffering) offering;
            retProdOffering.setProductSpec(convertBeanType(simpleProductOffering.getProductSpecification()));
        }

        if (null != offering.getProdOfferingRelationship() && offering.getProdOfferingRelationship().size() > 0) {
            List<RelatedOffering> relatedOfferings = new ArrayList<RelatedOffering>();
            for (ProductOfferingRelationship relationship : offering.getProdOfferingRelationship()) {
                RelatedOffering relatedOffering = new RelatedOffering();
                relatedOffering.setOfferingId(relationship.getTargetOffering().getId());
                relatedOffering.setOfferingName(relationship.getTargetOffering().getName());
                relatedOffering.setRelationshipType(relationship.getTypeRelationship());
                relatedOffering.setValidFor(relationship.getValidFor());

                relatedOfferings.add(relatedOffering);
            }
            retProdOffering.setRelatedOfferings(relatedOfferings);
        }

        return retProdOffering;
    }

    public static ProductSpec convertBeanType(ProductSpecification productSpecification) {
        ProductSpec productSpec = new ProductSpec();

        try {
            BeanUtils.copyProperties(productSpec, productSpecification);

            List<ProductSpecChar> productSpecChars = new ArrayList<ProductSpecChar>();
            if (null != productSpecification.getProdSpecChar() && productSpecification.getProdSpecChar().size() > 0) {
                for (ProductSpecCharUse charUse : productSpecification.getProdSpecChar()) {
                    ProductSpecChar productSpecChar = new ProductSpecChar();
                    BeanUtils.copyProperties(productSpecChar, charUse);

                    if (null != charUse.getProdSpecCharValue() && charUse.getProdSpecCharValue().size() > 0) {
                        List<ProductSpecCharValue> productSpecCharValues = new ArrayList<ProductSpecCharValue>();
                        for (ProdSpecCharValueUse valueUse : charUse.getProdSpecCharValue()) {
                            ProductSpecCharValue productSpecCharValue = new ProductSpecCharValue();
                            BeanUtils.copyProperties(productSpecCharValue, valueUse.getProdSpecCharValue());
                            productSpecCharValue.setIsDefault(valueUse.isIsDefault());
                            productSpecCharValue.setValidFor(valueUse.getValidFor());

                            productSpecCharValues.add(productSpecCharValue);
                        }
                        productSpecChar.setProductSpecCharValues(productSpecCharValues);
                    }
                    productSpecChars.add(productSpecChar);
                }
            }

            productSpec.setProductSpecChars(productSpecChars);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return productSpec;
    }
}
