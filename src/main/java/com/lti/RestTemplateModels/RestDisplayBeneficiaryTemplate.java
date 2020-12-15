package com.lti.RestTemplateModels;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.lti.model.AddBeneficiary;

public class RestDisplayBeneficiaryTemplate {

	private String status;
	private String message;
	private HttpStatus statuscode;
	private List<AddBeneficiary> beneficiaries;
	
	public RestDisplayBeneficiaryTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestDisplayBeneficiaryTemplate(String status, String message, HttpStatus statuscode,
			List<AddBeneficiary> beneficiaries) {
		super();
		this.status = status;
		this.message = message;
		this.statuscode = statuscode;
		this.beneficiaries = beneficiaries;
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

	public HttpStatus getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(HttpStatus statuscode) {
		this.statuscode = statuscode;
	}

	public List<AddBeneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<AddBeneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	@Override
	public String toString() {
		return "RestDisplayBeneficiaryTemplate [status=" + status + ", message=" + message + ", statuscode="
				+ statuscode + ", beneficiaries=" + beneficiaries + "]";
	}
	
}
