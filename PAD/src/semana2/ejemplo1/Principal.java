package semana2.ejemplo1;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import semana2.ejemplo1.DAO.DAOCursos;
import semana2.ejemplo1.entidades.Curso;

public class Principal {

	public static void main(String[] args) {
		
		//Obtengo todos los cursos
		LinkedList<Curso> cursosTodos = DAOCursos.getCursos();
		System.out.println();
		System.out.println("Listando todos los cursos");
		System.out.println();
		imprimirCursos(cursosTodos);
		
		//Obtengo los cursos de la materia de id 2
		LinkedList<Curso> cursosMateria2 = DAOCursos.getCursos(2);
		System.out.println();
		System.out.println("Listando todos los cursos de materia id 2");
		System.out.println();
		imprimirCursos(cursosTodos);
		

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
