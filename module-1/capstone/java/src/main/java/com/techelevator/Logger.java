package com.techelevator;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss a");
	LocalDateTime now = LocalDateTime.now();
		
	public Logger() {
		
	}
	
	public void logMoneyInput(PrintWriter writer, BigDecimal newMoney, BigDecimal balance) {
		String outputLine = dtf.format(now) + " FEED MONEY: $" + String.format("%.2f", newMoney) + " $" + String.format("%.2f", balance);
		writer.println(outputLine);
	}
	
	public void logItemDispense(PrintWriter writer, Item item, BigDecimal balance) {
		String outputLine = dtf.format(now) + " " + item.getName() + " " + item.getSlot() + " $" + String.format("%.2f", item.getPrice()) + " $" + String.format("%.2f", balance);
		writer.println(outputLine);
	}
	
	public void logChangeOutput(PrintWriter writer, BigDecimal balance) {
		String outputLine = dtf.format(now) + " GIVE CHANGE: $" + String.format("%.2f", balance) + " $0.00";
		writer.println(outputLine);
	}

}
