package com.digiwes.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	
	
	
}