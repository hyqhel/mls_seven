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
	private List<Map<String,Object>> loadProdCatalogProdOffer(String fields, String offeringName, Date time){
		List<ProdCatalogProdOffer> resultSearch = new ArrayList<ProdCatalogProdOffer>();
		resultSearch = ConfigData.productCatalog.retrieveOffering(offeringName, time);
		List<Map<String,Object>> prodOffers = new ArrayList<Map<String, Object>>();
		String []filedArray = fields.split(",");
		for(ProdCatalogProdOffer prodCatalogProdOffer : resultSearch){
			Map<String,Object> prodOfferMap = new HashMap<String,Object>();
			for(String filed :filedArray){
				Object value = getOfferingFiledValue(filed, prodCatalogProdOffer);
				prodOfferMap.put(filed,value);
			}
			prodOffers.add(prodOfferMap);
		}
		return prodOffers;
	}
	private Object getOfferingFiledValue(String filed,ProdCatalogProdOffer prodCatalogProdOffer){
		if("id".equals(filed)){
			return prodCatalogProdOffer.getProdOffering().getId();
		}
		if("name".equals(filed)){
			return prodCatalogProdOffer.getProdOffering().getName();
		}
		if("description".equals(filed)){
			return prodCatalogProdOffer.getProdOffering().getDescription();
		}
		if("validFor".equals(filed)){
			return prodCatalogProdOffer.getValidFor();
		}
		if("status".equals(filed)){
			return prodCatalogProdOffer.getProdOffering().getStatus();
		}
		if("productOfferingPrice".equals(filed)){
			return prodCatalogProdOffer.getProductOfferingPrice();
		}
		return null;
	}

}