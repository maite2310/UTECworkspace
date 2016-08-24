package semana6.teorico;

import java.util.Calendar;
import java.util.Date;

public class Estudiante {

	public String codigo;
	public String nombre;
	public int cedulaIdentidad;
	public int añoDeNacimiento;
	
	public Estudiante(){
		this.codigo = "";
		this.nombre = "";
		this.cedulaIdentidad = cedulaIdentidad;
		this.añoDeNacimiento = añoDeNacimiento;
	}
	
	public Estudiante(String codigo, String nombre, int  cedulaIdentidad, int añoDeNacimiento ){
		this.codigo = codigo;
		this.nombre = nombre;
		this.cedulaIdentidad = cedulaIdentidad;
		this.añoDeNacimiento = añoDeNacimiento;
	}
	
	public int calcularEdad(int añoActual){
		return añoActual - this.añoDeNacimiento;
	}
	
	
	public int calcularEdad(){
		//Se utiliza Calendar para trabajar con fechas
		Calendar cal = Calendar.getInstance();
		//Obtengo el año actual a traves de Calendar
		int añoActual = cal.get(Calendar.YEAR);
		return añoActual - this.añoDeNacimiento;
	}
	
	public int calcularEdad(Date date){
		Calendar cal = Calendar.getInstance();
		//Setea en calendar que la fecha es la pasada por parámetro
		cal.setTime(date);
		//En año queda almacenado el año de la fecha pasado por parámetro
		int año = cal.get(Calendar.YEAR);
		
		return año - this.añoDeNacimiento;
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

	public int getAñoDeNacimiento() {
		return añoDeNacimiento;
	}

	public void setAñoDeNacimiento(int añoDeNacimiento) {
		this.añoDeNacimiento = añoDeNacimiento;
	}
	
	
}
