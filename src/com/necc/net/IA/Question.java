package com.necc.net.IA;
/**
 * class receive question and keeps track of it place on the tree
 * it will pull the answer from the tree when it reachest question number 20. by using the key field.
 * 
 * @author elminino
 */
public class Question {
	
	private String Question; 
	private int NumQuestion;
	private int key;
	
	/**
	 * @param question
	 * @param numQuestion
	 * @param key
	 */
	public Question(String question, int numQuestion) {
		super();
		Question = question;
		this.setNumQuestion( numQuestion );
		
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
		if(numQuestion == 20)
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
