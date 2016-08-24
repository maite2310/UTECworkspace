package prueba.ejercicio3;

public class Docente {
	
	private String nombre;
	private int edad;
	private boolean casado;
	private double salario;
	
	public Docente(){
		this.nombre = "";
		this.edad = 0;
		this.casado = false;
		this.salario = 0;
	}
	
	public Docente(String nombre, int edad, boolean casado, double salario) throws Exception{
		this.nombre = nombre;	
		this.casado = casado;
		this.salario = salario;
		
		if(edad < 18){
			throw new Exception("El docente debe ser mayor a 18");
		}
		else{
			this.edad = edad;
		}
			
	}
	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
