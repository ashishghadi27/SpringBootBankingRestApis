package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.Transaction;

public class RestTransactionTemplate {
	
	private String status;
	private String message;
	private HttpStatus statuscode;
	private Transaction transaction;
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
	public HttpStatus getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(HttpStatus statuscode) {
		this.statuscode = statuscode;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public RestTransactionTemplate(String status, String message, HttpStatus statuscode, Transaction transaction) {
		super();
		this.status = status;
		this.message = message;
		this.statuscode = statuscode;
		this.transaction = transaction;
	}
	public RestTransactionTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
