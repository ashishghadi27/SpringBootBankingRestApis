package com.lti.services;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestTransactionTemplate;
import com.lti.model.Transaction;

public interface TransactionService {
	
	ResponseEntity<RestTransactionTemplate> createTransaction(Transaction transaction);
	ResponseEntity<RestAccountSummaryTemplate> updateBalance(String balance, String accountNo);
	ResponseEntity<RestTransactionTemplate> displayTransaction(Integer transactionId);

}
