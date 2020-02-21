package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainProgram {

	public MainProgram() {
		
	}


	public static void main(String[] args) throws IOException, FileNotFoundException {
		// CREATE VENDING MACHINE, CALCULATOR, INPUT FILE, AND WRITER
		VendingMachine vendingMachine = new VendingMachine();
		CalculateChange calculator = new CalculateChange();
		File inputFile = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\vendingmachine.csv");
		
		vendingMachine.fillMachine(inputFile);
		Display.displayInventory(vendingMachine);
		
		/*
		// CREATE SCANNER TO HANDLE USER INPUT
		try (Scanner userInput = new Scanner(System.in)) {
			
			// FILL VENDING MACHINE
			vendingMachine.fillMachine(inputFile); // TODO LOG

			// DISPLAY MAIN MENU AND GET INPUT
			String userSelection = "";
			do {
				Display.displayMainMenu();
				userSelection = userInput.nextLine();
				
				if (userSelection.equals("1") ) {
					Display.displayItems(vendingMachine.getInventory());
					// 2nd level display menu
				} else if (userSelection.equals("2")) {
					
					String userPurchaseSelection = "";
					do {
						Display.displayPurchaseMenu(calculator); // change me 
						userPurchaseSelection = userInput.nextLine();
						if (userPurchaseSelection.equals("1")) {
							calculator.insertMoney(userInput); // TODO REFACTOR TO PASS INPUT SCANNER INTO THIS; LOG
						} else if (userPurchaseSelection.equals("2")) {
							Display.displayItems(vendingMachine.getInventory()); // TODO FORMAT THIS TO LOOK PRETTY
							// TODO COLLECT INPUT FROM USER
							// TODO IF PRODUCT DOESN'T EXIST OR IF IT'S SOLD OUT, ALERT USER AND RETURN TO PURCHASE MENU; CONTINUE
							// TODO IF PRODUCT EXISTS, DISPENSE BY PRINTING NAME, COST, MONEY REMAINING, AND MESSAGE; DECREMENT INVENTORY; LOG; UPDATE BALANCE IN CALCULATOR (OR WHEREVER)							
						} else if (userPurchaseSelection.equals("3") ) {
							// TODO RETURN CHANGE (FROM CALCULATOR); LOG; UPDATE BALANCE; WILL EXIT THE LOOP
						}	
						
					} while (!userPurchaseSelection.equals("3"));
					
				} else if (userSelection.equals("3")) {
					System.out.println("Thank you!");
				} else if (userSelection.equals("4")) {
//					vendingMachine.generateSalesReport();
				}
				
			} while (!userSelection.equals("3"));
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

		// THIS IS ALL MANUAL TESTING FOR THE LOGGER
//		Candy nutterButter = new Candy("Nutter Butter", "D1", 2.00);
//		Logger logger = new Logger();
//		String filePath = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\log.txt";
//		File activityLog = new File(filePath);
//		activityLog.createNewFile();
//		PrintWriter writer = new PrintWriter(activityLog);
//		logger.logMoneyInput(writer, 5.00, 10.00);
//		logger.logItemDispense(writer, nutterButter, 10.00);
//		logger.logChangeOutput(writer, 5.00);
//		writer.close();
		
		// MANUAL TESTING FOR SALES REPORTS
		vendingMachine.generateSalesReport();
	}

	public static void clear() {
		// TODO CLEAR CONSOLE
	}
}
