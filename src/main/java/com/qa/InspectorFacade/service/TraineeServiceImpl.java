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
	public SentTrainee getSingleTraineeByID(String id) {
		
		SentTrainee sentTrainee = repo.findByTraineeId(id);
		
		return sentTrainee;
	}
	
	@Override
	public ArrayList<SentTrainee> getAllTrainees() {
		return (ArrayList<SentTrainee>) repo.findAll();
	}

	@Override
	public String deleteTrainee(String email) {
	SentTrainee traineeToDelete = repo.findAllByEmail(email);
	
	String traineeName = traineeToDelete.getFirstName();
	
	repo.delete(traineeToDelete);
	
	return traineeName + " deleted.";
	
	}

	@Override
	public String updateTrainee(String email) {
		SentTrainee trainee = repo.findAllByEmail(email);
		
		repo.delete(trainee);
		repo.save(trainee);
		return "Trainee successfully updated.";
	}

}
