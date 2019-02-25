package com.qa.gogoGadgetMongoClientService.service;

import java.util.ArrayList;

import com.qa.gogoGadgetMongoClientService.persistence.domain.SentCohort;

public interface CohortService {

	public SentCohort getSingleCohortByName(String name);
	
	public ArrayList<SentCohort> getAllCohorts();
	
	public String deleteCohort(String name);
	
	public String updateCohort(String name);

}
