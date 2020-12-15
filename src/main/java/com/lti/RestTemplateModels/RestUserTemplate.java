package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.RegisterUser;

public class RestUserTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private RegisterUser user;
	public RestUserTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestUserTemplate(String status, String message, HttpStatus statusCode, RegisterUser user) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.user = user;
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
	public RegisterUser getUser() {
		return user;
	}
	public void setUser(RegisterUser user) {
		this.user = user;
	}
		
}
