package semana1.teorico;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	
	public static void main(String[] args){
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
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe", "INSTITUTO", "INSTITUTO" );
		}
		catch(SQLException e){
			System.out.println("Error al conectarse!!");
			e.printStackTrace();
			return;
		}
		
		
		try {			 
			Statement sentencia = connection.createStatement();
			String consulta = "SELECT * FROM CURSOS";
			ResultSet resultado = sentencia.executeQuery(consulta);
			
			while(resultado.next()){
				
				int idDocente = resultado.getInt(1);
				int idMateria = resultado.getInt(2);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}

