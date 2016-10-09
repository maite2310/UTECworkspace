package semana3.ejemplo1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import semana3.ejemplo1.entidades.Carrera;
import semana3.ejemplo1.entidades.Materia;
import semana3.ejemplo1.entidades.MateriaAnual;

public class DAOMateriasAnual {
	private static final String ALL_MATERIAS = "SELECT * FROM MATERIASANUAL";
	private static final String INSERT_MATERIA = "INSERT INTO MATERIAS (ID_MATERIA,NOMBRE, ID_CARRERA) values (?,?,?)";
	private static final String INSERT = "INSERT INTO MATERIASANUAL (ID_MATERIA, ANIOPAR) values (?, ?)";
	private static final String UPDATE_MATERIA = "UPDATE MATERIA SET NOMBRE = ?, ID_CARRERA=? WHERE ID_MATERIA=?";
	private static final String UPDATE = "UPDATE MATERIASANUAL SET ANIOPAR = ? WHERE ID_MATERIA=?";
	private static final String DELETE_MATERIA = "DELETE FROM MATERIAS WHERE ID_MATERIA=?"; 
	private static final String DELETE = "DELETE FROM MATERIASANUAL WHERE ID_MATERIA=?"; 
	private static final String SELECT_MATERIA = "SELECT * FROM MATERIASANUAL WHERE ID_MATERIA=?";
	private static final String SELECT_MATERIACARRERA = "SELECT * FROM MATERIASANUAL INNER JOIN CARRERAS ON MATERIAS.ID_CARRERA = CARRERAS.ID_CARRERA WHERE MATERIAS.NOMBRE=? AND CARRERAS.NOMBRECARRERA = ?";
	
	//Inserta el curso pasado por parámetro
	public static boolean insert(MateriaAnual materia){
		try{
			//Como materias anual es hijo de materias, primero hay que insertar el registro de materia y luego el registro de materiaAnual (con referencia al ID_MATERIA del primero)
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_MATERIA);
			
			//"INSERT INTO MATERIAS (ID_MATERIA,NOMBRE, ID_CARRERA) values (?,?,?)";
			//Obtengo el ultimo ID_MATERIA utilizado
			long maxIdMaterias = DAOMaterias.getMaxId();
			statement.setLong(1, maxIdMaterias+1);
			statement.setString(2, materia.getNombre());
			statement.setLong(3, materia.getCarrera().getIdCarrera());
			
			statement.execute();
			
			//Luego de que se insertó 
			PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement(INSERT);
			statement2.setLong(1, maxIdMaterias+1);
			if(materia.isDictadaEnAnioPar()){
				statement2.setInt(2, 1);
			}
			else{
				statement2.setInt(2, 0);
			}
			
			statement2.execute();
								
			return true;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit(MateriaAnual materia){
		try{
			//Primero actualizo los campos del padre (en la tabla MATERIAS)
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_MATERIA);
			//"UPDATE MATERIA SET NOMBRE = ?, ID_CARRERA=? WHERE ID_MATERIA=?"
			statement.setString(1, materia.getNombre());
			statement.setLong(2, materia.getCarrera().getIdCarrera());
			statement.setLong(3, materia.getIdMateria());
			int retorno1 = statement.executeUpdate();
			
			//Luego actualizo los campos propios (en la tabla MATERIASANUAL)
			PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement(UPDATE);
			if(materia.isDictadaEnAnioPar()){
				statement2.setInt(1, 1);
			}
			else{
				statement2.setInt(1, 0);
			}
				
			statement2.setLong(2, materia.getIdMateria());
			int retorno2 = statement2.executeUpdate();
								
			return retorno1>0 && retorno2>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(MateriaAnual materia){
		try{
			//Primero borro el registro en la tabla hija MATERIASANUAL
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE);
			statement.setLong(1, materia.getIdMateria());
			
			int retorno = statement.executeUpdate();
			
			//Luego borro el registro en la tabla padre MATERIAS
			PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement(DELETE_MATERIA);
			statement2.setLong(1, materia.getIdMateria());
			
			int retorno2 = statement2.executeUpdate();
								
			return retorno>0 && retorno2>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	

	//Obtiene todos los cursos almacenados
	public static LinkedList<MateriaAnual> findAll(){
		LinkedList<MateriaAnual> materias = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_MATERIAS);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				MateriaAnual materia = getMateriaAnualFromResultSet(resultado);				
				materias.add(materia);				
			}
			return materias;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static MateriaAnual find(long idMateria){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT_MATERIA);
			statement.setLong(1, idMateria);
									
			ResultSet resultado = statement.executeQuery();
			MateriaAnual materia = null;
			while (resultado.next()){				
				materia = getMateriaAnualFromResultSet(resultado);	
			}
			return materia;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
	
	public static MateriaAnual findByNombreAndCarrera(String nombre, String carrera){
		
		try{
			//Como el nombre de la materia está en la tabla padre se tiene que hacer el select en la tabla MATERIAS
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SELECT_MATERIACARRERA);
			statement.setString(1, nombre);
			statement.setString(2, carrera);
									
			ResultSet resultado = statement.executeQuery();
			MateriaAnual materia = null;
			while (resultado.next()){	
				//Se obtiene el idMateria
				long idMateria = resultado.getLong("ID_MATERIA");
				//Con el idMateria se va a buscar la materia a MATERIASANUAL, puede pasar que no esté en esa tabla, 
				materia = find(idMateria);
			}
			return materia;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
		
		
	//Funcion auxiliar que traduce un registro a una instancia de materia
	private static MateriaAnual getMateriaAnualFromResultSet(ResultSet resultado) throws SQLException{
		int idMateria = resultado.getInt("ID_MATERIA");		
		int dictadoParInt =  resultado.getInt(2);
		boolean dictadoPar = false;
		if(dictadoParInt == 1)
			dictadoPar = true;
		
		//Se llama a DAOMaterias para obtener la materia padre
		Materia materiaPadre = DAOMaterias.find(idMateria);
		//Con los datos del padre se crea una instancia de hijo
		MateriaAnual materia = new MateriaAnual(idMateria, materiaPadre.getNombre(), materiaPadre.getCarrera(), dictadoPar);
		
		return materia;
	}
}
