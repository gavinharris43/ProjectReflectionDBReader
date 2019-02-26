package com.qa.InspectorFacade.persistence.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.InspectorFacade.persistence.domain.SentTrainee;

@Repository
public interface MongoTraineeRepo extends MongoRepository<SentTrainee, Long> {
	
	public ArrayList<SentTrainee> findAllByEmail(String email);
	
	public SentTrainee findByTraineeId(Long traineeId);

}
