package semana5.tarea;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] mi_array_enteros = {5,10,15,6,8,44};
		
		String[] mi_array_string = {"azul","amarillo","rosado","verde","naranja"};
		
		int resultado1 = sumaEnteros(mi_array_enteros);
		
		System.out.println(resultado1);
		
		imprimirColores(mi_array_string);
							
	}
		
	public static int sumaEnteros(int[] arrayEnteros) {
		// ACÁ COMIENZA LA FUNCIÓN PARA EL ARRAY DE ENTEROS
		int sumar = 0;
		
		for(int i = 0; i < arrayEnteros.length; i++) {
			
			if(arrayEnteros[i]>11){
				
				System.out.println(arrayEnteros[i]);
				
				for(int j = 0; j < arrayEnteros.length; j++) {
					
					sumar = sumar + arrayEnteros[j];	
				}
				break;
			}
		}
		return sumar;
		// ACÁ TERMINA LA FUNCIÓN PARA EL ARRAY DE ENTEROS
	}
	
	public static void imprimirColores(String[] arrayString) {
		// ACÁ COMIENZA EL MÉTODO PARA EL ARRAY DE STRINGS
		
		for(int k = 0; k < arrayString.length; k++) {
			
			String str1 = arrayString[k];
			
			if(str1.startsWith("v")){
				
				System.out.println(str1);
			} 
				else {
					
					if(str1.contains("l")) {
					
						System.out.println(str1);
					}
				}
		}
		// ACÁ FINALIZA EL MÉTODO PARA EL ARRAY DE STRINGS
	}
	
}