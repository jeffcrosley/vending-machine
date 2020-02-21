package com.techelevator;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// TODO MAKE THIS WHOLE THING APPEND
public class Logger {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss a");
	LocalDateTime now = LocalDateTime.now();
		
	public Logger() {
		
	}
	
	// TODO FIGURE OUT WHERE TO UPDATE THE BALANCE; WITHIN THIS METHOD?
	public void logMoneyInput(PrintWriter writer, double newMoney, double balance) {
		String outputLine = dtf.format(now) + " FEED MONEY: $" + String.format("%.2f", newMoney) + " $" + String.format("%.2f", balance);
		writer.println(outputLine);
	}
	
	// TODO FIGURE OUT WHERE TO UPDATE THE BALANCE; WITHIN THIS METHOD?
	public void logItemDispense(PrintWriter writer, Item item, double balance) {
		String outputLine = dtf.format(now) + " " + item.getName() + " " + item.getSlot() + " $" + String.format("%.2f", item.getPrice()) + " $" + String.format("%.2f", balance);
		writer.println(outputLine);
	}
	
	// TODO FIGURE OUT WHERE TO RESET THE BALANCE; WITHIN THIS METHOD?
	public void logChangeOutput(PrintWriter writer, double balance) {
		String outputLine = dtf.format(now) + " GIVE CHANGE: $" + String.format("%.2f", balance) + " $0.00";
		writer.println(outputLine);
	}

}
