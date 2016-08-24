package university.manejadores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

import university.modelo.Estudiante;

public class ManejadorEstudiantes {

	private static String archivoEstudiantes = "C:\\UTEC\\PAD\\Pruebas\\Semana1\\estudiantes.csv";
	private static String archivoEstudiantesCursos = "";

	public static boolean existeEstudiante(String codigoEstudiante) {

		boolean encontre = false;

		try {
			String linea;

			FileReader f = new FileReader(archivoEstudiantes);
			BufferedReader b = new BufferedReader(f);
			linea = b.readLine();

			while (linea != null && !encontre) {

				if (linea.equals("")) {
					// Me quedo con el primer campo, de cada linea que es el
					// codigo
					String[] valores = linea.split(",");
					String codigo = valores[0];

					if (codigo.equals(codigoEstudiante)) {
						encontre = true;
					}
				}

			}
			b.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer archivo de estudiantes");
		}

		return encontre;

	}

	public static void guardarEstudiante(Estudiante e) {

		try {

			FileWriter fichero = new FileWriter(archivoEstudiantes, true);
			PrintWriter pw = new PrintWriter(fichero);

			String coma = ",";
			String linea = e.getCodigo() + coma + e.getCi() + coma + e.getCarrera() + coma + e.getFechaNacimiento()
					+ coma + e.getLugarResidencia() + coma + e.getNombre();
			pw.println(linea);

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Error al guardar estudiante");
		}

	}

	public static Estudiante obtenerEstudiante(String codigoEstudiante) {

		Estudiante resultado = null;
		boolean encontre = false;

		try {
			String linea;

			FileReader f = new FileReader(archivoEstudiantes);
			BufferedReader b = new BufferedReader(f);
			linea = b.readLine();

			while (linea != null && !encontre) {

				if (linea.equals("")) {
					// Me quedo con el primer campo, de cada linea que es el
					// codigo
					String[] valores = linea.split(",");
					String codigo = valores[0];

					if (codigo.equals(codigoEstudiante)) {

						encontre = true;
						resultado = new Estudiante(valores[5], valores[1], valores[3], valores[4], valores[0],
								valores[2]);

					}
				}

			}
			b.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer archivo de estudiantes");
		}

		return resultado;
	}

	public static LinkedList<Estudiante> obtenerTodosEstudiantes() {

		LinkedList<Estudiante> resultado = new LinkedList<>();

		try {
			String linea;

			FileReader f = new FileReader(archivoEstudiantes);
			BufferedReader b = new BufferedReader(f);
			linea = b.readLine();

			while (linea != null) {

				if (linea.equals("")) {
					// Me quedo con el primer campo, de cada linea que es el
					// codigo
					String[] valores = linea.split(",");
					Estudiante estudiante = new Estudiante(valores[5], valores[1], valores[3], valores[4], valores[0],
							valores[2]);

					resultado.add(estudiante);

				}

			}
			b.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer archivo de estudiantes");
		}

		return resultado;
	}

}
