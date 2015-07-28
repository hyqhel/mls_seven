package com.digiwes.controller;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProductCatalogErrorEnum;
import com.digiwes.common.util.CommonUtils;
import com.digiwes.product.offering.catalog.*;
import com.digiwes.product.offering.*;
import com.digiwes.product.spec.ProductSpecCharUse;
import com.digiwes.resources.ConfigData;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.ProductOfferingResp;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	/**
	 * 
	 * @param fields
	 * @param offeringName
	 * @param time
	 */
	public List<ProdCatalogProdOffer> retrieveProductOffering(String fields, String offeringName, Date time) {
		List<ProdCatalogProdOffer> resultSearch = new ArrayList<ProdCatalogProdOffer>();
		resultSearch = ConfigData.productCatalog.retrieveOffering(offeringName, time);
		String SearchResult = CommonUtils.format(resultSearch.toString());
		String []filedArray = fields.split("\\,");
		return null;
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

}