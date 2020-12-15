package com.lti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.RestTemplateModels.RestAddBeneficiarytTemplate;
import com.lti.RestTemplateModels.RestDisplayBeneficiaryTemplate;
import com.lti.model.AddBeneficiary;


@Repository
public class BeneficiaryDaoImpl implements BeneficiaryDao {

	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory(){
		return factory;
	}
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public BeneficiaryDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public BeneficiaryDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ResponseEntity<RestAddBeneficiarytTemplate> addBeneficiary(AddBeneficiary add){
		Session session = factory.getCurrentSession();
		session.save(add);
		if(add.getBeneficiaryAccNo() != null){
			RestAddBeneficiarytTemplate addbeneficiarytemplate = new RestAddBeneficiarytTemplate("success", "Beneficiary Added Successfully!", HttpStatus.OK, add);
			return new ResponseEntity<RestAddBeneficiarytTemplate>(addbeneficiarytemplate,HttpStatus.OK);
		}
		else{
			RestAddBeneficiarytTemplate addbeneficiarytemplate = new RestAddBeneficiarytTemplate("failure", "Could not add Beneficiary", HttpStatus.INTERNAL_SERVER_ERROR, null);
			return new ResponseEntity<RestAddBeneficiarytTemplate>(addbeneficiarytemplate,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<RestDisplayBeneficiaryTemplate> displayBeneficiary(Integer accountNo) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery("Select * from beneficiaries where accountNo=" +accountNo);
		query.addEntity(AddBeneficiary.class);
		try{
			List<AddBeneficiary> list = (List<AddBeneficiary>) query.list();
			RestDisplayBeneficiaryTemplate restDisplayBeneficiaryTemplate = new RestDisplayBeneficiaryTemplate("success", "Beneficiary info fetched", HttpStatus.OK, list);
			return new ResponseEntity<RestDisplayBeneficiaryTemplate>(restDisplayBeneficiaryTemplate, HttpStatus.OK);
		}
		catch(Exception e){
			RestDisplayBeneficiaryTemplate restDisplayBeneficiaryTemplate = new RestDisplayBeneficiaryTemplate("failure", "Beneficiary info not found", HttpStatus.INTERNAL_SERVER_ERROR, null);
			return new ResponseEntity<RestDisplayBeneficiaryTemplate>(restDisplayBeneficiaryTemplate, HttpStatus.OK);
			
		}
	}
	
	
}
