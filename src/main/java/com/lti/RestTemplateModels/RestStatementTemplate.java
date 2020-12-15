package com.lti.RestTemplateModels;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.lti.model.Account;
import com.lti.model.Branch;
import com.lti.model.Transaction;

public class RestStatementTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private String firstName;
	private String middleName;
	private String lastName;
	private Account account;
	private Branch branch;
	private List<Transaction> transactions;
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
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public RestStatementTemplate(String status, String message, HttpStatus statusCode, String firstName,
			String middleName, String lastName, Account account, Branch branch, List<Transaction> transactions) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.account = account;
		this.branch = branch;
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "RestStatementTransactionTemplate [status=" + status + ", message=" + message + ", statusCode="
				+ statusCode + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", account=" + account + ", branch=" + branch + ", transactions=" + transactions + "]";
	}
	
	
	
	
	
}
