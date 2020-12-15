package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cityId")
	private Integer cityId;
	
	@Column(name="stateId")
	private Integer stateId;
	
	@Column(name="cityName")
	private String cityName;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public City(Integer cityId, Integer stateId, String cityName) {
		super();
		this.cityId = cityId;
		this.stateId = stateId;
		this.cityName = cityName;
	}

	public City() {
		super();
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", stateId=" + stateId + ", cityName=" + cityName + "]";
	}	
}
