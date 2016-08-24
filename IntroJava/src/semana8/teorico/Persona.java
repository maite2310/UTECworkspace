package semana8.teorico;

public class Persona {
	private String nombre;
	private String ciudadResidencia;
	private String ci;
	
		
	public Persona(String nombre, String ciudadResidencia, String ci) {	
		this.nombre = nombre;
		this.ciudadResidencia = ciudadResidencia;
		this.ci = ci;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}	
}
