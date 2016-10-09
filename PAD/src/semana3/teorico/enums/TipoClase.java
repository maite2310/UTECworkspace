package semana3.teorico.enums;

public enum TipoClase {
	LENGUA("Lengua",151), CIENCIA("Ciencia",432),
	MATEMATICA("Matemática",5), SOCIAL("Social",7); 
	
	private String nombre;
	private int numero;
	
	private TipoClase (String nombre, int numero){
		this.numero = numero;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumero() {
		return numero;
	}

}
