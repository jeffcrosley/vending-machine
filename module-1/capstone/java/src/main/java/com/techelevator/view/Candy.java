package com.techelevator.view;

public class Candy extends Item {
	// CTOR
	public Candy(String name, String slot, double price) {
		super(name, slot, price);
		this.type = "Candy";
		this.sound = "Munch Munch, Yum!";
	}
}
