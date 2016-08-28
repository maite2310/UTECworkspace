package semana2.ejemplo1Solucion.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import semana2.ejemplo1Solucion.entidades.Materia;


public class DAOMaterias {
	
	private static final String ALL_MATERIAS = "SELECT * FROM MATERIAS";	
	private static final String INSERT_MATERIA = "INSERT INTO MATERIAS (ID_MATERIA, NOMBRE, ID_CARRERA) values (?,?, ?)";
	private static final String UPDATE_MATERIA = "UPDATE MATERIAS SET NOMBRE = ?, ID_CARRERA=? WHERE ID_MATERIA=?";
	private static final String DELETE_MATERIA = "DELETE FROM MATERIAS WHERE ID_MATERIA=?"; 
	private static final String MATERIA_ID = "SELECT * FROM MATERIAS WHERE ID_MATERIA=?";
	private static final String MATERIA_NOMBRE = "SELECT * FROM MATERIAS WHERE NOMBRE=?";
	
	//Inserta el curso pasado por parámetro
	public static boolean insert(Materia materia){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_MATERIA);
			statement.setLong(1, materia.getIdMateria());
			statement.setString(2, materia.getNombre());
			statement.setLong(3, materia.getIdCarrera());
												
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit(Materia materia){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_MATERIA);
			
			statement.setString(1, materia.getNombre());
			statement.setLong(2, materia.getIdCarrera());
			statement.setLong(3, materia.getIdMateria());
												
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(Materia materia){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_MATERIA);
			statement.setLong(1, materia.getIdMateria());
			
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	

	//Obtiene todos los cursos almacenados
	public static LinkedList<Materia> findAll(){
		LinkedList<Materia> materias = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_MATERIAS);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				Materia materia = getMateriaFromResultSet(resultado);				
				materias.add(materia);				
			}
			return materias;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	//Obtiene un curso determinado
	public static Materia find(long idMateria){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(MATERIA_ID);
			statement.setLong(1, idMateria);
									
			ResultSet resultado = statement.executeQuery();
			Materia materia = null;
			while (resultado.next()){				
				materia  = getMateriaFromResultSet(resultado);	
			}
			return materia ;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
	}
	
	public static Materia findByNombre(String nombre){
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(MATERIA_NOMBRE);
			statement.setString(1, nombre);
									
			ResultSet resultado = statement.executeQuery();
			Materia materia = null;
			while (resultado.next()){				
				materia  = getMateriaFromResultSet(resultado);	
			}
			return materia ;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
		
		
	//Funcion auxiliar que traduce un registro a una instancia de carrera
	private static Materia getMateriaFromResultSet(ResultSet resultado) throws SQLException{
		int idMateria = resultado.getInt(1);
		String nombre = resultado.getString(2);
		int idCarrera = resultado.getInt(3);
		
		Materia materia = new Materia(idMateria, nombre, idCarrera);
		
		return materia;
	}
	
}
