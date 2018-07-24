package org.rajnegi.RESTMessenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/paramdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class ParamDemoResource {

	
	@GET
	@Path("/annotations")
	public String getParamUsingAnnotations(@MatrixParam("param") String matParam, 
										   @HeaderParam("customHeader") String header, 
										   @CookieParam("JSESSIONID") String sessionId) {
		return "Matrix Param - "+matParam+ "; Header Param - "+header+ "; Cookie Param - "+sessionId;
	}
	
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookie = headers.getCookies().toString();
		return "Path - "+path+"; cookie - "+cookie;
	}
}
