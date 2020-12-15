package com.lti.RestTemplateModels;

import org.springframework.http.HttpStatus;

import com.lti.model.AddBeneficiary;

public class RestAddBeneficiarytTemplate{
	
	private String status;
	private String message;
	private HttpStatus statuscode;
	private AddBeneficiary beneficiary;
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
	public AddBeneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(AddBeneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	public RestAddBeneficiarytTemplate(String status, String message, HttpStatus statuscode,
			AddBeneficiary beneficiary) {
		super();
		this.status = status;
		this.message = message;
		this.statuscode = statuscode;
		this.beneficiary = beneficiary;
	}
	
	
	
	
}