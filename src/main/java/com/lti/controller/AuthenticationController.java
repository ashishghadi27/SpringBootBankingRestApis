package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserIdAndOtpTemplate;
import com.lti.services.AuthenticationService;

@RestController
@RequestMapping(path = "/login")
@CrossOrigin(origins="http://localhost:4200")
public class AuthenticationController {
	@Autowired
	private AuthenticationService aService;
	
	public AuthenticationService getaService() {
		return aService;
	}

	public void setaService(AuthenticationService aService) {
		this.aService = aService;
	}

	public AuthenticationController() {
		super();
	}

	public AuthenticationController(AuthenticationService aService) {
		super();
		this.aService = aService;
	}

	@GetMapping(path="/checkUser")
	public ResponseEntity<RestSimpleTemplate> checkUser(@RequestParam("userId") Integer userId){
		return aService.checkUser(userId);
	}
	
	@GetMapping(path="/checkInternetBanking")
	public ResponseEntity<RestSimpleTemplate> checkInternetBanking(@RequestParam("userId") Integer userId){
		return aService.checkInternetBanking(userId);
	}
	
	@PostMapping(path="/checkLogin")
	public ResponseEntity<RestSimpleTemplate> checkLogin( @RequestParam("userId") Integer userId, @RequestParam("password") String password){
		return aService.checkLogin(userId,password);
	}
	
	@GetMapping(path="/checkAccountNo")
	public ResponseEntity<RestUserIdAndOtpTemplate> checkAccountNo(@RequestParam("accountNo") Integer accountNo){
		return aService.checkAccountNo(accountNo);
	}
	
	@GetMapping(path="/checkUserForOtp")
	public ResponseEntity<RestUserIdAndOtpTemplate> checkUserForOtp(@RequestParam("userId") Integer userId){
		return aService.checkUserForOtp(userId);
	}
	
	@PutMapping(path="/setNewLoginPassword")
	public ResponseEntity<RestSimpleTemplate> setLoginPassword(@RequestParam("password") String password, @RequestParam("userId") Integer userId){
		return aService.setLoginPassword(password,userId);
	}
}
