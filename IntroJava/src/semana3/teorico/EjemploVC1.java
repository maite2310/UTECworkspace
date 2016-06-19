package semana3.teorico;

public class EjemploVC1 {
	static public void main(String[] args){
		
		String operacion = args[0];
		int num1 = Integer.valueOf(args[1]);
		int num2 = Integer.valueOf(args[2]);
		int num3 = Integer.valueOf(args[3]);
				
		if(operacion.equals("+")){
			System.out.println(num1 + num2 + num3);
		}
		else if(operacion.equals("-")){
			System.out.println(num1 - num2 - num3);
		}
		else{
			System.out.println("Funcion no soportada");
		}
		
	}
}
