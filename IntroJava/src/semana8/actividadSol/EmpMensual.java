package semana8.actividadSol;

import java.util.Date;

public class EmpMensual extends Empleado {

	private double salMensual;
	private String tipoRegimen;


	
	public EmpMensual (String nombre, String apellido,  Integer numBPS, Integer funcionario, 
			String direccion, String telefono){
		super(nombre, apellido,  numBPS, funcionario,direccion, telefono);
	}



	public double getSalMensual() {
		return salMensual;
	}



	public void setSalMensual(double salMensual) {
		this.salMensual = salMensual;
	}



	public String getTipoRegimen() {
		return tipoRegimen;
	}



	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}
	
	public double getSueldo(){
		return salMensual;
	}
	
}
