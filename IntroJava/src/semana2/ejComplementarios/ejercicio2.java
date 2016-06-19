package semana2.ejComplementarios;

public class ejercicio2 {
	

	public static void main(String[] args) {
		boolean varBool;
		boolean varBool2;
		boolean varBool3;
		boolean varBool4;
		
		varBool = false;
		varBool2 = varBool || varBool == true && !varBool;
		varBool3 = !varBool2 && varBool != false;
		varBool4 = !varBool && !varBool2 || !varBool;
		
		System.out.println(varBool);
		System.out.println(varBool2);
		System.out.println(varBool3);
		System.out.println(varBool4);
		
	}
	
	
}
