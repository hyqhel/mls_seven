package com.digiwes.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Service;

@Service
@Path("/productCatalog")
public class ProductCatalogResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("offering")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCount(String condition) {
		System.out.print("condition"+condition);
		return String.valueOf("2");
	}
	@POST
	@Path("offering/publish")
	@Produces(MediaType.APPLICATION_JSON)
	public String publishOffering(String offering) {
		System.out.print("condition"+offering);
		return String.valueOf("2");
	}
	@DELETE
	@Path("offering/retire")
	@Produces(MediaType.APPLICATION_JSON)
	public String retireOffering(String offering) {
		System.out.print("condition"+offering);
		return String.valueOf("2");
	}

	@GET
	@Path("offering")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOffering(String offering) {
		System.out.print("condition"+offering);
		return String.valueOf("2");
	}
	
	
	
}
