package com.lti.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.RestTemplateModels.RestCityListTemplate;
import com.lti.RestTemplateModels.RestStateListTemplate;
import com.lti.dao.UtilityDao;


@Service
public class UtilityServiceImpl implements UtilityService{
	@Autowired
	private UtilityDao utilityDao;
	
	public UtilityServiceImpl() {
		super();
	}

	public UtilityServiceImpl(UtilityDao utilityDao) {
		super();
		this.utilityDao = utilityDao;
	}
	
	public UtilityDao getUtilityDao() {
		return utilityDao;
	}

	public void setUtilityDao(UtilityDao utilityDao) {
		this.utilityDao = utilityDao;
	}

	@Override
	@Transactional
	public ResponseEntity<RestStateListTemplate> getStates() {
		// TODO Auto-generated method stub
		return utilityDao.getStates();
	}

	@Override
	@Transactional
	public ResponseEntity<RestCityListTemplate> getCities(Integer stateId) {
		// TODO Auto-generated method stub
		return utilityDao.getCities(stateId);
	}
}
