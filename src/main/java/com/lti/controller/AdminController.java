package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.RestTemplateModels.RestAdminTemplate;
import com.lti.RestTemplateModels.RestCustRepresTemplate;
import com.lti.RestTemplateModels.RestServiceReferenceListTemplate;
import com.lti.RestTemplateModels.RestServiceReferenceTemplate;
import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserObjectTemplate;
import com.lti.model.ServiceReference;
import com.lti.services.AdminService;

@RestController
@RequestMapping(path = "/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService service;
	
	public AdminService getService() {
		return service;
	}

	public void setService(AdminService service) {
		this.service = service;
	}

	public AdminController(AdminService service) {
		super();
		this.service = service;
	}

	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostMapping(path="/generateServiceReference")
	public ResponseEntity<RestServiceReferenceTemplate> registerDebitCard(@RequestBody ServiceReference serviceReference){
		return service.generateServiceReference(serviceReference);
	}
	
	@PutMapping(path="/updateAdminAndCustRepres")
	public ResponseEntity<RestSimpleTemplate> updateAdminAndCustRepres(@RequestParam("userId") String userId, 
																	   @RequestParam("adminId") String adminId, 
																	   @RequestParam("cId") String cId)
	{
		return service.updateAdminAndCustRepres(userId, adminId, cId);
	}
	
	
	@PutMapping(path="/updateStatus")
	public ResponseEntity<RestSimpleTemplate> updateStatus(@RequestParam("userId") String userId, 
																	   @RequestParam("status") String status, 
																	   @RequestParam("remark") String remark)
	{
		return service.updateStatus(userId, status, remark);
	}
	
	@GetMapping(path="/adminLogin")
	public ResponseEntity<RestAdminTemplate> adminLogin(@RequestParam("username") String username, 
																	   @RequestParam("password") String password)
	{
		return service.adminLogin(username, password);
	}
	
	@GetMapping(path="/custRepresLogin")
	public ResponseEntity<RestCustRepresTemplate> custRepresLogin(@RequestParam("username") String username, 
																	   @RequestParam("password") String password)
	{
		return service.customerRepresentativeLogin(username, password);
	}
	
	@GetMapping(path="/getServiceReferenceList")
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReference()
	{
		return service.getListOfServiceReference();
	}
	
	@GetMapping(path="/getServiceReferenceListByAdmin")
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByAdmin(@RequestParam("adminId") String adminId)
	{
		return service.getListOfServiceReferenceByAdmin(adminId);
	}
	
	@GetMapping(path="/getServiceReferenceListByCid")
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByCid(@RequestParam("cId") String cId)
	{
		return service.getListOfServiceReferenceByCid(cId);
	}
	
	@GetMapping(path="/getServiceReferenceListByUserId")
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByUserId(@RequestParam("userId") String userId)
	{
		return service.getListOfServiceReferenceByUserId(userId);
	}
	
	@GetMapping(path="/getUserDetails")
	public ResponseEntity<RestUserObjectTemplate> getUserDetails(@RequestParam("userId") String userId)
	{
		return service.getUserDetailsAndAccountDetails(userId);
	}
	
	@DeleteMapping(path="/deleteServiceReference")
	public ResponseEntity<RestSimpleTemplate> deleteServiceReference(@RequestParam("serviceId") String serviceId)
	{
		return service.deleteServiceReference(serviceId);
	}
	
	@GetMapping(path="/sendSMS")
	public ResponseEntity<RestSimpleTemplate> sendSMS(@RequestParam("phone") String phone, @RequestParam("message") String message)
	{
		return service.sendSMS(phone, message);
	}
	
}
