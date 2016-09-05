package semana3.ejemplo1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import semana3.ejemplo1.entidades.Carrera;

public class DAOCarreras {
	private static final String ALL_CARRERAS = "SELECT * FROM CARRERAS";
	//private static final String CURSOS_MATERIA = "SELECT * FROM CURSOS WHERE ID_MATERIA=?";
	private static final String INSERT = "INSERT INTO CARRERAS (ID_CARRERA,NOMBRECARRERA, NIVEL) values (?,?, ?)";
	private static final String UPDATE = "UPDATE CARRERAS SET NOMBRECARRERA = ?, NIVEL=? WHERE ID_CARRERA=?";
	private static final String DELETE = "DELETE FROM CARRERAS WHERE ID_CARRERA=?"; 
	private static final String SELECT_CARRERA = "SELECT * FROM CARRERAS WHERE ID_CARRERA=?";
	private static final String SELECT_CARRERA_BY_NOMBRE = "SELECT * FROM CARRERAS WHERE NOMBRECARRERA=?";
	
	//Inserta el curso pasado por parámetro
	public static boolean insert(Carrera carrera){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
			statement.setLong(1, carrera.getIdCarrera());
			statement.setString(2, carrera.getNombre());
			statement.setString(3, carrera.getNivel());
									
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit(Carrera carrera){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE);
			statement.setString(1, carrera.getNombre());
			statement.setString(2, carrera.getNivel());
			statement.setLong(3, carrera.getIdCarrera());						
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
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
	

	//Obtiene todos los cursos almacenados
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
	
	//Obtiene una carrera determinado
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
		
		Carrera carrera = new Carrera(idCarrera, nombre, nivel);
		
		return carrera;
	}
}
