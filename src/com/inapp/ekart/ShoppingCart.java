package com.inapp.ekart;

import java.util.ArrayList;

public class ShoppingCart {
	
	private double totalCost;
		
	public static final int itemCountLimit = 15;
	
	private ArrayList<ShoppingItem> itemsInCart = new ArrayList<ShoppingItem>();
	
	public int getNumberOfItems() {
		return  itemsInCart.size();
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public ArrayList<ShoppingItem> getItemsInCart() {
		return itemsInCart;
	}
	public void setItemsInCart(ArrayList<ShoppingItem> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}
	
	public boolean addItemToCart(ArrayList<ShoppingItem> itemsToAdd){
		boolean itemAddSuccess = false;
		if(!isCartFull()){
			if(itemsToAdd.size()+ itemsInCart.size() < itemCountLimit){
				/*for (ShoppingItem shoppingItem : itemsToAdd) {
					itemsInCart.add(shoppingItem);
				}*/
				itemsInCart.addAll(itemsToAdd);
				itemAddSuccess = true;
			}
		}
		return itemAddSuccess;
	}
	
	public boolean addItemToCart(ShoppingItem itemToAdd, int quantity){
		boolean itemAddSuccess = false;
		return itemAddSuccess;
	}
	
	public boolean isCartFull(){
		boolean isFull = false;
		if( itemsInCart.size() >= itemCountLimit){
			isFull = true;
		}
		return isFull;
	}
	
	public boolean removeItemsFromCart(String itemId, int quantity){
		boolean removeSuccess = false;
		if( itemsInCart.size() > 0 &&  itemsInCart.size() >= quantity){
			int itemCounter = 0;
			for (ShoppingItem shoppingItem : itemsInCart) {
				if(shoppingItem.getId() == itemId){
					itemCounter+=1;
				}
			}
			if(itemCounter >= quantity){
				ArrayList<ShoppingItem> tempList = new ArrayList<ShoppingItem>();
				for (ShoppingItem shoppingItem : itemsInCart) {
					if(shoppingItem.getId() == itemId && quantity > 0){
						quantity -=1;
					} else {
						tempList.add(shoppingItem);
					}
				}
				itemsInCart = tempList;
				removeSuccess = true;
			}
		}
		return removeSuccess;
	}
	
	public boolean emptyCart(){
		boolean isEmpty = false;
		itemsInCart = new ArrayList<ShoppingItem>();
		isEmpty = true;
		return isEmpty;
	}
	
}
