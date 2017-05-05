package com.necc.net.costumeIPA;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.function.Consumer;

import Support.BSTInterface;
import Support.BSTNode;


public class DesicionTree<T> implements BSTInterface<T> {

	
	
	protected BSTNode<T> root;     
    protected Comparator<T> comp;   

	 
	public  DesicionTree()
	 {
		 root = null;
		 
		 comp = new Comparator<T>()
				    {
				       public int compare(T element1, T element2)
				       {
				         return ((Comparable)element1).compareTo(element2);
				       }
				    };
	 }
	
	public boolean add(T element) {
		
		return false;
	}

	public T get(T target) {
		
		return null;
	}

	public boolean contains(T target) {
		
		return false;
	}
	
	private Node nodeSearch(Node root, T taget)
	{
		if(root == null)return null;
		
		if( root.data == taget) return root;
	//	else if(root.data <= taget)
		
		return null;
	}

	public boolean remove(T target) {
		
		return false;
	}

	public boolean isFull() {
		
		return false;
	}

	public boolean isEmpty() {
		
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void forEach(Consumer<? super T> arg0) {
		// TODO Auto-generated method stub
		
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Spliterator<T> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public T min() {
		 if (isEmpty())
		       return null;
		    else
		    {
		       BSTNode<T> node = root;
		       while (node.getLeft() != null)
		         node = node.getLeft();
		       return node.getInfo();
		    }
	}

	public T max() {
		if (isEmpty())
		       return null;
		    else
		    {
		       BSTNode<T> node = root;
		       while (node.getRight() != null)
		         node = node.getRight();
		       return node.getInfo();
		    }
	}

	public Iterator<T> getIterator(Support.BSTInterface.Traversal orderType) {
		// TODO Auto-generated method stub
		return null;
	}

}
