package org.rajnegi.RESTMessenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.rajnegi.RESTMessenger.model.ExceptionMessage;

@Path("/")
public class CommentResource {

	@GET
	public String getAllComments(@PathParam("messageId") long messageId) {
		return "All Comments for Message Id - "+messageId;
	}
	
	@GET
	@Path("/{commentId}")
	public String getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		
		if(commentId == 100) {
			throw new NotFoundException(Response.status(Status.NOT_FOUND).entity(new ExceptionMessage("Not Found","http;//thisismyhome.org",404)).build());
		}
		
		return "Message Id - "+ messageId+"; commentId - "+commentId;
	}
	
}
