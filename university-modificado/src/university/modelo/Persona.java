package university.modelo;

public class Persona {

	private String nombre;
	private String ci;
	private String fechaNacimiento;
	private String lugarResidencia;
	
	

	public Persona(String nombre, String ci, String fechaNacimiento, String lugarResidencia) {
		this.nombre = nombre;
		this.ci = ci;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarResidencia = lugarResidencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getLugarResidencia() {
		return lugarResidencia;
	}

	public void setLugarResidencia(String lugarResidencia) {
		this.lugarResidencia = lugarResidencia;
	}

}
