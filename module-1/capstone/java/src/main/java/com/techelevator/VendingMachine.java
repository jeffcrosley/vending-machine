package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	
	// PRIVATE MEMBERS
	private BigDecimal balance;
	private Map<String, StockedItem> inventory;

	// GETS AND SETS
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Map<String, StockedItem> getInventory() 
	{
		return inventory;
	}
	
	// CTOR
	public VendingMachine() throws FileNotFoundException {
		this.balance = BigDecimal.ZERO;
		this.inventory = fillMachine();
	}	
	
	// PUBLIC METHODS
	public void insertMoney(BigDecimal insertedMoney, Logger logger, PrintWriter logWriter) {
		setBalance(this.getBalance().add(insertedMoney));
		logger.logMoneyInput(logWriter, insertedMoney, getBalance());
	}

	public void purchaseProduct(String selection, Logger logger, PrintWriter logWriter) {
		String outputMessage = "";
		for (Map.Entry<String, StockedItem> item : this.getInventory().entrySet()) {
			BigDecimal itemPrice = item.getValue().getItem().getPrice();
			if (selection.equalsIgnoreCase(item.getKey())) {
				// DECREMENT STOCK
				boolean isSuccessfulPurchase = item.getValue().removeItem();
				if (isSuccessfulPurchase)
				{
					
					setBalance(getBalance().subtract(itemPrice)); 
					logger.logItemDispense(logWriter, item.getValue().getItem(), getBalance());
					
					outputMessage = item.getValue().getItem().getSound() + "\n" +
							"Enjoy your " + item.getValue().getItem().getName() + "!\n" 
							+ "Cost: " + String.format("$%.2f", item.getValue().getItem().getPrice()) + "\n"
							+ "Balance: " + String.format("$%.2f", this.getBalance());
				}
			}
		}
		System.out.println("----------------------------------------");
		System.out.println(outputMessage);
	}

	public void generateSalesReport() throws IOException {
		BigDecimal totalSales = BigDecimal.ZERO;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssa");
		LocalDateTime now = LocalDateTime.now();
		
		String filePath = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\salesReport" + dtf.format(now) + ".txt";
		File salesReport = new File(filePath);
		salesReport.createNewFile();
		PrintWriter writer = new PrintWriter(salesReport);
		
		for (Map.Entry<String, StockedItem> item : this.getInventory().entrySet()) {
			writer.println(item.getValue().getItem().getName() + " | " + (5 - item.getValue().getItemsInStock()));
			totalSales = totalSales.add(new BigDecimal("5").subtract(new BigDecimal(item.getValue().getItemsInStock())).multiply(item.getValue().getItem().getPrice())) ;
		}		
		
		writer.println("\n");
		writer.println("Total Sales: $" + totalSales);
		
		writer.close();
	}

	public Map<String, StockedItem> fillMachine() throws FileNotFoundException {
		File inputFile = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\vendingmachine.csv");	
		Scanner fileScanner = new Scanner(inputFile);
		Map<String, StockedItem> inventory = new TreeMap<String, StockedItem>();
		while (fileScanner.hasNextLine()) {
			String[] inventoryData = fileScanner.nextLine().split("[|]");
			
			String slot = inventoryData[0];
			String name = inventoryData[1];
			BigDecimal price = new BigDecimal(inventoryData[2]);
			String type = inventoryData[3];
			
			StockedItem item = null;
			
			if (type.equalsIgnoreCase("Drink")) {
				item = new StockedItem(new Beverage(name, slot, price));
			} else if (type.equalsIgnoreCase("Candy")) {
				item = new StockedItem(new Candy(name, slot, price));
			} else if (type.equalsIgnoreCase("Chip")) {
				item = new StockedItem(new Chips(name, slot, price));
			} else if (type.equalsIgnoreCase("Gum")){
				item = new StockedItem(new Gum(name, slot, price));
			} else {
				System.out.println("INVALID ITEMS IN INPUT FILE");
				System.exit(1);
			}
			
			inventory.put(slot, item);			
		}	
		
		fileScanner.close();
		return inventory;
	}
}
