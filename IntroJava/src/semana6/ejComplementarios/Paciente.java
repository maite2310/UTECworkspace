package semana6.ejComplementarios;

public class Paciente {
	
	private String nombre;
	private String ci;
	
	//Constructor por defecto
	public Paciente (){
		
	}
	
	public Paciente (String nombre, String ci){
		this.nombre = nombre;
		this.ci = ci;
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
	
	
}
