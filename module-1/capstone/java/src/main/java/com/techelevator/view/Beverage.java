package com.techelevator.view;

public class Beverage extends Item {
	// CTOR
	public Beverage(String name, String slot, double price) {
		super(name, slot, price);
		this.type = "Beverage";
		this.sound = "Glug Glug, Yum!";
	}
}
