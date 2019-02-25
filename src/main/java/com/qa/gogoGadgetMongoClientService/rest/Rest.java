package com.qa.gogoGadgetMongoClientService.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.gogoGadgetMongoClientService.persistence.domain.SentCohort;
import com.qa.gogoGadgetMongoClientService.persistence.domain.SentTrainee;
import com.qa.gogoGadgetMongoClientService.persistence.domain.SentTrainer;
import com.qa.gogoGadgetMongoClientService.service.CohortService;
import com.qa.gogoGadgetMongoClientService.service.TraineeService;
import com.qa.gogoGadgetMongoClientService.service.TrainerService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class Rest {
	
	@Autowired
	private TraineeService traineeService;
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private CohortService cohortService;
	
	@GetMapping("${path.getAllTrainees}")
	public ArrayList<SentTrainee> getAllTrainees() {
		return traineeService.getAllTrainees();
	}
	
	@GetMapping("${path.getSingleTraineeByEmail}")
	public SentTrainee getSingleTraineeByEmail(@PathVariable String email) {
		return traineeService.getSingleTraineeByEmail(email);
	}
	
	@GetMapping("${path.getSingleTraineeByID}")
	public SentTrainee getSingleTraineeByID(@PathVariable Long id) {
		return traineeService.getSingleTraineeByID(id);
	}
	
	@GetMapping("${path.getSingleTrainerByEmail}")
	public SentTrainer getSingleTrainerByEmail(@PathVariable String email) {
		return trainerService.getSingleTrainerByEmail(email);
	}
	
	@GetMapping("${path.getAllTrainers}")
	public ArrayList<SentTrainer> getAllTrainers() {
		return trainerService.getAllTrainers();
	}
	
	@GetMapping("${path.getSingleCohortByName}")
	public SentCohort getSingleCohortByName(@PathVariable String name) {
		return cohortService.getSingleCohortByName(name);
	}
	
	@DeleteMapping("${path.deleteTrainee}")
	public void deleteTrainee(@PathVariable String email) {
		traineeService.deleteTrainee(email);
	}
	
	@DeleteMapping("${path.deleteTrainer}")
	public void deleteTrainer(@PathVariable String email) {
		trainerService.deleteTrainer(email);
	}
	
	@DeleteMapping("${path.deleteCohort}")
	public void deleteCohort(@PathVariable String name) {
		cohortService.deleteCohort(name);
	}
	
	@PutMapping("${path.updateTrainee}")
	public String updateTrainee(@PathVariable String email) {
		return traineeService.updateTrainee(email);
	}
	
	@PutMapping("${path.updateTrainer}")
	public String updateTrainer(@PathVariable String email) {
		return trainerService.updateTrainer(email);
	}
	
	@PutMapping("${path.updateCohort}")
	public String updateCohort(@PathVariable String name) {
		return cohortService.updateCohort(name);
	}
	
	@GetMapping("${path.getDataForGraph}")
	public String getDataForGraph(@PathVariable String name) {
		return "broken atm";
	}

}
