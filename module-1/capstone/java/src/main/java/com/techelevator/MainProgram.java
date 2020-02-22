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
	
	public MainProgram() {}

	public static void main(String[] args) throws IOException, FileNotFoundException {

		// CREATE PROGRAM COMPONENTS
		VendingMachine vendingMachine = new VendingMachine();		
		Scanner userInput = new Scanner(System.in);			
		Logger logger = new Logger();
		File log = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\log.txt");
		log.createNewFile();
		PrintWriter logWriter = createWriter(log);
		
		// MAIN PROGRAM LOOP
		mainLoop(userInput, vendingMachine, logWriter, logger);
		
		// CLOSE RESOURCES
		userInput.close();
		logWriter.close();
	}
	
	public static PrintWriter createWriter(File log) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss a");
		LocalDateTime now = LocalDateTime.now();			
		FileWriter fw = new FileWriter(log, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter logWriter = new PrintWriter(bw);
		// PRINTS A NEW SESSION TO THE LOG
		logWriter.println("-------------------- | NEW SESSION | " + dtf.format(now) + " | --------------------");
		return logWriter;
	}

	public static void mainLoop(Scanner userInput, VendingMachine vendingMachine, PrintWriter logWriter, Logger logger) throws IOException {
		
		boolean exit = false;
		do {
			Display.displayMainMenu();
			String mainMenuChoice = userInput.nextLine();
			
			if (mainMenuChoice.equals("1")) {
				Display.displayInventory(vendingMachine.getInventory());
			} else if (mainMenuChoice.equals("2")) {
				purchaseMenuLoop(vendingMachine, userInput, logger, logWriter);
			} else if (mainMenuChoice.equals("3")) {
				Display.displayFarewellMessage();
				exit = true;
				break;
			} else if (mainMenuChoice.equals("4")) {
				vendingMachine.generateSalesReport();
			} else {
				Display.displayReprompt();
			}
			
		} while (!exit);
		
		logWriter.println("\n");				
	}

	public static void purchaseMenuLoop(VendingMachine vendingMachine, Scanner userInput, Logger logger, PrintWriter logWriter) {
		boolean purchaseExit = false;
		do {

			Display.displayPurchaseMenu(vendingMachine);
			String purchaseMenuChoice = userInput.nextLine();					
			if (purchaseMenuChoice.equals("1")) {
				BigDecimal insertedMoney;
				do {
					Display.displayMoneyPrompt();
					insertedMoney = new BigDecimal(userInput.nextLine());
				} while ((!insertedMoney.equals(new BigDecimal("1")) && !insertedMoney.equals(new BigDecimal("2")) && !insertedMoney.equals(new BigDecimal("5")) && !insertedMoney.equals(new BigDecimal("10"))));
				vendingMachine.insertMoney(insertedMoney, logger, logWriter);
			} else if (purchaseMenuChoice.equals("2")) {
				purchaseItems(vendingMachine, userInput, logger, logWriter);					
			} else if (purchaseMenuChoice.equals("3")) {
				makeChange(logger, logWriter, vendingMachine);
				purchaseExit = true;
				break;
			} else {
				Display.displayReprompt();
			}
			
		} while (!purchaseExit);
	}
	// TODO MOVE TO VENDING MACHINE
	public static void makeChange(Logger logger, PrintWriter logWriter, VendingMachine vendingMachine) {
		logger.logChangeOutput(logWriter, vendingMachine.getBalance());
		CalculateChange.makeChange(vendingMachine);
		vendingMachine.setBalance(BigDecimal.ZERO);
	}
	// TODO DISENTANGLE WITH VENDING MACHINE
	public static void purchaseItems(VendingMachine vendingMachine, Scanner userInput, Logger logger, PrintWriter logWriter) {
		// PURCHASE ITEMS
		Display.displayInventory(vendingMachine.getInventory());
		System.out.println("Please make a selection:");						
		System.out.println("------------------------------------------");						
		String selectedItem = userInput.nextLine().toUpperCase();
		
		boolean validCode = false;
		for (Map.Entry<String, StockedItem> entry : vendingMachine.getInventory().entrySet())
		{
			if (selectedItem.equalsIgnoreCase(entry.getKey()))
			{
				if(vendingMachine.getBalance().compareTo(entry.getValue().getItem().getPrice()) >= 0)
				{
					validCode = true;
					vendingMachine.purchaseProduct(selectedItem, logger, logWriter);
				}
				else
				{
					validCode = true;
					System.out.println("You haven't entered enough money. GIVE ME MORE MONEY!");
					continue;
				}
			}
					
		}
		if (!validCode)
		{
			System.out.println("Invalid Product Code");
		}
	
	}

}