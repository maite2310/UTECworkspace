package semana3.ejemplo1.entidades;

import semana3.ejemplo1.enums.Nivel;

public class Carrera {
	private long idCarrera;
	private String nombre;
	private Nivel nivel;
	
	
	
	public Carrera(int idCarrera, String nombre, Nivel nivel) {
		
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.nivel = nivel;
	}
	
	public long getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
}
