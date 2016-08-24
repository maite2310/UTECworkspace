package prueba.ejercicio2;

public class Deporte extends JuegoOlimpico {

	public Deporte(double duracionJuego, boolean tieneEntretiempo, double duracionEntretiempo) {
		super(duracionJuego, tieneEntretiempo, duracionEntretiempo);	
	}
	
	public double getDuracionTotal(){
		double duracionTot = this.duracionJuego;
		if(this.tieneEntretiempo){
			duracionTot += this.duracionEntretiempo;
		}
		return duracionTot;
	}

}
