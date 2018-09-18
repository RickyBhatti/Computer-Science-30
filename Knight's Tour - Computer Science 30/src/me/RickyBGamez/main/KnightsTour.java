package me.RickyBGamez.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnightsTour {

	/*
	 * Program Name: Knight's Tour
	 * Programmer Name: RickyBGamez
	 * Date: May 25/2016
	 * 
	 * Description: Not Needed
	 * 
	 */
	
	public static Scanner input = new Scanner(System.in);
	public static ChessBoard CB = new ChessBoard(8); //Creating a 8x8 chess board
	public static Node rowMarker = CB.getFirst(); //Instantiating a node
	
	public static void begin(Node temp) throws FileNotFoundException{ //Method for searching solutions
		CB.tour(1,temp); //Starting the search for solutions
		
		if(temp.getRight() != null && rowMarker != null && CB.choice != 1){ //While in a row, the node on the right is not null and we are not on the 64 square and the user does not want to end the search
			begin(temp.getRight()); //Calling the method again with the node on the right
		}else if(temp.getRight() == null && rowMarker.getDown() != null && CB.choice != 1){ //If we have reached the end of the row but not the last row and the user wants to continue searching
			rowMarker = rowMarker.getDown();
			begin(rowMarker);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		int menuChoice = 0; //Variable for menu choice
		System.out.println("Knight's Tour");
		System.out.println("1. Start Finding Solutions");
		System.out.println("2. Exit Program");
		System.out.print("=> ");
		menuChoice = input.nextInt();
		
		if(menuChoice == 1){ //Starting the search
			begin(CB.getFirst());
		}
		if(menuChoice == 2 || CB.choice == 1){ //Ending the program
			System.out.println("Come back soon.");
		}
	}
	
}
