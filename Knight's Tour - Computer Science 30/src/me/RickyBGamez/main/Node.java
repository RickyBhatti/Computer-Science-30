package me.RickyBGamez.main;

public class Node {

	private int data;
	private Node up;
	private Node down;
	private Node left;
	private Node right;
		
	public Node(int data){ //Overload Constructor
		this.data = data;
		up = null;
		down = null;
		left = null;
		right = null;
	}
		
	//Getters and Setters
	public int getData(){
		return data;
	}
		
	public void setData(int data){
		this.data = data;
	}
		
	public Node getUp(){
		return up;
	}
		
	public void setUp(Node up){
		this.up = up;
	}
		
	public Node getDown() {
		return down;
	}
	public void setDown(Node down) {
		this.down = down;
	}

	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
}
