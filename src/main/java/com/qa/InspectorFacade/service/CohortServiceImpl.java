package com.qa.InspectorFacade.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistence.domain.SentCohort;
import com.qa.InspectorFacade.persistence.repository.MongoCohortRepo;

@Service
public class CohortServiceImpl implements CohortService {

	@Autowired
	MongoCohortRepo repo;
	
	@Override
	public SentCohort getSingleCohortByName(String name) {
		SentCohort cohort = repo.findByCohortName(name);
		return cohort;
	}

	@Override
	public ArrayList<SentCohort> getAllCohorts() {
		return (ArrayList<SentCohort>) repo.findAll();
	}

	@Override
	public String deleteCohort(String name) {
		SentCohort cohortToDelete = repo.findByCohortName(name);
		String cohortName = cohortToDelete.getCohortName();
		repo.delete(cohortToDelete);
		
		return cohortName + " deleted.";
	}

	@Override
	public String updateCohort(String name, SentCohort newCohort) {
		SentCohort cohort = repo.findByCohortName(name);
		
		repo.delete(cohort);
		cohort = newCohort;
		repo.save(newCohort);
		
		return "Cohort successfully updated.";
	}

}
