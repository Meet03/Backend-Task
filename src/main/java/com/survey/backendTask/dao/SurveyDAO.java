package com.survey.backendTask.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.survey.backendTask.model.Survey;

public interface SurveyDAO {
public Survey createSurvey(ArrayList<String> Questions,int surveyIdToBeAdded) throws Exception;
public Survey takeASurvey(String surveyId,JSONArray questions,JSONArray answers) throws Exception;
public Survey getResultOfSurvey(Integer surveyId) throws Exception;
public List<Survey> getAllSurveys() throws Exception;

}
