package semana3.ejComplementarios;

public class ejercicio4 {

	public static void main(String[] args) {
		 int mes = 8;
        String mesStr;
        switch (mes) {
            case 1:  mesStr = "Enero";
                     break;
            case 2:  mesStr = "Febrero";
                     break;
            case 3:  mesStr = "Marzo";
                     break;
            case 4:  mesStr = "Abril";
                     break;
            case 5:  mesStr = "Mayo";
                     break;
            case 6:  mesStr = "Junio";
                     break;
            case 7:  mesStr = "Julio";
                     break;
            case 8:  mesStr = "Agosto";
                     break;
            case 9:  mesStr = "Setiembre";
                     break;
            case 10: mesStr = "Octubre";
                     break;
            case 11: mesStr = "Noviembre";
                     break;
            case 12: mesStr = "Diciembre";
                     break;
            default: mesStr = "No existe";
                     break;
        }
        System.out.println(mesStr);
	    
	}

}
