package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column(name="addressId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userAddr_seq")
	@SequenceGenerator(name="userAddr_seq", sequenceName="userAddress_seq", allocationSize=1)
	private Integer addressId;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="stateId")
	private Integer stateId;
	
	@Column(name="cityId")
	private Integer cityId;
	
	@Column(name="line1")
	private String line1;
	
	@Column(name="line2")
	private String line2;
	
	@Column(name="landmark")
	private String landmark;
	
	@Column(name="pincode")
	private Integer pincode;
	
	@Column(name="isPermanent")
	private Integer isPermanent;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Integer addressId, Integer userId, Integer stateId, Integer cityId, String line1, String line2,
			String landmark, Integer pincode, Integer isPermanent) {
		super();
		this.addressId = addressId;
		this.userId = userId;
		this.stateId = stateId;
		this.cityId = cityId;
		this.line1 = line1;
		this.line2 = line2;
		this.landmark = landmark;
		this.pincode = pincode;
		this.isPermanent = isPermanent;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getIsPermanent() {
		return isPermanent;
	}

	public void setIsPermanent(Integer isPermanent) {
		this.isPermanent = isPermanent;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", userId=" + userId + ", stateId=" + stateId + ", cityId=" + cityId
				+ ", line1=" + line1 + ", line2=" + line2 + ", landmark=" + landmark + ", pincode=" + pincode
				+ ", isPermanent=" + isPermanent + "]";
	}

		
}
