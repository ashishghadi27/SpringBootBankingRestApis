package com.lti.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserIdAndOtpTemplate;
import com.lti.model.Account;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {
	
	@Autowired
	private SessionFactory factory;
	
	public AuthenticationDaoImpl() {
		super();
	}

	public AuthenticationDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	private String getOTP(){
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<RestSimpleTemplate> checkUser(Integer userId) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("select * from bankuser where userId=?");
		query.setParameter(1,userId);
		List<Object[]> list = query.list();
		//System.out.println(list);
		if(list.isEmpty()) {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("failed", "Invalid User ID", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<RestSimpleTemplate>(restTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "Correct user ID", HttpStatus.OK);
			return new ResponseEntity<RestSimpleTemplate>(restTemplate,HttpStatus.OK);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<RestSimpleTemplate> checkInternetBanking(Integer userId) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("select netBankingEnabled from bankuser where userId=?");
		query.setParameter(1,userId);
		try{
			Object o = query.getSingleResult();
			Integer isnetBankingEnabled = Integer.parseInt(o.toString());
			if(isnetBankingEnabled.equals(1)) {
				RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "Net Banking is Enabled", HttpStatus.OK);
				return new ResponseEntity<RestSimpleTemplate>(restTemplate,HttpStatus.OK);
			}
			else {
				RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "Net Banking not Enabled", HttpStatus.OK);
				return new ResponseEntity<RestSimpleTemplate>(restTemplate,HttpStatus.OK);
			}
		}
		catch (Exception e) {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("failed", "Invalid User", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<RestSimpleTemplate>(restTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<RestSimpleTemplate> checkLogin(Integer userId,String password ) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("select password from internetBanking where username=?");
		query.setParameter(1,userId);
		try{
			Object o = query.getSingleResult();
			String pass=(o.toString());
			if(pass.equals(password)) {
				RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "User Logged In", HttpStatus.OK);
				return new ResponseEntity<RestSimpleTemplate>(restTemplate,HttpStatus.OK);
			}
			else {
				RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "Invalid Password", HttpStatus.OK);
				return new ResponseEntity<RestSimpleTemplate>(restTemplate,HttpStatus.OK);
			}
		}catch (Exception e) {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "Invalid User Id", HttpStatus.OK);
			return new ResponseEntity<RestSimpleTemplate>(restTemplate,HttpStatus.OK);
		}
	}

	@SuppressWarnings({"rawtypes" })
	@Override
	public ResponseEntity<RestUserIdAndOtpTemplate> checkAccountNo(Integer accountNo) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("select * from account where accountNo=?");
		query.addEntity(Account.class);
		query.setParameter(1,accountNo);
	
		try{
			Account account = (Account)query.getSingleResult();
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "Valid AccountNo", HttpStatus.OK);
			int otp=Integer.parseInt(getOTP());
			RestUserIdAndOtpTemplate restOtpTemplate = new RestUserIdAndOtpTemplate(restTemplate,  account.getUserId(),  otp);
			return new ResponseEntity<RestUserIdAndOtpTemplate>(restOtpTemplate,HttpStatus.OK);

		}
		catch (Exception e) {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("failed", "Invalid AccountNo", HttpStatus.OK);
			RestUserIdAndOtpTemplate restOtpTemplate = new RestUserIdAndOtpTemplate(restTemplate,  null,  null);
			return new ResponseEntity<RestUserIdAndOtpTemplate>(restOtpTemplate,HttpStatus.OK);
		}
		
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<RestUserIdAndOtpTemplate> checkUserForOtp(Integer userId) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("select * from bankuser where userId=?");
		query.setParameter(1,userId);
		List<Object[]> list = query.list();
		if(list.isEmpty()) {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("failed", "Invalid UserId", HttpStatus.INTERNAL_SERVER_ERROR);
			RestUserIdAndOtpTemplate restOtpTemplate = new RestUserIdAndOtpTemplate(restTemplate,  userId,  null);
			return new ResponseEntity<RestUserIdAndOtpTemplate>(restOtpTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "Valid UserId", HttpStatus.OK);
			int otp=Integer.parseInt(getOTP());
			RestUserIdAndOtpTemplate restOtpTemplate = new RestUserIdAndOtpTemplate(restTemplate, userId,  otp);
			return new ResponseEntity<RestUserIdAndOtpTemplate>(restOtpTemplate,HttpStatus.OK);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<RestSimpleTemplate> setLoginPassword(String password, Integer userId) {
		RestSimpleTemplate restSimpleTemplate = new RestSimpleTemplate();
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("update internetBanking set password='" + password + "' where username=" + userId);
		int updated = query.executeUpdate();
		if(updated > 0){
			restSimpleTemplate.setStatus("success");
			restSimpleTemplate.setStatusCode(HttpStatus.OK);
			restSimpleTemplate.setMessage("Login Password Updated Successfully");
		}
		else{
			restSimpleTemplate.setStatus("success");
			restSimpleTemplate.setStatusCode(HttpStatus.OK);
			restSimpleTemplate.setMessage("No Such User exists");
		}
		return new ResponseEntity<RestSimpleTemplate>(restSimpleTemplate, HttpStatus.OK);
	}

}
