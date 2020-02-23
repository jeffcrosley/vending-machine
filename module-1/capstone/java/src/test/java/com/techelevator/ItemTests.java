package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ItemTests 
{
	public ItemTests() {}
	
	Gum gum = new Gum("gum name", "A1", new BigDecimal("0.50"));
	Candy candy = new Candy("candy name", "B3", new BigDecimal("1.00"));
	Chips chips = new Chips("chips name", "D1", new BigDecimal("1.50"));
	Beverage bvg = new Beverage("bvg name", "A4", new BigDecimal("1.25"));
	
	@Test
	public void validating_getters_for_gum()
	{
		Assert.assertEquals("getSound() should display item's sound", "Chew Chew, Yum!", gum.getSound());
		Assert.assertNotEquals("getSound() should display item's sound, so NotEquals should return true", "Mmmm Gum!", gum.getSound());
		
		Assert.assertEquals("getName() should display item's name", "gum name", gum.getName());
		Assert.assertNotEquals("getName() should display the item's name, so NotEquals should return true", "The gum", gum.getName());
		
		Assert.assertEquals("getSlot() should display item's slot #", "A1", gum.getSlot());
		Assert.assertNotEquals("getSlot() should display item's slot #, so NotEquals should return true", "B3", gum.getSlot());
		
		Assert.assertEquals("getType() should display 'Gum'", "Gum", gum.getType());
		Assert.assertNotEquals("getType() should display 'Gum', so NotEquals should return true", "Gummies", gum.getType());	
	
		Assert.assertEquals("getPrice() should display the price passed into constructor", new BigDecimal("0.50"), gum.getPrice());
		Assert.assertNotEquals("getPrice() should display the price passed into constructor, so NotEquals should return true", new BigDecimal("0.51"), gum.getPrice());
	}
	
	@Test
	public void validating_getters_for_beverages()
	{
		Assert.assertEquals("getSound() should display item's sound", "Glug Glug, Yum!", bvg.getSound());
		Assert.assertNotEquals("getSound() should display item's sound, so NotEquals should return true", "Chug Chug, Yum!", bvg.getSound());
		
		Assert.assertEquals("getName() should display item's name", "bvg name", bvg.getName());
		Assert.assertNotEquals("getName() should display the item's name, so NotEquals should return true", "The bvg", bvg.getName());
		
		Assert.assertEquals("getSlot() should display item's slot #", "A4", bvg.getSlot());
		Assert.assertNotEquals("getSlot() should display item's slot #, so NotEquals should return true", "A3", bvg.getSlot());
		
		Assert.assertEquals("getType() should display 'Beverage'", "Beverage", bvg.getType());
		Assert.assertNotEquals("getType() should display 'Beverage', so NotEquals should return true", "Dranks", bvg.getType());	
		
		Assert.assertEquals("getPrice() should display the price passed into constructor", new BigDecimal("1.25"), bvg.getPrice());
		Assert.assertNotEquals("getPrice() should display the price passed into constructor, so NotEquals should return true", new BigDecimal("1.30"), bvg.getPrice());
	}
	
	@Test
	public void validating_getters_for_chips()
	{
		Assert.assertEquals("getSound() should display item's sound", "Crunch Crunch, Yum!", chips.getSound());
		Assert.assertNotEquals("getSound() should display item's sound, so NotEquals should return true", "Mmmm, Crunchy!", chips.getSound());
		
		Assert.assertEquals("getName() should display item's name", "chips name", chips.getName());
		Assert.assertNotEquals("getName() should display the item's name, so NotEquals should return true", "The chips", chips.getName());
		
		Assert.assertEquals("getSlot() should display item's slot #", "D1", chips.getSlot());
		Assert.assertNotEquals("getSlot() should display item's slot #, so NotEquals should return true", "B3", chips.getSlot());
		
		Assert.assertEquals("getType() should display 'Chips'", "Chips", chips.getType());
		Assert.assertNotEquals("getType() should display 'Chips', so NotEquals should return true", "Chipz", chips.getType());	
		
		Assert.assertEquals("getPrice() should display the price passed into constructor", new BigDecimal("1.50"), chips.getPrice());
		Assert.assertNotEquals("getPrice() should display the price passed into constructor, so NotEquals should return true", new BigDecimal("1.51"), chips.getPrice());
	}
	
	@Test
	public void validating_getters_for_candy()
	{
		Assert.assertEquals("getSound() should display item's sound", "Munch Munch, Yum!", candy.getSound());
		Assert.assertNotEquals("getSound() should display item's sound, so NotEquals should return true", "Crunch Munch, Yum!", candy.getSound());
		
		Assert.assertEquals("getName() should display item's name", "candy name", candy.getName());
		Assert.assertNotEquals("getName() should display the item's name, so NotEquals should return true", "Da candy", candy.getName());
		
		Assert.assertEquals("getSlot() should display item's slot #", "B3", candy.getSlot());
		Assert.assertNotEquals("getSlot() should display item's slot #, so NotEquals should return true", "B2", candy.getSlot());
		
		Assert.assertEquals("getType() should display 'Candy'", "Candy", candy.getType());
		Assert.assertNotEquals("getType() should display 'Candy', so NotEquals should return true", "Candies", candy.getType());	
		
		Assert.assertEquals("getPrice() should display the price passed into constructor", new BigDecimal("1.00"), candy.getPrice());
		Assert.assertNotEquals("getPrice() should display the price passed into constructor, so NotEquals should return true", new BigDecimal("1.01"), candy.getPrice());
	}
}
