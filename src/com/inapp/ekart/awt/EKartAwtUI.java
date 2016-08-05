package com.inapp.ekart.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.inapp.ekart.ShoppingCart;
import com.inapp.ekart.ShoppingItem;

public class EKartAwtUI {

	public static final String EKART_DATE_FORMAT = "dd-MM-yyyy";

	Frame ekartFrame = new Frame();
	ShoppingCart shoppingCart = new ShoppingCart();
	Panel productPanel = new Panel();
	JScrollPane dataTablePane = new JScrollPane();
	
	Object[] columNames = {"<html>Product<br> Name<html>","Product Id","<html>Manufactured<br> Date</html>","<html>Expiry Date</html>","<html>Price in<br> Rupees</html>"};
	DefaultTableModel defaultTableModel = new DefaultTableModel(columNames,1);
	JTable cartItemsTable = new JTable(defaultTableModel);

	Label nameLabel = new Label("Product Name");
	TextField nameField = new TextField("Britannia ",50);

	Label productIdLabel = new Label("Product Id");
	TextField productIdField = new TextField("SS1102", 50);

	Label manufacturedDateLabel = new Label("Manufactured Date (format dd-MM-yyy, ex:- 22-07-2016)");
	TextField manufacturedDateField = new TextField("22-07-2016",50);

	Label expiryDateLabel = new Label("Expiry Date (format dd-MM-yyy, ex:- 22-07-2016)");
	TextField expiryDateField = new TextField("22-07-2017",50);

	Label priceLabel = new Label("Price in Rupees");
	TextField priceField = new TextField("0.0",50);

	public Frame getEkartFrame() {

		ekartFrame.setSize(400, 400);
		ekartFrame.setLayout(new BorderLayout());
		ekartFrame.add(getProductsPanel(), BorderLayout.NORTH);
		ekartFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		dataTablePane = new JScrollPane(cartItemsTable);
		ekartFrame.add(dataTablePane, BorderLayout.CENTER);
		ekartFrame.setVisible(true);
		return ekartFrame;
	}

	public Panel getProductsPanel() {

		productPanel.setLayout(new GridLayout(11, 1));

		productPanel.add(nameLabel);
		productPanel.add(nameField);

		productPanel.add(productIdLabel);
		productPanel.add(productIdField);

		productPanel.add(manufacturedDateLabel);
		productPanel.add(manufacturedDateField);

		productPanel.add(expiryDateLabel);
		productPanel.add(expiryDateField);

		productPanel.add(priceLabel);
		productPanel.add(priceField);

		Button saveButton = new Button("Save Product");
		productPanel.add(saveButton);

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveItemToCart();
			}
		});
		
		return productPanel;
	}

	private void saveItemToCart() {
		
		String productId = productIdField.getText();
		String productName = nameField.getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat(EKartAwtUI.EKART_DATE_FORMAT);
	    String manufacturedDateStr = manufacturedDateField.getText();
	    Date manufacturedDate = null;
	    Date expiryDate = null;
	    String expiryDateStr = expiryDateField.getText();
	    String price = priceField.getText();
	    
	    try {
			manufacturedDate = dateFormat.parse(manufacturedDateStr);
			expiryDate = dateFormat.parse(expiryDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	    ShoppingItem shoppingItem = new ShoppingItem();
	    shoppingItem.setId(productId);
	    shoppingItem.setName(productName);
	    shoppingItem.setManufacturedDate(manufacturedDate);
	    shoppingItem.setExpiryDate(expiryDate);
	    shoppingItem.setPrice(Double.parseDouble(price));
	    
	    System.out.println("Shoppping Item "+shoppingItem);
	    
	    ArrayList<ShoppingItem> itemsToAdd = new ArrayList<ShoppingItem>();
	    itemsToAdd.add(shoppingItem);
	    shoppingCart.addItemToCart(itemsToAdd);
	    
	    refreshTableData(itemsToAdd);
	    
	    
	}

	private void refreshTableData(ArrayList<ShoppingItem> itemsToAdd) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(EKartAwtUI.EKART_DATE_FORMAT);
		for (ShoppingItem shoppingItem : itemsToAdd) {
			Object[] rowData = new Object[5];
			
			rowData[0] = shoppingItem.getName();
			rowData[1] = shoppingItem.getId();
			rowData[2] = dateFormat.format(shoppingItem.getManufacturedDate());
			rowData[3] = dateFormat.format(shoppingItem.getExpiryDate());
			rowData[4] = shoppingItem.getPrice();
			
			defaultTableModel.addRow(rowData);
			defaultTableModel.fireTableDataChanged();
		}
		
	}

	public static void main(String[] args) {
		new EKartAwtUI().getEkartFrame();
	}
}
