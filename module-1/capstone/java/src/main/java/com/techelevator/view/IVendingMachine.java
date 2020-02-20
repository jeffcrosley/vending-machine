package com.techelevator.view;

import java.io.File;
import java.util.Map;

public interface IVendingMachine {
	public String purchaseProduct();
	public void stopProgram();
	public File generateSalesReport();
	public Map<String, Inventory> fillMachine(File inputFile);
}
