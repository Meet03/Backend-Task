package com.survey.backendTask.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.survey.backendTask.model.Question;
import com.survey.backendTask.model.Results;
import com.survey.backendTask.model.Survey;




@Repository(value="SurveyDAO")
public class SurveyDAOImp implements SurveyDAO {

	
	
	@Autowired
	private Results results;
	
	public Survey createSurvey(ArrayList<String> Questions,int surveyIdToBeAdded) throws Exception{
		
		Survey survey = new Survey();
		

		try {
			
		for(String s:Questions) {
			Question question = new Question();
			question.setNo(0);
			question.setYes(0);
			question.setQuestion(s);
			
			survey.getSur().add(question);
		}
		
		survey.setSurveyId(surveyIdToBeAdded);
				
		System.out.println("survey Id of Created Survey is: "+survey.getSurveyId());
		
		results.getAllSurvey().add(survey);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return survey;
	}
	
	public Survey takeASurvey(String surveyId,JSONArray questions,JSONArray answers) throws Exception{
		
		
		
		int sizeOfQuestions = questions.length();
		int sizeOfanswers = answers.length();
		
		if(sizeOfanswers!=sizeOfQuestions) {
			throw new Exception("Size mismatch");
		}
		
		Survey survey = new Survey();
		int surId = Integer.parseInt(surveyId);
		
		
		for(int i=0;i<results.getAllSurvey().size();i++) {
			if(results.getAllSurvey().get(i).getSurveyId()==surId) {
				survey = results.getAllSurvey().get(i);
			}
		}

		
		try {
		
			for(int i=0;i<sizeOfanswers;i++) {
				
				for(Question q : survey.getSur()) {
			
			if(q.getQuestion().equals(questions.getString(i).toString())) {		
					System.out.println("question  found");
					
				if(answers.get(i).toString().equals("no")) {
					System.out.println("its a no");
					q.setNo(q.getNo()+1);
				}
				
				else if(answers.get(i).toString().equals("yes")) {
					System.out.println("its a yes");
					q.setYes(q.getYes()+1);
				}
			}
		}
				
			}
		}
		catch(Exception e){
		System.out.println(e);	
		}
		return survey;
	}
	
	
	public Survey getResultOfSurvey(Integer surveyId) throws Exception {
		Survey survey  = new Survey();
		
		try {
			
			for(Survey s: results.getAllSurvey()) {
				if(s.getSurveyId()==surveyId) {
					survey = s;
				}
			}
			
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		return survey;
		
	}
	
	public List<Survey> getAllSurveys() throws Exception{
		
		List<Survey> surveys = new ArrayList<Survey>();
		
		try {
			surveys = results.getAllSurvey();
			
		}
		
		
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		return surveys;
	}
	
	
}
