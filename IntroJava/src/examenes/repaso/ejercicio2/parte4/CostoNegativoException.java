package examenes.repaso.ejercicio2.parte4;

public class CostoNegativoException extends Exception {
	
	public CostoNegativoException(){
		super("El costo del servicio no puede ser negativo");
	}
}
