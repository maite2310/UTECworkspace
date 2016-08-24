package university.programa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import university.excepciones.CursoException;
import university.excepciones.EstudianteException;
import university.excepciones.RangoOpcionException;
import university.manejadores.ManejadorCursos;
import university.manejadores.ManejadorEstudiantes;
import university.modelo.Curso;
import university.modelo.Estudiante;

public class Programa {

	public static int EXIT = 7;

	public static String MENU = "--- UNIVERSITY SYSTEM ---\n\n" + "Seleccione una opci�n:\n\n"
			+ "1. Ingresar Estudiante\n" + "2. Ingresar Curso\n" + "3. Listar Estudiantes de Curso\n"
			+ "4. Listar Cursos\n" + "5. Listar Estudiantes\n"  + "6. Matricular Estudiante\n"+ "7. Salir\n";

	public static String MENSAJE_ESTUDIANTE = "Alta de estudiante: ";
	public static String MENSAJE_CURSO = "Alta de curso: ";

	public static void main(String[] args) {

		// Inicializamos la lectura de la entrada
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(stream);

		// Leemos por primera vez
		int opcion = 0;

		// Comienzo la iteración hasta que finalice
		while (opcion != EXIT) {

			// Imprimimos el menu por primera vez
			System.out.println(MENU);

			// Pedimos un dato de la entrada
			opcion = opcionElegida(reader);

			switch (opcion) {
			case 1:

				ingresarNuevoEstudiante(reader);

				break;

			case 2:

				ingresarNuevoCurso(reader);

				break;

			case 3:

				listarEstudiantesCurso(reader);
				break;

			case 4:

				listarCursos();
				break;

			case 5:

				listarEstudiantes();
				break;

			case 6:

				matricularEstudiante(reader);
				break;
			default:
				break;
			}

		}

	}

