package com.digiwes.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.digiwes.common.enums.CommonErrorEnum;
import com.digiwes.common.enums.ProductCatalogErrorEnum;
import com.digiwes.controller.ProdCatalogProdOfferingController;
import com.digiwes.resources.beans.FindOfferingRequest;
import com.digiwes.resources.beans.ProductCatalogResponse;
import com.digiwes.resources.beans.ResultResponse;
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
    public String publishOffering(String offering) {
        System.out.print("condition" + offering);
        return String.valueOf("2");
    }

    @DELETE
    @Path("offering/retire")
    @Produces(MediaType.APPLICATION_JSON)
    public String retireOffering(String offering) {
        System.out.print("condition" + offering);
        return String.valueOf("2");
    }


}
