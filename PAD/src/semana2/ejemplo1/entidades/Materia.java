package semana2.ejemplo1.entidades;

public class Materia {
	private long idMateria;
	private String nombre;
	private long idCarrera;
	
	public Materia(long idMateria, String nombre, long idCarrera) {
		
		this.idMateria = idMateria;
		this.nombre = nombre;
		this.idCarrera = idCarrera;
	}

	public long getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(long idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(long idCarrera) {
		this.idCarrera = idCarrera;
	}
	
	
	
}
