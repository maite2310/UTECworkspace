package semana1.ejemplo1;

import java.util.Date;

public class Curso {

	private int idCurso;
	private int idDocente;
	private int idMateria;
	private Date fechaInicio;
	private Date fechaFin;
	private String modalidad;

	public Curso(int idCurso, int idDocente, int idMateria, Date fechaInicio, Date fechaFin, String modalidad) {
		super();
		this.idCurso = idCurso;
		this.idDocente = idDocente;
		this.idMateria = idMateria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.modalidad = modalidad;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public int getIdMateria() {
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
