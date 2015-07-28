package com.digiwes.controller;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProductCatalogErrorEnum;
import com.digiwes.product.offering.catalog.*;
import com.digiwes.product.offering.*;
import com.digiwes.resources.ConfigData;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;

public class CatalogManagementController {

	/**
	 * 
	 * @param offeringName
	 * @param time
	 */
	public List<ProdCatalogProdOffer> retrieveProductOffering(String offeringName, Date time) {
		// TODO - implement CatalogManagementController.retrieveProductOffering

		return null;
	}

	/**
	 * 
	 * @param fields
	 * @param offeringName
	 * @param time
	 */
	public List<ProdCatalogProdOffer> retrieveProductOffering(String fields, String offeringName, Date time) {
		// TODO - implement CatalogManagementController.retrieveProductOffering
		return null;
	}


	public int publishProductOffering( String offeringName, TimePeriod validFor) {
		int returnCode = -1;
		ProductOffering productOffering = loadProductOfferingByName(offeringName);
		returnCode = ConfigData.productCatalog.publish(productOffering, validFor);
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