package examenes.repaso.ejercicio2.parte4;

import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		
		try {
			Servicio servicio = new Servicio("Servicio", 55, new LinkedList<String>( )  );
			
		} catch (CostoNegativoException e) {
		
		}
		

	}

}
