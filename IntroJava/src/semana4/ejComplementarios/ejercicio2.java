package semana4.ejComplementarios;

public class ejercicio2 {

	public static void main(String[] args) {
		int cantMul = 0;
		for(int i=0 ; i <= 20 ; i++)
		{
			boolean esMul2 = i % 2 == 0;
			if(esMul2){
				cantMul++;
			}
			
		}
		System.out.println("Cantidad Multiplos de 2:" + cantMul);

	}

}
