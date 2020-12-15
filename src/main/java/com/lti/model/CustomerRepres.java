package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust_repres")
public class CustomerRepres {

	@Id
	private Integer cId;
	private String name;
	private String username;
	private String password;
	
	public CustomerRepres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerRepres(Integer cId, String name, String username, String password) {
		super();
		this.cId = cId;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
