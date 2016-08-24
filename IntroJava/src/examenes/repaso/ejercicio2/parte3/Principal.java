package examenes.repaso.ejercicio2.parte3;

import java.util.LinkedList;

public class Principal {
	public static void main(String[] args){
		
		LinkedList<String> listaClientes = new LinkedList<>();
		listaClientes.add("UTEC");
		listaClientes.add("CUTI");
		listaClientes.add("ANI");
		
		System.out.println(listaClientes.get(3));
		
		ServicioTecnico servicioTec = new ServicioTecnico("Servicio de sala", 7000,listaClientes , true, true);
		
		for(String s : listaClientes){
			System.out.println(s);
		}
		
	}
}
