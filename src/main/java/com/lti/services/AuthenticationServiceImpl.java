package com.lti.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserIdAndOtpTemplate;
import com.lti.dao.AuthenticationDao;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationDao authenticationDao;

	public AuthenticationServiceImpl(AuthenticationDao authenticationDao) {
		super();
		this.authenticationDao = authenticationDao;
	}
	
	public AuthenticationServiceImpl() {
		super();
	}

	public AuthenticationDao getAuthenticationDao() {
		return authenticationDao;
	}

	public void setAuthenticationDao(AuthenticationDao authenticationDao) {
		this.authenticationDao = authenticationDao;
	}

	@Override
	@Transactional
	public ResponseEntity<RestSimpleTemplate> checkUser(Integer userId) {
		
		return authenticationDao.checkUser(userId) ;
	}

	@Override
	@Transactional
	public ResponseEntity<RestSimpleTemplate> checkInternetBanking(Integer userId) {
		
		return authenticationDao.checkInternetBanking( userId);
	}

	@Override
	@Transactional
	public ResponseEntity<RestSimpleTemplate> checkLogin(Integer userId,String password ) {
		
		return authenticationDao.checkLogin(userId,password);
	}

	@Override
	@Transactional
	public ResponseEntity<RestUserIdAndOtpTemplate> checkAccountNo(Integer accountNo) {
		
		return authenticationDao.checkAccountNo(accountNo);
	}

	@Override
	@Transactional
	public ResponseEntity<RestUserIdAndOtpTemplate> checkUserForOtp(Integer userId) {
		
		return authenticationDao.checkUserForOtp(userId);
	}
	
	@Override
	@Transactional
	public ResponseEntity<RestSimpleTemplate> setLoginPassword(String password, Integer userId){
		return authenticationDao.setLoginPassword(password,userId);
	}

}
