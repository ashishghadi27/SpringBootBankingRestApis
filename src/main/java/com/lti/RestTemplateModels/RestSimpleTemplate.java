package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

public class RestSimpleTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	
	public RestSimpleTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestSimpleTemplate(String status, String message, HttpStatus statusCode) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "RestAddressTemplate [status=" + status + ", message=" + message + ", statusCode=" + statusCode + "]";
	}
	
	
	
}
