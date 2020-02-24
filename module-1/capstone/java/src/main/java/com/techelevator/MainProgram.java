package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class MainProgram {
	
	// PRIVATE CONSTANTS (File path)
	
	private static final String LOG_FILE_PATH = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\log.txt";
	
	public MainProgram() {}

	public static void main(String[] args)
	{
		// CREATE PROGRAM COMPONENTS
		try (Scanner userInput = new Scanner(System.in))
		{
			VendingMachine vendingMachine = new VendingMachine();	
			File log = new File(LOG_FILE_PATH);
			log.createNewFile();

			try (PrintWriter logWriter = new PrintWriter(new BufferedWriter(new FileWriter(log, true))))
			{
				Logger logger = new Logger(logWriter);
				
				// MAIN PROGRAM LOOP
			
				boolean exit = false;
				do {
					Display.displayMainMenu();
					String mainMenuChoice = userInput.nextLine();
					
					if (mainMenuChoice.equals("1")) {
						//TODO: Implement categorized inventory (re-added to Display class)
						Display.displayInventory(vendingMachine.getInventory());
					} else if (mainMenuChoice.equals("2")) {
						
						//TODO: If purchase menu selection != 1-3, should we re-prompt purchase menu, or kick back to main menu?
						selectPurchaseMenu(vendingMachine, userInput, logger);
					} else if (mainMenuChoice.equals("3")) {
						Display.displayFarewellMessage();
						exit = true;
						break;
					} else if (mainMenuChoice.equals("4")) {
						vendingMachine.generateSalesReport();
					} else {
						Display.displayReprompt();
					}
					
				} 
				while (!exit);
				
				logWriter.println("\n");
			}
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("File Not Found: " + ex.getMessage());
		}
		catch (IOException ex)
		{
			System.out.println("Input/Output Failure: " + ex.getMessage());
		}
		catch (NullPointerException ex)
		{
			System.out.println("Null Pointer: Attempted to reference an uninstantiated object or field. " + ex.getMessage());
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString() + " " + ex.getMessage());
		}
	
	}
	
	public static void selectPurchaseMenu(VendingMachine vendingMachine, Scanner userInput, Logger logger) 
	{
		try
		{
			boolean purchaseExit = false;
			do {
				Display.displayPurchaseMenu(vendingMachine);
				String purchaseMenuChoice = userInput.nextLine();					
				if (purchaseMenuChoice.equals("1")) 
				{
					BigDecimal insertedMoney;
					//TODO -- is forcing a money insertion the best option here? Maybe we just kick then back out to Purchase Menu if invalid money entered rather than force user to enter something valid
					do 
					{
						Display.displayMoneyPrompt();
						insertedMoney = new BigDecimal(userInput.nextLine());
					} 
					while ((!insertedMoney.equals(new BigDecimal("1")) && !insertedMoney.equals(new BigDecimal("2")) && !insertedMoney.equals(new BigDecimal("5")) && !insertedMoney.equals(new BigDecimal("10"))));
					vendingMachine.insertMoney(insertedMoney, logger);
				} 
				else if (purchaseMenuChoice.equals("2")) 
				{
					vendingMachine.purchaseProduct(logger, userInput);					
				} 
				else if (purchaseMenuChoice.equals("3")) 
				{
					vendingMachine.makeChange(logger);
					purchaseExit = true;
					break;
				} 
				else { Display.displayReprompt(); }
			} 
			while (!purchaseExit);
		}
		catch (Exception ex)
		{
			System.out.println("Exception thrown: " + ex.getMessage());
		}
	}
}