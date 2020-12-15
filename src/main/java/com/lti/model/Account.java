package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name="accountNo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acc_seq")
	@SequenceGenerator(name="acc_seq", sequenceName="account_seq", allocationSize=1)
	private Integer accountNo;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="branchId")
	private Integer branchId;
	
	@Column(name="accountType")
	private String accountType;	
	
	@Column(name="balance")
	private Long balance;
	
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Account(Integer accountNo, Integer userId, Integer branchId, String accountType, Long balance) {
		super();
		this.accountNo = accountNo;
		this.userId = userId;
		this.branchId = branchId;
		this.accountType = accountType;
		this.balance = balance;
	}
		
	public Account() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", userId=" + userId + ", branchId=" + branchId
				+ ", accountType=" + accountType + ", balance=" + balance + "]";
	}	
}