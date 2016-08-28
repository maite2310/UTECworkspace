package semana2.ejemplo1Solucion.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import semana2.ejemplo1Solucion.entidades.Curso;

public class DAOCursos {
	
	private static final String ALL_CURSOS = "SELECT * FROM CURSOS";
	private static final String CURSOS_MATERIA = "SELECT * FROM CURSOS WHERE ID_MATERIA=?";
	private static final String INSERT_CURSO = "INSERT INTO CURSOS (ID_CURSO,ID_DOCENTE, ID_MATERIA, FEC_INICIO, FEC_FIN, MODALIDAD) values (?,?, ?, ?,?,?)";
	private static final String UPDATE_CURSO = "UPDATE CURSOS SET ID_DOCENTE = ?, ID_MATERIA=?, FEC_INICIO=?, FEC_FIN=?, MODALIDAD=? WHERE ID_CURSO=?";
	private static final String DELETE_CURSO = "DELETE FROM CURSOS WHERE ID_CURSO=?"; 
	private static final String CURSOS_ID = "SELECT * FROM CURSOS WHERE ID_CURSO=?";
	
	//Inserta el curso pasado por parámetro
	public static boolean insert(Curso curso){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_CURSO);
			statement.setLong(1, curso.getIdCurso());
			statement.setLong(2, curso.getIdDocente());
			statement.setLong(3, curso.getIdMateria());
			//Hay que pasar del tipo date de java.util a date de java.sql, para poder insertar en la BD
			statement.setDate(4, new java.sql.Date( curso.getFechaInicio().getTime()) );
			statement.setDate(5, new java.sql.Date( curso.getFechaFin().getTime()) );
			statement.setString(6, curso.getModalidad());
									
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit(Curso curso){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_CURSO);
			
			statement.setLong(1, curso.getIdDocente());
			statement.setLong(2, curso.getIdMateria());
			//Hay que pasar del tipo date de java.util a date de java.sql, para poder insertar en la BD
			statement.setDate(3, new java.sql.Date( curso.getFechaInicio().getTime()) );
			statement.setDate(4, new java.sql.Date( curso.getFechaFin().getTime()) );
			statement.setString(5, curso.getModalidad());
			statement.setLong(6, curso.getIdCurso());						
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(Curso curso){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_CURSO);
			statement.setLong(1, curso.getIdCurso());
			
			int retorno = statement.executeUpdate();
								
			return retorno>0;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	

	//Obtiene todos los cursos almacenados
	public static LinkedList<Curso> findAll(){
		LinkedList<Curso> cursos = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_CURSOS);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				Curso curso = getCursoFromResultSet(resultado);				
				cursos.add(curso);				
			}
			return cursos;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	//Obtiene todos los cursos de una materia
	public static LinkedList<Curso> findByIdMateria(long idMateria){
		LinkedList<Curso> cursos = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CURSOS_MATERIA);
			statement.setLong(1, idMateria);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				Curso curso = getCursoFromResultSet(resultado);				
				cursos.add(curso);				
			}
			return cursos;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
	
	//Obtiene un curso determinado
	public static Curso find(long idCurso){
				
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CURSOS_ID);
			statement.setLong(1, idCurso);
									
			ResultSet resultado = statement.executeQuery();
			Curso curso = null;
			while (resultado.next()){				
				curso = getCursoFromResultSet(resultado);	
			}
			return curso;	
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		

	}
		
		
	//Funcion auxiliar que traduce un registro a una instancia de curso
	private static Curso getCursoFromResultSet(ResultSet resultado) throws SQLException{
		int idCurso = resultado.getInt("ID_CURSO");
		
		int idDocente = resultado.getInt("ID_DOCENTE");
		int idMateria = resultado.getInt("ID_MATERIA");
		
		
		Date fechaInicio = new Date(resultado.getDate("FEC_INICIO").getTime());
		Date fechaFin = new Date(resultado.getDate("FEC_FIN").getTime());
		String modalidad = resultado.getString("MODALIDAD");
		
		Curso curso = new Curso(idCurso, idDocente, idMateria, fechaInicio, fechaFin, modalidad);
		
		return curso;
	}
	
}
