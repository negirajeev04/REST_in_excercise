package org.rajnegi.RESTMessenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.rajnegi.RESTMessenger.model.Message;
import org.rajnegi.RESTMessenger.resources.bean.MessageFilterBean;
import org.rajnegi.RESTMessenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService service = new MessageService();
	
	@GET
	public List<Message> getAllMessage(@BeanParam MessageFilterBean filterBean) {
		System.out.println(filterBean.toString());
		return new ArrayList<>(service.getAllMessages().values());
	}
	
	@GET
	@Path("/{msgId}")
	public Message getMessage(@PathParam("msgId") long id) {
		return service.getMessage(id);
	}
	
	@POST
	public Response createMessage(Message message,@Context UriInfo uriInfo) throws URISyntaxException {
		service.createMessage(message);
		/*return Response.status(Status.CREATED)
					   .entity(message)
					   .location(new URI("/RESTMessenger/webapi/messages/"+message.getId())).build();
					   */
		return Response.created(uriInfo.getAbsolutePathBuilder().path("/"+message.getId()).build()).entity(message).build();
	}
	
	@PUT
	@Path("/{msgId}")
	public Message updateMessage(@PathParam("msgId") long msgId, Message message) {
		service.updateMessage(msgId, message);
		return message;
	}
	
	@DELETE
	@Path("/{msgId}")
	public void deleteMessage(@PathParam("msgId") long msgId) {
		service.deleteMessage(msgId);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
