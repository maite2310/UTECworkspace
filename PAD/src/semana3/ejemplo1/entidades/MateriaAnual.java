package semana3.ejemplo1.entidades;

public class MateriaAnual extends Materia {
	
	private boolean dictadaEnAnioPar;
	
	public MateriaAnual(long idMateria, String nombre, Carrera carrera, boolean dictadaEnAnioPar) {
		super(idMateria, nombre, carrera);
		this.dictadaEnAnioPar = dictadaEnAnioPar;
		
	}

	public boolean isDictadaEnAnioPar() {
		return dictadaEnAnioPar;
	}

	public void setDictadaEnAnioPar(boolean dictadaEnAnioPar) {
		this.dictadaEnAnioPar = dictadaEnAnioPar;
	}
	
	
}
