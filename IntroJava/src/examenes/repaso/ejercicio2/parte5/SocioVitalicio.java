package examenes.repaso.ejercicio2.parte5;

import java.util.Date;
import java.util.LinkedList;

public class SocioVitalicio extends Socio {
	private double monto;
	private String matricula;
	
	public SocioVitalicio(String nombre, Date fecha, LinkedList<Actividad> actividades,  double monto, String matricula) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.actividades = actividades;
		this.monto = monto;
		this.matricula = matricula;

	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
//	
//	public LinkedList<String> getProfesores() {
//		
//		System.out.println("entro a hijo vitalicio");
//		
//		return new LinkedList<>();
//
//	}
	
}
