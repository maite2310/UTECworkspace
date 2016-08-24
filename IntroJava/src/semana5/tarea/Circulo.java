package semana5.tarea;

public class Circulo {
	
	private static final double PI = 3.1415;
	
	private double radio;

	public double getPerimetro(){		
		return 2 * radio * PI;
	}
	
	public double getArea(){
		return (radio * radio)* PI;
	}
		
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	
}
