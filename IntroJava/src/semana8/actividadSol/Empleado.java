package semana8.actividadSol;

import java.util.Date;

public class Empleado {
	protected String nombre;
	protected String apellido;
	protected Integer numBPS;
	protected Integer funcionario;
	protected String direccion;
	protected String telefono;

	
	public Empleado(String nombre, String apellido,  Integer numBPS, Integer funcionario, 
			String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.numBPS = numBPS;
		this.funcionario = funcionario;
		this.direccion = direccion;
		this.telefono = telefono;

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

	public Integer getNumBPS() {
		return numBPS;
	}
	public void setNumBPS(Integer numBPS) {
		this.numBPS = numBPS;
	}
	public Integer getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String dirección) {
		this.direccion = dirección;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public double getSueldo(){
		return 0;
	}

	
	
}
