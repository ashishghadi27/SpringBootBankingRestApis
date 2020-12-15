package com.lti.RestTemplateModels;

public class RestUserIdAndOtpTemplate {

	private RestSimpleTemplate requestStatus;
	private Integer userId;
	private Integer otp;
	
	public RestUserIdAndOtpTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestUserIdAndOtpTemplate(RestSimpleTemplate requestStatus, Integer userId, Integer otp) {
		super();
		this.requestStatus = requestStatus;
		this.userId = userId;
		this.otp = otp;
	}

	public RestSimpleTemplate getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RestSimpleTemplate requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "RestUserIdAndOtpTemplate [requestStatus=" + requestStatus + ", userId=" + userId + ", otp=" + otp + "]";
	}
	
}
