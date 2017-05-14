package com.necc.net.IA;

import com.necc.net.costumeIPA.BinaryCounter;

public class GameIngine {
	
	private Answer answer;
	private Question question;
	private BinaryCounter binarycounter;
	
	public GameIngine(Answer answer, Question question)
	{
		this.answer = answer;
		this.question = question;
		this.binarycounter = new BinaryCounter();
	}
	
	
	public void Star()
	{
		question.getQuestion(1);
	}
	
	public void getAnswer(char input)
	{
		
	}
	
	
	
	
}
