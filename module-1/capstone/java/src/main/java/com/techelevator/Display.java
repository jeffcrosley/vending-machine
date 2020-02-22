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
		System.out.println("----------------------------------------");
	}
	
	public static void displayInventory(Map<String, StockedItem> inventory) 
	{
		System.out.println("----------------------------------------");
		for (Entry<String, StockedItem> entry : inventory.entrySet())
		{
			String tabs = "\t";
			
			if (entry.getValue().getItem().getName().length() < 8) {
				tabs += "\t";
			} 
			
			if (entry.getValue().getItem().getName().length() < 16) {
				tabs += "\t";
			}
			System.out.println(entry.getKey() + "\t" + entry.getValue().getItem().getName() + tabs + String.format("$%.2f", entry.getValue().getItem().getPrice()));
		}	
		System.out.println("----------------------------------------");		
	}
	
	public static void displayPurchaseMenu(VendingMachine vendingMachine) {
		System.out.println("----------------------------------------");
		System.out.println("Please make a selection:");
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction\n");
		System.out.println("Current Money Provided: " + String.format("$%.2f", vendingMachine.getBalance()));
		System.out.println("----------------------------------------");
	}
	
	public static void displayMoneyPrompt()
	{
		System.out.println("----------------------------------------");
		System.out.println("Please insert money ($1, $2, $5, $10 only):");
		System.out.println("----------------------------------------");
	}
	
	public static void displayAdditionalMoneyPrompt()
	{
		System.out.println("----------------------------------------");
		System.out.println("Would you like to insert additional money? (Y/N):");
		System.out.println("----------------------------------------");
	}
		
	public static void displayFarewellMessage() {
		System.out.println("----------------------------------------");
		System.out.println("Thank you!");
		System.out.println("----------------------------------------");
	}
	
	public static void displayReprompt() {
		System.out.println("----------------------------------------");
		System.out.println("Please make a selection of 1-3");
		System.out.println("----------------------------------------");
	}

	
}
