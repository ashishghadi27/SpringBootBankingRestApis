package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.Debit;

public class RestDebitTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private Debit debit;
	
	public RestDebitTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestDebitTemplate(String status, String message, HttpStatus statusCode, Debit debit) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.debit = debit;
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

	public Debit getDebit() {
		return debit;
	}

	public void setDebit(Debit debit) {
		this.debit = debit;
	}

	@Override
	public String toString() {
		return "RestDebitTemplate [status=" + status + ", message=" + message + ", statusCode=" + statusCode
				+ ", debit=" + debit + "]";
	}
	
}
