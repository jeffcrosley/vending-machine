package com.techelevator;

import java.math.BigDecimal;

public class CalculateChange 
{
	private double totalMoneyProvided;
	public double getTotalMoneyProvided() { return totalMoneyProvided; }
	public void printTotalMoneyProvided() { System.out.println(String.format("$%.2f", getTotalMoneyProvided())); }
	
	// CTOR
	public CalculateChange() {}
	
	// PUBLIC METHODS
	
	public static void makeChange(VendingMachine vendingMachine)
	{
		// TODO THIS DOESN'T WORK
		BigDecimal change = vendingMachine.getBalance().multiply(new BigDecimal("100"));
		
		int quarterCount = 0;
		int dimeCount = 0;
		int nickelCount = 0;
		
		while (change.compareTo(BigDecimal.ZERO) > 0)
		{
			if (change.compareTo(new BigDecimal("25")) >= 0)
			{
				change = change.subtract(new BigDecimal("25"));
				quarterCount++;
			}
			else if(change.compareTo(new BigDecimal("10")) >= 0)
			{
				change = change.subtract(new BigDecimal("10"));
				dimeCount++;
			}
			else
			{
				change = change.subtract(new BigDecimal("10"));
				nickelCount++;
			}
		}
		// TODO FIX THIS TO GET RID OF COINS THAT DON'T EXIST
		System.out.println("----------------------------------------");
		System.out.println("Your change is: " + String.format("$%.2f", vendingMachine.getBalance()));
		System.out.println(String.format("Coinage: %s Quarter(s), %s Dime(s), %s Nickel(s)", quarterCount, dimeCount, nickelCount));
		System.out.println("----------------------------------------");
	}
}
