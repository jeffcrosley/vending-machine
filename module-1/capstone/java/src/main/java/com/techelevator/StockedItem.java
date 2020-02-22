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
	
	public boolean removeItem()
	{
		if (itemsInStock > 0)
		{
			itemsInStock--;
			return true;
		}
		else
		{
			System.out.println("SOLD OUT!");
			return false;
		}
	}
	
	// CTOR
	public StockedItem(Item item) {
		this.item = item;
		this.itemsInStock = 5;
	}

}
