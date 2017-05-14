package com.necc.net.costumeIPA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * helps on the determining the current node/rowid to read
 */
public final class BinaryCounter {

	protected long number;
	protected LinkedList<String> desitions ;
	/**
	 * 
	 */
	public BinaryCounter()
	{
		this.number = 1;
		desitions = new LinkedList<String>();
		desitions.add("1");
		
	}
	
	/**
	 * 
	 * @return
	 */
	public long incraseCounter(boolean answer)
	{
		String myList ="";
		this.isTrue(answer);
		for(String a: desitions)
		{
			myList += a;
		}
			
		number = Long.parseLong(  myList , 2);
		
		return number;
	}
	
	private void isTrue(boolean answer)
	{
		if(answer == true)
			 desitions.add(1, "1");
		else
			desitions.add(1, "0");
	}
	
	
	private BinaryCounter(int input)
	{
		this.number = input;
	}
	
	public long getNumber() {
		return number;
	}

	private void setNumber(int number) {
		this.number = number;
	}
}
