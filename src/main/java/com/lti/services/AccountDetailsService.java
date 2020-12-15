package com.lti.services;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestBranchListTemplate;
import com.lti.RestTemplateModels.RestDetailsTemplate;
import com.lti.RestTemplateModels.RestStatementTemplate;

public interface AccountDetailsService {

	ResponseEntity<RestDetailsTemplate> getDetails(Integer id);
	
	ResponseEntity<RestStatementTemplate> fetchStatement(Integer userId, Date startDate, Date endDate);
	
	ResponseEntity<RestBranchListTemplate> fetchAllBranches();
	
}
