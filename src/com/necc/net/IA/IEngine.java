package com.necc.net.IA;

/** 
 * necesary method to handle logic
 * 
 */
public interface IEngine {

	void newQuestion(String nextLine);
	String guess();
	/**
	 * checks if the current row has a question/row
	 * @return
	 */
	boolean hasNext();
	void answer(String nextLine);
	String nextQuestion();
	boolean Star();
}
