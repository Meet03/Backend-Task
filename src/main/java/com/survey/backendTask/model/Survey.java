package com.survey.backendTask.model;

import java.util.ArrayList;


import org.springframework.stereotype.Component;


@Component
public class Survey {

	
Integer surveyId;	
ArrayList<Question> sur = new ArrayList<Question>();


public Survey() {

}


public Integer getSurveyId() {
	return surveyId;
}


public void setSurveyId(Integer surveyId) {
	this.surveyId = surveyId;
}


public ArrayList<Question> getSur() {
	return sur;
}


public void setSur(ArrayList<Question> sur) {
	this.sur = sur;
}

}
