package semana4.ejComplementarios;

public class ejercicio3 {

	public static void main(String[] args) {
		int cantMul = 0;
		for(int i=100 ; i > 9 ; i--)
		{
			boolean esMul5 = i % 5 == 0;
			if(esMul5){
				cantMul++;
			}
			
		}
		System.out.println("Cantidad Multiplos de 5:" + cantMul);

	}

}
