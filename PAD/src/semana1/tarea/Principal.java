package semana1.tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class Principal {

	public static void main(String[] args) {
		
		
		Locale.setDefault(new Locale("es","ES"));
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("No tienes el friver en tu build-path?");
			e.printStackTrace();
			return;
		}
		
		
		
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "INSTITUTO",
					"INSTITUTO");
		}
		catch(SQLException e){
			System.out.println("Error al conectarse!!");
			e.printStackTrace();
			return;
		}
		
		
		try {			 
			Statement sentencia = connection.createStatement();
			String consulta = "SELECT count(*) FROM MATRICULAS WHERE ID_CURSO=6";
			ResultSet resultado = sentencia.executeQuery(consulta);
			int count=0;
			while(resultado.next()){
				
				count = resultado.getInt(1);
				
			}
			
			System.out.println("La cantidad de matrículas en el curso 6 es:" + count);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
