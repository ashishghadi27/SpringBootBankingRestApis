package com.lti.RestTemplateModels;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.lti.model.Account;
import com.lti.model.Transaction;

public class RestAccountSummaryTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private Account account;
	private List<Transaction> transaction;
	
	public RestAccountSummaryTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestAccountSummaryTemplate(String status, String message, HttpStatus statusCode) {
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	
	
}
