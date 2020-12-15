package com.lti.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.RestTemplateModels.RestAccountTemplate;
import com.lti.RestTemplateModels.RestDebitTemplate;
import com.lti.RestTemplateModels.RestInternetTemplate;
import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserIdAndOtpTemplate;
import com.lti.RestTemplateModels.RestUserTemplate;
import com.lti.dao.RegistrationDao;
import com.lti.model.Account;
import com.lti.model.Address;
import com.lti.model.Debit;
import com.lti.model.InternetBanking;
import com.lti.model.Occupation;
import com.lti.model.RegisterUser;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private RegistrationDao registrationDao;

	public RegistrationDao getRegistrationDao() {
		return registrationDao;
	}

	public void setRegistrationDao(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

	public RegistrationServiceImpl(RegistrationDao registrationDao) {
		super();
		this.registrationDao = registrationDao;
	}

	public RegistrationServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResponseEntity<RestUserTemplate> createUser(RegisterUser user) {
		return registrationDao.createUser(user);
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> insertAddress(Address address) {
		ResponseEntity<RestSimpleTemplate> responseEntity = registrationDao.insertAddress(address);
		//System.out.println("In service: " + responseEntity.getBody() + " " + responseEntity.getStatusCode());
		return responseEntity;
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> insertOccupation(Occupation occupation) {
		return registrationDao.insertOccupation(occupation);
	}

	@Override
	public ResponseEntity<RestInternetTemplate> registerForInternetBanking(InternetBanking banking) {
		return registrationDao.registerForInternetBanking(banking);
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> setTransactionPassword(String password, Integer accountNo) {
		return registrationDao.setTransactionPassword(password, accountNo);
	}

	@Override
	public ResponseEntity<RestUserIdAndOtpTemplate> getUserId(Integer accountNo) {
		return registrationDao.getUserId(accountNo);
	}

	@Override
	public ResponseEntity<RestAccountTemplate> createAccount(Account account) {
		return registrationDao.createAccount(account);
	}

	@Override
	public ResponseEntity<RestDebitTemplate> registerDebitCard(Debit debit) {
		return registrationDao.registerDebitCard(debit);
	}
	
	
	
}
