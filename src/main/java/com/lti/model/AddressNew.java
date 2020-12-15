package com.lti.model;


public class AddressNew {
	
	private Integer addressId;
	
	private Integer userId;
	
	private State state;

	private City city;

	private String line1;

	private String line2;

	private String landmark;

	private Integer pincode;

	private Integer isPermanent;

	public AddressNew() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AddressNew(Integer addressId, Integer userId, State state, City city, String line1, String line2,
			String landmark, Integer pincode, Integer isPermanent) {
		super();
		this.addressId = addressId;
		this.userId = userId;
		this.state = state;
		this.city = city;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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
		return "Address [addressId=" + addressId + ", userId=" + userId + ", state=" + state + ", city=" + city
				+ ", line1=" + line1 + ", line2=" + line2 + ", landmark=" + landmark + ", pincode=" + pincode
				+ ", isPermanent=" + isPermanent + "]";
	}
	
}
