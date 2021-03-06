package com.qa.InspectorFacade.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistence.domain.SentReflectionForm;
import com.qa.InspectorFacade.persistence.domain.SentTrainee;
import com.qa.InspectorFacade.persistence.repository.MongoFormRepo;

@Service
public class FormServiceImpl implements FormService{

	@Autowired
	MongoFormRepo repo;
	
	@Override
	public ArrayList<SentReflectionForm> getAllFormByEmail(String email) {
		return repo.getAllFormsByEmail(email);
	}
	
	@Override
	public ArrayList<SentReflectionForm> getAllForms() {
		return (ArrayList<SentReflectionForm>) repo.findAll();
	}

	@Override
	public String deleteForm(String email) {
		repo.deleteByEmail(email);
		return "deleted";
	}

}
