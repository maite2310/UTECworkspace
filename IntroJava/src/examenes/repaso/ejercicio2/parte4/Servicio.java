package examenes.repaso.ejercicio2.parte4;

import java.util.LinkedList;

public class Servicio {
	protected String descripcion;
	protected double costo;
	protected LinkedList<String> clientes;
		
	public Servicio(String descripcion, double costo, LinkedList<String> clientes) throws  CostoNegativoException {

		if(costo < 0){
			throw new CostoNegativoException();
		}
		
		this.descripcion = descripcion;
		this.costo = costo;
		this.clientes = clientes;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public LinkedList<String> getClientes() {
		return clientes;
	}
	public void setClientes(LinkedList<String> clientes) {
		this.clientes = clientes;
	}
	
	
}
