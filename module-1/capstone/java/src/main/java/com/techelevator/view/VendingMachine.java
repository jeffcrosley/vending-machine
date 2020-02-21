package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	
	// PRIVATE METHODS
	private Map<String, StockedItem> inventory;
	
	// GETS AND SETS
	public Map<String, StockedItem> getInventory() {
		return inventory;
	}

	// CTOR
	public VendingMachine() {
		
	}	
	
	// PUBLIC METHODS
	public String purchaseProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	public File generateSalesReport() {
		// TODO CREATE GENERATE SALES REPORT METHOD
		return null;
	}

	public Map<String, StockedItem> fillMachine(File inputFile) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(inputFile);
		Map<String, StockedItem> inventory = new TreeMap<String, StockedItem>();
		
		while (fileScanner.hasNextLine()) {
			String[] inventoryData = fileScanner.nextLine().split("[|]");
			
			String slot = inventoryData[0];
			String name = inventoryData[1];
			double price = Double.parseDouble(inventoryData[2]);
			String type = inventoryData[3];
			
			StockedItem item;
			
			if (type.equalsIgnoreCase("Drink")) {
				item = new StockedItem(new Beverage(name, slot, price));
			} else if (type.equalsIgnoreCase("Candy")) {
				item = new StockedItem(new Candy(name, slot, price));
			} else if (type.equalsIgnoreCase("Chip")) {
				item = new StockedItem(new Chips(name, slot, price));
			} else {
				// TODO FIX THIS SO IT HANDLES BAD INPUT
				item = new StockedItem(new Gum(name, slot, price));
			}
			
			inventory.put(slot, item);
		}		
		
		fileScanner.close();
		return inventory;
	}
}
