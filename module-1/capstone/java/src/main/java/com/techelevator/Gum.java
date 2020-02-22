package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {
	// CTOR
	public Gum(String name, String slot, BigDecimal price) {
		super(name, slot, price);
		this.type = "Gum";
		this.sound = "Chew Chew, Yum!";
	}
}
