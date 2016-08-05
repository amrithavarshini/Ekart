package com.inapp.ekart.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Test{

	public static void main(String args[]) {
		Frame frame = new Frame();
		frame.setSize(300, 300);// frame size 300 width and 300 height
		frame.setLayout(new BorderLayout());// no layout manager
		
		Button b = new Button("click me ");
		Button b1 = new Button("click me 1");
		//b.setBounds(30, 100, 80, 100);// setting button position
		
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(3, 3));
		panel.add(b);// adding button into frame
		panel.add(b1);
		frame.add(panel);
		
		
		frame.setVisible(true);// now frame will be visible, by default not visible
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
