package semana2.ejemplo1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import semana2.ejemplo1.entidades.Curso;

public class DAOCursos {
	
	private static final String ALL_CURSOS = "SELECT * FROM CURSOS";
	private static final String CURSOS_MATERIA = "SELECT * FROM CURSOS WHERE ID_MATERIA=?";
	private static final String INSERT_CURSO = "INSERT INTO CURSOS (ID_CURSO,ID_DOCENTE, ID_MATERIA, FEC_INICIO, FEC_FIN, MODALIDAD) values (?,?, ?, ?,?,?)";
	
	//Inserta el curso pasado por parámetro
	public static void insertCurso(Curso curso){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_CURSO);
			statement.setLong(1, curso.getIdCurso());
			statement.setLong(2, curso.getIdDocente());
			statement.setLong(3, curso.getIdMateria());
			//Hay que pasar del tipo date de java.util a date de java.sql, para poder insertar en la BD
			statement.setDate(4, new java.sql.Date( curso.getFechaInicio().getTime()) );
			statement.setDate(5, new java.sql.Date( curso.getFechaFin().getTime()) );
			statement.setString(6, curso.getModalidad());
									
			statement.executeUpdate();
									
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	//Obtiene todos los cursos almacenados
	public static LinkedList<Curso> getCursos(){
		LinkedList<Curso> cursos = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_CURSOS);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				Curso curso = getCursoFromResultSet(resultado);				
				cursos.add(curso);				
			}
						
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return cursos;
	}
	
	//Obtiene todos los cursos de una materia
	public static LinkedList<Curso> getCursos(long idMateria){
		LinkedList<Curso> cursos = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CURSOS_MATERIA);
			statement.setLong(1, idMateria);
									
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()){
				
				Curso curso = getCursoFromResultSet(resultado);				
				cursos.add(curso);				
			}
						
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return cursos;
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
