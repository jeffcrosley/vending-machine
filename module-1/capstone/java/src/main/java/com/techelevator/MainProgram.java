package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainProgram {

	public MainProgram() {}

	public static void main(String[] args) throws IOException, FileNotFoundException {

		// INSTANTIATE COMPONENTS
		VendingMachine vendingMachine = new VendingMachine();
	
		File inputFile = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\vendingmachine.csv");
		
		Logger logger = new Logger();
		File log = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\log.txt");
		log.createNewFile();
		PrintWriter logWriter = new PrintWriter(log);
		
		Scanner userInput = new Scanner(System.in);
		
		
		// FILL VENDING MACHINE FROM INPUT FILE
		vendingMachine.fillMachine(inputFile);
		
		// MAIN LOOP: DISPLAY MAIN MENU AND GET INPUT
		boolean exit = false;
		do {
			Display.displayMainMenu();
			String mainMenuChoice = userInput.nextLine();
			
			if (mainMenuChoice.equals("1")) {
				// DISPLAY AVAILABLE SNACKS
				Display.displayInventory(vendingMachine.getInventory());
			} else if (mainMenuChoice.equals("2")) {
				// GO TO PURCHASE MENU				
				boolean purchaseExit = false;
				do {
					// DISPLAY PURCHASE MENU AND GET INPUT
					Display.displayPurchaseMenu(vendingMachine);
					String purchaseMenuChoice = userInput.nextLine();
					
					if (purchaseMenuChoice.equals("1")) {
						// ADD MONEY
						Display.displayMoneyPrompt();
						String insertedMoney = userInput.nextLine();
						vendingMachine.setBalance(vendingMachine.getBalance() + Double.parseDouble(insertedMoney));
						logger.logMoneyInput(logWriter, Double.parseDouble(insertedMoney), vendingMachine.getBalance());
					} else if (purchaseMenuChoice.equals("2")) {
						// PURCHASE ITEMS
						Display.displayInventory(vendingMachine.getInventory());
						System.out.println("Please make a selection:");						
						System.out.println("----------------------------------------");						
						String selectedItem = userInput.nextLine();
						vendingMachine.purchaseProduct(selectedItem);
						logger.logItemDispense(logWriter, vendingMachine.getInventory().get(selectedItem).getItem(), vendingMachine.getBalance());
						// TODO HANDLE CASES FOR OUT OF STOCK OR NON-EXISTENT PRODUCTS
						// TODO CHECK FOR NOT ENOUGH MONEY
					} else if (purchaseMenuChoice.equals("3")) {
						// MAKE CHANGE AND EXIT TO MAIN MENU
						logger.logChangeOutput(logWriter, vendingMachine.getBalance());
						CalculateChange.makeChange(vendingMachine);
						vendingMachine.setBalance(0);
						purchaseExit = true;
						break;
					} else {
						Display.displayReprompt();
					}
				} while (!purchaseExit);
			} else if (mainMenuChoice.equals("3")) {
				// EXIT PROGRAM
				Display.displayFarewellMessage();
				exit = true;
				break;
			} else if (mainMenuChoice.equals("4")) {
				// GENERATE SALES REPORT
				vendingMachine.generateSalesReport();
			} else {
				Display.displayReprompt();
			}
			
		} while (!exit);
		
		userInput.close();
		logWriter.close();		
	}
}