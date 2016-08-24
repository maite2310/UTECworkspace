package semana6.actividadSol;

public class Curso {
	
	public String codigo;
	public String nombre;
	private int duracionSemanas;
	private int cantidadMatriculados;
	private int cantidadExamen;
	
	public Curso(){
		this.codigo = "";
		this.nombre = "";
		this.duracionSemanas = 0;
		this.cantidadMatriculados = 0;
		this.cantidadExamen = 0;
	}
	
	public Curso(String codigo, String nombre, int duracionSemanas, int cantidadMatriculados, int cantidadExamen){
		this.codigo = codigo;
		this.nombre = nombre;
		this.duracionSemanas = duracionSemanas;
		this.cantidadMatriculados = cantidadMatriculados;
		this.cantidadExamen = cantidadExamen;
	}

	public int getDuracionSemanas() {
		return duracionSemanas;
	}

	public void setDuracionSemanas(int duracionSemanas) {
		this.duracionSemanas = duracionSemanas;
	}

	public int getCantidadMatriculados() {
		return cantidadMatriculados;
	}

	public void setCantidadMatriculados(int cantidadMatriculados) {
		this.cantidadMatriculados = cantidadMatriculados;
	}

	public int getCantidadExamen() {
		return cantidadExamen;
	}

	public void setCantidadExamen(int cantidadExamen) {
		this.cantidadExamen = cantidadExamen;
	}
	
	public int porcentajeExamen(){
		int porcentaje = this.cantidadExamen / this.cantidadMatriculados;
		return porcentaje * 100;
	}
	
}
