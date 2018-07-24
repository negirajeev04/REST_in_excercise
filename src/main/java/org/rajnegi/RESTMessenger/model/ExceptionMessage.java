package org.rajnegi.RESTMessenger.model;

public class ExceptionMessage {

	private String message;
	private String homePage;
	private long code;
	
	public ExceptionMessage() {
		
	}
	
	public ExceptionMessage(String msg, String home, long code) {
		this.message = msg;
		this.homePage = home;
		this.code = code;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	
	
	
}
