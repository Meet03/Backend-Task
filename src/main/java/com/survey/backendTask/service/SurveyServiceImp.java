package com.survey.backendTask.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.backendTask.dao.SurveyDAO;
import com.survey.backendTask.model.Survey;


@Service(value="SurveyService")
public class SurveyServiceImp  implements SurveyService{
	
	@Autowired
	private SurveyDAO surveyDAO;
	
	public Survey createSurvey(ArrayList<String> Questions,int surveyIdToBeAdded) throws Exception{
		
		Survey survey = new Survey();
		
		try {
			
			survey=surveyDAO.createSurvey(Questions,surveyIdToBeAdded);
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		return survey;
	}
	
	public Survey takeASurvey(String surveyId,JSONArray questions,JSONArray answers) throws Exception{
		Survey survey = new Survey();
		
		try {
			survey = surveyDAO.takeASurvey(surveyId, questions, answers);
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		return survey;
		
	}
	
	
	public Survey getResultOfSurvey(Integer surveyId) throws Exception{
		Survey survey = new Survey();
		
		try {
			survey = surveyDAO.getResultOfSurvey(surveyId);
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		return survey;
	}
	
	public List<Survey> getAllSurveys() throws Exception{
		
		List<Survey> surveys = new ArrayList<Survey>();
		
		
		
		try {
			surveys = surveyDAO.getAllSurveys(); 
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		return surveys;
	}

	
}
