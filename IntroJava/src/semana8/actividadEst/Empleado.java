package semana8.actividadEst;

// Clase Base o Padre: crea a los objetos Empleado, y contiene los atributos y métodos comunes que serán
// heredados por las subclases que la extiendan

public class Empleado {

	// Definimos los atributos de los objetos del tipo Empleado.

	private String nombre;
	private String apellido;
	private int numeroBps;
	private int numeroFuncionario;
	private String direccion;
	private String telefono;

	// ***** MÉTODO CONSTRUCTOR *****
	// Genera una instancia asignando los valores que se reciben por parámetro
	
	public Empleado(String pNombre, String pApellido, int pNumeroBps, int pNumeroFuncionario, String pDireccion,
			String pTelefono) {
		this.nombre = pNombre;
		this.apellido = pApellido;
		this.numeroBps = pNumeroBps;
		this.numeroFuncionario = pNumeroFuncionario;
		this.direccion = pDireccion;
		this.telefono = pTelefono;
	}
	// **********************************

	
	// ***** MÉTODOS ACCESORES Y MODIFICADORES *****
	// Métodos públicos para asignar valor (SET) y obtener valor (GET) de las
	// variables privadas

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String pApellido) {
		this.apellido = pApellido;
	}

	public int getNumeroBps() {
		return numeroBps;
	}

	public void setNumeroBps(int pNumeroBps) {
		this.numeroBps = pNumeroBps;
	}

	public int getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(int pNumeroFuncionario) {
		this.numeroFuncionario = pNumeroFuncionario;
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

	// *********************************************
	
	// MÉTODO QUE PERMITE CALCULAR EL SUELDO DE CADA EMPLEADO, SERÁ SOBRE ESCRITO EN LAS CLASES HIJAS
	// CONSIDERANDO LAS VARIABLES DE CADA TIPO DE EMPLEADO
	
	public double getSueldo(){
		double pSueldoEmp = 0;
		return pSueldoEmp;
	}
	
}
