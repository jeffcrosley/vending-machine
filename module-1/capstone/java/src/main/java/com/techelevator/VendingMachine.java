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
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssa");
	private static LocalDateTime now = LocalDateTime.now();
	
	// PRIVATE CONSTANTS (File Paths)
	private static final String INVENTORY_FILE_PATH = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\vendingmachine.csv";
	private static final String SALES_REPORT_FILE_PATH = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\salesReport" + dtf.format(now) + ".txt";

	// GETS AND SETS
	public BigDecimal getBalance() { return balance; }
	public Map<String, StockedItem> getInventory() { return inventory; }

	// Made this private given we're now only calling it within the VM class (and we don't want people setting the balance manually)
	private void setBalance(BigDecimal balance) { this.balance = balance; }

	// CTOR
	
	//TODO We should not have this throw an exception if we can avoid it.  Wrap in try/catch.
	public VendingMachine() throws FileNotFoundException
	{
		balance = BigDecimal.ZERO;
		inventory = fillMachine();
	}	
	
	// PUBLIC METHODS
	
	//TODO: Wrap in try-catch (not w/ resources)
	public void insertMoney(BigDecimal insertedMoney, Logger logger)
	{
		setBalance(this.getBalance().add(insertedMoney));
		logger.logMoneyInput(insertedMoney, getBalance());
	}

	//TODO: Wrap in try/catch (not w/ resources so that we don't close scanner/printwriter)
	public void purchaseProduct(Logger logger, Scanner userInput) throws NullPointerException
	{
		Display.displayInventory(getInventory());
		Display.displaySelectionPrompt();
		String selectedItem = userInput.nextLine().toUpperCase();
		
		boolean validCode = false;
		for (Map.Entry<String, StockedItem> item : getInventory().entrySet())
		{
			if (selectedItem.equalsIgnoreCase(item.getKey()))
			{
				validCode = true;
				BigDecimal itemPrice = item.getValue().getItem().getPrice();
				
				if(getBalance().compareTo(itemPrice) >= 0)
				{
					// DECREMENT STOCK
					boolean isSuccessfulPurchase = item.getValue().removeItem();
					System.out.println("----------------------------------------");
					
					if (isSuccessfulPurchase)
					{
						setBalance(getBalance().subtract(itemPrice)); 
						logger.logItemDispense(item.getValue().getItem(), getBalance());
						
						// TODO this can be turned into its own method (Item as param/arg)
						System.out.println(item.getValue().getItem().getSound() + "\n" +
										"Enjoy your " + item.getValue().getItem().getName() + "!\n" 
										+ "Cost: " + String.format("$%.2f", itemPrice) + "\n"
										+ "Balance: " + String.format("$%.2f", getBalance()));
					}
				}
				else
				{
					System.out.println("Please insert additional money to purchase your selected product."); // calculate difference between entered & cost of item
					continue;
				}
			}	
		}
		if (!validCode)
		{
			System.out.println("Invalid Product Code");
		}
		
	}

	//TODO: Wrap in try-with-resources + catch various exceptions
	public void generateSalesReport() throws IOException 
	{
		BigDecimal totalSales = BigDecimal.ZERO;
		
		String filePath = SALES_REPORT_FILE_PATH;
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

	//TODO: Wrap in try-with-resources + catch various exceptions
	public Map<String, StockedItem> fillMachine() throws FileNotFoundException 
	{
		File inputFile = new File(INVENTORY_FILE_PATH);	
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
	
	//TODO: Wrap in try/catch (not w/ resources so we don't close our printWriter)
	public void makeChange(Logger logger) {
		logger.logChangeOutput(getBalance());
		CalculateChange.makeChange(this);
		setBalance(BigDecimal.ZERO);
	}
}
