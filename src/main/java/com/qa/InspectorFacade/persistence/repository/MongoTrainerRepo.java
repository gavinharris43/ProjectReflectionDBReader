package com.qa.InspectorFacade.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.InspectorFacade.persistence.domain.SentTrainee;
import com.qa.InspectorFacade.persistence.domain.SentTrainer;

@Repository
public interface MongoTrainerRepo extends MongoRepository<SentTrainer, Long>{
	
	public SentTrainer findAllByEmail(String email);
	
	public SentTrainer findByEmail(String email);
	
	public String deleteByEmail(String email);

}

