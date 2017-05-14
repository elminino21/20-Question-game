package com.necc.net.IA;

import java.sql.ResultSet;

import com.necc.net.IA.database.AnswerSource;

public class Answer {

	private ResultSet result;
	
	
	public Answer()
	{
		AnswerSource question = new AnswerSource();
		result = question.desisplayAll();	
	}
	
	
	
	
}
