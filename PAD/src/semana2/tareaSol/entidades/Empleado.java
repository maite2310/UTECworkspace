package semana2.tareaSol.entidades;

public class Empleado {
	private long idEmpleado;
	private String ci;
	private String nombre;
	private String apellido;
	private double sueldo;
	private long idSucursal;
	
	public Empleado(long idEmpleado, String ci, String nombre, String apellido, double sueldo, long idSucursal) {

		this.idEmpleado = idEmpleado;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.idSucursal = idSucursal;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	
	
}
