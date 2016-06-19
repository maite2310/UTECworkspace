package semana5.ejComplementarios;

public class ejercicio1 {

	public static void main(String[] args) {
		int[] lista1 = {1, 4, 7, 8};
		boolean[] lista2 = {true, false, false};
		int var1 = 0;
		String var2 = "comienzo";
		
		if(lista2[0]){
			var1 = lista1[0];
			var2 = "entre en primer SI";
		}
		else{
			var2 = "entre en primer SINO";
		}
		
		if(!lista2[1]){
			var2 = var2 +"/"+"entre en segundo SI";
		}
		else{
			var1 = lista1[3];
			var2 = var2 + "/"+"entre en segundo SINO";
		}
		
		if(lista2[2]){
			var2 = var2 + "/" + "entre en tercer SI";
		}
		else{
			var1 = var1 + lista1[2];
			var2 = var2 + "/"+ "entre en tercer SINO";
		}		
	}

}
