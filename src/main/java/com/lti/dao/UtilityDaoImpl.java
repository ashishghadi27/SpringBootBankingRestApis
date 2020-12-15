package com.lti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.RestTemplateModels.RestCityListTemplate;
import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestStateListTemplate;
import com.lti.model.City;
import com.lti.model.State;
import org.hibernate.query.Query;

@Repository
public class UtilityDaoImpl implements UtilityDao{

	@Autowired
	private SessionFactory factory;
	
	
	public UtilityDaoImpl() {
		super();
	}

	public UtilityDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<RestStateListTemplate> getStates() {
		Session session = factory.getCurrentSession();
		Query q=session.createQuery("from State");
		List<State> states=q.list();
		if(states.isEmpty()) {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("failed", "Invalid Request", HttpStatus.INTERNAL_SERVER_ERROR);
			RestStateListTemplate restStateTemplate = new RestStateListTemplate(restTemplate,null);
			return new ResponseEntity<RestStateListTemplate>(restStateTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "States List Returned", HttpStatus.OK);
			RestStateListTemplate restStateTemplate = new RestStateListTemplate(restTemplate,states);
			return new ResponseEntity<RestStateListTemplate>(restStateTemplate,HttpStatus.OK);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<RestCityListTemplate> getCities(Integer stateId) {
		Session session = factory.getCurrentSession();
		Query q=session.createQuery("from City where stateId=?0");
		q.setParameter(0,stateId);
		List<City> cities=q.list();
		if(cities.isEmpty()) {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("failed", "Invalid Request", HttpStatus.INTERNAL_SERVER_ERROR);
			RestCityListTemplate restCityTemplate = new RestCityListTemplate(restTemplate,null);
			return new ResponseEntity<RestCityListTemplate>(restCityTemplate,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			RestSimpleTemplate restTemplate = new RestSimpleTemplate("success", "Cities List Returned", HttpStatus.OK);
			RestCityListTemplate restCityTemplate = new RestCityListTemplate(restTemplate,cities);
			return new ResponseEntity<RestCityListTemplate>(restCityTemplate,HttpStatus.OK);
		}
	}
	
	
	

}
