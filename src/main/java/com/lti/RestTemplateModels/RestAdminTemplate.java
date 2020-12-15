package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.Admin;

public class RestAdminTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private Admin admin;
	
	public RestAdminTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestAdminTemplate(String status, String message, HttpStatus statusCode, Admin admin) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.admin = admin;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "RestAdminTemplate [status=" + status + ", message=" + message + ", statusCode=" + statusCode
				+ ", admin=" + admin + "]";
	}
	
}
