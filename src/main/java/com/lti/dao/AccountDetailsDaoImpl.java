package com.lti.dao;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.RestTemplateModels.RestBranchListTemplate;
import com.lti.RestTemplateModels.RestDetailsTemplate;
import com.lti.RestTemplateModels.RestStatementTemplate;
import com.lti.model.Account;
import com.lti.model.AddressNew;
import com.lti.model.Branch;
import com.lti.model.City;
import com.lti.model.Country;
import com.lti.model.Occupation;
import com.lti.model.RegisterUser;
import com.lti.model.State;
import com.lti.model.Transaction;

@Repository
public class AccountDetailsDaoImpl implements AccountDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String toString() {
		return "AccountDetailsDaoImpl [sessionFactory=" + sessionFactory + ", getSessionFactory()="
				+ getSessionFactory() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public AccountDetailsDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<RestDetailsTemplate> fetchDetails(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select u.title, u.firstName, u.middleName, u.lastName, u.fathername, u.mobileNo, u.email, u.aadhar, u.dob, a.addressId, a.line1, a.line2, a.landmark, a.pincode, a.isPermanent, c.cityId, c.cityName, s.stateId, s.stateName, ctry.countryId, ctry.countryName, o.occupationId from address a, bankuser u, city c, state s, occupation o, country ctry where a.userId=u.userId AND a.cityId=c.cityId AND a.stateId=s.stateId AND u.userId=o.userId AND s.countryId=ctry.countryId AND u.userId="+userId);
		List<Object[]> rows = query.getResultList();
		
		System.out.println(rows.size());
		
		try{
			Object[] row1 = rows.get(0);
			
			RegisterUser user = new RegisterUser();
			user.setUserId(userId);
			user.setTitle(row1[0].toString());
			user.setFirstName(row1[1].toString());
			user.setMiddleName(row1[2].toString());
			user.setLastName(row1[3].toString());
			user.setFatherName(row1[4].toString());
			user.setMobileNo(row1[5].toString());
			user.setEmail(row1[6].toString());
			user.setAadhar(row1[7].toString());
			Date date;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(row1[8].toString());
				user.setDob(date);
			} catch (ParseException e) {
				System.out.println("this");
				e.printStackTrace();
			} 
			
			System.out.println(user);
			
			AddressNew residentialAddress = new AddressNew();
			AddressNew permanentAddress = new AddressNew();
			System.out.println("before if");
			if (rows.size()==1) {
				
				
				
				Country country = new Country();
				country.setCountryId(Integer.parseInt(row1[19].toString()));
				country.setCountryName(row1[20].toString());
				
				State state = new State();
				state.setStateId(Integer.parseInt(row1[17].toString()));
				state.setCountry(country);
				state.setStateName(row1[18].toString());
				
				City city = new City();
				city.setCityId(Integer.parseInt(row1[15].toString()));
				city.setStateId(state.getStateId());
				city.setCityName(row1[16].toString());
				
				residentialAddress.setAddressId(Integer.parseInt(row1[9].toString()));
				residentialAddress.setUserId(userId);
				residentialAddress.setCity(city);
				residentialAddress.setState(state);
				residentialAddress.setLine1(row1[10].toString());
				residentialAddress.setLine2(row1[11].toString());
				residentialAddress.setLandmark(row1[12].toString());
				residentialAddress.setPincode(Integer.parseInt(row1[13].toString()));
				residentialAddress.setIsPermanent(Integer.parseInt(row1[14].toString()));

						
				permanentAddress = residentialAddress;
				
				
			} else if (rows.size()==2) {
				
				System.out.println("it enters");
				for (Object[] row: rows) {
					
					Country country = new Country();
					country.setCountryId(Integer.parseInt(row[19].toString()));
					country.setCountryName(row[20].toString());
					
					State state = new State();
					state.setStateId(Integer.parseInt(row[17].toString()));
					state.setCountry(country);
					state.setStateName(row[18].toString());
					
					City city = new City();
					city.setCityId(Integer.parseInt(row[15].toString()));
					city.setStateId(state.getStateId());
					city.setCityName(row[16].toString());
					
					AddressNew address = new AddressNew();
					address.setAddressId(Integer.parseInt(row[9].toString()));
					address.setUserId(userId);
					address.setCity(city);
					address.setState(state);
					address.setLine1(row[10].toString());
					address.setLine2(row[11].toString());
					address.setLandmark(row[12].toString());
					address.setPincode(Integer.parseInt(row[13].toString()));
					address.setIsPermanent(Integer.parseInt(row[14].toString()));
					
					System.out.println(address.getAddressId()+" "+address.getIsPermanent());
					
					if(address.getIsPermanent()==1) {
						permanentAddress = address;
					} else {
						residentialAddress = address;
					}
				}
				
			}
			Occupation occupation = session.get(Occupation.class, Integer.parseInt(row1[21].toString()));
		
			RestDetailsTemplate restDetailsTemplate = new RestDetailsTemplate("success", "account details retrieved", HttpStatus.OK, user, residentialAddress, permanentAddress, occupation);
			return new ResponseEntity<RestDetailsTemplate>(restDetailsTemplate, HttpStatus.OK);

		}	
		catch (Exception e) {
			RestDetailsTemplate restDetailsTemplate = new RestDetailsTemplate("failure", "account details retrival unsuccessful", HttpStatus.INTERNAL_SERVER_ERROR, null, null, null, null);
			return new ResponseEntity<RestDetailsTemplate>(restDetailsTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<RestStatementTemplate> fetchTransactions(Integer userId, Date startDate, Date endDate) {

		Session session = sessionFactory.getCurrentSession();
		
		Query queryForUserAccountBranch = session.createSQLQuery("select u.firstName, u.middleName, u.lastName, a.accountNo, a.accountType, a.balance, b.branchId, b.branchName, b.ifsc from bankuser u, account a, branch b where u.userId=a.userId AND a.branchId=b.branchId AND u.userId="+userId);
		// t.transactionId, t.reason, t.type, t.startDate, t.endDate, t.amount, t.flow 
		List<Object[]> rows = queryForUserAccountBranch.getResultList();
		
		System.out.println(rows.size());
		
		if (rows.size()==1) {
			
			Object[] row = rows.get(0);
			
			String firstName = row[0].toString();
			String middleName = row[1].toString();
			String lastName = row[2].toString();
			
			Account account = new Account();
			account.setAccountNo(Integer.parseInt(row[3].toString()));
			account.setUserId(userId);
			account.setBranchId(Integer.parseInt(row[6].toString()));
			account.setAccountType(row[4].toString());
			account.setBalance(Long.parseLong(row[5].toString()));
			
			Branch branch = new Branch();
			branch.setBranchId(Integer.parseInt(row[6].toString()));
			branch.setBranchName(row[7].toString());
			branch.setIfsc(row[8].toString());
			
			
			List<Transaction> transactions = new ArrayList<>();
			
			if (startDate == null && endDate == null) {
				endDate = new Date();
				Calendar c = Calendar.getInstance(); 
				c.setTime(endDate); 
				c.add(Calendar.MONTH, -1);
				startDate = c.getTime();
				
				
			}
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			
			String sDate = format.format(startDate);
			String eDate = format.format(endDate);
			
			org.hibernate.query.Query<Transaction> queryForTransactions = session.createQuery("from com.lti.model.Transaction where accountNo="+account.getAccountNo()+" AND (endDate BETWEEN '"+sDate+"' AND '"+eDate+"') ORDER BY endDate DESC");
			
			transactions = queryForTransactions.list();
			
	
					
			RestStatementTemplate restStatementTemplate = new RestStatementTemplate("success", "transactions for the period fetched successfully", HttpStatus.OK, firstName, middleName, lastName, account,branch, transactions);
			return new ResponseEntity<RestStatementTemplate>(restStatementTemplate, HttpStatus.OK);	
		} else {
			RestStatementTemplate restStatementTemplate = new RestStatementTemplate("failure", "unsuccessful", HttpStatus.INTERNAL_SERVER_ERROR, null, null, null, null,null, null);
			return new ResponseEntity<RestStatementTemplate>(restStatementTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<RestBranchListTemplate> fetchBranches() {

		Session session = sessionFactory.getCurrentSession();
		
		Query sql = session.createQuery("from com.lti.model.Branch");
		
		List<Branch> branches = sql.getResultList();
		if (branches.size()>0) {
			RestBranchListTemplate restBranchListTemplate = new RestBranchListTemplate("success", "all branches retrieved successfully", HttpStatus.OK, branches);
			return new ResponseEntity<RestBranchListTemplate>(restBranchListTemplate,HttpStatus.OK);
		} else {
			RestBranchListTemplate restBranchListTemplate = new RestBranchListTemplate("failure", "branch retrival unsuccessful", HttpStatus.INTERNAL_SERVER_ERROR, branches);
			return new ResponseEntity<RestBranchListTemplate>(restBranchListTemplate, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
