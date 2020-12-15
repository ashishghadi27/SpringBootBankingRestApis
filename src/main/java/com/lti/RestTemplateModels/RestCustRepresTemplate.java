package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;
import com.lti.model.CustomerRepres;

public class RestCustRepresTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private CustomerRepres customerRepres;
	
	public RestCustRepresTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestCustRepresTemplate(String status, String message, HttpStatus statusCode, CustomerRepres customerRepres) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.customerRepres = customerRepres;
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

	public CustomerRepres getCustomerRepres() {
		return customerRepres;
	}

	public void setCustomerRepres(CustomerRepres customerRepres) {
		this.customerRepres = customerRepres;
	}

}
