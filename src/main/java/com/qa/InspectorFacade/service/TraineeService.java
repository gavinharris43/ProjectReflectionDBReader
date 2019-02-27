package com.qa.InspectorFacade.service;

import java.util.ArrayList;

import com.qa.InspectorFacade.persistence.domain.SentTrainee;

public interface TraineeService {
	
	public SentTrainee getSingleTraineeByEmail(String email);
	
	public ArrayList<SentTrainee> getAllTrainees();
	
	public String deleteTrainee(String email);
	
	public String updateTrainee(String email, SentTrainee newTrainee);

}
