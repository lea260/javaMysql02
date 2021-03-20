package main;
import javax.swing.*;


public class Formulario extends JFrame{
	private JLabel label1;
	private JLabel label2;
	public Formulario() {
		setLayout(null);
		label1 = new JLabel("Uno");
		label1.setBounds(10,10,100,20);		
		super.add(label1);//add(label1)
		label2 = new JLabel("Dos");
		label2.setBounds(10,180,100,20);		
		add(label2);//add(label1)
	}
}