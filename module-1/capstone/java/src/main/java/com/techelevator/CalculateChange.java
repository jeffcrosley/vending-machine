package com.techelevator;

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
		double change = Math.round(vendingMachine.getBalance() * 100);
		
		int quarterCount = 0;
		int dimeCount = 0;
		int nickelCount = 0;
		
		while (change > 0)
		{
			if (change >= 25)
			{
				change -= 25;
				quarterCount++;
			}
			else if (change >= 10)
			{
				change -= 10;
				dimeCount++;
			}
			else
			{
				change -= 5;
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
