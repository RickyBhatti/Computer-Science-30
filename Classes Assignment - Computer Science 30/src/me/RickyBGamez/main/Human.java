package me.RickyBGamez.main;

public class Human {

	//Variables
	private String name;
	private int age;
	private String gender;
	private String number[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	//Human Constructor
	public Human(String name, int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	//Getters and Setters [Name, Age, Gender]
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){ //Age > 30, 30% of the time will increase by 5 years.
		int num = (int)(Math.random() * (11 - 1) + 1);
		if(num <= 3 && age > 30){
			this.age = age + 5;
		}else{
			this.age = age;
		}
	}
	
	public String getGender(){
		return gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	//Method to find the sum of 2 numbers
	public int sum(int num1, int num2){
		return num1 + num2;
	}
	
	//Method to find the sum of two word numbers.
	public int add(String num1, String num2){
		int newNum1 = 0;
		int newNum2 = 0;
		boolean passed = false;
		int counter = 0;
		
		for(int x = 0; x < 10; x++){
			if(num1.equalsIgnoreCase(number[x])){
				newNum1 = x;
				counter++;
			}
			
			if(num2.equalsIgnoreCase(number[x])){
				newNum2 = x;
				counter++;
			}
		}
		
		if(counter == 2){
			passed = true;
		}else if(passed == false){
			return -1;
		}
		
		return newNum1 + newNum2;
	}
	
	//Prints the age of the Human.
	public void showAge(){
		System.out.println(name + " is " + age + " years old. ");
	}
}
