package examenes.repaso.ejercicio2.parte5;

public class Actividad {
	private String nombre;
	private String profesor;
	private double duracion;
	
		
	public Actividad(String nombre, String profesor, double duracion) {

		this.nombre = nombre;
		this.profesor = profesor;
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	
}
