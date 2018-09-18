package me.RickyBGamez.main;

public class Node {

	private int data;
	private Node next; //Naming node
	private Node prev;
	
	public Node(){ //Default Constructor
		data = -1;
		next = null;
		prev = null;
	}
	
	public Node(int data){ //Overload Constructor
		this.data = data;
		next = null;
		prev = null;
	}
	
	//Getters and Setters
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	public Node getPrev(){
		return prev;
	}
	
	public void setPrev(Node prev){
		this.prev = prev;
	}
}
