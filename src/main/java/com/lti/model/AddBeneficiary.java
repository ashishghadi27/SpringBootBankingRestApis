package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beneficiaries")
public class AddBeneficiary {

	@Id
	@Column(name="beneficiaryAccNo")
	private Integer beneficiaryAccNo;
	
	@Column(name="accountNo")
	private int accountNo; 
	
	@Column(name="beneficiaryName")
	private String beneficiaryName;
	
	@Column(name="bankName")
	private String bankName;
	
	@Column(name="ifsc")
	private String ifsc;
	
	@Column(name="nickName")
	private String nickName;

	public AddBeneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddBeneficiary(Integer beneficiaryAccNo, int accountNo, String beneficiaryName, String bankName, String ifsc,
			String nickName) {
		super();
		this.beneficiaryAccNo = beneficiaryAccNo;
		this.accountNo = accountNo;
		this.beneficiaryName = beneficiaryName;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.nickName = nickName;
	}

	public Integer getBeneficiaryAccNo() {
		return beneficiaryAccNo;
	}

	public void setBeneficiaryAccNo(Integer beneficiaryAccNo) {
		this.beneficiaryAccNo = beneficiaryAccNo;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "AddBeneficiary [beneficiaryAccNo=" + beneficiaryAccNo + ", accountNo=" + accountNo
				+ ", beneficiaryName=" + beneficiaryName + ", bankName=" + bankName + ", ifsc=" + ifsc + ", nickName="
				+ nickName + "]";
	}
	
}
