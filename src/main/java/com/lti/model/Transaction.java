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
@Table(name="transactions")
public class Transaction {
	@Id
	@Column(name="transactionId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionId")
	@SequenceGenerator(name="transactionId", sequenceName="transaction_seq",allocationSize=1)
	private Integer transactionId;
	
	@Column(name="accountNo")
	private Integer accountNo;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="type")
	private String type;
	
	@Column(name="startDate")
	@Temporal(value=TemporalType.DATE)
	private Date startDate;
	
	@Column(name="endDate")
	@Temporal(value=TemporalType.DATE)
	private Date endDate;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="flow")
	private String flow;
	
	@Column(name="toAccount")
	private Integer toAccount;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public Integer getToAccount() {
		return toAccount;
	}

	public void setToAccount(Integer toAccount) {
		this.toAccount = toAccount;
	}

	public Transaction(Integer transactionId, Integer accountNo, String reason, String type, Date startDate,
			Date endDate, Integer amount, String flow, Integer toAccount) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.reason = reason;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.flow = flow;
		this.toAccount = toAccount;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNo=" + accountNo + ", reason=" + reason
				+ ", type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + ", amount=" + amount
				+ ", flow=" + flow + ", toAccount=" + toAccount + "]";
	}
	
}
