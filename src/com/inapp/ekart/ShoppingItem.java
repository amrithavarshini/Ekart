package com.inapp.ekart;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.inapp.ekart.awt.EKartAwtUI;

public class ShoppingItem {
	private String id;
	private String name;
	private double price;
	private Date manufacturedDate;
	private Date expiryDate;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		builder.append("id->"+id+" : ");
		builder.append("name->"+name+" : ");
		builder.append("manufacturedDate->"+new SimpleDateFormat(EKartAwtUI.EKART_DATE_FORMAT).format(manufacturedDate)+" : ");
		builder.append("expiryDate->"+expiryDate+" : ");
		builder.append("price->"+price+" : ");
		return builder.toString();
	}
	
	
	
}
