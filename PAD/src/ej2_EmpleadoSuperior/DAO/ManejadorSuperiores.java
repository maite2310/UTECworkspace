package ej2_EmpleadoSuperior.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ej2_EmpleadoSuperior.entidades.Superior;

public class ManejadorSuperiores {

	public static void guardarSuperior(Superior superior) throws SQLException {

		// Ejecuto un insert sobre la tabla de Superores con los valores de atributos del superior
		
		String consulta = "INSERT INTO SUPERIOR(CI,NOMBRE,ANIOS_TRABAJO) VALUES('" + superior.getCi() + "','"
				+ superior.getNombre() + "'," + superior.getAñosDeTrabajo() + ")";
		DatabaseManager.inicializarConexion();
		DatabaseManager.ejecutarConsulta(consulta);

	}

	public static Superior obtenerSuperior(String ci) {

		try {
			String consulta = "SELECT * FROM SUPERIOR WHERE CI='" + ci +"'";
			DatabaseManager.inicializarConexion();
			ResultSet resultado = DatabaseManager.ejecutarConsulta(consulta);

			if (resultado.next()) {

				String nombre = resultado.getString("NOMBRE");
				int aniosTRabajo = resultado.getInt("ANIOS_TRABAJO");

				Superior superior = new Superior(ci, nombre, aniosTRabajo);
				return superior;

			} else {
				// Si no hay resultado, retorno el puntero a null
				// esto significa que no existe el superior en la base de datos
				return null;
			}

		} catch (SQLException e) {
			// si hay un error en ejecutar la consulta devolvemos el puntero
			// null
			return null;
		}

	}
}
