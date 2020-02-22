package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Item {
	// CTOR
	public Chips(String name, String slot, BigDecimal price) {
		super(name, slot, price);
		this.type = "Chips";
		this.sound = "Crunch Crunch, Yum!";
	}
}
