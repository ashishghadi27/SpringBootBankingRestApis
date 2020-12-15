package com.lti.services;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestServiceRefernceTemplate;


public interface AccountService {

	public ResponseEntity<RestAccountSummaryTemplate> displayAccountSummary(Integer userId);
	public ResponseEntity<RestServiceRefernceTemplate> displayStatus(Integer serviceId);
}
