package com.lti.dao;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestTransactionTemplate;
import com.lti.model.Transaction;

public interface TransactionDao {

	ResponseEntity<RestTransactionTemplate> createTransaction(Transaction transaction);
	ResponseEntity<RestTransactionTemplate> displayTransaction(Integer tid);
	ResponseEntity<RestAccountSummaryTemplate> updateBalance(String balance, String accountNo);
	
}
