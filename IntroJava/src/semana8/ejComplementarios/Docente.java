package semana8.ejComplementarios;

import java.util.LinkedList;

public class Docente {

	private int codPofesor;
	private String nombre;
	LinkedList <Curso> listCursosDicta;
	
	public Docente (int cod, String nom){
		this.codPofesor = cod;
		this.nombre = nom;
		this.listCursosDicta = new LinkedList <Curso> ();
	}

	public int getCodPofesor() {
		return codPofesor;
	}

	public void setCodPofesor(int codPofesor) {
		this.codPofesor = codPofesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedList<Curso> getListCursosDicta() {
		return listCursosDicta;
	}

	public void setListCursosDicta(LinkedList<Curso> listCursosDicta) {
		this.listCursosDicta = listCursosDicta;
	}
 
	public void agregarCurso (Curso c){
		this.listCursosDicta.add(c);
	}
}
