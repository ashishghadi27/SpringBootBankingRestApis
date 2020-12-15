package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.RestTemplateModels.RestAddBeneficiarytTemplate;
import com.lti.RestTemplateModels.RestDisplayBeneficiaryTemplate;
import com.lti.model.AddBeneficiary;
import com.lti.services.AddBeneficiarService;


@RestController
@RequestMapping(path="/beneficiary")
@CrossOrigin(origins="http://localhost:4200")
public class FundTransferController {
	
	@Autowired
	private AddBeneficiarService abService;

	public AddBeneficiarService getAbService() {
		return abService;
	}

	public void setAbService(AddBeneficiarService abService) {
		this.abService = abService;
	}

	public FundTransferController(AddBeneficiarService abService) {
		super();
		this.abService = abService;
	}

	public FundTransferController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping(path="/addPayee")
	public ResponseEntity<RestAddBeneficiarytTemplate> addbeneficiary(@RequestBody AddBeneficiary add){
		return abService.addBeneficiary(add);
	}
	
	@GetMapping(path="/displayBeneficiary")
	public ResponseEntity<RestDisplayBeneficiaryTemplate> displayBeneficiary(@RequestParam("accountNo") Integer accountNo){
		return abService.displayBeneficiary(accountNo);
	}
	

}
