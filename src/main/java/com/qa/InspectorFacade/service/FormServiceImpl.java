package com.qa.InspectorFacade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistence.repository.MongoFormRepo;

@Service
public class FormServiceImpl implements FormService{

	@Autowired
	MongoFormRepo repo;
	
	@Override
	public String getDataForPython(String name) {
		return "broken atm";
	}

}
