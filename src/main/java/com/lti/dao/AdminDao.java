package com.lti.dao;


import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestAdminTemplate;
import com.lti.RestTemplateModels.RestCustRepresTemplate;
import com.lti.RestTemplateModels.RestServiceReferenceListTemplate;
import com.lti.RestTemplateModels.RestServiceReferenceTemplate;
import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserObjectTemplate;
import com.lti.model.ServiceReference;

public interface AdminDao {
	ResponseEntity<RestServiceReferenceTemplate> generateServiceReference(ServiceReference sReference);
	ResponseEntity<RestSimpleTemplate> updateAdminAndCustRepres(String userId, String adminId, String cId);
	ResponseEntity<RestSimpleTemplate> updateStatus(String userId, String status, String remark);
	ResponseEntity<RestAdminTemplate> adminLogin(String username, String password);
	ResponseEntity<RestCustRepresTemplate> customerRepresentativeLogin(String username, String password);
	ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReference();
	ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByAdmin(String adminId);
	ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByCid(String cId);
	ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByUserId(String userId);
	ResponseEntity<RestSimpleTemplate> deleteServiceReference(String userId);
	ResponseEntity<RestUserObjectTemplate> getUserDetailsAndAccountDetails(String userId);
	ResponseEntity<RestSimpleTemplate> sendSMS(String phoneNo, String message);
}
