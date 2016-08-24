package ej2_EmpleadoSuperior.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class DatabaseManager {
	
	private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "INSTITUTO";
	private static String CLAVE = "INSTITUTO";
	
	public static void inicializarConexion() throws SQLException {
		Locale.setDefault(new Locale("es","ES"));
		databaseConnection = DriverManager.getConnection(CONNECTION_STRING,USUARIO,CLAVE); 
		
	}
	
	public static ResultSet ejecutarConsulta(String consulta) throws SQLException{
		
		Statement sentencia = databaseConnection.createStatement();
		return sentencia.executeQuery(consulta);
		
	}

}
