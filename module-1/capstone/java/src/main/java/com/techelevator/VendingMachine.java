package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	
	// PRIVATE MEMBERS
	private double balance;
	private Map<String, StockedItem> inventory;

	// GETS AND SETS
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Map<String, StockedItem> getInventory() 
	{
		return inventory;
	}
	
	// CTOR
	public VendingMachine() {
		
	}	
	
	// PUBLIC METHODS
	public void purchaseProduct(String selection) {
		String outputMessage = "";
		for (Map.Entry<String, StockedItem> item : this.getInventory().entrySet()) {
			if (selection.equals(item.getKey())) {
				item.getValue().setItemsInStock(item.getValue().getItemsInStock() - 1);
				setBalance(getBalance() - item.getValue().getItem().getPrice()); 
				outputMessage = item.getValue().getItem().getName() + " " 
						+ item.getValue().getItem().getPrice() + " "
						+ this.getBalance() + " "
						+ item.getValue().getItem().getSound();
			}
		}
		System.out.println(outputMessage);
	}

	public void generateSalesReport() throws IOException {
		double totalSales = 0;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssa");
		LocalDateTime now = LocalDateTime.now();
		
		String filePath = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\salesReport" + dtf.format(now) + ".txt";
		File salesReport = new File(filePath);
		salesReport.createNewFile();
		PrintWriter writer = new PrintWriter(salesReport);
		
		for (Map.Entry<String, StockedItem> item : this.getInventory().entrySet()) {
			writer.println(item.getValue().getItem().getName() + " | " + (5 - item.getValue().getItemsInStock()));
			totalSales += (5 - item.getValue().getItemsInStock()) * item.getValue().getItem().getPrice();
		}		
		
		writer.println("\n");
		writer.println("Total Sales: $" + totalSales);
		
		writer.close();
	}

	public void fillMachine(File inputFile) throws FileNotFoundException {
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
			this.inventory = inventory;
		}		
		fileScanner.close();
	}


	
	public void insertMoney(Scanner scanner) // pass a Logger object into this (same instance as in our VendingMachine), maybe store as private variable
	{
		int totalMoneyInserted = 0;
		
		try
		{	
			String yesNoAnswer = "";
			do
			{
				totalMoneyInserted += insertMoneyPrompt(scanner);
				do 
				{
					Display.displayAdditionalMoneyPrompt();
					yesNoAnswer = scanner.nextLine();
				}
				while(!yesNoAnswer.equalsIgnoreCase("yes") && !yesNoAnswer.equalsIgnoreCase("no") && !yesNoAnswer.equalsIgnoreCase("y") && !yesNoAnswer.equalsIgnoreCase("n"));
			}
			while (yesNoAnswer.equalsIgnoreCase("y") || yesNoAnswer.equalsIgnoreCase("yes"));
			balance += totalMoneyInserted;
		}
		catch (Exception ex)
		{
			System.out.println("Problem! Change me! " + ex.getMessage());
		}

	}
	
	public int insertMoneyPrompt(Scanner scanner)
	{
		String value;
		int total = 0;	
		
		do
		{
			Display.displayMoneyPrompt();
			value = scanner.nextLine();
		}
		while (!value.equals("1") && !value.equals("2") && !value.equals("5") && !value.equals("10"));
		
		total = Integer.parseInt(value);
		
		return total;
	}
	
}
