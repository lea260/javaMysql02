package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

	private static Connection conexion = null;
	public static Connection getConexion() {
		String user = "usuario02";
		String password = "usuario02";
		String url = "jdbc:mysql://localhost:3306/base02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);			
			// TODO: handle exception
		} catch (SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
			
			// TODO: handle exception
		}
		return conexion;
	}
	public static void cerrar() {
		try {
			conexion.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
