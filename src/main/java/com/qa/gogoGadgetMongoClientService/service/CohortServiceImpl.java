package com.qa.gogoGadgetMongoClientService.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.gogoGadgetMongoClientService.persistence.domain.SentCohort;
import com.qa.gogoGadgetMongoClientService.persistence.repository.MongoCohortRepo;

@Service
public class CohortServiceImpl implements CohortService {

	@Autowired
	MongoCohortRepo repo;
	
	@Override
	public SentCohort getSingleCohortByName(String name) {
		ArrayList<SentCohort> Cohorts = (ArrayList<SentCohort>) repo.findAll();
		ArrayList<SentCohort> cohort = new ArrayList<SentCohort>();
		cohort = (ArrayList<SentCohort>) cohort.stream().filter(x -> name.equals(x.getCohortName())).collect(Collectors.toList());
		
		return cohort.get(0);
	}

	@Override
	public ArrayList<SentCohort> getAllCohorts() {
		return (ArrayList<SentCohort>) repo.findAll();
	}

	@Override
	public String deleteCohort(String name) {
		ArrayList<SentCohort> cohorts = (ArrayList<SentCohort>) repo.findAll();
		ArrayList<SentCohort> cohort = new ArrayList<SentCohort>();
		cohort = (ArrayList<SentCohort>) cohorts.stream().filter(x -> name.equals(x.getCohortName())).collect(Collectors.toList());
		
		repo.delete(cohort.get(0));
		
		return "cohort got rekt yo.";
	}

	@Override
	public String updateCohort(String name) {
		ArrayList<SentCohort> cohorts = (ArrayList<SentCohort>) repo.findAll();
		ArrayList<SentCohort> cohort = new ArrayList<SentCohort>();
		cohort = (ArrayList<SentCohort>) cohorts.stream().filter(x -> name.equals(x.getCohortName())).collect(Collectors.toList());
		
		repo.delete(cohort.get(0));
		repo.save(cohort.get(0));
		
		return "Cohort successfully deleted.";
	}

}
