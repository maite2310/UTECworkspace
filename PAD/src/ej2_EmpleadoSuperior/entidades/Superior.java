package ej2_EmpleadoSuperior.entidades;

public class Superior {

	private String ci;
	private String nombre;
	private int añosDeTrabajo;
	
	public Superior() {
		this.ci = "";
		this.nombre = "";
		this.añosDeTrabajo = 0;
	}
	
	public Superior(String ci, String nombre, int añosDeTrabajo) {
		this.ci = ci;
		this.nombre = nombre;
		this.añosDeTrabajo = añosDeTrabajo;
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

	public int getAñosDeTrabajo() {
		return añosDeTrabajo;
	}

	public void setAñosDeTrabajo(int añosDeTrabajo) {
		this.añosDeTrabajo = añosDeTrabajo;
	}

	public String devolverInfoSuperior() {
		return "Superior= " + this.nombre + "," + this.ci + "," + this.añosDeTrabajo;
	}

}
