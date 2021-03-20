package main;

import java.awt.Point;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import datos.PersonaDto;
import persistencia.PersonaDao;


enum modo {
	  edit,
	  normal,
	  delete
	}


public class Table extends JFrame 
implements ActionListener {
	private int indiceEdit;
	private int id;
	private String nombre;
	private modo modo1;
	private JLabel label1;
	private JTextField text1;
	private JButton botonAgregar;
	private JButton botonEditar;
	private JButton botonEliminar;	
	private JTable tabla;
	private JScrollPane pane1;
	private DefaultTableModel modelo;
	private final String[] columnas = {"Id", "Nombre"};
	private static Integer indice=1;
	public Table() {
		modo1 = modo.normal;
		setLayout(null);
		label1 = new JLabel("Usuario: ");
		label1.setBounds(10,10,100,30);		
		add(label1);
		
		text1 = new JTextField();
		text1.setBounds(120,10, 150, 30);
		add(text1);
		
		
		//40
		botonAgregar= new JButton("Agregar");
		botonAgregar.setBounds(10, 60, 100, 30);
		add(botonAgregar);
		botonAgregar.addActionListener(this);
		
		botonEditar= new JButton("Editar");
		botonEditar.setBounds(120, 60, 100, 30);
		add(botonEditar);
		botonEditar.addActionListener(this);
		
		
		botonEliminar= new JButton("Eliminar");
		botonEliminar.setBounds(230, 60, 100, 30);
		add(botonEliminar);
		botonEliminar.addActionListener(this);
		
		
		agregarDatos();
		
		//tabla = new JTable();
		tabla.setBounds(10, 100, 470, 200);
		tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		add(tabla);
		
		
		/*modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnas);
		tabla.setModel(modelo);*/
		
		//agregarDatos();
					
		//260, suma setBounds(x,y, ancho, alto);
		//y+alto+10px separacion
		
		pane1 = new JScrollPane(tabla);
		pane1.setBounds(10, 100, 470, 200);
		add(pane1);
		//boton1.addActionListener((ActionListener) this);		
	}	
		
	private void agregarDatos() {		
		//String[][] data = new String[][] {{"101", "Ramesh"}, {"102", "Adithya"}, {"103", "Jai"}, {"104", "Sai"}};
		//String[][] data
		String[] columnNames = new String[] {"ID", "Name"};
		this.modelo = new DefaultTableModel(null, columnNames);
	    //this.modelo = new DefaultTableModel(data, columnNames);
	    this.tabla = new JTable(modelo);
	    try {
			PersonaDao personaDao = new PersonaDao(); 
			ArrayList<PersonaDto> listaPersonas = personaDao.listarPersonas();
			Object[][] datosAux = new Object[][] {{"101", "Ramesh"}, {"102", "Adithya"}, {"103", "Jai"}, {"104", "Sai"}};
			int largo = listaPersonas.size();
	        for (Integer i = 0; i < largo; i++) {
	        	indice = (Integer) i;
	            // Creamos un nuevo renglon para la tabla
	        	PersonaDto personaDto = listaPersonas.get(indice);
	            String[] datos = { String.valueOf(personaDto.getId()), 
	            		(String) personaDto.getNombre()};
	            // Agregamos los datos a la tabla
	            this.modelo.addRow(datos);
	        }
		} catch (SQLException e) {
			// TODO: handle exception
		}
	     
	    
	    
		/*
		Object[][] datosAux = new Object[][] {{"101", "Ramesh"}, {"102", "Adithya"}, {"103", "Jai"}, {"104", "Sai"}};
		int largo = datosAux.length;
        for (Integer i = 0; i < largo; i++) {
        	indice = (Integer) i;
            String mensaje = i + " producto";

            // Creamos un nuevo renglon para la tabla
            String[] datos = {(String)datosAux[i][0] , (String)datosAux[i][1] };
            // Agregamos los datos a la tabla
            modelo.addRow(datos);
        }*/
    }
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if (e.getSource()==botonEliminar) {
			id = Integer.parseInt((String)modelo.getValueAt(tabla.getSelectedRow(), 0));
			this.indiceEdit = tabla.getSelectedRow();
			int dialogResult = JOptionPane.showConfirmDialog (null, 
					"Desea eliminar id:" + id,
					"Warning",JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION) {				
				modelo.removeRow(this.indiceEdit);
				JOptionPane.showMessageDialog(null, "Exitosamente elimanda");
			}
			
		} else if (e.getSource()==botonAgregar) {
			indice++;
			String[] datos = {indice.toString(), text1.getText()};
			text1.setText("");
            // Agregamos los datos a la tabla
            modelo.addRow(datos);//modelo.setValueAt(aValue, row, column);
            //pane1.getViewport().setViewPosition(new Point(0,0));
            JScrollBar vertical = pane1.getVerticalScrollBar();
            vertical.setValue( vertical.getMaximum());            
            //modelo.setColumnCount(modelo.getRowCount());;
		} else if (e.getSource()==botonEditar) {			
			if (tabla.getSelectedRow() != -1) {
				switch (this.modo1) { 
				case normal:
					botonEditar.setText("Confirmar");
					this.modo1 = modo.edit;		
					this.indiceEdit = tabla.getSelectedRow();
		            String codigo = (String) modelo.getValueAt(tabla.getSelectedRow(), 0);
		            id = Integer.parseInt(codigo);
		            nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
		            // Lo imprimimos en pantalla
		            System.out.println(codigo);
		            System.out.println(nombre);
		            text1.setText(nombre);					
					break;
				case edit:
					this.modo1 = modo.normal;
					botonEditar.setText("Editar");					
					String texto =  text1.getText();
					//actualizar modelo					
					modelo.setValueAt(texto, this.indiceEdit, 1);										
					break;
				default:
					
				}							
				
	        } else {
	            System.out.println("Seleccione un renglon primero");
	        }
		}//end editar		
	}
}