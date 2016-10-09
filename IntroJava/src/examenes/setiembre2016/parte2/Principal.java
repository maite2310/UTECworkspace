package examenes.setiembre2016.parte2;

public class Principal {
	
	public static void main(String[] args){
		try{
			Empleado e1 = new Empleado("Jose Perez", "53565422", false, 20333,false);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			Empleado e2 = new Empleado("Maria Rodriguez", "34565431",true, 50765,false);
			System.out.println(e2.getSueldo());
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
