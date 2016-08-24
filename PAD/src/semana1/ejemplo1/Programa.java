package semana1.ejemplo1;

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

		if (connection != null) {
			System.out.println("Conexión creada con éxito, puede tomar el contro lde tu base de Datos!");
		} else {
			System.out.println("Error creando la conexión!!");
		}
		
		// Primera consulta
		testConsulta1(connection);
		
		
	}
	
	public static void testConsulta1(Connection connection){
		
		System.out.println();
		System.out.println("-------- Consulta de Prueba ------");
		
		try {
			System.out.println("Ejecutando: SELECT * FROM CURSOS WHERE ID_CURSI");
			
			
			Statement sentencia = connection.createStatement();
			String consulta = "SELECT * FROM CURSOS WHERE ID_CURSO=1";
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
			
			System.out.println();
			System.out.println("Listando objetos obtenidos:");
			System.out.println();
			
			for (Curso c : cursos){
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				
				System.out.println("Id Curso: " + c.getIdCurso());
				System.out.println("Id Docente: " + c.getIdDocente());
				System.out.println("Id Materia: " + c.getIdMateria());
				System.out.println("Fec Inicio: " + sdf.format(c.getFechaInicio()));
				System.out.println("Fec Fin: " + sdf.format(c.getFechaFin()));
				System.out.println("Modalidad: " + c.getModalidad());
				System.out.println();

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
