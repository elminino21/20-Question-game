package com.necc.net.IA;

import com.necc.net.costumeIPA.BinaryCounter;

public class GameIngine {
	
	private Answer answer;
	private Question question;
	private BinaryCounter counter;
	
	public GameIngine(Answer answer, Question question)
	{
		this.answer = answer;
		this.question = question;
		this.counter = new BinaryCounter();
	}
	
	
	public boolean Star()
	{
		question.getQuestion(1);
		
		
		
		return true;
	}


	public String nextQuestion() {
		
		return null;
	}


	public void answer(String nextLine) {
		// TODO Auto-generated method stub
		
	}


	public boolean hasNext() {
		if( question.getQuestion(counter.getNumber()) == null  )
		{
			return false;
		}
		
		return true;
	}


	public void newQuestion(String nextLine) {
		// TODO Auto-generated method stub
		
	}


	public String guess() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
