package examenes.setiembre2016.parte3;

public class Mantenimiento {
	private String avion;
	private String detalle;
	private double horas;
	
	public Mantenimiento(){
		this.avion = "";
		this.detalle = "";
		this.horas = 0;
	}
	
	public Mantenimiento(String avion, String detalle, double horas) {
		this.avion = avion;
		this.detalle = detalle;
		this.horas = horas;
	}

	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
		this.avion = avion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}
			
}
