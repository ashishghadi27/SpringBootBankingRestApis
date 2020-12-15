package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="internetBanking")
public class InternetBanking {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="internetBank_seq")
	@SequenceGenerator(name="internetBank_seq", sequenceName="internetBanking_seq", allocationSize=1)
	private Integer id;
	
	@Column(name="accountNo")
	private Integer accountNo;
	
	@Column(name="username")
	private Integer username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="transPass")
	private String transPass;
	
	@Column(name="impsUpperLimit")
	private Integer impsUpperLimit;
	
	@Column(name="neftUpperLimit")
	private Integer neftUpperLimit;
	
	@Column(name="rtgsUpperLimit")
	private Integer rtgsUpperLimit;
	
	@Column(name="isBlocked")
	private Integer isBlocked;

	public InternetBanking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternetBanking(Integer id, Integer accountNo, Integer username, String password, String transPass,
			Integer impsUpperLimit, Integer neftUpperLimit, Integer rtgsUpperLimit, Integer isBlocked) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.username = username;
		this.password = password;
		this.transPass = transPass;
		this.impsUpperLimit = impsUpperLimit;
		this.neftUpperLimit = neftUpperLimit;
		this.rtgsUpperLimit = rtgsUpperLimit;
		this.isBlocked = isBlocked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getUsername() {
		return username;
	}

	public void setUsername(Integer username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTransPass() {
		return transPass;
	}

	public void setTransPass(String transPass) {
		this.transPass = transPass;
	}

	public Integer getImpsUpperLimit() {
		return impsUpperLimit;
	}

	public void setImpsUpperLimit(Integer impsUpperLimit) {
		this.impsUpperLimit = impsUpperLimit;
	}

	public Integer getNeftUpperLimit() {
		return neftUpperLimit;
	}

	public void setNeftUpperLimit(Integer neftUpperLimit) {
		this.neftUpperLimit = neftUpperLimit;
	}

	public Integer getRtgsUpperLimit() {
		return rtgsUpperLimit;
	}

	public void setRtgsUpperLimit(Integer rtgsUpperLimit) {
		this.rtgsUpperLimit = rtgsUpperLimit;
	}

	public Integer getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Integer isBlocked) {
		this.isBlocked = isBlocked;
	}

	@Override
	public String toString() {
		return "InternetBanking [id=" + id + ", accountNo=" + accountNo + ", username=" + username + ", password="
				+ password + ", transPass=" + transPass + ", impsUpperLimit=" + impsUpperLimit + ", neftUpperLimit="
				+ neftUpperLimit + ", rtgsUpperLimit=" + rtgsUpperLimit + ", isBlocked=" + isBlocked + "]";
	}
	
}
