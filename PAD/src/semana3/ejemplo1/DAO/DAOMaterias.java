package semana3.ejemplo1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import semana3.ejemplo1.entidades.Carrera;
import semana3.ejemplo1.entidades.Materia;

public class DAOMaterias {
	private static final String ALL_MATERIAS = "SELECT * FROM MATERIAS";
	private static final String INSERT = "INSERT INTO MATERIAS (ID_MATERIA,NOMBRE, ID_CARRERA) SELECT MAX(ID_MATERIA)+1, ?, ?  FROM MATERIAS";
	private static final String UPDATE = "UPDATE MATERIAS SET NOMBRE = ?, ID_CARRERA=? WHERE ID_MATERIA=?";
	private static final String DELETE = "DELETE FROM MATERIAS WHERE ID_MATERIA=?"; 
	private static final String SELECT_MATERIA = "SELECT * FROM MATERIAS WHERE ID_MATERIA=?";
	private static final String SELECT_MATERIACARRERA = "SELECT * FROM MATERIAS INNER JOIN CARRERAS ON MATERIAS.ID_CARRERA = CARRERAS.ID_CARRERA WHERE MATERIAS.NOMBRE=? AND CARRERAS.NOMBRECARRERA = ?";
	private static final String GET_MAX_ID= "SELECT MAX(ID_MATERIA) FROM MATERIAS";
	
	//Inserta la materia pasada por parámetro
	public static boolean insert(Materia materia){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
			
			statement.setString(1, materia.getNombre());
			statement.setLong(2, materia.getCarrera().getIdCarrera());
			
			statement.execute();
								
			return true;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Edita los campos de la materia pasada
	public static boolean edit(Materia materia){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE);
			
			statement.setString(1, materia.getNombre());
			statement.setLong(2, materia.getCarrera().getIdCarrera());
			statement.setLong(3, materia.getIdMateria());
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Borra la materia pasada como parámetro
	public static boolean delete(Materia materia){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE);
			statement.setLong(1, materia.getIdMateria());
			
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	

	//Obtiene todos las materias almacenadas
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
	
	//Obtiene una materia buscando por id
	public static Materia find(long idMateria){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT_MATERIA);
			statement.setLong(1, idMateria);
									
			ResultSet resultado = statement.executeQuery();
			Materia materia = null;
			while (resultado.next()){				
				materia = getMateriaFromResultSet(resultado);	
			}
			return materia;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
	
	//Obtiene una materia buscando por nombre de la materia y nombre de carrera
	public static Materia findByNombreAndCarrera(String nombre, String carrera){
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT_MATERIACARRERA);
			statement.setString(1, nombre);
			statement.setString(2, carrera);
									
			ResultSet resultado = statement.executeQuery();
			Materia materia = null;
			while (resultado.next()){				
				materia = getMateriaFromResultSet(resultado);	
			}
			return materia;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
		
		
	//Funcion auxiliar que traduce un registro a una instancia de materia
	private static Materia getMateriaFromResultSet(ResultSet resultado) throws SQLException{
		int idMateria = resultado.getInt("ID_MATERIA");		
		String nombre = resultado.getString("NOMBRE");
		long idCarrera = resultado.getLong("ID_CARRERA");
		
		Carrera carrera = DAOCarreras.find(idCarrera);
		
		Materia materia = new Materia(idMateria, nombre, carrera);
		
		return materia;
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
}
