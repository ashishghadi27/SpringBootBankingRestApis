package com.lti.RestTemplateModels;

import java.util.List;

import com.lti.model.City;

public class RestCityListTemplate {
	
	private RestSimpleTemplate requestStatus;
	private List<City> cityList;
	
	public RestCityListTemplate() {
		super();
	}
	
	public RestCityListTemplate(RestSimpleTemplate requestStatus, List<City> cityList) {
		super();
		this.requestStatus = requestStatus;
		this.cityList = cityList;
	}

	public RestSimpleTemplate getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RestSimpleTemplate requestStatus) {
		this.requestStatus = requestStatus;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	@Override
	public String toString() {
		return "RestCityListTemplate [requestStatus=" + requestStatus + ", cityList=" + cityList + "]";
	}
	
	
}
