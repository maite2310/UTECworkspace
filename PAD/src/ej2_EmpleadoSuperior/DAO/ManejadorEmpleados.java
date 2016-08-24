package ej2_EmpleadoSuperior.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ej2_EmpleadoSuperior.entidades.Empleado;
import ej2_EmpleadoSuperior.entidades.Superior;

public class ManejadorEmpleados {
	
	public static void guardarEmpleado(Empleado empleado) throws SQLException {
		
		// Ejecuto un insert sobre la tabla de Empleado con los valores de atributos del Empleado

		String consulta = "INSERT INTO EMPLEADO(CI,NOMBRE,EDAD,SALARIO,CI_SUPERIOR) VALUES('" + 
		empleado.getCi() + "','" + empleado.getNombre() + "'," + empleado.getEdad() + "," + empleado.getSalario() + ",'" + empleado.getSuperior().getCi() + "')";
		DatabaseManager.inicializarConexion();
		DatabaseManager.ejecutarConsulta(consulta);

	}

	public static ArrayList<Empleado> obtenerEmpleados() {

		ArrayList<Empleado> resultado = new ArrayList<>();

		try{
			// Buscamos todos los empleados de la base de datos
			
			String consulta = "SELECT * FROM EMPLEADO";
			DatabaseManager.inicializarConexion();
			ResultSet empleadosDb = DatabaseManager.ejecutarConsulta(consulta);
			
			while (empleadosDb.next()){
				
				String ci = empleadosDb.getString("CI");
				String nombre = empleadosDb.getString("NOMBRE");
				int edad = empleadosDb.getInt("EDAD");
				double salario = empleadosDb.getDouble("SALARIO");
				
				String ciSuperior = empleadosDb.getString("CI_SUPERIOR");
				
				Superior superior = ManejadorSuperiores.obtenerSuperior(ciSuperior);
				
				Empleado empleado = new Empleado(nombre, ci, edad, salario, superior);
				resultado.add(empleado);
				
			}
		}
		catch (SQLException e){
			
		}

		return resultado;
	}

}
