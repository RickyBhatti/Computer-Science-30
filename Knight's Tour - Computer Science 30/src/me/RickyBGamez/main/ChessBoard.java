package me.RickyBGamez.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChessBoard {
	
	public static Scanner input = new Scanner(System.in);
	private Node first;
	private int solutions = 0;
	private File outfile;
	private PrintWriter output;
	private int size = 8;
	public int choice = 0;

	public ChessBoard(int size){ //Overload constructor that creates the chess board
		first = new Node(0); //The first square in the chess board and setting its value to zero
		
		Node columnMarker = first;
		Node rowMarker = first;
		Node temp;
		Node temp1;
		
		for(int x = 2; x <= size; x++){ //Instantiating the first row of the chess board and setting their value to zero
			temp1 = new Node(0);
			
			columnMarker.setRight(temp1); //Setting the right node of columnMarker to be temp1
			temp1.setLeft(columnMarker); //Setting the left node of temp1 to be columnMarker
			columnMarker = temp1;
		}
		
		for(int row = 2; row <= size; row++){ //Instantiating rest of the 7 columns of the chess board
			temp = new Node(0); ///Temporary node with its own value as zero
			
			temp.setUp(rowMarker); //Node above temp is set to rowMarker
			rowMarker.setDown(temp); //Node below rowMarker is set to temp
			columnMarker = temp;
			
			for(int x = 0; x < size - 1; x++){
				temp = new Node(0);
				
				columnMarker.setRight(temp); //Node right of columnMarker is set to temp
				temp.setLeft(columnMarker); //Node left of temp is set to columnMarker
				columnMarker.getUp().getRight().setDown(temp);
				temp.setUp(columnMarker.getUp().getRight());
				columnMarker = temp;
			}
			rowMarker = rowMarker.getDown(); //Moving down a row
		}
	}
	
	public Node display(){ //Displays the chess board to the user
		Node temp = first;
		Node rowMarker = first;
		
		while(rowMarker != null){ //Chess board will be output until we do not run out of rows
			temp = rowMarker; //temp node is set to rowMarker
			
			System.out.println("\n\n\n\n\n\n\n");
			while(temp != null){ //While we have nodes in a row
				if(temp.getData() < 10){ //For less than 10 knight moves
					System.out.println("   " + temp.getData());
				}else if(temp.getData() > 9 && temp.getData() < 100){ //For knight moves between 10 & 99
					System.out.println("   " + temp.getData());
				}else{
					System.out.println("   " + temp.getData());
				}
				temp.getRight();
			}
			rowMarker = rowMarker.getDown(); //Moving down a row
		}
		
		return null;
	}
	
	public void tour(int pieces, Node temp) throws FileNotFoundException{ //Method for searching solutions
		temp.setData(pieces); //Number of a square is set to the knight move
		
		if((pieces == 36 & size == 6) || (pieces == 49 && size == 7) || (pieces == 64 & size == 8)){
			display(); //Displays the chess board with the solution
			System.out.println("Solutions: " + solutions++ + "."); //Displays the solution number
			
			if(solutions > 1 && (solutions % 1000000) == 0){ //Every 100,000 solutions, this is executed
				System.out.println("Do you want to save and end the search?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				System.out.print("=> ");
				choice = input.nextInt();
				if(choice == 1){ //If the user chooses to save the solution and end the search
					save();
					return;
				}
			}
			save(); //Solutions found are saved even if the user chooses to continue
		}else if(pieces == 25 && size == 5){ //After finding all the solutions for a 5x5 board the solutions are saved
			System.out.println("Solutions: " + solutions++ + ".");
			save();
		}
		
		//Checks the appropriate path to take for the knight.
		if(temp.getDown() != null && temp.getDown().getDown() != null && temp.getDown().getDown().getRight() != null && temp.getDown().getDown().getRight().getData() == 0){
			tour(pieces + 1, temp.getDown().getDown().getRight());
		}
		if(temp.getDown() != null && temp.getDown().getDown() != null && temp.getDown().getDown().getLeft() != null && temp.getDown().getDown().getLeft().getData() == 0){
			tour(pieces + 1, temp.getDown().getDown().getLeft());
		}
		if(temp.getLeft() != null && temp.getLeft().getLeft() != null && temp.getLeft().getLeft().getDown() != null && temp.getLeft().getLeft().getDown().getData() == 0){
			tour(pieces + 1, temp.getLeft().getLeft().getDown());
		}
		if(temp.getLeft() != null && temp.getLeft().getLeft() != null && temp.getLeft().getLeft().getUp() != null && temp.getLeft().getLeft().getUp().getData() == 0){
			tour(pieces + 1, temp.getLeft().getLeft().getUp());
		}
		if(temp.getUp() != null && temp.getUp().getUp() != null && temp.getUp().getUp().getLeft() != null && temp.getUp().getUp().getLeft().getData() == 0){
			tour(pieces + 1, temp.getUp().getUp().getLeft());
		}
		if(temp.getUp() != null && temp.getUp().getUp() != null && temp.getUp().getUp().getRight() != null && temp.getUp().getUp().getRight().getData() == 0){
			tour(pieces + 1, temp.getUp().getUp().getRight());
		}
		if(temp.getRight() != null && temp.getRight().getRight() != null && temp.getRight().getRight().getUp() != null && temp.getRight().getRight().getUp().getData() == 0){
			tour(pieces + 1, temp.getRight().getRight().getUp());
		}
		if(temp.getRight() != null && temp.getRight().getRight() != null && temp.getRight().getRight().getDown() != null && temp.getRight().getRight().getDown().getData() == 0){
			tour(pieces + 1, temp.getRight().getRight().getDown());
		}
		temp.setData(0);													//After finding no moves for a specific square the number of the tile is set to 0
	}
	
	public void save() throws FileNotFoundException{ //Saving the solution to a text file
		if(size == 5 && solutions == 1){ //If the size of the chess board is 5x5 and the first solution has been found, outfile and output variables are instantiated
			outfile = new File("solution1.txt"); //Name of the text file is solution1.txt
			output = new PrintWriter(outfile);
		}else if(size > 5 && ((solutions - 1) % 500000) == 0){ //If the size of the chess board is greater than 5x5 and the first solution has been found
			outfile = new File("solution" + (int)(2 + (solutions/500000)) + ".txt"); //Name of the text file changes after finding 500,000 solutions (Who wants that many anyways? lel)
			output = new PrintWriter(outfile);
		}
		
		for(int x = 0; x < 3; x++){
			if(x == 0){ 
				output.println("Solution: " + solutions); //Printing the solution number
			}else if(x == 1){
				Node temp = first;
				Node rowMarker = first;
				
				while(rowMarker != null){ //Same as display method in the class, except its going in to the text file
					temp = rowMarker; 
					
					output.println("");
					output.println("");
					while(temp != null){ 
						if(temp.getData() < 10){
							System.out.println("   " + temp.getData());
						}else if(temp.getData() > 9 && temp.getData() < 100){ 
							System.out.println("   " + temp.getData());
						}else{
							System.out.println("   " + temp.getData());
						}
						temp.getRight();
					}
					rowMarker = rowMarker.getDown();
				}
			}else if(x == 2){ //Separate every solution
				output.println("");
				output.println("");
				output.println("-------------------------------------------------------\n\n");
			}
		}
		
		if(size == 5 && solutions == 1728){ //Finding all the slutions for a 5x5 board
			output.close();
		}else if(size > 5 && choice == 1){ //User chooses to end the search
			output.close();
		}
	}
	//GETTERS AND SETTERS
	public Node getFirst(){
		return first;
	}
	
	public void setFirst(Node first){
		this.first = first;
	}
}
