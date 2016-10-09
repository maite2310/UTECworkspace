package semana3.tarea.sol.entidades;

import java.util.LinkedList;

public class Cita {
	private long idCita;
	private long timestamp;
	private int duracion;
	private LinkedList<Recurso> recursos;
	
	public Cita(long idCita, long timestamp, int duracion, LinkedList<Recurso> recursos) {
		this.idCita = idCita;
		this.timestamp = timestamp;
		this.duracion = duracion;
		this.recursos = recursos;
	}

	public long getIdCita() {
		return idCita;
	}

	public void setIdCita(long idCita) {
		this.idCita = idCita;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LinkedList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(LinkedList<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	
}
