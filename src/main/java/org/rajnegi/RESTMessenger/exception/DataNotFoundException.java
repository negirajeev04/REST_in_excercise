package org.rajnegi.RESTMessenger.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -7404741009620839411L;
	
	private String message;
	
	public DataNotFoundException(String msg) {
		super();
		message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
