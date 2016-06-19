package semana5.ejComplementarios;

public class ejercicio5 {

	public static void main(String[] args) {
		
	}

	public static int[] multiplicarLista(int[] array){
		for(int i = 0; i < array.length; i++){
			array[i] = array[i] * i;  
		}
		
		return array;
	}
}
