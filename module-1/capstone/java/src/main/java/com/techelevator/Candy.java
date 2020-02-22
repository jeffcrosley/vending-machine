package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {
	// CTOR
	public Candy(String name, String slot, BigDecimal price) {
		super(name, slot, price);
		this.type = "Candy";
		this.sound = "Munch Munch, Yum!";
	}
}
