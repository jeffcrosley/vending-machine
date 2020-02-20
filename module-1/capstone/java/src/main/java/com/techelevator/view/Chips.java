package com.techelevator.view;

public class Chips extends Item {
	// CTOR
	public Chips(String name, String slot, double price) {
		super(name, slot, price);
		this.type = "Chips";
		this.sound = "Crunch Crunch, Yum!";
	}
}
