package com.lti.dao;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestServiceRefernceTemplate;

public interface AccountDao {

	public ResponseEntity<RestAccountSummaryTemplate> displayAccountSummary(Integer userId);
	public ResponseEntity<RestServiceRefernceTemplate> displayStatus(Integer serviceId);
}
