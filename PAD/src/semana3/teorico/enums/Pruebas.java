package semana3.teorico.enums;

public class Pruebas {
	public static void main(String [] args){
		// Instanciamos el enumerado
		TipoClase tipo = TipoClase.LENGUA;
				
		// Devuelve un String con el nombre de la constante
		System.out.println("tipo.name()= "+tipo.name());
				
		// Devuelve el contenido de los atributos
		System.out.println("tipo.getNombre()= "+tipo.getNombre());
		System.out.println("tipo.getNumero()= "+tipo.getNumero());
	}
}
