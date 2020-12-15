package com.lti.dao;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestCityListTemplate;
import com.lti.RestTemplateModels.RestStateListTemplate;

public interface UtilityDao {

	ResponseEntity<RestStateListTemplate> getStates();
	ResponseEntity<RestCityListTemplate> getCities(Integer stateId);
}
