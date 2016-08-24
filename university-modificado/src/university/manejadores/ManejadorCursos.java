package university.manejadores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

import university.modelo.Curso;
import university.modelo.Estudiante;

public class ManejadorCursos {

	private static String archivoCursos = "";
	private static String archivoEstudiantesCursos = "";

	public static boolean existeCurso(String codigoCurso) {

		boolean encontre = false;

		try {
			String linea;

			FileReader f = new FileReader(archivoCursos);
			BufferedReader b = new BufferedReader(f);
			linea = b.readLine();

			while (linea != null && !encontre) {

				if (!linea.equals("")) {
					// Me quedo con el primer campo, de cada linea que es el
					// codigo
					String[] valores = linea.split(",");
					String codigo = valores[0];

					if (codigo.equals(codigoCurso)) {
						encontre = true;
					}
				}

			}
			b.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer archivo de cursos");
		}

		return encontre;

	}

	public static void guardarCurso(Curso c) {

		try {

			FileWriter fichero = new FileWriter(archivoCursos, true);
			PrintWriter pw = new PrintWriter(fichero);

			String coma = ",";
			String linea = c.getCodigo() + coma + c.getCarrera() + coma + c.getDepartamento() + coma + c.getDuracion()
					+ coma + c.getNombre();
			pw.println(linea);

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Error al guardar estudiante");
		}

	}

	public static Curso obtenerCurso(String codigo) {

		Curso resultado = null;
		boolean encontre = false;

		try {
			String linea;

			FileReader f = new FileReader(archivoCursos);
			BufferedReader b = new BufferedReader(f);
			linea = b.readLine();

			while (linea != null && !encontre) {

				if (!linea.equals("")) {

					String[] valores = linea.split(",");

					if (valores[0].equals(codigo)) {

						encontre = true;

						LinkedList<Estudiante> estudiantes = ManejadorCursos.obtenerEstudiantesCurso(codigo);
						resultado = new Curso(valores[1], valores[0], valores[4], valores[2],
								Integer.valueOf(valores[3]));
						resultado.setEstudiantes(estudiantes);

					}

				}
			}
			b.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer archivo de cursos");
		}

		return resultado;

	}

	private static LinkedList<Estudiante> obtenerEstudiantesCurso(String codigoCurso) {

		LinkedList<Estudiante> resultado = new LinkedList<>();

		try {
			String linea;

			FileReader f = new FileReader(archivoEstudiantesCursos);
			BufferedReader b = new BufferedReader(f);
			linea = b.readLine();

			while (linea != null) {

				if (linea.equals("")) {

					// Me quedo con el primer campo, de cada linea que es el
					// codigo
					String[] valores = linea.split(",");
					String codigo = valores[0];

					if (codigo.equals(codigoCurso)) {

						Estudiante e = ManejadorEstudiantes.obtenerEstudiante(valores[1]);
						resultado.add(e);

					}
				}

			}
			b.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer archivo de estudiantes");
		}

		return resultado;
	}

	public static LinkedList<Curso> obtenerTodosCursos() {

		LinkedList<Curso> resultado = new LinkedList<>();

		try {
			String linea;

			FileReader f = new FileReader(archivoCursos);
			BufferedReader b = new BufferedReader(f);
			linea = b.readLine();

			while (linea != null) {

				if (!linea.equals("")) {

					String[] valores = linea.split(",");

					Curso curso = new Curso(valores[1], valores[0], valores[4], valores[2],
							Integer.valueOf(valores[3]));
					
					resultado.add(curso);

				}
			}
			b.close();
		} catch (Exception e) {
			System.out.println("No se pudo leer archivo de cursos");
		}

		return resultado;
	}

	public static void matricularEstudianteCurso(String codigoCurso, String codigoEstudiante) {
		
		try {

			FileWriter fichero = new FileWriter(archivoEstudiantesCursos, true);
			PrintWriter pw = new PrintWriter(fichero);

			String coma = ",";
			String linea = codigoCurso + coma + codigoEstudiante;
			pw.println(linea);

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Error al guardar relacion estudiante-curso");
		}
		
	}

}
