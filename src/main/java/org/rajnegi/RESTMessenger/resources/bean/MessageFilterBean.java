package org.rajnegi.RESTMessenger.resources.bean;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	private @QueryParam("year") int year;
	private @MatrixParam("param") String matParam;
	private @HeaderParam("customHeader") String customHeader;
	private @CookieParam("JSESSIONID") String cookie;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMatParam() {
		return matParam;
	}
	public void setMatParam(String matParam) {
		this.matParam = matParam;
	}
	public String getCustomHeader() {
		return customHeader;
	}
	public void setCustomHeader(String customHeader) {
		this.customHeader = customHeader;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	@Override
	public String toString() {
		return "MessageFilterBean [year=" + year + ", matParam=" + matParam + ", customHeader=" + customHeader
				+ ", cookie=" + cookie + "]";
	}
	
	
	
}
