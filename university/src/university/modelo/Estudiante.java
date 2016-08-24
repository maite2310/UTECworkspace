package university.modelo;

import java.util.LinkedList;

public class Estudiante extends Persona {

	private String codigo;
	private String carrera;
	private LinkedList<Curso> cursos;
	
	public Estudiante(String nombre, String ci, String fechaNacimiento, String lugarResidencia, String codigo,
			String carrera, LinkedList<Curso> cursos) {
		super(nombre, ci, fechaNacimiento, lugarResidencia);
		this.codigo = codigo;
		this.carrera = carrera;
		this.cursos = cursos;
	}
	
	public Estudiante(String nombre, String ci, String fechaNacimiento, String lugarResidencia, String codigo,
			String carrera) {
		super(nombre, ci, fechaNacimiento, lugarResidencia);
		this.codigo = codigo;
		this.carrera = carrera;
		this.cursos = new LinkedList<Curso>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public LinkedList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(LinkedList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public String infoEstudiante(){
		
		return "Nombre: " + super.getNombre() + ", CI: " + super.getCi() + ", Fecha Nacimiento: " + super.getFechaNacimiento()
		         + ", Lugar Residencia: " + super.getLugarResidencia() + ", Codigo: " + this.codigo + ", Carrera: " + this.carrera;
		
	}
	
	
	
}
