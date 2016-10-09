package semana3.tarea.sol.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import semana3.tarea.sol.DAOs.DatabaseManager;
import semana3.tarea.sol.entidades.Cita;
import semana3.tarea.sol.entidades.Recurso;


public class DAOCita {
	private static final String ALL = "SELECT * FROM CITAS";
	private static final String INSERT = "INSERT INTO CITAS (IDCITA,TIMESTAMP,HORASDURACION) VALUES( ?,?,?)";	
	private static final String UPDATE = "UPDATE CITAS SET TIMESTAMP = ?, HORASDURACION=? WHERE IDCITA=?";
	private static final String DELETE = "DELETE FROM CITAS WHERE IDCITA=?"; 
	private static final String SELECT = "SELECT * FROM CITAS WHERE IDCITA=?";
	private static final String GET_MAX_ID= "SELECT MAX(IDCITA) FROM CITAS";
	
	private static final String SELECT_RECURSOS_CITA = "SELECT * FROM CITAS_RECURSOS WHERE IDCITA=?";
	private static final String INSERT_RECURSOS_CITA = "INSERT INTO CITAS_RECURSOS (IDCITA,IDRECURSO) VALUES (?,?)";
	
	//Inserta la carrera pasada por parámetro
	public static boolean insert(Cita cita){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
			
			long maxIDUtilizado= getMaxId();
			statement.setLong(1, maxIDUtilizado+1);
			statement.setLong(2, cita.getTimestamp());
			statement.setInt(3, cita.getDuracion());
			
			statement.execute();
			
			insertRecursosCita(maxIDUtilizado+1, cita.getRecursos());
								
			return true;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Modifica los campos de la carrera pasada como parámetro
	public static boolean edit(Cita cita){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE);
			statement.setLong(1, cita.getTimestamp());
			statement.setInt(2, cita.getDuracion());
	
			statement.setLong(3, cita.getIdCita());						
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Borra la carrera pasada como parámetro
	public static boolean delete(Cita cita){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE);
			statement.setLong(1, cita.getIdCita());
			
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	

	//Obtiene todos las carreras almacenadas
	public static LinkedList<Cita> findAll(){
		LinkedList<Cita> citas = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				Cita cita = getCitaFromResultSet(resultado);				
				citas.add(cita);				
			}
			return citas;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	//Obtiene una carrera determinada
	public static Cita find(long idCita){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT);
			statement.setLong(1, idCita);
									
			ResultSet resultado = statement.executeQuery();
			Cita cita = null;
			while (resultado.next()){				
				cita = getCitaFromResultSet(resultado);	
			}
			return cita;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
	}
			
	//Funcion auxiliar que traduce un registro a una instancia de carrera
	private static Cita getCitaFromResultSet(ResultSet resultado) throws SQLException{
		int idCita = resultado.getInt("IDRECURSO");		
		long timestamp = resultado.getLong("TIMESTAMP");
		int duracion = resultado.getInt("HORASDURACION");
				
		LinkedList<Recurso> recursosCita = getRecursosFromIdCita(idCita);
		
		Cita cita = new Cita(idCita, timestamp, duracion, recursosCita);
				
		return cita;
	}
	
	public static long getMaxId(){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(GET_MAX_ID);
												
			ResultSet resultado = statement.executeQuery();
			long maxId = 0;
			while (resultado.next()){				
				maxId = resultado.getLong(1);
			}
			return maxId;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	/* VA A TABLA CITAS_RECURSOS */
	private static LinkedList<Recurso> getRecursosFromIdCita(long idCita){
		LinkedList<Recurso> recursos = new LinkedList<>();
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT_RECURSOS_CITA);
			statement.setLong(1,idCita);
						
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				long idRecurso = resultado.getLong("IDRECURSO");
				Recurso rec = DAORecursos.find(idRecurso);
				recursos.add(rec);
			}
			return recursos;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	private static boolean insertRecursosCita(long idCita, LinkedList<Recurso> recursos){
		for(Recurso rec : recursos){
			
			try{
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_RECURSOS_CITA);
				
				statement.setLong(1, idCita);
				statement.setLong(2, rec.getIdRecurso());
				
				statement.execute();
									
				
				
			}
			catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
