package com.digiwes.resources;

import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.util.CommonUtils;
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
@Path("/catalogManagement")
public class ProdCatalogProdOfferingResource {

    @Context
    UriInfo uriInfo;

    @POST
    @Path("/findCatalogOffering")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public ResultResponse retrieveOffering(FindOfferingRequest findOfferingRequest) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(CommonErrorEnum.SUCCESS.getCode());
        resultResponse.setMessage(CommonErrorEnum.SUCCESS.getMessage());

        ProdCatalogProdOfferingController controller = new ProdCatalogProdOfferingController();
        ProductCatalogResponse productCatalogResponse = controller.retrieveOffering(findOfferingRequest
                .getProductCatalogId(), findOfferingRequest.getRetrieveTime(), findOfferingRequest.getCondition());

        resultResponse.setProductCatalogResponse(productCatalogResponse);

        return resultResponse;
    }

    @Context
    Request request;


    @POST
    @Path("retiredOffering")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResult retireOffering(OfferingRequest offeringRequest) {
        ProdCatalogProdOfferingController controller = new ProdCatalogProdOfferingController();
        int returnCode = -1;
        returnCode = controller.retiredOffering(offeringRequest.getProductCatalogId(), offeringRequest.getProductOfferingId());
        BaseResult resultData = new BaseResult();

        resultData.setMessage(CommonUtils.getMessage(returnCode));
        resultData.setCode(returnCode);
        return resultData;
    }

    @POST
    @Path("publishOffering")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultData<OfferingRequest> publishOffering(OfferingRequest offeringRequest) {
        ProdCatalogProdOfferingController controller = new ProdCatalogProdOfferingController();
        int returnCode = -1;
        returnCode = controller.publishOffering(offeringRequest.getProductCatalogId(), offeringRequest.getProductOfferingId(), offeringRequest.getValidFor());
        ResultData<OfferingRequest> resultData = new ResultData<OfferingRequest>();
        resultData.setData(offeringRequest);
        resultData.setMessage(CommonUtils.getMessage(returnCode));
        resultData.setCode(returnCode);

        return resultData;
    }


}
