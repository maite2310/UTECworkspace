package semana1.tareaEst;


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
			System.out.println("Ejecutando: SELECT * FROM MATRICULA");
			
		    Statement sentencia = (Statement) connection.createStatement()	;
			String consulta = "SELECT COUNT (*) FROM MATRICULAS WHERE ID_CURSO = 71";
			ResultSet resultado= ((java.sql.Statement) sentencia).executeQuery(consulta);
			
			
			
			while (resultado.next()){
				
				
				for (int i=1;i<= resultado.getMetaData().getColumnCount();i++){
					
					System.out.println( "La cantidad de Matriculas es:"  + resultado.getString(i));
			
			}
		}
			
			System.out.println();
			
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	













	}


