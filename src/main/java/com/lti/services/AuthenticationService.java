package com.lti.services;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserIdAndOtpTemplate;

public interface AuthenticationService {
	ResponseEntity<RestSimpleTemplate> checkUser(Integer userId);
	ResponseEntity<RestSimpleTemplate> checkInternetBanking(Integer userId);
	ResponseEntity<RestSimpleTemplate> checkLogin(Integer userId,String password );
	ResponseEntity<RestUserIdAndOtpTemplate> checkAccountNo(Integer accountNo);
	ResponseEntity<RestUserIdAndOtpTemplate> checkUserForOtp(Integer userId);
	ResponseEntity<RestSimpleTemplate> setLoginPassword(String password, Integer userId);
}
