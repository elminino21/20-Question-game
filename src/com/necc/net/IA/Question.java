package com.necc.net.IA;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.necc.net.IA.database.QuestionSource;

/**
 * adds questions to the database
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
	private QuestionSource questionTable;
	/**
	 * @param question
	 * @param numQuestion
	 * @param key
	 */
	public Question() {
		super();
		Question = "";
		this.key = -1;

		this.questionTable = new QuestionSource();
		result = questionTable.desisplayAll();
		
	}
	
	
	/**
	 * @return the specified question
	 */
	public String getQuestion(long key) {
		
		ResultSet temp = questionTable.getRow(key);
		String myQuestion = "";
		
		try {
			myQuestion = temp.getString("QUESTION");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NumQuestion++;
		return myQuestion;
	}
	/**
	 * @param question the question to set
	 */
	public void addQuestion(String question, int key, boolean generade) {
		
		int randonlyGenerated = (generade == true) ? 1 : 0;
		
		try {
			questionTable.addQuestion(key, question, randonlyGenerated);
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
