package com.lti.RestTemplateModels;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.lti.model.Branch;

public class RestBranchListTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private List<Branch> branches;
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
	public List<Branch> getBranches() {
		return branches;
	}
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	public RestBranchListTemplate(String status, String message, HttpStatus statusCode, List<Branch> branches) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.branches = branches;
	}
	public RestBranchListTemplate() {
		super();
	}
	@Override
	public String toString() {
		return "RestBranchTemplate [status=" + status + ", message=" + message + ", statusCode=" + statusCode
				+ ", branches=" + branches + "]";
	}
	
	
	
}
