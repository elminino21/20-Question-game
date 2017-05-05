package com.necc.net.IA;
/**
 * class receive question and keeps track of it place on the tree
 * it will pull the answer from the tree when it reachest question number 20. by using the key field.
 * 
 * @author elminino
 */
/**
 * 
 * @author elminino
 *
 */


public class Question {
	
	private String Question; 
	private int NumQuestion;
	private int key;
	private String answer;
	
	/**
	 * @param question
	 * @param numQuestion
	 * @param key
	 */
	public Question(String question, int numQuestion) {
		super();
		Question = question;
		this.key = -1;
		this.setNumQuestion( numQuestion );
		this.statusChecker();
	}
	
	/** 
	 * if answer is not in the tree the an answer will have to be manually enter by the user
	 */
	protected void statusChecker()
	{
		if(key == -1)
		{
			
		}
	}
	
	
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return Question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		Question = question;
	}
	/**
	 * @return the numQuestion
	 */
	public int getNumQuestion() {
		return NumQuestion;
	}
	/**
	 * @param numQuestion the numQuestion to set
	 */
	private void setNumQuestion(int numQuestion) {
		if(numQuestion == 20 && key != -1)
		{
			/*
			 * TODO:  adds insert guess on data base.
			 */
		}
		NumQuestion = numQuestion;
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
