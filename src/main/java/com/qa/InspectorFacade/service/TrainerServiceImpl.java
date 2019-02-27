package com.qa.InspectorFacade.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistence.domain.SentTrainee;
import com.qa.InspectorFacade.persistence.domain.SentTrainer;
import com.qa.InspectorFacade.persistence.repository.MongoTrainerRepo;

@Service
public class TrainerServiceImpl implements TrainerService {

	MongoTrainerRepo repo;
	
	@Override
	public SentTrainer getSingleTrainerByEmail(String email) {
		SentTrainer sentTrainer = repo.findByEmail(email);
		
		return sentTrainer;
	}

	@Override
	public ArrayList<SentTrainer> getAllTrainers() {
		return (ArrayList<SentTrainer>) repo.findAll();
	}

	@Override
	public String deleteTrainer(String email) {
		SentTrainer trainerToDelete = repo.findByEmail(email);
		String trainerName = trainerToDelete.getFirstName();
		repo.delete(trainerToDelete);
		
		return trainerName + " deleted.";
	}

	@Override
	public String updateTrainer(String email, SentTrainer newTrainer) {
		SentTrainer trainer = repo.findByEmail(email);
		
		repo.delete(trainer);
		trainer = newTrainer;
		repo.save(newTrainer);
		return "Trainee successfully updated.";
	}

}
