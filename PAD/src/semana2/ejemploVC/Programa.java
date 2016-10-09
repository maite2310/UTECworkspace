package semana2.ejemploVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;

import java.util.Locale;

public class Programa {

	public static void main(String[] argv) {

		Locale.setDefault(new Locale("es","ES"));
		System.out.println("-------- Test de conexion con Oracle DB ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("No tienes el driver en tu build-path?");
			e.printStackTrace();
			return;

		}

		System.out.println("Se encontró el Driver para Oracle DB");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "INSTITUTO",
					"INSTITUTO");
			

		} catch (SQLException e) {

			System.out.println("Error al conectase!!");
			e.printStackTrace();
			return;

		}

		if (connection == null) {
			
			System.out.println("Error creando la conexión!!");
		}
		
		//Imprime todos los cursos correspondiente a la materia de nombre 'Arquitectura de Sistemas' persistidos en la base de datos INSTITUTO
		testConsulta2(connection);
		//testConsulta3(connection);
	}
	
	public static void testConsulta2(Connection connection){
		
		System.out.println();
		System.out.println("-------- Consulta de Prueba 2 ------");
		
		try {
			
			Statement sentencia = connection.createStatement();
			String consulta = "SELECT * FROM CURSOS WHERE ID_DOCENTE = 1 AND MODALIDAD = 'Online'";

			System.out.println("Ejecutando: " + consulta);
			
			ResultSet resultado = sentencia.executeQuery(consulta);
			
			
			LinkedList<Curso> cursos = new LinkedList<>();
			
			while (resultado.next()){
				
				int idCurso = resultado.getInt("ID_CURSO");
				
				int idDocente = resultado.getInt("ID_DOCENTE");
				int idMateria = resultado.getInt("ID_MATERIA");
				
				
				Date fechaInicio = new Date(resultado.getDate("FEC_INICIO").getTime());
				Date fechaFin = new Date(resultado.getDate("FEC_FIN").getTime());
				String modalidad = resultado.getString("MODALIDAD");
				
				Curso curso = new Curso(idCurso, idDocente, idMateria, fechaInicio, fechaFin, modalidad);
				cursos.add(curso);
				
			}
			
			imprimirCursos(cursos);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testConsulta3(Connection connection){
		
		System.out.println();
		System.out.println("-------- Consulta de Prueba 3 ------");
		
		try {
			
			PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM CURSOS WHERE ID_DOCENTE = ? AND MODALIDAD = ?");
			sentencia.setLong(1, 1);
			sentencia.setString(2, "Online");
			ResultSet resultado = sentencia.executeQuery();
						
			LinkedList<Curso> cursos = new LinkedList<>();
			
			while (resultado.next()){
				
				int idCurso = resultado.getInt("ID_CURSO");
				
				int idDocente = resultado.getInt("ID_DOCENTE");
				int idMateria = resultado.getInt("ID_MATERIA");
				
				Date fechaInicio = new Date(resultado.getDate("FEC_INICIO").getTime());
				Date fechaFin = new Date(resultado.getDate("FEC_FIN").getTime());
				String modalidad = resultado.getString("MODALIDAD");
				
				Curso curso = new Curso(idCurso, idDocente, idMateria, fechaInicio, fechaFin, modalidad);
				cursos.add(curso);
				
			}
			
			imprimirCursos(cursos);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	private static void imprimirCursos(LinkedList<Curso> cursos){
		
		
		
			System.out.println();
			System.out.println("Listando cursos obtenidos:");
			System.out.println();
			
			
			for (Curso c : cursos){
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				
				System.out.println("  Id Curso: " + c.getIdCurso());
				System.out.println("  Id Docente: " + c.getIdDocente());
				System.out.println("  Id Materia: " + c.getIdMateria());
				System.out.println("  Fec Inicio: " + sdf.format(c.getFechaInicio()));
				System.out.println("  Fec Fin: " + sdf.format(c.getFechaFin()));
				System.out.println("  Modalidad: " + c.getModalidad());
				System.out.println();
	
			}
		
	}
	
	
	
	

}
