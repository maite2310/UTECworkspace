package university.programa;

import java.util.HashMap;
import java.util.LinkedList;

import university.modelo.Curso;
import university.modelo.Estudiante;

public class Datos {

	// Listas de entidades existentes en el sistema
	private LinkedList<Estudiante> estudiantes;
	private LinkedList<Curso> cursos;

	// Mapa de entidades exitentes en el sistema
	private HashMap<String, Estudiante> mapaEstudiantes;
	private HashMap<String, Curso> mapaCursos;

	public Datos() {
		this.estudiantes = new LinkedList<>();
		this.cursos = new LinkedList<>();
		this.mapaEstudiantes = new HashMap<>();
		this.mapaCursos = new HashMap<>();

	}

	public LinkedList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public LinkedList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(LinkedList<Curso> cursos) {
		this.cursos = cursos;
	}

	public HashMap<String, Estudiante> getMapaEstudiantes() {
		return mapaEstudiantes;
	}

	public void setMapaEstudiantes(HashMap<String, Estudiante> mapaEstudiantes) {
		this.mapaEstudiantes = mapaEstudiantes;
	}

	public HashMap<String, Curso> getMapaCursos() {
		return mapaCursos;
	}

	public void setMapaCursos(HashMap<String, Curso> mapaCursos) {
		this.mapaCursos = mapaCursos;
	}
	
	

}
