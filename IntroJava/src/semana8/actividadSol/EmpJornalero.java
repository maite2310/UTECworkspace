package semana8.actividadSol;

import java.util.Date;

public class EmpJornalero extends Empleado {

	private double valorHora;
	private double horasTrabajadas;


	
	public EmpJornalero (String nombre, String apellido, Integer numBPS, Integer funcionario, 
			String direccion, String telefono){
		
		super(nombre, apellido,  numBPS, funcionario, direccion,telefono);
	}



	public double getValorHora() {
		return valorHora;
	}



	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}



	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}



	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public double getSueldo(){
		return valorHora*horasTrabajadas;
	}
}
