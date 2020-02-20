package com.techelevator.view;

public abstract class Item {
	
	// PRIVATE MEMBERS
	protected String name;
	protected String slot;
	protected double price;
	protected String type;
	protected String sound;
		
	// GETS AND SETS
	public String getName() {
		return name;
	}

	public String getSlot() {
		return slot;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public String getSound() {
		return sound;
	}

	// CTOR
	public Item(String name, String slot, double price) {
		this.name = name;
		this.slot = slot;
		this.price = price;
	}
}
