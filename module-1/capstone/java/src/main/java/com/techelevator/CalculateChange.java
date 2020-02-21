package com.techelevator;

import java.util.Scanner;

public class CalculateChange 
{
	private double totalMoneyProvided;
	public double getTotalMoneyProvided() { return totalMoneyProvided; }
	public void printTotalMoneyProvided() { System.out.println(String.format("$%.2f", getTotalMoneyProvided())); }
	
	// CTOR
	public CalculateChange() {}
	
	// PUBLIC METHODS
	public void insertMoney() // pass a Logger object into this (same instance as in our VendingMachine), maybe store as private variable
	{
		int totalMoneyInserted = 0;
		
		try(Scanner scanner = new Scanner(System.in))
		{	
			String yesNoAnswer = "";
			do
			{
				totalMoneyInserted += insertMoneyPrompt(scanner);
				
				do 
				{
					System.out.print("Would you like to insert additional money? (Y/N): ");
					yesNoAnswer = scanner.nextLine();
				}
				while(!yesNoAnswer.equalsIgnoreCase("yes") && !yesNoAnswer.equalsIgnoreCase("no") && !yesNoAnswer.equalsIgnoreCase("y") && !yesNoAnswer.equalsIgnoreCase("n"));
			}
			while (yesNoAnswer.equalsIgnoreCase("y") || yesNoAnswer.equalsIgnoreCase("yes"));		
		}
		System.out.println("Thank you.  Please select your item(s).");
		totalMoneyProvided += totalMoneyInserted;
	}
	
	public int insertMoneyPrompt(Scanner scanner)
	{
		String value;
		int total = 0;	
		
		do
		{
			System.out.print("Please insert money ($1, $2, $5, $10 only): ");
			value = scanner.nextLine();
		}
		while (!value.equals("1") && !value.equals("2") && !value.equals("5") && !value.equals("10"));
		
		total = Integer.parseInt(value);
		
		return total;
	}
	
	public void makeChange(double totalCost)
	{
		double difference = getTotalMoneyProvided() - totalCost;
		double differenceMod = Math.round(difference * 100);
		int quarterCount = 0;
		int dimeCount = 0;
		int nickelCount = 0;
		
		while (differenceMod > 0)
		{
			if (differenceMod >= 25)
			{
				differenceMod -= 25;
				quarterCount++;
			}
			else if (differenceMod >= 10)
			{
				differenceMod -= 10;
				dimeCount++;
			}
			else
			{
				differenceMod -= 5;
				nickelCount++;
			}
		}
		
		System.out.println("Your change is: " + String.format("$%.2f", difference));
		System.out.println(String.format("Coinage: %s Quarter(s), %s Dime(s), %s Nickel(s)", quarterCount, dimeCount, nickelCount));
	}
	
	public static void main(String[] args)
	{
		CalculateChange cc = new CalculateChange();
		cc.insertMoney();
		cc.printTotalMoneyProvided();
		
		cc.makeChange(4.35);
	}
}
