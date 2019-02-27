package com.qa.InspectorFacade.persistence.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.InspectorFacade.persistence.domain.SentReflectionForm;

@Repository
public interface MongoFormRepo extends MongoRepository<SentReflectionForm, Long> {
	
	public ArrayList<SentReflectionForm> getAllFormsByEmail(String email);
	
	public SentReflectionForm findByEmail(String email);
	
	public String deleteByEmail(String email);

}
