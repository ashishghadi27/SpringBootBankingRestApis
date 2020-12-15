package com.lti.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.RestTemplateModels.RestBranchListTemplate;
import com.lti.RestTemplateModels.RestDetailsTemplate;
import com.lti.RestTemplateModels.RestStatementTemplate;
import com.lti.dao.AccountDetailsDao;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	private AccountDetailsDao detailsDao;
	
	public AccountDetailsDao getDetailsDao() {
		return detailsDao;
	}

	public void setDetailsDao(AccountDetailsDao detailsDao) {
		this.detailsDao = detailsDao;
	}

	@Override
	public String toString() {
		return "AccountDetailsServiceImpl [detailsDao=" + detailsDao + "]";
	}

	public AccountDetailsServiceImpl() {
		super();
	}

	public AccountDetailsServiceImpl(AccountDetailsDao detailsDao) {
		super();
		this.detailsDao = detailsDao;
	}

	@Override
	@Transactional
	public ResponseEntity<RestDetailsTemplate> getDetails(Integer id) {
		// TODO Auto-generated method stub
		return detailsDao.fetchDetails(id);
	}
	
	@Override
	@Transactional
	public ResponseEntity<RestStatementTemplate> fetchStatement(Integer userId, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return detailsDao.fetchTransactions(userId, startDate, endDate);
	}

	@Override
	@Transactional
	public ResponseEntity<RestBranchListTemplate> fetchAllBranches() {
		// TODO Auto-generated method stub
		return detailsDao.fetchBranches();
	}

}
