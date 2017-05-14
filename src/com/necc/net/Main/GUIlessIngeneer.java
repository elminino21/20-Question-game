package com.necc.net.Main;

import java.util.Scanner;

import com.necc.net.IA.Answer;
import com.necc.net.IA.GameIngine;
import com.necc.net.IA.Question;

public class GUIlessIngeneer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("20 Question game started");
		Scanner in = new Scanner(System.in);
		GameIngine game = new GameIngine(new Answer(), new Question());
		
		while( game.Star())
		{
			
			if(!game.hasNext())
			{
				System.out.print("This location is empty enter a new question");
				game.newQuestion(in.nextLine());
			}
			
			System.out.println(game.nextQuestion());
			
			game.answer( in.nextLine());
			
		}
		in.close();
		
		System.out.println(game.guess() );
		

	}

}
