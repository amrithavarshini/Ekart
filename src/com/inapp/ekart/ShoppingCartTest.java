package com.inapp.ekart;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

public class ShoppingCartTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddItemToCartShoppingItemArray() {
		ShoppingCart shoppingCart = new ShoppingCart();
		
		ShoppingItem item = new ShoppingItem();
		item.setId("SP1011");
		item.setName("Brittannia Good day");
		item.setManufacturedDate(new Date());
		item.setExpiryDate(new Date());
		
		ArrayList<ShoppingItem> itemsToAdd = new ArrayList<ShoppingItem>(); 
		itemsToAdd.add(item);
		
		shoppingCart.addItemToCart(itemsToAdd);
		
		assertEquals(1, shoppingCart.getNumberOfItems());
	}
	
	public void testRemoveItemsFromCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		
		ShoppingItem item = new ShoppingItem();
		item.setId("SP1011");
		item.setName("Brittannia Good day");
		item.setManufacturedDate(new Date());
		item.setExpiryDate(new Date());
		
		ShoppingItem item1 = new ShoppingItem();
		item1.setId("SP1012");
		item1.setName("Brittannia 50 50");
		item1.setManufacturedDate(new Date());
		item1.setExpiryDate(new Date());
		
		ShoppingItem item2 = new ShoppingItem();
		item2.setId("SP1011");
		item2.setName("Brittannia Good day");
		item2.setManufacturedDate(new Date());
		item2.setExpiryDate(new Date());
		
		ShoppingItem item3 = new ShoppingItem();
		item3.setId("SP1013");
		item3.setName("Brittannia Marie Gold");
		item3.setManufacturedDate(new Date());
		item3.setExpiryDate(new Date());
		
		ArrayList<ShoppingItem> itemsToAdd = new ArrayList<ShoppingItem>(); 
		itemsToAdd.add(item);
		itemsToAdd.add(item1);
		itemsToAdd.add(item2);
		itemsToAdd.add(item3);
		
		shoppingCart.addItemToCart(itemsToAdd);
		
		assertEquals(4, shoppingCart.getNumberOfItems());
		
		shoppingCart.removeItemsFromCart("SP1011", 1);
		
		assertEquals(3, shoppingCart.getNumberOfItems());
	}

}
