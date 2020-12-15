package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestServiceRefernceTemplate;
import com.lti.services.AccountService;

@RestController
@RequestMapping(path = "/account")
@CrossOrigin(origins="http://localhost:4200")
public class AccountController {

	@Autowired
	private AccountService aService;

	public AccountService getaService() {
		return aService;
	}
	public void setaService(AccountService aService) {
		this.aService = aService;
	}

	public AccountController(AccountService aService) {
		super();
		this.aService = aService;
	}
	public AccountController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path="/displaySummary/{userId}")
	public ResponseEntity<RestAccountSummaryTemplate> displaySummary(@PathVariable("userId") Integer userId){
		return aService.displayAccountSummary(userId);
	}
	
	@GetMapping(path="/displayStatus/{serviceId}")
	public ResponseEntity<RestServiceRefernceTemplate> displayStatus(@PathVariable("serviceId") Integer serviceId){
		return aService.displayStatus(serviceId);
	}
}
