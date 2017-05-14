package com.necc.net.IA;

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
	private QuestionSource sql;
	
	/**
	 * @param question
	 * @param numQuestion
	 * @param key
	 */
	public Question() {
		super();
		Question = "";
		this.key = -1;
		this.sql = new QuestionSource();
		
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
	public void addQuestion(String question, int key) {
		
		
	
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
