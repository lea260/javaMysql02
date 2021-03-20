package main;

import java.awt.event.*;

//import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.*;

public class Form2 extends JFrame 
implements ActionListener {
		private JLabel label1;
		private JTextField text;
		private JButton boton1;		
		public Form2() {
			setLayout(null);
			label1 = new JLabel("Usuario: ");
			label1.setBounds(10,10,100,30);		
			add(label1);
			
			text = new JTextField();
			text.setBounds(120,10, 150, 30);
			add(text);
			
			
			//40
			boton1= new JButton("Agregar");
			boton1.setBounds(10, 60, 100, 30);
			add(boton1);
			boton1.addActionListener(this);
			//boton1.addActionListener((ActionListener) this);
			
			
			/*
			boton1.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					label1.setText("apreto boton 01");
				}
				});*/
			//boton1.addActionListener((ActionListener) this);
			
		}//end constructor		
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//this.label1.setText("has apretado botones");
			if (e.getSource()==boton1) {
				String texto = text.getText();
				setTitle(texto);
			}			
		}
}