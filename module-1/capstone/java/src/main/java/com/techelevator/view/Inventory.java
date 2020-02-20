package com.techelevator.view;

public class Inventory {
	// PRIVATE MEMBERS
	private Item item;
	private int itemsInStock;
	
	// GETS AND SETS
	public Item getItem() {
		return item;
	}

	public int getItemsInStock() {
		return itemsInStock;
	}
	
	// CTOR
	public Inventory(Item item) {
		this.item = item;
		this.itemsInStock = 5;
	}

}
