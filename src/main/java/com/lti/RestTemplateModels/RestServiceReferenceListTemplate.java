package com.lti.RestTemplateModels;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.lti.model.ServiceReference;

public class RestServiceReferenceListTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private List<ServiceReference> serviceReferences;
	
	public RestServiceReferenceListTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestServiceReferenceListTemplate(String status, String message, HttpStatus statusCode,
			List<ServiceReference> serviceReferences) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.serviceReferences = serviceReferences;
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

	public List<ServiceReference> getServiceReferences() {
		return serviceReferences;
	}

	public void setServiceReferences(List<ServiceReference> serviceReferences) {
		this.serviceReferences = serviceReferences;
	}

	@Override
	public String toString() {
		return "RestServiceReferenceListTemplate [status=" + status + ", message=" + message + ", statusCode="
				+ statusCode + ", serviceReferences=" + serviceReferences + "]";
	}
	
}
