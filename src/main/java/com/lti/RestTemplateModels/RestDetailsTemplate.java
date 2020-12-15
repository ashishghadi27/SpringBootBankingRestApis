package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.AddressNew;
import com.lti.model.Occupation;
import com.lti.model.RegisterUser;

public class RestDetailsTemplate {

	private String status;
	private String message;
	private HttpStatus statusCode;
	private RegisterUser user;
	private AddressNew residentialAddress;
	private AddressNew permanentAddress;
	private Occupation occupation;
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
	public AddressNew getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(AddressNew residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public AddressNew getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(AddressNew permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public Occupation getOccupation() {
		return occupation;
	}
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	public RestDetailsTemplate(String status, String message, HttpStatus statusCode, RegisterUser user,
			AddressNew residentialAddress, AddressNew permanentAddress, Occupation occupation) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.user = user;
		this.residentialAddress = residentialAddress;
		this.permanentAddress = permanentAddress;
		this.occupation = occupation;
	}
	public RestDetailsTemplate() {
		super();
	}

}
