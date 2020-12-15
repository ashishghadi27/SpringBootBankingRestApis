package com.lti.services;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestAddBeneficiarytTemplate;
import com.lti.RestTemplateModels.RestDisplayBeneficiaryTemplate;
import com.lti.model.AddBeneficiary;

public interface AddBeneficiarService {
	
	ResponseEntity<RestAddBeneficiarytTemplate> addBeneficiary(AddBeneficiary beneficiary);
	ResponseEntity<RestDisplayBeneficiaryTemplate> displayBeneficiary(Integer accountNo);

}
