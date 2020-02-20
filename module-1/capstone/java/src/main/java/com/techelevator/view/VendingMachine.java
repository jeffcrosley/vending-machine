package com.techelevator.view;

import java.io.File;
import java.util.Map;

public class VendingMachine implements IVendingMachine {
	
	// PRIVATE METHODS
	private Map<String, Inventory> inventory;
	
	// GETS AND SETS
	public Map<String, Inventory> getInventory() {
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

	public void stopProgram() {
		// TODO Auto-generated method stub
		
	}

	public File generateSalesReport() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Inventory> fillMachine(File inputFile) {
		// TODO Auto-generated method stub
		return null;
	}
}
