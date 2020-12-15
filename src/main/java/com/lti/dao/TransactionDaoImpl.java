package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestTransactionTemplate;
import com.lti.model.Transaction;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private SessionFactory factory;
	
	@PersistenceContext
	EntityManager em;
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public SessionFactory getFactory(){
		return factory;
	}

	public TransactionDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	@Override
	public ResponseEntity<RestTransactionTemplate> createTransaction(Transaction transaction){
		Session session = factory.getCurrentSession();
		session.save(transaction);
		if(transaction.getAccountNo() != null){
			RestTransactionTemplate restTemplate = new RestTransactionTemplate("success", "Transaction initiated", HttpStatus.OK, transaction);
			return new ResponseEntity<RestTransactionTemplate>(restTemplate,HttpStatus.OK);
		}
		else{
			RestTransactionTemplate restTemplate = new RestTransactionTemplate("failed", "Transaction failed", HttpStatus.INTERNAL_SERVER_ERROR, null);
			return new ResponseEntity<RestTransactionTemplate>(restTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity<RestTransactionTemplate> displayTransaction(Integer tid) {
		
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery("Select * from transactions where transactionId ="+tid);
		query.addEntity(Transaction.class);
		try{
			Transaction transaction = (Transaction)query.getSingleResult();
			RestTransactionTemplate restTransactionTemplate = new RestTransactionTemplate("success", "Transaction Info Fetched", HttpStatus.OK	, transaction);
			return new ResponseEntity<RestTransactionTemplate>(restTransactionTemplate,HttpStatus.OK);	
			
		}
		catch(Exception e){
			RestTransactionTemplate restTransactionTemplate = new RestTransactionTemplate("failed", "Invalid Transaction Id", HttpStatus.INTERNAL_SERVER_ERROR, null);
			return new ResponseEntity<RestTransactionTemplate>(restTransactionTemplate,HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	
	}
	
	@Override
	public ResponseEntity<RestAccountSummaryTemplate> updateBalance(String balance, String accountNo){
		
		Session session = factory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		NativeQuery query = session.createSQLQuery("Update account set balance =" + balance + " where accountNo = " + accountNo);
		int updated = query.executeUpdate();
		
		RestAccountSummaryTemplate restAccTemplate;
		
		if(updated > 0){
			restAccTemplate = new RestAccountSummaryTemplate("success","Balance updated",HttpStatus.OK);
			return new ResponseEntity<RestAccountSummaryTemplate>(restAccTemplate,HttpStatus.OK);
		}
		else{
			restAccTemplate = new RestAccountSummaryTemplate("failed","Transfer unsuccessfull",HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<RestAccountSummaryTemplate>(restAccTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
		
			
		}
		
	}


}
