package me.RickyBGamez.main;

import java.util.Scanner;

public class LinkedList {

	private Node first;
	private Node last;
	public int length = 0;
	public int occurrance = 0;
	static Scanner input = new Scanner(System.in);
	
	public LinkedList(){ //Default constructor
		first = null;
		last = null;
		length = 0;
	}
	
	public void push(int data){ //Adding a new node to the list with a number in each node
		Node newNode = new Node(data);
		
		if(first == null){ //If the list is empty, than this node will become the first node
			first = newNode;
		}else{ //If the list already contains a node, than this node will be added to the list and is also attached to node last 
			newNode.setPrev(last);
			last.setNext(newNode);
		}
		last = newNode;
		length++; //Tracking the length of the list
	}
	
	public void pop(){ //Removes the last node from the list
		last = last.getPrev();
		last.setNext(null);
		length--;
	}
	
	public boolean pop(int data){ //Removes a specific item from the list
		Node tempNode = first; //Temp node is created
		Node prevNode = null; //Node for node behind temp
		
		while(tempNode != null){ //If the list contains a node
			if(tempNode.getData() == data){ //This runs if the data matches
				if(tempNode == first){ //If the first node is being removed
					first = first.getNext();
					first.setPrev(null);
				}else{ //If any other node is being removed
					prevNode.setNext(tempNode.getNext());
					Node temp = tempNode.getNext();
					temp.setPrev(prevNode);
				}
				length--;
				return true;
			}else{ //If any other node is being removed
				prevNode = tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return false;
	}
	
	public void display(){
		if(first != null){					//Only if the list has nodes will it be displayed
			Node temp = first;				//Creating a temporary node
			
			System.out.println("Forward:");
			while(temp != null){				//While the temporary node is not empty, the number within it will be displayed	
				int counter = 1;
				
				for(int x = 0; x < length; x++)
				{
					if(x == 0 && first.getData() > 99){
						System.out.print("\n" + temp.getData());
					}else if(x == 0 && first.getData() > 9 && first.getData() < 100){
						System.out.print("\n " + first.getData());
					}else if(x == 0 && first.getData() < 10){
						System.out.print("\n  " + first.getData());
					}else if(temp.getData() > 0 && temp.getData() < 10 && x != 10*counter){
						System.out.print("    " + temp.getData());
					}else if(x == 10*counter){
						if(temp.getData() > 9 && temp.getData() < 100){
							System.out.print("\n " + temp.getData());
						}else if(temp.getData() > 0 && temp.getData() < 10){
							System.out.print("\n  " + temp.getData());
						}else{
							System.out.print("\n" + temp.getData());
						}
						counter++;
					}else if(temp.getData() > 99 && x != 10*counter){
						System.out.print("  " + temp.getData());
					}else{
						System.out.print("   " + temp.getData());
					}
					temp = temp.getNext();		//Moving one node up in the list
				}
			}
			System.out.println();
			
			System.out.println("Reverse:");
			temp = last;					//Making the temporary node equal to the last node in the list
			while(temp != null)				//While the temporary node is not empty, the number within it will be displayed
			{
				int counter = 1;
				
				for(int x = 0; x < length; x++){
					if(x == 0 && last.getData() > 99){
						System.out.print("\n" + temp.getData());
					}else if(x == 0 && last.getData() > 9 && last.getData() < 100){
						System.out.print("\n " + temp.getData());
					}else if(x == 0 && last.getData() < 10){
						System.out.print("\n  " + temp.getData());
					}else if(temp.getData() > 0 && temp.getData() < 10 && x != 10*counter){
						System.out.print("    " + temp.getData());
					}else if(x == 10 * counter){
						if(temp.getData() > 9 && temp.getData() < 100){
							System.out.print("\n " + temp.getData());
						}else if(temp.getData() > 0 && temp.getData() < 10){
							System.out.print("\n  " + temp.getData());
						}else{
							System.out.print("\n" + temp.getData());
						}
						counter++;
					}else if(temp.getData() > 99 && x != 10*counter){
						System.out.print("  " + temp.getData());
					}else{
						System.out.print("   " + temp.getData());
					}
					temp = temp.getPrev();		//Moving one node down in the list
				}
			}
			System.out.println();
		}
		System.out.println("Enter any key to continue");	//A pause statement created for the user to comfortably read the list
		@SuppressWarnings("unused")
		String pause = input.next();
	}
	
	public Node posFind(int pos){ //Finds the node based on its position in the list
		Node temp = first; //Temp node is created
		for(int x = 0; x < pos - 1; x++){ //The loop will run till the position has been achieved
			temp = temp.getNext(); //Moving up a spot in the list
		}
		return temp;
	}
	
	public Node find(int data, boolean occ){ //Finds the node in the list off of its data
		if(first == null){ //If the list is empty
			System.out.println("The list is empty.");
		}else{ //If the list isn't empty
			Node temp = first;
			
			while(temp != null){
				if(temp.getData() == data && occ){ //The linear search algorithm has found a match and the user wants to know the number of occurrences of the number in the list
					System.out.println("Them item is part of the list!");
					occurrance++;
				}else if(temp.getData() == data && !occ){ //The linear search algorithm has found a match
					System.out.println("The item is part of the list!");
					return temp;
				}
				
				temp.getNext(); //Moving up a node in the list
			}
		}
		return null;
	}
	
	public void swap(Node firstNode, Node secondNode){
		if(firstNode.getData() == secondNode.getData()){	//If the two numbers entered are identical, then no swap is performed.
			return;
		}else if(length == 2){					//If the list only contains two nodes, then they are swapped.
			first = secondNode;					//The first node in the list is set to the second node.
			last = firstNode;					//The last node in the list is set to the first node.
			secondNode.setNext(firstNode);			//The node after the second node is set to the first node.	
			secondNode.setPrev(null);		//The node before the second node is null because there is no node.
			firstNode.setNext(null);			//The node after the first node is null because there is no node.
			firstNode.setPrev(secondNode);		//The node before the first node is set to the second node.				
		}else if(secondNode == firstNode.getNext() || secondNode == firstNode.getPrev()){	//If the numbers being swapped are adjacent, then this branch is executed.
			if((secondNode == firstNode.getNext() || secondNode == firstNode.getPrev()) && (firstNode != first && firstNode != last) && (secondNode != first && secondNode != last)){	//If the numbers are adjacent and neither at the beginning nor at the end of the list, then this branch is executed
				if(secondNode == firstNode.getNext()){			//If the second number entered by the user is after the first number in the list, then they are swapped. 
					Node pfirstNode = firstNode.getPrev();	//This node holds the node before the first node.
					Node nsecondNode = secondNode.getNext();		//This node holds the node after the second node.
					
					pfirstNode.setNext(secondNode);				//The node after pfirstNode is set to the second node.
					nsecondNode.setPrev(firstNode);			//The node before nsecondNode is set to the first node.
					
					firstNode.setPrev(secondNode);			//The node before the first node is set to the second node.
					firstNode.setNext(nsecondNode);				//The node after the first node is set to nsecondNode.
					secondNode.setPrev(pfirstNode);			//The node before the second node is set to pfirstNode.
					secondNode.setNext(firstNode);				//The node after the second node is set to the first node.
				}else if(secondNode == firstNode.getPrev()){	//If the first number is before the second number, this branch is executed.
					Node nfirstNode = firstNode.getNext();		//This node holds the node after the first node.
					Node psecondNode = secondNode.getPrev();	//This node holds the node before the second node.
					
					nfirstNode.setPrev(secondNode);			//The node after nfirstNode is set to the second node.
					psecondNode.setNext(firstNode);				//The node before psecondNode is set to the first node.
					
					firstNode.setPrev(psecondNode);			//The node before the first node is set to psecondNode.
					firstNode.setNext(secondNode);				//The node after the first node is set to the second node.
					secondNode.setPrev(firstNode);			//The node before the second node is set to the first node.
					secondNode.setNext(nfirstNode); 				//The node after the second node is set to nfirstNode.
				}
			}else if((secondNode == firstNode.getNext() || secondNode == firstNode.getPrev()) && ((firstNode == first || firstNode == last) || (secondNode == first || secondNode == last))){ //If the numbers are adjacent and at the beginning or at the end, then this branch is executed.
				if(secondNode == firstNode.getNext() && firstNode == first){			//If the second number is after the first number and if the first number is the first node in the list, they are swapped.
					Node nsecondNode = secondNode.getNext();
					
					first = secondNode;
					nsecondNode.setPrev(firstNode);
					
					firstNode.setPrev(secondNode);
					firstNode.setNext(nsecondNode);
					secondNode.setNext(firstNode);
					secondNode.setPrev(null);
				}else if(secondNode == firstNode.getNext() && secondNode == last){		//If the second number is after the first number and if the second number is the last node in the list, they are swapped.
					Node pfirstNode = firstNode.getPrev();
					
					last = firstNode;
					pfirstNode.setNext(secondNode);
					
					firstNode.setPrev(secondNode);
					firstNode.setNext(null);
					secondNode.setNext(firstNode);
					secondNode.setPrev(pfirstNode);
				}else if(secondNode == firstNode.getPrev() && secondNode == first){	//If the second number is before the first number and if the second number is the first node in the list, they are swapped.	
					Node nfirstNode = firstNode.getNext();
					
					first = firstNode;
					nfirstNode.setPrev(secondNode);
					
					firstNode.setPrev(null);
					firstNode.setNext(secondNode);
					secondNode.setNext(nfirstNode);
					secondNode.setPrev(firstNode); 
				}else if(secondNode == firstNode.getPrev() && firstNode == last){	//If the second number is before the first number and if the first number is the first node in the list, they are swapped.
					Node psecondNode = secondNode.getPrev();
					
					last = secondNode;
					psecondNode.setNext(firstNode);
					
					firstNode.setPrev(psecondNode);
					firstNode.setNext(secondNode);
					secondNode.setNext(null);
					secondNode.setPrev(firstNode);
				}
			}
		}else if(firstNode != first && firstNode != last && secondNode != first && secondNode != last){	//If neither numbers are at the beginning or at the end of the list, they are swapped.
			Node pfirstNode = firstNode.getPrev();
			Node nfirstNode = firstNode.getNext();
			Node psecondNode = secondNode.getPrev();
			Node nsecondNode = secondNode.getNext();
			
			pfirstNode.setNext(secondNode);			
			nfirstNode.setPrev(secondNode);
			psecondNode.setNext(firstNode);
			nsecondNode.setPrev(firstNode);
			
			firstNode.setPrev(psecondNode);
			firstNode.setNext(nsecondNode);
			secondNode.setPrev(pfirstNode);
			secondNode.setNext(nfirstNode);
		}else if((firstNode == first || firstNode == last) && secondNode != first && secondNode != last){	//If the first number is at the beginning or at the end but not the second number, this branch is executed.
			Node psecondNode = secondNode.getPrev();
			Node nsecondNode = secondNode.getNext();
			
			if(firstNode == first)				//If the first number is at the beginning, the numbers are swapped.
			{
				Node nfirstNode = firstNode.getNext();
				
				first = secondNode;
				nfirstNode.setPrev(secondNode);
				
				secondNode.setPrev(null);
				secondNode.setNext(nfirstNode);
			}else{							//If the first number is at the end, the numbers are swapped.
				Node pfirstNode = firstNode.getPrev();
				
				last = secondNode;
				pfirstNode.setNext(secondNode);
				
				secondNode.setPrev(pfirstNode);
				secondNode.setNext(null);
			}
			
			psecondNode.setNext(firstNode);
			nsecondNode.setPrev(firstNode);
			firstNode.setPrev(psecondNode);
			firstNode.setNext(nsecondNode);
		}else if(firstNode != first && firstNode != last && (secondNode == first || secondNode == last)){	//If the second number is at the beginning or the end but not the first number, this branch is executed.
			Node pfirstNode = firstNode.getPrev();
			Node nfirstNode = firstNode.getNext();
			
			if(secondNode == first)				//If the second number is at the beginning, the numbers are swapped.
			{
				Node nsecondNode = secondNode.getNext();
				
				first = firstNode;
				nsecondNode.setPrev(firstNode);
				
				firstNode.setPrev(null);
				firstNode.setNext(nsecondNode);
			}
			else							//If the second number is at the end, the numbers are swapped.
			{
				Node psecondNode = secondNode.getPrev();
				
				last = firstNode;
				psecondNode.setNext(firstNode);
				
				firstNode.setPrev(psecondNode);
				firstNode.setNext(null);
			}
			
			pfirstNode.setNext(secondNode);
			nfirstNode.setPrev(secondNode);
			secondNode.setPrev(pfirstNode);
			secondNode.setNext(nfirstNode);
		}else if((firstNode == first || firstNode == last) && (secondNode == first || secondNode == last)){	//If both the numbers are at the beginning or the end, this branch is executd.
			if(firstNode == first && secondNode == last){			//If the first number is at the beginning and the second number is at the end, they are swapped.
				Node nfirstNode = firstNode.getNext();
				Node psecondNode = secondNode.getPrev();
				
				first = secondNode;
				nfirstNode.setPrev(secondNode);
				secondNode.setPrev(null);
				secondNode.setNext(nfirstNode);
				
				last = firstNode;
				psecondNode.setNext(firstNode);
				firstNode.setPrev(psecondNode);
				firstNode.setNext(null);
			}else if(firstNode == last && secondNode == first){	//If the second number is at the beginning and the first number is at the end, they are swapped.
				Node nsecondNode = secondNode.getNext();
				Node pfirstNode = firstNode.getPrev();
				
				first = firstNode;
				nsecondNode.setPrev(firstNode);
				firstNode.setPrev(null);
				firstNode.setNext(nsecondNode);
				
				last = secondNode;
				pfirstNode.setNext(secondNode);
				secondNode.setPrev(pfirstNode);
				secondNode.setNext(null);
			}
		}
	}
	
	//GETTERS AND SETTERS
	public Node getFirst(){
		return first;
	}
	
	public void setFirst(Node first){
		this.first = first;
	}
	
	public Node getLast(){
		return last;
	}
	
	public void setLaste(Node last){
		this.last = last;
	}
}
