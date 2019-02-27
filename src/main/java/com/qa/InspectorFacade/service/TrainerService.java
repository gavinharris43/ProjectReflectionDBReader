package com.qa.InspectorFacade.service;

import java.util.ArrayList;

import com.qa.InspectorFacade.persistence.domain.SentTrainer;

public interface TrainerService {
	
	public SentTrainer getSingleTrainerByEmail(String email);
	
	public ArrayList<SentTrainer> getAllTrainers();
	
	public String deleteTrainer(String email);
	
	public String updateTrainer(String email, SentTrainer newTrainer);

}
