package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends Item {
	// CTOR
	public Beverage(String name, String slot, BigDecimal price) {
		super(name, slot, price);
		this.type = "Beverage";
		this.sound = "Glug Glug, Yum!";
	}
}
