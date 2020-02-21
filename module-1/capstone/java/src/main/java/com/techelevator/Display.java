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
	
	public static void displayCategorizedInventory(Map<String, StockedItem> inventory, String category) 
	{
		for (Entry<String, StockedItem> entry : inventory.entrySet())
		{
			if (category.equals("1") && entry.getValue().getItem().getType().equalsIgnoreCase("Drink"))
				System.out.println(entry.getKey() + "\t\t" + entry.getValue().getItem().getName() + "\t\t" + entry.getValue().getItem().getPrice());
			else if (category.equals("2") && entry.getValue().getItem().getType().equalsIgnoreCase("Chip"))
				System.out.println(entry.getKey() + "\t\t" + entry.getValue().getItem().getName() + "\t\t" + entry.getValue().getItem().getPrice());
			else if (category.equals("3") && entry.getValue().getItem().getType().equalsIgnoreCase("Candy"))
				System.out.println(entry.getKey() + "\t\t" + entry.getValue().getItem().getName() + "\t\t" + entry.getValue().getItem().getPrice());
			else if (category.equals("4") && entry.getValue().getItem().getType().equalsIgnoreCase("Gum"))
				System.out.println(entry.getKey() + "\t\t" + entry.getValue().getItem().getName() + "\t\t" + entry.getValue().getItem().getPrice());
				
		}	
	}
	public static void displayInventory(Map<String, StockedItem> inventory) 
	{
		for (Entry<String, StockedItem> entry : inventory.entrySet())
		{
			System.out.println(entry.getKey() + "\t\t" + entry.getValue().getItem().getName() + "\t\t" + entry.getValue().getItem().getPrice());
		}	
		
	}
	
	// clean up formatting
	public static void displayPurchaseMenu(CalculateChange calculateChange) {
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction\n");
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
	
	public static void displayVendingMachineCategories()
	{

		System.out.println("1. Drinks\n2. Chips\n3. Candy\n4. Gum");
		System.out.println("\nSelect a category (1-4): ");
	}
	
}
