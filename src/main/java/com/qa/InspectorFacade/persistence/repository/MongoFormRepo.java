package com.qa.InspectorFacade.persistence.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.InspectorFacade.persistence.domain.SentReflectionForm;

@Repository
public interface MongoFormRepo extends MongoRepository<SentReflectionForm, Long> {
	
	ArrayList<SentReflectionForm> getAllFormsByEmail(String email);
	
	SentReflectionForm findByEmail(String email);

}
