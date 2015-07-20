package com.digiwes.resources;

import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.controller.ProdCatalogProdOfferingController;
import com.digiwes.product.offering.ProductOffering;
import com.digiwes.product.offering.catalog.ProductCatalog;
import com.digiwes.resources.beans.*;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Service
@Path("/productCatalog")
public class ProdCatalogProdOfferingResource {

    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    @POST
    @Path("offering/retire")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultData<OfferingRequest> retireOffering(OfferingRequest offeringRequest) {
        ProdCatalogProdOfferingController controller = new ProdCatalogProdOfferingController();
        ProductCatalog pc = controller.retrieveProductCatalog(offeringRequest.getProductCatalogId());
        int returnCode = -1;
        String message = "";
        if (null != pc) {
            ProductOffering prodOffering = controller.retrieveProductOffering(offeringRequest.getProductOfferingId());
            returnCode = pc.retired(prodOffering);
        } else {
            message = "can not find this catalog!";
        }
        ResultData<OfferingRequest> resultData = new ResultData<OfferingRequest>();
        resultData.setData(offeringRequest);
        if (-1 != returnCode) {
            message = "SUCCESS";
        } else {
            message = "FAILED";
        }
        resultData.setMessage(message);
        resultData.setCode(returnCode);
        return resultData;
    }


    @POST
    @Path("offering")
    @Consumes(MediaType.APPLICATION_JSON)
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
        int returnCode = -1;
        String message = "";
        if (null != pc) {
            ProductOffering productOffering = controller.retrieveProductOffering(offeringRequest.getProductOfferingId());
            returnCode = pc.publish(productOffering, offeringRequest.getValidFor());
        } else {
            message = "can not find this catalog!";
        }
        ResultData<OfferingRequest> resultData = new ResultData<OfferingRequest>();
        resultData.setData(offeringRequest);
        if (-1 != returnCode) {
            message = CommonErrorEnum.getMessage(returnCode);
        }
        resultData.setMessage(message);
        resultData.setCode(returnCode);
        return resultData;
    }


}
