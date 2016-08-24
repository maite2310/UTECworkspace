package semana6.ejComplementarios;

import java.util.Date;

public class Empleado {
	private String codigo;
	private String nombre;
	private String ci;
	private double valorHora;
	private int [] horasPorMes = new int [12];
	
	//Constructor por defecto
	public Empleado (){
		
	}
	
	public Empleado (String codigo, String nombre, String ci){
		this.codigo= codigo;
		this.nombre= nombre;
		this.ci=ci;
		
	}
	
	public void cargarHorasMes (int month, int horas){
		if (month < 13 && month >1){
			horasPorMes[month-1]= horas;
		}
	}
	
	public double getSueldoMes (int month){
		double ret =0;
		if (month < 13 && month >1){
			ret= horasPorMes[month-1]*valorHora;
		}
		return ret;
		
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
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public int[] getHorasPorMes() {
		return horasPorMes;
	}
	public void setHorasPorMes(int[] horasPorMes) {
		this.horasPorMes = horasPorMes;
	}
	
	


}
