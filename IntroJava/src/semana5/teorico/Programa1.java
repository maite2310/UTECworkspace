package semana5.teorico;

public class Programa1 {
	public static void main(String args[]){
		String[] textos = {"aca", "tenemos", "varios", "textos", "ancadenados"};
		
		String[] otrosTextos = new String[4];
		
		otrosTextos[0] = "hola";
		otrosTextos[1] = "chau";
		otrosTextos[2] = "bienvenidos";
		otrosTextos[3] = "saludos terricolas";
		
		String[] salida = new String[3];
		
		for(int i=0; i<3; i++){
			salida[i] = textos[i]+ " " + otrosTextos[i];
		}
		
		for(int n = 0; n<salida.length; n++){
			System.out.println(salida[n]);
		}
		
	}
}

