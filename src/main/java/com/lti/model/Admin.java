package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	private Integer adminId;
	private String name;
	private String username;
	private String password;
	private String role;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(Integer adminId, String name, String username, String password, String role) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}
	
}
