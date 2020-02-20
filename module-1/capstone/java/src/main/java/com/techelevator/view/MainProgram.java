package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;

public class MainProgram {

	public MainProgram() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		File inputFile = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-0\\module-1\\capstone\\java\\vendingmachine.csv");
		
		try {
			vendingMachine.fillMachine(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
