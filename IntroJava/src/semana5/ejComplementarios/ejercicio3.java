package semana5.ejComplementarios;

public class ejercicio3 {

	public static void main(String[] args) {
		String [] listaStr = {"azul", "amarillo", "rojo", "negro"};
		String [] listaNueva = new String[listaStr.length + 1];
		boolean seEncuentra = false;
		
		for(int i = 0; i < listaStr.length; i++){
			listaNueva[i] = listaStr[i];  
		}
		
		listaNueva[listaStr.length] = "FIN";
	}

}
