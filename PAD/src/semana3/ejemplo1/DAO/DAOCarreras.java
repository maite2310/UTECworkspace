package semana3.ejemplo1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import semana3.ejemplo1.entidades.Carrera;
import semana3.ejemplo1.enums.Nivel;

public class DAOCarreras {
	private static final String ALL_CARRERAS = "SELECT * FROM CARRERAS";
	private static final String INSERT = "INSERT INTO CARRERAS (ID_CARRERA,NOMBRECARRERA, NIVEL) SELECT MAX(ID_CARRERA)+1,?,? FROM CARRERAS";	
	private static final String UPDATE = "UPDATE CARRERAS SET NOMBRECARRERA = ?, NIVEL=? WHERE ID_CARRERA=?";
	private static final String DELETE = "DELETE FROM CARRERAS WHERE ID_CARRERA=?"; 
	private static final String SELECT_CARRERA = "SELECT * FROM CARRERAS WHERE ID_CARRERA=?";
	private static final String SELECT_CARRERA_BY_NOMBRE = "SELECT * FROM CARRERAS WHERE NOMBRECARRERA=?";
	
	//Inserta la carrera pasada por parámetro
	public static boolean insert(Carrera carrera){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
			
			statement.setString(1, carrera.getNombre());
			statement.setString(2, carrera.getNivel().name());
									
			statement.execute();
								
			return true;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Modifica los campos de la carrera pasada como parámetro
	public static boolean edit(Carrera carrera){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE);
			statement.setString(1, carrera.getNombre());
			statement.setString(2, carrera.getNivel().name());
			statement.setLong(3, carrera.getIdCarrera());						
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Borra la carrera pasada como parámetro
	public static boolean delete(Carrera carrera){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE);
			statement.setLong(1, carrera.getIdCarrera());
			
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	

	//Obtiene todos las carreras almacenadas
	public static LinkedList<Carrera> findAll(){
		LinkedList<Carrera> carreras = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_CARRERAS);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				Carrera carrera = getCarreraFromResultSet(resultado);				
				carreras.add(carrera);				
			}
			return carreras;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	//Obtiene una carrera determinada
	public static Carrera find(long idCarrera){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT_CARRERA);
			statement.setLong(1, idCarrera);
									
			ResultSet resultado = statement.executeQuery();
			Carrera carrera = null;
			while (resultado.next()){				
				carrera = getCarreraFromResultSet(resultado);	
			}
			return carrera;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
	
	//Obtiene una carrera por su nombre
	public static Carrera findByNombre(String nombre){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT_CARRERA_BY_NOMBRE);
			statement.setString(1, nombre);
									
			ResultSet resultado = statement.executeQuery();
			Carrera carrera = null;
			while (resultado.next()){				
				carrera = getCarreraFromResultSet(resultado);	
			}
			return carrera;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
		
		
	//Funcion auxiliar que traduce un registro a una instancia de carrera
	private static Carrera getCarreraFromResultSet(ResultSet resultado) throws SQLException{
		int idCarrera = resultado.getInt("ID_CARRERA");		
		String nombre = resultado.getString("NOMBRECARRERA");
		String nivel = resultado.getString("NIVEL");
		
		Carrera carrera = new Carrera(idCarrera, nombre, Nivel.valueOf( nivel) );
		
		return carrera;
	}
}
