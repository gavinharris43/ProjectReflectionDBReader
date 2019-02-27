package com.qa.InspectorFacade.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.InspectorFacade.persistence.domain.SentCohort;
import com.qa.InspectorFacade.persistence.domain.SentReflectionForm;
import com.qa.InspectorFacade.persistence.domain.SentTrainee;
import com.qa.InspectorFacade.persistence.domain.SentTrainer;
import com.qa.InspectorFacade.service.CohortService;
import com.qa.InspectorFacade.service.FormService;
import com.qa.InspectorFacade.service.TraineeService;
import com.qa.InspectorFacade.service.TrainerService;

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

	@Autowired
	private FormService formService;

	@GetMapping("${path.getAllTrainees}")
	public ArrayList<SentTrainee> getAllTrainees() {
		return traineeService.getAllTrainees();
	}

	@GetMapping("${path.getSingleTraineeByEmail}")
	public SentTrainee getSingleTraineeByEmail(@PathVariable String email) {
		return traineeService.getSingleTraineeByEmail(email);
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
	public String updateTrainee(@PathVariable String email, SentTrainee newTrainee) {
		return traineeService.updateTrainee(email, newTrainee);
	}

	@PutMapping("${path.updateTrainer}")
	public String updateTrainer(@PathVariable String email, SentTrainer newTrainer) {
		return trainerService.updateTrainer(email, newTrainer);
	}

	@PutMapping("${path.updateCohort}")
	public String updateCohort(@PathVariable String name, SentCohort newCohort) {
		return cohortService.updateCohort(name, newCohort);
	}

	@GetMapping("${path.getAllFormsSpecificTraineeByEmail}")
	public ArrayList<SentReflectionForm> getAllFormsSpecificTraineeByEmail(@PathVariable String email) {
		return formService.getAllFormByEmail(email);
	}

	@DeleteMapping("${path.deleteForm}")
	public String deleteForm(@PathVariable String email) {
		return formService.deleteForm(email);
	}
	
	@GetMapping("${path.getAllForms}")
	public ArrayList<SentReflectionForm> getAllForms() {
		return formService.getAllForms();
	}

	@GetMapping("${path.getDataForGraph}")
	public String getDataForGraph(@PathVariable String name) {
		return "broken atm";
	}

}
