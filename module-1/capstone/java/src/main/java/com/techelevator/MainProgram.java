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

	public static void main(String[] args) throws IOException, FileNotFoundException {

		// CREATE PROGRAM COMPONENTS
		VendingMachine vendingMachine = new VendingMachine();		
		Scanner userInput = new Scanner(System.in);			
		Logger logger = new Logger();
		//TODO: Have Logger accept a PrintWriter to it's constructor (logWriter, as created in the createWriter method (passing in BW/FW))
		// We could then make it print a "NEW SESSION" every time the program runs & a new logger is created (using Display.displayNewLog(), as below in createWriter()
		File log = new File(LOG_FILE_PATH);
		log.createNewFile();
		PrintWriter logWriter = createWriter(log); // Once we remove createWriter, we'll
		
		// MAIN PROGRAM LOOP
		
		// TODO: Wrap in try-with/resources / catch blocks, passing in one or multiple of the scanners/printwriters.
		boolean exit = false;
		do {
			Display.displayMainMenu();
			String mainMenuChoice = userInput.nextLine();
			
			if (mainMenuChoice.equals("1")) {
				Display.displayInventory(vendingMachine.getInventory());
			} else if (mainMenuChoice.equals("2")) {
				selectPurchaseMenu(vendingMachine, userInput, logger, logWriter);
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
		
		// TODO: Wrap main() in try-with-resources for autoclosing & exception handling.
		userInput.close();
		logWriter.close();
	}
	
	//TODO: See notes above. We can get rid of this method & majority of its code by refactoring.
	public static PrintWriter createWriter(File log) throws IOException 
	{	
		// We will eventually delete all of this, using the logWriter above (declared the same way), passing a PrintWriter into the Logger constructor
		// Only keeping this currently because of the logWriter.println(Display.displayNewLog()), which I plan to move into the Logger's constructor eventually.
		PrintWriter logWriter = new PrintWriter(new BufferedWriter(new FileWriter(log, true)));
		logWriter.println(Display.displayNewLog());
		return logWriter;
	}

	//TODO -- Should this also be in VendingMachine? I don't think so, but could see an argument for it.
	public static void selectPurchaseMenu(VendingMachine vendingMachine, Scanner userInput, Logger logger, PrintWriter logWriter) 
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
				vendingMachine.insertMoney(insertedMoney, logger, logWriter);
			} 
			else if (purchaseMenuChoice.equals("2")) 
			{
				vendingMachine.purchaseProduct(logger, logWriter, userInput);					
			} 
			else if (purchaseMenuChoice.equals("3")) 
			{
				vendingMachine.makeChange(logger, logWriter);
				purchaseExit = true;
				break;
			} 
			else { Display.displayReprompt(); }
		} 
		while (!purchaseExit);
	}
}