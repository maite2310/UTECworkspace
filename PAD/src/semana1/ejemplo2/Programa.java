package semana1.ejemplo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Locale;

public class Programa {

	public static void main(String[] argv) {
		//Locale.setDefault(new Locale("es","ES"));
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

		} catch (SQLException e) {

			System.out.println("Error al conectase!!");
			e.printStackTrace();
			return;

		}
		
		// intentanms ejecutar la consulta y mostrar el resultado
		
		try{
			HashMap<String, Integer> cursos = contarCursos(connection);
			
			System.out.println("La cantidad de Cursos ONLINE es: " + cursos.get("Online"));
			System.out.println("La cantidad de Cursos PRESENCIAL es: " + cursos.get("Presencial"));
			
		}
		catch (SQLException e){
			System.out.println("Error ejecutando la consulta de CURSOS");
		}

	}

	private static HashMap<String, Integer> contarCursos(Connection connection) throws SQLException {

		// Hacemos la consulta a la base de datos
		
		Statement sentencia = connection.createStatement();
		String consulta = "SELECT * FROM CURSOS";
		ResultSet resultado = sentencia.executeQuery(consulta);
		
		// Inicializamos el mapa inicialmente 0 cursos de cada tipo
		//La clave del mapa es la modalidad del curso y el valor es la cantidad de cursos de esa modalidad que hay en la base de datos
		HashMap<String,Integer> cursos = new HashMap<>();
		
		
		cursos.put("Online", 0);
		cursos.put("Presencial", 0);
		
		// Recorremos la lista de resultados de la consulta
		
		while (resultado.next()){
			
			// obtengo del registro actual el valor de la columna modalidad
			String modalidad = resultado.getString("MODALIDAD");
			
			// obetenemos del mapa, con clave la modalidad obtenida, el valor actual de cursos (que lleva la cuenta)
			int cantidadActual = cursos.get(modalidad);
			
			// le sumamos uno a este valor
			cantidadActual++;
			
			// actualizamos el valor en el mapa de la clave modalidad
			cursos.put(modalidad, cantidadActual);
			
		}
		
		// retornamos el mapa de cursos
		return cursos;

	}

}
