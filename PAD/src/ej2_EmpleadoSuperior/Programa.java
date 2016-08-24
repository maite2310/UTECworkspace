package ej2_EmpleadoSuperior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import ej2_EmpleadoSuperior.DAO.DatabaseManager;
import ej2_EmpleadoSuperior.DAO.ManejadorEmpleados;
import ej2_EmpleadoSuperior.DAO.ManejadorSuperiores;
import ej2_EmpleadoSuperior.entidades.Empleado;
import ej2_EmpleadoSuperior.entidades.Superior;

public class Programa {

	public static int EXIT = 7;


	public static String MENSAJE_EMPLEADO = "***** Alta de empleado ***** ";
	public static String MENSAJE_SUPERVISOR = "***** Alta de supervisor *****";

	public static String MENU = "-------------- Bienvenidos! -------------\n\n" + "SELECCIONE UNA OPCIÓN:\n\n" + "1. Ingresar Empleado\n"
			+ "2. Ingresar Supervisor\n" + "3. Listar Empleados\n" + "4. Salir\n";

	public static void main(String[] args) {

		// Inicializamos la lectura de la entrada
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(stream);

		// Inizializamos la conexion a la base de datos
		try {
			DatabaseManager.inicializarConexion();
		} catch (SQLException e) {

			// Si falla la conexion a la base de datos, mostramos un mensaje y
			// finalizamos el programa

			System.out.println("Error conectando a la base de datos!. Se Termina el programa");
			return;
		}

		// Leemos por primera vez
		int opcion = 0;

		// Comienzo la iteraciÃ³n hasta que finalice
		while (opcion != EXIT) {

			// Imprimimos el menu por primera vez
			System.out.println(MENU);

			// Pedimos un dato de la entrada
			opcion = opcionElegida(reader);

			switch (opcion) {
			case 1:

				ingresarNuevoEmpleado(reader);

				break;

			case 2:

				ingresarNuevoSupervisor(reader);

				break;

			case 3:

				listarEmpleados();
				break;

			default:
				break;
			}
			
			// Imprimimos un salto de linea
			System.out.println();

		}

	}

	private static void listarEmpleados() {

		ArrayList<Empleado> empleados = ManejadorEmpleados.obtenerEmpleados();
		
		System.out.println("***** Empleados *****");
		System.out.println();

		for (Empleado e : empleados) {
			System.out.println(e.devolverInfoEmpleado());
		}

	}

	private static void ingresarNuevoSupervisor(BufferedReader reader) {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_SUPERVISOR);
		System.out.println();

		try {

			// Pedimos uno a uno los datos del curso

			System.out.print("Nombre: ");
			String nombre = reader.readLine();
			System.out.println();

			System.out.print("CI: ");
			String ci = reader.readLine();
			System.out.println();

			System.out.print("AÃ±os de trabajo: ");
			String anosTrabajoString = reader.readLine();
			int anosTrabajo = Integer.valueOf(anosTrabajoString);
			System.out.println();

			Superior superior = new Superior(ci, nombre, anosTrabajo);

			ManejadorSuperiores.guardarSuperior(superior);
			System.out.println("Superior creado Exitosamente!");

		} catch (SQLException e) {
			System.out.println("Error al guardar el Superior. Intente nuevamente");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println(e.getMessage());
		}

	}

	private static void ingresarNuevoEmpleado(BufferedReader reader) {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_EMPLEADO);
		System.out.println();

		try {

			// Pedimos uno a uno los datos del curso

			System.out.print("Nombre: ");
			String nombre = reader.readLine();
			System.out.println();

			System.out.print("CI: ");
			String ci = reader.readLine();
			System.out.println();

			System.out.print("Edad: ");
			String edadString = reader.readLine();
			int edad = Integer.valueOf(edadString);
			System.out.println();

			System.out.print("Salario: ");
			String salarioString = reader.readLine();
			double salario = Double.valueOf(salarioString);
			System.out.println();

			System.out.print("CI Superior: ");
			String ciSuperior = reader.readLine();
			System.out.println();

			Superior superior = ManejadorSuperiores.obtenerSuperior(ciSuperior);

			if (superior != null) {
				Empleado empleado = new Empleado(nombre, ci, edad, salario, superior);
				ManejadorEmpleados.guardarEmpleado(empleado);
				System.out.println("Empleado creado Exitosamente!");
			} else {
				System.out.println("No existe el superior indicado!");
			}

		} catch (IOException e) {
			
		} catch (Exception e) {
			System.out.println();
			System.out.println(e.getMessage());
		}

	}

	private static int opcionElegida(BufferedReader reader) {

		int resultado = 0;
		String opcionLeida = null;

		// Leemos la opcion ingresada hasta que sea vÃ¡lida
		boolean entradaCorrecta = false;

		while (!entradaCorrecta) {

			try {
				opcionLeida = reader.readLine();
				resultado = Integer.valueOf(opcionLeida);
				validarRangoOpcion(resultado);
				entradaCorrecta = true;
			} catch (IOException e) {
				System.out.println("Error al leer de la entrada estandar, ingrese nuevamente su opción\n");
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un número, ingrese nuevamente su opción\n");

			} catch (RangoOpcionException e) {
				System.out.println(e.getMessage());
			}
		}

		return resultado;
	}

	// Metodo que valida que la opcion estÃ© entre 1 y 4
	private static void validarRangoOpcion(int opcion) throws RangoOpcionException {

		if (opcion <= 0 || opcion > 5) {
			throw new RangoOpcionException("El rango de la opcion debe estar entre 1 y 4");
		}

	}

}
