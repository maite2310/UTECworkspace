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
			Locale.setDefault(new Locale("es","ES"));
			databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);
			System.out.println("Se cre� la conexi�n con �xito");
		}
		catch(Exception e){
			System.out.println("Error creando la conexi�n a la base de datos");
			e.printStackTrace();
		}
	}

//		
//	static{
//		
//		Locale.setDefault(new Locale("es","ES"));
//		try {
//			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//		} catch (ClassNotFoundException e) {
//
//			System.out.println("No tienes el driver en tu build-path?");
//			e.printStackTrace();
//		}
//
//		System.out.println("Se encontr� el Driver para Oracle DB");
//		try {
//
//			databaseConnection = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", "INSTITUTO",
//					"INSTITUTO");
//			System.out.println("Se cre� la conexi�n con �xito");
//
//		} catch (SQLException e) {
//
//			System.out.println("Error al conectase!!");
//			e.printStackTrace();
//
//		}
//		
//	}
	
	public static Connection getConnection(){
		return databaseConnection;
	}

}
