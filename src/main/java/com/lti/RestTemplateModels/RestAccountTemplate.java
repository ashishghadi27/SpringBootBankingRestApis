package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.Account;

public class RestAccountTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private Account account;
	
	public RestAccountTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestAccountTemplate(String status, String message, HttpStatus statusCode, Account account) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.account = account;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "RestAccountTemplate [status=" + status + ", message=" + message + ", statusCode=" + statusCode
				+ ", account=" + account + "]";
	}
	
}
