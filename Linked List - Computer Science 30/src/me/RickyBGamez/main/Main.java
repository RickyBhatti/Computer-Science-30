package me.RickyBGamez.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

	/*
	 * Program Name: Linked List
	 * Programmer Name: RickyBGamez
	 * Date: March 31/2016
	 * 
	 * Description: Not Needed
	 * 
	 */
	
	static Scanner input = new Scanner(System.in);
	static LinkedList LL = new LinkedList();
	static int menuTurns = 0;
	public static Random randNum = new Random();
	
	public static void populate(){
		System.out.println("How long do you want the list to be? ");
		System.out.print("=> ");
		int length = input.nextInt();
		int choice = 0;
		
		if(length > 1){
			System.out.println("How do you want to populate it?");
			System.out.println("1. Sequentially from 1 to " + length + ".");
			System.out.println("2. Randomly from 1 to " + length + ".");
			choice = input.nextInt();
		}
		
		for(int x = 0; x < length; x++){
			if(choice == 1){
				LL.push(x + 1);
			}else{
				LL.push((int)(Math.random() * ((length - 1) + 1) + 1));
			}
		}
	}
	
	public static void quickSort(int left, int right){
		if(right - left < 1){ //Checks if the arrest is smaller than 2
			return;
		}
		
		//Creating the left and right scroller, also the pivot.
		int LS = left;
		int RS = right;
		int pivot = LS;
		
		while(LS != RS ){
			while(LL.posFind(LS).getData() <= LL.posFind(pivot).getData() && LS < pivot){ //If the number on the left of the pivot is smaller and the left scroller is less than the pivot, than we move the left scroller up one spot
				LS++;	
			}
			
			while(LL.posFind(RS).getData() >= LL.posFind(pivot).getData() && RS > pivot){ //If the number on the right of the pivot is larger and the right scroller is greater than the pivot, than we move the right scroller down one spot
				RS--;
			}
			
			//If the left number is greater than the right numer we will switch them around.
			LL.swap(LL.posFind(LS), LL.posFind(RS));
			
			//Pivot swap
			if(LS == pivot){
				pivot = RS;
			}else if(RS == pivot){
				pivot = LS;
			}
		}
		
		quickSort(left, pivot - 1); //Sorts the left side of the pivot
		quickSort(pivot + 1, right); //Sorts the right side of the pivot
	}
	
	public static void main(String args[]){
		boolean exit = false;
		System.out.println("Welcome!");
		do{
			System.out.println("1. Populate the List");
			System.out.println("2. Display the List");
			System.out.println("3. Shuffle the Nodes in the List");
			System.out.println("4. Add Data to the List");
			System.out.println("5. Remove the Last Item from the List");
			System.out.println("6. Remove an Item from the List");
			System.out.println("7. Find and Item in the List");
			System.out.println("8. Swap Items in the List");
			System.out.println("9. Bubble Sort the List");
			System.out.println("10. Insertion Sort the List");
			System.out.println("11. Selection Sort the List");
			System.out.println("12. Radix Sort the List");
			System.out.println("13. Quick Sort the List");
			System.out.println("0. Exit");
			System.out.print("=> ");
			int choice = input.nextInt();
			
			if(choice == 0){ //Wants to quit
				exit = true;
				System.out.println("See you next time!");
			}else if(choice == 1){ //Wants to populate the list
				populate();
			}else if(choice == 2){ //Wants to display the list
				LL.display();
			}else if(choice == 3){ //Shuffle the nodes in the list
				for(int x = 1; x <= LL.length; x++){ //Loop that will shuffle the numbers in the array
					int randomPosition= randNum.nextInt(LL.length);
					LL.swap(LL.posFind(x), LL.posFind(randomPosition));
				}
			}else if(choice == 4){ //If the user chooses to add a node to the list
				System.out.println("Enter the number you would like to add. ");
				System.out.print("=> ");
				int num = input.nextInt();
				LL.push(num);
			}else if(choice == 5){ //If the user chooses to remove the last node from the list
				System.out.println("The last item was " + LL.posFind(LL.occurrance).getData() + " and it has ben removed. ");
				LL.pop();
			}else if(choice == 6){ //User chooses to remove a specific node from the list
				System.out.println("Which item would you like removed?");
				System.out.print("=> ");
				int item = input.nextInt();
				boolean lastPop = false; //Check if the number is at the end of the list
				LL.find(item, true); //Finds the number of occurrences of a number in the list
				
				if(LL.posFind(LL.occurrance).getData() == item){
					LL.pop();
					lastPop = true; //Number was at the end of the list and it has been removed
					LL.occurrance--; //Number's number of occurrence will be reduced by one
				}
				if(LL.occurrance >= 0){
					boolean deleted = LL.pop(item);
					
					if(deleted){ //If the number is removed from the list, the statement is displayed to the user
						System.out.println("The item has been removed from the list.");
					}else if(!lastPop){ //If the number being removed is not in the list, the statement is displayed to the user
						System.out.println("The item was not found in the list.");
					}
				}
			}else if(choice == 7){ //User wants to find an item in the list
				System.out.println("Which item would you like to find?");
				System.out.print("=> ");
				int item = input.nextInt();
				Node temp = LL.find(item, false); //Searches for the item without recording its occurrences
				
				if(temp == null){ //Search method does not find the number
					System.out.println("The item is not part of the list!");
				}
			}else if(choice == 8){ //User chooses to swap two numbers in the list
				int fItem = 0;
				int sItem = 0;
				
				if(LL.occurrance > 2){ //If there are more than two numbers in the list, than we execute this
					do{ //Checks if the first number is in the list
						System.out.println("Enter the first item of the swap");
						System.out.print("=> ");
						fItem = input.nextInt();
						LL.find(fItem, true);
					}while(LL.occurrance <= 0);
					LL.occurrance = 0; //Sets the occurences variable to zero for future use
					
					do{ //Check if the second number is in the list
						System.out.println("Enter the second item of the swap");
						System.out.print("=> ");
						sItem = input.nextInt();
						LL.find(sItem, true);
					}while(LL.occurrance <= 0);
					LL.occurrance = 0;
					
					LL.swap(LL.find(fItem, false), LL.find(sItem, false)); //Calls swap method
				}else if(LL.occurrance == 2){ //If list only contains two numbers, we swap them
					LL.swap(LL.getFirst(), LL.getLast());
				}
			}else if(choice == 9){ //Bubble sort the list
				for(int x = 1; x < LL.occurrance; x++){ //X marker
					for(int y = x + 1; y <= LL.occurrance; y++){ //Y marker
						if(LL.posFind(y).getData() < LL.posFind(x).getData()){ //Succesor number in the list is smaller than the predecessor number and they're swapped
							LL.swap(LL.posFind(y), LL.posFind(x));
						}
					}
				}
			}else if(choice == 10){ //Insertion sort the list
				for(int x = 1; x <= LL.occurrance; x++){
					int key = LL.posFind(x).getData(); //Key to compare number
					int marker = x - 1; //Marker that will compare numbers below the key in the array
					
					while(marker >= 0 && LL.posFind(marker).getData() > key){ //Number below is the key is larger than the key, the numbers are swapped
						LL.swap(LL.posFind(marker + 1), LL.posFind(marker));
						marker--;
					}
					
					LL.posFind(marker + 1).setData(key); //Index with the larger number becomes the smaller number
				}
			}else if(choice == 11){ //Selection sort the list
				for(int x = 1; x < LL.occurrance; x++){
					int minIndex = x; //Arbitrarily choose the first index to be the smallest number
					
					for(int y = x + 1; y <= LL.occurrance; y++){
						if(LL.posFind(y).getData() < LL.posFind(minIndex).getData()){
							minIndex = y;
						}
					}
					LL.swap(LL.posFind(minIndex), LL.posFind(x));
				}
			}else if(choice == 12){ //Radix sort the list
				for(int x = 3; x >= 1; x--){
					boolean sort = true;
					do{ //Swap the numbers until the array is sorted
						sort = true;
						for(int y = 1; y < LL.occurrance; y++){
							if((int)(LL.posFind(y + 1).getData()/Math.pow(10, 3 - x)) % 10 < (int)(LL.posFind(y).getData()/Math.pow(10, 3 - x)) % 10){
								LL.swap(LL.posFind(y), LL.posFind(y + 1));
								sort = false;
							}
						}
					}while(!sort);
				}
			}else if(choice == 13){ //Quick sort the list
				quickSort(0, LL.length); //Method
			}
		}while(!exit);
	}
}
