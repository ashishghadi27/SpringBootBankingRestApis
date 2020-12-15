package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.RestTemplateModels.RestCityListTemplate;
import com.lti.RestTemplateModels.RestStateListTemplate;
import com.lti.services.UtilityService;

@RestController
@RequestMapping(path = "/utility")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilityController {

	@Autowired
	private UtilityService uService;

	public UtilityController(UtilityService uService) {
		super();
		this.uService = uService;
	}

	public UtilityController() {
		super();
	}

	public UtilityService getuService() {
		return uService;
	}

	public void setuService(UtilityService uService) {
		this.uService = uService;
	}

	@GetMapping(path = "/states")
	public ResponseEntity<RestStateListTemplate> getStates() {
		return uService.getStates();
	}

	@GetMapping(path = "/cities")
	public ResponseEntity<RestCityListTemplate> getCities(@RequestParam(value="stateId") Integer stateId) {
		return uService.getCities(stateId);
	}

}
