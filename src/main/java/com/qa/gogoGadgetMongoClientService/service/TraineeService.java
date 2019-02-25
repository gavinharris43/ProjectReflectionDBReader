package com.qa.gogoGadgetMongoClientService.service;

import java.util.ArrayList;

import com.qa.gogoGadgetMongoClientService.persistence.domain.SentTrainee;

public interface TraineeService {
	
	public SentTrainee getSingleTraineeByEmail(String email);
	
	public SentTrainee getSingleTraineeByID(Long id);
	
	public ArrayList<SentTrainee> getAllTrainees();
	
	public String deleteTrainee(String email);
	
	public String updateTrainee(String email);

}
