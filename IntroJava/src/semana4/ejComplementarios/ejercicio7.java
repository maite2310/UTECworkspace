package semana4.ejComplementarios;

public class ejercicio7 {

	public static void main(String[] args) {
		int var1 = 3;
		int var2 = 4;
		int resultado = 0;
		
		if(var1 <= var2){
			resultado = var1 + var2;
		}
		
		while(var2 != var1){
			resultado++;
			var2--;
		}
	}

}
