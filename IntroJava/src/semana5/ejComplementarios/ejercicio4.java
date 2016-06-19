package semana5.ejComplementarios;

public class ejercicio4 {

	public static void main(String[] args) {
		
		//Una forma es definir variables y luego hacer la llamada a la función
		int param1 = 2;
		int param2 = 2;
		int param3 = 3;
		
		double promedio = calcularPromedio(param1, param2, param3);
		System.out.println(promedio);
		
		//Otra forma es llamar a la función directo con lo valores que queremos que
		//tomen los parametros
		System.out.println(calcularPromedio(2,2,3) );
	}

	public static double calcularPromedio(int num1, int num2, int num3){
		return (num1 + num2 + num3)/3;
	}
}
