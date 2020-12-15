package com.lti.dao;

import java.util.Random;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

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

@SuppressWarnings({ "unused", "deprecation" })
@Repository
public class RegistrationDaoImpl implements RegistrationDao{

	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public RegistrationDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public RegistrationDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResponseEntity<RestUserTemplate> createUser(RegisterUser user) {
		Session session = factory.getCurrentSession();
		session.save(user);
		if(user.getUserId() != null){
			RestUserTemplate restTemplate = new RestUserTemplate("success", "User Created Successfully", HttpStatus.OK, user);
			return new ResponseEntity<RestUserTemplate>(restTemplate,HttpStatus.OK);
		}
		else{
			RestUserTemplate restTemplate = new RestUserTemplate("failed", "User Creation Failed", HttpStatus.OK, null);
			return new ResponseEntity<RestUserTemplate>(restTemplate,HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> insertAddress(Address address) {
		Session session = factory.getCurrentSession();
		session.save(address);
		RestSimpleTemplate restAddressTemplate = new RestSimpleTemplate();
		System.out.println(address.getAddressId() + " IDI");
		if(address.getAddressId() != null){
			restAddressTemplate.setStatus("success");
			restAddressTemplate.setStatusCode(HttpStatus.OK);
			restAddressTemplate.setMessage("Address Saved Successfully");
			System.out.println("Here");
			return new ResponseEntity<RestSimpleTemplate>(restAddressTemplate, HttpStatus.OK);
		}
		else{
			restAddressTemplate.setStatus("failed");
			restAddressTemplate.setStatusCode(HttpStatus.OK);
			restAddressTemplate.setMessage("Address not saved");
			return new ResponseEntity<RestSimpleTemplate>(restAddressTemplate, HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> insertOccupation(Occupation occupation) {
		Session session = factory.getCurrentSession();
		session.save(occupation);
		RestSimpleTemplate restAddressTemplate = new RestSimpleTemplate();
		System.out.println(occupation.getOccupationId() + " IDI");
		if(occupation.getOccupationId() != null){
			restAddressTemplate.setStatus("success");
			restAddressTemplate.setStatusCode(HttpStatus.OK);
			restAddressTemplate.setMessage("Occupation Saved Successfully");
			System.out.println("Here");
			return new ResponseEntity<RestSimpleTemplate>(restAddressTemplate, HttpStatus.OK);
		}
		else{
			restAddressTemplate.setStatus("failed");
			restAddressTemplate.setStatusCode(HttpStatus.OK);
			restAddressTemplate.setMessage("Occupation not saved");
			return new ResponseEntity<RestSimpleTemplate>(restAddressTemplate, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<RestUserIdAndOtpTemplate> getUserId(Integer accountNo) {
		RestSimpleTemplate restSimpleTemplate = new RestSimpleTemplate();
		RestUserIdAndOtpTemplate restUserIdAndOtpTemplate = new RestUserIdAndOtpTemplate();
		String userId =  getUserIdFromAccountNo(accountNo);
		
		if(userId.length() >= 5){
			restSimpleTemplate.setStatus("success");
			restSimpleTemplate.setStatusCode(HttpStatus.OK);
			restSimpleTemplate.setMessage("User Found");
			restUserIdAndOtpTemplate.setRequestStatus(restSimpleTemplate);
			restUserIdAndOtpTemplate.setUserId(Integer.parseInt(userId));
			String otp = getOTP();
			restUserIdAndOtpTemplate.setOtp(Integer.parseInt(otp));
		}
		else {
			restSimpleTemplate.setStatus("success");
			restSimpleTemplate.setStatusCode(HttpStatus.OK);
			restSimpleTemplate.setMessage("User Not Found");
			restUserIdAndOtpTemplate.setUserId(Integer.parseInt(null));
			restUserIdAndOtpTemplate.setRequestStatus(restSimpleTemplate);
			restUserIdAndOtpTemplate.setOtp(null);
		}
		return new ResponseEntity<RestUserIdAndOtpTemplate>(restUserIdAndOtpTemplate, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	private String getUserIdFromAccountNo(Integer accountNo){
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("select userId from account where accountNo=" + accountNo);
		Object row = query.getSingleResult();
		//System.out.println("Row: " + row);
		return row.toString();
	}
	
	private String getOTP(){
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public ResponseEntity<RestSimpleTemplate> setTransactionPassword(String password, Integer accountNo) {
		RestSimpleTemplate restSimpleTemplate = new RestSimpleTemplate();
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("update internetBanking set transPass='" + password + "' where accountNo=" + accountNo);
		int updated = query.executeUpdate();
		if(updated > 0){
			restSimpleTemplate.setStatus("success");
			restSimpleTemplate.setStatusCode(HttpStatus.OK);
			restSimpleTemplate.setMessage("Transaction Password Updated Successfully");
		}
		else{
			restSimpleTemplate.setStatus("success");
			restSimpleTemplate.setStatusCode(HttpStatus.OK);
			restSimpleTemplate.setMessage("No Such Account exists");
		}
		return new ResponseEntity<RestSimpleTemplate>(restSimpleTemplate, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RestInternetTemplate> registerForInternetBanking(InternetBanking banking) {
		Session session = factory.getCurrentSession();
		session.save(banking);
		if(enableInternetBanking(banking.getUsername().toString()) > 0){
			RestInternetTemplate rTemplate = new RestInternetTemplate("success", "Internet Banking Enabled", HttpStatus.OK, banking);
			return new ResponseEntity<RestInternetTemplate>(rTemplate, HttpStatus.OK);
		}
		else {
			RestInternetTemplate rTemplate = new RestInternetTemplate("success", "Operation Failure", HttpStatus.OK, banking);
			return new ResponseEntity<RestInternetTemplate>(rTemplate, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings({ "rawtypes"})
	public int enableInternetBanking(String userId){
		Session session = factory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("update bankuser set netBankingEnabled=1 where userId=" + userId);
		int updated = query.executeUpdate();
		return updated;
	}

	@Override
	public ResponseEntity<RestAccountTemplate> createAccount(Account account) {
		Session session = factory.getCurrentSession();
		session.save(account);
		RestAccountTemplate restAccountTemplate;
		if(account.getAccountNo() != null){
			restAccountTemplate = new RestAccountTemplate("success", "Account Created Successfully", HttpStatus.OK, account);
			return new ResponseEntity<RestAccountTemplate>(restAccountTemplate, HttpStatus.OK);
		}
		else {
			restAccountTemplate = new RestAccountTemplate("success", "Account Creation Failed", HttpStatus.OK, account);
			return new ResponseEntity<RestAccountTemplate>(restAccountTemplate, HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseEntity<RestDebitTemplate> registerDebitCard(Debit debit) {
		Session session = factory.getCurrentSession();
		session.save(debit);
		RestDebitTemplate restDebitTemplate;
		if(debit.getDebitId() != null){
			restDebitTemplate = new RestDebitTemplate("success", "Debit Card Registered Successfully", HttpStatus.OK, debit);
			return new ResponseEntity<RestDebitTemplate>(restDebitTemplate, HttpStatus.OK);
		}
		else {
			restDebitTemplate = new RestDebitTemplate("success", "Debit Card Registration Failed", HttpStatus.OK, debit);
			return new ResponseEntity<RestDebitTemplate>(restDebitTemplate, HttpStatus.OK);
		}
	}
	
}
