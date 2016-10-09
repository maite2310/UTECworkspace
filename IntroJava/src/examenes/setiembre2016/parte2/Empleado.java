package examenes.setiembre2016.parte2;

public class Empleado extends Persona {
	private double sueldo;
	private boolean exentoImpuesto;
	
	public Empleado(String nombre, String ci, boolean esMayor, double sueldo, boolean exentoImpuesto) throws Exception {
		
		super(nombre, ci, esMayor);
		
		if(!esMayor){
			throw new Exception("Los empleados deben ser mayor de edad");
		}
		this.sueldo = sueldo;
		this.exentoImpuesto = exentoImpuesto;
	}
	
	public double getSueldo(){
		if(!exentoImpuesto){
			return sueldo * 0.8;
		}
		return sueldo;
	}
	
	
}
