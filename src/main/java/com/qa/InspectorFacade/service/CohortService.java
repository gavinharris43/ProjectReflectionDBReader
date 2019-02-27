package com.qa.InspectorFacade.service;

import java.util.ArrayList;

import com.qa.InspectorFacade.persistence.domain.SentCohort;

public interface CohortService {

	public SentCohort getSingleCohortByName(String name);
	
	public ArrayList<SentCohort> getAllCohorts();
	
	public String deleteCohort(String name);
	
	public String updateCohort(String name, SentCohort newCohort);

}
