package com.qa.gogoGadgetMongoClientService.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.gogoGadgetMongoClientService.persistence.domain.SentTrainee;
import com.qa.gogoGadgetMongoClientService.persistence.repository.MongoTraineeRepo;

public class TraineeServiceImpl implements TraineeService {
	
	@Autowired
	MongoTraineeRepo repo;

	@Override
	public SentTrainee getSingleTraineeByEmail(String email) {
		ArrayList<SentTrainee> trainees = (ArrayList<SentTrainee>) repo.findAll();
		ArrayList<SentTrainee> trainee = new ArrayList<SentTrainee>();
		trainee = (ArrayList<SentTrainee>) trainees.stream().filter(x -> email.equals(x.getEmail())).collect(Collectors.toList());
		
		return trainee.get(0);
	}
	
	@Override
	public SentTrainee getSingleTraineeByID(Long id) {
		Optional<SentTrainee> optionalClass = repo.findById(id);
		
		return optionalClass.get();
	}
	
	@Override
	public ArrayList<SentTrainee> getAllTrainees() {
		return (ArrayList<SentTrainee>) repo.findAll();
	}

	@Override
	public String deleteTrainee(String email) {
	ArrayList<SentTrainee> trainees = (ArrayList<SentTrainee>) repo.findAll();
	ArrayList<SentTrainee> trainee = new ArrayList<SentTrainee>();
	trainee = (ArrayList<SentTrainee>) trainees.stream().filter(x -> email.equals(x.getEmail())).collect(Collectors.toList());
	
	repo.delete(trainee.get(0));
	
	return "trainee got rekt yo.";
	
	}

	@Override
	public String updateTrainee(String email) {
		ArrayList<SentTrainee> trainees = (ArrayList<SentTrainee>) repo.findAll();
		ArrayList<SentTrainee> theTrainee = new ArrayList<SentTrainee>();
		theTrainee = (ArrayList<SentTrainee>) trainees.stream().filter(x -> email.equals(x.getEmail())).collect(Collectors.toList());
		
		repo.delete(theTrainee.get(0));
		repo.save(theTrainee.get(0));
		return "Trainee successfully deleted.";
	}

}
