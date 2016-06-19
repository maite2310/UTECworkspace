package semana3.ejComplementarios;

public class ejercicio2 {
	public static void main(String[] args) {
		int nota = Integer.valueOf(args[0]);
		
		if(nota < 25){
			System.out.println("Recursa");
		}
		else if(nota <= 59){
			System.out.println("Examen");
		}
		else{
			System.out.println("Salvado");
		}
	}
}
