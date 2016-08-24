package semana8.ejComplementarios;

public class Estudiante {

	private Integer numEstudiante;
	private String nombre;
	
	public Estudiante (Integer num, String nom){
		this.numEstudiante = num;
		this.nombre = nom;
	}
	
	public Integer getNumEstudiante() {
		return numEstudiante;
	}
	public void setNumEstudiante(Integer numEstudiante) {
		this.numEstudiante = numEstudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
