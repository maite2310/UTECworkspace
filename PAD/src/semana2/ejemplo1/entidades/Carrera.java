package semana2.ejemplo1.entidades;

public class Carrera {
	private long idCarrera;
	private String nombre;
	private String nivel;
	
	
	
	public Carrera(int idCarrera, String nombre, String nivel) {
		
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
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	
}
