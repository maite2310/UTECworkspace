package semana2.ejemplo1.DAO;

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
	
	
	static{
		try{
			//Locale.setDefault(new Locale("es","ES"));
			databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);
		}
		catch(Exception e){
			System.out.println("Error creando la conexión a la base de datos");
		}
	}
	
	public static Connection getConnection(){
		return databaseConnection;
	}

}
