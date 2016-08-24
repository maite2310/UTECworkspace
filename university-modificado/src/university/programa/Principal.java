package university.programa;

import university.manejadores.ManejadorEstudiantes;
import university.modelo.Estudiante;

public class Principal {
	public static void main(String[] args){
		
		Estudiante estudiante = new Estudiante("maite", "3302456","23/10/1980","montevideo","cod01", "inge");
		
		ManejadorEstudiantes.guardarEstudiante(estudiante);
		
	}
	
}
