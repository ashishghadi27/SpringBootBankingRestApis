package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="debit")
public class Debit {

	@Id
	@Column(name="debitId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="debit")
	@SequenceGenerator(name="debit", sequenceName="debit_seq", allocationSize=1)
	private Integer debitId;
	
	@Column(name="accountNo")
	private Integer accountNo;
	
	@Column(name="debitCardNumber")
	private String debitCardNumber;
	
	@Column(name="cvv")
	private Integer cvv;
	
	@Column(name="pin")
	private Integer pin;
	
	@Column(name="isBlocked")
	private Integer isBlocked;

	public Debit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Debit(Integer debitId, Integer accountNo, String debitCardNumber, Integer cvv, Integer pin,
			Integer isBlocked) {
		super();
		this.debitId = debitId;
		this.accountNo = accountNo;
		this.debitCardNumber = debitCardNumber;
		this.cvv = cvv;
		this.pin = pin;
		this.isBlocked = isBlocked;
	}

	public Integer getDebitId() {
		return debitId;
	}

	public void setDebitId(Integer debitId) {
		this.debitId = debitId;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getDebitCardNumber() {
		return debitCardNumber;
	}

	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Integer getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Integer isBlocked) {
		this.isBlocked = isBlocked;
	}

	@Override
	public String toString() {
		return "Debit [debitId=" + debitId + ", accountNo=" + accountNo + ", debitCardNumber=" + debitCardNumber
				+ ", cvv=" + cvv + ", pin=" + pin + ", isBlocked=" + isBlocked + "]";
	}
	
}
