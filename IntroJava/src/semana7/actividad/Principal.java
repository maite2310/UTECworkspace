package semana7.actividad;

import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		
		Persona persona1 = new Persona("Maria Perez", "44024677", "", "Uruguay", true);
		Persona persona2 = new Persona("Santiago Diaz", "", "", "Chile", true);
		Persona persona3 = new Persona("Jose Martin", "33786754", "AZA34579", "Uruguay", false);
		Persona persona4 = new Persona("Juan Rodriguez", "24568976", "CPA57564", "Uruguay", true);
		
		LinkedList<Persona> listaPersonas = new LinkedList<>();
		listaPersonas.add(persona1);
		listaPersonas.add(persona2);
		listaPersonas.add(persona3);
		listaPersonas.add(persona4);
		
		for(Persona persona : listaPersonas){
			try {
				persona.puedeVotar();
				System.out.println(persona.getNombre()+" habilitado a votar");
			} catch (NoVotaException e) {
				System.out.println(persona.getNombre()+" "+e.getMessage());
			}
		}
		
	}

}
