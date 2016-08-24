package examenes.repaso.ejercicio3.parte3;

import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		
		Actividad actividad1 = new Actividad();
		actividad1.setNombre("actividad1");
		try {
			actividad1.setNota(-9);
		} catch (NotaInvalidaException e) {
			actividad1.setDescripcionNota("Insuficiente");
		}
		
		Actividad actividad2 = null;
		try {
			actividad2 = new Actividad("actividad2", 3);
			
		} catch (NotaInvalidaException e) {
			actividad2.setDescripcionNota("Insuficiente");
		}
		
		LinkedList<Actividad> listaActividades = new LinkedList<>();
		listaActividades.add(actividad1);
		listaActividades.add(actividad2);
		
		Estudiante estudiante1 = new Estudiante("Maria Perez", 33, listaActividades);
		
		
		Estudiante estudiante2 = new Estudiante();
		estudiante2.setEdad(23);
		estudiante2.setNombre("Jose Lopez");
		
		try {
			Actividad actividad3 = new Actividad("actividad3", 5);
			Actividad actividad4 = new Actividad("actividad4", 3);
			
			LinkedList<Actividad> listaActividades2 = new LinkedList<>();
			listaActividades2.add(actividad3);
			listaActividades2.add(actividad4);
			
			estudiante2.setActividades(listaActividades2);
			
			System.out.println("Promedio de estudiante "+ estudiante2.getNombre() + " es " + estudiante2.getPromedio());
			
		} catch (NotaInvalidaException e) {
			System.out.println(e.getMessage());
		}		
	}
}
