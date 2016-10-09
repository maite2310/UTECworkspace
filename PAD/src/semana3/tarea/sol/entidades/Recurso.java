package semana3.tarea.sol.entidades;

public class Recurso {
	private long idRecurso;
	private String nombre;
	
	public Recurso(long idRecurso, String nombre) {
		this.idRecurso = idRecurso;
		this.nombre = nombre;
	}

	public long getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(long idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
