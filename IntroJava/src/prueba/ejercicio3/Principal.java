package prueba.ejercicio3;

import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		
		try {
			Docente docente1 = new Docente("Maria Perez", 43, true, 26500);
		} catch (Exception e) {
				System.out.println(e.getMessage());		
		}
		
		Estudiante estudiante1 = new Estudiante();
		estudiante1.nombre = "Jose Gonzalez";
		estudiante1.ci = "34532477";
				
		LinkedList<String> listaActividades = new LinkedList<String>();
		
		listaActividades.add("actividad1");
		listaActividades.add("actividad2");
		listaActividades.add("actividad2");
		estudiante1.actividadesRealizadas = listaActividades;
	}

}
