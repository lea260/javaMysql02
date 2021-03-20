package main;

import java.awt.event.*;

//import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.*;

public class FormularioTexArea extends JFrame 
implements ActionListener,
KeyListener{		
	private JLabel label;
	private JTextField text;
	private JTextArea area;
	private JButton boton1;	
	private JScrollPane pane1;	
	private String texto;
	//contrucctor
	public FormularioTexArea() {
		setTitle("titulo del formulario");
		setLayout(null);		
		label = new JLabel("Usuario: ");
		label.setBounds(10,10,100,30);		
		add(label);
		//y=40, x=110
		text = new JTextField();
		text.setBounds(120, 10, 360, 30);
		add(text);	
		text.addKeyListener(this);;
		//y=40
		//nueva fila +10
		
		area = new JTextArea();
		area.setBounds(10,60, 470, 200);
		add(area);			
		//260, suma setBounds(x,y, ancho, alto);
		//y+alto+10px separacion
		
		pane1 = new JScrollPane(area);
		pane1.setBounds(10, 60, 470, 200);
		add(pane1);
		
		
		
		boton1= new JButton("Agregar");
		boton1.setBounds(10, 270, 100, 30);
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

	//evento click, implements ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//this.label1.setText("has apretado botones");
		if (e.getSource()==boton1) {
			texto= area.getText();
			texto += text.getText()+ "\n";			
			area.setText(texto);
			text.setText("");
		}			
	}


	//evento click, implements KeyListener
	//al pulsar la tecla
	@Override
	public void keyPressed(KeyEvent e) {
		// pulso un enter
		if (e.getSource()==text) {			
			if (e.getKeyCode()== KeyEvent.VK_ENTER) {
				texto= area.getText();
				texto += text.getText()+ "\n";			
				area.setText(texto);
				text.setText("");
			}
		}
	}
	

	//keyReleased: al soltar la tecla.
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//keyTyped:al pulsar y soltar la tecla.
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
