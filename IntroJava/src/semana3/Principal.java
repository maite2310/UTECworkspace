package semana3;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] mi_array_enteros = {5, 10, 15, 6, 8, 44};
		String[] mi_array_string = {"azul", "amarillo", "rosado", "verde", "naranja"};
		
		boolean esta = sumaEnteros (mi_array_enteros);
		imprimirColores (mi_array_string);
		
	}
	
	public static boolean sumaEnteros (int[] array) {
		
		boolean esta = false;
		
		for (int i = 0 ; i<array.length ;i++) {
			
			
			if (array[i] > 11) {
				System.out.println(array[i]);
				System.out.println(array[0] + array[1] + array[2] + array[3] + array[4] + array[5]);
				esta = true;
				
				break;
			}
		
	};
		return esta;
	}
	
	public static void imprimirColores (String[] array) {
		
		boolean presente = false;
		
		for (int i = 0 ; i<array.length ; i++) {
		
			if (array[i].contains("l") || array[i].startsWith("v")) {
				System.out.println(array[i]);
			}
				
		
		
		
		
		
		
	}
}
}