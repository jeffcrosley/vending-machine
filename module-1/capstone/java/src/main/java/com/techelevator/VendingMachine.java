package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	
	private double budget;
	// PRIVATE METHODS
	private Map<String, StockedItem> inventory = new TreeMap<String, StockedItem>();
	
	// GETS AND SETS
	public Map<String, StockedItem> getInventory() 
	{
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

	// TODO THIS SHOULD CREATE A NEW REPORT EACH TIME
	public void generateSalesReport() throws IOException {
		String filePath = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\salesReport.txt";
		File salesReport = new File(filePath);
		salesReport.createNewFile();
		PrintWriter writer = new PrintWriter(salesReport);
		
		// TODO FIX FORMATTING
		for (Map.Entry<String, StockedItem> item : this.getInventory().entrySet()) {
			writer.println(item.getKey() + " | " + item.getValue());
		}
		
		writer.close();
	}

	public void fillMachine(File inputFile) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(inputFile);
		
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
	}
	
}
