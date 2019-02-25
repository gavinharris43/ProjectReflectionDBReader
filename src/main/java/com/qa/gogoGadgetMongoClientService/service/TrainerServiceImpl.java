package com.qa.gogoGadgetMongoClientService.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.gogoGadgetMongoClientService.persistence.domain.SentTrainer;
import com.qa.gogoGadgetMongoClientService.persistence.repository.MongoTrainerRepo;

@Service
public class TrainerServiceImpl implements TrainerService {

	MongoTrainerRepo repo;
	
	@Override
	public SentTrainer getSingleTrainerByEmail(String email) {
		ArrayList<SentTrainer> trainers = (ArrayList<SentTrainer>) repo.findAll();
		ArrayList<SentTrainer> trainer = new ArrayList<SentTrainer>();
		trainer = (ArrayList<SentTrainer>) trainers.stream().filter(x -> email.equals(x.getEmail())).collect(Collectors.toList());
		
		return trainer.get(0);
	}

	@Override
	public ArrayList<SentTrainer> getAllTrainers() {
		return (ArrayList<SentTrainer>) repo.findAll();
	}

	@Override
	public String deleteTrainer(String email) {
		ArrayList<SentTrainer> trainers = (ArrayList<SentTrainer>) repo.findAll();
		ArrayList<SentTrainer> trainer = new ArrayList<SentTrainer>();
		trainer = (ArrayList<SentTrainer>) trainers.stream().filter(x -> email.equals(x.getEmail())).collect(Collectors.toList());
		
		repo.delete(trainer.get(0));
		
		return "trainer got rekt yo.";
	}

	@Override
	public String updateTrainer(String email) {
		ArrayList<SentTrainer> trainers = (ArrayList<SentTrainer>) repo.findAll();
		ArrayList<SentTrainer> theTrainer = new ArrayList<SentTrainer>();
		theTrainer = (ArrayList<SentTrainer>) trainers.stream().filter(x -> email.equals(x.getEmail())).collect(Collectors.toList());
		
		repo.delete(theTrainer.get(0));
		repo.save(theTrainer.get(0));
		return "Trainer successfully deleted.";
	}

}
