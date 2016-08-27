package semana3.ejemplo1.entidades;

import java.util.Date;

public class Curso {

	private long idCurso;
	private long idDocente;
	private long idMateria;
	private Date fechaInicio;
	private Date fechaFin;
	private String modalidad;

	public Curso(long idCurso, long idDocente, long idMateria, Date fechaInicio, Date fechaFin, String modalidad) {
		
		this.idCurso = idCurso;
		this.idDocente = idDocente;
		this.idMateria = idMateria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.modalidad = modalidad;
	}

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public long getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public long getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

}
