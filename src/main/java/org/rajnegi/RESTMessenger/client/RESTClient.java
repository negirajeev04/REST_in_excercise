package org.rajnegi.RESTMessenger.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.rajnegi.RESTMessenger.model.Message;


public class RESTClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/RESTMessenger/webapi");
		WebTarget msgTarget = baseTarget.path("messages");
		
		Builder request = msgTarget.request();
		List<Message> messages = request.get(new GenericType<List<Message>>() {});
		
		System.out.println(messages);
		
		
	}

}
