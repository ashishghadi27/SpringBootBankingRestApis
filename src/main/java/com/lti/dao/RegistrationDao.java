package com.lti.dao;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestAccountTemplate;
import com.lti.RestTemplateModels.RestDebitTemplate;
import com.lti.RestTemplateModels.RestInternetTemplate;
import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserIdAndOtpTemplate;
import com.lti.RestTemplateModels.RestUserTemplate;
import com.lti.model.Account;
import com.lti.model.Address;
import com.lti.model.Debit;
import com.lti.model.InternetBanking;
import com.lti.model.Occupation;
import com.lti.model.RegisterUser;

public interface RegistrationDao {
	ResponseEntity<RestUserTemplate> createUser(RegisterUser user);
	ResponseEntity<RestSimpleTemplate> insertAddress(Address address);
	ResponseEntity<RestSimpleTemplate> insertOccupation(Occupation occupation);
	ResponseEntity<RestUserIdAndOtpTemplate> getUserId(Integer accountNo);
	ResponseEntity<RestInternetTemplate> registerForInternetBanking(InternetBanking banking);
	ResponseEntity<RestSimpleTemplate> setTransactionPassword(String password, Integer accountNo);
	ResponseEntity<RestAccountTemplate> createAccount(Account account);
	ResponseEntity<RestDebitTemplate> registerDebitCard(Debit debit);
}
