package me.RickyBGamez.main;

import java.util.Scanner;

public class Main {
	
	/*
	 * Program Name: Classes Assignment | Human
	 * Programmer Name: RickyBGamez
	 * Date: March 28/2016
	 * 
	 * Description: Not Needed
	 * 
	 */

	static Scanner input = new Scanner(System.in);
	
	//Method that delays the program for a set time interval
	public static void delay(int delay){
		try{
			Thread.sleep(delay);
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}
	
	//Method that outputs the name of the Human
	public static void checkName(Human x){
		System.out.println("The name of this Human is: " + x.getName());
	}
	
	//Method that increases the Humans age
	public static void birthday(Human x){
		x.setAge(x.getAge() + 1);
	}
	
	public static void main(String[] args){
		System.out.println("What is your name?"); //Asking for the users name
		System.out.print("=>  ");
		String userName = input.nextLine();
		
		System.out.println("What is your age, " + userName + "?"); //Asking for the users age
		System.out.print("=>  ");
		int userAge = input.nextInt();
		
		System.out.println("What is your gender, " + userName + "?"); //Asking for the users gender
		System.out.print("=>  ");
		String userGender = input.nextLine();
		
		Human robot = new Human(userName, userAge, userGender); //Creates the Human
		
		robot.getAge(); //Getting the age
		robot.setAge(userAge); //Setting the Humans age to the age enterred by the user
		System.out.println("Your age is stored as: " + robot.getAge() + " years. ");
		delay(3000);
		
		//Asking two numbers from the user and than returning the sum of the two numbers
		System.out.println("Enter a number: ");
		System.out.print("=>  ");
		int inputNum1 = input.nextInt();
		
		System.out.println("Enter the second number: ");
		System.out.print("=>  ");
		int inputNum2 = input.nextInt();
		
		int sum = robot.sum(inputNum1, inputNum2);
		System.out.println("The sum of the two number is: " + sum);
		delay(3000);
		
		//Asking for two word numbers from the user and than returning the sum of the two word numbers
		System.out.println("Enter a number in words: ");
		System.out.print("=>  ");
		String inputNumW1 = input.nextLine();
		
		System.out.println("Enter the second number in words: ");
		System.out.print("=>  ");
		String inputNumW2 = input.nextLine();
		
		int wSum = robot.add(inputNumW1, inputNumW2);
		if(wSum == -1){
			System.out.println("[ERROR] Something went wrong.");
		}else{
			System.out.println("The sum of the two word numbers is: " + wSum);
		}
		delay(3000);
		
		robot.showAge();
		
		//Creating more Humans :/ [I don't like Humans :c]
		Human shivam = new Human("Shivam", 17, "Male");
		Human ali = new Human("Ali", 17, "Male");
		
		//Print those ^^^ Humans ages
		shivam.showAge();
		delay(3000);
		ali.showAge();
		delay(3000);
		
		checkName(robot);
		birthday(robot);
	}
}
