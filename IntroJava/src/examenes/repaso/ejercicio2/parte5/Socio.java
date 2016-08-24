package examenes.repaso.ejercicio2.parte5;

import java.util.Date;
import java.util.LinkedList;

public class Socio {
	protected String nombre;
	protected Date fecha;
	protected LinkedList<Actividad> actividades;
	
	public Socio() {
		this.nombre = "";
		this.fecha = null;
		this.actividades = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public LinkedList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(LinkedList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	public LinkedList<String> getProfesores() throws Exception{
		
		if(this.actividades == null){
			throw new Exception("El socio no tiene actividades");
		}
		
		LinkedList<String> profesores = new LinkedList<>();
		
		for(Actividad a : this.actividades){
			profesores.add(a.getProfesor());
		}
		
		return profesores;
	}
}
