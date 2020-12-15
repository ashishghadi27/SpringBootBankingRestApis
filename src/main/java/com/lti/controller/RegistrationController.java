package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.RestTemplateModels.RestAccountTemplate;
import com.lti.RestTemplateModels.RestDebitTemplate;
import com.lti.RestTemplateModels.RestInternetTemplate;
import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserIdAndOtpTemplate;
import com.lti.RestTemplateModels.RestUserTemplate;
import com.lti.model.Account;
import com.lti.model.Address;
import com.lti.model.Debit;
import com.lti.model.InternetBanking;
import com.lti.model.Occupation;
import com.lti.model.RegisterUser;
import com.lti.services.RegistrationService;

@RestController
@RequestMapping(path = "/register")
@CrossOrigin(origins="http://localhost:4200")
public class RegistrationController {

	@Autowired
	private RegistrationService rService;
	
	public RegistrationService getrService() {
		return rService;
	}

	public void setrService(RegistrationService rService) {
		this.rService = rService;
	}

	public RegistrationController(RegistrationService rService) {
		super();
		this.rService = rService;
	}

	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostMapping(path="/createUser")
	public ResponseEntity<RestUserTemplate> createUser(@RequestBody RegisterUser user){
		System.out.println(user);
		return rService.createUser(user);
	}
	
	@PostMapping(path="/insertAddress")
	public ResponseEntity<RestSimpleTemplate> insertAddress(@RequestBody Address address){
		System.out.println(address);
		ResponseEntity<RestSimpleTemplate> responseEntity = rService.insertAddress(address);
		//System.out.println("This " + responseEntity.getBody() + " " + responseEntity.getStatusCode());
		return responseEntity;
	}
	
	@PostMapping(path="/insertOccupation")
	public ResponseEntity<RestSimpleTemplate> insertOccupation(@RequestBody Occupation occupation){
		System.out.println(occupation);
		return rService.insertOccupation(occupation);
	}
	
	@PostMapping(path="/registerInternetBanking")
	public ResponseEntity<RestInternetTemplate> registerInternetBanking(@RequestBody InternetBanking banking){
		return rService.registerForInternetBanking(banking);
	}
	
	@GetMapping(path="/getUserId")
	public ResponseEntity<RestUserIdAndOtpTemplate> getUserId(@RequestParam("accountNo") Integer accountNo){
		return rService.getUserId(accountNo);
	}
	
	@PutMapping(path="/setTransPass")
	public ResponseEntity<RestSimpleTemplate> setTransPass(@RequestParam("accountNo") Integer accountNo, @RequestParam("transPass") String transPass){
		return rService.setTransactionPassword(transPass, accountNo);
	}
	
	@PostMapping(path="/createAccount")
	public ResponseEntity<RestAccountTemplate> createAccount(@RequestBody Account account){
		return rService.createAccount(account);
	}
	
	@PostMapping(path="/registerDebitCard")
	public ResponseEntity<RestDebitTemplate> registerDebitCard(@RequestBody Debit debit){
		return rService.registerDebitCard(debit);
	}
	
}
