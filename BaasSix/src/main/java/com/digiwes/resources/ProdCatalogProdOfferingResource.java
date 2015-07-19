package com.digiwes.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductCatalogErrorEnum;
import com.digiwes.controller.ProdCatalogProdOfferingController;
import com.digiwes.product.offering.ProductOffering;
import com.digiwes.product.offering.catalog.ProductCatalog;
import com.digiwes.resources.beans.*;
import org.springframework.stereotype.Service;

@Service
@Path("/productCatalog")
public class ProdCatalogProdOfferingResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @POST
    @Path("offering")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultResponse retrieveOffering(FindOfferingRequest findOfferingRequest) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(CommonErrorEnum.SUCCESS.getCode());
        resultResponse.setMessage(CommonErrorEnum.SUCCESS.getMessage());

        ProdCatalogProdOfferingController controller = new ProdCatalogProdOfferingController();
        ProductCatalogResponse productCatalogResponse = controller.retrieveOffering(findOfferingRequest
                        .getProductCatalogId(),
                findOfferingRequest
                        .getCondition());

        resultResponse.setProductCatalogResponse(productCatalogResponse);

        return resultResponse;
    }

    @POST
    @Path("offering/publish")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultData<OfferingRequest> publishOffering(OfferingRequest offeringRequest) {
        ProdCatalogProdOfferingController controller = new ProdCatalogProdOfferingController();
        ProductCatalog pc = controller.retrieveProductCatalog(offeringRequest.getProductCatalogId());
        int returncode = -1;
        String message = "";
        if(null != pc){
            ProductOffering poffering = controller.retrieveProductOffering(offeringRequest.getProductOfferingId());
            returncode = pc.publish(poffering,offeringRequest.getValidFor());
        }else{
            message = "can not find this catalog!";
        }
        ResultData<OfferingRequest> resultData = new ResultData<OfferingRequest>();
        resultData.setData(offeringRequest);
        if(-1 != returncode){
            message = CommonErrorEnum.getMessage(returncode);
        }
        resultData.setMessage(message);
        resultData.setCode(returncode);
        return resultData;
    }

    @POST
    @Path("offering/retire")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultData<OfferingRequest> retireOffering(OfferingRequest offeringRequest) {
        ProdCatalogProdOfferingController controller = new ProdCatalogProdOfferingController();
        ProductCatalog pc = controller.retrieveProductCatalog(offeringRequest.getProductCatalogId());
        int returncode = -1;
        String message = "";
        if(null != pc){
            ProductOffering poffering = controller.retrieveProductOffering(offeringRequest.getProductOfferingId());
            returncode = pc.retired(poffering);
        }else{
            message = "can not find this catalog!";
        }
        ResultData<OfferingRequest> resultData = new ResultData<OfferingRequest>();
        resultData.setData(offeringRequest);
        if(-1 != returncode){
            message = "SUCCESS";
        }else{
            message = "FAILD";
        }
        resultData.setMessage(message);
        resultData.setCode(returncode);
        return resultData;
    }


}
