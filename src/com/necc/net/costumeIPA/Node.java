package com.necc.net.costumeIPA;



public class Node<T> {
	
	private T data;                // The node info
	  private Node<T> no;       // A link to the left child node
	  private Node<T> yes;      // A link to the right child node

	  public Node(T info)
	  {
	    this.data = info; no = null;  yes = null;
	  }
	 
	  public void setInfo(T info){this.data = info;}
	  public T getInfo(){return data;}
	  
	  public void setLeft(Node<T> link){no = link;}
	  public void setRight(Node<T> link){yes = link;}
	  
	  public Node<T> getNo(){return no;}
	  public Node<T> getYes(){return yes;}
}
