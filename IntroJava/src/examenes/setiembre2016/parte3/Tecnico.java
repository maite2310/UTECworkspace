package examenes.setiembre2016.parte3;

import java.util.LinkedList;

public class Tecnico {
	public String nombre;
	public String cedula;
	public LinkedList<Mantenimiento> mantenimientos;
	
	public Tecnico() {		
		this.nombre = "";
		this.cedula = "";
		this.mantenimientos = new LinkedList<Mantenimiento>();
	}
	
	public double getHorasMantenimientos(){
		double resultado = 0; 
		for(Mantenimiento m : this.mantenimientos){
			resultado += m.getHoras();
		}
		
		return resultado;
	}
	
	
}
