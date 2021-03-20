package main;

import java.awt.event.*;

//import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.*;

public class FormularioBoton extends JFrame 
implements ActionListener {
		private JLabel label1;
		private JLabel label2;
		private JButton boton1;
		private JButton boton2;
		public FormularioBoton() {
			setLayout(null);
			label1 = new JLabel("Uno");
			label1.setBounds(10,10,100,20);		
			super.add(label1);//add(label1)
			label2 = new JLabel("Dos");
			label2.setBounds(10,100,100,20);		
			add(label2);//add(label1)
			boton1= new JButton("Boton 01");
			boton1.setBounds(10, 300, 100, 30);
			add(boton1);
			boton1.addActionListener((ActionListener) this);
			
			boton2= new JButton("Boton 02");
			boton2.setBounds(120, 300, 100, 30);
			add(boton2);
			boton2.addActionListener((ActionListener) this);
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
			this.label1.setText("has apretado botones");
			if (e.getSource()==boton1) {
				this.label2.setText("apreto boton 01");
			}
			if (e.getSource()==boton2) {
				this.label2.setText("apreto boton 02");
			}
		}
}
