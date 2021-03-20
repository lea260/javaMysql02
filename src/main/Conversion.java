package main;

import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class Conversion extends JFrame 
implements ActionListener, 
ItemListener {
		private JLabel label1;
		private JLabel label2;
		private JTextField txt1;
		private JTextField txt2;
		private JLabel resultado;		
		private JButton btnSumar;
		private JComboBox<String> combo1;
		private String seleccionado;
		public Conversion() {
			this.seleccionado= "multiplicacion"; 
			setLayout(null);			
			
			label1 = new JLabel("Valor 01:");
			label1.setBounds(10,10,100,30);		
			add(label1);//add(label1)
			
			txt1 = new JTextField();
			txt1.setBounds(120,10,360,30);		
			add(txt1);//add(label1)
			
			label1 = new JLabel("Valor 02:");
			label1.setBounds(10,50,100,30);		
			add(label1);//add(label1)
			
			txt2 = new JTextField();
			txt2.setBounds(120,50,360,30);		
			add(txt2);//add(label1)			
			
			resultado = new JLabel("Resultado:");
			resultado.setBounds(10,90,480,30);		
			add(resultado);//add(label1)	
			
			combo1 = new JComboBox();
			combo1.setBounds(10,130,470,30);
			add(combo1);//add(label1)
			combo1.addItem("multiplicacion");
			combo1.addItem("division");
			combo1.addItem("suma");
			combo1.addItem("resta");
			combo1.addItemListener(this);
			
			
			
			btnSumar= new JButton("Calcular:");
			btnSumar.setBounds(10, 170, 470, 30);
			add(btnSumar);
			btnSumar.addActionListener((ActionListener) this);
					
		}//end constructor		
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//this.label1.setText("has apretado botones");
			if (e.getSource()==btnSumar) {
				double valor1, valor2;
				//int valor1, valor2;
				//valor1= Integer.parseInt(txt1.getText());
				//valor2= Integer.parseInt(txt2.getText());
				//int resultadoNum= valor1+valor2;
				valor1= Double.parseDouble(txt1.getText());
				valor2= Double.parseDouble(txt2.getText());
				double resultadoNum=0;
				String resultadoStr = "";								
				resultado.setText(resultadoStr);
				switch (this.seleccionado) {
				case "multiplicacion":
					//multiplicacion:
					resultadoNum= valor1*valor2; 
					break;
				case "division":
					//division
					resultadoNum= valor1/valor2;
					break;
				case "suma":
					//suma
					resultadoNum= valor1+valor2;
					break;
				case "resta":
					//resta
					resultadoNum= valor1-valor2;
					break;				
				}
				DecimalFormat df = new DecimalFormat("0.00");
				//resultadoStr = String.valueOf(resultadoNum);				
			    resultadoStr = df.format(resultadoNum);
				resultado.setText("Resultado:    "+resultadoStr);
			}			
		}
		
		//captura de evento para combox
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==combo1 && 
					e.getStateChange() == ItemEvent.SELECTED) {				
				String itemsel = (String) e.getItem();
				this.seleccionado = itemsel;
					JOptionPane.showMessageDialog(new JFrame(), 
							"seleccionado:" +itemsel, 
							"título de la ventana", 
								JOptionPane.INFORMATION_MESSAGE);
			}
		}
}