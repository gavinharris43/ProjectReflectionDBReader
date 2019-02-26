package com.qa.InspectorFacade.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

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
		ArrayList<SentTrainee> trainee = repo.findAllByEmail(email);
		
		return trainee.get(0);
	}
	
	@Override
	public SentTrainee getSingleTraineeByID(Long id) {
		SentTrainee sentTrainee = repo.findByTraineeId(id);
		
		return sentTrainee;
	}
	
	@Override
	public ArrayList<SentTrainee> getAllTrainees() {
		return (ArrayList<SentTrainee>) repo.findAll();
	}

	@Override
	public String deleteTrainee(String email) {
	ArrayList<SentTrainee> traineeToDelete = repo.findAllByEmail(email);
	
	String traineeName = traineeToDelete.get(0).getFirstName();
	
	repo.delete(traineeToDelete.get(0));
	
	return traineeName + " deleted.";
	
	}

	@Override
	public String updateTrainee(String email) {
		ArrayList<SentTrainee> trainee = repo.findAllByEmail(email);
		
		repo.delete(trainee.get(0));
		repo.save(trainee.get(0));
		return "Trainee successfully updated.";
	}

}
