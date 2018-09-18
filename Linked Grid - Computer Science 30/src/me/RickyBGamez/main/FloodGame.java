package me.RickyBGamez.main;

import java.util.Scanner;

public class FloodGame {

	/*
	 * Program Name: Flood Game
	 * Programmer Name: RickyBGamez
	 * Date: May 21/2016
	 * 
	 * Description: Not Needed
	 * 
	 */
	
	public static Scanner input = new Scanner(System.in); //Scanner
	public static Grid FloodGame = new Grid(6,1); // Making the grid
	public static int turns = 1; //Number of turns played by the user
	
	public static void play(){ //Starts the game
		System.out.println("Flood Game");
		System.out.println("----------");
		//System.out.print("Start Here -->");
		Grid.display(); //Displays the grid
		System.out.println("Turns: (" + turns + "/12)");
		System.out.println("Enter a number from 1 to 6");
		System.out.print("=> ");
		int choice = input.nextInt();
		
		if(FloodGame.getFirstValue() != choice){ //If the number input is different from the number already on the grid
			FloodGame.flood(choice, FloodGame.getFirst());
		}
		turns++; //Increases the number of player turns
		FloodGame.setFirstValue(FloodGame.getFirst().getData());
		if(!FloodGame.complete(FloodGame.getFirst().getData()) && turns < 13){ //If the grid is not complete and player turn is less than 13
			play(); //Calling the method play
		}
	}
	
	public static void main(String[] args){
		int menuChoice = 0; //Menu choice
		
		do{
			if(menuChoice == 0){
				System.out.println("FLOOD GAME");
				System.out.println("1. Start the Game");
				System.out.println("2. Exit the Game");
				System.out.print("=> ");
			}else{
				System.out.println("FLOOD GAME");
				System.out.println("1. Replay the Game");
				System.out.println("2. Exit the Game");
				System.out.print("=> ");
			}
			menuChoice = input.nextInt();
			
			if(menuChoice == 1){ //User wants to replay
				play();
			}else if(menuChoice == 2){
				System.out.println("[FLOOD] Come back soon!"); //User wants to leave
			}
			turns = 0; //Sets trys to 0 for new game
		}while(menuChoice != 2);
	}
	
}
