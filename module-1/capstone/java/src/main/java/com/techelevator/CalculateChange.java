package com.techelevator;

import java.math.BigDecimal;

public class CalculateChange 
{	
	// CTOR
	
	//TODO: Make this "ChangeCalculator" or something.  CalculateChange sounds like a method rather than a class.  
	public CalculateChange() {}
	
	// PUBLIC METHODS
	
	//TODO: (Not important/dire -- bells & whistles): Create an interface (that has a getBalance()) that would handle much more than just Vending Machines that VM implements. 
	public static void makeChange(VendingMachine vendingMachine)
	{
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

		String changeOutput = "";
		
		if (quarterCount > 0) {
			changeOutput += quarterCount + " Quarter(s) ";
		}
		
		if (dimeCount > 0) {
			changeOutput += dimeCount + " Dime(s) ";
		}
		
		if (nickelCount > 0) {
			changeOutput += nickelCount + " Nickel(s) ";
		}
		
		//TODO: For tests, we could set return type to "String" and return this.
		//TODO: Put this in Display class?
		System.out.println("----------------------------------------");
		System.out.println("Your change is: " + String.format("$%.2f", vendingMachine.getBalance()));
		System.out.println("Coinage: " + changeOutput);
		System.out.println("----------------------------------------");
	}
}
