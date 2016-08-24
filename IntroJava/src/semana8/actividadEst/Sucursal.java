package semana8.actividadEst;

//Para el manejo de objetos del tipo Listas necesitamos importar el paquete java.util
import java.util.*;

// Clase que crea los objetos Sucursal en donde trabajan los empleados

public class Sucursal {

	// Definimos los atributos de la clase
	private String nombre;
	private int identificador;
	private String direccion;
	private String telefono;
	private String rut;
	
	LinkedList <Empleado> colEmpleados;

	// ***** MÉTODO CONSTRUCTOR *****
	
	public Sucursal (String pNombre, int pIdentificador, String pDireccion, String pTelefono, String pRut, LinkedList<Empleado> pColEmpleados){
		this.nombre = pNombre;
		this.identificador = pIdentificador;
		this.direccion = pDireccion;
		this.telefono = pTelefono;
		this.rut = pRut;
		this.colEmpleados = pColEmpleados;
		
	}

	// ******************************
	
	// ***** MÉTODOS ACCESORES Y MODIFICADORES *****
		// Métodos públicos para asignar valor (SET) y obtener valor (GET) de las
		// variables privadas
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int pIdentificador) {
		this.identificador = pIdentificador;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String pDireccion) {
		this.direccion = pDireccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String pTelefono) {
		this.telefono = pTelefono;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String pRut) {
		this.rut = pRut;
	}

	public LinkedList<Empleado> getColEmpleados() {
		return colEmpleados;
	}
	
	public void setColEmpleados(LinkedList<Empleado> pColEmpleados) {
		this.colEmpleados = pColEmpleados;
	}
	
	// *********************************************
	
	
	
}
