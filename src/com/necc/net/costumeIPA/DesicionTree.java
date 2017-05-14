package com.necc.net.costumeIPA;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.function.Consumer;

import Support.BSTInterface;
import Support.BSTNode;

/**
 * after multiple implementation for performance and dorability the tree will no be serialize, 
 * but read from  two data bases, questions(will get the question base on it binary position) and answer answer will do the same, 
 * but based on its final value on digital base.
 * @author elminino
 *
 int n = 12345;
BitSet bs = BitSet.valueOf(new long[]{n});
long l = bs.toLongArray()[0];
 * @param <T>
 */
public class DesicionTree<T> implements BSTInterface<T> {

	
	
	protected Node<T> root;     
    protected Comparator<T> comp; 
    private BitSet bitTrail; /* tracks the answer */ 

	 
	public  DesicionTree()
	 {
		 root = null;
		 this.bitTrail = new BitSet(20);
		 
		
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
		
		if( root.getInfo() == taget) return root;
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
		       Node<T> node = root;
		       while (node.getNo() != null)
		         node = node.getNo();
		       return node.getInfo();
		    }
	}

	public T max() {
		if (isEmpty())
		       return null;
		    else
		    {
		       Node<T> node = root;
		       while (node.getYes() != null)
		         node = node.getYes();
		       return node.getInfo();
		    }
	}

	public Iterator<T> getIterator(Support.BSTInterface.Traversal orderType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private long getBitSetvalue() {
		return bitTrail.toLongArray()[0];
	}

}
