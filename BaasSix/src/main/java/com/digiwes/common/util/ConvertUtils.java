package com.digiwes.common.util;

import com.digiwes.product.offering.*;
import com.digiwes.product.offering.catalog.ProdCatalogProdOffer;
import com.digiwes.product.spec.ProdSpecCharValueUse;
import com.digiwes.product.spec.ProductSpecCharUse;
import com.digiwes.product.spec.ProductSpecification;
import com.digiwes.resources.beans.*;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.ProductOfferingResp;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductSpecification.ProductSpecificationRef;
import com.sun.java.util.jar.pack.*;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<String,Object> convertMap(ProductOfferingResp offeringResp,String fields[]){
        Map<String,Object> map = new HashMap<String, Object>();
        if(null != offeringResp){
            Class offerClass =  offeringResp.getClass();
            Field[] files = offerClass.getDeclaredFields();
            for(int i = 0 ; i < files.length; i++) {
                Field f = files[i];
                Object val = null;
                try {
                    if(null != fields){
                        for(String filed :fields){
                            if(filed.equals(f.getName())){
                                val = f.get(offeringResp);
                                map.put(f.getName(),val);
                                break;
                            }
                        }
                    }else{
                        val = f.get(offeringResp);
                        map.put(f.getName(),val);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


    public static ProductOfferingResp convertFromProdCatalogProdOffeing(ProdCatalogProdOffer prodCatalogProdOffer){
        ProductOfferingResp resp = new ProductOfferingResp();
        resp.id = prodCatalogProdOffer.getProdOffering().getId();
        resp.name = prodCatalogProdOffer.getProdOffering().getName();
        resp.description = prodCatalogProdOffer.getProdOffering().getDescription();
        resp.lifecycleStatus = prodCatalogProdOffer.getProdOffering().getStatus();
        resp.productOfferingPrice=null;
        resp.validFor = prodCatalogProdOffer.getValidFor();
        if (prodCatalogProdOffer.getProdOffering() instanceof BundledProductOffering) {
            resp.isBundle = true;
            List<com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.BundledProductOffering> bundledOfferings = new ArrayList<com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.BundledProductOffering>();
            BundledProductOffering bundledProductOffering = (BundledProductOffering) prodCatalogProdOffer.getProdOffering();
            if (null != bundledProductOffering.getBundledProdOfferOption() && bundledProductOffering
                    .getBundledProdOfferOption().size() > 0) {
                for (BundledProdOfferOption bundledProdOfferOption : bundledProductOffering.getBundledProdOfferOption
                        ()) {
                    com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.BundledProductOffering bundledOffering = new com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.BundledProductOffering();
                    String offerId = bundledProdOfferOption.getProductOffering().getId();
                    bundledOffering.setId(offerId);
                    bundledOffering.setName(bundledProdOfferOption.getProductOffering().getName());
                    bundledOffering.setLifecycleStatus(bundledProdOfferOption.getProductOffering().getStatus());
                    bundledOffering.setHref("http://localhost:8080/catalogManagement/productOffering/"+offerId);
                    bundledOfferings.add(bundledOffering);
                }
            }
            resp.bundledProductOffering = bundledOfferings;
        }else{
            resp.isBundle = false;
            ProductSpecificationRef psr = new ProductSpecificationRef();
            SimpleProductOffering simpleProductOffering =(SimpleProductOffering) prodCatalogProdOffer.getProdOffering();
            String specNum = simpleProductOffering.getProductSpecification().getProductNumber();
            psr.setId(specNum);
            psr.setName(simpleProductOffering.getProductSpecification().getName());
            psr.setHref("http://localhost:8080/catalogManagement/productSpecification/" + specNum);
            resp.productSpecification = psr;
        }
        return resp;
    }


}
