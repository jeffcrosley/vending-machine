package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;


public class StockedItemTests {

	public StockedItemTests() {
		
	}
	
	Gum gum = new Gum("gum name", "A1", new BigDecimal("0.50"));
	StockedItem gumStock = new StockedItem(gum);
	
	@Test
	public void remove_item_decrements_an_item_stock() {
		gumStock.removeItem();
		Assert.assertEquals("removeItem should decrement an item's stock", 4, gumStock.getItemsInStock());
	}

	@Test
	public void remove_item_identifies_empty_stock() {
		gumStock.removeItem();
		gumStock.removeItem();
		gumStock.removeItem();
		gumStock.removeItem();
		gumStock.removeItem();
		Assert.assertFalse("removeItem should return false when an item is sold out", gumStock.removeItem());
	}

}
