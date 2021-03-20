package persistencia;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.PersonaDto;

public class PersonaDao {
	public int id;
	public String nombre;
	public PersonaDao() {
		super();
	}
	public PersonaDao(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/*public void insertarPersona() {
		Connection con =null;
		try {
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			
		}
		Connection con= Conexion.getConexion();
		//ResultSet resultado = 
		
		
	}*/
	public ArrayList<PersonaDto> listarPersonas() throws SQLException {
		Connection con = Conexion.getConexion();
		ArrayList<PersonaDto> listaPersonas = new ArrayList<PersonaDto>();
		try {						
			PreparedStatement ps = con.prepareStatement("select * from usuario");
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				PersonaDto personaDao = new PersonaDto(id, nombre);
				listaPersonas.add(personaDao);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			con.close();
		}
		return listaPersonas;
		
		
	}
	
	

}
