package prueba.ejercicio2;

public class JuegoOlimpico  {

	protected double duracionJuego;
	protected boolean tieneEntretiempo;
	protected double duracionEntretiempo;
		
	public JuegoOlimpico(double duracionJuego, boolean tieneEntretiempo, double duracionEntretiempo) {
	
		this.duracionJuego = duracionJuego;
		this.tieneEntretiempo = tieneEntretiempo;
		this.duracionEntretiempo = duracionEntretiempo;
	}
	
	public double getDuracionJuego() {
		return duracionJuego;
	}
	public void setDuracionJuego(double duracionJuego) {
		this.duracionJuego = duracionJuego;
	}
	public boolean isTieneEntretiempo() {
		return tieneEntretiempo;
	}
	public void setTieneEntretiempo(boolean tieneEntretiempo) {
		this.tieneEntretiempo = tieneEntretiempo;
	}
	public double getDuracionEntretiempo() {
		return duracionEntretiempo;
	}
	public void setDuracionEntretiempo(double duracionEntretiempo) {
		this.duracionEntretiempo = duracionEntretiempo;
	}
		
 }
