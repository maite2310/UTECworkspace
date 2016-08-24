package semana6.actividad;

public class Curso {
	public String codigo;
	public String nombre;
	private int duracionEnSemanas;
	private int cantidadAlumnosMatriculados;
	private int cantidadAlumnosQueRindenExamen;
	
	
	public Curso (){
		this.codigo = "";
		this.nombre = "";
		this.setDuracionEnSemanas(0);
		this.setCantidadAlumnosMatriculados(0);
		this.setCantidadAlumnosQueRindenExamen(0);
		
	}
	
	public Curso( String codigo, String nombre, int duracionEnSemanas, int cantidadAlumnosMatriculados,int cantidadAlumnosQueRindenExamen){
		this.codigo=codigo;
		this.nombre =nombre;
		this.setDuracionEnSemanas(duracionEnSemanas);
		this.setCantidadAlumnosMatriculados(cantidadAlumnosMatriculados);
		this.setCantidadAlumnosQueRindenExamen(cantidadAlumnosQueRindenExamen);
		
		
	}

	public int getDuracionEnSemanas() {
		return duracionEnSemanas;
	}

	public void setDuracionEnSemanas(int duracionEnSemanas) {
		this.duracionEnSemanas = duracionEnSemanas;
	}

	public int getCantidadAlumnosMatriculados() {
		return cantidadAlumnosMatriculados;
	}

	public void setCantidadAlumnosMatriculados(int cantidadAlumnosMatriculados) {
		this.cantidadAlumnosMatriculados = cantidadAlumnosMatriculados;
	}

	public int getCantidadAlumnosQueRindenExamen() {
		return cantidadAlumnosQueRindenExamen;
	}

	public void setCantidadAlumnosQueRindenExamen(int cantidadAlumnosQueRindenExamen) {
		this.cantidadAlumnosQueRindenExamen = cantidadAlumnosQueRindenExamen;
	}
	
	public int porcentaje (int cantidadAlumnosMatriculados,int cantidadAlumnosQueRindenExamen){
				
			int porcentaje = 0;
			porcentaje = cantidadAlumnosQueRindenExamen * 100 / cantidadAlumnosMatriculados;
			
			return porcentaje;
	}
	
	

}


