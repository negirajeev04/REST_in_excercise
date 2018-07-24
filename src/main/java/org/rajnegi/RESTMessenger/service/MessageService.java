package org.rajnegi.RESTMessenger.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.rajnegi.RESTMessenger.exception.DataNotFoundException;
import org.rajnegi.RESTMessenger.model.Message;

public class MessageService {

	private static Map<Long,Message> messages = new HashMap<>();
	
	public MessageService() {
		
		Message msg1 = new Message();
		msg1.setId(1);
		msg1.setText("Hello, REST!!");
		msg1.setAuthor("Rajeev Negi");
		msg1.setCreatedDate(new Date());
		
		messages.put(msg1.getId(), msg1);
		
		Message msg2 = new Message();
		msg2.setId(2);
		msg2.setText("Hello, Jersey!!");
		msg2.setAuthor("Laxmi Negi");
		msg2.setCreatedDate(new Date());
		
		messages.put(msg2.getId(), msg2);
	}
	
	public Map<Long,Message> getAllMessages(){
		return messages;
	}
	
	public Message getMessage(Long id) {
		Message msg = messages.get(id);
		if(msg == null) {
			throw new DataNotFoundException("Not Found");
		}
		return msg;
	}
	
	public void createMessage(Message msg) {
		msg.setId(messages.size()+1);
		msg.setCreatedDate(new Date());
		messages.put(msg.getId(), msg);
	}
	
	public void updateMessage(Long id, Message msg) {
		msg.setId(id);
		msg.setCreatedDate(new Date());
		messages.put(msg.getId(), msg);
	}
	
	public void deleteMessage(Long id) {
		messages.remove(id);
	}
	
}