	private static void matricularEstudiante(BufferedReader reader) {
		
		try {

			// Pedimos el codigo del curso en cuestión

			System.out.print("Ingrese el codigo del curso: ");
			String codigoCurso = reader.readLine();
			System.out.println();
			
			boolean existeCurso = ManejadorCursos.existeCurso(codigoCurso);

			if (!existeCurso) {
				System.out.println("No existe un curso con dicho codigo");
				System.out.println();
			} else {
				
				System.out.print("Ingrese el codigo del estudiante: ");
				String codigoEstudiante = reader.readLine();
				System.out.println();

				boolean existeEstudiante = ManejadorEstudiantes.existeEstudiante(codigoEstudiante);
				
				if (!existeEstudiante){
					System.out.println("No existe un estudiante con dicho codigo");
					System.out.println();
				}
				else{
					// Relacionamos el curso con el estudiante
					
					Curso c = ManejadorCursos.obtenerCurso(codigoCurso);
					Estudiante e = ManejadorEstudiantes.obtenerEstudiante(codigoEstudiante);
					
					if (e.getCarrera().equals(c.getCarrera())){
						ManejadorCursos.matricularEstudianteCurso(codigoCurso, codigoEstudiante);
					}
					else{
						System.out.println("El curso no pertenece a la carrera del estudiante.");
						System.out.println();
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * Método que lista los cursos
	 */
	private static void listarEstudiantes() {
		
		LinkedList<Estudiante> estudiantes = ManejadorEstudiantes.obtenerTodosEstudiantes();

		if (estudiantes.isEmpty()){
			System.out.println("No hay estudiantes ingresados");
			System.out.println();

		}
		else{
			System.out.println("Los estudiantes son los siguientes: ");
			for (Estudiante e : estudiantes) {
				System.out.println(e.infoEstudiante());
			}
			System.out.println();
		}
		
	}

	/*
	 * Método que lista los cursos
	 */
	private static void listarCursos() {

		LinkedList<Curso> cursos = ManejadorCursos.obtenerTodosCursos();

		if (cursos.isEmpty()){
			System.out.println("No hay cursos ingresados");
			System.out.println();

		}
		else{
			System.out.println("Los estudiantes del curso son los siguientes: ");
			for (Curso c : cursos) {
				System.out.println(c.infoCurso());
			}
			System.out.println();
		}
		

	}

	/*
	 * Se imprimen en pantalla todos los estudiantes del curso con el código
	 * ingresado
	 */
	private static void listarEstudiantesCurso(BufferedReader reader) {

		try {

			// Pedimos el codigo del curso en cuestión

			System.out.print("Ingrese el codigo del curso: ");
			String codigo = reader.readLine();
			System.out.println();

			boolean existe = ManejadorCursos.existeCurso(codigo);

			if (!existe) {
				System.out.println("No existe un curso con dicho código");
			} else {
				System.out.println("Los estudiantes del curso son los siguientes: ");

				Curso curso = ManejadorCursos.obtenerCurso(codigo);
				LinkedList<Estudiante> estudiantes = curso.getEstudiantes();

				for (Estudiante e : estudiantes) {
					System.out.println(e.infoEstudiante());
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Metodo para pedir los datos de un estudiante para ingresar al sistema
	 */
	private static void ingresarNuevoCurso(BufferedReader reader) {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_CURSO);

		try {

			// Pedimos uno a uno los datos del curso

			System.out.print("Carrera: ");
			String carrera = reader.readLine();
			System.out.println();

			System.out.print("Codigo: ");
			String codigo = reader.readLine();
			System.out.println();

			// Chequiamos que no haya un curso con el código ingresado

			if (ManejadorCursos.existeCurso(codigo)) {
				throw new CursoException("Ya existe un curso en el sistema con el codigo correspondiente");
			}

			System.out.print("Nombre: ");
			String nombre = reader.readLine();
			System.out.println();

			System.out.print("Departamento: ");
			String departamento = reader.readLine();
			System.out.println();

			System.out.print("Duracion: ");
			String duracionString = reader.readLine();
			System.out.println();

			boolean esNumero = false;
			int duracion = -1;
			while (!esNumero) {
				try {
					duracion = Integer.valueOf(duracionString);
					esNumero = true;
				} catch (NumberFormatException e) {
					System.out.println("Debe ingresar un dato numérico");
					System.out.print("Duracion: ");
					duracionString = reader.readLine();
					System.out.println();
				}
			}

			// Creamos la instancia del curso

			Curso c = new Curso(carrera, codigo, nombre, departamento, duracion);
			String infoCurso = c.infoCurso();

			// Preguntamos por los datos ingresados si son correctos

			System.out.println("Los datos ingresados fueron lo siguientes:");
			System.out.println(infoCurso);
			System.out.println("¿Son Correctos? Y/N");

			String correctos = reader.readLine();

			if (correctos.equals("Y")) {
				ManejadorCursos.guardarCurso(c);
				System.out.println("Curso con código " + codigo + " ingresado correctamente.");
			} else {
				System.out.println("Se ha cancelado la solicitud");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CursoException e) {
			System.out.println();
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Metodo para pedir los datos de un estudiante para ingresar al sistema
	 */
	private static void ingresarNuevoEstudiante(BufferedReader reader) {

		// Imprimimos el mensaje de bienvenida
		System.out.println(MENSAJE_ESTUDIANTE);

		try {

			// Pedimos uno a uno los datos del estudiante

			System.out.print("Nombre: ");
			String nombre = reader.readLine();
			System.out.println();

			System.out.print("CI: ");
			String ci = reader.readLine();
			System.out.println();

			System.out.print("Fecha Nacimiento: ");
			String fechaNac = reader.readLine();
			System.out.println();

			System.out.print("Lugar Residencia: ");
			String residencia = reader.readLine();
			System.out.println();

			System.out.print("Codigo de Estudiante: ");
			String codigo = reader.readLine();
			System.out.println();

			// Chequiamos que no haya un estudiante con el código ingresado

			if (ManejadorEstudiantes.existeEstudiante(codigo)) {
				throw new EstudianteException("Ya existe un estudiante en el sistema con el codigo correspondiente");
			}

			System.out.print("Carrera: ");
			String carrera = reader.readLine();
			System.out.println();

			// Creamos la instancia del estudiante

			Estudiante e = new Estudiante(nombre, ci, fechaNac, residencia, codigo, carrera);
			String infoEstudiante = e.infoEstudiante();

			// Preguntamos por los datos ingresados si son correctos

			System.out.println("Los datos ingresados fueron lo siguientes:");
			System.out.println(infoEstudiante);
			System.out.println("¿Son Correctos? Y/N");

			String correctos = reader.readLine();

			// Entramos en loop hasta q se ingrese el caracter solicitado

			while (!correctos.equals("Y") || !correctos.equals("N")) {
				correctos = reader.readLine();
			}

			if (correctos.equals("Y")) {
				ManejadorEstudiantes.guardarEstudiante(e);
				System.out.println("Estudiante con código " + codigo + " ingresado correctamente.");
			} else {
				System.out.println("Se ha cancelado la solicitud");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EstudianteException e) {
			System.out.println();
			System.out.println(e.getMessage());
		}

	}

	private static int opcionElegida(BufferedReader reader) {

		int resultado = 0;
		String opcionLeida = null;

		// Leemos la opcion ingresada hasta que sea válida
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

	// Metodo que valida que la opcion esté entre 1 y 7
	private static void validarRangoOpcion(int opcion) throws RangoOpcionException {

		if (opcion <= 0 || opcion > 7) {
			throw new RangoOpcionException("El rango de la opcion debe estar entre 1 y 7");
		}

	}

}
