package ej2_EmpleadoSuperior.entidades;

public class Superior {

	private String ci;
	private String nombre;
	private int a�osDeTrabajo;
	
	public Superior() {
		this.ci = "";
		this.nombre = "";
		this.a�osDeTrabajo = 0;
	}
	
	public Superior(String ci, String nombre, int a�osDeTrabajo) {
		this.ci = ci;
		this.nombre = nombre;
		this.a�osDeTrabajo = a�osDeTrabajo;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getA�osDeTrabajo() {
		return a�osDeTrabajo;
	}

	public void setA�osDeTrabajo(int a�osDeTrabajo) {
		this.a�osDeTrabajo = a�osDeTrabajo;
	}

	public String devolverInfoSuperior() {
		return "Superior= " + this.nombre + "," + this.ci + "," + this.a�osDeTrabajo;
	}

}
