package com.techelevator;

public class StockedItem {
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
	
	public void setItemsInStock(int itemsInStock) {
		this.itemsInStock = itemsInStock;
	}
	
	// CTOR
	public StockedItem(Item item) {
		this.item = item;
		this.itemsInStock = 5;
	}

}
