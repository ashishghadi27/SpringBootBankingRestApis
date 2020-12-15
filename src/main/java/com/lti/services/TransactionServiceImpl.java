package com.lti.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestTransactionTemplate;
import com.lti.dao.TransactionDao;
import com.lti.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionDao transactiondao;

	public TransactionDao getTransactiondao() {
		return transactiondao;
	}

	public void setTransactiondao(TransactionDao transactiondao) {
		this.transactiondao = transactiondao;
	}

	public TransactionServiceImpl(TransactionDao transactiondao) {
		super();
		this.transactiondao = transactiondao;
	}

	public TransactionServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@Transactional
	public ResponseEntity<RestTransactionTemplate> createTransaction(Transaction transaction){
		return transactiondao.createTransaction(transaction);
	}
	
	@Override
	@Transactional
	public ResponseEntity<RestTransactionTemplate> displayTransaction(Integer transactionId){
		return transactiondao.displayTransaction(transactionId);
	}

	@Override
	@Transactional
	public ResponseEntity<RestAccountSummaryTemplate> updateBalance(String balance, String accountNo) {
		return transactiondao.updateBalance(balance, accountNo);
	}
	

}
