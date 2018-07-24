package org.rajnegi.RESTMessenger.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rajnegi.RESTMessenger.exception.DataNotFoundException;
import org.rajnegi.RESTMessenger.model.ExceptionMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		
		ExceptionMessage exc = new ExceptionMessage(exception.getMessage(),"http://thisismyhome.org", 404);
		return Response.status(Status.NOT_FOUND).entity(exc).build();
	}

}
