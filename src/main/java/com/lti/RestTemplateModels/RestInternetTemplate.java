package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.InternetBanking;

public class RestInternetTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private InternetBanking internetBanking;
	
	public RestInternetTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestInternetTemplate(String status, String message, HttpStatus statusCode, InternetBanking internetBanking) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.internetBanking = internetBanking;
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

	public InternetBanking getInternetBanking() {
		return internetBanking;
	}

	public void setInternetBanking(InternetBanking internetBanking) {
		this.internetBanking = internetBanking;
	}

	@Override
	public String toString() {
		return "RestInternetTemplate [status=" + status + ", message=" + message + ", statusCode=" + statusCode
				+ ", internetBanking=" + internetBanking + ", getStatus()=" + getStatus() + ", getMessage()="
				+ getMessage() + ", getStatusCode()=" + getStatusCode() + ", getInternetBanking()="
				+ getInternetBanking() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
