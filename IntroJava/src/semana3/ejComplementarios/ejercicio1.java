package semana3.ejComplementarios;

public class ejercicio1 {

	public static void main(String[] args) {
		int varNum = 56;
		int varNum2 = 64;
		int varNum3 = 70;
		boolean varBool = varNum > varNum2 && varNum2 >= varNum3 || varNum+23 != varNum2;
		boolean varBool2 = varBool && true && false;
		boolean varBool3 = varBool2 == varBool;
		//>
		if(varBool) {
			System.out.println("varBool es verdadera");			
		}
		else{
			System.out.println("varBool es falsa");
		}
		
		if(varNum < 10){
			System.out.println("varNum es menor a 10");
		}
		else if(varNum < 40){
			System.out.println("varNum es mayor a 10 y menor a 40");
		}
		else{
			System.out.println("varNum es mayor a 40");
		}
		
		if(varNum2 != 2 && !varBool2){
			varNum2 = 80;
			if(varBool3){
				System.out.println("en if anidado varBool3 es verdadera");
			}
			else{
				System.out.println("en if anidado varBool3 es falsa");
			}
		}
		
	}

}
