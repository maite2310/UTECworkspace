package semana1.tareaEst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Locale;


public class Programa {

	public static void main(String[] argv) {
		Locale.setDefault(new Locale("es","ES"));
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("No tienes el driver en tu build-path?");
			e.printStackTrace();
			return;

		}
		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "INSTITUTO", "INSTITUTO");

		} 
		catch (SQLException e) {

			System.out.println("Error al conectase!!");
			e.printStackTrace();
			return;

		}
		try{
			Integer matr = contarMatriculas(connection);
			System.out.println("La cantidad de matriculas del curso 6 es: " + matr);
		}
		catch (SQLException e){
			System.out.println("Error ejecutando la consulta de CURSOS");
		}	

	}

	private static Integer contarMatriculas(Connection connection) throws SQLException {

			Statement sentencia = connection.createStatement();
			
			String consulta = "SELECT ID_MATRICULA FROM MATRICULAS WHERE ID_CURSO=6";
			ResultSet resultado = sentencia.executeQuery(consulta);
			Integer matr = 0;
			
			while (resultado.next()){
				matr++;
				
			}
				
			return matr;
			
	}
}



			