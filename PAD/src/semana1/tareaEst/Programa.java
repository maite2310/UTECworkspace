package semana1.tareaEst;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("es","ES"));
		
		// Verificamos que se encuentre el driver JDBC previo a establecer la conexión para
		// evitar un error posterior
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		}catch(ClassNotFoundException unaException){
			System.out.println("No tienes el driver en tu build-path");
			unaException.printStackTrace();
			return;
		}
		
		// Creamos un objeto del tipo Connection nulo, el cuál utilizaremos para establecer la interacción
		// con la BD INSTITUTO
		Connection unaConexion = null;
		
		try{
			String url  = "jdbc:oracle:thin:@localhost:1521:xe";
			unaConexion = DriverManager.getConnection(url, "INSTITUTO","INSTITUTO");
						
		}catch(SQLException e){
			System.out.println("Error al intentar establecer conexión con la Base de Datos");
			e.printStackTrace();
			return;
			
		}
		
        if (unaConexion == null) {
			System.out.println("Error creando la conexión");
		}
        
        // Le enviamos al método la conexión a la BD para que pueda ejecutar la consulta
        contarMatriculas(unaConexion);
             	
	}
	
	// El método estático contarMatriculas imprime en consola la cantidad de Matrículas que tiene
	// el Curso con id=6 almacenados en la base de datos
	public static void contarMatriculas(Connection unaConexion){
    	
		int contadorMat = 0;
		
    	try{
    		// Creamos un objeto Statement a partir de la conexión para poder realizar la
    		// consulta a la BD
    		Statement sentencia = unaConexion.createStatement();
    		String consultaSql = "SELECT * FROM MATRICULAS INNER JOIN CURSOS ON MATRICULAS.ID_CURSO = CURSOS.ID_CURSO WHERE CURSOS.ID_CURSO=6";
    		// El objeto ResultSet nos permite manipular el resultado de la ejecución de la consulta
    		ResultSet resultado = sentencia.executeQuery(consultaSql);
    		    		
    		// Procesando el resultado obtenido de la consulta a la base de datos, en este caso
    		// únicamente necesitamos un contador de los registros
    		while (resultado.next()){
    			contadorMat++;
    		
    		}
    		
    		System.out.println("La cantidad de matriculas en el curso 6 es: " + contadorMat);
    		// Cerramos la conexión para que no continúe gastando recursos
    		sentencia.close();
    		
    		
    	}catch(SQLException ex){
    		System.out.println(ex.getMessage());
    	}
    	
    }

}
