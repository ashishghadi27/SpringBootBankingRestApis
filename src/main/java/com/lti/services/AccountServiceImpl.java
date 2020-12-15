package com.lti.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestServiceRefernceTemplate;
import com.lti.dao.AccountDao;


@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public AccountServiceImpl(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	@Transactional
	public ResponseEntity<RestAccountSummaryTemplate> displayAccountSummary(Integer userId) {
		// TODO Auto-generated method stub
		return accountDao.displayAccountSummary(userId);
	}
	@Override
	@Transactional
	public ResponseEntity<RestServiceRefernceTemplate> displayStatus(Integer serviceId) {
		// TODO Auto-generated method stub
		return accountDao.displayStatus(serviceId);
	}
	
	
}
