package Snake;

import java.lang.reflect.Array;

/**
 * 
 * @author Piet Cordemans
 * @author Klaas Govaerts
 * Singly linked list
 *
 * @param <T> type or the parameter
 */


public class LinkedList<T> {
	private Node head;
	private int size;
	
	/**
	 * Constructor of an empty List
	 */
public LinkedList(){
	head = null;
	size = 0;
}
	
/**
 * Constructor for a linked list with one element
 * 
 * @param element
 */
	public LinkedList(T element){
		head = new Node(element);
		size=1;
	}
	
	private LinkedList(Node node){
		head = node;
		size = count(node,0);
	}
	
	/**
	 * 
	 * @return Array of all the elements
	 * @author Klaas Govaerts
	 */
	public <T> T[] getElements(Class<T[]> classType){
		T[] elements = classType.cast(Array.newInstance(classType.getComponentType(), size));
		Node current=head;
		for(int i=0;i<size;i++){
			elements[i]=(T) current.get();
			current=current.next();
		}
		return elements;
	}

	
	/**
	 * Prepends the element to the linked with one element
	 * 
	 * @param element
	 */
	public void prepend(T element){
		Node newNode = new Node(element, head);
		head = newNode;
		size++;
	}
	
	/**
	 * Appends the element to the linked list
	 * @author Klaas Govaerts
	 * @param element
	 */
	public void append(T element){
		Node newNode = new Node(element, null);
		Node last=lastRecursive(head);
		last.setNext(newNode);
		size++;
	}
	
	/**
	 * 
	 * @return the head of the list
	 */
	public T first(){
		if(head == null) return null;
		return head.get();
	}
	
	/**
	 * 
	 * @return the last element of the list
	 */
	public T last(){
		return lastRecursive(head).get();
	}
	
	private Node lastRecursive(Node current){
		if(current.next() == null) return current;
		return lastRecursive(current.next());
		
	}
	
	/**
	 * 
	 * @return the number of elements in the linked list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * 
	 * @return the Linked list without the head element
	 */
	public LinkedList<T> tail(){
		return new LinkedList<T>(head.next());
	}
	
	/**
	 * 
	 * @return true if empty, false if the linked list contains elements
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * Finds the element in the list
	 * @param element to find
	 * @return true if present in the list otherwise false
	 */
	public boolean find(T element){
		Node cursor = head;
		do
		{
			if(cursor.get().equals(element))
				{
				return true;
				}
		}
		while(cursor.next() != null);
		return false;
	}
	
	private int count(Node current, int total){
		if(current == null) return total;
		return count(current.next(), ++total);
	}
	
	private class Node{
		private T element;
		private Node next;
		
		public Node(T element){
			this(element,null);
			//this.element = element;
			//this.next = null;
		}
	
		public Node(T element, Node next){
			this.element = element;
			this.next = next;
		}
		
		public T get(){
			return element;
			}
		
		public Node next(){
			return next;
		}
		
		public void setNext(Node next){
			this.next=next;
		}
	}
}
