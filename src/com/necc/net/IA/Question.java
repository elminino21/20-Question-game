package com.necc.net.IA;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.necc.net.IA.database.QuestionSource;

/**
 * adds questionst to the database
 * 
 * 
 * @author elminino
 *
 */


public class Question {
	
	private String Question; 
	private int NumQuestion;
	private int key;
	private ResultSet result;
	private QuestionSource questionAdder;
	/**
	 * @param question
	 * @param numQuestion
	 * @param key
	 */
	public Question() {
		super();
		Question = "";
		this.key = -1;

		this.questionAdder = new QuestionSource();
		result = questionAdder.desisplayQuestions();
		
	}
	
	
	/**
	 * @return the question
	 */
	public String getQuestion(int key) {
		
		
		
		return Question;
	}
	/**
	 * @param question the question to set
	 */
	public void addQuestion(String question, int key, boolean generade) {
		
		int randonlyGenerated = (generade == true) ? 1 : 0;
		
		try {
			questionAdder.addQuestion(key, question, randonlyGenerated);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the numQuestion
	 */
	public int getNumQuestion() {
		return NumQuestion;
	}
	
	
	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

}
