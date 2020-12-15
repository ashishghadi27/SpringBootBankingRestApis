package com.lti.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestServiceRefernceTemplate;
import com.lti.model.Account;
import com.lti.model.ServiceReference;
import com.lti.model.Transaction;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public AccountDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public AccountDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<RestAccountSummaryTemplate> displayAccountSummary(Integer userId) {
		Session session = factory.getCurrentSession();
		NativeQuery q1 = session.createSQLQuery("select * from account where userid = " + userId);
		q1.addEntity(Account.class);
		
		
		/*NativeQuery<Object[]> query = session.createSQLQuery("select a.accountNo,a.userId,a.balance,a.branchId,a.accountType,a.balance,t.transactionId,t.accountNo,t.startDate,t.type,t.amount,t.endDate,t.reason,t.flow, t.toAccount from account a inner join transactions t on a.accountNo= t.accountNo where a.userId="+userId+" and ROWNUM < 6")
				.addEntity("a",Account.class)
				.addEntity("t",Transaction.class);
		List<Object[]> resultSet = query.list();
		List<Object> updateList1 = new ArrayList<Object>();
		for (Object[] row : resultSet) {
		    for(Object obj : row) {
		    	updateList1.add(obj);
		    }
		}
		System.out.println("List is");
		for(Object obj : updateList1){
			System.out.println(obj);
		}*/
		RestAccountSummaryTemplate restAccountSummaryTemplate = new RestAccountSummaryTemplate();
		Account accDetails = null;
		try{
			accDetails = (Account) q1.getSingleResult();
			System.out.println(accDetails);
			NativeQuery q2 = session.createSQLQuery("select * from transactions where accountNo="+accDetails.getAccountNo());
			q2.addEntity(Transaction.class);
	        List<Transaction> transactions = (List<Transaction>) q2.list();
	       
			restAccountSummaryTemplate.setStatus("success");
			restAccountSummaryTemplate.setStatusCode(HttpStatus.OK);
			restAccountSummaryTemplate.setMessage("Account summary loaded successfully!");
			restAccountSummaryTemplate.setAccount(accDetails);
			restAccountSummaryTemplate.setTransaction(transactions);
			return new ResponseEntity<RestAccountSummaryTemplate>(restAccountSummaryTemplate, HttpStatus.OK);
		
		}
		catch (Exception e) {
			System.out.println("Exception");
			restAccountSummaryTemplate.setStatus("failed");
			restAccountSummaryTemplate.setStatusCode(HttpStatus.OK);
			restAccountSummaryTemplate.setMessage("Account summary not loaded");
			restAccountSummaryTemplate.setAccount(accDetails);
			restAccountSummaryTemplate.setTransaction(null);
			return new ResponseEntity<RestAccountSummaryTemplate>(restAccountSummaryTemplate, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<RestServiceRefernceTemplate> displayStatus(Integer serviceId) {
		Session session = factory.getCurrentSession();	
		NativeQuery<Object[]> query = session.createSQLQuery("select serviceId, userId, adminId, cId, status, remark from service_reference where serviceId="+serviceId);
		List<Object[]> resultSet = query.list();
		ServiceReference serviceReference = new ServiceReference();
		for (Object[] row : resultSet) {
			serviceReference.setServiceId(Integer.parseInt(row[0].toString()));
			serviceReference.setUserId(Integer.parseInt(row[1].toString()));
			serviceReference.setAdminId(Integer.parseInt(row[2].toString()));
			serviceReference.setcId(Integer.parseInt(row[3].toString()));
			serviceReference.setStatus(row[4].toString());
			serviceReference.setRemark(row[5].toString());
		    System.out.println(row);
		}
		
		System.out.println(serviceReference);
        
        RestServiceRefernceTemplate restServiceRefernceTemplate = new RestServiceRefernceTemplate();
		if(serviceReference.getUserId() != null){
			restServiceRefernceTemplate.setStatus("success");
			restServiceRefernceTemplate.setStatusCode(HttpStatus.OK);
			restServiceRefernceTemplate.setMessage("Account status loaded successfully!");
			restServiceRefernceTemplate.setServiceReference(serviceReference);
			return new ResponseEntity<RestServiceRefernceTemplate>(restServiceRefernceTemplate, HttpStatus.OK);
		}
		else{
			restServiceRefernceTemplate.setStatus("failed");
			restServiceRefernceTemplate.setStatusCode(HttpStatus.OK);
			restServiceRefernceTemplate.setMessage("Invalid Service reference");
			return new ResponseEntity<RestServiceRefernceTemplate>(restServiceRefernceTemplate, HttpStatus.OK);
		}
	}
	
}
