package com.lti.dao;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestBranchListTemplate;
import com.lti.RestTemplateModels.RestDetailsTemplate;
import com.lti.RestTemplateModels.RestStatementTemplate;


public interface AccountDetailsDao {

	ResponseEntity<RestDetailsTemplate> fetchDetails(Integer userId);
	
	ResponseEntity<RestStatementTemplate> fetchTransactions(Integer userId, Date startDate, Date endDate);
	
	ResponseEntity<RestBranchListTemplate> fetchBranches();
	
}
