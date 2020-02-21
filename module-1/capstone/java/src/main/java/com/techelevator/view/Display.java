package com.techelevator.view;

import java.util.Map;

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
	
	public static void displayItems(Map<String, StockedItem> inventory) {
		// TODO RUN THROUGH THE INVENTORY AND PRINT EVERYTHING (SEE FORMATTING NOTES IN INSTRUCTIONS)
	}
	
	public static void displayPurchaseMenu(CalculateChange calculateChange) {
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction\n");
		// TODO CREATE STATIC METHOD FOR THIS IN CalculateChange
		System.out.println("Current Money Provided: " + calculateChange.getTotalMoneyProvided());
	}
}
