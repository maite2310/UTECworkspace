package examenes.repaso.ejercicio2.parte5;

import java.util.Date;
import java.util.LinkedList;

public class SocioMensual extends Socio {
	private double monto;
	private Date fechaPagada;
	
	public SocioMensual(String nombre, Date fecha, LinkedList<Actividad> actividades,  double monto, Date fechaPagada) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.actividades = actividades;
		this.monto = monto;
		this.fechaPagada = fechaPagada;
		
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaPagada() {
		return fechaPagada;
	}

	public void setFechaPagada(Date fechaPagada) {
		this.fechaPagada = fechaPagada;
	}

//	public LinkedList<String> getProfesores() {
//		
//		System.out.println("entro a hijo mensual");
//		
//		return new LinkedList<>();
//
//	}
	
}
