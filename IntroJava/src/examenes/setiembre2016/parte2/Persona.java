package examenes.setiembre2016.parte2;

public class Persona {
	
	private String nombre;	
	private String ci;
	private boolean esMayor;
	
	public Persona(String nombre, String ci, boolean esMayor) {		
		this.nombre = nombre;
		this.ci = ci;
		this.esMayor = esMayor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public boolean isEsMayor() {
		return esMayor;
	}

	public void setEsMayor(boolean esMayor) {
		this.esMayor = esMayor;
	}
	
	
	
}
