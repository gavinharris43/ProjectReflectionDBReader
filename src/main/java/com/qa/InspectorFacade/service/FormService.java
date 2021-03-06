package com.qa.InspectorFacade.service;

import java.util.ArrayList;

import com.qa.InspectorFacade.persistence.domain.SentReflectionForm;

public interface FormService {
	
	ArrayList<SentReflectionForm> getAllFormByEmail(String email);
	
	ArrayList<SentReflectionForm> getAllForms();
	
	String deleteForm(String email);
	
}
