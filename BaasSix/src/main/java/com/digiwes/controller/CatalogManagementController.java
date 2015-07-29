package com.digiwes.controller;

import com.digiwes.common.enums.ProductOfferingErrorEnum;
import com.digiwes.product.offering.BundledProductOffering;
import com.digiwes.product.offering.catalog.*;
import com.digiwes.product.offering.*;
import com.digiwes.resources.ConfigData;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.*;
import org.apache.commons.lang.StringUtils;

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
		if(productOffering instanceof BundledProductOffering){
			if(null != reqProdOffering.getBundledProductOffering()){
				for(com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.BundledProductOffering prodoffer:reqProdOffering.getBundledProductOffering()){
					ProductOffering offer = loadProductOfferingById(prodoffer.getId());
					if(null == offer){
						return ProductOfferingErrorEnum.OFFERING_IS_NULL.getCode();
					}
				}
			}
		}
		returnCode = ConfigData.productCatalog.publish(productOffering, reqProdOffering.getValidFor());
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

	/**
	 *
	 * @param id
	 */
	public ProductOffering loadProductOfferingById(String id) {
		if (StringUtils.isNotEmpty(id)) {
			for (ProductOffering pc : ConfigData.offerings) {
				if (id.equals(pc.getId())) {
					return pc;
				}
			}
		}
		return null;
	}


}