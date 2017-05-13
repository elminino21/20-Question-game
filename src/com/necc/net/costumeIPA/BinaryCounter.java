package com.necc.net.costumeIPA;
/**
 * 
 */
public class BinaryCounter {

	protected int number;
	
	/**
	 * 
	 */
	public BinaryCounter()
	{
		this.number = 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int incraseCounter()
	{
		int temp =  1 << number;
		
		return temp;
	}
	
	public BinaryCounter(int input)
	{
		this.number = input;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
