package semana5.tarea;

public class PrincipalSolucion {

	public static void main(String[] args) {
		int[] mi_array_enteros = {5, 10, 15, 6, 8, 44};
		String[] mi_array_string = {"azul", "amarillo", "rosado", "verde", "naranja"};
		
		int suma = sumaEnteros(mi_array_enteros);
		System.out.println(suma);
		imprimirColores(mi_array_string);
	}
	
	public static int sumaEnteros(int[] array){
		int suma = 0;
		boolean yaImprimi = false;
		
		
		for(int i = 0; i< array.length; i++){
			suma = suma + array[i];
			if(array[i] > 11 && !yaImprimi ){
				System.out.println(array[i]);
				yaImprimi = true;				
			}
		}
		
		return suma;
	}
	
	public static void imprimirColores(String[] array){
		for(int i = 0; i< array.length; i++){
			if(array[i].startsWith("v") || array[i].contains("l")){
				System.out.println(array[i]);
			}
		}
	}
}
