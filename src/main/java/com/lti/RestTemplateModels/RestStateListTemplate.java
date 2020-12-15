package com.lti.RestTemplateModels;

import java.util.List;

import com.lti.model.State;

public class RestStateListTemplate {
	
	private RestSimpleTemplate requestStatus;
	private List<State> stateList;
	
	public RestStateListTemplate() {
		super();
	}

	public RestStateListTemplate(RestSimpleTemplate requestStatus, List<State> stateList) {
		super();
		this.requestStatus = requestStatus;
		this.stateList = stateList;
	}

	public RestSimpleTemplate getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RestSimpleTemplate requestStatus) {
		this.requestStatus = requestStatus;
	}

	public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	@Override
	public String toString() {
		return "RestStateListTemplate [requestStatus=" + requestStatus + ", stateList=" + stateList + "]";
	}
	
	
	
}
