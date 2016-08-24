package university.modelo;

import java.util.LinkedList;

public class Curso {

	private String carrera;
	private String codigo;
	private String nombre;
	private String departamento;
	private int duracion; // en meses
	private LinkedList<Estudiante> estudiantes;

	public Curso(String carrera, String codigo, String nombre, String departamento, int duracion) {
		super();
		this.carrera = carrera;
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
		this.duracion = duracion;
		this.estudiantes = new LinkedList<Estudiante>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public LinkedList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public String infoCurso() {
		return "Carrera: " + this.carrera + ", Codigo: " + this.codigo + ", Nombre: " + this.nombre
        + ", Departamento: " + this.departamento + ", Duracion: " + this.duracion;
	}

	
}
