package com.survey.backendTask.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Results {

	
	ArrayList<Survey> allSurvey = new ArrayList<Survey>();
	
	
	public Results() {
		
	}


	public ArrayList<Survey> getAllSurvey() {
		return allSurvey;
	}


	public void setAllSurvey(ArrayList<Survey> allSurvey) {
		this.allSurvey = allSurvey;
	}
	
	
	
	
	
}
