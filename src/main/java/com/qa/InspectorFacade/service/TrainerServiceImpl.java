package com.qa.InspectorFacade.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
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
		repo.deleteByEmail(email);
		return "deleted";
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
