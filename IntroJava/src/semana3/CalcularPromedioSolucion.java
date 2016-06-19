package semana3;

public class CalcularPromedioSolucion {

	public static void main(String[] args) {

		int num1 = Integer.valueOf(args[0]);
		int num2 = Integer.valueOf(args[1]);
		int num3 = Integer.valueOf(args[2]);
		
		// de aquí para abajo, colocar el código
		int promedio = (num1+num2+num3)/3;
		
		if (promedio<10){
			System.out.print(promedio);
		}
		else{
			int nuevoValor = promedio + num1 + num2 + num3;
			System.out.print(nuevoValor);
		}

	}

}
