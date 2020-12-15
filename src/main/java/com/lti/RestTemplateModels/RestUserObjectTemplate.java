package com.lti.RestTemplateModels;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.lti.model.Address;
import com.lti.model.RegisterUser;

public class RestUserObjectTemplate {
	
	private String status;
	private String message;
	private HttpStatus statusCode;
	private RegisterUser user;
	private List<Address> addresses;
	
	public RestUserObjectTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public RestUserObjectTemplate(String status, String message, HttpStatus statusCode, RegisterUser user,
			List<Address> addresses) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.user = user;
		this.addresses = addresses;
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

	public RegisterUser getUser() {
		return user;
	}

	public void setUser(RegisterUser user) {
		this.user = user;
	}
	

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "RestUserAndAccountTemplate [status=" + status + ", message=" + message + ", statusCode=" + statusCode
				+ ", user=" + user + "]";
	}
	

}
