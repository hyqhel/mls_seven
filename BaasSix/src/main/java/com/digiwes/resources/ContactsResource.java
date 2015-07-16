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
@Path("/contacts")
public class ContactsResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		System.out.print("11111111111");
		return String.valueOf("2");
	}
	
	
	
}
