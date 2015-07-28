package com.digiwes.resources;

import com.digiwes.common.util.ConvertUtils;
import com.digiwes.controller.CatalogManagementController;
import com.digiwes.product.offering.catalog.ProdCatalogProdOffer;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.ProductOfferingReq;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.ProductOfferingResp;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import java.util.*;

/**
 * Created by liurl3 on 2015/7/28.
 */
@Service
@Path("/catalogManagement")
public class CatalogManagementResource {
    /**
     * publishOffering
     */
    @Path("/publishOffering")
    @POST
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public ProductOfferingResp publishOffering(ProductOfferingResp productRep ){
        CatalogManagementController catalogManagementController = new CatalogManagementController();
        catalogManagementController.publishProductOffering(productRep);
        return productRep;
    }
    /**
     * retrieveOffering
     */
    @Path("/productOffering")
    @GET
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    public List<Map<String,Object>> retrieveOffering(@QueryParam("fields") String fields,@QueryParam("offeringName") String offeringName,@QueryParam("time") Date time) throws Exception {
        CatalogManagementController controller = new CatalogManagementController();
        List<ProdCatalogProdOffer> prodCatalogProdOffers = new ArrayList<ProdCatalogProdOffer>();
        List<Map<String,Object>> productOfferingResps = new ArrayList<Map<String,Object>>();
        prodCatalogProdOffers = controller.retrieveProductOffering(offeringName,time);
        if(StringUtils.isEmpty(fields)){
        }else{
        }
        for(ProdCatalogProdOffer prodCataProdOffer : prodCatalogProdOffers ){
            ProductOfferingResp offeringResp = new ProductOfferingResp();
            offeringResp.convertFromProdCatalogProdOffeing(prodCataProdOffer);
            productOfferingResps.add(ConvertUtils.convertMap(offeringResp));
        }
        return productOfferingResps;
    }
}
