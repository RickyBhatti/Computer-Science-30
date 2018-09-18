package me.RickyBGamez.main;

public class Grid {
	
	private static Node first; //Place holder for the first node in the grid
	private static int firstValue = 0; //Value of the first node is stored in this variable before changing its value to the user value 
	private static int winCounter = 0;	
	
	public Grid(int size, int choice){ //Overload constructor
		int counter = 0; //Variable used to sequentially populate the grid
		
		if(choice == 0){ //If the user chooses to sequentially populate the grid, the first square is populated
			first = new Node(++counter); 
		}else{ //Randomly populating the grid, first square is populated
			first = new Node((int)(Math.random() * 6 + 1));
		}
		
		Node columnMarker = first; //Node to track nodes in a row
		Node rowMarker = first; //Node to track the row we're in
		Node temp;
		Node temp1;
		
		for(int x = 2; x <= size; x++){ //Populating the rest of the row
			if(choice == 0){
				temp1 = new Node(counter++);
			}else{
				temp1 = new Node((int)(Math.random() * 6 + 1));
			}
			
			columnMarker.setRight(temp1); //Node to right of node columnMarker is set to temp1
			temp1.setLeft(columnMarker); //Node to left of temp1 is set to columnMarker
			columnMarker = temp1; //columnMarker is set to temp1, moving one spot to the right
		}
		
		for(int row = 2; row <= size; row++){ //Populating the rest of the grid
			if(choice == 0){
				temp = new Node(counter++);
			}else{
				temp = new Node((int)(Math.random() * 6 + 1));
			}
			temp.setUp(rowMarker); //Node on top of node temp is set to rowMarker
			rowMarker.setDown(temp); //Node below rowMarker is set to temp
			columnMarker = temp; //columnMarker is set to node temp
			
			for(int x = 0; x < size - 1; x++){
				if(choice == 0){
					temp = new Node(counter++);
				}else{
					temp = new Node((int)(Math.random() * 6 + 1));
				}
				
				columnMarker.setRight(temp);
				temp.setLeft(columnMarker);
				columnMarker.getUp().getRight().setDown(temp);
				temp.setUp(columnMarker.getUp().getRight());
				columnMarker = temp;
			}
			rowMarker = rowMarker.getDown(); //Node rowMarker is moved one row down
		}
		firstValue = first.getData(); //Value of the first node in the grid is saved in this variable
	}
	
	public static void display(){ //Displays the grid 
		Node temp = first; //A temp node set to the first node in the grid
		Node rowMarker = first; //Node rowMarker is set to the first node in the grid
		
		while(rowMarker != null){ //While we dont run out of rows
			temp = rowMarker; //Node temp is set to node rowMarker
			while(temp != null){ //While we dont run out of nodes on a specific row
				if(temp.getData() < 10){ //If the number is less than 10
					System.out.print("  " + temp.getData());
				}else{ //If the number output is a 2 digit number
					System.out.print("  " + temp.getData());
				}
				temp = temp.getRight();
			}
			System.out.println("  ");
			rowMarker = rowMarker.getDown(); //Node rowMarker is moved one row down
		}
	}

	public void flood(int choice, Node temp){ //Flooding the grid with the number chosen by user
		temp.setData(choice); //Setting a square of the grid to users number
		
		if(temp.getRight() == null & temp.getDown() == null){ //If we reach the end of the grid, the last square on the grid
			return;
		}
		if(temp.getUp() != null && temp.getUp().getData() == firstValue){ //If the square on top is available and its value is the value being changed
			flood(choice,temp.getUp());
		}
		if(temp.getDown() != null && temp.getDown().getData() == firstValue){ //If the square below is available and its value is the value being changed
			flood(choice,temp.getDown());
		}
		if(temp.getLeft() != null && temp.getLeft().getData() == firstValue){ //If the square to the left is available and its value is the value being changed
			flood(choice,temp.getLeft());
		}
		if(temp.getRight() != null && temp.getRight().getData() == firstValue){ //If the square to the right is available and its value is the value being changed
			flood(choice,temp.getRight());
		}
	}
	
	public boolean complete(int temp){ //Checking if the grid is completely filled with the same number
		boolean complete = false; //If the grid is complete or not
		
		if(first != null){ //If there is a square in the grid
			Node columnMarker = first;
			Node rowMarker = first;
			
			while(rowMarker != null){ //While there are rows remaining in the grid
				while(columnMarker != null){ //While there are squares remaining in a row
					if (columnMarker.getData() != temp){ //If we find two different numbers in the grid, a false result is sent to the program to inform it that the grid is not complete yet
						return complete;
					}
					columnMarker = columnMarker.getRight(); //Node columnMarker is moved one spot right
				}
				rowMarker = rowMarker.getDown(); //Node rowMarker is moved down one row
				columnMarker = rowMarker; //columnMarker is set to rowMarker
			}
		}
		return true; //Returns true if the grid is complete
	}
	
	//Getter and Setters
	public Node getFirst(){
		return first;
	}
	
	public void setFirst(Node first){
		Grid.first = first;
	}
	
	public static int getFirstValue(){
		return firstValue;
	}
	
	public static void setFirstValue(int firstValue){
		Grid.firstValue = firstValue;
	}
	
	public static int getWinCounter(){
		return winCounter;
	}
	
	public static void setWinCounter(int winCounter){
		Grid.winCounter = winCounter;
	}
	
}
