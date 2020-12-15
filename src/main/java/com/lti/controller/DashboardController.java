package com.lti.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.RestTemplateModels.RestBranchListTemplate;
import com.lti.RestTemplateModels.RestDetailsTemplate;
import com.lti.RestTemplateModels.RestStatementTemplate;
import com.lti.services.AccountDetailsService;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins="http://localhost:4200")
public class DashboardController {
	
	@Autowired
	private AccountDetailsService detailsService;

	public AccountDetailsService getDetailsService() {
		return detailsService;
	}

	public void setDetailsService(AccountDetailsService detailsService) {
		this.detailsService = detailsService;
	}

	@GetMapping("/getDetails")
	public ResponseEntity<RestDetailsTemplate> fetchDetails(@RequestParam("userId") Integer id) {
		return detailsService.getDetails(id);
	}
	
	@GetMapping("/getStatement")
	public ResponseEntity<RestStatementTemplate> fetchStatement(@RequestParam("userId") Integer userId,
																@RequestParam(value="startDate",required = false) Date startDate,
																@RequestParam(value="endDate", required = false) Date endDate) {
		System.out.println(startDate);
		return detailsService.fetchStatement(userId, startDate, endDate);
	}
	
	@GetMapping("/getAllBranches")
	public ResponseEntity<RestBranchListTemplate> fetchAllBranches() {
		return detailsService.fetchAllBranches();
	}
}
