package com.lti.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.RestTemplateModels.RestAdminTemplate;
import com.lti.RestTemplateModels.RestCustRepresTemplate;
import com.lti.RestTemplateModels.RestServiceReferenceListTemplate;
import com.lti.RestTemplateModels.RestServiceReferenceTemplate;
import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserObjectTemplate;
import com.lti.dao.AdminDao;
import com.lti.model.ServiceReference;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	public AdminServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminServiceImpl(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public ResponseEntity<RestServiceReferenceTemplate> generateServiceReference(ServiceReference sReference) {
		return adminDao.generateServiceReference(sReference);
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> updateAdminAndCustRepres(String userId, String adminId, String cId) {
		return adminDao.updateAdminAndCustRepres(userId, adminId, cId);
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> updateStatus(String userId, String status, String remark) {
		return adminDao.updateStatus(userId, status, remark);
	}

	@Override
	public ResponseEntity<RestAdminTemplate> adminLogin(String username, String password) {
		return adminDao.adminLogin(username, password);
	}

	@Override
	public ResponseEntity<RestCustRepresTemplate> customerRepresentativeLogin(String username, String password) {
		return adminDao.customerRepresentativeLogin(username, password);
	}

	@Override
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReference() {
		return adminDao.getListOfServiceReference();
	}

	@Override
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByAdmin(String adminId) {
		return adminDao.getListOfServiceReferenceByAdmin(adminId);
	}

	@Override
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByCid(String cId) {
		return adminDao.getListOfServiceReferenceByCid(cId);
	}

	@Override
	public ResponseEntity<RestUserObjectTemplate> getUserDetailsAndAccountDetails(String userId) {
		return adminDao.getUserDetailsAndAccountDetails(userId);
	}

	@Override
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByUserId(String userId) {
		return adminDao.getListOfServiceReferenceByUserId(userId);
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> deleteServiceReference(String userId) {
		return adminDao.deleteServiceReference(userId);
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> sendSMS(String phoneNo, String message) {
		return adminDao.sendSMS(phoneNo, message);
	}
	
}
