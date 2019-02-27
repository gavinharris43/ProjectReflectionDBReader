package com.qa.InspectorFacade.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistence.domain.SentTrainee;
import com.qa.InspectorFacade.persistence.repository.MongoTraineeRepo;

@Service
public class TraineeServiceImpl implements TraineeService {
	
	@Autowired
	MongoTraineeRepo repo;

	@Override
	public SentTrainee getSingleTraineeByEmail(String email) {
		SentTrainee dude = repo.findByEmail(email);
		return dude;
	}
	
	@Override
	public ArrayList<SentTrainee> getAllTrainees() {
		return (ArrayList<SentTrainee>) repo.findAll();
	}

	@Override
	public String deleteTrainee(String email) {
	repo.deleteByEmail(email);
	return "deleted.";
	
	}

	@Override
	public String updateTrainee(String email, SentTrainee newTrainee) {
		SentTrainee trainee = repo.findByEmail(email);
		
		repo.delete(trainee);
		trainee = newTrainee;
		repo.save(newTrainee);
		return "Trainee successfully updated.";
	}

}
