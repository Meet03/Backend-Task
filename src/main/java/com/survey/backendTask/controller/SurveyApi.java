package com.survey.backendTask.controller;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.backendTask.model.Survey;
import com.survey.backendTask.service.SurveyService;


@RestController
@RequestMapping(value = "/surveybackendtask")
public class SurveyApi {


@Autowired
private SurveyService surveyService;	





static int surveyIdToBeAdded = 1;


	
@PostMapping(value = "/createsurvey")	
public ResponseEntity<String> createSurvey(@RequestBody ArrayList<String> Questions) throws Exception  {
	
	String successMessage = "Survey Created Successfully";		
	ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
	
	try {
		
		Survey survey = new Survey();
		survey=surveyService.createSurvey(Questions,surveyIdToBeAdded);
		surveyIdToBeAdded++;
		
		
		
	}
	catch(Exception e) {	
		System.out.println(e);
	}
	return response;	
}

@PostMapping(value = "/takeasurvey")
public ResponseEntity<String> takeASurvey(@RequestBody String body){
	String successMessage = "Your Response stored Successfully";	
	
	ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
	
	JSONObject json = new JSONObject(body);

	String surveyId = json.getString("surveyId");
	JSONArray questions = json.getJSONArray("Questions");
	JSONArray answers = json.getJSONArray("Answers");
	Survey survey = new Survey();
	
	try {
		 survey = surveyService.takeASurvey(surveyId,questions,answers);
		System.out.println("Your Response stored Successfully");
	
		for(int i=0;i<survey.getSur().size();i++) {
		//	System.out.println("HII");
			System.out.println(survey.getSur().get(i).getYes());
		}
		
	}
	catch(Exception e) {
			System.out.println(e);
	}
	return response;
}

@GetMapping(value = "/allsurvey")
public ResponseEntity<List<Survey>> getAllCustomerDetails() throws Exception {
	List<Survey> surveyList = surveyService.getAllSurveys();
	
	
	ResponseEntity<List<Survey>> response = new ResponseEntity<List<Survey>>(surveyList, HttpStatus.OK);
	
	return response;
}


@GetMapping(value = "/allsurvey/{surveyId}")
public ResponseEntity<Survey> getCustomerDetails(@PathVariable Integer surveyId)  throws Exception  {
	
	Survey survey = surveyService.getResultOfSurvey(surveyId);

	ResponseEntity<Survey> response = new ResponseEntity<Survey>(survey, HttpStatus.OK);
	
	return response;
}

 

}
