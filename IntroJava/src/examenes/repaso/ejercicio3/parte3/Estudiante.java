package examenes.repaso.ejercicio3.parte3;

import java.util.LinkedList;

public class Estudiante {
	private String nombre;
	private int edad;
	private LinkedList<Actividad> actividades;
	
	
	
	public Estudiante() {
		this.nombre = "";
		this.actividades = new LinkedList<>();
		this.edad = 0;
	}
	
	public Estudiante(String nombre, int edad, LinkedList<Actividad> actividades) {
	
		this.nombre = nombre;
		this.edad = edad;
		this.actividades = actividades;
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
	public LinkedList<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(LinkedList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	public double getPromedio() {
		double promedio =0;
		for(Actividad a : this.actividades){
			promedio += a.getNota();
		}
		
		promedio = promedio/this.actividades.size();
		return promedio;
		
	}
}
