package com.lti.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="bankuser")
public class RegisterUser {

	@Id
	@Column(name="userId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="bankUser_seq", allocationSize=1)
	private Integer userId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="fatherName")
	private String fatherName;
	
	@Column(name="mobileNo")
	private String mobileNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="aadhar")
	private String aadhar;
	
	@Column(name="dob")
	@Temporal(value=TemporalType.DATE)
	private Date dob;
	
	@Column(name="netBankingEnabled")
	private Integer netBankingEnabled;
	
	@Column(name="debitEnabled")
	private Integer debitEnabled;

	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterUser(Integer userId, String title, String firstName, String middleName, String lastName,
			String fatherName, String mobileNo, String email, String aadhar, Date dob, Integer netBankingEnabled,
			Integer debitEnabled) {
		super();
		this.userId = userId;
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.aadhar = aadhar;
		this.dob = dob;
		this.netBankingEnabled = netBankingEnabled;
		this.debitEnabled = debitEnabled;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getNetBankingEnabled() {
		return netBankingEnabled;
	}

	public void setNetBankingEnabled(Integer netBankingEnabled) {
		this.netBankingEnabled = netBankingEnabled;
	}

	public Integer getDebitEnabled() {
		return debitEnabled;
	}

	public void setDebitEnabled(Integer debitEnabled) {
		this.debitEnabled = debitEnabled;
	}

	@Override
	public String toString() {
		return "RegisterUser [userId=" + userId + ", title=" + title + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", fatherName=" + fatherName + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", aadhar=" + aadhar + ", dob=" + dob + ", netBankingEnabled="
				+ netBankingEnabled + ", debitEnabled=" + debitEnabled + "]";
	}

}
