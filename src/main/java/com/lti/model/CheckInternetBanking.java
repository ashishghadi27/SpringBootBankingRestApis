package com.lti.model;

public class CheckInternetBanking {
	
	private Integer userId;
	private String netBankingEnabled;
	
	public CheckInternetBanking() {
		super();
	}

	public CheckInternetBanking(Integer userId, String netBankingEnabled) {
		super();
		this.userId = userId;
		this.netBankingEnabled = netBankingEnabled;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNetBankingEnabled() {
		return netBankingEnabled;
	}

	public void setNetBankingEnabled(String netBankingEnabled) {
		this.netBankingEnabled = netBankingEnabled;
	}

	@Override
	public String toString() {
		return "CheckInternetBanking [userId=" + userId + ", netBankingEnabled=" + netBankingEnabled + "]";
	}
	
}
