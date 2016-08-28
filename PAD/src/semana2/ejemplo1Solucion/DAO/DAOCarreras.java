package semana2.ejemplo1Solucion.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import semana2.ejemplo1Solucion.entidades.Carrera;
import semana2.ejemplo1Solucion.entidades.Curso;

public class DAOCarreras {
	
	private static final String ALL_CARRERAS = "SELECT * FROM CARRERAS";	
	private static final String INSERT_CARRERAS = "INSERT INTO CARRERAS (ID_CARRERA, NOMBRECARRERA, NIVEL) values (?,?, ?)";
	private static final String UPDATE_CARRERAS = "UPDATE CARRERAS SET NOMBRECARRERA = ?, NIVEL=? WHERE ID_CARRERA=?";
	private static final String DELETE_CARRERAS = "DELETE FROM CARRERAS WHERE ID_CARRERA=?"; 
	private static final String CARRERAS_ID = "SELECT * FROM CARRERAS WHERE ID_CARRERA=?";
	private static final String CARRERAS_NOMBRE = "SELECT * FROM CARRERAS WHERE NOMBRECARRERA=?";
	
	//Inserta el curso pasado por parámetro
	public static boolean insert(Carrera carrera){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_CARRERAS);
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
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_CARRERAS);
			
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
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_CARRERAS);
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
				carreras.add(carrera );				
			}
			return carreras;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	//Obtiene un curso determinado
	public static Carrera find(long idCarrera){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CARRERAS_ID);
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
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CARRERAS_NOMBRE);
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
		int idCarrera = resultado.getInt(1);
		String nombre = resultado.getString(2);
		String nivel = resultado.getString(3);
		
		Carrera carrera = new Carrera(idCarrera, nombre, nivel);
		
		return carrera ;
	}
	
}
