package com.techelevator;

public class Gum extends Item {
	// CTOR
	public Gum(String name, String slot, double price) {
		super(name, slot, price);
		this.type = "Gum";
		this.sound = "Chew Chew, Yum!";
	}
}
