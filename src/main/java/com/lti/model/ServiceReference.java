package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="service_reference")
public class ServiceReference {

	@Id
	@Column(name="serviceId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="service_ref_seq")
	@SequenceGenerator(name="service_ref_seq", sequenceName="service_reference_seq", allocationSize=1)
	private Integer serviceId;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="adminId")
	private Integer adminId;
	
	@Column(name="cId")
	private Integer cId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="remark")
	private String remark;

	public ServiceReference() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceReference(Integer serviceId, Integer userId, Integer adminId, Integer cId, String status,
			String remark) {
		super();
		this.serviceId = serviceId;
		this.userId = userId;
		this.adminId = adminId;
		this.cId = cId;
		this.status = status;
		this.remark = remark;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ServiceReference [serviceId=" + serviceId + ", userId=" + userId + ", adminId=" + adminId + ", cId="
				+ cId + ", status=" + status + ", remark=" + remark + "]";
	}
	
}
