package manejadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	
	private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "VETERINARIA";
	private static String CLAVE = "VETERINARIA";
	
	static{
		try {
			databaseConnection = DriverManager.getConnection(CONNECTION_STRING,USUARIO,CLAVE);
		} catch (SQLException e) {
			System.out.println("Error creando la conexión a la base de datos");
		} 

	}
	
	public static Connection getConnection() {
		
		return databaseConnection;
		
	}

}


