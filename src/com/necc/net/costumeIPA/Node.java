package com.necc.net.costumeIPA;

public class Node<T> {
	
	T data;
	Node no;
	Node yes;	
	public Node(T data){
		this.data = data;
		no = null;
		yes = null;
	}
}
