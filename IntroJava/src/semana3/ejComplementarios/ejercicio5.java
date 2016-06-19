package semana3.ejComplementarios;

public class ejercicio5 {

	public static void main(String[] args) {
	    int mes = 2;        
        int numDias = 0;

        switch (mes) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                numDias = 31;
                break;
            case 4: case 6:
            case 9: case 11:
                numDias = 30;
                break;
            case 2:
               numDias = 28;
                break;
            default:
                System.out.println("Mes invalido.");
                break;
        }
        System.out.println("Numero de Días = "
                           + numDias);

	}

}
