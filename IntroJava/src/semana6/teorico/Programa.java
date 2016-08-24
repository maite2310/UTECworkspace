package semana6.teorico;

public class Programa {

	public static void main(String[] args) {
		Estudiante e1;
		e1 = new Estudiante();
		
		String nombreE1 = e1.nombre;
		
		Estudiante e2 = new Estudiante("ES1", "Juan", 332156845, 1955);
		String nombreE2 = e2.nombre;
		int cedulaE2 = e2.cedulaIdentidad;

	}

}
