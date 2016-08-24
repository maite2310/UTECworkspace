package semana5.teorico;

public class Programa {
	public static void main(String[] args){
		int a = 5;
		int b = 6;
		int suma = sumar(a, b);
		
		System.out.print(suma);
		
		
		boolean esta = estaPresente(6, new int[] {1} );
		
		boolean esta2 = estaPresente(6, new int[] {3, 5, 6} );
		
		int[] array3 = new int[3];
		boolean esta3 =  estaPresente(0, array3);
		
		int num4 = 4;
		int[] array4 = new int[]{5,10, 35, 67,88};
		boolean esta4 =  estaPresente(num4, array4);
	
		System.out.println(esta);
		System.out.println(esta2);
		System.out.println(esta3);
		System.out.println(esta4);
		
		
		String var1 = concatenar("como ", "estas");
		String var2 = concatenar(var1, "?");
		//String var3 = concatenar(3, "ee");
		
		
	}
	
	public static boolean estaPresente(int numero, int[] arregloEnteros){
		boolean esta = false;
		for(int i = 0; i< arregloEnteros.length; i++){
			if(arregloEnteros[i] == numero){
				esta = true;
			}
		}
		return esta;
	}
	
	public static int sumar(int numero1, int numero2){
		return numero1 + numero2;
	}
	
	public static String concatenar(String u, String u2){
		return "";
	}
	
}
