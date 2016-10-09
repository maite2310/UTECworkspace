package semana3.tarea.sol.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class DatabaseManager {
	
	private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "AGENDA";
	private static String CLAVE = "AGENDA";
	
	
	static{
		try{
			Locale.setDefault(new Locale("es","ES"));
			databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);
		}
		catch(Exception e){
			System.out.println("Error creando la conexión a la base de datos");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return databaseConnection;
	}

}
