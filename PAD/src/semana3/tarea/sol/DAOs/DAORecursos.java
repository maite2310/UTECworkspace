package semana3.tarea.sol.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import semana3.tarea.sol.entidades.Recurso;


public class DAORecursos {
	private static final String ALL = "SELECT * FROM RECURSOS";
	private static final String INSERT = "INSERT INTO RECURSOS (IDRECURSO,NOMBRE) SELECT MAX(IDRECURSO)+1,? FROM RECURSOS";	
	private static final String UPDATE = "UPDATE RECURSOS SET NOMBRE = ? WHERE IDRECURSO=?";
	private static final String DELETE = "DELETE FROM RECURSOS WHERE IDRECURSO=?"; 
	private static final String SELECT = "SELECT * FROM RECURSOS WHERE IDRECURSO=?";
	
	
	//Inserta la carrera pasada por parámetro
	public static boolean insert(Recurso recurso){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
			
			statement.setString(1, recurso.getNombre());
			
			statement.execute();
								
			return true;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Modifica los campos de la carrera pasada como parámetro
	public static boolean edit(Recurso recurso){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE);
			statement.setString(1, recurso.getNombre());
	
			statement.setLong(2, recurso.getIdRecurso());						
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Borra la carrera pasada como parámetro
	public static boolean delete(Recurso recurso){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE);
			statement.setLong(1, recurso.getIdRecurso());
			
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	

	//Obtiene todos las carreras almacenadas
	public static LinkedList<Recurso> findAll(){
		LinkedList<Recurso> recursos = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				Recurso rec = getRecursoFromResultSet(resultado);				
				recursos.add(rec);				
			}
			return recursos;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	//Obtiene una carrera determinada
	public static Recurso find(long idRecurso){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT);
			statement.setLong(1, idRecurso);
									
			ResultSet resultado = statement.executeQuery();
			Recurso recurso = null;
			while (resultado.next()){				
				recurso = getRecursoFromResultSet(resultado);	
			}
			return recurso;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
	}
			
	//Funcion auxiliar que traduce un registro a una instancia de carrera
	private static Recurso getRecursoFromResultSet(ResultSet resultado) throws SQLException{
		int idRecurso = resultado.getInt("IDRECURSO");		
		String nombre = resultado.getString("NOMBRE");
				
		Recurso rec = new Recurso(idRecurso, nombre);
		
		return rec;
	}
}
