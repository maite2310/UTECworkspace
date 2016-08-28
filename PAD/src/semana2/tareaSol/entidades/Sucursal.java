package semana2.tareaSol.entidades;

public class Sucursal {
	private long idSucursal;
	private String telefono;	
	private String direccion;
	private String nombre;
	
	public Sucursal(long idSucursal, String telefono, String direccion, String nombre) {

		this.idSucursal = idSucursal;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombre = nombre;
	}

	public long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
