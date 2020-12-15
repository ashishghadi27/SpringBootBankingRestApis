package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.ServiceReference;

public class RestServiceRefernceTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private ServiceReference serviceReference;
	
	public RestServiceRefernceTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestServiceRefernceTemplate(String status, String message, HttpStatus statusCode) {
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

	public ServiceReference getServiceReference() {
		return serviceReference;
	}

	public void setServiceReference(ServiceReference serviceReference) {
		this.serviceReference = serviceReference;
	}

	
	
}
