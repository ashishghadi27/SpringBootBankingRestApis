package com.lti.services;

import org.springframework.http.ResponseEntity;

import com.lti.RestTemplateModels.RestCityListTemplate;
import com.lti.RestTemplateModels.RestStateListTemplate;

public interface UtilityService {
	ResponseEntity<RestStateListTemplate> getStates();
	ResponseEntity<RestCityListTemplate> getCities(Integer stateId);

}
