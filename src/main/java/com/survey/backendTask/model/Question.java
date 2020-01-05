package com.survey.backendTask.model;

import org.springframework.stereotype.Component;

@Component
public class Question {

String question;
int no;
int yes;
	

public Question(){
	this.no = 0;
	this.yes = 0;
}


public String getQuestion() {
	return question;
}


public void setQuestion(String question) {
	this.question = question;
}


public int getNo() {
	return no;
}


public void setNo(int no) {
	this.no = no;
}


public int getYes() {
	return yes;
}


public void setYes(int yes) {
	this.yes = yes;
}
	
	
}
