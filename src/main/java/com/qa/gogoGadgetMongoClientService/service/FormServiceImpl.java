package com.qa.gogoGadgetMongoClientService.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.gogoGadgetMongoClientService.persistence.repository.MongoFormRepo;

public class FormServiceImpl implements FormService{

	@Autowired
	MongoFormRepo repo;
	
	@Override
	public String getDataForPython(String name) {
		return "broken atm";
	}

}
