package main;


public class PrimeraClase {
	public static void main(String args[]) {		
		//FormularioBoton form = new FormularioBoton();
		//FormularioTexArea form = new FormularioTexArea();
		//posicion en x, posicion en y
		try {
			Table form = new Table();
			form.setBounds(0, 0, 500, 500);
			form.setVisible(true);
			form.setResizable(false);
			//formulario en el centro
			form.setLocationRelativeTo(null);			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}
}