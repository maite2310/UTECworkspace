package examenes.repaso.ejercicio2.parte3;

import java.util.LinkedList;

public class ServicioTecnico extends Servicio {
	private boolean requiereMicrfono;
	private boolean requiereProyector;
			
	public ServicioTecnico(String descripcion, double costo, LinkedList<String> clientes, boolean requiereMicrfono, boolean requiereProyector ) {
		super(descripcion, costo, clientes);
		this.requiereMicrfono = requiereMicrfono;
		this.requiereProyector = requiereProyector;
	}
	public boolean isRequiereMicrfono() {
		return requiereMicrfono;
	}
	public void setRequiereMicrfono(boolean requiereMicrfono) {
		this.requiereMicrfono = requiereMicrfono;
	}
	public boolean isRequiereProyector() {
		return requiereProyector;
	}
	public void setRequiereProyector(boolean requiereProyector) {
		this.requiereProyector = requiereProyector;
	}
	
	public double getCostoTotal(){
		double costoTotal = this.costo;
		
		if(this.requiereMicrfono){
			costoTotal += 760;
		}
		
		if(this.requiereProyector){
			costoTotal += 1500;
		}
		
		return costoTotal;
	}
	
	
}
