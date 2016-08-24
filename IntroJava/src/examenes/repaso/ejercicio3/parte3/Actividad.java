package examenes.repaso.ejercicio3.parte3;

public class Actividad {
	private String nombre;
	private int nota;
	private String descripcionNota;
	
	public Actividad(String nombre, int nota) throws NotaInvalidaException{
		this.nombre = nombre;
		this.nota = nota;
		setDescripcionNota(this.nota);
	}
	
	public Actividad(){
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) throws NotaInvalidaException {
		this.nota = nota;
		setDescripcionNota(nota);
	}

	public String getDescripcionNota() {
		return descripcionNota;
	}

	public void setDescripcionNota(String descripcionNota) {
		this.descripcionNota = descripcionNota;
	}

	private void setDescripcionNota(int nota) throws NotaInvalidaException{
		if(nota < 0 || nota > 5){
			throw new NotaInvalidaException("La nota ingresada debe ser entre 0 y 5");
		}
		
		if(nota >= 0 && nota < 3){
			this.descripcionNota = "Insuficiente"; 
		}
		else if(nota == 3){
			this.descripcionNota = "Suficiente";
		}
		else if(nota == 4){
			this.descripcionNota = "Muy bueno";
		}
		else{
			this.descripcionNota = "Excelente";
		}
		
	}
	
}
