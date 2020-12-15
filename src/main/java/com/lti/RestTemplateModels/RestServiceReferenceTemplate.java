package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.ServiceReference;

public class RestServiceReferenceTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private ServiceReference serviceReference;
	
	public RestServiceReferenceTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestServiceReferenceTemplate(String status, String message, HttpStatus statusCode,
			ServiceReference serviceReference) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.serviceReference = serviceReference;
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

	@Override
	public String toString() {
		return "RestServiceReferenceTemplate [status=" + status + ", message=" + message + ", statusCode=" + statusCode
				+ ", serviceReference=" + serviceReference + "]";
	}
	
}
