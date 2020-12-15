package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class State {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="stateId")
	private Integer stateId;
	
	@OneToOne
	private Country country;
	
	@Column(name="stateName")
	private String stateName;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public State() {
		super();
	}

	public State(Integer stateId, Country country, String stateName) {
		super();
		this.stateId = stateId;
		this.country = country;
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", country=" + country + ", stateName=" + stateName + "]";
	}
	
}