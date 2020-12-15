package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="branchId")
	private Integer branchId;
	
	@Column(name="branchName")
	private String branchName;
	
	@Column(name="ifsc")
	private String ifsc;
	
	
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public Branch(Integer branchId, String branchName, String ifsc) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.ifsc = ifsc;
	}
	public Branch() {
		super();
	}
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", ifsc=" + ifsc + "]";
	}

}
