package com.qa.gogoGadgetMongoClientService.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class Rest {
	
	public void getAllTrainees() {
		
	}
	
	@GetMapping("${path.getTrainee}")
	public String getSingleTraineeByEmail(String email) {
		return "all good baby";
	}

}
