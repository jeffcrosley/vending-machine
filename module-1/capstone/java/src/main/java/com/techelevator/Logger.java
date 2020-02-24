package com.techelevator;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger 
{
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss a");
	private static LocalDateTime now = LocalDateTime.now();
	private PrintWriter writer;
	
	public Logger() {}
	
	public Logger(PrintWriter writer) 
	{
		this.writer = writer;
		writer.println(Display.displayNewLog());
	}
	
	public void logMoneyInput(BigDecimal newMoney, BigDecimal balance)
	{
		String outputLine = dtf.format(now) + " FEED MONEY: $" + String.format("%.2f", newMoney) + " $" + String.format("%.2f", balance);
		writer.println(outputLine);
	}
	
	public void logItemDispense(Item item, BigDecimal balance) 
	{
		String outputLine = dtf.format(now) + " " + item.getName() + " " + item.getSlot() + " $" + String.format("%.2f", item.getPrice()) + " $" + String.format("%.2f", balance);
		writer.println(outputLine);
	}
	
	public void logChangeOutput(BigDecimal balance) 
	{
		String outputLine = dtf.format(now) + " GIVE CHANGE: $" + String.format("%.2f", balance) + " $0.00";
		writer.println(outputLine);
	}
}
