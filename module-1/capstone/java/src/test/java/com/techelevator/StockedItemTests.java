package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;


public class StockedItemTests {

	public StockedItemTests() {
		
	}
	
	Gum gum = new Gum("gum name", "A1", new BigDecimal("0.50"));
	Candy candy = new Candy("candy name", "B3", new BigDecimal("1.00"));
	Chips chips = new Chips("chips name", "D1", new BigDecimal("1.50"));
	Beverage bvg = new Beverage("bvg name", "A4", new BigDecimal("1.25"));
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
	
	@Test
	public void test_sound_for_each_item()
	{
		Assert.assertEquals("getSound() should display item's sound", "", gumStock.getItemsInStock());
	}

}
