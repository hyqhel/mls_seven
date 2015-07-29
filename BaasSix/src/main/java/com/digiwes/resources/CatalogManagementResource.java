package com.digiwes.resources;

import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.util.CommonUtils;
import com.digiwes.common.util.ConvertUtils;
import com.digiwes.controller.CatalogManagementController;
import com.digiwes.product.offering.catalog.ProdCatalogProdOffer;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.ProductOfferingReq;
import com.digiwes.resources.beans.EngagedPartyProduct.ProductOffering.ProductOfferingResp;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import java.text.SimpleDateFormat;
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
        int code = catalogManagementController.publishProductOffering(productRep);
        if(code == CommonErrorEnum.SUCCESS.getCode()){
            productRep.setHref("");
            productRep.setId("");
            productRep.setLastUpdate(new Date());
        }
        return productRep;
    }
    /**
     * retrieveOffering
     */
    @Path("/productOffering")
    @GET
    @Produces({ "application/json", "application/xml" })
    public List<Map<String,Object>> retrieveOffering(@QueryParam("fields") String fields,@QueryParam("offeringName") String offeringName,@QueryParam("time") String time) throws Exception {
        CatalogManagementController controller = new CatalogManagementController();
        List<ProdCatalogProdOffer> prodCatalogProdOffers = new ArrayList<ProdCatalogProdOffer>();
        List<Map<String,Object>> productOfferingResps = new ArrayList<Map<String,Object>>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        prodCatalogProdOffers = controller.retrieveProductOffering(offeringName,format.parse(time));
        String fieldArray[] = null;
        if(null != fields && !"".equals(fields)){
            fieldArray  =fields.split("\\,");
        }
        for(ProdCatalogProdOffer prodCataProdOffer : prodCatalogProdOffers ){
            ProductOfferingResp offeringResp = new ProductOfferingResp();
            offeringResp = controller.convertFromProdCatalogProdOffeing(prodCataProdOffer);
            productOfferingResps.add(ConvertUtils.convertMap(offeringResp,fieldArray));
        }
        return productOfferingResps;
    }
}
