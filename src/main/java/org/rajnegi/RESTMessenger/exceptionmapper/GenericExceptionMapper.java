package org.rajnegi.RESTMessenger.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rajnegi.RESTMessenger.model.ExceptionMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ExceptionMessage exec = new ExceptionMessage(exception.getMessage(),"http;//thisismyhome.org",500);
		return Response.serverError().entity(exec).build();
	}

}
