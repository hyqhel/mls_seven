package com.digiwes.controller;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProductCatalogErrorEnum;
import com.digiwes.common.util.CommonUtils;
import com.digiwes.product.offering.BundledProductOffering;
import com.digiwes.product.offering.catalog.*;
import com.digiwes.product.offering.*;
import com.digiwes.product.spec.ProductSpecCharUse;
import com.digiwes.resources.ConfigData;
import com.digiwes.resources.beans.BundledOffering;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.*;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class CatalogManagementController {

	/**
	 * 
	 * @param offeringName
	 * @param time
	 */
	public List<ProdCatalogProdOffer> retrieveProductOffering(String offeringName, Date time) {
		List<ProdCatalogProdOffer> resultSearch = new ArrayList<ProdCatalogProdOffer>();
		resultSearch = ConfigData.productCatalog.retrieveOffering(offeringName, time);
		return resultSearch;
	}

	public int publishProductOffering(ProductOfferingResp reqProdOffering) {
		int returnCode = -1;
		ProductOffering productOffering = loadProductOfferingByName(reqProdOffering.getName());
		returnCode = ConfigData.productCatalog.publish(productOffering, reqProdOffering.getValidFor());
		reqProdOffering.setHref("");
		reqProdOffering.setId("");
		reqProdOffering.setLastUpdate(new Date());
		return returnCode;
	}

	/**
	 *
	 * @param offeringName
	 */
	public ProductOffering loadProductOfferingByName(String offeringName) {
		if (StringUtils.isNotEmpty(offeringName)) {
			for (ProductOffering pc : ConfigData.offerings) {
				if (offeringName.equals(pc.getName())) {
					return pc;
				}
			}
		}
		return null;
	}

	public ProductOfferingResp convertFromProdCatalogProdOffeing(ProdCatalogProdOffer prodCatalogProdOffer){
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
		}
		return resp;
	}

}