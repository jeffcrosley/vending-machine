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
	
	public void makeChange(double totalAmountEntered, double totalCost)
	{
		double difference = totalAmountEntered - totalCost;
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
}
