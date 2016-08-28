package semana2.ejemplo1Solucion;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import semana2.ejemplo1Solucion.DAO.DAOCarreras;
import semana2.ejemplo1Solucion.DAO.DAOCursos;
import semana2.ejemplo1Solucion.DAO.DAOMaterias;
import semana2.ejemplo1Solucion.entidades.Carrera;
import semana2.ejemplo1Solucion.entidades.Curso;
import semana2.ejemplo1Solucion.entidades.Materia;

public class Principal {

	public static void main(String[] args) {
		
		//Obtengo todos los cursos
		LinkedList<Curso> cursosTodos = DAOCursos.findAll();
		System.out.println();
		System.out.println("Listando todos los cursos");
		System.out.println();
		imprimirCursos(cursosTodos);
		
		//Obtengo los cursos de la materia de id 2
		LinkedList<Curso> cursosMateria2 = DAOCursos.findByIdMateria(2);
		System.out.println();
		System.out.println("Listando todos los cursos de materia id 2");
		System.out.println();
		imprimirCursos(cursosMateria2);
		
		Materia materia = DAOMaterias.findByNombre("Testing Funcional");
		LinkedList<Curso> cursosMateria3 = DAOCursos.findByIdMateria(materia.getIdMateria());
		imprimirCursos(cursosMateria3);
	}
	
	private static void imprimirCursos(LinkedList<Curso> cursos){
		
		for (Curso c : cursos){
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			
			System.out.println("  Id Curso: " + c.getIdCurso());
			System.out.println("  Id Docente: " + c.getIdDocente());
			System.out.println("  Id Materia: " + c.getIdMateria());
			System.out.println("  Fec Inicio: " + sdf.format(c.getFechaInicio()));
			System.out.println("  Fec Fin: " + sdf.format(c.getFechaFin()));
			System.out.println("  Modalidad: " + c.getModalidad());
			System.out.println();

		}
	
}

}
