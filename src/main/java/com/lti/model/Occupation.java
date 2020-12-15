package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="occupation")
public class Occupation {
	
	@Id
	@Column(name="occupationId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="occup_seq")
	@SequenceGenerator(name="occup_seq", sequenceName="occupation_seq", allocationSize=1)
	private Integer occupationId;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="occupationType")
	private String occupationType;
	
	@Column(name="sourceOfIncome")
	private String sourceOfIncome;
	
	@Column(name="grossAnnual")
	private Integer grossAnnual;

	public Occupation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Occupation(Integer occupationId, Integer userId, String occupationType, String sourceOfIncome,
			Integer grossAnnual) {
		super();
		this.occupationId = occupationId;
		this.userId = userId;
		this.occupationType = occupationType;
		this.sourceOfIncome = sourceOfIncome;
		this.grossAnnual = grossAnnual;
	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public Integer getGrossAnnual() {
		return grossAnnual;
	}

	public void setGrossAnnual(Integer grossAnnual) {
		this.grossAnnual = grossAnnual;
	}

	@Override
	public String toString() {
		return "Occupation [occupationId=" + occupationId + ", userId=" + userId + ", occupationType=" + occupationType
				+ ", sourceOfIncome=" + sourceOfIncome + ", grossAnnual=" + grossAnnual + "]";
	}
	

}
