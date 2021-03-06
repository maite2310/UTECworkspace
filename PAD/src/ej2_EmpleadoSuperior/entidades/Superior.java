package ej2_EmpleadoSuperior.entidades;

public class Superior {

	private String ci;
	private String nombre;
	private int aņosDeTrabajo;
	
	public Superior() {
		this.ci = "";
		this.nombre = "";
		this.aņosDeTrabajo = 0;
	}
	
	public Superior(String ci, String nombre, int aņosDeTrabajo) {
		this.ci = ci;
		this.nombre = nombre;
		this.aņosDeTrabajo = aņosDeTrabajo;
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

	public int getAņosDeTrabajo() {
		return aņosDeTrabajo;
	}

	public void setAņosDeTrabajo(int aņosDeTrabajo) {
		this.aņosDeTrabajo = aņosDeTrabajo;
	}

	public String devolverInfoSuperior() {
		return "Superior= " + this.nombre + "," + this.ci + "," + this.aņosDeTrabajo;
	}

}
