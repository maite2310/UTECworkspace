package semana3.ejemplo1.entidades;

public class Materia {
	private long idMateria;
	private String nombre;
	private Carrera carrera;
	
	public Materia(long idMateria, String nombre, Carrera carrera) {

		this.idMateria = idMateria;
		this.nombre = nombre;
		this.carrera = carrera;
	}

	public Materia( String nombre, Carrera carrera) {

		this.idMateria = 0;
		this.nombre = nombre;
		this.carrera = carrera;
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

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	
}
