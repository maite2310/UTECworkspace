package semana6.teorico;

import java.util.Calendar;
import java.util.Date;

public class Estudiante {

	public String codigo;
	public String nombre;
	public int cedulaIdentidad;
	public int a�oDeNacimiento;
	
	public Estudiante(){
		this.codigo = "";
		this.nombre = "";
		this.cedulaIdentidad = cedulaIdentidad;
		this.a�oDeNacimiento = a�oDeNacimiento;
	}
	
	public Estudiante(String codigo, String nombre, int  cedulaIdentidad, int a�oDeNacimiento ){
		this.codigo = codigo;
		this.nombre = nombre;
		this.cedulaIdentidad = cedulaIdentidad;
		this.a�oDeNacimiento = a�oDeNacimiento;
	}
	
	public int calcularEdad(int a�oActual){
		return a�oActual - this.a�oDeNacimiento;
	}
	
	
	public int calcularEdad(){
		//Se utiliza Calendar para trabajar con fechas
		Calendar cal = Calendar.getInstance();
		//Obtengo el a�o actual a traves de Calendar
		int a�oActual = cal.get(Calendar.YEAR);
		return a�oActual - this.a�oDeNacimiento;
	}
	
	public int calcularEdad(Date date){
		Calendar cal = Calendar.getInstance();
		//Setea en calendar que la fecha es la pasada por par�metro
		cal.setTime(date);
		//En a�o queda almacenado el a�o de la fecha pasado por par�metro
		int a�o = cal.get(Calendar.YEAR);
		
		return a�o - this.a�oDeNacimiento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCedulaIdentidad() {
		return cedulaIdentidad;
	}

	public void setCedulaIdentidad(int cedulaIdentidad) {
		this.cedulaIdentidad = cedulaIdentidad;
	}

	public int getA�oDeNacimiento() {
		return a�oDeNacimiento;
	}

	public void setA�oDeNacimiento(int a�oDeNacimiento) {
		this.a�oDeNacimiento = a�oDeNacimiento;
	}
	
	
}
