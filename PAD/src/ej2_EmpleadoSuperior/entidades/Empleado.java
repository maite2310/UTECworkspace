package ej2_EmpleadoSuperior.entidades;

public class Empleado {
	
	// Atributos
	
	private String nombre;
	private String ci;
	private int edad;
	private double salario;
	private Superior superior;
	
	// Constructores
	
	public Empleado() {
		
		this.nombre = "";
		this.ci = "";
		this.edad = -1;
		this.salario = -1;
		this.setSuperior(null);
	}

	public Empleado(String nombre, String ci, int edad, double salario, Superior superior) {
		this.nombre = nombre;
		this.ci = ci;
		this.edad = edad;
		this.salario = salario;
		this.setSuperior(superior);
		
	}
	
	// Getters y Setters

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	// Metodos
	
	public String obtenerCalificacion(){
		
		if (this.edad<=21){
			return "Principiante";
		}
		else if (this.edad > 21 && this.edad <=35){
			return "Intermedio";
		}
		else{
			return "Senior";
		}
	}
	
	public String devolverInfoEmpleado(){
		
		return "Empleado= " + this.nombre + "," + this.ci + "," + this.edad + "," + this.salario + ", " + this.superior.devolverInfoSuperior();
	}
	
	public void aumentarSalario(double porcentaje){
		
		double salarioAIncrementar = (this.salario * porcentaje) / 100;
		this.salario = this.salario + salarioAIncrementar;
		
	}

	public Superior getSuperior() {
		return superior;
	}

	public void setSuperior(Superior superior) {
		this.superior = superior;
	}
	
}
