package com.techelevator;

import java.util.Map;
import java.util.Map.Entry;

public class Display {

	// CTOR
	public Display() {
		
	}

	// PUBLIC METHODS
	public static void displayMainMenu() {
		
		System.out.println("Please make a selection:");
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
	}
	
	public static void displayInventory(VendingMachine vm) 
	{
		
		System.out.println("Item #\t\tProduct\t\tPrice");
		System.out.println("------------------------------------------------------");
		
		for (Entry<String, StockedItem> entry : vm.getInventory().entrySet())
		{
			System.out.println(entry.getKey() + "\t\t" + entry.getValue().getItem().getName() + "\t\t" + entry.getValue().getItem().getPrice());
		}	
		
	}
	
	public static void displayPurchaseMenu(CalculateChange calculateChange) {
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction\n");
		// TODO CREATE STATIC METHOD FOR THIS IN CalculateChange
		System.out.println("Current Money Provided: " + calculateChange.getTotalMoneyProvided());
	}
	
	public static void displayMoneyPrompt()
	{
		System.out.print("Please insert money ($1, $2, $5, $10 only): ");
	}
	public static void displayAdditionalMoneyPrompt()
	{
		System.out.print("Would you like to insert additional money? (Y/N): ");
		
	}
	
}
