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
	
	public boolean removeItem() // boolean return?  "True" if able to decrement, false if out of stock.
	{
		if (itemsInStock > 0)
		{
			itemsInStock--;
			return true;
		}
		else
		{
			System.out.println("OUT OF STOCK!");
			return false;
		}
	}
	
	// CTOR
	public StockedItem(Item item) {
		this.item = item;
		this.itemsInStock = 5;
	}

}
